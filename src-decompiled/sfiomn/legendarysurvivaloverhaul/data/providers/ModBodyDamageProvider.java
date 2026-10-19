/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.BodyDamageDataProvider;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModBodyDamageProvider
/*    */   extends BodyDamageDataProvider
/*    */ {
/*    */   public ModBodyDamageProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 18 */     super("legendarysurvivaloverhaul", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     consumable((Item)ItemRegistry.HEALING_HERBS.get()).healingCharges(1).healingValue(2.0F).duration(600)
/* 25 */       .recoveryEffectDuration(600);
/* 26 */     consumable((Item)ItemRegistry.PLASTER.get()).healingCharges(1).healingValue(3.0F).duration(400)
/* 27 */       .recoveryEffectDuration(1200);
/* 28 */     consumable((Item)ItemRegistry.BANDAGE.get()).healingCharges(3).healingValue(3.0F).duration(300)
/* 29 */       .recoveryEffectDuration(1200).recoveryEffectAmplifier(1);
/* 30 */     consumable((Item)ItemRegistry.TONIC.get()).healingCharges(0).healingValue(5.0F).duration(600)
/* 31 */       .recoveryEffectDuration(1400).recoveryEffectAmplifier(1);
/* 32 */     consumable((Item)ItemRegistry.MEDKIT.get()).healingCharges(0).healingValue(8.0F).duration(400)
/* 33 */       .recoveryEffectDuration(1400).recoveryEffectAmplifier(2);
/*    */     
/* 35 */     damageSource("legendarysurvivaloverhaul.hypothermia")
/* 36 */       .damageDistribution(DamageDistributionEnum.NONE);
/* 37 */     damageSource("legendarysurvivaloverhaul.hyperthermia")
/* 38 */       .damageDistribution(DamageDistributionEnum.NONE);
/* 39 */     damageSource("legendarysurvivaloverhaul.dehydration")
/* 40 */       .damageDistribution(DamageDistributionEnum.NONE);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModBodyDamageProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */