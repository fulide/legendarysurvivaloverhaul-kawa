/*     */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*     */ import net.minecraft.core.Direction;
/*     */ import net.minecraft.data.PackOutput;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.DoublePlantBlock;
/*     */ import net.minecraft.world.level.block.state.BlockState;
/*     */ import net.minecraft.world.level.block.state.properties.BlockStateProperties;
/*     */ import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
/*     */ import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
/*     */ import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
/*     */ import net.neoforged.neoforge.client.model.generators.ModelFile;
/*     */ import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.IceFernBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SunFernBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.ThermalBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.WaterPlantBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*     */ 
/*     */ public class ModBlockStateProvider extends BlockStateProvider {
/*  24 */   public static final ResourceLocation COOLER_OFF = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "block/cooler_off");
/*  25 */   public static final ResourceLocation COOLER_ON = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "block/cooler_on");
/*  26 */   public static final ResourceLocation HEATER_BASE_OFF = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "block/heater_base_off");
/*  27 */   public static final ResourceLocation HEATER_BASE_ON = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "block/heater_base_on");
/*  28 */   public static final ResourceLocation HEATER_TOP = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "block/heater_top");
/*  29 */   public static final ResourceLocation SEWING_TABLE = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "block/sewing_table");
/*     */ 
/*     */   
/*     */   public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
/*  33 */     super(output, "legendarysurvivaloverhaul", exFileHelper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void registerStatesAndModels() {
/*  39 */     simpleBlockItem((Block)BlockRegistry.COOLER.get(), (ModelFile)new ModelFile.UncheckedModelFile(COOLER_OFF));
/*  40 */     getVariantBuilder((Block)BlockRegistry.COOLER.get())
/*  41 */       .forAllStates(state -> ((Boolean)state.getValue((Property)BlockStateProperties.LIT)).booleanValue() ? ConfiguredModel.builder().modelFile((ModelFile)new ModelFile.UncheckedModelFile(COOLER_ON)).rotationY((int)((Direction)state.getValue((Property)ThermalBlock.FACING)).toYRot()).build() : ConfiguredModel.builder().modelFile((ModelFile)new ModelFile.UncheckedModelFile(COOLER_OFF)).rotationY((int)((Direction)state.getValue((Property)ThermalBlock.FACING)).toYRot()).build());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     simpleBlockItem((Block)BlockRegistry.HEATER.get(), (ModelFile)new ModelFile.UncheckedModelFile(modLoc("block/heater_off_full_block")));
/*  55 */     getVariantBuilder((Block)BlockRegistry.HEATER.get())
/*  56 */       .forAllStates(state -> ((Boolean)state.getValue((Property)BlockStateProperties.LIT)).booleanValue() ? ConfiguredModel.builder().modelFile((ModelFile)new ModelFile.UncheckedModelFile(HEATER_BASE_ON)).rotationY((int)((Direction)state.getValue((Property)ThermalBlock.FACING)).toYRot()).build() : ConfiguredModel.builder().modelFile((ModelFile)new ModelFile.UncheckedModelFile(HEATER_BASE_OFF)).rotationY((int)((Direction)state.getValue((Property)ThermalBlock.FACING)).toYRot()).build());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     getVariantBuilder((Block)BlockRegistry.HEATER_TOP.get())
/*  70 */       .forAllStates(state -> ConfiguredModel.builder().modelFile((ModelFile)new ModelFile.UncheckedModelFile(HEATER_TOP)).rotationY((int)((Direction)state.getValue((Property)ThermalBlock.FACING)).toYRot()).build());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     simpleBlockItem((Block)BlockRegistry.SEWING_TABLE.get(), (ModelFile)new ModelFile.UncheckedModelFile(SEWING_TABLE));
/*  76 */     getVariantBuilder((Block)BlockRegistry.SEWING_TABLE.get())
/*  77 */       .forAllStates(state -> ConfiguredModel.builder().modelFile((ModelFile)new ModelFile.UncheckedModelFile(SEWING_TABLE)).rotationY((int)((Direction)state.getValue((Property)ThermalBlock.FACING)).toYRot()).build());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     VariantBlockStateBuilder iceFernBuilder = getVariantBuilder((Block)BlockRegistry.ICE_FERN_CROP.get());
/*  83 */     IceFernBlock.AGE.getPossibleValues().forEach(age -> {
/*     */           if (age.intValue() < 3) {
/*     */             iceFernBuilder.partialState().with((Property)IceFernBlock.AGE, age).modelForState().modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)models().crop("ice_fern_" + age, modLoc("block/ice_fern_" + age))).texture("particle", modLoc("block/ice_fern_" + age))).renderType("cutout")).addModel();
/*     */           } else {
/*     */             iceFernBuilder.partialState().with((Property)IceFernBlock.AGE, age).modelForState().modelFile((ModelFile)new ModelFile.UncheckedModelFile(modLoc("block/ice_fern_mature"))).addModel();
/*     */           } 
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 101 */     simpleBlockWithItem((Block)BlockRegistry.ICE_FERN_GOLD.get(), (ModelFile)new ModelFile.UncheckedModelFile(modLoc("block/ice_fern_gold")));
/*     */     
/* 103 */     VariantBlockStateBuilder sunFernBuilder = getVariantBuilder((Block)BlockRegistry.SUN_FERN_CROP.get());
/* 104 */     SunFernBlock.AGE.getPossibleValues().forEach(age -> {
/*     */           if (age.intValue() < 3) {
/*     */             sunFernBuilder.partialState().with((Property)SunFernBlock.AGE, age).modelForState().modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)models().crop("sun_fern_" + age, modLoc("block/sun_fern_" + age))).texture("particle", modLoc("block/sun_fern_" + age))).renderType("cutout")).addModel();
/*     */           } else {
/*     */             sunFernBuilder.partialState().with((Property)SunFernBlock.AGE, age).modelForState().modelFile((ModelFile)new ModelFile.UncheckedModelFile(modLoc("block/sun_fern_mature"))).addModel();
/*     */           } 
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     simpleBlockWithItem((Block)BlockRegistry.SUN_FERN_GOLD.get(), (ModelFile)new ModelFile.UncheckedModelFile(modLoc("block/sun_fern_gold")));
/*     */     
/* 124 */     VariantBlockStateBuilder waterPlantBuilder = getVariantBuilder((Block)BlockRegistry.WATER_PLANT_CROP.get());
/* 125 */     WaterPlantBlock.AGE.getPossibleValues().forEach(age -> {
/*     */           waterPlantBuilder.partialState().with((Property)DoublePlantBlock.HALF, (Comparable)DoubleBlockHalf.LOWER).with((Property)WaterPlantBlock.AGE, age).modelForState().modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)models().cross("water_plant_bottom_" + age, modLoc("block/water_plant_bottom_" + age))).texture("particle", modLoc("block/water_plant_bottom_" + age))).renderType("cutout")).addModel();
/*     */           waterPlantBuilder.partialState().with((Property)DoublePlantBlock.HALF, (Comparable)DoubleBlockHalf.UPPER).with((Property)WaterPlantBlock.AGE, age).modelForState().modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)models().cross("water_plant_top_" + age, modLoc("block/water_plant_top_" + age))).texture("particle", modLoc("block/water_plant_top_" + age))).renderType("cutout")).addModel();
/*     */         });
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModBlockStateProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */