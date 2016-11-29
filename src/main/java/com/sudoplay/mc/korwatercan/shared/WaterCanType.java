package com.sudoplay.mc.korwatercan.shared;

import com.sudoplay.mc.kor.spi.item.ISubType;

/**
 * Created by codetaylor on 11/22/2016.
 */
public enum WaterCanType implements
    ISubType {

  Wood(0, "wood"),
  Stone(1, "stone"),
  Iron(2, "iron"),
  Diamond(3, "diamond");

  private final int meta;
  private final String name;

  WaterCanType(int meta, String name) {
    this.meta = meta;
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getMeta() {
    return this.meta;
  }
}
