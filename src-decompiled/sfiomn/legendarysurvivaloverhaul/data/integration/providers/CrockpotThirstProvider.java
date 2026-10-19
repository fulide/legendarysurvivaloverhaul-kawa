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
/*    */ public class CrockpotThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public CrockpotThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("crockpot", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     consumable("asparagus_soup").addThirst(thirstData(4, 2.0F));
/* 23 */     consumable("bone_soup").addThirst(thirstData(4, 2.0F));
/* 24 */     consumable("gazpacho").addThirst(thirstData(4, 2.0F));
/*    */     
/* 26 */     consumable("iced_tea").addThirst(thirstData(8, 5.0F));
/* 27 */     consumable("tea").addThirst(thirstData(6, 3.0F));
/* 28 */     consumable("hot_cocoa").addThirst(thirstData(4, 2.0F));
/* 29 */     consumable("fruit_medley").addThirst(thirstData(6, 3.0F));
/* 30 */     consumable("veg_stinger").addThirst(thirstData(6, 3.0F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CrockpotThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */