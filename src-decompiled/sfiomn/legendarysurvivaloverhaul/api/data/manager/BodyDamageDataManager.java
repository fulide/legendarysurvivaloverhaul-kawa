/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.manager;
/*    */ 
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonBodyPartResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonBodyPartsDamageSource;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonHealingConsumable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BodyDamageDataManager
/*    */ {
/*    */   public static IBodyPartsDamageSourceManager internalBodyPartsDamageSource;
/*    */   public static IHealingConsumableManager internalHealingConsumable;
/*    */   public static IBodyResistanceItemManager internalBodyResistanceItem;
/*    */   
/*    */   @Nullable
/*    */   public static JsonBodyPartsDamageSource getBodyParts(String damageSourceName) {
/* 25 */     return internalBodyPartsDamageSource.get(damageSourceName.toLowerCase());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public static JsonHealingConsumable getHealingItem(ResourceLocation itemRegistryName) {
/* 37 */     return internalHealingConsumable.get(itemRegistryName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public static JsonBodyPartResistance getBodyResistanceItem(ResourceLocation itemRegistryName) {
/* 49 */     return internalBodyResistanceItem.get(itemRegistryName);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\manager\BodyDamageDataManager.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */