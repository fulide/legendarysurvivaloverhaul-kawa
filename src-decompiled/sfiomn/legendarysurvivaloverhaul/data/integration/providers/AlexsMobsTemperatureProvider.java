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
/*    */ public class AlexsMobsTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public AlexsMobsTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("alexsmobs", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     item("roadrunner_boots").heatResistance(1.0F);
/* 23 */     item("crocodile_chestplate").coldResistance(1.0F);
/* 24 */     item("centipede_leggings").heatResistance(1.0F);
/* 25 */     item("frontier_cap").coldResistance(4.0F);
/* 26 */     item("sombrero").heatResistance(4.0F);
/* 27 */     item("emu_leggings").heatResistance(1.5F);
/* 28 */     item("froststalker_helmet").heatResistance(3.0F);
/* 29 */     item("unsettling_kimono").heatResistance(2.0F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\AlexsMobsTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */