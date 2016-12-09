package com.sudoplay.mc.korwatercan.module.watercan.recipe;

import com.sudoplay.mc.kor.spi.recipe.KorRecipeFileRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;

/**
 * Created by codetaylor on 12/8/2016.
 */
public class RecipeRegistrationDelegate extends
    KorRecipeFileRegistrationDelegate {

  @KorInject
  public RecipeRegistrationDelegate(
      @KorJsonConfig(file = "recipes.json") Recipes recipeFile
  ) {
    super(recipeFile);
  }
}
