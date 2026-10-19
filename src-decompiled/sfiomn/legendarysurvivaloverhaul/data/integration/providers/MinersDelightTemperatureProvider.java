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
/*    */ public class MinersDelightTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public MinersDelightTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("miners_delight", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     ITemperatureConsumableData soupTemperature = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(2400);
/* 25 */     consumable("beetroot_soup_cup").addTemperature(soupTemperature);
/* 26 */     consumable("cave_soup_cup").addTemperature(soupTemperature);
/* 27 */     consumable("bat_soup_cup").addTemperature(soupTemperature);
/* 28 */     consumable("vegetable_soup_cup").addTemperature(soupTemperature);
/* 29 */     consumable("noodle_soup_cup").addTemperature(soupTemperature);
/* 30 */     consumable("chicken_soup_cup").addTemperature(soupTemperature);
/* 31 */     consumable("pumpkin_soup_cup").addTemperature(soupTemperature);
/*    */     
/* 33 */     ITemperatureConsumableData soupTemperature2 = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(2400);
/* 34 */     consumable("cave_soup").addTemperature(soupTemperature2);
/* 35 */     consumable("bat_soup").addTemperature(soupTemperature2);
/*    */     
/* 37 */     ITemperatureConsumableData stewTemperature = temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(2400);
/* 38 */     consumable("mushroom_stew_cup").addTemperature(stewTemperature);
/* 39 */     consumable("insect_stew_cup").addTemperature(stewTemperature);
/* 40 */     consumable("fish_stew_cup").addTemperature(stewTemperature);
/* 41 */     consumable("rabbit_stew_cup").addTemperature(stewTemperature);
/* 42 */     consumable("beef_stew_cup").addTemperature(stewTemperature);
/* 43 */     consumable("baked_cod_stew_cup").addTemperature(stewTemperature);
/*    */     
/* 45 */     ITemperatureConsumableData stewTemperature2 = temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(2).duration(2400);
/* 46 */     consumable("insect_stew").addTemperature(stewTemperature2);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\MinersDelightTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */