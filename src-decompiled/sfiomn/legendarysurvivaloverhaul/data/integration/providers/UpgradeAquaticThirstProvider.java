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
/*    */ public class UpgradeAquaticThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public UpgradeAquaticThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("upgrade_aquatic", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     consumable("mulberry").addThirst(thirstData(4, 0.0F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\UpgradeAquaticThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */