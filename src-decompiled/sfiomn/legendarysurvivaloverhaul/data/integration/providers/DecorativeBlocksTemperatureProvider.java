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
/*    */ public class DecorativeBlocksTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public DecorativeBlocksTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("decorative_blocks", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 21 */     block("brazier")
/* 22 */       .addTemperature(temperatureBlock(12.5F).addProperty("lit", "true"))
/* 23 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 25 */     block("soul_brazier")
/* 26 */       .addTemperature(temperatureBlock(-12.5F).addProperty("lit", "true"))
/* 27 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\DecorativeBlocksTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */