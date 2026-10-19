/*     */ package sfiomn.legendarysurvivaloverhaul.api.data.providers;
/*     */ import com.google.gson.JsonElement;
/*     */ import java.nio.file.Path;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import javax.annotation.Nonnull;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.data.CachedOutput;
/*     */ import net.minecraft.data.DataProvider;
/*     */ import net.minecraft.data.PackOutput;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureBiomeOverrideData;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureBlockDataHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableBlockDataHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableData;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableDataHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureDimensionData;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureFuelItemData;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureResistanceData;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureBlockDataHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureConsumableBlockDataHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureConsumableDataHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureFuelItemData;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.builders.TemperatureResistanceData;
/*     */ 
/*     */ public abstract class TemperatureDataProvider implements DataProvider {
/*     */   private final String modId;
/*     */   private final CompletableFuture<HolderLookup.Provider> lookupProvider;
/*     */   private final PackOutput.PathProvider consumablesPathProvider;
/*     */   private final PackOutput.PathProvider consumableBlocksPathProvider;
/*     */   private final PackOutput.PathProvider blocksPathProvider;
/*  38 */   private final Map<String, ITemperatureConsumableDataHolder> consumableBuilders = new HashMap<>(); private final PackOutput.PathProvider itemsPathProvider; private final PackOutput.PathProvider biomesPathProvider; private final PackOutput.PathProvider fuelItemPathProvider; private final PackOutput.PathProvider dimensionPathProvider; private final PackOutput.PathProvider mountPathProvider; private final PackOutput.PathProvider originPathProvider;
/*  39 */   private final Map<String, ITemperatureConsumableBlockDataHolder> consumableBlockBuilders = new HashMap<>();
/*  40 */   private final Map<String, ITemperatureBlockDataHolder> blockBuilders = new HashMap<>();
/*  41 */   private final Map<String, ITemperatureResistanceData> itemBuilders = new HashMap<>();
/*  42 */   private final Map<String, ITemperatureBiomeOverrideData> biomeBuilders = new HashMap<>();
/*  43 */   private final Map<String, ITemperatureFuelItemData> fuelItemBuilders = new HashMap<>();
/*  44 */   private final Map<String, ITemperatureDimensionData> dimensionBuilders = new HashMap<>();
/*  45 */   private final Map<String, ITemperatureResistanceData> mountBuilders = new HashMap<>();
/*  46 */   private final Map<String, ITemperatureResistanceData> originBuilders = new HashMap<>();
/*     */   
/*     */   private final ExistingFileHelper fileHelper;
/*     */   
/*     */   public TemperatureDataProvider(String modId, PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/*  51 */     this.modId = modId;
/*  52 */     this.fileHelper = fileHelper;
/*  53 */     this.consumablesPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/temperature/consumables");
/*  54 */     this.consumableBlocksPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/temperature/consumable_blocks");
/*  55 */     this.blocksPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/temperature/blocks");
/*  56 */     this.itemsPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/temperature/items");
/*  57 */     this.biomesPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/temperature/biomes");
/*  58 */     this.fuelItemPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/temperature/fuel_items");
/*  59 */     this.dimensionPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/temperature/dimensions");
/*  60 */     this.mountPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/temperature/mounts");
/*  61 */     this.originPathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "legendarysurvivaloverhaul/temperature/origins");
/*  62 */     this.lookupProvider = lookupProvider;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public CompletableFuture<?> run(@Nonnull CachedOutput pOutput) {
/*  70 */     return this.lookupProvider.thenCompose(p_255484_ -> {
/*     */           List<CompletableFuture<?>> list = new ArrayList<>();
/*     */           generate(p_255484_, this.fileHelper);
/*     */           this.consumableBuilders.forEach(());
/*     */           this.consumableBlockBuilders.forEach(());
/*     */           this.blockBuilders.forEach(());
/*     */           this.itemBuilders.forEach(());
/*     */           this.biomeBuilders.forEach(());
/*     */           this.fuelItemBuilders.forEach(());
/*     */           this.dimensionBuilders.forEach(());
/*     */           this.mountBuilders.forEach(());
/*     */           this.originBuilders.forEach(());
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
/*     */   public final ITemperatureConsumableDataHolder consumable(String id) {
/* 120 */     return this.consumableBuilders.computeIfAbsent(id, k -> new TemperatureConsumableDataHolder());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureConsumableDataHolder consumable(Item item) {
/* 125 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(item);
/* 126 */     return this.consumableBuilders.computeIfAbsent(itemRegistryName.toString(), k -> new TemperatureConsumableDataHolder());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureConsumableData temperatureConsumable(TemporaryModifierGroupEnum group) {
/* 131 */     return (new TemperatureConsumableData()).group(group);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureConsumableBlockDataHolder consumableBlock(String id) {
/* 136 */     return this.consumableBlockBuilders.computeIfAbsent(id, k -> new TemperatureConsumableBlockDataHolder());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureConsumableBlockDataHolder consumableAndConsumableBlock(String id, ITemperatureConsumableData data) {
/* 141 */     this.consumableBuilders.computeIfAbsent(id, k -> (new TemperatureConsumableDataHolder()).addTemperature(data));
/* 142 */     return this.consumableBlockBuilders.computeIfAbsent(id, k -> (new TemperatureConsumableBlockDataHolder()).addTemperature(data.asBlock()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureConsumableBlockData temperatureConsumableBlock(TemporaryModifierGroupEnum group) {
/* 147 */     return (new TemperatureConsumableBlockData()).group(group);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureBlockDataHolder block(String id) {
/* 152 */     return this.blockBuilders.computeIfAbsent(id, k -> new TemperatureBlockDataHolder());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureBlockDataHolder block(Block block) {
/* 157 */     ResourceLocation blockRegistryName = BuiltInRegistries.BLOCK.getKey(block);
/* 158 */     assert blockRegistryName != null;
/* 159 */     return this.blockBuilders.computeIfAbsent(blockRegistryName.toString(), k -> new TemperatureBlockDataHolder());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureBlockData temperatureBlock(float temperatureValue) {
/* 164 */     return (new TemperatureBlockData()).temperature(temperatureValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureResistanceData item(String id) {
/* 169 */     return this.itemBuilders.computeIfAbsent(id, k -> new TemperatureResistanceData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureResistanceData item(Item item) {
/* 174 */     ResourceLocation itemRegistryName = BuiltInRegistries.ITEM.getKey(item);
/* 175 */     assert itemRegistryName != null;
/* 176 */     return this.itemBuilders.computeIfAbsent(itemRegistryName.toString(), k -> new TemperatureResistanceData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureBiomeOverrideData biome(String id) {
/* 181 */     return this.biomeBuilders.computeIfAbsent(id, k -> new TemperatureBiomeOverrideData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureFuelItemData fuelItem(String id) {
/* 186 */     return this.fuelItemBuilders.computeIfAbsent(id, k -> new TemperatureFuelItemData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureDimensionData dimension(String id) {
/* 191 */     return this.dimensionBuilders.computeIfAbsent(id, k -> new TemperatureDimensionData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureResistanceData mount(String id) {
/* 196 */     return this.mountBuilders.computeIfAbsent(id, k -> new TemperatureResistanceData());
/*     */   }
/*     */ 
/*     */   
/*     */   public final ITemperatureResistanceData origin(String id) {
/* 201 */     return this.originBuilders.computeIfAbsent(id, k -> new TemperatureResistanceData());
/*     */   }
/*     */ 
/*     */   
/*     */   @Nonnull
/*     */   public final String getName() {
/* 207 */     return "Temperature for " + this.modId;
/*     */   }
/*     */   
/*     */   public abstract void generate(HolderLookup.Provider paramProvider, ExistingFileHelper paramExistingFileHelper);
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\providers\TemperatureDataProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */