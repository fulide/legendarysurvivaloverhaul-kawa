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
/*    */ public class MeadowTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public MeadowTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("meadow", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     block("stove_tiles_wood")
/* 24 */       .addTemperature(temperatureBlock(6.0F).addProperty("lit", "true"))
/* 25 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/* 26 */     block("stove_tiles_lid")
/* 27 */       .addTemperature(temperatureBlock(6.0F).addProperty("lit", "true"))
/* 28 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/* 29 */     block("cooking_cauldron")
/* 30 */       .addTemperature(temperatureBlock(4.0F).addProperty("lit", "true"))
/* 31 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/* 32 */     block("fondue")
/* 33 */       .addTemperature(temperatureBlock(4.0F).addProperty("lit", "true"))
/* 34 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/* 35 */     block("frame").addTemperature(temperatureBlock(10.0F));
/*    */     
/* 37 */     block("oil_lantern").addTemperature(temperatureBlock(1.5F));
/* 38 */     item("oil_lantern").temperature(1.5F);
/*    */     
/* 40 */     item("fur_helmet").heatResistance(2.0F);
/* 41 */     item("fur_chestplate").heatResistance(3.5F);
/* 42 */     item("fur_leggings").heatResistance(3.0F);
/* 43 */     item("fur_boots").heatResistance(1.0F);
/*    */     
/* 45 */     consumable("sausage_with_cheese").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(2).duration(2400));
/* 46 */     consumable("roasted_ham").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(2).duration(3600));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\MeadowTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */