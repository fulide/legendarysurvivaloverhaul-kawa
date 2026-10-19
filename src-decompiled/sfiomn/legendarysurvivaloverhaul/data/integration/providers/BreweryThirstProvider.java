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
/*    */ public class BreweryThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public BreweryThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("brewery", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     IThirstData whiskey_hydration = thirstData(5, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 800, 0.4F);
/* 25 */     consumableAndBlock("whiskey_jojannik", whiskey_hydration);
/* 26 */     consumableAndBlock("whiskey_lilitusinglemalt", whiskey_hydration);
/* 27 */     consumableAndBlock("whiskey_cristelwalker", whiskey_hydration);
/* 28 */     consumableAndBlock("whiskey_maggoallan", whiskey_hydration);
/* 29 */     consumableAndBlock("whiskey_carrasconlabel", whiskey_hydration);
/* 30 */     consumableAndBlock("whiskey_ak", whiskey_hydration);
/* 31 */     consumableAndBlock("whiskey_highland_hearth", whiskey_hydration);
/* 32 */     consumableAndBlock("whiskey_smokey_reverie", whiskey_hydration);
/* 33 */     consumableAndBlock("whiskey_jamesons_malt", whiskey_hydration);
/*    */     
/* 35 */     IThirstData beer_hydration = thirstData(8, 6.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F);
/* 36 */     consumableAndBlock("beer_wheat", beer_hydration);
/* 37 */     consumableAndBlock("beer_barley", beer_hydration);
/* 38 */     consumableAndBlock("beer_hops", beer_hydration);
/* 39 */     consumableAndBlock("beer_nettle", beer_hydration);
/* 40 */     consumableAndBlock("beer_oat", beer_hydration);
/* 41 */     consumableAndBlock("beer_haley", beer_hydration);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BreweryThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */