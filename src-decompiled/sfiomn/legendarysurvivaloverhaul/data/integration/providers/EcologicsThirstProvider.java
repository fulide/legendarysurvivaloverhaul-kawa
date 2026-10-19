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
/*    */ public class EcologicsThirstProvider
/*    */   extends ThirstDataProvider
/*    */ {
/*    */   public EcologicsThirstProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 16 */     super("ecologics", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 23 */     consumable("coconut_slice").addThirst(thirstData(3, 0.5F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/* 24 */     consumable("prickly_pear").addThirst(thirstData(2, 0.5F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.2F));
/* 25 */     consumable("tropical_stew").addThirst(thirstData(3, 0.5F).addEffect((MobEffect)MobEffectRegistry.THIRST.get(), 600, 0.4F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\EcologicsThirstProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */