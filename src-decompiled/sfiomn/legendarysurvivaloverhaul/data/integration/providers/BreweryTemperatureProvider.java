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
/*    */ public class BreweryTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public BreweryTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 19 */     super("brewery", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 26 */     consumableAndConsumableBlock("fried_chicken", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(2400));
/* 27 */     consumableAndConsumableBlock("pork_knuckle", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(2400));
/* 28 */     consumableAndConsumableBlock("half_chicken", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(2400));
/*    */     
/* 30 */     consumableAndConsumableBlock("potato_salad", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/*    */     
/* 32 */     ITemperatureConsumableData whiskeyTemperature = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(2400);
/* 33 */     consumableAndConsumableBlock("whiskey_jojannik", whiskeyTemperature);
/* 34 */     consumableAndConsumableBlock("whiskey_lilitusinglemalt", whiskeyTemperature);
/* 35 */     consumableAndConsumableBlock("whiskey_cristelwalker", whiskeyTemperature);
/* 36 */     consumableAndConsumableBlock("whiskey_maggoallan", whiskeyTemperature);
/* 37 */     consumableAndConsumableBlock("whiskey_carrasconlabel", whiskeyTemperature);
/* 38 */     consumableAndConsumableBlock("whiskey_ak", whiskeyTemperature);
/* 39 */     consumableAndConsumableBlock("whiskey_highland_hearth", whiskeyTemperature);
/* 40 */     consumableAndConsumableBlock("whiskey_smokey_reverie", whiskeyTemperature);
/* 41 */     consumableAndConsumableBlock("whiskey_jamesons_malt", whiskeyTemperature);
/*    */     
/* 43 */     ITemperatureConsumableData beerTemperature = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400);
/* 44 */     consumableAndConsumableBlock("beer_wheat", beerTemperature);
/* 45 */     consumableAndConsumableBlock("beer_barley", beerTemperature);
/* 46 */     consumableAndConsumableBlock("beer_hops", beerTemperature);
/* 47 */     consumableAndConsumableBlock("beer_nettle", beerTemperature);
/* 48 */     consumableAndConsumableBlock("beer_oat", beerTemperature);
/* 49 */     consumableAndConsumableBlock("beer_haley", beerTemperature);
/*    */     
/* 51 */     item("brewfest_hat").heatResistance(1.0F);
/* 52 */     item("brewfest_regalia").heatResistance(1.5F);
/* 53 */     item("brewfest_trousers").heatResistance(1.0F);
/* 54 */     item("brewfest_boots").heatResistance(0.5F);
/*    */     
/* 56 */     item("brewfest_hat_red").heatResistance(1.0F);
/* 57 */     item("brewfest_blouse").heatResistance(1.5F);
/* 58 */     item("brewfest_dress").heatResistance(1.0F);
/* 59 */     item("brewfest_shoes").heatResistance(0.5F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BreweryTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */