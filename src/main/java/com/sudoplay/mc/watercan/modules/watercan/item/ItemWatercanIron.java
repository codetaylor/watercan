package com.sudoplay.mc.watercan.modules.watercan.item;

import com.sudoplay.mc.watercan.ModWatercanConfig;

public class ItemWatercanIron
    extends ItemWaterCanBase {

  public static final String NAME = "watercan_iron";

  @Override
  protected int getCapacity() {

    return ModWatercanConfig.WATERCAN_IRON.CAPACITY;
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.WATERCAN_IRON.EXTINGUISH_FIRE;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.WATERCAN_IRON.MOISTURIZE_FARMLAND;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.WATERCAN_IRON.SPAWN_FLOWERS;
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.WATERCAN_IRON.SPREAD_GRASS;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.WATERCAN_IRON.SPREAD_MYCELIUM;
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.WATERCAN_IRON.GROW_CROPS;
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.WATERCAN_IRON.GROW_SAPLINGS;
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.WATERCAN_IRON.DELAY_MODIFIER;
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.WATERCAN_IRON.CONSUME_WATER_SOURCE;
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.WATERCAN_IRON.RANGE;
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.WATERCAN_IRON.FLOWER_CHANCE;
  }
}
