package com.sudoplay.mc.korwatercan.module.watercan.config;

/**
 * Created by sk3lls on 11/26/2016.
 */
public class ConfigWaterCanEntry {

  private int range;
  private int capacity;
  private int millibucketsPerUse;
  private float flowerChance;

  public ConfigWaterCanEntry(
      int range,
      int capacity,
      int millibucketsPerUse,
      float flowerChance
  ) {
    this.range = range;
    this.capacity = capacity;
    this.millibucketsPerUse = millibucketsPerUse;
    this.flowerChance = flowerChance;
  }

  public int getRange() {
    return range;
  }

  public int getCapacity() {
    return capacity;
  }

  public int getMillibucketsPerUse() {
    return millibucketsPerUse;
  }

  public float getFlowerChance() {
    return flowerChance;
  }
}
