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
/*    */ public class WardrobeTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public WardrobeTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("wardrobe", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     item("taiga_helmet").coldResistance(2.0F);
/* 23 */     item("taiga_chestplate").coldResistance(3.5F);
/* 24 */     item("taiga_leggings").coldResistance(3.0F);
/* 25 */     item("taiga_boots").coldResistance(1.0F);
/*    */     
/* 27 */     item("snowy_helmet").coldResistance(2.0F);
/* 28 */     item("snowy_chestplate").coldResistance(3.5F);
/* 29 */     item("snowy_leggings").coldResistance(3.0F);
/* 30 */     item("snowy_boots").coldResistance(1.0F);
/*    */     
/* 32 */     item("desert_helmet").heatResistance(2.0F);
/* 33 */     item("desert_chestplate").heatResistance(3.0F);
/* 34 */     item("desert_leggings").heatResistance(2.0F);
/* 35 */     item("desert_boots").heatResistance(1.0F);
/*    */     
/* 37 */     item("jungle_chestplate").heatResistance(5.0F);
/* 38 */     item("jungle_leggings").heatResistance(3.0F);
/* 39 */     item("jungle_boots").heatResistance(2.0F);
/*    */     
/* 41 */     item("savanna_chestplate").heatResistance(4.0F);
/* 42 */     item("savanna_leggings").heatResistance(2.5F);
/* 43 */     item("savanna_boots").heatResistance(1.5F);
/*    */     
/* 45 */     item("wool_vest_chestplate").coldResistance(2.0F);
/* 46 */     item("chiton").heatResistance(2.0F);
/* 47 */     item("farmers_hat_helmet").heatResistance(3.5F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\WardrobeTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */