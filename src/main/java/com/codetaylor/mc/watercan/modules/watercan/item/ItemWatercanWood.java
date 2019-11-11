package com.codetaylor.mc.watercan.modules.watercan.item;

import com.codetaylor.mc.watercan.ModWatercanConfig;

public class ItemWatercanWood
    extends ItemWaterCanBase {

  public static final String NAME = "watercan.wood";

  public ItemWatercanWood() {

    super(new Properties().maxDamage(ModWatercanConfig.WOODEN_WATERCAN.capacity.get()), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return ModWatercanConfig.WOODEN_WATERCAN.isDispensable.get();
  }

  @Override
  protected boolean canExtinguishFire() {

    return ModWatercanConfig.WOODEN_WATERCAN.extinguishFire.get();
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return ModWatercanConfig.WOODEN_WATERCAN.moisturizeFarmland.get();
  }

  @Override
  protected boolean canSpawnFlowers() {

    return ModWatercanConfig.WOODEN_WATERCAN.spawnFlowers.get();
  }

  @Override
  protected boolean canSpreadGrass() {

    return ModWatercanConfig.WOODEN_WATERCAN.spreadGrass.get();
  }

  @Override
  protected boolean canSpreadMycelium() {

    return ModWatercanConfig.WOODEN_WATERCAN.spreadMycelium.get();
  }

  @Override
  protected boolean canGrowCrops() {

    return ModWatercanConfig.WOODEN_WATERCAN.growCrops.get();
  }

  @Override
  protected boolean canGrowSaplings() {

    return ModWatercanConfig.WOODEN_WATERCAN.growSaplings.get();
  }

  @Override
  protected int getDelayModifier() {

    return ModWatercanConfig.WOODEN_WATERCAN.delayModifier.get();
  }

  @Override
  protected boolean consumeWaterSource() {

    return ModWatercanConfig.WOODEN_WATERCAN.consumeWaterSource.get();
  }

  @Override
  protected int getRange() {

    return ModWatercanConfig.WOODEN_WATERCAN.range.get();
  }

  @Override
  protected int getFlowerChance() {

    return ModWatercanConfig.WOODEN_WATERCAN.flowerChance.get();
  }
}
