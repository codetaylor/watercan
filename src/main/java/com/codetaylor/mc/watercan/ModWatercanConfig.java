package com.codetaylor.mc.watercan;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

@Mod.EventBusSubscriber(modid = ModWatercan.MOD_ID)
public class ModWatercanConfig {

  public static void loadConfig(ForgeConfigSpec spec, Path path) {

    final CommentedFileConfig configData = CommentedFileConfig.builder(path)
        .sync()
        .autosave()
        .writingMode(WritingMode.REPLACE)
        .build();

    configData.load();
    spec.setConfig(configData);
  }

  @SubscribeEvent
  public static void onLoad(final ModConfig.Loading configEvent) {
    //
  }

  @SubscribeEvent
  public static void onReload(final ModConfig.ConfigReloading configEvent) {
    //
  }

  // ---------------------------------------------------------------------------
  // - Client Config
  // ---------------------------------------------------------------------------

  public static ForgeConfigSpec CLIENT_CONFIG;

  public static Client CLIENT;

  static {
    ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    CLIENT = new Client(builder);
    CLIENT_CONFIG = builder.build();
  }

  public static class Client {

    public final ForgeConfigSpec.BooleanValue spawnWaterParticles;

    public Client(ForgeConfigSpec.Builder builder) {

      builder.push("client");
      this.spawnWaterParticles = builder
          .comment(
              "Set to false to disable client-side particle display when watering.",
              "Default: " + true
          )
          .define("spawnWaterParticles", true);
      builder.pop();
    }
  }

  // ---------------------------------------------------------------------------
  // - Common Config
  // ---------------------------------------------------------------------------

  public static ForgeConfigSpec COMMON_CONFIG;

  public static Watercan WOODEN_WATERCAN;
  public static Watercan STONE_WATERCAN;
  public static Watercan IRON_WATERCAN;
  public static Watercan GOLD_WATERCAN;
  public static Watercan DIAMOND_WATERCAN;

  static {
    ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    WOODEN_WATERCAN = new Watercan(
        builder,
        "wooden_watercan",
        true,
        1000,
        0,
        0,
        5,
        false,
        true,
        true,
        true,
        true,
        true,
        true,
        true
    );
    STONE_WATERCAN = new Watercan(
        builder,
        "stone_watercan",
        true,
        2000,
        1,
        1,
        15,
        false,
        true,
        true,
        true,
        true,
        true,
        true,
        true
    );
    IRON_WATERCAN = new Watercan(
        builder,
        "iron_watercan",
        true,
        4000,
        1,
        1,
        10,
        false,
        true,
        true,
        true,
        true,
        true,
        true,
        true
    );
    GOLD_WATERCAN = new Watercan(
        builder,
        "gold_watercan",
        true,
        4000,
        1,
        50,
        40,
        false,
        true,
        true,
        true,
        true,
        true,
        true,
        true
    );
    DIAMOND_WATERCAN = new Watercan(
        builder,
        "diamond_watercan",
        true,
        0,
        2,
        2,
        10,
        false,
        true,
        true,
        true,
        true,
        true,
        true,
        true
    );
    COMMON_CONFIG = builder.build();
  }

  public static class Watercan {

    public final ForgeConfigSpec.BooleanValue isDispensable;
    public final ForgeConfigSpec.IntValue capacity;
    public final ForgeConfigSpec.IntValue range;
    public final ForgeConfigSpec.IntValue flowerChance;
    public final ForgeConfigSpec.IntValue delayModifier;
    public final ForgeConfigSpec.BooleanValue consumeWaterSource;
    public final ForgeConfigSpec.BooleanValue extinguishFire;
    public final ForgeConfigSpec.BooleanValue moisturizeFarmland;
    public final ForgeConfigSpec.BooleanValue spawnFlowers;
    public final ForgeConfigSpec.BooleanValue growCrops;
    public final ForgeConfigSpec.BooleanValue growSaplings;
    public final ForgeConfigSpec.BooleanValue spreadGrass;
    public final ForgeConfigSpec.BooleanValue spreadMycelium;

    public Watercan(
        ForgeConfigSpec.Builder builder,
        String category,
        boolean isDispensable,
        int capacity,
        int range,
        int flowerChance,
        int delayModifier,
        boolean consumeWaterSource,
        boolean extinguishFire,
        boolean moisturizeFarmland,
        boolean spawnFlowers,
        boolean growCrops,
        boolean growSaplings,
        boolean spreadGrass,
        boolean spreadMycelium
    ) {

      builder.push(category);
      this.isDispensable = builder
          .comment(
              "If true, the watercan can be used in a dispenser.",
              "Default: " + isDispensable
          )
          .define("isDispensable", true);
      this.capacity = builder
          .comment(
              "Defines the capacity of the watercan in millibuckets.",
              "Set to zero to make the can never run out of water.",
              "Default: " + capacity
          )
          .defineInRange("capacity", capacity, 0, Short.MAX_VALUE);
      this.range = builder
          .comment(
              "Defines the range of the watercan.",
              "This is the radius that the water will spread out from the targeted block.",
              "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area.",
              "Default: " + range
          )
          .defineInRange("range", range, 0, 8);
      this.flowerChance = builder
          .comment(
              "Defines the range of the watercan.",
              "This is the radius that the water will spread out from the targeted block.",
              "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area.",
              "Default: " + flowerChance
          )
          .defineInRange("flowerChance", flowerChance, 0, 100);
      this.delayModifier = builder
          .comment(
              "Use the delay modifier to speed up or slow down growth.",
              "Smaller is faster.",
              "Default: " + delayModifier
          )
          .defineInRange("delayModifier", delayModifier, 1, 40);
      this.consumeWaterSource = builder
          .comment(
              "Set to true to consume the water source block when filling the watercan.",
              "Default: " + consumeWaterSource
          )
          .define("consumeWaterSource", consumeWaterSource);
      this.extinguishFire = builder
          .comment(
              "Set to false to prevent the watercan from extinguishing fire.",
              "Default: " + extinguishFire
          )
          .define("extinguishFire", extinguishFire);
      this.moisturizeFarmland = builder
          .comment(
              "Set to false to prevent the watercan from moisturizing farmland.",
              "Default: " + moisturizeFarmland
          )
          .define("moisturizeFarmland", moisturizeFarmland);
      this.spawnFlowers = builder
          .comment(
              "Set to false to prevent the watercan from spawning flowers on grass.",
              "Default: " + spawnFlowers
          )
          .define("spawnFlowers", spawnFlowers);
      this.growCrops = builder
          .comment(
              "Set to false to prevent the watercan from growing crops / growables.",
              "Default: " + growCrops
          )
          .define("growCrops", growCrops);
      this.growSaplings = builder
          .comment(
              "Set to false to prevent the watercan from growing saplings.",
              "Default: " + growSaplings
          )
          .define("growSaplings", growSaplings);
      this.spreadGrass = builder
          .comment(
              "Set to false to prevent the watercan from spreading grass.",
              "Default: " + spreadGrass
          )
          .define("spreadGrass", spreadGrass);
      this.spreadMycelium = builder
          .comment(
              "Set to false to prevent the watercan from spreading mycelium.",
              "Default: " + spreadMycelium
          )
          .define("spreadMycelium", spreadMycelium);
      builder.pop();
    }
  }

}
