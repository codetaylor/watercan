package com.sudoplay.mc.watercan.modules.watercan.network;

import com.codetaylor.mc.athenaeum.spi.packet.PacketBlockPosBase;
import com.sudoplay.mc.watercan.ModWatercanConfig;
import com.sudoplay.mc.watercan.modules.watercan.item.ItemWaterCanBase;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class SCPacketDispenseWatercan
    extends PacketBlockPosBase<SCPacketDispenseWatercan> {

  private static final Logger LOGGER = LogManager.getLogger(SCPacketDispenseWatercan.class);

  // activate(ItemStack itemStack, World world, BlockPos pos)

  private ItemStack itemStack;

  @SuppressWarnings("unused")
  public SCPacketDispenseWatercan() {
    // serialization
  }

  public SCPacketDispenseWatercan(ItemStack itemStack, BlockPos pos) {

    super(pos);
    this.itemStack = itemStack;
  }

  @Override
  public void fromBytes(ByteBuf buf) {

    super.fromBytes(buf);
    PacketBuffer packetBuffer = new PacketBuffer(buf);

    try {
      this.itemStack = packetBuffer.readItemStack();

    } catch (IOException e) {
      LOGGER.error("Error reading itemStack", e);
    }
  }

  @Override
  public void toBytes(ByteBuf buf) {

    super.toBytes(buf);
    PacketBuffer packetBuffer = new PacketBuffer(buf);
    packetBuffer.writeItemStack(this.itemStack);
  }

  @Override
  public IMessage onMessage(SCPacketDispenseWatercan message, MessageContext ctx) {

    if (ModWatercanConfig.CLIENT.SPAWN_WATER_PARTICLES) {

      ItemStack itemStack = message.itemStack;
      Item item = itemStack.getItem();

      if (item instanceof ItemWaterCanBase) {
        double x = message.blockPos.getX() + 0.5;
        double y = message.blockPos.getY() + 0.5;
        double z = message.blockPos.getZ() + 0.5;
        World world = Minecraft.getMinecraft().world;
        ItemWaterCanBase watercan = (ItemWaterCanBase) item;

        if (watercan.getMaxDamage(itemStack) == 0
            || watercan.getMaxDamage(itemStack) - itemStack.getItemDamage() >= ItemWaterCanBase.MILLI_BUCKETS_PER_USE) {
          watercan.spawnParticles(world, x, y, z);
        }
      }
    }

    return null;
  }
}
