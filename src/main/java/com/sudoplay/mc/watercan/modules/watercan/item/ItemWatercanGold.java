package com.sudoplay.mc.watercan.modules.watercan.item;

import com.sudoplay.mc.watercan.ModWatercanConfig;

public class ItemWatercanGold
    extends ItemWaterCanBase {

  public static final String NAME = "watercan_gold";

  @Override
  protected int getCapacity() {

    return ModWatercanConfig.WATERCAN_GOLD.CAPACITY;
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.WATERCAN_GOLD.EXTINGUISH_FIRE;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.WATERCAN_GOLD.MOISTURIZE_FARMLAND;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.WATERCAN_GOLD.SPAWN_FLOWERS;
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.WATERCAN_GOLD.SPREAD_GRASS;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.WATERCAN_GOLD.SPREAD_MYCELIUM;
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.WATERCAN_GOLD.GROW_CROPS;
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.WATERCAN_GOLD.GROW_SAPLINGS;
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.WATERCAN_GOLD.DELAY_MODIFIER;
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.WATERCAN_GOLD.CONSUME_WATER_SOURCE;
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.WATERCAN_GOLD.RANGE;
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.WATERCAN_GOLD.FLOWER_CHANCE;
  }
}
