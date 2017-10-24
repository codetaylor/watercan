package com.sudoplay.mc.ctwatercan.proxy;

import com.sudoplay.mc.ctwatercan.Config;
import com.sudoplay.mc.ctwatercan.items.watercan.ItemWaterCan;
import com.sudoplay.mc.ctwatercan.items.watercan.Type;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@Mod.EventBusSubscriber
public class ProxyCommon {

  public static Configuration CONFIG;

  public void onPreInitialization(FMLPreInitializationEvent event) {

    File configFolder = event.getModConfigurationDirectory();
    CONFIG = new Configuration(new File(configFolder.getPath(), Config.FILENAME));
    Config.read(ProxyCommon.CONFIG);
  }

  public void onInitialization(FMLInitializationEvent event) {
    //
  }

  public void onPostInitialization(FMLPostInitializationEvent event) {

    if (CONFIG.hasChanged()) {
      CONFIG.save();
    }
  }

  @SubscribeEvent
  public static void registerItems(RegistryEvent.Register<Item> event) {

    event.getRegistry().registerAll(
        new ItemWaterCan(Type.Wood),
        new ItemWaterCan(Type.Stone),
        new ItemWaterCan(Type.Iron),
        new ItemWaterCan(Type.Diamond),
        new ItemWaterCan(Type.Gold)
    );
  }

}
