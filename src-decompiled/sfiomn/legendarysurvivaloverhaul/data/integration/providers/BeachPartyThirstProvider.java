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
/*    */ public class BeachPartyThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public BeachPartyThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("beachparty", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     consumable("coconut_open").addThirst(thirstData(3, 0.0F));
/* 23 */     consumable("coconut_cocktail").addThirst(thirstData(4, 2.0F));
/* 24 */     consumable("sweetberries_cocktail").addThirst(thirstData(4, 4.0F));
/* 25 */     consumable("cocoa_cocktail").addThirst(thirstData(6, 3.0F));
/* 26 */     consumable("pumpkin_cocktail").addThirst(thirstData(6, 3.0F));
/* 27 */     consumable("melon_cocktail").addThirst(thirstData(8, 4.0F));
/* 28 */     consumable("honey_cocktail").addThirst(thirstData(9, 6.0F));
/* 29 */     consumable("refreshing_drink").addThirst(thirstData(10, 8.0F));
/* 30 */     consumable("sweetberry_milkshake").addThirst(thirstData(6, 4.0F));
/* 31 */     consumable("coconut_milkshake").addThirst(thirstData(6, 4.0F));
/* 32 */     consumable("chocolate_milkshake").addThirst(thirstData(8, 6.0F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BeachPartyThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */