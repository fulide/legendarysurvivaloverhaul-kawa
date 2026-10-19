/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IThirstData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.ThirstDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ 
/*    */ 
/*    */ public class FarmersRespiteThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public FarmersRespiteThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("farmersrespite", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     consumable("coffee").addThirst(thirstData(5, 3.5F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/* 25 */     consumable("long_coffee").addThirst(thirstData(7, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/* 26 */     consumable("strong_coffee").addThirst(thirstData(5, 3.5F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.4F));
/*    */     
/* 28 */     consumable("long_apple_cider").addThirst(thirstData(10, 4.0F));
/* 29 */     consumable("strong_apple_cider").addThirst(thirstData(5, 2.0F));
/* 30 */     consumable("strong_hot_cocoa").addThirst(thirstData(6, 3.0F));
/* 31 */     consumable("strong_melon_juice").addThirst(thirstData(8, 4.0F));
/*    */     
/* 33 */     IThirstData teaTemperature = thirstData(5, 3.0F);
/* 34 */     consumable("black_tea").addThirst(teaTemperature);
/* 35 */     consumable("dandelion_tea").addThirst(teaTemperature);
/* 36 */     consumable("gamblers_tea").addThirst(teaTemperature.copy().addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.5F));
/* 37 */     consumable("green_tea").addThirst(teaTemperature);
/* 38 */     consumable("yellow_tea").addThirst(teaTemperature);
/* 39 */     consumable("rose_hip_tea").addThirst(teaTemperature);
/* 40 */     consumable("purulent_tea").addThirst(teaTemperature);
/*    */     
/* 42 */     IThirstData longTeaTemperature = thirstData(7, 4.0F);
/* 43 */     consumable("long_black_tea").addThirst(longTeaTemperature);
/* 44 */     consumable("long_dandelion_tea").addThirst(longTeaTemperature);
/* 45 */     consumable("long_gamblers_tea").addThirst(longTeaTemperature.copy().addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.5F));
/* 46 */     consumable("long_green_tea").addThirst(longTeaTemperature);
/* 47 */     consumable("long_yellow_tea").addThirst(longTeaTemperature);
/* 48 */     consumable("long_rose_hip_tea").addThirst(longTeaTemperature);
/* 49 */     consumable("long_purulent_tea").addThirst(longTeaTemperature);
/*    */     
/* 51 */     IThirstData strongTeaTemperature = thirstData(5, 3.0F);
/* 52 */     consumable("strong_black_tea").addThirst(strongTeaTemperature);
/* 53 */     consumable("long_dandelion_tea").addThirst(strongTeaTemperature);
/* 54 */     consumable("strong_gamblers_tea").addThirst(strongTeaTemperature.copy().addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.5F));
/* 55 */     consumable("strong_green_tea").addThirst(strongTeaTemperature);
/* 56 */     consumable("strong_yellow_tea").addThirst(strongTeaTemperature);
/* 57 */     consumable("strong_rose_hip_tea").addThirst(strongTeaTemperature);
/* 58 */     consumable("strong_purulent_tea").addThirst(strongTeaTemperature);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\FarmersRespiteThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */