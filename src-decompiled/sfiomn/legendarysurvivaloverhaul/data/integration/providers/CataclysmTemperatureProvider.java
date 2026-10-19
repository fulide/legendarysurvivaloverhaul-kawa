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
/*    */ public class CataclysmTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public CataclysmTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("cataclysm", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     item("bone_reptile_helmet").coldResistance(1.5F);
/* 23 */     item("bone_reptile_chestplate").coldResistance(2.0F);
/*    */     
/* 25 */     item("ignitium_helmet").coldResistance(1.5F);
/* 26 */     item("ignitium_chestplate").coldResistance(3.0F);
/* 27 */     item("ignitium_elytra_chestplate").coldResistance(3.0F);
/* 28 */     item("ignitium_leggings").coldResistance(2.0F);
/* 29 */     item("ignitium_boots").coldResistance(1.5F);
/*    */     
/* 31 */     item("monstrous_helm").coldResistance(1.0F);
/* 32 */     item("bloom_stone_pauldrons").heatResistance(1.0F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CataclysmTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */