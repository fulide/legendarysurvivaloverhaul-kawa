/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureDimension;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureImmunityEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.terrafirmacraft.TerraFirmaCraftUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AltitudeModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getWorldInfluence(@Nullable Player player, Level level, BlockPos pos) {
/* 25 */     JsonTemperatureDimension dimensionTemperature = TemperatureDataManager.getDimension(level.dimension().location());
/* 26 */     if (dimensionTemperature == null || !dimensionTemperature.hasAltitude || TerraFirmaCraftUtil.shouldUseTerraFirmaCraftTemp())
/*    */     {
/* 28 */       return 0.0F;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 37 */     float altitudeDiff = (pos.getY() - dimensionTemperature.seaLevelHeight) / 64.0F;
/* 38 */     if (player != null && altitudeDiff > 0.0F && TemperatureUtil.hasImmunity(player, TemperatureImmunityEnum.HIGH_ALTITUDE))
/* 39 */       return 0.0F; 
/* 40 */     return Math.abs(altitudeDiff) * (float)Config.Baked.altitudeModifier;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\AltitudeModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */