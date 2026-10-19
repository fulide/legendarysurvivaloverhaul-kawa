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
/*    */ public class BrewinCompatDelightThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public BrewinCompatDelightThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("brewincompatdelight", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     consumable("brass_monkey").addThirst(thirstData(4, 0.0F));
/*    */ 
/*    */     
/* 27 */     IThirstData beer = thirstData(8, 6.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F);
/* 28 */     consumable("beer_knees").addThirst(beer);
/* 29 */     consumable("brass_monkey").addThirst(beer);
/*    */ 
/*    */     
/* 32 */     IThirstData cocktail = thirstData(9, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 500, 0.3F);
/* 33 */     consumable("aqua_velva").addThirst(cocktail);
/* 34 */     consumable("blue_curacao").addThirst(cocktail);
/* 35 */     consumable("china_blue").addThirst(cocktail);
/* 36 */     consumable("gin_and_juice").addThirst(cocktail);
/* 37 */     consumable("gin_and_tonic").addThirst(cocktail);
/* 38 */     consumable("half_and_half").addThirst(cocktail);
/* 39 */     consumable("margarita").addThirst(cocktail);
/* 40 */     consumable("mojito").addThirst(cocktail);
/* 41 */     consumable("pina_colada").addThirst(cocktail);
/* 42 */     consumable("salted_margarita").addThirst(cocktail);
/* 43 */     consumable("singapore_sling").addThirst(cocktail);
/* 44 */     consumable("tequila_sunrise").addThirst(cocktail);
/*    */ 
/*    */     
/* 47 */     IThirstData wine = thirstData(7, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 400, 0.3F);
/* 48 */     consumable("mulled_wine").addThirst(wine);
/* 49 */     consumable("peach_wine").addThirst(wine);
/* 50 */     consumable("red_wine").addThirst(wine);
/* 51 */     consumable("sweet_red_wine").addThirst(wine);
/* 52 */     consumable("white_wine").addThirst(wine);
/*    */ 
/*    */     
/* 55 */     IThirstData alcohol = thirstData(5, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 800, 0.4F);
/* 56 */     consumable("gin").addThirst(alcohol);
/* 57 */     consumable("kraken_rum").addThirst(alcohol);
/* 58 */     consumable("screwdriver").addThirst(alcohol);
/* 59 */     consumable("tequila").addThirst(alcohol);
/*    */     
/* 61 */     IThirstData soft = thirstData(5, 2.0F);
/* 62 */     consumable("hard_lemonade").addThirst(soft);
/* 63 */     consumable("hard_cider").addThirst(soft);
/* 64 */     consumable("lemon_lime").addThirst(soft);
/* 65 */     consumable("mermaid_lemonade").addThirst(soft);
/* 66 */     consumable("tonic_water").addThirst(soft);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BrewinCompatDelightThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */