/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.builder.IThirstData;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.ThirstDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MinersDelightThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public MinersDelightThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("miners_delight", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     consumable("milk_cup").addThirst(thirstData(4, 1.0F));
/*    */     
/* 25 */     IThirstData lowThirst = thirstData(4, 1.0F);
/* 26 */     consumable("beetroot_soup_cup").addThirst(lowThirst);
/* 27 */     consumable("mushroom_stew_cup").addThirst(lowThirst);
/* 28 */     consumable("cave_soup_cup").addThirst(lowThirst);
/* 29 */     consumable("bat_soup_cup").addThirst(lowThirst);
/* 30 */     consumable("insect_stew_cup").addThirst(lowThirst);
/*    */     
/* 32 */     IThirstData midThirst = thirstData(5, 2.0F);
/* 33 */     consumable("fish_stew_cup").addThirst(midThirst);
/* 34 */     consumable("rabbit_stew_cup").addThirst(midThirst);
/* 35 */     consumable("beef_stew_cup").addThirst(midThirst);
/* 36 */     consumable("vegetable_soup_cup").addThirst(lowThirst);
/*    */     
/* 38 */     IThirstData highThirst = thirstData(5, 3.0F);
/* 39 */     consumable("baked_cod_stew_cup").addThirst(highThirst);
/* 40 */     consumable("noodle_soup_cup").addThirst(highThirst);
/* 41 */     consumable("chicken_soup_cup").addThirst(highThirst);
/* 42 */     consumable("pumpkin_soup_cup").addThirst(highThirst);
/* 43 */     consumable("cave_soup").addThirst(highThirst);
/* 44 */     consumable("bat_soup").addThirst(highThirst);
/* 45 */     consumable("insect_stew").addThirst(highThirst);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\MinersDelightThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */