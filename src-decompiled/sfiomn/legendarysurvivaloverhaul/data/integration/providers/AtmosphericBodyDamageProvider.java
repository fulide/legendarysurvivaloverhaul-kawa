/*    */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.BodyDamageDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AtmosphericBodyDamageProvider
/*    */   extends BodyDamageDataProvider
/*    */ {
/*    */   public AtmosphericBodyDamageProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 18 */     super("atmospheric", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 24 */     damageSource("atmospheric.yuccaSapling")
/* 25 */       .damageDistribution(DamageDistributionEnum.ONE_OF)
/* 26 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 27 */     damageSource("atmospheric.yuccaFlower")
/* 28 */       .damageDistribution(DamageDistributionEnum.ONE_OF)
/* 29 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 30 */     damageSource("atmospheric.yuccaBranch")
/* 31 */       .damageDistribution(DamageDistributionEnum.ONE_OF)
/* 32 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 33 */     damageSource("atmospheric.yuccaLeaves")
/* 34 */       .damageDistribution(DamageDistributionEnum.ONE_OF)
/* 35 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 36 */     damageSource("atmospheric.barrelCactus")
/* 37 */       .damageDistribution(DamageDistributionEnum.ONE_OF)
/* 38 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 39 */     damageSource("atmospheric.aloeLeaves")
/* 40 */       .damageDistribution(DamageDistributionEnum.ONE_OF)
/* 41 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\AtmosphericBodyDamageProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */