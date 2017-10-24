package com.sudoplay.mc.ctwatercan;

import com.sudoplay.mc.ctwatercan.items.watercan.ItemWaterCan;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

  @GameRegistry.ObjectHolder(ModCTWatercan.MOD_ID + ":watercan_wood")
  public static ItemWaterCan WATER_CAN_WOOD;

  @GameRegistry.ObjectHolder(ModCTWatercan.MOD_ID + ":watercan_stone")
  public static ItemWaterCan WATER_CAN_STONE;

  @GameRegistry.ObjectHolder(ModCTWatercan.MOD_ID + ":watercan_iron")
  public static ItemWaterCan WATER_CAN_IRON;

  @GameRegistry.ObjectHolder(ModCTWatercan.MOD_ID + ":watercan_diamond")
  public static ItemWaterCan WATER_CAN_DIAMOND;

  @GameRegistry.ObjectHolder(ModCTWatercan.MOD_ID + ":watercan_gold")
  public static ItemWaterCan WATER_CAN_GOLD;

  @SideOnly(Side.CLIENT)
  public static void initModels() {
    WATER_CAN_WOOD.initModel();
    WATER_CAN_STONE.initModel();
    WATER_CAN_IRON.initModel();
    WATER_CAN_DIAMOND.initModel();
    WATER_CAN_GOLD.initModel();
  }

}
