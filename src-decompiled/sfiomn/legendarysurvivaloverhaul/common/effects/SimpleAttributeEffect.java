/*    */ package sfiomn.legendarysurvivaloverhaul.common.effects;
/*    */ 
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleAttributeEffect
/*    */   extends MobEffect
/*    */ {
/*    */   public static final String HOT_FOOD_ATTRIBUTE_UUID = "dbac2b95-f979-4104-a4ba-3039c1015ae7";
/*    */   public static final String HOT_DRINK_ATTRIBUTE_UUID = "5f1f294d-86f4-42e8-ae78-67223f29e9e8";
/*    */   public static final String COLD_FOOD_ATTRIBUTE_UUID = "344cffd9-9a50-4bd5-9ac1-aa4830c3128a";
/*    */   public static final String COLD_DRINK_ATTRIBUTE_UUID = "10db1b22-eda8-4cc2-90df-c1e3b06fa460";
/*    */   public static final String HEAT_RESISTANCE_ATTRIBUTE_UUID = "fc0998d2-a273-4d8c-aaf4-39f8a25a3c8e";
/*    */   public static final String COLD_RESISTANCE_ATTRIBUTE_UUID = "cc64e9cb-10dd-4896-8ff6-5f6a21b949ff";
/*    */   protected final double amplifierMultiplier;
/*    */   
/*    */   public SimpleAttributeEffect(MobEffectCategory category, int color, double amplifierMultiplier) {
/* 22 */     super(category, color);
/* 23 */     this.amplifierMultiplier = amplifierMultiplier;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double valueForLevel(double base, int amplifier) {
/* 31 */     return base + this.amplifierMultiplier * amplifier;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\effects\SimpleAttributeEffect.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */