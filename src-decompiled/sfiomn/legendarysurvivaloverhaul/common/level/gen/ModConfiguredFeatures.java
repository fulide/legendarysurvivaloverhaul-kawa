/*    */ package sfiomn.legendarysurvivaloverhaul.common.level.gen;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.data.worldgen.BootstrapContext;
/*    */ import net.minecraft.data.worldgen.features.FeatureUtils;
/*    */ import net.minecraft.data.worldgen.placement.PlacementUtils;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.block.state.properties.Property;
/*    */ import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
/*    */ import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
/*    */ import net.minecraft.world.level.levelgen.feature.Feature;
/*    */ import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
/*    */ import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
/*    */ import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
/*    */ import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.IceFernBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SunFernBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.WaterPlantBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.FeatureRegistry;
/*    */ 
/*    */ public class ModConfiguredFeatures
/*    */ {
/* 26 */   public static final ResourceKey<ConfiguredFeature<?, ?>> ICE_FERN_CONFIG_KEY = registerKey("ice_fern_config_feature");
/* 27 */   public static final ResourceKey<ConfiguredFeature<?, ?>> SUN_FERN_CONFIG_KEY = registerKey("sun_fern_config_feature");
/* 28 */   public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_PLANT_CONFIG_KEY = registerKey("water_plant_config_feature");
/*    */ 
/*    */   
/*    */   public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
/* 32 */     return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", name));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void registerSimpleRandomPatchConfig(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, BlockState blockState) {
/* 37 */     FeatureUtils.register(context, resourceKey, Feature.RANDOM_PATCH, (FeatureConfiguration)new RandomPatchConfiguration(5, 5, 3, 
/*    */ 
/*    */ 
/*    */           
/* 41 */           PlacementUtils.filtered((Feature)FeatureRegistry.GOLD_FERN
/* 42 */             .get(), (FeatureConfiguration)new SimpleBlockConfiguration(
/* 43 */               (BlockStateProvider)BlockStateProvider.simple(blockState)), 
/* 44 */             BlockPredicate.replaceable())));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void registerDoubleRandomPatchConfig(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, BlockState blockState) {
/* 49 */     FeatureUtils.register(context, resourceKey, Feature.RANDOM_PATCH, (FeatureConfiguration)new RandomPatchConfiguration(10, 5, 3, 
/*    */ 
/*    */ 
/*    */           
/* 53 */           PlacementUtils.filtered((Feature)FeatureRegistry.DOUBLE_BLOCK
/* 54 */             .get(), (FeatureConfiguration)new SimpleBlockConfiguration(
/* 55 */               (BlockStateProvider)BlockStateProvider.simple(blockState)), 
/* 56 */             BlockPredicate.replaceable())));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
/* 61 */     registerSimpleRandomPatchConfig(context, ICE_FERN_CONFIG_KEY, (BlockState)((IceFernBlock)BlockRegistry.ICE_FERN_CROP.get()).defaultBlockState().setValue((Property)IceFernBlock.AGE, Integer.valueOf(3)));
/* 62 */     registerSimpleRandomPatchConfig(context, SUN_FERN_CONFIG_KEY, (BlockState)((SunFernBlock)BlockRegistry.SUN_FERN_CROP.get()).defaultBlockState().setValue((Property)SunFernBlock.AGE, Integer.valueOf(3)));
/* 63 */     registerDoubleRandomPatchConfig(context, WATER_PLANT_CONFIG_KEY, (BlockState)((WaterPlantBlock)BlockRegistry.WATER_PLANT_CROP.get()).defaultBlockState().setValue((Property)WaterPlantBlock.AGE, Integer.valueOf(7)));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\level\gen\ModConfiguredFeatures.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */