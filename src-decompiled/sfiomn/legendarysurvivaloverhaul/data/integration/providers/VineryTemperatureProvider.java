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
/*    */ public class VineryTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public VineryTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("vinery", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     item("straw_hat").heatResistance(3.0F);
/*    */     
/* 25 */     consumable("eiswein").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(1200));
/* 26 */     consumable("cristel_wine").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(2400));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\VineryTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */