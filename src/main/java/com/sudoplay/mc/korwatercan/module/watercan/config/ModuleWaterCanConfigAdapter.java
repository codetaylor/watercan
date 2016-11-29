package com.sudoplay.mc.korwatercan.module.watercan.config;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.KorConfigUtil;
import com.sudoplay.mc.kor.spi.config.forge.KorForgeConfigurationAdapter;
import com.sudoplay.mc.korwatercan.module.watercan.ModuleWaterCan;
import com.sudoplay.mc.korwatercan.shared.WaterCanType;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by codetaylor on 11/22/2016.
 */
public class ModuleWaterCanConfigAdapter implements
    KorForgeConfigurationAdapter<TextConfigData> {

  @Override
  public void adapt(Configuration configuration, TextConfigData textConfigData) {
    String category;

    category = ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN;

    configuration.addCustomCategoryComment(
        category,
        "Disabling a type here will prevent the item from being loaded."
    );

    for (WaterCanType mortarType : WaterCanType.values()) {
      KorConfigUtil.adaptBoolean(category, mortarType.getName(), true, configuration, textConfigData);
    }

    category = ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_PARTICLES;

    configuration.addCustomCategoryComment(
        category,
        "Turn off all the particle spawned by the water can here."
    );

    KorConfigUtil.adaptBoolean(category, "spawnWaterParticles", true, configuration, textConfigData);

    category = ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_CAPACITY;

    configuration.addCustomCategoryComment(
        category,
        "How much water could a water can can if a water can could can water?" +
            "\n\nSet to zero to make the can never run out of water."
    );

    KorConfigUtil.adaptInteger(category, "wood", 1000, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "stone", 2000, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "iron", 4000, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "diamond", 0, configuration, textConfigData);

    category = ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_RANGE;

    configuration.addCustomCategoryComment(
        category,
        "This is the radius that the water can will spread out from the targeted block.\n" +
            "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area."
    );

    KorConfigUtil.adaptInteger(category, "wood", 0, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "stone", 1, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "iron", 2, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "diamond", 3, configuration, textConfigData);

    category = ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_FLOWER;

    configuration.addCustomCategoryComment(
        category,
        "The flower chance controls the spawn rate of flowers on watered grass blocks.\n" +
            "Range: 0 to 100"
    );

    KorConfigUtil.adaptInteger(category, "wood", 0, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "stone", 1, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "iron", 2, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "diamond", 4, configuration, textConfigData);

    category = ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_DELAY_MODIFIER;

    configuration.addCustomCategoryComment(
        category,
        "Use the delay modifier to speed up or slow down growth.\n" +
            "Range: 1 to 40 (smaller is faster)"
    );

    KorConfigUtil.adaptInteger(category, "wood", 10, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "stone", 20, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "iron", 20, configuration, textConfigData);
    KorConfigUtil.adaptInteger(category, "diamond", 20, configuration, textConfigData);
  }
}
