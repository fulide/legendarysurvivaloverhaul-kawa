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
/*    */ public class RusticDelightThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public RusticDelightThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("rusticdelight", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     consumable("bell_pepper_green").addThirst(thirstData(4, 0.0F));
/* 23 */     consumable("bell_pepper_yellow").addThirst(thirstData(4, 0.0F));
/* 24 */     consumable("bell_pepper_red").addThirst(thirstData(4, 0.0F));
/*    */     
/* 26 */     consumable("syrup").addThirst(thirstData(2, 1.0F));
/*    */     
/* 28 */     consumable("dark_coffee").addThirst(thirstData(4, 3.5F));
/* 29 */     consumable("coffee").addThirst(thirstData(5, 3.5F));
/* 30 */     consumable("milk_coffee").addThirst(thirstData(6, 4.0F));
/* 31 */     consumable("syrup_coffee").addThirst(thirstData(6, 4.0F));
/* 32 */     consumable("chocolate_coffee").addThirst(thirstData(7, 4.5F));
/* 33 */     consumable("honey_coffee").addThirst(thirstData(7, 4.5F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\RusticDelightThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */