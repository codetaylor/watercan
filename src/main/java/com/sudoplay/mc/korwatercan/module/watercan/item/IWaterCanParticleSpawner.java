package com.sudoplay.mc.korwatercan.module.watercan.item;

import net.minecraft.world.World;

/**
 * Created by sk3lls on 11/27/2016.
 */
/* package */ interface IWaterCanParticleSpawner {

  IWaterCanParticleSpawner NO_OP = (world, x, y, z, range) -> {
    //
  };

  void spawnParticles(
      World world,
      double x,
      double y,
      double z,
      int range
  );
}
