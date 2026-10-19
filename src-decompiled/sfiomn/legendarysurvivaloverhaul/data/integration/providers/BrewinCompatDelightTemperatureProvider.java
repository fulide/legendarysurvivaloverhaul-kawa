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
/*    */ public class BrewinCompatDelightTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public BrewinCompatDelightTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 18 */     super("brewincompatdelight", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 25 */     ITemperatureConsumableData beer = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400);
/* 26 */     consumable("beer_knees").addTemperature(beer);
/* 27 */     consumable("brass_monkey").addTemperature(beer);
/*    */     
/* 29 */     ITemperatureConsumableData cocktail = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(2400);
/* 30 */     consumable("aqua_velva").addTemperature(cocktail);
/* 31 */     consumable("blue_curacao").addTemperature(cocktail);
/* 32 */     consumable("china_blue").addTemperature(cocktail);
/* 33 */     consumable("gin_and_juice").addTemperature(cocktail);
/* 34 */     consumable("gin_and_tonic").addTemperature(cocktail);
/* 35 */     consumable("half_and_half").addTemperature(cocktail);
/* 36 */     consumable("margarita").addTemperature(cocktail);
/* 37 */     consumable("mojito").addTemperature(cocktail);
/* 38 */     consumable("pina_colada").addTemperature(cocktail);
/* 39 */     consumable("salted_margarita").addTemperature(cocktail);
/* 40 */     consumable("singapore_sling").addTemperature(cocktail);
/* 41 */     consumable("tequila_sunrise").addTemperature(cocktail);
/*    */     
/* 43 */     ITemperatureConsumableData wine = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400);
/* 44 */     consumable("mulled_wine").addTemperature(wine);
/* 45 */     consumable("peach_wine").addTemperature(wine);
/* 46 */     consumable("red_wine").addTemperature(wine);
/* 47 */     consumable("sweet_red_wine").addTemperature(wine);
/* 48 */     consumable("white_wine").addTemperature(wine);
/*    */     
/* 50 */     ITemperatureConsumableData alcohol = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(2400);
/* 51 */     consumable("gin").addTemperature(alcohol);
/* 52 */     consumable("kraken_rum").addTemperature(alcohol);
/* 53 */     consumable("screwdriver").addTemperature(alcohol);
/* 54 */     consumable("tequila").addTemperature(alcohol);
/*    */     
/* 56 */     ITemperatureConsumableData soft = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400);
/* 57 */     consumable("hard_lemonade").addTemperature(soft);
/* 58 */     consumable("hard_cider").addTemperature(soft);
/* 59 */     consumable("lemon_lime").addTemperature(soft);
/* 60 */     consumable("mermaid_lemonade").addTemperature(soft);
/* 61 */     consumable("tonic_water").addTemperature(soft);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BrewinCompatDelightTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */