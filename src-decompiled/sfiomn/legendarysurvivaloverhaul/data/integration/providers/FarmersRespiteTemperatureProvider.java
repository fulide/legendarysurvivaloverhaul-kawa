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
/*    */ public class FarmersRespiteTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public FarmersRespiteTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 19 */     super("farmersrespite", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 26 */     consumable("coffee").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(2400));
/* 27 */     consumable("long_coffee").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(4800));
/* 28 */     consumable("strong_coffee").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(3).duration(2400));
/*    */     
/* 30 */     consumable("strong_hot_cocoa").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(4).duration(3600));
/* 31 */     consumable("strong_melon_juice").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(-2).duration(2400));
/*    */     
/* 33 */     ITemperatureConsumableData teaTemperature = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(2400);
/* 34 */     consumable("black_tea").addTemperature(teaTemperature);
/* 35 */     consumable("dandelion_tea").addTemperature(teaTemperature);
/* 36 */     consumable("gamblers_tea").addTemperature(teaTemperature);
/* 37 */     consumable("green_tea").addTemperature(teaTemperature);
/* 38 */     consumable("yellow_tea").addTemperature(teaTemperature);
/* 39 */     consumable("rose_hip_tea").addTemperature(teaTemperature);
/* 40 */     consumable("purulent_tea").addTemperature(teaTemperature);
/*    */     
/* 42 */     ITemperatureConsumableData longTeaTemperature = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(1).duration(4800);
/* 43 */     consumable("long_black_tea").addTemperature(longTeaTemperature);
/* 44 */     consumable("long_dandelion_tea").addTemperature(longTeaTemperature);
/* 45 */     consumable("long_gamblers_tea").addTemperature(longTeaTemperature);
/* 46 */     consumable("long_green_tea").addTemperature(longTeaTemperature);
/* 47 */     consumable("long_yellow_tea").addTemperature(longTeaTemperature);
/* 48 */     consumable("long_rose_hip_tea").addTemperature(longTeaTemperature);
/* 49 */     consumable("long_purulent_tea").addTemperature(longTeaTemperature);
/*    */     
/* 51 */     ITemperatureConsumableData strongTeaTemperature = temperatureConsumable(TemporaryModifierGroupEnum.DRINK).temperatureLevel(2).duration(2400);
/* 52 */     consumable("strong_black_tea").addTemperature(strongTeaTemperature);
/* 53 */     consumable("long_dandelion_tea").addTemperature(strongTeaTemperature);
/* 54 */     consumable("strong_gamblers_tea").addTemperature(strongTeaTemperature);
/* 55 */     consumable("strong_green_tea").addTemperature(strongTeaTemperature);
/* 56 */     consumable("strong_yellow_tea").addTemperature(strongTeaTemperature);
/* 57 */     consumable("strong_rose_hip_tea").addTemperature(strongTeaTemperature);
/* 58 */     consumable("strong_purulent_tea").addTemperature(strongTeaTemperature);
/*    */     
/* 60 */     consumable("blazing_chili").addTemperature(temperatureConsumable(TemporaryModifierGroupEnum.FOOD).temperatureLevel(3).duration(4800));
/*    */     
/* 62 */     block("kettle")
/* 63 */       .addTemperature(temperatureBlock(0.0F).addProperty("lid", "false"))
/* 64 */       .addTemperature(temperatureBlock(4.0F).addProperty("lid", "true"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\FarmersRespiteTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */