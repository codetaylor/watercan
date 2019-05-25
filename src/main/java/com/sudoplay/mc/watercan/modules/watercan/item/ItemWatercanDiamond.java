package com.sudoplay.mc.watercan.modules.watercan.item;

import com.sudoplay.mc.watercan.ModWatercanConfig;

public class ItemWatercanDiamond
    extends ItemWaterCanBase {

  public static final String NAME = "watercan_diamond";

  @Override
  protected boolean isDispensable() {

    return ModWatercanConfig.WATERCAN_DIAMOND.IS_DISPENSABLE;
  }

  @Override
  protected int getCapacity() {

    return ModWatercanConfig.WATERCAN_DIAMOND.CAPACITY;
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.WATERCAN_DIAMOND.EXTINGUISH_FIRE;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.WATERCAN_DIAMOND.MOISTURIZE_FARMLAND;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.WATERCAN_DIAMOND.SPAWN_FLOWERS;
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.WATERCAN_DIAMOND.SPREAD_GRASS;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.WATERCAN_DIAMOND.SPREAD_MYCELIUM;
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.WATERCAN_DIAMOND.GROW_CROPS;
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.WATERCAN_DIAMOND.GROW_SAPLINGS;
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.WATERCAN_DIAMOND.DELAY_MODIFIER;
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.WATERCAN_DIAMOND.CONSUME_WATER_SOURCE;
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.WATERCAN_DIAMOND.RANGE;
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.WATERCAN_DIAMOND.FLOWER_CHANCE;
  }
}
