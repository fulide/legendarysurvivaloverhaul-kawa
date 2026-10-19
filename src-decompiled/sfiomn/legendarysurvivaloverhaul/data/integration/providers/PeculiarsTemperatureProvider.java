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
/*    */ public class PeculiarsTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public PeculiarsTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 18 */     super("peculiars", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     consumable("yucca_ice_cream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(3600));
/* 25 */     consumable("aloe_ice_cream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(3600));
/* 26 */     consumable("passionfruit_ice_cream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(3600));
/*    */     
/* 28 */     consumable("yucca_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-3).duration(3600));
/* 29 */     consumable("aloe_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-3).duration(3600));
/* 30 */     consumable("passionfruit_milkshake").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-3).duration(3600));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\PeculiarsTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */