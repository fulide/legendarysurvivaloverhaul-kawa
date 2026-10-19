/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureBlockData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.ITemperatureConsumableData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemporaryModifierGroupEnum;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CandlelightTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public CandlelightTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 20 */     super("candlelight", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 27 */     consumable("beetroot_salad").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/* 28 */     consumable("salad").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/* 29 */     consumable("fresh_garden_salad").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/* 30 */     consumableAndConsumableBlock("tomato_mozzarella_salad", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/* 31 */     consumable("harvest_plate").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/*    */     
/* 33 */     consumable("fricasse").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(2400));
/* 34 */     consumable("roastbeef_carrots").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(2400));
/* 35 */     consumable("bolognese").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(2400));
/* 36 */     consumableAndConsumableBlock("beef_wellington", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(2).duration(2400));
/* 37 */     consumableAndConsumableBlock("lasagne", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(2).duration(2400));
/* 38 */     consumable("pasta_with_bolognese").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(2).duration(2400));
/* 39 */     consumable("beef_with_mushroom_in_wine_and_potatoes").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(3).duration(4800));
/*    */     
/* 41 */     ITemperatureConsumableData soupTemperatureData = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(3600);
/* 42 */     consumable("tomato_soup").addTemperature(soupTemperatureData);
/* 43 */     consumable("mushroom_soup").addTemperature(soupTemperatureData);
/*    */     
/* 45 */     ITemperatureBlockData stoveTemp = temperatureBlock(6.0F).addProperty("lit", "true");
/* 46 */     ITemperatureBlockData stoveTempOff = temperatureBlock(0.0F).addProperty("lit", "false");
/* 47 */     block("cobblestone_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 48 */     block("sandstone_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 49 */     block("stone_bricks_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 50 */     block("deepslate_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 51 */     block("granit_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 52 */     block("end_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 53 */     block("mud_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 54 */     block("quartz_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 55 */     block("red_nether_bricks_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 56 */     block("basalt_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/* 57 */     block("bamboo_stove").addTemperature(stoveTemp).addTemperature(stoveTempOff);
/*    */     
/* 59 */     item("flower_crown").heatResistance(1.0F);
/* 60 */     item("necktie").heatResistance(1.0F);
/* 61 */     item("dress").heatResistance(1.5F);
/* 62 */     item("shirt").heatResistance(1.5F);
/*    */     
/* 64 */     item("cooking_hat").heatResistance(1.0F);
/* 65 */     item("chefs_jacket").heatResistance(1.5F);
/* 66 */     item("chefs_pants").heatResistance(1.0F);
/* 67 */     item("chefs_boots").heatResistance(0.5F);
/*    */     
/* 69 */     item("trousers_and_vest").heatResistance(1.0F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CandlelightTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */