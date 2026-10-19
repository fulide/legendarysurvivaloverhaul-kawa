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
/*    */ public class SurvivalInstinctThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public SurvivalInstinctThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("survival_instinct", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 25 */     IThirstData beer_hydration = thirstData(8, 6.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F);
/* 26 */     consumable("beer").addThirst(beer_hydration);
/*    */ 
/*    */     
/* 29 */     IThirstData alcohol = thirstData(5, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 800, 0.4F);
/* 30 */     consumable("tequila").addThirst(alcohol);
/* 31 */     consumable("whiskey").addThirst(alcohol);
/*    */ 
/*    */     
/* 34 */     IThirstData wine = thirstData(7, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 400, 0.3F);
/* 35 */     consumable("wine").addThirst(wine);
/*    */     
/* 37 */     consumable("bean_can").addThirst(thirstData(3, 1.0F));
/* 38 */     consumable("cod_can").addThirst(thirstData(4, 1.0F));
/* 39 */     consumable("sardine_can").addThirst(thirstData(4, 1.0F));
/* 40 */     consumable("tuna_can").addThirst(thirstData(4, 1.0F));
/* 41 */     consumable("fruit_can").addThirst(thirstData(6, 2.0F));
/* 42 */     consumable("tomato_soup").addThirst(thirstData(6, 2.0F));
/* 43 */     consumable("military_can").addThirst(thirstData(4, 2.0F));
/* 44 */     consumable("milk").addThirst(thirstData(9, 4.0F));
/* 45 */     consumable("orange_juice").addThirst(thirstData(9, 4.0F));
/*    */     
/* 47 */     consumable("blue_soda").addThirst(thirstData(8, 3.5F));
/* 48 */     consumable("red_soda").addThirst(thirstData(8, 3.5F));
/* 49 */     consumable("lemon_soda").addThirst(thirstData(8, 3.5F));
/* 50 */     consumable("energy_can").addThirst(thirstData(8, 3.5F));
/* 51 */     consumable("monster_can").addThirst(thirstData(11, 4.0F));
/*    */     
/* 53 */     consumable("gallon_of_milk").addThirst(thirstData(10, 5.0F));
/* 54 */     consumable("gallon_of_water").addThirst(thirstData(10, 5.0F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\SurvivalInstinctThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */