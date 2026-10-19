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
/*    */ public class FarmAndCharmTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public FarmAndCharmTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 19 */     super("farm_and_charm", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 26 */     consumable("farmer_salad").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-1).duration(2400));
/*    */     
/* 28 */     consumable("goulash").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(3).duration(4800));
/* 29 */     consumable("chicken_wrapped_in_bacon").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(4800));
/* 30 */     consumableAndConsumableBlock("stuffed_rabbit", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(2400));
/* 31 */     consumableAndConsumableBlock("stuffed_chicken", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(2400));
/* 32 */     consumableAndConsumableBlock("farmers_breakfast", temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(7200));
/* 33 */     consumable("sausage_with_oat_patty").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(2).duration(4800));
/*    */     
/* 35 */     ITemperatureConsumableData soupTemperatureData = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(3600);
/* 36 */     consumable("simple_tomato_soup").addTemperature(soupTemperatureData);
/* 37 */     consumable("barley_soup").addTemperature(soupTemperatureData);
/* 38 */     consumable("onion_soup").addTemperature(soupTemperatureData);
/* 39 */     consumable("potato_soup").addTemperature(soupTemperatureData);
/*    */     
/* 41 */     consumable("strawberry_tea").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(3600));
/* 42 */     consumable("nettle_tea").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(3600));
/* 43 */     consumable("ribwort_tea").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(3600));
/* 44 */     consumable("strawberry_tea_cup").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400));
/* 45 */     consumable("nettle_tea_cup").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400));
/* 46 */     consumable("ribwort_tea_cup").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400));
/*    */     
/* 48 */     block("roaster")
/* 49 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"))
/* 50 */       .addTemperature(temperatureBlock(4.0F).addProperty("lit", "true"));
/*    */     
/* 52 */     block("cooking_pot")
/* 53 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"))
/* 54 */       .addTemperature(temperatureBlock(3.0F).addProperty("lit", "true"));
/*    */     
/* 56 */     block("stove")
/* 57 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"))
/* 58 */       .addTemperature(temperatureBlock(6.0F).addProperty("lit", "true"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\FarmAndCharmTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */