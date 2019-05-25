package com.sudoplay.mc.watercan.modules.watercan;

import com.codetaylor.mc.athenaeum.module.ModuleBase;
import com.codetaylor.mc.athenaeum.network.IPacketRegistry;
import com.codetaylor.mc.athenaeum.network.IPacketService;
import com.codetaylor.mc.athenaeum.registry.Registry;
import com.sudoplay.mc.watercan.ModWatercan;
import com.sudoplay.mc.watercan.modules.watercan.init.ModuleItems;
import com.sudoplay.mc.watercan.modules.watercan.item.*;
import com.sudoplay.mc.watercan.modules.watercan.network.SCPacketDispenseWatercan;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.RegistryDefaulted;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import static com.sudoplay.mc.watercan.ModWatercan.CREATIVE_TAB;

public class ModuleWatercan
    extends ModuleBase {

  public static final String MOD_ID = ModWatercan.MOD_ID;

  public static IPacketService PACKET_SERVICE;

  public ModuleWatercan() {

    super(0, MOD_ID);

    this.setRegistry(new Registry(MOD_ID, CREATIVE_TAB));
    this.enableAutoRegistry();

    PACKET_SERVICE = this.enableNetwork();
  }

  @Override
  public void onInitializationEvent(FMLInitializationEvent event) {

    super.onInitializationEvent(event);

    RegistryDefaulted<Item, IBehaviorDispenseItem> registry = BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY;
    ItemWaterCanBase.DispenserBehavior behavior = new ItemWaterCanBase.DispenserBehavior();
    registry.putObject(Items.WATERCAN_DIAMOND, behavior);
    registry.putObject(Items.WATERCAN_GOLD, behavior);
    registry.putObject(Items.WATERCAN_IRON, behavior);
    registry.putObject(Items.WATERCAN_STONE, behavior);
    registry.putObject(Items.WATERCAN_WOOD, behavior);
  }

  @Override
  public void onRegister(Registry registry) {

    ModuleItems.onRegister(registry);
  }

  @Override
  public void onClientRegister(Registry registry) {

    ModuleItems.onClientRegister(registry);
  }

  @Override
  public void onNetworkRegister(IPacketRegistry registry) {

    registry.register(SCPacketDispenseWatercan.class, SCPacketDispenseWatercan.class, Side.CLIENT);
  }

  @GameRegistry.ObjectHolder(ModWatercan.MOD_ID)
  public static final class Items {

    @GameRegistry.ObjectHolder(ItemWatercanDiamond.NAME)
    public static final ItemWatercanDiamond WATERCAN_DIAMOND;

    @GameRegistry.ObjectHolder(ItemWatercanGold.NAME)
    public static final ItemWatercanGold WATERCAN_GOLD;

    @GameRegistry.ObjectHolder(ItemWatercanIron.NAME)
    public static final ItemWatercanIron WATERCAN_IRON;

    @GameRegistry.ObjectHolder(ItemWatercanStone.NAME)
    public static final ItemWatercanStone WATERCAN_STONE;

    @GameRegistry.ObjectHolder(ItemWatercanWood.NAME)
    public static final ItemWatercanWood WATERCAN_WOOD;

    static {
      WATERCAN_DIAMOND = null;
      WATERCAN_GOLD = null;
      WATERCAN_IRON = null;
      WATERCAN_STONE = null;
      WATERCAN_WOOD = null;
    }
  }
}
