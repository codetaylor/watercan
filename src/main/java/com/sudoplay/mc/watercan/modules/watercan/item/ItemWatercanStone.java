package com.sudoplay.mc.watercan.modules.watercan.item;

import com.sudoplay.mc.watercan.ModWatercanConfig;

public class ItemWatercanStone
    extends ItemWaterCanBase {

  public static final String NAME = "watercan_stone";

  @Override
  protected int getCapacity() {

    return ModWatercanConfig.WATERCAN_STONE.CAPACITY;
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.WATERCAN_STONE.EXTINGUISH_FIRE;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.WATERCAN_STONE.MOISTURIZE_FARMLAND;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.WATERCAN_STONE.SPAWN_FLOWERS;
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.WATERCAN_STONE.SPREAD_GRASS;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.WATERCAN_STONE.SPREAD_MYCELIUM;
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.WATERCAN_STONE.GROW_CROPS;
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.WATERCAN_STONE.GROW_SAPLINGS;
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.WATERCAN_STONE.DELAY_MODIFIER;
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.WATERCAN_STONE.CONSUME_WATER_SOURCE;
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.WATERCAN_STONE.RANGE;
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.WATERCAN_STONE.FLOWER_CHANCE;
  }
}
