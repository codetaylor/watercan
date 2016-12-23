package com.sudoplay.mc.korwatercan.module.watercan.recipe;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.recipe.RecipeFile;
import com.sudoplay.mc.kor.core.recipe.RecipeFileParseResults;
import com.sudoplay.mc.kor.core.recipe.RecipeFileParser;
import com.sudoplay.mc.kor.core.recipe.exception.RecipeItemNotFoundInRegistryException;
import com.sudoplay.mc.kor.core.recipe.furnace.RecipeFurnaceParseResults;
import com.sudoplay.mc.kor.core.recipe.furnace.RecipeFurnaceRegistrationDelegate;
import com.sudoplay.mc.kor.core.recipe.shaped.RecipeShapedParseResults;
import com.sudoplay.mc.kor.core.recipe.shaped.RecipeShapedRegistrationDelegate;
import com.sudoplay.mc.kor.core.recipe.shapeless.RecipeShapelessParseResults;
import com.sudoplay.mc.kor.core.recipe.shapeless.RecipeShapelessRegistrationDelegate;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeFileRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.registry.strategy.KorInitStrategy;
import com.sudoplay.mc.korwatercan.module.watercan.ModuleWaterCan;

import java.util.List;

/**
 * Created by codetaylor on 12/8/2016.
 */
public class RecipeRegistrationDelegate extends
    KorRecipeFileRegistrationDelegate {

  private RecipeFile recipeFile;
  private RecipeShapelessRegistrationDelegate recipeShapelessRegistrationDelegate;
  private RecipeShapedRegistrationDelegate recipeShapedRegistrationDelegate;
  private RecipeFurnaceRegistrationDelegate recipeFurnaceRegistrationDelegate;

  private TextConfigData textConfigData;

  @KorInject
  public RecipeRegistrationDelegate(
      @KorJsonConfig(file = "recipes.json") Recipes recipeFile,
      @KorTextConfig(file = ModuleWaterCan.Config.FILENAME) TextConfigData textConfigData
  ) {
    super(recipeFile);
    this.recipeFile = recipeFile;
    this.recipeShapelessRegistrationDelegate = new RecipeShapelessRegistrationDelegate();
    this.recipeShapedRegistrationDelegate = new RecipeShapedRegistrationDelegate();
    this.recipeFurnaceRegistrationDelegate = new RecipeFurnaceRegistrationDelegate();

    this.textConfigData = textConfigData;
  }

  @Override
  public KorInitStrategy getInitStrategy() {
    return kor -> {
      RecipeFileParser recipeFileParser = kor.getRecipeFileParser();
      RecipeFileParseResults recipeFileParseResults = recipeFileParser.parseRecipeFile(this.recipeFile);

      List<RecipeShapelessParseResults> shapelessParseResultsList = recipeFileParseResults.getShapelessParseResultsList();

      for (RecipeShapelessParseResults results : shapelessParseResultsList) {

        try {
          String key = results.getName().replace("watercan_", "");
          Integer capacity = this.textConfigData.getCategory(ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_CAPACITY).getInteger(key);
          results.getOutputParseResult().setMeta(capacity);
          this.recipeShapelessRegistrationDelegate.registerShapelessRecipe(results);

        } catch (RecipeItemNotFoundInRegistryException e) {
          kor.getLoggerService().error(String.format("Failed to register shapeless recipe [%s]", results.getName()), e);
        }
      }

      List<RecipeShapedParseResults> shapedParseResultsList = recipeFileParseResults.getShapedParseResultsList();

      for (RecipeShapedParseResults results : shapedParseResultsList) {

        try {
          String key = results.getName().replace("watercan_", "");
          Integer capacity = this.textConfigData.getCategory(ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_CAPACITY).getInteger(key);
          results.getOutputParseResult().setMeta(capacity);
          this.recipeShapedRegistrationDelegate.registerShapedRecipe(results);

        } catch (RecipeItemNotFoundInRegistryException e) {
          kor.getLoggerService().error(String.format("Failed to register shaped recipe [%s]", results.getName()), e);
        }
      }

      List<RecipeFurnaceParseResults> furnaceParseResultsList = recipeFileParseResults.getFurnaceParseResultsList();

      for (RecipeFurnaceParseResults results : furnaceParseResultsList) {

        try {
          String key = results.getName().replace("watercan_", "");
          Integer capacity = this.textConfigData.getCategory(ModuleWaterCan.Config.CATEGORY_ITEM_WATERCAN_CAPACITY).getInteger(key);
          results.getOutputParseResult().setMeta(capacity);
          this.recipeFurnaceRegistrationDelegate.registerFurnaceRecipe(results);

        } catch (RecipeItemNotFoundInRegistryException e) {
          kor.getLoggerService().error(String.format("Failed to register furnace recipe [%s]", results.getName()), e);
        }
      }
    };
  }
}
