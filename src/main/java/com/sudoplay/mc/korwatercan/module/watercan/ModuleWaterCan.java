package com.sudoplay.mc.korwatercan.module.watercan;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.OnLoadConfigurationsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterCreativeTabsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterItemsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterRecipesEvent;
import com.sudoplay.mc.korwatercan.KorWaterCanCreativeTab;
import com.sudoplay.mc.korwatercan.module.watercan.config.ModuleWaterCanConfigAdapter;
import com.sudoplay.mc.korwatercan.module.watercan.item.ItemWaterCanDiamond;
import com.sudoplay.mc.korwatercan.module.watercan.item.ItemWaterCanIron;
import com.sudoplay.mc.korwatercan.module.watercan.item.ItemWaterCanStone;
import com.sudoplay.mc.korwatercan.module.watercan.item.ItemWaterCanWood;
import com.sudoplay.mc.korwatercan.module.watercan.recipe.RecipeRegistrationDelegate;

import java.io.File;

/**
 * Created by codetaylor on 11/24/2016.
 */
public class ModuleWaterCan implements
    IKorModule {

  public static final String MODULE_ID = "watercan";

  public static class Config {
    public static final String FILENAME = MODULE_ID + ".cfg";

    public static final String CATEGORY_ITEM_WATERCAN = "0 - WaterCan";
    public static final String CATEGORY_ITEM_WATERCAN_PARTICLES = "1 - WaterCan: Particles";
    public static final String CATEGORY_ITEM_WATERCAN_CAPACITY = "2 - Capacity";
    public static final String CATEGORY_ITEM_WATERCAN_RANGE = "3 - Range";
    public static final String CATEGORY_ITEM_WATERCAN_FLOWER = "4 - Flower Chance";
    public static final String CATEGORY_ITEM_WATERCAN_DELAY_MODIFIER = "5 - Delay Modifier";
  }

  @Override
  public String getKorModuleId() {
    return MODULE_ID;
  }

  @Subscribe
  public void onLoadConfigurationsEvent(OnLoadConfigurationsEvent event) {
    event.getConfigurationService()

        .loadConfiguration(
            new File(Config.FILENAME),
            new ModuleWaterCanConfigAdapter()
        );
  }

  @Subscribe
  public void onRegisterCreativeTabsEvent(OnRegisterCreativeTabsEvent event) {
    event.getRegistryService().register(

        KorWaterCanCreativeTab.class
    );
  }

  @Subscribe
  public void onRegisterItemsEvent(OnRegisterItemsEvent event) {
    event.getRegistryService().register(

        ItemWaterCanWood.class,
        ItemWaterCanStone.class,
        ItemWaterCanIron.class,
        ItemWaterCanDiamond.class
    );
  }

  @Subscribe
  public void onRegisterRecipesEvent(OnRegisterRecipesEvent event) {
    event.getRegistryService().register(

        RecipeRegistrationDelegate.class
    );
  }
}
