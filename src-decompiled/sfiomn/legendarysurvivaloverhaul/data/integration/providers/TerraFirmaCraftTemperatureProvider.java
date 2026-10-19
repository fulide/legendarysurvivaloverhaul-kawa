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
/*    */ public class TerraFirmaCraftTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public TerraFirmaCraftTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("tfc", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 21 */     block("firepit")
/* 22 */       .addTemperature(temperatureBlock(8.0F).addProperty("lit", "true"))
/* 23 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 25 */     block("pot")
/* 26 */       .addTemperature(temperatureBlock(8.0F).addProperty("lit", "true"))
/* 27 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 29 */     block("charcoal_forge")
/* 30 */       .addTemperature(temperatureBlock(15.0F).addProperty("heat_level", "6"))
/* 31 */       .addTemperature(temperatureBlock(13.0F).addProperty("heat_level", "5"))
/* 32 */       .addTemperature(temperatureBlock(11.0F).addProperty("heat_level", "4"))
/* 33 */       .addTemperature(temperatureBlock(9.0F).addProperty("heat_level", "3"))
/* 34 */       .addTemperature(temperatureBlock(6.0F).addProperty("heat_level", "2"))
/* 35 */       .addTemperature(temperatureBlock(3.0F).addProperty("heat_level", "1"))
/* 36 */       .addTemperature(temperatureBlock(0.0F).addProperty("heat_level", "0"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\TerraFirmaCraftTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */