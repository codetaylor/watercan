package com.codetaylor.mc.watercan.modules.watercan;

import com.codetaylor.mc.watercan.ModWatercan;
import com.codetaylor.mc.watercan.modules.watercan.init.ModuleItems;
import com.codetaylor.mc.watercan.modules.watercan.item.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = ModuleWatercan.MOD_ID)
public class ModuleWatercan {

  public static final String MOD_ID = ModWatercan.MOD_ID;

  @SubscribeEvent
  public void onRegisterItemEvent(RegistryEvent.Register<Item> event) {

    ModuleItems.onRegister(event.getRegistry());
  }

  @ObjectHolder(ModWatercan.MOD_ID)
  public static final class Items {

    @ObjectHolder(ItemWatercanDiamond.NAME)
    public static final ItemWatercanDiamond WATERCAN_DIAMOND;

    @ObjectHolder(ItemWatercanGold.NAME)
    public static final ItemWatercanGold WATERCAN_GOLD;

    @ObjectHolder(ItemWatercanIron.NAME)
    public static final ItemWatercanIron WATERCAN_IRON;

    @ObjectHolder(ItemWatercanStone.NAME)
    public static final ItemWatercanStone WATERCAN_STONE;

    @ObjectHolder(ItemWatercanWood.NAME)
    public static final ItemWatercanWood WATERCAN_WOOD;

    static {
      WATERCAN_DIAMOND = null;
      WATERCAN_GOLD = null;
      WATERCAN_IRON = null;
      WATERCAN_STONE = null;
      WATERCAN_WOOD = null;
    }
  }
}
