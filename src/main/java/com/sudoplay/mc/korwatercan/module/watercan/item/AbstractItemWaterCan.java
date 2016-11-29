package com.sudoplay.mc.korwatercan.module.watercan.item;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.item.KorBasicItem;
import com.sudoplay.mc.kor.spi.util.RNGUtils;
import com.sudoplay.mc.korwatercan.module.watercan.ModuleWaterCan;
import com.sudoplay.mc.korwatercan.shared.WaterCanType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nonnull;

/**
 * Created by sk3lls on 11/27/2016.
 */
/* package */ abstract class AbstractItemWaterCan extends
    KorBasicItem {

  private static final int BLOCK_FARMLAND_MAX_MOISTURE = 7;

  private final IWaterCanParticleSpawner particleSpawner;
  private final WaterCanRenderer waterCanRenderer;
  private int range;
  private float flowerChance;
  private int milliBucketsPerUse;
  private int delayModifier;

  /* package */ AbstractItemWaterCan(
      String modId,
      String name,
      WaterCanType type,
      TextConfigData textConfigData
  ) {
    super(modId, name);

    int maxDamage = textConfigData
        .getCategory(ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_CAPACITY)
        .getInteger(type.getName());
    maxDamage = Math.max(0, maxDamage);
    setMaxDamage(maxDamage);

    this.range = textConfigData
        .getCategory(ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_RANGE)
        .getInteger(type.getName());
    this.range = Math.max(0, Math.min(32, this.range));

    int fc = textConfigData
        .getCategory(ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_FLOWER)
        .getInteger(type.getName());
    fc = Math.max(0, Math.min(100, fc));

    this.flowerChance = 0.0005f * fc;

    if (textConfigData
        .getCategory(ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_PARTICLES)
        .getBoolean("spawnWaterParticles")) {
      this.particleSpawner = WaterCanParticleSpawner.INSTANCE;

    } else {
      this.particleSpawner = IWaterCanParticleSpawner.NO_OP;
    }

    this.waterCanRenderer = new WaterCanRenderer(this);
    this.milliBucketsPerUse = 10;

    this.delayModifier = textConfigData
        .getCategory(ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_DELAY_MODIFIER)
        .getInteger(type.getName());
    this.delayModifier = Math.min(40, Math.max(1, this.delayModifier));
  }

  @Nonnull
  @Override
  public EnumActionResult onItemUse(
      ItemStack stack,
      EntityPlayer player,
      World world,
      BlockPos pos,
      EnumHand hand,
      EnumFacing facing,
      float hitX,
      float hitY,
      float hitZ
  ) {
    int itemDamage;

    if (this.getMaxDamage() > 0) {

      // water check
      EnumActionResult waterCheckResult = this.checkRefill(stack, world, player).getType();

      if (waterCheckResult == EnumActionResult.SUCCESS) {
        return EnumActionResult.SUCCESS; // refill success

      } else if (waterCheckResult == EnumActionResult.FAIL) {
        return EnumActionResult.SUCCESS; // trying to get water, but can is full
      }

      // capacity check
      if (this.getMaxDamage() - stack.getItemDamage() < this.milliBucketsPerUse) {
        return EnumActionResult.SUCCESS; // nope
      }

      itemDamage = stack.getItemDamage() + this.milliBucketsPerUse;
      itemDamage = Math.min(itemDamage, this.getMaxDamage());
      stack.setItemDamage(itemDamage);
    }

    this.waterBlockRange(
        world,
        pos.getX() + 0.5,
        pos.getY() + 0.5,
        pos.getZ() + 0.5
    );

    return EnumActionResult.SUCCESS;
  }

  @Nonnull
  @Override
  public ActionResult<ItemStack> onItemRightClick(
      @Nonnull ItemStack itemStack,
      World world,
      EntityPlayer player,
      EnumHand hand
  ) {
    return checkRefill(itemStack, world, player);
  }

  @Nonnull
  private ActionResult<ItemStack> checkRefill(
      @Nonnull ItemStack itemStack,
      World world,
      EntityPlayer player
  ) {
    RayTraceResult rayTraceResult = this.rayTrace(world, player, true);

    // rayTraceResult can be null
    //noinspection ConstantConditions
    if (rayTraceResult != null
        && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
      BlockPos blockPos = rayTraceResult.getBlockPos();
      IBlockState blockState = world.getBlockState(blockPos);

      if (blockState.getBlock().getMaterial(blockState) == Material.WATER) {

        if (itemStack.getItemDamage() == 0) {
          return ActionResult.newResult(EnumActionResult.FAIL, itemStack);
        }

        int damage = itemStack.getItemDamage() - 1000;
        damage = Math.max(0, damage);
        itemStack.setItemDamage(damage);
        player.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0f, 1.0f);
        return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
      }
    }

    return ActionResult.newResult(EnumActionResult.PASS, itemStack);
  }

  private void waterBlockRange(
      World world,
      double x,
      double y,
      double z
  ) {
    if (world.isRemote) {
      // particles on the client
      this.particleSpawner.spawnParticles(world, x, y, z, this.range);

    } else {
      // effect on the server
      _waterBlockRange(world, x, y, z, this.range, this.flowerChance);
    }
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
          IBlockState blockState = world.getBlockState(pos);
          Block block = blockState.getBlock();

          // skip air blocks
          if (!world.isAirBlock(pos)) {
            waterBlock(world, flowerChance, pos, blockState, block);
          }
        }
      }
    }
  }

  private void waterBlock(
      World world,
      float flowerChance,
      BlockPos pos,
      IBlockState blockState,
      Block block
  ) {
    int blockUpdateDelay;

    // put out fire
    if (block == Blocks.FIRE) {
      world.setBlockToAir(pos);
    }

    // moisturize farmland
    if (block == Blocks.FARMLAND
        && blockState.getValue(BlockFarmland.MOISTURE) < BLOCK_FARMLAND_MAX_MOISTURE) {
      world.setBlockState(pos, block.getDefaultState().withProperty(BlockFarmland.MOISTURE, BLOCK_FARMLAND_MAX_MOISTURE), 3);
    }

    if (block == Blocks.GRASS) {
      // chance to spawn flowers on a grass block with air above it
      BlockPos up = pos.up();

      if (world.isAirBlock(up)
          && RNGUtils.RANDOM.nextFloat() < flowerChance) {
        world.getBiomeGenForCoords(pos).plantFlower(world, RNGUtils.RANDOM, up);
      }
    }

    blockUpdateDelay = getBlockUpdateDelay(blockState, block);

    if (blockUpdateDelay > 0 && block.getTickRandomly()) {
      world.scheduleBlockUpdate(pos, block, RNGUtils.RANDOM.nextInt(blockUpdateDelay), 0);
    }
  }

  private int getBlockUpdateDelay(IBlockState blockState, Block block) {
    int delay = -1;
    this.delayModifier = 1;

    if (block == Blocks.GRASS) {
      delay = this.delayModifier;

    } else if (block == Blocks.MYCELIUM) {
      delay = this.delayModifier;

    } else if (block == Blocks.WHEAT) {
      delay = (int) (2.0f * this.delayModifier);

    } else if (block instanceof BlockSapling) {
      delay = (int) (2.5f + this.delayModifier);

    } else if (block instanceof IPlantable
        || block instanceof IGrowable) {
      delay = (int) (2.0f + this.delayModifier);

    } else if (block.getMaterial(blockState) == Material.GRASS) {
      delay = this.delayModifier;
    }
    return delay;
  }

  @SubscribeEvent
  public void onRenderSpecificHandEvent(RenderSpecificHandEvent event) {
    this.waterCanRenderer.onRenderSpecificHandEvent(event);
  }
}
