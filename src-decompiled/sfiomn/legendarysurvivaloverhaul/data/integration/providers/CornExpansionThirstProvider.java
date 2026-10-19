/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.ThirstDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ 
/*    */ 
/*    */ public class CornExpansionThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public CornExpansionThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("cornexpansion", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     consumable("corn_syrup").addThirst(thirstData(-4, 0.0F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\CornExpansionThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */