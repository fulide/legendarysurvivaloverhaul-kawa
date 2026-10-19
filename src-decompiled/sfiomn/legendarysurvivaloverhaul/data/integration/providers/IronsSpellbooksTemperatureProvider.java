/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IronsSpellbooksTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public IronsSpellbooksTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("irons_spellbooks", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 21 */     item("pyromancer_helmet").coldResistance(1.5F);
/* 22 */     item("pyromancer_chestplate").coldResistance(2.5F);
/* 23 */     item("pyromancer_leggings").coldResistance(2.0F);
/* 24 */     item("pyromancer_boots").coldResistance(1.5F);
/* 25 */     item("cryomancer_helmet").heatResistance(1.5F);
/* 26 */     item("cryomancer_chestplate").heatResistance(2.5F);
/* 27 */     item("cryomancer_leggings").heatResistance(2.0F);
/* 28 */     item("cryomancer_boots").heatResistance(1.5F);
/* 29 */     item("netherite_mage_helmet").coldResistance(2.0F);
/* 30 */     item("netherite_mage_chestplate").coldResistance(3.5F);
/* 31 */     item("netherite_mage_leggings").coldResistance(2.5F);
/* 32 */     item("netherite_mage_boots").coldResistance(2.0F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\IronsSpellbooksTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */