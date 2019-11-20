package com.codetaylor.mc.watercan.modules.watercan.init;

import com.codetaylor.mc.watercan.modules.watercan.item.*;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemInitializer {

  public static void onRegister(IForgeRegistry<Item> registry) {

    ItemWatercanWood watercanWood = new ItemWatercanWood();
    ItemWatercanStone watercanStone = new ItemWatercanStone();
    ItemWatercanIron watercanIron = new ItemWatercanIron();
    ItemWatercanGold watercanGold = new ItemWatercanGold();
    ItemWatercanDiamond watercanDiamond = new ItemWatercanDiamond();

    registry.register(watercanWood);
    registry.register(watercanStone);
    registry.register(watercanIron);
    registry.register(watercanGold);
    registry.register(watercanDiamond);

    ItemWaterCanBase.DispenserBehavior behavior = new ItemWaterCanBase.DispenserBehavior();
    DispenserBlock.registerDispenseBehavior(watercanDiamond, behavior);
    DispenserBlock.registerDispenseBehavior(watercanGold, behavior);
    DispenserBlock.registerDispenseBehavior(watercanIron, behavior);
    DispenserBlock.registerDispenseBehavior(watercanStone, behavior);
    DispenserBlock.registerDispenseBehavior(watercanWood, behavior);
  }
}
