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
/*    */ public class RealisticTorchesTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public RealisticTorchesTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("realistictorches", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     block("torch")
/* 23 */       .addTemperature(temperatureBlock(1.5F).addProperty("litstate", "2"))
/* 24 */       .addTemperature(temperatureBlock(0.75F).addProperty("litstate", "1"))
/* 25 */       .addTemperature(temperatureBlock(0.0F).addProperty("litstate", "0"));
/* 26 */     block("torch_wall")
/* 27 */       .addTemperature(temperatureBlock(1.5F).addProperty("litstate", "2"))
/* 28 */       .addTemperature(temperatureBlock(0.75F).addProperty("litstate", "1"))
/* 29 */       .addTemperature(temperatureBlock(0.0F).addProperty("litstate", "0"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\RealisticTorchesTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */