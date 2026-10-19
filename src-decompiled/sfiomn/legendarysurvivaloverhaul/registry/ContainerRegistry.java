/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.inventory.MenuType;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
/*    */ import net.neoforged.neoforge.network.IContainerFactory;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.containers.CoolerContainer;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.containers.HeaterContainer;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.containers.SewingTableContainer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerRegistry
/*    */ {
/* 18 */   public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(Registries.MENU, "legendarysurvivaloverhaul");
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 22 */     CONTAINERS.register(eventBus);
/* 23 */   } public static final DeferredHolder<MenuType<?>, MenuType<CoolerContainer>> COOLER_CONTAINER = CONTAINERS
/* 24 */     .register("cooler_container", () -> IMenuTypeExtension.create(CoolerContainer::new));
/*    */   
/* 26 */   public static final DeferredHolder<MenuType<?>, MenuType<HeaterContainer>> HEATER_CONTAINER = CONTAINERS
/* 27 */     .register("heater_container", () -> IMenuTypeExtension.create(HeaterContainer::new));
/*    */   
/* 29 */   public static final DeferredHolder<MenuType<?>, MenuType<SewingTableContainer>> SEWING_TABLE_CONTAINER = CONTAINERS
/* 30 */     .register("sewing_table_container", () -> IMenuTypeExtension.create(SewingTableContainer::new));
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\ContainerRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */