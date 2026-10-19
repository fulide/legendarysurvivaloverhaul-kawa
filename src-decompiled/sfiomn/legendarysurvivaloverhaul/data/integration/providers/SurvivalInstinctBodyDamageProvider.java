/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.BodyDamageDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SurvivalInstinctBodyDamageProvider
/*    */   extends BodyDamageDataProvider
/*    */ {
/*    */   public SurvivalInstinctBodyDamageProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("survival_instinct", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 21 */     consumable("adrenaline_injector").healingCharges(1).healingValue(1.0F).duration(100);
/* 22 */     consumable("adrenaline_syringe").healingCharges(1).healingValue(1.0F).duration(100);
/* 23 */     consumable("bandage").healingCharges(3).healingValue(3.0F).duration(300);
/* 24 */     consumable("blood_syringe").healingCharges(1).healingValue(4.0F).duration(375);
/* 25 */     consumable("homemade_bandage").healingCharges(3).healingValue(3.0F).duration(300);
/* 26 */     consumable("medkit_bag").healingCharges(6).healingValue(8.0F).duration(400);
/* 27 */     consumable("medkit_bag").healingCharges(6).healingValue(8.0F).duration(400);
/* 28 */     consumable("morphine_injector").healingCharges(1).healingValue(2.0F).duration(150);
/* 29 */     consumable("morphine_syringe").healingCharges(1).healingValue(2.0F).duration(150);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\SurvivalInstinctBodyDamageProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */