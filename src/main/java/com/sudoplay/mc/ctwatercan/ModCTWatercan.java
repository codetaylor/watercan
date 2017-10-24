package com.sudoplay.mc.ctwatercan;

import com.sudoplay.mc.ctwatercan.proxy.ProxyCommon;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
    modid = ModCTWatercan.MOD_ID,
    version = ModCTWatercan.VERSION,
    name = ModCTWatercan.NAME
    //@@DEPENDENCIES@@
)
public class ModCTWatercan {

  public static final String MOD_ID = "ctwatercan";
  public static final String VERSION = "@@VERSION@@";
  public static final String NAME = "CT WaterCan";

  @SuppressWarnings("unused")
  @Mod.Instance
  public static ModCTWatercan INSTANCE;

  @SidedProxy(clientSide = "com.sudoplay.mc.ctwatercan.proxy.ProxyClient", serverSide = "com.sudoplay.mc.ctwatercan.proxy.ProxyServer")
  public static ProxyCommon PROXY;

  public static Logger LOG;

  @Mod.EventHandler
  protected void onPreInitialization(FMLPreInitializationEvent event) {

    LOG = event.getModLog();
    PROXY.onPreInitialization(event);
  }

  @Mod.EventHandler
  protected void onInitialization(FMLInitializationEvent event) {

    PROXY.onInitialization(event);
  }

  @Mod.EventHandler
  protected void onPostInitialization(FMLPostInitializationEvent event) {

    PROXY.onPostInitialization(event);
  }

}
