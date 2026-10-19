/*    */ package sfiomn.legendarysurvivaloverhaul.common.level.gen;
/*    */ import java.util.List;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.HolderGetter;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.data.worldgen.BootstrapContext;
/*    */ import net.minecraft.data.worldgen.placement.PlacementUtils;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.util.valueproviders.UniformInt;
/*    */ import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
/*    */ import net.minecraft.world.level.levelgen.placement.CountPlacement;
/*    */ import net.minecraft.world.level.levelgen.placement.PlacedFeature;
/*    */ import net.minecraft.world.level.levelgen.placement.PlacementModifier;
/*    */ import net.minecraft.world.level.levelgen.placement.RarityFilter;
/*    */ 
/*    */ public class ModPlacedFeatures {
/* 18 */   public static final ResourceKey<PlacedFeature> ICE_FERN_PLACED_KEY = registerKey("ice_fern_placed");
/* 19 */   public static final ResourceKey<PlacedFeature> SUN_FERN_PLACED_KEY = registerKey("sun_fern_placed");
/* 20 */   public static final ResourceKey<PlacedFeature> WATER_PLANT_PLACED_KEY = registerKey("water_plant_placed");
/*    */ 
/*    */   
/*    */   public static ResourceKey<PlacedFeature> registerKey(String name) {
/* 24 */     return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", name));
/*    */   }
/*    */ 
/*    */   
/*    */   public static List<PlacementModifier> worldSurfaceWithCountAndChance(int minCount, int maxCount, int chanceOnceEvery) {
/* 29 */     return (List)List.of(
/* 30 */         RarityFilter.onAverageOnceEvery(chanceOnceEvery), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, 
/*    */         
/* 32 */         BiomeFilter.biome(), 
/* 33 */         CountPlacement.of((IntProvider)UniformInt.of(minCount, maxCount)));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void bootstrap(BootstrapContext<PlacedFeature> context) {
/* 38 */     HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
/*    */     
/* 40 */     PlacementUtils.register(context, ICE_FERN_PLACED_KEY, (Holder)configuredFeatures
/*    */         
/* 42 */         .getOrThrow(ModConfiguredFeatures.ICE_FERN_CONFIG_KEY), 
/* 43 */         worldSurfaceWithCountAndChance(4, 7, 20));
/*    */     
/* 45 */     PlacementUtils.register(context, SUN_FERN_PLACED_KEY, (Holder)configuredFeatures
/*    */         
/* 47 */         .getOrThrow(ModConfiguredFeatures.SUN_FERN_CONFIG_KEY), 
/* 48 */         worldSurfaceWithCountAndChance(4, 7, 20));
/*    */     
/* 50 */     PlacementUtils.register(context, WATER_PLANT_PLACED_KEY, (Holder)configuredFeatures
/*    */         
/* 52 */         .getOrThrow(ModConfiguredFeatures.WATER_PLANT_CONFIG_KEY), 
/* 53 */         worldSurfaceWithCountAndChance(3, 5, 20));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\level\gen\ModPlacedFeatures.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */