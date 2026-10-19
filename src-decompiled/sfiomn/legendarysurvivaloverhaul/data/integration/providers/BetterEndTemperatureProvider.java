/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BetterEndTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public BetterEndTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("betterend", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     fuelItem("charcoal_block").thermalType(ThermalTypeEnum.HEATING).duration(5400);
/*    */     
/* 24 */     fuelItem("emerald_ice").thermalType(ThermalTypeEnum.COOLING).duration(1800);
/* 25 */     fuelItem("dense_emerald_ice").thermalType(ThermalTypeEnum.COOLING).duration(3600);
/* 26 */     fuelItem("ancient_emerald_ice").thermalType(ThermalTypeEnum.COOLING).duration(16200);
/*    */     
/* 28 */     item("emerald_ice").temperature(-2.0F);
/* 29 */     item("dense_emerald_ice").temperature(-3.0F);
/* 30 */     item("ancient_emerald_ice").temperature(-4.0F);
/*    */     
/* 32 */     item("aeternium_helmet").heatResistance(2.0F);
/* 33 */     item("aeternium_chestplate").heatResistance(3.0F);
/* 34 */     item("aeternium_leggings").heatResistance(2.5F);
/* 35 */     item("aeternium_boots").heatResistance(2.0F);
/*    */     
/* 37 */     item("crystalite_helmet").heatResistance(1.5F);
/* 38 */     item("crystalite_chestplate").heatResistance(2.0F);
/* 39 */     item("crystalite_leggings").heatResistance(2.0F);
/* 40 */     item("crystalite_boots").heatResistance(1.0F);
/*    */     
/* 42 */     item("terminite_helmet").heatResistance(1.0F);
/* 43 */     item("terminite_chestplate").heatResistance(1.5F);
/* 44 */     item("crystalite_leggings").heatResistance(1.0F);
/* 45 */     item("crystalite_boots").heatResistance(1.0F);
/*    */     
/* 47 */     item("thallasium_helmet").heatResistance(0.5F);
/* 48 */     item("thallasium_chestplate").heatResistance(1.0F);
/* 49 */     item("thallasium_leggings").heatResistance(0.5F);
/* 50 */     item("thallasium_boots").heatResistance(0.5F);
/*    */     
/* 52 */     item("cincinnasite_helmet").heatResistance(1.0F);
/* 53 */     item("cincinnasite_chestplate").heatResistance(2.0F);
/* 54 */     item("cincinnasite_leggings").heatResistance(2.0F);
/* 55 */     item("cincinnasite_boots").heatResistance(1.0F);
/*    */     
/* 57 */     item("nether_ruby_helmet").coldResistance(1.0F);
/* 58 */     item("nether_ruby_chestplate").coldResistance(2.0F);
/* 59 */     item("nether_ruby_leggings").coldResistance(2.0F);
/* 60 */     item("nether_ruby_boots").coldResistance(1.0F);
/*    */     
/* 62 */     item("flaming_ruby_helmet").coldResistance(1.5F);
/* 63 */     item("flaming_ruby_chestplate").coldResistance(2.5F);
/* 64 */     item("flaming_ruby_leggings").coldResistance(2.5F);
/* 65 */     item("flaming_ruby_boots").coldResistance(1.5F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BetterEndTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */