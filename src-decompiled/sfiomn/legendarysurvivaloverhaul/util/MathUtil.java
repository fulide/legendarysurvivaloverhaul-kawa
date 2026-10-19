/*    */ package sfiomn.legendarysurvivaloverhaul.util;
/*    */ 
/*    */ import net.minecraft.world.phys.AABB;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MathUtil
/*    */ {
/*    */   public static float invLerp(float from, float to, float value) {
/* 14 */     return (value - from) / (to - from);
/*    */   }
/*    */ 
/*    */   
/*    */   public static float round(float value, int precision) {
/* 19 */     int scale = (int)Math.pow(10.0D, precision);
/* 20 */     return Math.round(value * scale) / scale;
/*    */   }
/*    */ 
/*    */   
/*    */   public static float ceil(float value, int precision) {
/* 25 */     int scale = (int)Math.pow(10.0D, precision);
/* 26 */     return (float)Math.ceil((value * scale)) / scale;
/*    */   }
/*    */ 
/*    */   
/*    */   public static AABB inflateMultiplier(AABB aabb1, AABB aabb2) {
/* 31 */     double newMinX = aabb1.minX + aabb1.getXsize() * aabb2.minX;
/* 32 */     double newMinY = aabb1.minY + aabb1.getYsize() * aabb2.minY;
/* 33 */     double newMinZ = aabb1.minZ + aabb1.getZsize() * aabb2.minZ;
/* 34 */     double newMaxX = aabb1.minX + aabb1.getXsize() * aabb2.maxX;
/* 35 */     double newMaxY = aabb1.minY + aabb1.getYsize() * aabb2.maxY;
/* 36 */     double newMaxZ = aabb1.minZ + aabb1.getZsize() * aabb2.maxZ;
/* 37 */     return new AABB(newMinX, newMinY, newMinZ, newMaxX, newMaxY, newMaxZ);
/*    */   }
/*    */ 
/*    */   
/*    */   public static AABB inflateMultiplier(AABB original, double inflateValue) {
/* 42 */     AABB inflateAABB = new AABB(-inflateValue, -inflateValue, -inflateValue, 1.0D + inflateValue, 1.0D + inflateValue, 1.0D + inflateValue);
/* 43 */     return inflateMultiplier(original, inflateAABB);
/*    */   }
/*    */ 
/*    */   
/*    */   public static AABB inflate(AABB original, AABB inflateValues) {
/* 48 */     double newMinX = original.minX + inflateValues.minX;
/* 49 */     double newMinY = original.minY + inflateValues.minY;
/* 50 */     double newMinZ = original.minZ + inflateValues.minZ;
/* 51 */     double newMaxX = original.maxX + inflateValues.maxX;
/* 52 */     double newMaxY = original.maxY + inflateValues.maxY;
/* 53 */     double newMaxZ = original.maxZ + inflateValues.maxZ;
/* 54 */     return new AABB(newMinX, newMinY, newMinZ, newMaxX, newMaxY, newMaxZ);
/*    */   }
/*    */ 
/*    */   
/*    */   public static AABB horizontalInflate(AABB original, double inflateValue) {
/* 59 */     AABB inflateAABB = new AABB(-inflateValue, 0.0D, -inflateValue, inflateValue, 0.0D, inflateValue);
/* 60 */     return inflate(original, inflateAABB);
/*    */   }
/*    */ 
/*    */   
/*    */   public static AABB horizontalUpInflate(AABB original, double inflateValue) {
/* 65 */     AABB inflateAABB = new AABB(-inflateValue, 0.0D, -inflateValue, inflateValue, inflateValue, inflateValue);
/* 66 */     return inflate(original, inflateAABB);
/*    */   }
/*    */ 
/*    */   
/*    */   public static AABB horizontalDownInflate(AABB original, double inflateValue) {
/* 71 */     AABB inflateAABB = new AABB(-inflateValue, -inflateValue, -inflateValue, inflateValue, 0.0D, inflateValue);
/* 72 */     return inflate(original, inflateAABB);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\MathUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */