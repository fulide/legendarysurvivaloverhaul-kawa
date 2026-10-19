/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BornInChaosTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public BornInChaosTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("born_in_chaos_v1", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     item("dark_metal_armor_helmet").heatResistance(1.0F);
/* 23 */     item("dark_metal_armor_chestplate").heatResistance(2.0F);
/* 24 */     item("dark_metal_armor_leggings").heatResistance(1.0F);
/* 25 */     item("dark_metal_armor_boots").heatResistance(0.5F);
/*    */     
/* 27 */     item("nightmare_mantleofthe_night_helmet").coldResistance(1.0F);
/* 28 */     item("nightmare_mantleofthe_night_chestplate").coldResistance(2.0F);
/* 29 */     item("nightmare_mantleofthe_night_leggings").coldResistance(1.0F);
/* 30 */     item("nightmare_mantleofthe_night_boots").coldResistance(0.5F);
/*    */     
/* 32 */     item("spiritual_guide_sombrero_helmet").coldResistance(3.5F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BornInChaosTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */