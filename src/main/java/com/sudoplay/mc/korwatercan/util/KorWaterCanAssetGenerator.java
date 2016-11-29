package com.sudoplay.mc.korwatercan.util;

import com.sudoplay.mc.kor.core.generation.AssetGenerator;
import com.sudoplay.mc.kor.spi.util.FileUtils;
import com.sudoplay.mc.korwatercan.module.watercan.ModuleWaterCan;

import java.io.File;
import java.io.IOException;

/**
 * Created by codetaylor on 11/24/2016.
 */
public class KorWaterCanAssetGenerator {

  public static void main(String... args) {

    File assetRoot = new File("subprojects/kor-watercan/src/main/resources/assets/ctkorwatercan");

    try {
      FileUtils.delete(assetRoot, System.out::println);

    } catch (IOException e) {
      e.printStackTrace();
    }

    AssetGenerator generator = new AssetGenerator(
        "subprojects/kor-watercan/assets",
        "subprojects/kor-watercan/src/main/resources/assets/ctkorwatercan"
    );

    generator.generate(
        new ModuleWaterCan()
    );
  }
}
