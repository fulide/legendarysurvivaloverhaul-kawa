/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BrewinAndChewinTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public BrewinAndChewinTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 19 */     super("brewinandchewin", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 26 */     ITemperatureConsumableData drinkTemperature = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400);
/* 27 */     consumable("beer").addTemperature(drinkTemperature);
/* 28 */     consumable("bloody_mary").addTemperature(drinkTemperature);
/* 29 */     consumable("mead").addTemperature(drinkTemperature);
/* 30 */     consumable("pale_jane").addTemperature(drinkTemperature);
/* 31 */     consumable("steel_toe_stout").addTemperature(drinkTemperature);
/* 32 */     consumable("strongroot_ale").addTemperature(drinkTemperature);
/*    */     
/* 34 */     ITemperatureConsumableData drinkTemperature2 = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(2400);
/* 35 */     consumable("glittering_grenadine").addTemperature(drinkTemperature2);
/* 36 */     consumable("kombucha").addTemperature(drinkTemperature2);
/*    */     
/* 38 */     consumable("egg_grog").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(2400));
/* 39 */     consumable("vodka").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(2400));
/* 40 */     consumable("dread_nog").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(2400));
/* 41 */     consumable("red_rum").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(3).duration(2400));
/* 42 */     consumable("saccharine_rum").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(3).duration(2400));
/*    */     
/* 44 */     consumable("fiery_fondue").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(3).duration(3600));
/*    */     
/* 46 */     block("fiery_fondue_pot")
/* 47 */       .addTemperature(temperatureBlock(5.0F).addProperty("level", "3"))
/* 48 */       .addTemperature(temperatureBlock(4.0F).addProperty("level", "2"))
/* 49 */       .addTemperature(temperatureBlock(2.0F).addProperty("level", "1"))
/* 50 */       .addTemperature(temperatureBlock(0.0F).addProperty("level", "0"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BrewinAndChewinTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */