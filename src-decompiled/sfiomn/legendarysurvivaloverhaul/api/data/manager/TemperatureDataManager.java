/*     */ package sfiomn.legendarysurvivaloverhaul.api.data.manager;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureBiomeOverride;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureConsumable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureConsumableBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureDimension;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureFuelItem;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TemperatureDataManager
/*     */ {
/*     */   public static ITemperatureBlockManager internalBlock;
/*     */   public static ITemperatureConsumableManager internalConsumable;
/*     */   public static ITemperatureConsumableBlockManager internalConsumableBlock;
/*     */   public static ITemperatureItemManager internalItem;
/*     */   public static ITemperatureBiomeManager internalBiome;
/*     */   public static ITemperatureFuelItemManager internalFuelItem;
/*     */   public static ITemperatureDimensionManager internalDimension;
/*     */   public static ITemperatureMountManager internalMount;
/*     */   public static ITemperatureOriginManager internalOrigin;
/*     */   
/*     */   public static List<JsonTemperatureBlock> getBlock(ResourceLocation blockRegistryName) {
/*  30 */     return internalBlock.get(blockRegistryName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<JsonTemperatureConsumable> getConsumable(ResourceLocation itemRegistryName) {
/*  41 */     return internalConsumable.get(itemRegistryName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<JsonTemperatureConsumableBlock> getConsumableBlock(ResourceLocation itemRegistryName) {
/*  52 */     return internalConsumableBlock.get(itemRegistryName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static JsonTemperatureResistance getItem(ResourceLocation itemRegistryName) {
/*  64 */     return internalItem.get(itemRegistryName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static JsonTemperatureBiomeOverride getBiome(ResourceLocation biomeRegistryName) {
/*  76 */     return internalBiome.get(biomeRegistryName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static JsonTemperatureFuelItem getFuelItem(ResourceLocation itemRegistryName) {
/*  88 */     return internalFuelItem.get(itemRegistryName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static JsonTemperatureDimension getDimension(ResourceLocation dimensionRegistryName) {
/* 100 */     return internalDimension.get(dimensionRegistryName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static JsonTemperatureResistance getMount(ResourceLocation mountRegistryName) {
/* 112 */     return internalMount.get(mountRegistryName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Nullable
/*     */   public static JsonTemperatureResistance getOrigin(ResourceLocation originRegistryName) {
/* 124 */     return internalOrigin.get(originRegistryName);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\manager\TemperatureDataManager.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */