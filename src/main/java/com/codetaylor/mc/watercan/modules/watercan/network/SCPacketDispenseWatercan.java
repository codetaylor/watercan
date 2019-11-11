package com.codetaylor.mc.watercan.modules.watercan.network;

import com.codetaylor.mc.watercan.ModWatercanConfig;
import com.codetaylor.mc.watercan.modules.watercan.item.ItemWaterCanBase;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SCPacketDispenseWatercan {

  private ItemStack itemStack;
  private BlockPos blockPos;

  @SuppressWarnings("unused")
  public SCPacketDispenseWatercan() {
    // serialization
  }

  public SCPacketDispenseWatercan(ItemStack itemStack, BlockPos pos) {

    this.itemStack = itemStack;
    this.blockPos = pos;
  }

  public static void encode(SCPacketDispenseWatercan packet, PacketBuffer buffer) {

    buffer.writeItemStack(packet.itemStack);
    buffer.writeBlockPos(packet.blockPos);
  }

  public static SCPacketDispenseWatercan decode(PacketBuffer buf) {

    SCPacketDispenseWatercan packet = new SCPacketDispenseWatercan();
    packet.itemStack = buf.readItemStack();
    packet.blockPos = buf.readBlockPos();
    return packet;
  }

  public static class Handler {

    public static void handle(final SCPacketDispenseWatercan message, Supplier<NetworkEvent.Context> context) {

      context.get().enqueueWork(() -> {

        if (ModWatercanConfig.CLIENT.spawnWaterParticles.get()) {

          ItemStack itemStack = message.itemStack;
          Item item = itemStack.getItem();

          if (item instanceof ItemWaterCanBase) {
            double x = message.blockPos.getX() + 0.5;
            double y = message.blockPos.getY() + 0.5;
            double z = message.blockPos.getZ() + 0.5;
            World world = Minecraft.getInstance().world;
            ItemWaterCanBase watercan = (ItemWaterCanBase) item;

            if (watercan.getMaxDamage(itemStack) == 0
                || watercan.getMaxDamage(itemStack) - itemStack.getDamage() >= ItemWaterCanBase.MILLI_BUCKETS_PER_USE) {
              watercan.spawnParticles(world, x, y, z);
            }
          }
        }
      });
      context.get().setPacketHandled(true);
    }
  }

}
