/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.ThirstDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ 
/*    */ 
/*    */ public class HearthAndHarvestThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public HearthAndHarvestThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("hearthandharvest", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     consumable("goat_milk_bottle").addThirst(thirstData(6, 1.0F));
/*    */     
/* 25 */     consumable("mead")
/* 26 */       .addThirst(thirstData(7, 4.0F)
/* 27 */         .addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/*    */     
/* 29 */     consumable("blueberries").addThirst(thirstData(4, 0.0F));
/* 30 */     consumable("blueberry_juice").addThirst(thirstData(6, 3.0F));
/* 31 */     consumable("blueberry_wine")
/* 32 */       .addThirst(thirstData(7, 4.0F)
/* 33 */         .addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/*    */     
/* 35 */     consumable("cherry").addThirst(thirstData(4, 0.0F));
/* 36 */     consumable("cherry_juice").addThirst(thirstData(6, 3.0F));
/* 37 */     consumable("cherry_wine")
/* 38 */       .addThirst(thirstData(7, 4.0F)
/* 39 */         .addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/*    */     
/* 41 */     consumable("green_grapes").addThirst(thirstData(4, 0.0F));
/* 42 */     consumable("green_grape_juice").addThirst(thirstData(6, 3.0F));
/* 43 */     consumable("green_grape_wine")
/* 44 */       .addThirst(thirstData(7, 4.0F)
/* 45 */         .addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/*    */     
/* 47 */     consumable("raspberry").addThirst(thirstData(4, 0.0F));
/* 48 */     consumable("raspberry_juice").addThirst(thirstData(6, 3.0F));
/* 49 */     consumable("raspberry_wine")
/* 50 */       .addThirst(thirstData(7, 4.0F)
/* 51 */         .addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/*    */     
/* 53 */     consumable("red_grapes").addThirst(thirstData(4, 0.0F));
/* 54 */     consumable("red_grape_juice").addThirst(thirstData(6, 3.0F));
/* 55 */     consumable("red_grape_wine")
/* 56 */       .addThirst(thirstData(7, 4.0F)
/* 57 */         .addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/*    */     
/* 59 */     consumable("sweet_berry_wine")
/* 60 */       .addThirst(thirstData(7, 4.0F)
/* 61 */         .addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\HearthAndHarvestThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */