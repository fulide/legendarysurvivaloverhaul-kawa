/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.level.levelgen.feature.Feature;
/*    */ import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.level.feature.DoubleBlockFeature;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.level.feature.GoldFernFeature;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FeatureRegistry
/*    */ {
/* 16 */   public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, "legendarysurvivaloverhaul");
/*    */   
/* 18 */   public static final DeferredHolder<Feature<?>, DoubleBlockFeature> DOUBLE_BLOCK = FEATURES.register("double_block", () -> new DoubleBlockFeature(SimpleBlockConfiguration.CODEC));
/* 19 */   public static final DeferredHolder<Feature<?>, GoldFernFeature> GOLD_FERN = FEATURES.register("gold_fern", () -> new GoldFernFeature(SimpleBlockConfiguration.CODEC));
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 23 */     FEATURES.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\FeatureRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */