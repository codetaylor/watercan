package com.codetaylor.mc.watercan.modules.watercan.item;

import com.codetaylor.mc.watercan.ModWatercanConfig;

public class ItemWatercanIron
    extends ItemWaterCanBase {

  public static final String NAME = "watercan_iron";

  public ItemWatercanIron() {

    super(new Properties().maxDamage(ModWatercanConfig.IRON_WATERCAN.capacity.get()), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return ModWatercanConfig.IRON_WATERCAN.isDispensable.get();
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.IRON_WATERCAN.extinguishFire.get();
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.IRON_WATERCAN.moisturizeFarmland.get();
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.IRON_WATERCAN.spawnFlowers.get();
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.IRON_WATERCAN.spreadGrass.get();
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.IRON_WATERCAN.spreadMycelium.get();
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.IRON_WATERCAN.growCrops.get();
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.IRON_WATERCAN.growSaplings.get();
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.IRON_WATERCAN.delayModifier.get();
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.IRON_WATERCAN.consumeWaterSource.get();
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.IRON_WATERCAN.range.get();
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.IRON_WATERCAN.flowerChance.get();
  }
}
