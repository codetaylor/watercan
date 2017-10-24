package com.sudoplay.mc.ctwatercan.items.watercan;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderSpecificHandEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* package */ class WaterCanRenderer {

  private Item item;

  /* package */ WaterCanRenderer(Item item) {
    this.item = item;
  }

  /* package */ void onRenderSpecificHandEvent(RenderSpecificHandEvent event) {
    ItemStack itemStack = event.getItemStack();

    if (!itemStack.isEmpty()) {
      Item item = itemStack.getItem();

      if (item == this.item
          && !Mouse.isButtonDown(0)) {

        this.renderItemInFirstPerson(
            Minecraft.getMinecraft().player,
            event.getPartialTicks(),
            event.getHand(),
            itemStack,
            event.getEquipProgress()
        );
        event.setCanceled(true);
      }
    }
  }

  private void renderItemInFirstPerson(
      AbstractClientPlayer clientPlayer,
      float partialTicks,
      EnumHand hand,
      @Nonnull ItemStack itemStack,
      float equipProgress
  ) {
    RayTraceResult rayTraceResult = this.rayTrace(clientPlayer, 10.0, partialTicks, true);
    float equipProgressScalar = 0.1f;

    if (rayTraceResult != null
        && rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
      BlockPos blockPos = rayTraceResult.getBlockPos();
      IBlockState blockState = clientPlayer.world.getBlockState(blockPos);
      Block block = blockState.getBlock();

      if (block.getMaterial(blockState) == Material.WATER) {
        equipProgressScalar = 1;
      }

    } else {
      equipProgressScalar = 0;
    }

    boolean isMainHand = hand == EnumHand.MAIN_HAND;
    EnumHandSide enumhandside = isMainHand ? clientPlayer.getPrimaryHand() : clientPlayer.getPrimaryHand().opposite();
    boolean isRightHand = enumhandside == EnumHandSide.RIGHT;

    GlStateManager.pushMatrix();
    this.transformSideFirstPerson(enumhandside, equipProgress * equipProgressScalar);
    this.transformFirstPerson(enumhandside);
    this.renderItemSide(clientPlayer, itemStack, isRightHand ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, !isRightHand);
    GlStateManager.popMatrix();
  }

  private void transformFirstPerson(EnumHandSide handSide) {
    int i = handSide == EnumHandSide.RIGHT ? 1 : -1;
    GlStateManager.rotate((float) i * 45.0F, 0.0F, 1.0F, 0.0F);
    GlStateManager.rotate(0.0F, 0.0F, 0.0F, 1.0F);
    GlStateManager.rotate(0.0F, 1.0F, 0.0F, 0.0F);
    GlStateManager.rotate((float) i * -45.0F, 0.0F, 1.0F, 0.0F);
  }

  private void transformSideFirstPerson(EnumHandSide handSide, float equipProgress) {
    int i = handSide == EnumHandSide.RIGHT ? 1 : -1;
    GlStateManager.translate((float) i * 0.56F, -0.52F + equipProgress * -0.6F, -0.72F);
  }

  private void renderItemSide(
      EntityLivingBase entityLivingBase,
      ItemStack heldStack,
      ItemCameraTransforms.TransformType transform,
      boolean isLeftHanded
  ) {
    if (heldStack != null) {
      GlStateManager.pushMatrix();

      RenderItem itemRenderer = Minecraft.getMinecraft().getRenderItem();
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
  @SideOnly(Side.CLIENT)
  private RayTraceResult rayTrace(
      Entity entity,
      double blockReachDistance,
      float partialTicks,
      boolean stopOnLiquid
  ) {
    Vec3d vec3d = entity.getPositionEyes(partialTicks);
    Vec3d vec3d1 = entity.getLook(partialTicks);
    Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
    return entity.world.rayTraceBlocks(vec3d, vec3d2, stopOnLiquid, false, true);
  }
}