package com.sudoplay.mc.korwatercan.module.watercan.recipe;

import com.sudoplay.mc.kor.core.recipe.RecipeFile;
import com.sudoplay.mc.kor.core.recipe.shaped.RecipeShaped;
import com.sudoplay.mc.korwatercan.KorWaterCan;

/**
 * Created by codetaylor on 12/8/2016.
 */
public class Recipes extends
    RecipeFile {

  public Recipes() {

    this.recipeShapedMap.put("watercan_wood", new RecipeShaped(
        KorWaterCan.MOD_ID + ":watercan_wood",
        new String[]{
            "ore:plankWood, null, null",
            "ore:plankWood, minecraft:bowl, ore:plankWood",
            "null, ore:plankWood, null"
        }
    ));

    this.recipeShapedMap.put("watercan_stone", new RecipeShaped(
        KorWaterCan.MOD_ID + ":watercan_stone",
        new String[]{
            "minecraft:stone, null, null",
            "minecraft:stone, minecraft:bowl, minecraft:stone",
            "null, minecraft:stone, null"
        }
    ));

    this.recipeShapedMap.put("watercan_iron", new RecipeShaped(
        KorWaterCan.MOD_ID + ":watercan_iron",
        new String[]{
            "minecraft:ingot_iron, null, null",
            "minecraft:ingot_iron, minecraft:bowl, minecraft:ingot_iron",
            "null, minecraft:ingot_iron, null"
        }
    ));

    this.recipeShapedMap.put("watercan_diamond", new RecipeShaped(
        KorWaterCan.MOD_ID + ":watercan_diamond",
        new String[]{
            "minecraft:diamond, null, null",
            "minecraft:diamond, minecraft:bowl, minecraft:diamond",
            "null, minecraft:diamond, null"
        }
    ));
  }
}
