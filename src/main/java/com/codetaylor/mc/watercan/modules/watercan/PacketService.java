package com.codetaylor.mc.watercan.modules.watercan;

import com.codetaylor.mc.watercan.ModWatercan;
import com.codetaylor.mc.watercan.modules.watercan.network.SCPacketDispenseWatercan;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketService {

  private static final String PROTOCOL_VERSION = Integer.toString(1);
  private static final SimpleChannel NETWORK_CHANNEL;

  private static int index;

  static {
    NETWORK_CHANNEL = NetworkRegistry.ChannelBuilder
        .named(new ResourceLocation(ModWatercan.MOD_ID, "module.watercan"))
        .clientAcceptedVersions(PROTOCOL_VERSION::equals)
        .serverAcceptedVersions(PROTOCOL_VERSION::equals)
        .networkProtocolVersion(() -> PROTOCOL_VERSION)
        .simpleChannel();
  }

  public static void register() {

    NETWORK_CHANNEL.registerMessage(
        PacketService.index++,
        SCPacketDispenseWatercan.class,
        SCPacketDispenseWatercan::encode,
        SCPacketDispenseWatercan::decode,
        SCPacketDispenseWatercan.Handler::handle
    );
  }

  public static void sendToAll(Object msg) {

    NETWORK_CHANNEL.send(PacketDistributor.ALL.noArg(), msg);
  }
}
