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
/*    */ public class CrockpotTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public CrockpotTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 18 */     super("crockpot", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 25 */     block("crock_pot")
/* 26 */       .addTemperature(temperatureBlock(7.5F).addProperty("lit", "true"))
/* 27 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 29 */     block("portable_crock_pot")
/* 30 */       .addTemperature(temperatureBlock(7.5F).addProperty("lit", "true"))
/* 31 */       .addTemperature(temperatureBlock(0.0F).addProperty("lit", "false"));
/*    */     
/* 33 */     consumable("iced_tea").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(4800));
/* 34 */     consumable("tea").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(3).duration(4800));
/* 35 */     consumable("fruit_medley").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-1).duration(1200));
/* 36 */     consumable("hot_cocoa").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(2400));
/*    */     
/* 38 */     consumable("ice_cream").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(1200));
/* 39 */     consumable("bone_stew").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(3).duration(2400));
/* 40 */     consumable("bunny_stew").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(1).duration(1200));
/* 41 */     consumable("flower_salad").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-3).duration(6000));
/* 42 */     consumable("hot_chili").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(2).duration(2400));
/* 43 */     consumable("pepper_popper").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(3).duration(6000));
/* 44 */     consumable("salsa").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-2).duration(2400));
/* 45 */     consumable("watermelon_icle").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(-4).duration(1800));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CrockpotTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */