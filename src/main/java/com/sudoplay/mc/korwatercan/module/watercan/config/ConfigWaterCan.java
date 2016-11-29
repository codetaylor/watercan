package com.sudoplay.mc.korwatercan.module.watercan.config;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sk3lls on 11/27/2016.
 */
public class ConfigWaterCan extends
    KorConfigObject {

  @SerializedName("watercan_properties")
  private Map<String, ConfigWaterCanEntry> map;

  public ConfigWaterCan() {
    this.map = new LinkedHashMap<>();

    this.map.put("wood", new ConfigWaterCanEntry(2, 1000, 10, 0.0005f));
    this.map.put("stone", new ConfigWaterCanEntry(2, 2000, 10, 0.0005f));
    this.map.put("iron", new ConfigWaterCanEntry(2, 3000, 10, 0.0005f));
    this.map.put("diamond", new ConfigWaterCanEntry(2, 4000, 10, 0.0005f));
  }

  public ConfigWaterCanEntry getConfigWaterCanEntry(String name) {
    return this.map.get(name);
  }
}
