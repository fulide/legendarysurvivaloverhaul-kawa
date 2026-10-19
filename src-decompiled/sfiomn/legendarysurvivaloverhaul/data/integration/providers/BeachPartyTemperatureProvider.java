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
/*    */ public class BeachPartyTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public BeachPartyTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 18 */     super("beachparty", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 25 */     consumable("sweetberry_icecream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-2).duration(1200));
/* 26 */     consumable("coconut_icecream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-2).duration(1200));
/* 27 */     consumable("chocolate_icecream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-2).duration(1200));
/* 28 */     consumable("icecream_coconut").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-2).duration(1200));
/* 29 */     consumable("icecream_cactus").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-2).duration(1200));
/* 30 */     consumable("icecream_chocolate").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-2).duration(1200));
/* 31 */     consumable("icecream_sweetberries").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-2).duration(1200));
/* 32 */     consumable("icecream_melon").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-2).duration(1200));
/*    */     
/* 34 */     consumable("coconut_cocktail").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400));
/* 35 */     consumable("sweetberries_cocktail").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400));
/* 36 */     consumable("cocoa_cocktail").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(2400));
/* 37 */     consumable("pumpkin_cocktail").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400));
/* 38 */     consumable("melon_cocktail").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400));
/* 39 */     consumable("honey_cocktail").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400));
/* 40 */     consumable("refreshing_drink").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(2400));
/* 41 */     consumable("sweetberry_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-3).duration(4800));
/* 42 */     consumable("coconut_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(1800));
/* 43 */     consumable("chocolate_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(1800));
/*    */     
/* 45 */     item("beach_hat").heatResistance(2.5F);
/* 46 */     item("trunks").heatResistance(3.0F);
/* 47 */     item("bikini").heatResistance(3.0F);
/* 48 */     item("crocs").heatResistance(0.5F);
/* 49 */     item("palm_torch_item").temperature(1.5F);
/* 50 */     item("tall_palm_torch").temperature(2.0F);
/* 51 */     block("palm_torch_item").addTemperature(temperatureBlock(1.5F));
/* 52 */     block("tall_palm_torch").addTemperature(temperatureBlock(2.0F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BeachPartyTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */