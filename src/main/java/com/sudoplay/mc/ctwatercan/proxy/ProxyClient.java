package com.sudoplay.mc.ctwatercan.proxy;

import com.sudoplay.mc.ctwatercan.ModItems;
import com.sudoplay.mc.ctwatercan.items.watercan.WaterCanRenderer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ProxyClient
    extends ProxyCommon {

  @Override
  public void onPreInitialization(FMLPreInitializationEvent event) {

    super.onPreInitialization(event);
    MinecraftForge.EVENT_BUS.register(new WaterCanRenderer());
  }

  @SubscribeEvent
  public static void registerModels(ModelRegistryEvent event) {

    ModItems.initModels();
  }
}
