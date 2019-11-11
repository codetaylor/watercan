package com.codetaylor.mc.watercan.modules.watercan.client.event;

import com.codetaylor.mc.watercan.modules.watercan.ModuleWatercan;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHelper;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class RenderSpecificHandEventHandler {

  @SubscribeEvent
  public static void onRenderSpecificHandEvent(RenderSpecificHandEvent event) {

    ItemStack itemStack = event.getItemStack();

    if (!itemStack.isEmpty()) {

      Minecraft minecraft = Minecraft.getInstance();
      MouseHelper mouseHelper = minecraft.mouseHelper;

      if (isItemWatercan(itemStack.getItem())
          && !mouseHelper.isLeftDown()) {

        renderItemInFirstPerson(
            minecraft.player,
            event.getPartialTicks(),
            event.getHand(),
            itemStack,
            event.getEquipProgress()
        );
        event.setCanceled(true);
      }
    }
  }

  private static boolean isItemWatercan(Item item) {

    return item == ModuleWatercan.Items.WATERCAN_WOOD
        || item == ModuleWatercan.Items.WATERCAN_STONE
        || item == ModuleWatercan.Items.WATERCAN_IRON
        || item == ModuleWatercan.Items.WATERCAN_DIAMOND
        || item == ModuleWatercan.Items.WATERCAN_GOLD;
  }

  private static void renderItemInFirstPerson(
      PlayerEntity clientPlayer,
      float partialTicks,
      Hand hand,
      @Nonnull ItemStack itemStack,
      float equipProgress
  ) {

    RayTraceResult rayTraceResult = rayTrace(clientPlayer, 10.0, partialTicks);
    float equipProgressScalar = 0.1f;

    if (rayTraceResult != null
        && rayTraceResult.getType() == RayTraceResult.Type.BLOCK) {
      BlockPos blockPos = ((BlockRayTraceResult) rayTraceResult).getPos();
      BlockState blockState = clientPlayer.world.getBlockState(blockPos);
      Block block = blockState.getBlock();

      if (block.getMaterial(blockState) == Material.WATER) {
        equipProgressScalar = 1;
      }

    } else {
      equipProgressScalar = 0;
    }

    boolean isMainHand = hand == Hand.MAIN_HAND;
    HandSide handSide = isMainHand ? clientPlayer.getPrimaryHand() : clientPlayer.getPrimaryHand().opposite();
    boolean isRightHand = (handSide == HandSide.RIGHT);

    GlStateManager.pushMatrix();
    transformSideFirstPerson(handSide, equipProgress * equipProgressScalar);
    transformFirstPerson(handSide);
    renderItemSide(
        clientPlayer,
        itemStack,
        isRightHand ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND,
        !isRightHand
    );
    GlStateManager.popMatrix();
  }

  private static void transformFirstPerson(HandSide handSide) {

    int i = handSide == HandSide.RIGHT ? 1 : -1;
    GlStateManager.rotatef((float) i * 45.0F, 0.0F, 1.0F, 0.0F);
    GlStateManager.rotatef(0.0F, 0.0F, 0.0F, 1.0F);
    GlStateManager.rotatef(0.0F, 1.0F, 0.0F, 0.0F);
    GlStateManager.rotatef((float) i * -45.0F, 0.0F, 1.0F, 0.0F);
  }

  private static void transformSideFirstPerson(HandSide handSide, float equipProgress) {

    int i = handSide == HandSide.RIGHT ? 1 : -1;
    GlStateManager.translatef((float) i * 0.56F, -0.52F + equipProgress * -0.6F, -0.72F);
  }

  private static void renderItemSide(
      LivingEntity entityLivingBase,
      ItemStack heldStack,
      ItemCameraTransforms.TransformType transform,
      boolean isLeftHanded
  ) {

    if (heldStack != null) {
      GlStateManager.pushMatrix();

      ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
      boolean shouldRenderItemIn3D = itemRenderer.shouldRenderItemIn3D(heldStack);

      if (shouldRenderItemIn3D) {
        GlStateManager.depthMask(false);
      }

      itemRenderer.renderItem(heldStack, entityLivingBase, transform, isLeftHanded);

      if (shouldRenderItemIn3D) {
        GlStateManager.depthMask(true);
      }

      GlStateManager.popMatrix();
    }
  }

  @Nullable
  @OnlyIn(Dist.CLIENT)
  private static RayTraceResult rayTrace(
      Entity entity,
      double blockReachDistance,
      float partialTicks
  ) {

    Vec3d vec3d = entity.getEyePosition(partialTicks);
    Vec3d vec3d1 = entity.getLook(partialTicks);
    Vec3d vec3d2 = vec3d.add(
        vec3d1.x * blockReachDistance,
        vec3d1.y * blockReachDistance,
        vec3d1.z * blockReachDistance
    );
    return entity.world.rayTraceBlocks(new RayTraceContext(vec3d, vec3d2, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.SOURCE_ONLY, entity));
  }
}