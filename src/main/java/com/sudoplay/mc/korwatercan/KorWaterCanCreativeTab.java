package com.sudoplay.mc.korwatercan;

import com.sudoplay.mc.kor.core.generation.annotation.KorGenerateLangEntries;
import com.sudoplay.mc.kor.core.generation.annotation.KorLangEntry;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.korwatercan.module.watercan.item.ItemWaterCanWood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;

/**
 * Created by codetaylor on 11/24/2016.
 */
@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "itemGroup." + KorWaterCan.MOD_ID + "_tab", value = "CTKor WaterCan")
})
public class KorWaterCanCreativeTab extends
    CreativeTabs {

  private Kor kor;

  @KorInject
  public KorWaterCanCreativeTab(
      Kor kor
  ) {
    super(CreativeTabs.getNextID(), KorWaterCan.MOD_ID + "_tab");
    this.kor = kor;
  }

  @Nonnull
  @Override
  public Item getTabIconItem() {
    return this.kor.get(ItemWaterCanWood.class);
  }
}
