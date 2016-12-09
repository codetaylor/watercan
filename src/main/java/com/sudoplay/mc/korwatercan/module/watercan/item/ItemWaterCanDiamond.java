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
    @KorTextConfigDependency(filename = Config.FILENAME, category = Config.CATEGORY_ITEM_WATERCAN, key = "diamond")
})

@KorGenerateModelItemSingleTexture(
    name = "watercan_diamond",
    modId = KorWaterCan.MOD_ID
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "item.watercan_diamond.name", value = "Water Can (Diamond)")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 4, row = 1, target = "items/watercan_diamond", source = "KorWaterCan.png")
})

@ForgeEventListener
public class ItemWaterCanDiamond extends AbstractItemWaterCan {

  @KorInject
  public ItemWaterCanDiamond(
      Kor kor,
      @KorTextConfig(file = Config.FILENAME) TextConfigData textConfigData
  ) {
    super(
        KorWaterCan.MOD_ID,
        "watercan_diamond",
        WaterCanType.Diamond,
        textConfigData
    );
    setCreativeTab(kor.get(KorWaterCanCreativeTab.class));
    setMaxStackSize(1);
  }
}
