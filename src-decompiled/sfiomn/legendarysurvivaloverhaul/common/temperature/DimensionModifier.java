/*    */ package sfiomn.legendarysurvivaloverhaul.common.temperature;
/*    */ 
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureDimension;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.TemperatureDataManager;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.terrafirmacraft.TerraFirmaCraftUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DimensionModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getWorldInfluence(@Nullable Player player, Level level, BlockPos pos) {
/* 23 */     if (TerraFirmaCraftUtil.shouldUseTerraFirmaCraftTemp()) {
/* 24 */       return 0.0F;
/*    */     }
/* 26 */     JsonTemperatureDimension dimensionTemperature = TemperatureDataManager.getDimension(level.dimension().location());
/* 27 */     if (dimensionTemperature == null) {
/* 28 */       return TemperatureEnum.NORMAL.getValue();
/*    */     }
/* 30 */     return dimensionTemperature.temperature;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\temperature\DimensionModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */