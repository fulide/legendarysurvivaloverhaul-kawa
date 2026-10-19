/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature.dynamic;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.core.registries.BuiltInRegistries;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.DynamicModifierBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MountDynamicModifier
/*    */   extends DynamicModifierBase
/*    */ {
/*    */   public float applyDynamicPlayerInfluence(Player player, float currentTemperature, float currentResistance) {
/* 24 */     if (player.getVehicle() == null) return 0.0F;
/*    */     
/* 26 */     return getEffectiveResistance(currentTemperature, currentResistance, processMountJson(player.getVehicle()));
/*    */   }
/*    */ 
/*    */   
/*    */   private JsonTemperatureResistance processMountJson(Entity entity) {
/* 31 */     ResourceLocation entityRegistryName = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());
/* 32 */     JsonTemperatureResistance jsonTemperatureResistance = TemperatureDataManager.getMount(entityRegistryName);
/* 33 */     return Objects.<JsonTemperatureResistance>requireNonNullElseGet(jsonTemperatureResistance, JsonTemperatureResistance::new);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\dynamic\MountDynamicModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */