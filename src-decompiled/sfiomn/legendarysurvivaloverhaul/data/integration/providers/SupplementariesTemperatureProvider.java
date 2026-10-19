/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureBlockData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SupplementariesTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public SupplementariesTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("supplementaries", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     block("fire_pit")
/* 24 */       .addTemperature(temperatureBlock(12.5F).addProperty("lit", "true"))
/* 25 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 27 */     ITemperatureBlockData candleOn = temperatureBlock(1.5F).addProperty("lit", "true");
/* 28 */     ITemperatureBlockData candleOff = temperatureBlock(0.0F).addProperty("lit", "false");
/* 29 */     block("candle_holder").addTemperature(candleOn).addTemperature(candleOff);
/* 30 */     block("candle_holder_white").addTemperature(candleOn).addTemperature(candleOff);
/* 31 */     block("candle_holder_light_gray").addTemperature(candleOn).addTemperature(candleOff);
/* 32 */     block("candle_holder_gray").addTemperature(candleOn).addTemperature(candleOff);
/* 33 */     block("candle_holder_black").addTemperature(candleOn).addTemperature(candleOff);
/* 34 */     block("candle_holder_brown").addTemperature(candleOn).addTemperature(candleOff);
/* 35 */     block("candle_holder_red").addTemperature(candleOn).addTemperature(candleOff);
/* 36 */     block("candle_holder_orange").addTemperature(candleOn).addTemperature(candleOff);
/* 37 */     block("candle_holder_yellow").addTemperature(candleOn).addTemperature(candleOff);
/* 38 */     block("candle_holder_lime").addTemperature(candleOn).addTemperature(candleOff);
/* 39 */     block("candle_holder_green").addTemperature(candleOn).addTemperature(candleOff);
/* 40 */     block("candle_holder_cyan").addTemperature(candleOn).addTemperature(candleOff);
/* 41 */     block("candle_holder_light_blue").addTemperature(candleOn).addTemperature(candleOff);
/* 42 */     block("candle_holder_blue").addTemperature(candleOn).addTemperature(candleOff);
/* 43 */     block("candle_holder_purple").addTemperature(candleOn).addTemperature(candleOff);
/* 44 */     block("candle_holder_magenta").addTemperature(candleOn).addTemperature(candleOff);
/* 45 */     block("candle_holder_pink").addTemperature(candleOn).addTemperature(candleOff);
/*    */     
/* 47 */     ITemperatureBlockData sconceOn = temperatureBlock(2.5F).addProperty("lit", "true");
/* 48 */     ITemperatureBlockData sconceOff = temperatureBlock(0.0F).addProperty("lit", "false");
/* 49 */     block("sconce").addTemperature(sconceOn).addTemperature(sconceOff);
/* 50 */     block("sconce_lever").addTemperature(sconceOn).addTemperature(sconceOff);
/*    */     
/* 52 */     ITemperatureBlockData soulSconceOn = temperatureBlock(-2.5F).addProperty("lit", "true");
/* 53 */     ITemperatureBlockData soulSconceOff = temperatureBlock(0.0F).addProperty("lit", "false");
/* 54 */     block("soul_sconce").addTemperature(soulSconceOn).addTemperature(soulSconceOff);
/*    */     
/* 56 */     item("sconce").temperature(1.5F);
/* 57 */     item("sconce_lever").temperature(1.5F);
/* 58 */     item("soul_sconce").temperature(-1.5F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\SupplementariesTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */