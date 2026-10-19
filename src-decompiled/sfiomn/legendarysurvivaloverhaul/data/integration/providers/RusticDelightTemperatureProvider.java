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
/*    */ public class RusticDelightTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public RusticDelightTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 19 */     super("rusticdelight", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 26 */     ITemperatureConsumableData coffee = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(2400);
/* 27 */     consumable("dark_coffee").addTemperature(coffee);
/* 28 */     consumable("coffee").addTemperature(coffee);
/* 29 */     consumable("milk_coffee").addTemperature(coffee);
/* 30 */     consumable("syrup_coffee").addTemperature(coffee);
/* 31 */     consumable("chocolate_coffee").addTemperature(coffee);
/* 32 */     consumable("honey_coffee").addTemperature(coffee);
/*    */     
/* 34 */     consumable("bell_pepper_green").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/* 35 */     consumable("bell_pepper_yellow").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/* 36 */     consumable("bell_pepper_red").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/*    */     
/* 38 */     consumable("potato_salad").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/* 39 */     consumable("sweet_salad").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\RusticDelightTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */