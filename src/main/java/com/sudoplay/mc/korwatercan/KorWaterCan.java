package com.sudoplay.mc.korwatercan;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.korwatercan.module.watercan.ModuleWaterCan;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by codetaylor on 11/24/2016.
 */
@Mod(
    modid = KorWaterCan.MOD_ID,
    version = KorWaterCan.VERSION,
    name = KorWaterCan.NAME
)
public class KorWaterCan extends
    Kor {

  public static final String MOD_ID = "ctkorwatercan";
  public static final String VERSION = "snapshot";
  public static final String NAME = "CTKor WaterCan";
  public static final double JSON_CONFIGS_VERSION = 1.0;

  @SuppressWarnings("unused")
  @Mod.Instance
  public static KorWaterCan INSTANCE;

  @Override
  public String getModId() {
    return MOD_ID;
  }

  @Override
  public String getModVersion() {
    return VERSION;
  }

  @Override
  public String getModName() {
    return NAME;
  }

  @Override
  public double getJsonConfigsVersion() {
    return JSON_CONFIGS_VERSION;
  }

  @Override
  @Mod.EventHandler
  protected void onPreInitialization(FMLPreInitializationEvent event) {

    this.registerModules(
        new ModuleWaterCan()
    );

    super.onPreInitialization(event);
  }

  @Override
  @Mod.EventHandler
  protected void onInitialization(FMLInitializationEvent event) {
    super.onInitialization(event);
  }

  @Override
  @Mod.EventHandler
  protected void onPostInitialization(FMLPostInitializationEvent event) {
    super.onPostInitialization(event);
  }
}
