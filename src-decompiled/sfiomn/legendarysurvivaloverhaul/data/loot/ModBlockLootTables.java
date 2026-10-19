/*     */ package sfiomn.legendarysurvivaloverhaul.data.loot;
/*     */ import java.util.Set;
/*     */ import net.minecraft.advancements.critereon.StatePropertiesPredicate;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.minecraft.world.level.block.state.properties.Property;
/*     */ import net.minecraft.world.level.storage.loot.LootPool;
/*     */ import net.minecraft.world.level.storage.loot.LootTable;
/*     */ import net.minecraft.world.level.storage.loot.entries.LootItem;
/*     */ import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
/*     */ import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
/*     */ import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
/*     */ import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
/*     */ import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
/*     */ import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
/*     */ import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
/*     */ import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
/*     */ import net.neoforged.neoforge.registries.DeferredHolder;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SunFernBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.WaterPlantBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ 
/*     */ public class ModBlockLootTables extends BlockLootSubProvider {
/*     */   public ModBlockLootTables(HolderLookup.Provider provider) {
/*  29 */     super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generate() {
/*  35 */     dropSelf((Block)BlockRegistry.HEATER.get());
/*  36 */     dropOther((Block)BlockRegistry.HEATER_TOP.get(), (ItemLike)BlockRegistry.HEATER.get());
/*  37 */     dropSelf((Block)BlockRegistry.COOLER.get());
/*  38 */     dropSelf((Block)BlockRegistry.SEWING_TABLE.get());
/*     */ 
/*     */ 
/*     */     
/*  42 */     LootItemBlockStatePropertyCondition.Builder builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)BlockRegistry.WATER_PLANT_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)WaterPlantBlock.AGE, 7));
/*     */ 
/*     */ 
/*     */     
/*  46 */     LootItemBlockStatePropertyCondition.Builder builder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)BlockRegistry.WATER_PLANT_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)WaterPlantBlock.AGE, 6));
/*     */ 
/*     */ 
/*     */     
/*  50 */     LootItemBlockStatePropertyCondition.Builder builder3 = LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)BlockRegistry.WATER_PLANT_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)WaterPlantBlock.AGE, 5));
/*     */     
/*  52 */     add((Block)BlockRegistry.WATER_PLANT_CROP.get(), 
/*  53 */         createCropDrops((Block)BlockRegistry.WATER_PLANT_CROP
/*  54 */           .get(), (Item)ItemRegistry.WATER_PLANT_SEEDS
/*  55 */           .get(), (Item)ItemRegistry.WATER_PLANT_SEEDS
/*  56 */           .get(), (LootItemCondition.Builder)builder1)
/*     */ 
/*     */         
/*  59 */         .withPool(LootPool.lootPool()
/*  60 */           .add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.WATER_PLANT_BAG.get()))
/*  61 */           .apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)UniformGenerator.between(1.0F, 2.0F)))
/*  62 */           .when((LootItemCondition.Builder)builder3))
/*     */         
/*  64 */         .withPool(LootPool.lootPool()
/*  65 */           .add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.WATER_PLANT_BAG.get()))
/*  66 */           .apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)UniformGenerator.between(1.0F, 3.0F)))
/*  67 */           .when((LootItemCondition.Builder)builder2))
/*     */         
/*  69 */         .withPool(LootPool.lootPool()
/*  70 */           .add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.WATER_PLANT_BAG.get()))
/*  71 */           .apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)UniformGenerator.between(2.0F, 4.0F)))
/*  72 */           .when((LootItemCondition.Builder)builder1)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)BlockRegistry.ICE_FERN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)IceFernBlock.AGE, 3));
/*     */     
/*  80 */     add((Block)BlockRegistry.ICE_FERN_CROP.get(), (LootTable.Builder)
/*  81 */         applyExplosionDecay((ItemLike)BlockRegistry.ICE_FERN_CROP.get(), 
/*  82 */           (FunctionUserBuilder)LootTable.lootTable()
/*  83 */           .withPool(LootPool.lootPool()
/*  84 */             .add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.ICE_FERN.get()))
/*  85 */             .when((LootItemCondition.Builder)builder1))
/*  86 */           .withPool(LootPool.lootPool().add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.ICE_FERN_SEEDS.get())))));
/*     */     
/*  88 */     add((Block)BlockRegistry.ICE_FERN_GOLD.get(), LootTable.lootTable()
/*  89 */         .withPool(LootPool.lootPool().add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.ICE_FERN_GOLD.get())))
/*  90 */         .withPool(LootPool.lootPool().add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.ICE_FERN_SEEDS.get()))));
/*     */ 
/*     */ 
/*     */     
/*  94 */     builder1 = LootItemBlockStatePropertyCondition.hasBlockStateProperties((Block)BlockRegistry.SUN_FERN_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty((Property)SunFernBlock.AGE, 3));
/*     */     
/*  96 */     add((Block)BlockRegistry.SUN_FERN_CROP.get(), (LootTable.Builder)
/*  97 */         applyExplosionDecay((ItemLike)BlockRegistry.SUN_FERN_CROP.get(), 
/*  98 */           (FunctionUserBuilder)LootTable.lootTable()
/*  99 */           .withPool(LootPool.lootPool()
/* 100 */             .add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.SUN_FERN.get()))
/* 101 */             .when((LootItemCondition.Builder)builder1))
/* 102 */           .withPool(LootPool.lootPool().add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.SUN_FERN_SEEDS.get())))));
/*     */     
/* 104 */     add((Block)BlockRegistry.SUN_FERN_GOLD.get(), LootTable.lootTable()
/* 105 */         .withPool(LootPool.lootPool().add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.SUN_FERN_GOLD.get())))
/* 106 */         .withPool(LootPool.lootPool().add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.SUN_FERN_SEEDS.get()))));
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   protected Iterable<Block> getKnownBlocks() {
/* 112 */     return BlockRegistry.BLOCKS.getEntries()
/* 113 */       .stream()
/* 114 */       .map(DeferredHolder::get)
/* 115 */       .map(b -> b)
/* 116 */       .toList();
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\loot\ModBlockLootTables.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */