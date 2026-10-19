/*     */ package sfiomn.legendarysurvivaloverhaul.data.loot;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.BiConsumer;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.core.registries.Registries;
/*     */ import net.minecraft.data.loot.LootTableSubProvider;
/*     */ import net.minecraft.resources.ResourceKey;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.enchantment.Enchantment;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.storage.loot.BuiltInLootTables;
/*     */ import net.minecraft.world.level.storage.loot.LootPool;
/*     */ import net.minecraft.world.level.storage.loot.LootTable;
/*     */ import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
/*     */ import net.minecraft.world.level.storage.loot.entries.LootItem;
/*     */ import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
/*     */ import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
/*     */ import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
/*     */ import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
/*     */ import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
/*     */ import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
/*     */ import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.enchantments.ModEnchantments;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ 
/*     */ public class ModChestLootTables implements LootTableSubProvider {
/*  33 */   private static final Item PURITY_BOOK = Items.ENCHANTED_BOOK;
/*     */   
/*  35 */   public static Map<ResourceKey<LootTable>, List<Item>> chestInjectedLootTables = Map.ofEntries((Map.Entry<? extends ResourceKey<LootTable>, ? extends List<Item>>[])new Map.Entry[] {
/*  36 */         Map.entry(BuiltInLootTables.BURIED_TREASURE, List.of((Item)ItemRegistry.HEART_FRAGMENT.get())), 
/*  37 */         Map.entry(BuiltInLootTables.JUNGLE_TEMPLE, List.of((Item)ItemRegistry.HEART_FRAGMENT.get())), 
/*  38 */         Map.entry(BuiltInLootTables.ABANDONED_MINESHAFT, List.of((Item)ItemRegistry.HEART_FRAGMENT.get())), 
/*  39 */         Map.entry(BuiltInLootTables.BASTION_TREASURE, List.of((Item)ItemRegistry.HEART_FRAGMENT.get(), (Item)ItemRegistry.COLD_RESISTANCE_RING.get(), PURITY_BOOK)), 
/*  40 */         Map.entry(BuiltInLootTables.BASTION_BRIDGE, List.of(PURITY_BOOK)), 
/*  41 */         Map.entry(BuiltInLootTables.BASTION_HOGLIN_STABLE, List.of(PURITY_BOOK)), 
/*  42 */         Map.entry(BuiltInLootTables.BASTION_OTHER, List.of(PURITY_BOOK)), 
/*  43 */         Map.entry(BuiltInLootTables.NETHER_BRIDGE, List.of(PURITY_BOOK)), 
/*  44 */         Map.entry(BuiltInLootTables.DESERT_PYRAMID, List.of((Item)ItemRegistry.HEAT_RESISTANCE_RING.get())), 
/*  45 */         Map.entry(BuiltInLootTables.PILLAGER_OUTPOST, List.of((Item)ItemRegistry.FIRST_AID_SUPPLIES.get()))
/*     */       });
/*     */   
/*     */   private final HolderLookup.Provider registries;
/*     */ 
/*     */   
/*     */   public ModChestLootTables(HolderLookup.Provider provider) {
/*  52 */     this.registries = provider;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(@NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
/*  64 */     LootPool.Builder heartFragmentLoot = LootPool.lootPool().setRolls((NumberProvider)UniformGenerator.between(1.0F, 1.0F)).add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.HEART_FRAGMENT.get()).setWeight(30)).add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.HEART_FRAGMENT.get()).setWeight(5).apply((LootItemFunction.Builder)SetItemCountFunction.setCount((NumberProvider)ConstantValue.exactly(2.0F)))).add((LootPoolEntryContainer.Builder)EmptyLootItem.emptyItem().setWeight(80));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     LootPool.Builder heatResistanceRing = LootPool.lootPool().setRolls((NumberProvider)UniformGenerator.between(1.0F, 1.0F)).add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.HEAT_RESISTANCE_RING.get()).setWeight(5)).add((LootPoolEntryContainer.Builder)EmptyLootItem.emptyItem().setWeight(95));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     LootPool.Builder coldResistanceRing = LootPool.lootPool().setRolls((NumberProvider)UniformGenerator.between(1.0F, 1.0F)).add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.COLD_RESISTANCE_RING.get()).setWeight(5)).add((LootPoolEntryContainer.Builder)EmptyLootItem.emptyItem().setWeight(95));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     LootPool.Builder firstAidSupplies = LootPool.lootPool().setRolls((NumberProvider)UniformGenerator.between(1.0F, 1.0F)).add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)ItemRegistry.FIRST_AID_SUPPLIES.get()).setWeight(1)).add((LootPoolEntryContainer.Builder)EmptyLootItem.emptyItem().setWeight(99));
/*     */     
/*  81 */     HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     LootPool.Builder purityBook = LootPool.lootPool().setRolls((NumberProvider)UniformGenerator.between(1.0F, 1.0F)).add((LootPoolEntryContainer.Builder)LootItem.lootTableItem((ItemLike)Items.ENCHANTED_BOOK).setWeight(5).apply((LootItemFunction.Builder)(new EnchantRandomlyFunction.Builder()).withEnchantment((Holder)enchantmentLookup.getOrThrow(ModEnchantments.PURITY)))).add((LootPoolEntryContainer.Builder)EmptyLootItem.emptyItem().setWeight(95));
/*     */     
/*  88 */     for (Map.Entry<ResourceKey<LootTable>, List<Item>> entry : chestInjectedLootTables.entrySet()) {
/*     */       
/*  90 */       LootTable.Builder lootTable = LootTable.lootTable();
/*  91 */       if (((List)entry.getValue()).contains(ItemRegistry.HEART_FRAGMENT.get()))
/*     */       {
/*  93 */         lootTable.withPool(heartFragmentLoot);
/*     */       }
/*  95 */       if (((List)entry.getValue()).contains(ItemRegistry.HEAT_RESISTANCE_RING.get()))
/*     */       {
/*  97 */         lootTable.withPool(heatResistanceRing);
/*     */       }
/*  99 */       if (((List)entry.getValue()).contains(ItemRegistry.COLD_RESISTANCE_RING.get()))
/*     */       {
/* 101 */         lootTable.withPool(coldResistanceRing);
/*     */       }
/* 103 */       if (((List)entry.getValue()).contains(ItemRegistry.FIRST_AID_SUPPLIES.get()))
/*     */       {
/* 105 */         lootTable.withPool(firstAidSupplies);
/*     */       }
/* 107 */       if (((List)entry.getValue()).contains(PURITY_BOOK))
/*     */       {
/* 109 */         lootTable.withPool(purityBook);
/*     */       }
/* 111 */       biConsumer.accept(
/* 112 */           ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "inject/" + ((ResourceKey)entry.getKey()).location().getPath())), lootTable);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\loot\ModChestLootTables.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */