package com.sudoplay.mc.korwatercan.module.watercan.item;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.ForgeEventListener;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.korwatercan.KorWaterCan;
import com.sudoplay.mc.korwatercan.KorWaterCanCreativeTab;
import com.sudoplay.mc.korwatercan.module.watercan.ModuleWaterCan.Config;
import com.sudoplay.mc.korwatercan.shared.WaterCanType;

/**
 * Created by codetaylor on 11/24/2016.
 */
@KorRegistrationTextConfigDependency(dependsOn = {
    @KorTextConfigDependency(filename = Config.FILENAME, category = Config.CATEGORY_ITEM_WATERCAN, key = "gold")
})

@KorGenerateModelItemSingleTexture(
    name = ItemWaterCanGold.NAME,
    modId = KorWaterCan.MOD_ID
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "item." + ItemWaterCanGold.NAME + ".name", value = "Water Can (Gold)")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 5, row = 1, target = "items/" + ItemWaterCanGold.NAME, source = "KorWaterCan.png")
})

@ForgeEventListener
public class ItemWaterCanGold extends AbstractItemWaterCan {

  public static final String NAME = "watercan_gold";

  @KorInject
  public ItemWaterCanGold(
      Kor kor,
      @KorTextConfig(file = Config.FILENAME) TextConfigData textConfigData
  ) {
    super(
        KorWaterCan.MOD_ID,
        NAME,
        WaterCanType.Gold,
        textConfigData
    );
    setCreativeTab(kor.get(KorWaterCanCreativeTab.class));
    setMaxStackSize(1);
  }
}
