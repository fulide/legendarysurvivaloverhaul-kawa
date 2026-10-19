/*    */ package sfiomn.legendarysurvivaloverhaul.data.loot;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.function.BiConsumer;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.data.loot.LootTableSubProvider;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.storage.loot.LootPool;
/*    */ import net.minecraft.world.level.storage.loot.LootTable;
/*    */ import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
/*    */ import net.minecraft.world.level.storage.loot.entries.LootItem;
/*    */ import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*    */ 
/*    */ 
/*    */ public class ModEntityLootTables
/*    */   implements LootTableSubProvider
/*    */ {
/* 22 */   public static List<ResourceLocation> entityInjectedLootTables = List.of(
/* 23 */       ResourceLocation.parse("entities/drowned"));
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ModEntityLootTables(HolderLookup.Provider provider) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
/* 34 */     for (ResourceLocation lootTable : entityInjectedLootTables)
/*    */     {
/* 36 */       biConsumer.accept(
/* 37 */           ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "inject/" + lootTable.getPath())), 
/* 38 */           LootTable.lootTable().withPool(
/* 39 */             LootPool.lootPool()
/* 40 */             .add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.WATER_PURIFIER.get()).setWeight(1))
/* 41 */             .add((LootPoolEntryContainer.Builder)EmptyLootItem.emptyItem().setWeight(100))));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\loot\ModEntityLootTables.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */