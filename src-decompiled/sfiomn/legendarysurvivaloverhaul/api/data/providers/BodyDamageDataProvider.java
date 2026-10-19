/*     */ package sfiomn.legendarysurvivaloverhaul.api.data.providers;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import java.nio.file.Path;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import java.util.concurrent.CompletionStage;
/*     */ import javax.annotation.Nonnull;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.data.CachedOutput;
/*     */ import net.minecraft.data.DataProvider;
/*     */ import net.minecraft.data.PackOutput;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IBodyPartResistanceData;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IBodyPartsDamageSourceData;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IHealingConsumableData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.BodyPartResistanceData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.BodyPartsDamageSourceData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.HealingConsumableData;
/*     */ 
/*     */ public abstract class BodyDamageDataProvider
/*     */   implements DataProvider {
/*     */   private final String modId;
/*     */   private final CompletableFuture<HolderLookup.Provider> lookupProvider;
/*     */   private final PackOutput.PathProvider consumablesPathProvider;
/*     */   private final PackOutput.PathProvider bodyPartsDamageSourcePathProvider;
/*     */   private final PackOutput.PathProvider bodyPartResistancePathProvider;
/*  34 */   private final Map<String, IHealingConsumableData> consumablesBuilders = new HashMap<>();
/*  35 */   private final Map<String, IBodyPartsDamageSourceData> bodyPartsDamageSourceBuilders = new HashMap<>();
/*  36 */   private final Map<String, IBodyPartResistanceData> bodyPartResistanceBuilders = new HashMap<>();
/*     */   
/*     */   private final ExistingFileHelper fileHelper;
/*     */   
/*     */   public BodyDamageDataProvider(String modId, PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/*  41 */     this.modId = modId;
/*  42 */     this.fileHelper = fileHelper;
/*  43 */     this.consumablesPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/body_damage/consumables");
/*  44 */     this.bodyPartsDamageSourcePathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/body_damage/damage_sources");
/*  45 */     this.bodyPartResistancePathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/body_damage/items");
/*  46 */     this.lookupProvider = lookupProvider;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public CompletableFuture<?> run(@Nonnull CachedOutput pOutput) {
/*  54 */     return this.lookupProvider.thenCompose(p_255484_ -> {
/*     */           List<CompletableFuture<?>> list = new ArrayList<>();
/*     */           generate(p_255484_, this.fileHelper);
/*     */           this.consumablesBuilders.forEach(());
/*     */           this.bodyPartsDamageSourceBuilders.forEach(());
/*     */           this.bodyPartResistanceBuilders.forEach(());
/*     */           return CompletableFuture.allOf((CompletableFuture<?>[])list.toArray(()));
/*     */         });
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final IHealingConsumableData consumable(String id) {
/*  77 */     return this.consumablesBuilders.computeIfAbsent(id, k -> new HealingConsumableData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final IHealingConsumableData consumable(Item item) {
/*  82 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(item);
/*  83 */     assert itemRegistryName != null;
/*  84 */     return this.consumablesBuilders.computeIfAbsent(itemRegistryName.toString(), k -> new HealingConsumableData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final IBodyPartsDamageSourceData damageSource(String id) {
/*  89 */     return this.bodyPartsDamageSourceBuilders.computeIfAbsent(id, k -> new BodyPartsDamageSourceData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final IBodyPartResistanceData item(String id) {
/*  94 */     return this.bodyPartResistanceBuilders.computeIfAbsent(id, k -> new BodyPartResistanceData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final IBodyPartResistanceData item(Item item) {
/*  99 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(item);
/* 100 */     assert itemRegistryName != null;
/* 101 */     return this.bodyPartResistanceBuilders.computeIfAbsent(itemRegistryName.toString(), k -> new BodyPartResistanceData());
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public final String getName() {
/* 107 */     return "Body Damage for " + this.modId;
/*     */   }
/*     */   
/*     */   public abstract void generate(HolderLookup.Provider paramProvider, ExistingFileHelper paramExistingFileHelper);
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\providers\BodyDamageDataProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */