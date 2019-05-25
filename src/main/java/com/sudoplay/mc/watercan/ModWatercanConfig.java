package com.sudoplay.mc.watercan;

import net.minecraftforge.common.config.Config;

@Config(modid = ModWatercan.MOD_ID)
public class ModWatercanConfig {

  public static Client CLIENT = new Client();

  public static class Client {

    @Config.Comment({
        "Set to false to disable client-side particle display when watering."
    })
    public boolean SPAWN_WATER_PARTICLES = true;
  }

  public static WatercanWood WATERCAN_WOOD = new WatercanWood();

  public static class WatercanWood {

    @Config.Comment({
        "If true, the watercan can be used in a dispenser.",
        "Default: " + true
    })
    public boolean IS_DISPENSABLE = true;

    @Config.Comment({
        "Defines the capacity of the watercan in millibuckets.",
        "Set to zero to make the can never run out of water.",
        "Range: [0,2147483647]",
        "Default: " + 1000
    })
    @Config.RequiresMcRestart
    public int CAPACITY = 1000;

    @Config.Comment({
        "Defines the range of the watercan.",
        "This is the radius that the water will spread out from the targeted block.",
        "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area.",
        "Range: [0,8]",
        "Default: " + 0
    })
    public int RANGE = 0;

    @Config.Comment({
        "The flower chance controls the spawn rate of flowers on watered grass blocks.",
        "The higher the number the higher the chance to spawn flowers while watering.",
        "Range: [0,100]",
        "Default: " + 0
    })
    public int FLOWER_CHANCE = 0;

    @Config.Comment({
        "Use the delay modifier to speed up or slow down growth.",
        "Smaller is faster.",
        "Range: [1,40]",
        "Default: " + 5
    })
    public int DELAY_MODIFIER = 5;

    @Config.Comment({
        "Set to true to consume the water source block when filling the watercan.",
        "Default: " + false
    })
    public boolean CONSUME_WATER_SOURCE = false;

    @Config.Comment({
        "Set to false to prevent the watercan from extinguishing fire.",
        "Default: " + true
    })
    public boolean EXTINGUISH_FIRE = true;

    @Config.Comment({
        "Set to false to prevent the watercan from moisturizing farmland.",
        "Default: " + true
    })
    public boolean MOISTURIZE_FARMLAND = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spawning flowers on grass.",
        "Default: " + true
    })
    public boolean SPAWN_FLOWERS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing crops / growables.",
        "Default: " + true
    })
    public boolean GROW_CROPS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing saplings.",
        "Default: " + true
    })
    public boolean GROW_SAPLINGS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading grass.",
        "Default: " + true
    })
    public boolean SPREAD_GRASS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading mycelium.",
        "Default: " + true
    })
    public boolean SPREAD_MYCELIUM = true;
  }

  public static WatercanStone WATERCAN_STONE = new WatercanStone();

  public static class WatercanStone {

    @Config.Comment({
        "If true, the watercan can be used in a dispenser.",
        "Default: " + true
    })
    public boolean IS_DISPENSABLE = true;

    @Config.Comment({
        "Defines the capacity of the watercan in millibuckets.",
        "Set to zero to make the can never run out of water.",
        "Range: [0,2147483647]",
        "Default: " + 2000
    })
    @Config.RequiresMcRestart
    public int CAPACITY = 2000;

    @Config.Comment({
        "Defines the range of the watercan.",
        "This is the radius that the water will spread out from the targeted block.",
        "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area.",
        "Range: [0,8]",
        "Default: " + 1
    })
    public int RANGE = 1;

    @Config.Comment({
        "The flower chance controls the spawn rate of flowers on watered grass blocks.",
        "The higher the number the higher the chance to spawn flowers while watering.",
        "Range: [0,100]",
        "Default: " + 1
    })
    public int FLOWER_CHANCE = 1;

    @Config.Comment({
        "Use the delay modifier to speed up or slow down growth.",
        "Smaller is faster.",
        "Range: [1,40]",
        "Default: " + 15
    })
    public int DELAY_MODIFIER = 15;

    @Config.Comment({
        "Set to true to consume the water source block when filling the watercan.",
        "Default: " + false
    })
    public boolean CONSUME_WATER_SOURCE = false;

    @Config.Comment({
        "Set to false to prevent the watercan from extinguishing fire.",
        "Default: " + true
    })
    public boolean EXTINGUISH_FIRE = true;

    @Config.Comment({
        "Set to false to prevent the watercan from moisturizing farmland.",
        "Default: " + true
    })
    public boolean MOISTURIZE_FARMLAND = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spawning flowers on grass.",
        "Default: " + true
    })
    public boolean SPAWN_FLOWERS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing crops / growables.",
        "Default: " + true
    })
    public boolean GROW_CROPS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing saplings.",
        "Default: " + true
    })
    public boolean GROW_SAPLINGS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading grass.",
        "Default: " + true
    })
    public boolean SPREAD_GRASS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading mycelium.",
        "Default: " + true
    })
    public boolean SPREAD_MYCELIUM = true;
  }

  public static WatercanIron WATERCAN_IRON = new WatercanIron();

  public static class WatercanIron {

    @Config.Comment({
        "If true, the watercan can be used in a dispenser.",
        "Default: " + true
    })
    public boolean IS_DISPENSABLE = true;

    @Config.Comment({
        "Defines the capacity of the watercan in millibuckets.",
        "Set to zero to make the can never run out of water.",
        "Range: [0,2147483647]",
        "Default: " + 4000
    })
    @Config.RequiresMcRestart
    public int CAPACITY = 4000;

    @Config.Comment({
        "Defines the range of the watercan.",
        "This is the radius that the water will spread out from the targeted block.",
        "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area.",
        "Range: [0,8]",
        "Default: " + 1
    })
    public int RANGE = 1;

    @Config.Comment({
        "The flower chance controls the spawn rate of flowers on watered grass blocks.",
        "The higher the number the higher the chance to spawn flowers while watering.",
        "Range: [0,100]",
        "Default: " + 1
    })
    public int FLOWER_CHANCE = 1;

    @Config.Comment({
        "Use the delay modifier to speed up or slow down growth.",
        "Smaller is faster.",
        "Range: [1,40]",
        "Default: " + 10
    })
    public int DELAY_MODIFIER = 10;

    @Config.Comment({
        "Set to true to consume the water source block when filling the watercan.",
        "Default: " + false
    })
    public boolean CONSUME_WATER_SOURCE = false;

    @Config.Comment({
        "Set to false to prevent the watercan from extinguishing fire.",
        "Default: " + true
    })
    public boolean EXTINGUISH_FIRE = true;

    @Config.Comment({
        "Set to false to prevent the watercan from moisturizing farmland.",
        "Default: " + true
    })
    public boolean MOISTURIZE_FARMLAND = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spawning flowers on grass.",
        "Default: " + true
    })
    public boolean SPAWN_FLOWERS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing crops / growables.",
        "Default: " + true
    })
    public boolean GROW_CROPS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing saplings.",
        "Default: " + true
    })
    public boolean GROW_SAPLINGS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading grass.",
        "Default: " + true
    })
    public boolean SPREAD_GRASS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading mycelium.",
        "Default: " + true
    })
    public boolean SPREAD_MYCELIUM = true;
  }

  public static WatercanGold WATERCAN_GOLD = new WatercanGold();

  public static class WatercanGold {

    @Config.Comment({
        "If true, the watercan can be used in a dispenser.",
        "Default: " + true
    })
    public boolean IS_DISPENSABLE = true;

    @Config.Comment({
        "Defines the capacity of the watercan in millibuckets.",
        "Set to zero to make the can never run out of water.",
        "Range: [0,2147483647]",
        "Default: " + 4000
    })
    @Config.RequiresMcRestart
    public int CAPACITY = 4000;

    @Config.Comment({
        "Defines the range of the watercan.",
        "This is the radius that the water will spread out from the targeted block.",
        "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area.",
        "Range: [0,8]",
        "Default: " + 1
    })
    public int RANGE = 1;

    @Config.Comment({
        "The flower chance controls the spawn rate of flowers on watered grass blocks.",
        "The higher the number the higher the chance to spawn flowers while watering.",
        "Range: [0,100]",
        "Default: " + 50
    })
    public int FLOWER_CHANCE = 50;

    @Config.Comment({
        "Use the delay modifier to speed up or slow down growth.",
        "Smaller is faster.",
        "Range: [1,40]",
        "Default: " + 5
    })
    public int DELAY_MODIFIER = 40;

    @Config.Comment({
        "Set to true to consume the water source block when filling the watercan.",
        "Default: " + false
    })
    public boolean CONSUME_WATER_SOURCE = false;

    @Config.Comment({
        "Set to false to prevent the watercan from extinguishing fire.",
        "Default: " + true
    })
    public boolean EXTINGUISH_FIRE = true;

    @Config.Comment({
        "Set to false to prevent the watercan from moisturizing farmland.",
        "Default: " + true
    })
    public boolean MOISTURIZE_FARMLAND = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spawning flowers on grass.",
        "Default: " + true
    })
    public boolean SPAWN_FLOWERS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing crops / growables.",
        "Default: " + true
    })
    public boolean GROW_CROPS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing saplings.",
        "Default: " + true
    })
    public boolean GROW_SAPLINGS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading grass.",
        "Default: " + true
    })
    public boolean SPREAD_GRASS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading mycelium.",
        "Default: " + true
    })
    public boolean SPREAD_MYCELIUM = true;
  }

  public static WatercanDiamond WATERCAN_DIAMOND = new WatercanDiamond();

  public static class WatercanDiamond {

    @Config.Comment({
        "If true, the watercan can be used in a dispenser.",
        "Default: " + true
    })
    public boolean IS_DISPENSABLE = true;

    @Config.Comment({
        "Defines the capacity of the watercan in millibuckets.",
        "Set to zero to make the can never run out of water.",
        "Range: [0,2147483647]",
        "Default: " + 0
    })
    @Config.RequiresMcRestart
    public int CAPACITY = 0;

    @Config.Comment({
        "Defines the range of the watercan.",
        "This is the radius that the water will spread out from the targeted block.",
        "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area.",
        "Range: [0,8]",
        "Default: " + 2
    })
    public int RANGE = 2;

    @Config.Comment({
        "The flower chance controls the spawn rate of flowers on watered grass blocks.",
        "The higher the number the higher the chance to spawn flowers while watering.",
        "Range: [0,100]",
        "Default: " + 2
    })
    public int FLOWER_CHANCE = 2;

    @Config.Comment({
        "Use the delay modifier to speed up or slow down growth.",
        "Smaller is faster.",
        "Range: [1,40]",
        "Default: " + 5
    })
    public int DELAY_MODIFIER = 10;

    @Config.Comment({
        "Set to true to consume the water source block when filling the watercan.",
        "Default: " + false
    })
    public boolean CONSUME_WATER_SOURCE = false;

    @Config.Comment({
        "Set to false to prevent the watercan from extinguishing fire.",
        "Default: " + true
    })
    public boolean EXTINGUISH_FIRE = true;

    @Config.Comment({
        "Set to false to prevent the watercan from moisturizing farmland.",
        "Default: " + true
    })
    public boolean MOISTURIZE_FARMLAND = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spawning flowers on grass.",
        "Default: " + true
    })
    public boolean SPAWN_FLOWERS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing crops / growables.",
        "Default: " + true
    })
    public boolean GROW_CROPS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from growing saplings.",
        "Default: " + true
    })
    public boolean GROW_SAPLINGS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading grass.",
        "Default: " + true
    })
    public boolean SPREAD_GRASS = true;

    @Config.Comment({
        "Set to false to prevent the watercan from spreading mycelium.",
        "Default: " + true
    })
    public boolean SPREAD_MYCELIUM = true;
  }

}
