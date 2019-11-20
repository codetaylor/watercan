package com.codetaylor.mc.watercan;

import com.codetaylor.mc.watercan.modules.watercan.ModuleWatercan;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Mod(ModWatercan.MOD_ID)
public class ModWatercan {

  public static final String MOD_ID = "watercan";

  public ModWatercan() {

    ModLoadingContext modLoadingContext = ModLoadingContext.get();
    modLoadingContext.registerConfig(ModConfig.Type.CLIENT, ModWatercanConfig.CLIENT_CONFIG);
    modLoadingContext.registerConfig(ModConfig.Type.COMMON, ModWatercanConfig.COMMON_CONFIG);

    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

    MinecraftForge.EVENT_BUS.register(this);

    Path configPath = FMLPaths.CONFIGDIR.get().resolve(ModWatercan.MOD_ID);

    try {
      Files.createDirectories(configPath);

    } catch (IOException ignore) {
      //
    }

    ModWatercanConfig.loadConfig(ModWatercanConfig.CLIENT_CONFIG, configPath.resolve("watercan.client.toml"));
    ModWatercanConfig.loadConfig(ModWatercanConfig.COMMON_CONFIG, configPath.resolve("watercan.common.toml"));
  }

  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEventHandler {

    @SubscribeEvent
    public static void onRegisterItem(RegistryEvent.Register<Item> event) {

      ModuleWatercan.onRegisterItemEvent(event);
    }
  }

  private <T extends Event> void doClientStuff(T t) {
    //
  }

  private <T extends Event> void setup(T t) {
    //
  }
}
