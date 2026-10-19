/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import java.util.function.Function;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.data.loot.LootTableProvider;
/*    */ import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModLootTableProvider
/*    */ {
/*    */   public static LootTableProvider createLootTables(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
/* 17 */     return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(sfiomn.legendarysurvivaloverhaul.data.loot.ModBlockLootTables::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(sfiomn.legendarysurvivaloverhaul.data.loot.ModChestLootTables::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(sfiomn.legendarysurvivaloverhaul.data.loot.ModEntityLootTables::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(sfiomn.legendarysurvivaloverhaul.data.loot.ModFishingLootTables::new, LootContextParamSets.FISHING), new LootTableProvider.SubProviderEntry(sfiomn.legendarysurvivaloverhaul.data.loot.ModBarteringLootTables::new, LootContextParamSets.PIGLIN_BARTER)), lookupProvider);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModLootTableProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */