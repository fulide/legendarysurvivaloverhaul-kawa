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
/*    */ public class HardcoreTorchesTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public HardcoreTorchesTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("hardcore_torches", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     block("hardcore_campfire")
/* 23 */       .addTemperature(temperatureBlock(10.0F).addProperty("lit", "true"))
/* 24 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 26 */     block("lit_wall_torch").addTemperature(temperatureBlock(1.5F));
/* 27 */     block("lit_torch").addTemperature(temperatureBlock(1.5F));
/* 28 */     item("lit_torch").temperature(1.5F);
/*    */     
/* 30 */     block("smoldering_wall_torch").addTemperature(temperatureBlock(0.75F));
/* 31 */     block("smoldering_torch").addTemperature(temperatureBlock(0.75F));
/* 32 */     item("smoldering_torch").temperature(0.75F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\HardcoreTorchesTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */