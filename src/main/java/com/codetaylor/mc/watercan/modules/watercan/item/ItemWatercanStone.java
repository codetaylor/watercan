package com.codetaylor.mc.watercan.modules.watercan.item;

import com.codetaylor.mc.watercan.ModWatercanConfig;

public class ItemWatercanStone
    extends ItemWaterCanBase {

  public static final String NAME = "watercan_stone";

  public ItemWatercanStone() {

    super(new Properties().maxDamage(ModWatercanConfig.STONE_WATERCAN.capacity.get()), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return ModWatercanConfig.STONE_WATERCAN.isDispensable.get();
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.STONE_WATERCAN.extinguishFire.get();
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.STONE_WATERCAN.moisturizeFarmland.get();
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.STONE_WATERCAN.spawnFlowers.get();
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.STONE_WATERCAN.spreadGrass.get();
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.STONE_WATERCAN.spreadMycelium.get();
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.STONE_WATERCAN.growCrops.get();
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.STONE_WATERCAN.growSaplings.get();
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.STONE_WATERCAN.delayModifier.get();
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.STONE_WATERCAN.consumeWaterSource.get();
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.STONE_WATERCAN.range.get();
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.STONE_WATERCAN.flowerChance.get();
  }
}
