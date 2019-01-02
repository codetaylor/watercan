package com.sudoplay.mc.watercan.modules.watercan.item;

import com.sudoplay.mc.watercan.ModWatercanConfig;

public class ItemWatercanWood
    extends ItemWaterCanBase {

  public static final String NAME = "watercan_wood";

  @Override
  protected int getCapacity() {

    return ModWatercanConfig.WATERCAN_WOOD.CAPACITY;
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.WATERCAN_WOOD.EXTINGUISH_FIRE;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.WATERCAN_WOOD.MOISTURIZE_FARMLAND;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.WATERCAN_WOOD.SPAWN_FLOWERS;
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.WATERCAN_WOOD.SPREAD_GRASS;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.WATERCAN_WOOD.SPREAD_MYCELIUM;
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.WATERCAN_WOOD.GROW_CROPS;
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.WATERCAN_WOOD.GROW_SAPLINGS;
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.WATERCAN_WOOD.DELAY_MODIFIER;
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.WATERCAN_WOOD.CONSUME_WATER_SOURCE;
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.WATERCAN_WOOD.RANGE;
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.WATERCAN_WOOD.FLOWER_CHANCE;
  }
}
