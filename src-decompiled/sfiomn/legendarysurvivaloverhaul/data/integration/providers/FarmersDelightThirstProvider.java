/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.ThirstDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FarmersDelightThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public FarmersDelightThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("farmersdelight", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     consumable("tomato").addThirst(thirstData(4, 0.0F));
/* 23 */     consumable("milk_bottle").addThirst(thirstData(6, 1.0F));
/* 24 */     consumable("apple_cider").addThirst(thirstData(5, 2.0F));
/* 25 */     consumable("hot_cocoa").addThirst(thirstData(6, 3.0F));
/* 26 */     consumable("melon_juice").addThirst(thirstData(8, 4.0F));
/* 27 */     consumable("tomato_sauce").addThirst(thirstData(6, 0.0F));
/*    */     
/* 29 */     consumable("melon_popsicle").addThirst(thirstData(4, 1.0F));
/* 30 */     consumable("fruit_salad").addThirst(thirstData(6, 2.0F));
/*    */     
/* 32 */     consumable("chicken_soup").addThirst(thirstData(4, 2.0F));
/* 33 */     consumable("vegetable_soup").addThirst(thirstData(4, 2.0F));
/* 34 */     consumable("pumpkin_soup").addThirst(thirstData(7, 3.0F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\FarmersDelightThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */