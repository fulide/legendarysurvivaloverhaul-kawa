/*    */ package sfiomn.legendarysurvivaloverhaul.common.level.gen;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.HolderGetter;
/*    */ import net.minecraft.core.HolderSet;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.data.worldgen.BootstrapContext;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.level.biome.Biome;
/*    */ import net.minecraft.world.level.levelgen.GenerationStep;
/*    */ import net.minecraft.world.level.levelgen.placement.PlacedFeature;
/*    */ import net.neoforged.neoforge.common.Tags;
/*    */ import net.neoforged.neoforge.common.world.BiomeModifier;
/*    */ import net.neoforged.neoforge.common.world.BiomeModifiers;
/*    */ import net.neoforged.neoforge.registries.NeoForgeRegistries;
/*    */ 
/*    */ public class ModBiomeModifiers {
/* 18 */   public static final ResourceKey<BiomeModifier> ADD_ICE_FERN = registerKey("add_ice_fern");
/* 19 */   public static final ResourceKey<BiomeModifier> ADD_SUN_FERN = registerKey("add_sun_fern");
/* 20 */   public static final ResourceKey<BiomeModifier> ADD_WATER_PLANT = registerKey("add_water_plant");
/*    */ 
/*    */   
/*    */   public static ResourceKey<BiomeModifier> registerKey(String name) {
/* 24 */     return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", name));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void bootstrap(BootstrapContext<BiomeModifier> context) {
/* 29 */     HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
/* 30 */     HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
/*    */     
/* 32 */     context.register(ADD_ICE_FERN, new BiomeModifiers.AddFeaturesBiomeModifier((HolderSet)biomes
/* 33 */           .getOrThrow(Tags.Biomes.IS_COLD_OVERWORLD), 
/* 34 */           (HolderSet)HolderSet.direct(new Holder[] { (Holder)placedFeatures.getOrThrow(ModPlacedFeatures.ICE_FERN_PLACED_KEY) }, ), GenerationStep.Decoration.VEGETAL_DECORATION));
/*    */ 
/*    */     
/* 37 */     context.register(ADD_SUN_FERN, new BiomeModifiers.AddFeaturesBiomeModifier((HolderSet)biomes
/* 38 */           .getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD), 
/* 39 */           (HolderSet)HolderSet.direct(new Holder[] { (Holder)placedFeatures.getOrThrow(ModPlacedFeatures.SUN_FERN_PLACED_KEY) }, ), GenerationStep.Decoration.VEGETAL_DECORATION));
/*    */ 
/*    */     
/* 42 */     context.register(ADD_WATER_PLANT, new BiomeModifiers.AddFeaturesBiomeModifier((HolderSet)biomes
/* 43 */           .getOrThrow(Tags.Biomes.IS_HOT_OVERWORLD), 
/* 44 */           (HolderSet)HolderSet.direct(new Holder[] { (Holder)placedFeatures.getOrThrow(ModPlacedFeatures.WATER_PLANT_PLACED_KEY) }, ), GenerationStep.Decoration.VEGETAL_DECORATION));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\level\gen\ModBiomeModifiers.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */