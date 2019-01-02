package com.sudoplay.mc.watercan.modules.watercan.client;

import net.minecraft.world.World;

public interface IWaterCanParticleSpawner {

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
