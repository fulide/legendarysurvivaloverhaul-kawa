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
/*    */ public class VineryThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public VineryThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 17 */     super("vinery", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     consumable("rotten_cherry").addThirst(thirstData(-4, 0.0F));
/*    */     
/* 25 */     IThirstData grape_hydration = thirstData(4, 0.0F);
/* 26 */     IThirstData grape_hydration2 = thirstData(6, 2.0F);
/* 27 */     consumable("cherry").addThirst(grape_hydration);
/* 28 */     consumable("red_grape").addThirst(grape_hydration);
/* 29 */     consumable("white_grape").addThirst(grape_hydration);
/* 30 */     consumable("savanna_grapes_red").addThirst(grape_hydration);
/* 31 */     consumable("savanna_grapes_white").addThirst(grape_hydration);
/* 32 */     consumable("taiga_grapes_red").addThirst(grape_hydration);
/* 33 */     consumable("taiga_grapes_white").addThirst(grape_hydration);
/* 34 */     consumable("jungle_grapes_red").addThirst(grape_hydration2);
/* 35 */     consumable("jungle_grapes_white").addThirst(grape_hydration2);
/*    */     
/* 37 */     IThirstData juice_hydration = thirstData(7, 3.0F);
/* 38 */     IThirstData juice_hydration2 = thirstData(9, 5.0F);
/* 39 */     consumable("red_grapejuice").addThirst(juice_hydration);
/* 40 */     consumable("white_grapejuice").addThirst(juice_hydration);
/* 41 */     consumable("red_savanna_grapejuice").addThirst(juice_hydration);
/* 42 */     consumable("white_savanna_grapejuice").addThirst(juice_hydration);
/* 43 */     consumable("red_taiga_grapejuice").addThirst(juice_hydration);
/* 44 */     consumable("white_taiga_grapejuice").addThirst(juice_hydration);
/* 45 */     consumable("red_jungle_grapejuice").addThirst(juice_hydration2);
/* 46 */     consumable("white_jungle_grapejuice").addThirst(juice_hydration2);
/* 47 */     consumable("apple_juice").addThirst(grape_hydration2);
/*    */     
/* 49 */     IThirstData vinery_hydration1 = thirstData(7, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 400, 0.3F);
/* 50 */     IThirstData vinery_hydration2 = thirstData(9, 6.5F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 500, 0.3F);
/* 51 */     consumable("apple_cider").addThirst(vinery_hydration1);
/* 52 */     consumable("apple_wine").addThirst(vinery_hydration1);
/* 53 */     consumable("noir_wine").addThirst(vinery_hydration1);
/* 54 */     consumable("glowing_wine").addThirst(vinery_hydration1);
/* 55 */     consumable("red_wine").addThirst(vinery_hydration1);
/* 56 */     consumable("cherry_wine").addThirst(vinery_hydration1);
/* 57 */     consumable("creepers_crush").addThirst(vinery_hydration1);
/* 58 */     consumable("kelp_cider").addThirst(vinery_hydration1);
/* 59 */     consumable("jo_special_mixture").addThirst(vinery_hydration1);
/* 60 */     consumable("eiswein").addThirst(vinery_hydration1);
/* 61 */     consumable("villagers_fright").addThirst(vinery_hydration1);
/* 62 */     consumable("clark_wine").addThirst(vinery_hydration1);
/* 63 */     consumable("magnetic_wine").addThirst(vinery_hydration1);
/*    */ 
/*    */     
/* 66 */     consumable("mead").addThirst(vinery_hydration2);
/* 67 */     consumable("solaris_wine").addThirst(vinery_hydration2);
/* 68 */     consumable("strad_wine").addThirst(vinery_hydration2);
/* 69 */     consumable("lilitu_wine").addThirst(vinery_hydration2);
/* 70 */     consumable("aegis_wine").addThirst(vinery_hydration2);
/* 71 */     consumable("bolvar_wine").addThirst(vinery_hydration2);
/* 72 */     consumable("stal_wine").addThirst(vinery_hydration2);
/* 73 */     consumable("chenet_wine").addThirst(vinery_hydration2);
/*    */     
/* 75 */     consumable("bottle_mojang_noir").addThirst(thirstData(8, 5.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.3F));
/*    */     
/* 77 */     IThirstData vinery_hydration3 = thirstData(9, 8.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 800, 0.4F);
/*    */     
/* 79 */     consumable("mellohi_wine").addThirst(vinery_hydration3);
/* 80 */     consumable("cristel_wine").addThirst(vinery_hydration3);
/* 81 */     consumable("chorus_wine").addThirst(vinery_hydration3);
/*    */     
/* 83 */     consumable("jellie_wine").addThirst(thirstData(12, 10.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 1000, 0.3F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\VineryThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */