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
/*    */ 
/*    */ public class GraveyardTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public GraveyardTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("graveyard", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     block("fire_brazier")
/* 23 */       .addTemperature(temperatureBlock(12.5F).addProperty("lit", "true"))
/* 24 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 26 */     block("soul_fire_brazier")
/* 27 */       .addTemperature(temperatureBlock(-12.5F).addProperty("lit", "true"))
/* 28 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\GraveyardTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */