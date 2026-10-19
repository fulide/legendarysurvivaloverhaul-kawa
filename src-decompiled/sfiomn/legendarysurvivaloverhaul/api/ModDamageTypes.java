/*    */ package sfiomn.legendarysurvivaloverhaul.api;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.data.worldgen.BootstrapContext;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.damagesource.DamageEffects;
/*    */ import net.minecraft.world.damagesource.DamageScaling;
/*    */ import net.minecraft.world.damagesource.DamageType;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.DamageSourceUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModDamageTypes
/*    */ {
/* 17 */   public static final ResourceKey<DamageType> HYPOTHERMIA = registerKey("hypothermia");
/* 18 */   public static final ResourceKey<DamageType> HYPERTHERMIA = registerKey("hyperthermia");
/* 19 */   public static final ResourceKey<DamageType> DEHYDRATION = registerKey("dehydration");
/*    */ 
/*    */ 
/*    */   
/*    */   public static ResourceKey<DamageType> registerKey(String name) {
/* 24 */     return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", name));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void hyperthermia(Entity entity, float amount) {
/* 29 */     entity.hurt(DamageSourceUtil.getDamageSource(entity.level(), HYPERTHERMIA), amount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void hypothermia(Entity entity, float amount) {
/* 34 */     entity.hurt(DamageSourceUtil.getDamageSource(entity.level(), HYPOTHERMIA), amount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void dehydration(Entity entity, float amount) {
/* 39 */     entity.hurt(DamageSourceUtil.getDamageSource(entity.level(), DEHYDRATION), amount);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void bootstrap(BootstrapContext<DamageType> context) {
/* 44 */     context.register(HYPOTHERMIA, new DamageType("legendarysurvivaloverhaul.hypothermia", DamageScaling.NEVER, 0.1F, DamageEffects.FREEZING));
/* 45 */     context.register(HYPERTHERMIA, new DamageType("legendarysurvivaloverhaul.hyperthermia", DamageScaling.NEVER, 0.1F, DamageEffects.BURNING));
/* 46 */     context.register(DEHYDRATION, new DamageType("legendarysurvivaloverhaul.dehydration", DamageScaling.NEVER, 0.1F, DamageEffects.POKING));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\ModDamageTypes.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */