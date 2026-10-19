/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.terrafirmacraft;
/*    */ 
/*    */ import net.dries007.tfc.util.climate.Climate;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Vec3i;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.Level;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TerraFirmaCraftModifier
/*    */   extends ModifierBase
/*    */ {
/*    */   public float getWorldInfluence(Player player, Level level, BlockPos pos) {
/* 23 */     if (!LegendarySurvivalOverhaul.terraFirmaCraftLoaded) {
/* 24 */       return 0.0F;
/*    */     }
/* 26 */     if (Config.Baked.tfcTemperatureMultiplier == 0.0D) {
/* 27 */       return 0.0F;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 33 */       return getUncaughtWorldInfluence(level, pos);
/* 34 */     } catch (Exception e) {
/*    */ 
/*    */       
/* 37 */       LegendarySurvivalOverhaul.LOGGER.error("An error has occurred with TerraFirmaCraft compatibility, disabling integration", e);
/* 38 */       LegendarySurvivalOverhaul.terraFirmaCraftLoaded = false;
/*    */       
/* 40 */       return 0.0F;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public float getUncaughtWorldInfluence(Level level, BlockPos pos) {
/* 46 */     Vec3i[] posOffsets = { new Vec3i(0, 0, 0), new Vec3i(10, 0, 0), new Vec3i(-10, 0, 0), new Vec3i(0, 0, 10), new Vec3i(0, 0, -10) };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 54 */     float value = 0.0F;
/*    */     
/* 56 */     for (Vec3i offset : posOffsets)
/*    */     {
/* 58 */       value += (float)(Climate.getInstantTemperature(level, pos.offset(offset)) * Config.Baked.tfcTemperatureMultiplier);
/*    */     }
/*    */     
/* 61 */     value /= posOffsets.length;
/*    */     
/* 63 */     return value;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\terrafirmacraft\TerraFirmaCraftModifier.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */