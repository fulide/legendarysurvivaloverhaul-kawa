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
/*    */ public class FarmAndCharmThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public FarmAndCharmThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("farm_and_charm", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     consumable("tomato").addThirst(thirstData(4, 0.0F));
/* 24 */     consumable("strawberry").addThirst(thirstData(2, 0.0F));
/*    */     
/* 26 */     IThirstData teaThirstData = thirstData(7, 5.0F);
/* 27 */     consumable("strawberry_tea").addThirst(teaThirstData);
/* 28 */     consumable("nettle_tea").addThirst(teaThirstData);
/* 29 */     consumable("ribwort_tea").addThirst(teaThirstData);
/* 30 */     consumable("strawberry_tea_cup").addThirst(teaThirstData);
/* 31 */     consumable("nettle_tea_cup").addThirst(teaThirstData);
/* 32 */     consumable("ribwort_tea_cup").addThirst(teaThirstData);
/*    */     
/* 34 */     IThirstData soupThirstData = thirstData(4, 2.0F);
/* 35 */     consumable("simple_tomato_soup").addThirst(soupThirstData);
/* 36 */     consumable("barley_soup").addThirst(soupThirstData);
/* 37 */     consumable("onion_soup").addThirst(soupThirstData);
/* 38 */     consumable("potato_soup").addThirst(soupThirstData);
/* 39 */     consumable("goulash").addThirst(soupThirstData);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\FarmAndCharmThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */