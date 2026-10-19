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
/*    */ 
/*    */ 
/*    */ public class NeapolitanTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public NeapolitanTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 18 */     super("neapolitan", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     consumable("ice_cubes").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(3600));
/* 25 */     consumable("chocolate_ice_cream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(3600));
/* 26 */     consumable("vanilla_ice_cream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(3600));
/* 27 */     consumable("strawberry_ice_cream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(3600));
/* 28 */     consumable("banana_ice_cream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(3600));
/* 29 */     consumable("neapolitan_ice_cream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(3600));
/*    */     
/* 31 */     consumable("chocolate_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-3).duration(3600));
/* 32 */     consumable("vanilla_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-3).duration(3600));
/* 33 */     consumable("strawberry_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-3).duration(3600));
/* 34 */     consumable("banana_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-3).duration(3600));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\NeapolitanTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */