/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HerbalBrewsTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public HerbalBrewsTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("herbalbrews", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     block("stove")
/* 24 */       .addTemperature(temperatureBlock(6.0F).addProperty("lit", "true"))
/* 25 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/* 26 */     block("cauldron").addTemperature(temperatureBlock(6.0F));
/* 27 */     block("tea_kettle")
/* 28 */       .addTemperature(temperatureBlock(4.0F).addProperty("lit", "true"))
/* 29 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/* 30 */     block("copper_tea_kettle")
/* 31 */       .addTemperature(temperatureBlock(4.0F).addProperty("lit", "true"))
/* 32 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 34 */     consumable("green_tea")
/* 35 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(2400));
/* 36 */     consumable("black_tea")
/* 37 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(3600));
/* 38 */     consumable("hibiscus_tea")
/* 39 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(3600));
/* 40 */     consumable("lavender_tea")
/* 41 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(3600));
/* 42 */     consumable("coffee")
/* 43 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(3600));
/* 44 */     consumable("milk_coffee")
/* 45 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(3600));
/* 46 */     consumable("rooibos_tea")
/* 47 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(1200));
/* 48 */     consumable("oolong_tea")
/* 49 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(2400));
/* 50 */     consumable("yerba_mate_tea")
/* 51 */       .addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(3600));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\HerbalBrewsTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */