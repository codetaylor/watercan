package com.sudoplay.mc.ctwatercan;

import com.sudoplay.mc.ctwatercan.items.watercan.Type;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {

  public static final String FILENAME = ModCTWatercan.MOD_ID + ".cfg";

  public static final String CATEGORY_ITEM_WATERCAN_PARTICLES = "1 - Client";
  public static final String CATEGORY_ITEM_WATERCAN_CAPACITY = "2 - Capacity";
  public static final String CATEGORY_ITEM_WATERCAN_RANGE = "3 - Range";
  public static final String CATEGORY_ITEM_WATERCAN_FLOWER = "4 - Flower Chance";
  public static final String CATEGORY_ITEM_WATERCAN_DELAY_MODIFIER = "5 - Delay Modifier";
  public static final String CATEGORY_ITEM_WATERCAN_CONSUME_WATER_SOURCE = "6 - Consume Water Source";

  private static final Type[] TYPES = Type.values();

  public static boolean SHOW_PARTICLES;
  public static int[] CAPACITY = new int[TYPES.length];
  public static int[] RANGE = new int[TYPES.length];
  public static int[] FLOWER_CHANCE = new int[TYPES.length];
  public static int[] DELAY_MODIFIER = new int[TYPES.length];
  public static boolean[] CONSUME_WATER_SOURCE = new boolean[TYPES.length];

  public static int getCapacity(Type type) {

    return CAPACITY[type.getMeta()];
  }

  public static int getRange(Type type) {

    return RANGE[type.getMeta()];
  }

  public static int getFlowerChance(Type type) {

    return FLOWER_CHANCE[type.getMeta()];
  }

  public static int getDelayModifier(Type type) {

    return DELAY_MODIFIER[type.getMeta()];
  }

  public static void read(Configuration config) {

    try {
      config.load();
      Config._read(config);

    } catch (Exception e) {
      ModCTWatercan.LOG.log(Level.ERROR, "Error loading config file", e);

    } finally {

      if (config.hasChanged()) {
        config.save();
      }
    }
  }

  private static void _read(Configuration config) {

    Config.readShowParticles(config);
    Config.readCapacity(config);
    Config.readRange(config);
    Config.readFlowerChance(config);
    Config.readDelayModifier(config);
    Config.readConsumeWaterSource(config);
  }

  private static void readConsumeWaterSource(Configuration config) {

    config.addCustomCategoryComment(
        CATEGORY_ITEM_WATERCAN_CONSUME_WATER_SOURCE,
        "Set to true to consume the water source block when refilling the watercan."
    );

    CONSUME_WATER_SOURCE[Type.Wood.getMeta()] = Config.getConsumeWaterSource(config, Type.Wood.getName(), false);
    CONSUME_WATER_SOURCE[Type.Stone.getMeta()] = Config.getConsumeWaterSource(config, Type.Stone.getName(), false);
    CONSUME_WATER_SOURCE[Type.Iron.getMeta()] = Config.getConsumeWaterSource(config, Type.Iron.getName(), false);
    CONSUME_WATER_SOURCE[Type.Diamond.getMeta()] = Config.getConsumeWaterSource(config, Type.Diamond.getName(), false);
    CONSUME_WATER_SOURCE[Type.Gold.getMeta()] = Config.getConsumeWaterSource(config, Type.Gold.getName(), false);
  }

  private static void readShowParticles(Configuration config) {

    config.addCustomCategoryComment(
        CATEGORY_ITEM_WATERCAN_PARTICLES,
        "Turn off all the particles spawned by the water can here."
    );

    SHOW_PARTICLES = config.getBoolean("spawnWaterParticles", CATEGORY_ITEM_WATERCAN_PARTICLES, true, "");
  }

  private static void readCapacity(Configuration config) {

    config.addCustomCategoryComment(
        CATEGORY_ITEM_WATERCAN_CAPACITY,
        "How much water could a water can can if a water can could can water?" +
            "\nCapacity in millibuckets." +
            "\n\nSet to zero to make the can never run out of water."
    );

    CAPACITY[Type.Wood.getMeta()] = Config.getCapacity(config, Type.Wood.getName(), 1000);
    CAPACITY[Type.Stone.getMeta()] = Config.getCapacity(config, Type.Stone.getName(), 2000);
    CAPACITY[Type.Iron.getMeta()] = Config.getCapacity(config, Type.Iron.getName(), 4000);
    CAPACITY[Type.Diamond.getMeta()] = Config.getCapacity(config, Type.Diamond.getName(), 0);
    CAPACITY[Type.Gold.getMeta()] = Config.getCapacity(config, Type.Gold.getName(), 4000);
  }

  private static void readRange(Configuration config) {

    config.addCustomCategoryComment(
        CATEGORY_ITEM_WATERCAN_RANGE,
        "This is the radius that the water can will spread out from the targeted block.\n" +
            "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area."
    );

    RANGE[Type.Wood.getMeta()] = Config.getRange(config, Type.Wood.getName(), 0);
    RANGE[Type.Stone.getMeta()] = Config.getRange(config, Type.Stone.getName(), 1);
    RANGE[Type.Iron.getMeta()] = Config.getRange(config, Type.Iron.getName(), 1);
    RANGE[Type.Diamond.getMeta()] = Config.getRange(config, Type.Diamond.getName(), 2);
    RANGE[Type.Gold.getMeta()] = Config.getRange(config, Type.Gold.getName(), 1);
  }

  private static void readFlowerChance(Configuration config) {

    config.addCustomCategoryComment(
        CATEGORY_ITEM_WATERCAN_FLOWER,
        "The flower chance controls the spawn rate of flowers on watered grass blocks.\n" +
            "The higher the number the higher the chance to spawn flowers while watering.\n" +
            "Range: 0 to 100"
    );

    FLOWER_CHANCE[Type.Wood.getMeta()] = Config.getFlowerChance(config, Type.Wood.getName(), 0);
    FLOWER_CHANCE[Type.Stone.getMeta()] = Config.getFlowerChance(config, Type.Stone.getName(), 1);
    FLOWER_CHANCE[Type.Iron.getMeta()] = Config.getFlowerChance(config, Type.Iron.getName(), 1);
    FLOWER_CHANCE[Type.Diamond.getMeta()] = Config.getFlowerChance(config, Type.Diamond.getName(), 2);
    FLOWER_CHANCE[Type.Gold.getMeta()] = Config.getFlowerChance(config, Type.Gold.getName(), 50);
  }

  private static void readDelayModifier(Configuration config) {

    config.addCustomCategoryComment(
        CATEGORY_ITEM_WATERCAN_DELAY_MODIFIER,
        "Use the delay modifier to speed up or slow down growth.\n" +
            "Range: 1 to 40 (smaller is faster)"
    );

    DELAY_MODIFIER[Type.Wood.getMeta()] = Config.getDelayModifier(config, Type.Wood.getName(), 5);
    DELAY_MODIFIER[Type.Stone.getMeta()] = Config.getDelayModifier(config, Type.Stone.getName(), 15);
    DELAY_MODIFIER[Type.Iron.getMeta()] = Config.getDelayModifier(config, Type.Iron.getName(), 10);
    DELAY_MODIFIER[Type.Diamond.getMeta()] = Config.getDelayModifier(config, Type.Diamond.getName(), 10);
    DELAY_MODIFIER[Type.Gold.getMeta()] = Config.getDelayModifier(config, Type.Gold.getName(), 40);
  }

  private static int getCapacity(
      Configuration config,
      String name,
      int defaultValue
  ) {

    return config.getInt(name, CATEGORY_ITEM_WATERCAN_CAPACITY, defaultValue, 0, Short.MAX_VALUE, "");
  }

  private static int getRange(
      Configuration config,
      String name,
      int defaultValue
  ) {

    return config.getInt(name, CATEGORY_ITEM_WATERCAN_RANGE, defaultValue, 0, 8, "");
  }

  private static int getFlowerChance(
      Configuration config,
      String name,
      int defaultValue
  ) {

    return config.getInt(name, CATEGORY_ITEM_WATERCAN_FLOWER, defaultValue, 0, 100, "");
  }

  private static int getDelayModifier(
      Configuration config,
      String name,
      int defaultValue
  ) {

    return config.getInt(name, CATEGORY_ITEM_WATERCAN_DELAY_MODIFIER, defaultValue, 1, 40, "");
  }

  private static boolean getConsumeWaterSource(
      Configuration config,
      String name,
      boolean defaultValue
  ) {

    return config.getBoolean(name, CATEGORY_ITEM_WATERCAN_CONSUME_WATER_SOURCE, defaultValue, "");
  }
}
