/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.level.storage.loot.LootTable;
/*    */ import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
/*    */ import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
/*    */ import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
/*    */ import net.neoforged.neoforge.common.loot.LootTableIdCondition;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.loot_modifiers.AdditionalLootTable;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.loot.ModBarteringLootTables;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.loot.ModChestLootTables;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.loot.ModEntityLootTables;
/*    */ import sfiomn.legendarysurvivaloverhaul.data.loot.ModFishingLootTables;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModGlobalLootModifierProvider
/*    */   extends GlobalLootModifierProvider
/*    */ {
/*    */   public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
/* 25 */     super(output, lookupProvider, "legendarysurvivaloverhaul");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void start() {
/* 31 */     for (ResourceKey<LootTable> lootTableKey : (Iterable<ResourceKey<LootTable>>)ModChestLootTables.chestInjectedLootTables.keySet()) {
/*    */       
/* 33 */       ResourceLocation lootTable = lootTableKey.location();
/* 34 */       add(lootTable.getPath(), (IGlobalLootModifier)new AdditionalLootTable(new LootItemCondition[] {
/* 35 */               LootTableIdCondition.builder(lootTable).build()
/* 36 */             }, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "inject/" + lootTable.getPath()), false), new net.neoforged.neoforge.common.conditions.ICondition[0]);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 42 */     for (ResourceLocation lootTable : ModEntityLootTables.entityInjectedLootTables) {
/*    */       
/* 44 */       add(lootTable.getPath(), (IGlobalLootModifier)new AdditionalLootTable(new LootItemCondition[] {
/* 45 */               LootTableIdCondition.builder(lootTable).build()
/* 46 */             }, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "inject/" + lootTable.getPath()), false), new net.neoforged.neoforge.common.conditions.ICondition[0]);
/*    */     } 
/*    */ 
/*    */     
/* 50 */     for (ResourceLocation lootTable : ModFishingLootTables.fishingInjectedLootTables) {
/*    */       
/* 52 */       add(lootTable.getPath(), (IGlobalLootModifier)new AdditionalLootTable(new LootItemCondition[] {
/* 53 */               LootTableIdCondition.builder(lootTable).build()
/* 54 */             }, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "inject/" + lootTable.getPath()), false), new net.neoforged.neoforge.common.conditions.ICondition[0]);
/*    */     } 
/*    */ 
/*    */     
/* 58 */     for (ResourceLocation lootTable : ModBarteringLootTables.barteringInjectedLootTables) {
/*    */       
/* 60 */       add(lootTable.getPath(), (IGlobalLootModifier)new AdditionalLootTable(new LootItemCondition[] {
/* 61 */               LootTableIdCondition.builder(lootTable).build()
/* 62 */             }, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "inject/" + lootTable.getPath()), false), new net.neoforged.neoforge.common.conditions.ICondition[0]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModGlobalLootModifierProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */