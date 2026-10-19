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
/*    */ public class MedsAndHerbsBodyDamageProvider
/*    */   extends BodyDamageDataProvider
/*    */ {
/*    */   public MedsAndHerbsBodyDamageProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 15 */     super("meds_and_herbs", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 21 */     consumable("medkit_novice").healingCharges(0).healingValue(3.0F).duration(400);
/* 22 */     consumable("medkit_advanced").healingCharges(0).healingValue(5.0F).duration(800);
/* 23 */     consumable("medkit_expert").healingCharges(0).healingValue(8.0F).duration(600);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\MedsAndHerbsBodyDamageProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */