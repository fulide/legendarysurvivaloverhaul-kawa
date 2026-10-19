/*     */ package sfiomn.legendarysurvivaloverhaul.api.data.providers;
/*     */ 
/*     */ import com.google.gson.JsonElement;
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
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IThirstData;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IThirstDataHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.ThirstData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.ThirstDataHolder;
/*     */ 
/*     */ public abstract class ThirstDataProvider
/*     */   implements DataProvider {
/*     */   private final String modId;
/*     */   private final CompletableFuture<HolderLookup.Provider> lookupProvider;
/*     */   private final PackOutput.PathProvider consumablesPathProvider;
/*     */   private final PackOutput.PathProvider blocksPathProvider;
/*  31 */   private final Map<String, IThirstDataHolder> consumablesBuilders = new HashMap<>();
/*  32 */   private final Map<String, IThirstDataHolder> blocksBuilders = new HashMap<>();
/*     */   
/*     */   private final ExistingFileHelper fileHelper;
/*     */   
/*     */   public ThirstDataProvider(String modId, PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/*  37 */     this.modId = modId;
/*  38 */     this.fileHelper = fileHelper;
/*  39 */     this.consumablesPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/thirst/consumables");
/*  40 */     this.blocksPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/thirst/blocks");
/*  41 */     this.lookupProvider = lookupProvider;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public CompletableFuture<?> run(@Nonnull CachedOutput pOutput) {
/*  49 */     return this.lookupProvider.thenCompose(p_255484_ -> {
/*     */           List<CompletableFuture<?>> list = new ArrayList<>();
/*     */           generate(p_255484_, this.fileHelper);
/*     */           this.consumablesBuilders.forEach(());
/*     */           this.blocksBuilders.forEach(());
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
/*     */   public final IThirstDataHolder consumable(String id) {
/*  68 */     return this.consumablesBuilders.computeIfAbsent(id, k -> new ThirstDataHolder());
/*     */   }
/*     */ 
/*     */   
/*     */   public final IThirstDataHolder consumable(Item item) {
/*  73 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(item);
/*  74 */     assert itemRegistryName != null;
/*  75 */     return this.consumablesBuilders.computeIfAbsent(itemRegistryName.toString(), k -> new ThirstDataHolder());
/*     */   }
/*     */ 
/*     */   
/*     */   public final IThirstDataHolder block(String id) {
/*  80 */     return this.blocksBuilders.computeIfAbsent(id, k -> new ThirstDataHolder());
/*     */   }
/*     */ 
/*     */   
/*     */   public final IThirstDataHolder block(Block block) {
/*  85 */     ResourceLocation blockRegistryName = BuiltInRegistries.BLOCK.getKey(block);
/*  86 */     assert blockRegistryName != null;
/*  87 */     return this.blocksBuilders.computeIfAbsent(blockRegistryName.toString(), k -> new ThirstDataHolder());
/*     */   }
/*     */ 
/*     */   
/*     */   public final IThirstDataHolder consumableAndBlock(String id, IThirstData data) {
/*  92 */     this.consumablesBuilders.computeIfAbsent(id, k -> (new ThirstDataHolder()).addThirst(data));
/*  93 */     return this.blocksBuilders.computeIfAbsent(id, k -> (new ThirstDataHolder()).addThirst(data));
/*     */   }
/*     */ 
/*     */   
/*     */   public final IThirstData thirstData(int hydration, float saturation) {
/*  98 */     return (new ThirstData()).hydration(hydration).saturation(saturation);
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public final String getName() {
/* 104 */     return "Thirst for " + this.modId;
/*     */   }
/*     */   
/*     */   public abstract void generate(HolderLookup.Provider paramProvider, ExistingFileHelper paramExistingFileHelper);
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\providers\ThirstDataProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */