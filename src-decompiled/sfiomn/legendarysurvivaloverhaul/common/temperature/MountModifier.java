/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import net.minecraft.core.registries.BuiltInRegistries;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MountModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getPlayerInfluence(Player player) {
/* 21 */     if (player.getVehicle() != null)
/*    */     {
/* 23 */       return processMountJson(player.getVehicle());
/*    */     }
/* 25 */     return 0.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   private float processMountJson(Entity entity) {
/* 30 */     ResourceLocation entityRegistryName = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());
/* 31 */     JsonTemperatureResistance jsonTemperature = TemperatureDataManager.getMount(entityRegistryName);
/* 32 */     if (jsonTemperature != null)
/*    */     {
/* 34 */       return jsonTemperature.temperature;
/*    */     }
/*    */     
/* 37 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\MountModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */