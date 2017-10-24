package com.sudoplay.mc.ctwatercan.items.watercan;

import net.minecraft.world.World;

/**
 * Created by codetaylor on 11/27/2016.
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
