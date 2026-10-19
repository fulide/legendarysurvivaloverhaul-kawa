/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.entity.BlockEntityType;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blockentities.CoolerBlockEntity;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blockentities.HeaterBlockEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockEntityRegistry
/*    */ {
/* 16 */   public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "legendarysurvivaloverhaul");
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 20 */     BLOCK_ENTITIES.register(eventBus);
/* 21 */   } public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HeaterBlockEntity>> HEATER_BLOCK_ENTITY = BLOCK_ENTITIES
/* 22 */     .register("heater", () -> BlockEntityType.Builder.of(HeaterBlockEntity::new, new Block[] { (Block)BlockRegistry.HEATER.get() }).build(null));
/*    */ 
/*    */   
/* 25 */   public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CoolerBlockEntity>> COOLER_BLOCK_ENTITY = BLOCK_ENTITIES
/* 26 */     .register("cooler", () -> BlockEntityType.Builder.of(CoolerBlockEntity::new, new Block[] { (Block)BlockRegistry.COOLER.get() }).build(null));
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\BlockEntityRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */