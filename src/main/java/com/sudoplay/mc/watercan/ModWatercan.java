package com.sudoplay.mc.watercan;

import com.codetaylor.mc.athenaeum.module.ModuleManager;
import com.sudoplay.mc.watercan.modules.watercan.ModuleWatercan;
import com.sudoplay.mc.watercan.modules.watercan.init.ModuleItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.*;

@Mod(
    modid = ModWatercan.MOD_ID,
    version = ModWatercan.VERSION,
    name = ModWatercan.NAME
    //@@DEPENDENCIES@@
)
public class ModWatercan {

  public static final String MOD_ID = "watercan";
  public static final String VERSION = "@@VERSION@@";
  public static final String NAME = "Watercan";

  @SuppressWarnings("unused")
  @Mod.Instance
  public static ModWatercan INSTANCE;

  public static final CreativeTabs CREATIVE_TAB = new CreativeTabs(MOD_ID) {

    @Override
    public ItemStack getTabIconItem() {

      return new ItemStack(ModuleItems.WATERCAN_WOOD, 1, 0);
    }
  };

  private final ModuleManager moduleManager;

  public ModWatercan() {

    this.moduleManager = new ModuleManager(MOD_ID);
    this.moduleManager.registerModules(
        ModuleWatercan.class
    );
  }

  @Mod.EventHandler
  public void onConstructionEvent(FMLConstructionEvent event) {

    this.moduleManager.onConstructionEvent();
    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onPreInitializationEvent(FMLPreInitializationEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onInitializationEvent(FMLInitializationEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onPostInitializationEvent(FMLPostInitializationEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onLoadCompleteEvent(FMLLoadCompleteEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerAboutToStartEvent(FMLServerAboutToStartEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerStartingEvent(FMLServerStartingEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerStartedEvent(FMLServerStartedEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerStoppingEvent(FMLServerStoppingEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

  @Mod.EventHandler
  public void onServerStoppedEvent(FMLServerStoppedEvent event) {

    this.moduleManager.routeFMLStateEvent(event);
  }

}
