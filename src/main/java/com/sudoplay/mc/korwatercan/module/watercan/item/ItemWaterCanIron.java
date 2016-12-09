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
    @KorTextConfigDependency(filename = Config.FILENAME, category = Config.CATEGORY_ITEM_WATERCAN, key = "iron")
})

@KorGenerateModelItemSingleTexture(
    name = "watercan_iron",
    modId = KorWaterCan.MOD_ID
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "item.watercan_iron.name", value = "Water Can (Iron)")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 3, row = 1, target = "items/watercan_iron", source = "KorWaterCan.png")
})

@ForgeEventListener
public class ItemWaterCanIron extends AbstractItemWaterCan {

  @KorInject
  public ItemWaterCanIron(
      Kor kor,
      @KorTextConfig(file = Config.FILENAME) TextConfigData textConfigData
  ) {
    super(
        KorWaterCan.MOD_ID,
        "watercan_iron",
        WaterCanType.Iron,
        textConfigData
    );
    setCreativeTab(kor.get(KorWaterCanCreativeTab.class));
    setMaxStackSize(1);
  }
}
