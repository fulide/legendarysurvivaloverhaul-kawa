/*    */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.data.PackOutput;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.DamageDistributionEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.BodyDamageDataProvider;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MinecraftBodyDamageProvider
/*    */   extends BodyDamageDataProvider
/*    */ {
/*    */   public MinecraftBodyDamageProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/* 19 */     super("minecraft", output, lookupProvider, fileHelper);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/* 25 */     consumable(Items.ENCHANTED_GOLDEN_APPLE).healingCharges(0).healingValue(3.0F).duration(600);
/*    */     
/* 27 */     item(Items.DIAMOND_HELMET).headResistance(0.1F);
/* 28 */     item(Items.DIAMOND_CHESTPLATE).chestResistance(0.1F);
/* 29 */     item(Items.DIAMOND_LEGGINGS).legsResistance(0.1F);
/* 30 */     item(Items.DIAMOND_BOOTS).feetResistance(0.1F);
/*    */     
/* 32 */     damageSource("fall")
/* 33 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 34 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT }));
/* 35 */     damageSource("hotFloor")
/* 36 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 37 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT }));
/* 38 */     damageSource("fallingBlock")
/* 39 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 40 */       .addBodyPart(BodyPartEnum.HEAD);
/* 41 */     damageSource("flyIntoWall")
/* 42 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 43 */       .addBodyPart(BodyPartEnum.HEAD);
/* 44 */     damageSource("anvil")
/* 45 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 46 */       .addBodyPart(BodyPartEnum.HEAD);
/* 47 */     damageSource("lightningBolt")
/* 48 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 49 */       .addBodyParts(Arrays.asList(BodyPartEnum.values()));
/* 50 */     damageSource("onFire")
/* 51 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 52 */       .addBodyParts(Arrays.asList(BodyPartEnum.values()));
/* 53 */     damageSource("explosion")
/* 54 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 55 */       .addBodyParts(Arrays.asList(BodyPartEnum.values()));
/* 56 */     damageSource("bad_respawn_point")
/* 57 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 58 */       .addBodyParts(Arrays.asList(BodyPartEnum.values()));
/* 59 */     damageSource("dragonBreath")
/* 60 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 61 */       .addBodyParts(Arrays.asList(BodyPartEnum.values()));
/* 62 */     damageSource("inFire")
/* 63 */       .damageDistribution(DamageDistributionEnum.ALL)
/* 64 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 65 */     damageSource("cactus")
/* 66 */       .damageDistribution(DamageDistributionEnum.ONE_OF)
/* 67 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 68 */     damageSource("sweetBerryBush")
/* 69 */       .damageDistribution(DamageDistributionEnum.ONE_OF)
/* 70 */       .addBodyParts(Arrays.asList(new BodyPartEnum[] { BodyPartEnum.LEFT_FOOT, BodyPartEnum.RIGHT_FOOT, BodyPartEnum.LEFT_LEG, BodyPartEnum.RIGHT_LEG }));
/* 71 */     damageSource("in_wall")
/* 72 */       .damageDistribution(DamageDistributionEnum.NONE);
/* 73 */     damageSource("drown")
/* 74 */       .damageDistribution(DamageDistributionEnum.NONE);
/* 75 */     damageSource("starve")
/* 76 */       .damageDistribution(DamageDistributionEnum.NONE);
/* 77 */     damageSource("magic")
/* 78 */       .damageDistribution(DamageDistributionEnum.NONE);
/* 79 */     damageSource("wither")
/* 80 */       .damageDistribution(DamageDistributionEnum.NONE);
/* 81 */     damageSource("indirectMagic")
/* 82 */       .damageDistribution(DamageDistributionEnum.NONE);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\MinecraftBodyDamageProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */