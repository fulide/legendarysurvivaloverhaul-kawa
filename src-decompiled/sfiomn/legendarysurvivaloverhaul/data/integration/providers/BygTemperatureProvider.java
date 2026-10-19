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
/*    */ public class BygTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public BygTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("byg", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     block("boric_fire")
/* 23 */       .addTemperature(temperatureBlock(5.0F));
/*    */     
/* 25 */     block("boric_campfire")
/* 26 */       .addTemperature(temperatureBlock(10.0F).addProperty("lit", "true"))
/* 27 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 29 */     block("cryptic_fire")
/* 30 */       .addTemperature(temperatureBlock(5.0F));
/*    */     
/* 32 */     block("cryptic_campfire")
/* 33 */       .addTemperature(temperatureBlock(7.5F).addProperty("lit", "true"))
/* 34 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BygTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */