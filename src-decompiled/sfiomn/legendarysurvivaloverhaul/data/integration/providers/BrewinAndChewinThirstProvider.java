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
/*    */ public class BrewinAndChewinThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public BrewinAndChewinThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("brewinandchewin", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 25 */     IThirstData drink0 = thirstData(3, 2.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.3F);
/* 26 */     consumable("saccharine_rum").addThirst(drink0);
/*    */ 
/*    */     
/* 29 */     IThirstData drink1 = thirstData(8, 6.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F);
/* 30 */     consumable("beer").addThirst(drink1);
/* 31 */     consumable("bloody_mary").addThirst(drink1);
/* 32 */     consumable("dread_nog").addThirst(drink1);
/* 33 */     consumable("egg_grog").addThirst(drink1);
/* 34 */     consumable("mead").addThirst(drink1);
/* 35 */     consumable("steel_toe_stout").addThirst(drink1);
/* 36 */     consumable("strongroot_ale").addThirst(drink1);
/*    */ 
/*    */     
/* 39 */     IThirstData drink2 = thirstData(10, 6.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F);
/* 40 */     consumable("glittering_grenadine").addThirst(drink2);
/* 41 */     consumable("kombucha").addThirst(drink2);
/*    */ 
/*    */     
/* 44 */     IThirstData drink3 = thirstData(5, 4.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 1000, 0.4F);
/* 45 */     consumable("pale_jane").addThirst(drink3);
/* 46 */     consumable("vodka").addThirst(drink3);
/* 47 */     consumable("red_rum").addThirst(drink3);
/* 48 */     consumable("rice_wine").addThirst(drink3);
/* 49 */     consumable("salty_folly").addThirst(drink3);
/*    */     
/* 51 */     consumable("withering_dross").addThirst(thirstData(12, 7.0F)
/* 52 */         .addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 1200));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BrewinAndChewinThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */