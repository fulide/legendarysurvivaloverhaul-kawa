/*    */ package sfiomn.legendarysurvivaloverhaul.util;
/*    */ 
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.world.damagesource.DamageSource;
/*    */ import net.minecraft.world.damagesource.DamageType;
/*    */ import net.minecraft.world.level.Level;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DamageSourceUtil
/*    */ {
/*    */   private static Registry<DamageType> damageTypes(Level level) {
/* 19 */     return level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE);
/*    */   }
/*    */ 
/*    */   
/*    */   public static DamageSource getDamageSource(Level level, ResourceKey<DamageType> damageType) {
/* 24 */     return new DamageSource((Holder)damageTypes(level).getHolderOrThrow(damageType));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\DamageSourceUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */