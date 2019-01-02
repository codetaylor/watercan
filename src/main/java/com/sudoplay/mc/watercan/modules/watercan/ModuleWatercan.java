package com.sudoplay.mc.watercan.modules.watercan;

import com.codetaylor.mc.athenaeum.module.ModuleBase;
import com.codetaylor.mc.athenaeum.registry.Registry;
import com.sudoplay.mc.watercan.ModWatercan;
import com.sudoplay.mc.watercan.modules.watercan.init.ModuleItems;

import static com.sudoplay.mc.watercan.ModWatercan.CREATIVE_TAB;

public class ModuleWatercan
    extends ModuleBase {

  public static final String MOD_ID = ModWatercan.MOD_ID;

  public ModuleWatercan() {

    super(0, MOD_ID);

    this.setRegistry(new Registry(MOD_ID, CREATIVE_TAB));
    this.enableAutoRegistry();
  }

  @Override
  public void onRegister(Registry registry) {

    ModuleItems.onRegister(registry);
  }

  @Override
  public void onClientRegister(Registry registry) {

    ModuleItems.onClientRegister(registry);
  }
}
