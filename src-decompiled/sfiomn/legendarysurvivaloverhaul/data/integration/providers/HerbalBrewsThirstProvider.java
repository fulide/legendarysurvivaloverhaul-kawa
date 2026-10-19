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
/*    */ public class HerbalBrewsThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public HerbalBrewsThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("herbalbrews", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     consumable("green_tea").addThirst(thirstData(5, 3.0F));
/* 23 */     consumable("black_tea").addThirst(thirstData(5, 3.0F));
/* 24 */     consumable("hibiscus_tea").addThirst(thirstData(6, 4.0F));
/* 25 */     consumable("lavender_tea").addThirst(thirstData(7, 5.0F));
/* 26 */     consumable("coffee").addThirst(thirstData(5, 3.5F));
/* 27 */     consumable("milk_coffee").addThirst(thirstData(6, 4.0F));
/* 28 */     consumable("rooibos_tea").addThirst(thirstData(9, 7.0F));
/* 29 */     consumable("oolong_tea").addThirst(thirstData(10, 10.0F));
/* 30 */     consumable("yerba_mate_tea").addThirst(thirstData(12, 12.0F));
/* 31 */     consumable("flask").addThirst(thirstData(7, 4.5F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\HerbalBrewsThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */