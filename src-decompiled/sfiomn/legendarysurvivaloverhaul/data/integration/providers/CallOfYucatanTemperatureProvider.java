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
/*    */ public class CallOfYucatanTemperatureProvider
/*    */   extends TemperatureDataProvider
/*    */ {
/*    */   public CallOfYucatanTemperatureProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("call_of_yucutan", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 22 */     item("jades_helmet").heatResistance(0.5F);
/* 23 */     item("jades_chestplate").coldResistance(1.5F);
/* 24 */     item("jades_leggings").coldResistance(1.5F);
/* 25 */     item("jades_boots").coldResistance(0.5F);
/*    */     
/* 27 */     block("bone_torch_ground").addTemperature(temperatureBlock(1.5F));
/* 28 */     item("bone_torch_ground").temperature(1.5F);
/*    */     
/* 30 */     block("golden_torch_ground").addTemperature(temperatureBlock(1.5F));
/* 31 */     item("golden_torch_ground").temperature(1.5F);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CallOfYucatanTemperatureProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */