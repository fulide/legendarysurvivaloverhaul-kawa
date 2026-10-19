/*     */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.Consumer;
/*     */ import net.minecraft.advancements.Advancement;
/*     */ import net.minecraft.advancements.AdvancementHolder;
/*     */ import net.minecraft.advancements.AdvancementType;
/*     */ import net.minecraft.advancements.critereon.InventoryChangeTrigger;
/*     */ import net.minecraft.advancements.critereon.ItemPredicate;
/*     */ import net.minecraft.advancements.critereon.PlayerTrigger;
/*     */ import net.minecraft.advancements.critereon.RecipeCraftedTrigger;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.neoforged.neoforge.common.Tags;
/*     */ import net.neoforged.neoforge.common.data.AdvancementProvider;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.item.CoatEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.RecipeRegistry;
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
/*     */ class LegendarySurvivalAdvancements
/*     */   implements AdvancementProvider.AdvancementGenerator
/*     */ {
/*     */   public void generate(HolderLookup.Provider registries, @NotNull Consumer<AdvancementHolder> consumer, @NotNull ExistingFileHelper existingFileHelper) {
/*  66 */     AdvancementHolder root = Advancement.Builder.advancement().display((ItemLike)ItemRegistry.THERMOMETER.get(), (Component)Component.translatable("advancement.legendarysurvivaloverhaul"), (Component)Component.translatable("advancement.legendarysurvivaloverhaul.description"), ResourceLocation.parse("textures/block/ice.png"), AdvancementType.TASK, false, false, false).addCriterion("main", PlayerTrigger.TriggerInstance.tick()).save(consumer, "legendarysurvivaloverhaul:main/root");
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
/*  78 */     AdvancementHolder get_a_thermometer = Advancement.Builder.advancement().display((ItemLike)ItemRegistry.THERMOMETER.get(), (Component)Component.translatable("advancement.legendarysurvivaloverhaul.get_a_thermometer"), (Component)Component.translatable("advancement.legendarysurvivaloverhaul.get_a_thermometer.description"), null, AdvancementType.TASK, true, true, false).parent(root).addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] { (ItemLike)ItemRegistry.THERMOMETER.get() })).save(consumer, "legendarysurvivaloverhaul:main/get_a_thermometer");
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
/*  90 */     AdvancementHolder get_a_calendar = Advancement.Builder.advancement().display((ItemLike)ItemRegistry.SEASONAL_CALENDAR.get(), (Component)Component.translatable("advancement.legendarysurvivaloverhaul.get_a_calendar"), (Component)Component.translatable("advancement.legendarysurvivaloverhaul.get_a_calendar.description"), null, AdvancementType.TASK, true, true, false).parent(root).addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] { (ItemLike)ItemRegistry.SEASONAL_CALENDAR.get() })).save(consumer, "legendarysurvivaloverhaul:main/get_a_calendar");
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
/* 102 */     AdvancementHolder use_a_sewing_table = Advancement.Builder.advancement().display((ItemLike)BlockRegistry.SEWING_TABLE.get(), (Component)Component.translatable("advancement.legendarysurvivaloverhaul.get_a_sewing_table"), (Component)Component.translatable("advancement.legendarysurvivaloverhaul.get_a_sewing_table.description"), null, AdvancementType.TASK, true, true, false).parent(root).addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[] { (ItemLike)BlockRegistry.SEWING_TABLE.get() })).save(consumer, "legendarysurvivaloverhaul:main/get_a_sewing_table");
/*     */ 
/*     */     
/* 105 */     List<ItemPredicate.Builder> itemPredicates = new ArrayList<>();
/* 106 */     for (CoatEnum coatEnum : CoatEnum.values()) {
/*     */       
/* 108 */       CompoundTag coatTag = new CompoundTag();
/* 109 */       coatTag.putString("Coat", coatEnum.id());
/* 110 */       itemPredicates.add(
/* 111 */           ItemPredicate.Builder.item()
/* 112 */           .of(Tags.Items.ARMORS));
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     AdvancementHolder sew_a_coat = Advancement.Builder.advancement().display((ItemLike)ItemRegistry.COOLING_COAT_1.get(), (Component)Component.translatable("advancement.legendarysurvivaloverhaul.sew_a_coat"), (Component)Component.translatable("advancement.legendarysurvivaloverhaul.sew_a_coat.description"), null, AdvancementType.TASK, true, true, false).parent(use_a_sewing_table).addCriterion("recipe_crafted", RecipeCraftedTrigger.TriggerInstance.craftedItem(RecipeRegistry.SEWING_RECIPE.getId(), itemPredicates)).save(consumer, "legendarysurvivaloverhaul:main/sew_a_coat");
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModAdvancementProvider$LegendarySurvivalAdvancements.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */