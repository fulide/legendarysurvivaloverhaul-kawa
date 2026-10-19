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
/*    */ public class AquamiraeTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public AquamiraeTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("aquamirae", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 21 */     item("terrible_helmet").heatResistance(1.0F);
/* 22 */     item("terrible_chestplate").heatResistance(1.5F);
/* 23 */     item("terrible_leggings").heatResistance(1.5F);
/* 24 */     item("terrible_boots").heatResistance(1.0F);
/* 25 */     item("abyssal_heaume").coldResistance(1.0F);
/* 26 */     item("abyssal_brigantine").coldResistance(2.0F);
/* 27 */     item("abyssal_leggings").coldResistance(1.0F);
/* 28 */     item("abyssal_boots").coldResistance(1.0F);
/* 29 */     item("three_bolt_helmet").coldResistance(1.0F);
/* 30 */     item("three_bolt_suit").coldResistance(1.0F);
/* 31 */     item("three_bolt_leggings").coldResistance(1.0F);
/* 32 */     item("three_bolt_boots").coldResistance(1.0F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\AquamiraeTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */