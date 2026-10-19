/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.TemperatureDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BetterEndForgeTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public BetterEndForgeTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("betterendforge", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     fuelItem("coal_block").thermalType(ThermalTypeEnum.HEATING).duration(5400);
/* 23 */     fuelItem("charcoal_block").thermalType(ThermalTypeEnum.HEATING).duration(5400);
/*    */     
/* 25 */     biome("sulphur_springs").temperature(1.1F);
/* 26 */     biome("ice_starfield").temperature(0.1F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\BetterEndForgeTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */