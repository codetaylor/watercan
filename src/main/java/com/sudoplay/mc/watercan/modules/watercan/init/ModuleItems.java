package com.sudoplay.mc.watercan.modules.watercan.init;

import com.codetaylor.mc.athenaeum.registry.Registry;
import com.codetaylor.mc.athenaeum.util.ModelRegistrationHelper;
import com.sudoplay.mc.watercan.modules.watercan.item.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModuleItems {

  public static ItemWatercanWood WATERCAN_WOOD = new ItemWatercanWood();
  public static ItemWatercanStone WATERCAN_STONE = new ItemWatercanStone();
  public static ItemWatercanIron WATERCAN_IRON = new ItemWatercanIron();
  public static ItemWatercanDiamond WATERCAN_DIAMOND = new ItemWatercanDiamond();
  public static ItemWatercanGold WATERCAN_GOLD = new ItemWatercanGold();

  public static void onRegister(Registry registry) {

    registry.registerItem(ModuleItems.WATERCAN_WOOD, ItemWatercanWood.NAME);
    registry.registerItem(ModuleItems.WATERCAN_STONE, ItemWatercanStone.NAME);
    registry.registerItem(ModuleItems.WATERCAN_IRON, ItemWatercanIron.NAME);
    registry.registerItem(ModuleItems.WATERCAN_DIAMOND, ItemWatercanDiamond.NAME);
    registry.registerItem(ModuleItems.WATERCAN_GOLD, ItemWatercanGold.NAME);
  }

  @SideOnly(Side.CLIENT)
  public static void onClientRegister(Registry registry) {

    registry.registerClientModelRegistrationStrategy(() -> ModelRegistrationHelper.registerItemModels(
        ModuleItems.WATERCAN_WOOD,
        ModuleItems.WATERCAN_STONE,
        ModuleItems.WATERCAN_IRON,
        ModuleItems.WATERCAN_DIAMOND,
        ModuleItems.WATERCAN_GOLD
    ));
  }
}
