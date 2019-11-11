package com.codetaylor.mc.watercan.modules.watercan.item;

import com.codetaylor.mc.watercan.ModWatercanConfig;

public class ItemWatercanGold
    extends ItemWaterCanBase {

  public static final String NAME = "watercan.gold";

  public ItemWatercanGold() {

    super(new Properties().maxDamage(ModWatercanConfig.GOLD_WATERCAN.capacity.get()), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return ModWatercanConfig.GOLD_WATERCAN.isDispensable.get();
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.GOLD_WATERCAN.extinguishFire.get();
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.GOLD_WATERCAN.moisturizeFarmland.get();
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.GOLD_WATERCAN.spawnFlowers.get();
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.GOLD_WATERCAN.spreadGrass.get();
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.GOLD_WATERCAN.spreadMycelium.get();
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.GOLD_WATERCAN.growCrops.get();
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.GOLD_WATERCAN.growSaplings.get();
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.GOLD_WATERCAN.delayModifier.get();
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.GOLD_WATERCAN.consumeWaterSource.get();
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.GOLD_WATERCAN.range.get();
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.GOLD_WATERCAN.flowerChance.get();
  }
}
