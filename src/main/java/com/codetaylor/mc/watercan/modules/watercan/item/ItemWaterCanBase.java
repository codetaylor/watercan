package com.codetaylor.mc.watercan.modules.watercan.item;

import com.codetaylor.mc.watercan.ModWatercanConfig;
import com.codetaylor.mc.watercan.modules.watercan.PacketService;
import com.codetaylor.mc.watercan.modules.watercan.client.IWaterCanParticleSpawner;
import com.codetaylor.mc.watercan.modules.watercan.client.WaterCanParticleSpawner;
import com.codetaylor.mc.watercan.modules.watercan.network.SCPacketDispenseWatercan;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IDispenseItemBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public abstract class ItemWaterCanBase
    extends Item {

  public static final int MILLI_BUCKETS_PER_USE = 10;

  private static final int BLOCK_FARMLAND_MAX_MOISTURE = 7;
  private static final float FLOWER_CHANCE_SCALAR = 0.0005f;
  private static final Random RANDOM = new Random();

  private final IWaterCanParticleSpawner particleSpawner;

  public ItemWaterCanBase(Properties properties, String name) {

    super(properties.group(ItemGroup.MISC));
    this.setRegistryName(name);

    if (ModWatercanConfig.CLIENT.spawnWaterParticles.get()) {
      this.particleSpawner = WaterCanParticleSpawner.INSTANCE;

    } else {
      this.particleSpawner = IWaterCanParticleSpawner.NO_OP;
    }
  }

  protected abstract boolean canExtinguishFire();

  protected abstract boolean canMoisturizeFarmland();

  protected abstract boolean canSpawnFlowers();

  protected abstract boolean canSpreadGrass();

  protected abstract boolean canSpreadMycelium();

  protected abstract boolean canGrowCrops();

  protected abstract boolean canGrowSaplings();

  protected abstract int getDelayModifier();

  protected abstract boolean consumeWaterSource();

  protected abstract int getRange();

  protected abstract int getFlowerChance();

  protected abstract boolean isDispensable();

  @OnlyIn(Dist.CLIENT)
  @Override
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

    super.addInformation(stack, worldIn, tooltip, flagIn);

    tooltip.add(new TranslationTextComponent(
        "tooltip.watercan.capacity",
        stack.getMaxDamage() - stack.getDamage(),
        stack.getMaxDamage()
    ));
  }

  @Override
  public boolean isEnchantable(ItemStack stack) {

    return false;
  }

  @Nonnull
  @Override
  public ActionResultType onItemUse(ItemUseContext context) {

    PlayerEntity player = context.getPlayer();
    Hand hand = context.getHand();
    BlockPos pos = context.getPos();
    World world = context.getWorld();

    if (player != null) {
      ItemStack itemStack = player.getHeldItem(hand);
      this.activate(itemStack, world, player, pos);
    }
    return ActionResultType.SUCCESS;
  }

  public void activate(ItemStack itemStack, World world, @Nullable PlayerEntity player, BlockPos pos) {

    if (this.getMaxDamage() > 0) {

      // water check
      ActionResultType waterCheckResult = null;

      // player will be null when the watercan is activated from a dispenser
      // we only want to do a want to do a water check when the can is being
      // activated by a player (or fake player)
      if (player != null) {
        waterCheckResult = this.checkRefill(itemStack, world, player).getType();
      }

      if (waterCheckResult != null) {

        if (waterCheckResult == ActionResultType.SUCCESS) {
          return; // refill success

        } else if (waterCheckResult == ActionResultType.FAIL) {
          return; // trying to get water, but can is full
        }
      }

      // capacity check
      if (this.getMaxDamage() - itemStack.getDamage() < MILLI_BUCKETS_PER_USE) {
        return; // nope
      }

      int itemDamage = itemStack.getDamage() + MILLI_BUCKETS_PER_USE;
      itemDamage = Math.min(itemDamage, this.getMaxDamage());
      itemStack.setDamage(itemDamage);
    }

    this.waterBlockRange(
        world,
        pos.getX() + 0.5,
        pos.getY() + 0.5,
        pos.getZ() + 0.5
    );
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {

    return this.checkRefill(player.getHeldItem(hand), world, player);
  }

  @Nonnull
  private ActionResult<ItemStack> checkRefill(
      @Nonnull ItemStack itemStack,
      World world,
      PlayerEntity player
  ) {

    RayTraceResult rayTraceResult = Item.rayTrace(world, player, RayTraceContext.FluidMode.SOURCE_ONLY);

    // rayTraceResult can be null
    //noinspection ConstantConditions
    if (rayTraceResult != null
        && rayTraceResult.getType() == RayTraceResult.Type.BLOCK) {
      BlockPos blockPos = ((BlockRayTraceResult) rayTraceResult).getPos();
      BlockState blockState = world.getBlockState(blockPos);

      if (blockState.getBlock().getMaterial(blockState) == Material.WATER) {

        if (itemStack.getDamage() == 0) {
          return ActionResult.newResult(ActionResultType.FAIL, itemStack);
        }

        if (!world.isRemote) {
          int damage = itemStack.getDamage() - 1000;
          damage = Math.max(0, damage);
          itemStack.setDamage(damage);
          world.playSound(
              null,
              player.posX,
              player.posY,
              player.posZ,
              SoundEvents.ITEM_BUCKET_FILL,
              SoundCategory.PLAYERS,
              1,
              1
          );

          if (this.consumeWaterSource()) {
            world.removeBlock(blockPos, false);
          }
        }
        return ActionResult.newResult(ActionResultType.SUCCESS, itemStack);
      }
    }

    return ActionResult.newResult(ActionResultType.PASS, itemStack);
  }

  private void waterBlockRange(
      World world,
      double x,
      double y,
      double z
  ) {

    if (world.isRemote) {
      // particles on the client
      this.spawnParticles(world, x, y, z);

    } else {
      // effect on the server
      int range = this.getRange();
      int flowerChance = this.getFlowerChance();
      this._waterBlockRange(world, x, y, z, range, flowerChance * FLOWER_CHANCE_SCALAR);
    }
  }

  public void spawnParticles(World world, double x, double y, double z) {

    this.particleSpawner.spawnParticles(world, x, y, z, this.getRange());
  }

  private void _waterBlockRange(
      World world,
      double posX,
      double posY,
      double posZ,
      int range,
      float flowerChance
  ) {

    BlockPos pos;

    int blockX = (int) Math.floor(posX);
    int blockY = (int) Math.floor(posY);
    int blockZ = (int) Math.floor(posZ);

    for (int x = blockX - range; x <= blockX + range; x++) {

      for (int y = blockY - range; y <= blockY + range; y++) {

        for (int z = blockZ - range; z <= blockZ + range; z++) {
          pos = new BlockPos(x, y, z);
          BlockState blockState = world.getBlockState(pos);
          Block block = blockState.getBlock();

          // skip air blocks
          if (!world.isAirBlock(pos)) {
            this.waterBlock(world, flowerChance, pos, blockState, block);
          }
        }
      }
    }
  }

  private void waterBlock(
      World world,
      float flowerChance,
      BlockPos pos,
      BlockState blockState,
      Block block
  ) {

    int blockUpdateDelay;

    // put out fire
    if (this.canExtinguishFire()
        && block == Blocks.FIRE) {
      world.removeBlock(pos, false);
    }

    // moisturize farmland
    if (this.canMoisturizeFarmland()
        && block == Blocks.FARMLAND
        && blockState.get(FarmlandBlock.MOISTURE) < BLOCK_FARMLAND_MAX_MOISTURE) {
      BlockState newBlockState = block.getDefaultState()
          .with(FarmlandBlock.MOISTURE, BLOCK_FARMLAND_MAX_MOISTURE);
      world.setBlockState(pos, newBlockState, 3);
    }

    if (this.canSpawnFlowers()
        && block == Blocks.GRASS_BLOCK) {
      // chance to spawn flowers on a grass block with air above it
      BlockPos up = pos.up();

      if (world.isAirBlock(up)
          && Math.random() < flowerChance) {

        List<ConfiguredFeature<?>> list = world.getBiome(up).getFlowers();

        if (!list.isEmpty()) {
          ConfiguredFeature<?> configuredFeature = list.get(0);
          DecoratedFeatureConfig config = (DecoratedFeatureConfig) configuredFeature.config;
          FlowersFeature feature = (FlowersFeature) config.feature.feature;
          BlockState randomFlower = feature.getRandomFlower(RANDOM, up);

          if (randomFlower.isValidPosition(world, up)) {
            world.setBlockState(up, randomFlower, 3);
          }
        }
      }
    }

    blockUpdateDelay = this.getBlockUpdateDelay(blockState, block);

    if (blockUpdateDelay > 0 && block.ticksRandomly(blockState)) {
      world.getPendingBlockTicks().scheduleTick(pos, block, RANDOM.nextInt(blockUpdateDelay));
    }
  }

  private int getBlockUpdateDelay(
      BlockState blockState,
      Block block
  ) {

    int delay = -1;
    int delayModifier = this.getDelayModifier();

    if (this.canSpreadGrass()
        && block == Blocks.GRASS_BLOCK) {
      delay = delayModifier;

    } else if (this.canSpreadMycelium()
        && block == Blocks.MYCELIUM) {
      delay = delayModifier;

    } else if (this.canGrowCrops()
        && block == Blocks.WHEAT) {
      delay = (int) (2.0f * delayModifier);

    } else if (this.canGrowSaplings()
        && block instanceof SaplingBlock) {
      delay = (int) (2.5f + delayModifier);

    } else if (this.canGrowCrops()
        && block instanceof IPlantable
        || block instanceof IGrowable) {
      delay = (int) (2.0f + delayModifier);

    } else if (this.canSpreadGrass()
        && block.getMaterial(blockState) == Material.ORGANIC) {
      delay = delayModifier;
    }
    return delay;
  }

  @Override
  public int getRGBDurabilityForDisplay(ItemStack stack) {

    return 0x4466FF;
  }

  public static class DispenserBehavior
      implements IDispenseItemBehavior {

    @Nonnull
    @Override
    public ItemStack dispense(@Nonnull IBlockSource source, @Nonnull ItemStack stack) {

      Item item = stack.getItem();

      if (item instanceof ItemWaterCanBase
          && ((ItemWaterCanBase) item).isDispensable()) {

        World world = source.getWorld();
        BlockPos pos = source.getBlockPos();
        BlockState blockState = world.getBlockState(pos);

        if (!world.isRemote
            && blockState.getBlock() instanceof DispenserBlock) {

          Direction facing = blockState.get(DispenserBlock.FACING);
          BlockPos offset = pos.offset(facing, ((ItemWaterCanBase) item).getRange() + 1);
          ItemStack copy = stack.copy();
          ((ItemWaterCanBase) item).activate(stack, world, null, offset);

          // client packet
          SCPacketDispenseWatercan packet = new SCPacketDispenseWatercan(copy, offset);
          PacketService.sendToAll(packet);
        }
      }

      return stack;
    }
  }
}
