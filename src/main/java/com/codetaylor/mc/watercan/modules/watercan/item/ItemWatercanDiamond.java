package com.codetaylor.mc.watercan.modules.watercan.item;

import com.codetaylor.mc.watercan.ModWatercanConfig;

public class ItemWatercanDiamond
    extends ItemWaterCanBase {

  public static final String NAME = "watercan.diamond";

  public ItemWatercanDiamond() {

    super(new Properties().maxDamage(ModWatercanConfig.DIAMOND_WATERCAN.capacity.get()), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return ModWatercanConfig.DIAMOND_WATERCAN.isDispensable.get();
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.DIAMOND_WATERCAN.extinguishFire.get();
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.DIAMOND_WATERCAN.moisturizeFarmland.get();
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.DIAMOND_WATERCAN.spawnFlowers.get();
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.DIAMOND_WATERCAN.spreadGrass.get();
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.DIAMOND_WATERCAN.spreadMycelium.get();
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.DIAMOND_WATERCAN.growCrops.get();
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.DIAMOND_WATERCAN.growSaplings.get();
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.DIAMOND_WATERCAN.delayModifier.get();
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.DIAMOND_WATERCAN.consumeWaterSource.get();
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.DIAMOND_WATERCAN.range.get();
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.DIAMOND_WATERCAN.flowerChance.get();
  }
}
