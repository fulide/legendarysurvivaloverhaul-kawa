/*    */ package sfiomn.legendarysurvivaloverhaul.util;
/*    */ 
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class DifficultyUtil
/*    */ {
/*    */   public static boolean isModDangerous() {
/* 17 */     return (Config.Baked.difficultyMode != EnumUtil.DifficultyMode.PEACEFUL);
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean healthAboveDifficulty(Player player) {
/* 22 */     EnumUtil.DifficultyMode difficulty = Config.Baked.difficultyMode;
/* 23 */     return (difficulty == EnumUtil.DifficultyMode.HARD || (difficulty == EnumUtil.DifficultyMode.NORMAL && player
/* 24 */       .getHealth() > 2.0F) || ((difficulty == EnumUtil.DifficultyMode.EASY || difficulty == EnumUtil.DifficultyMode.PEACEFUL) && player
/* 25 */       .getHealth() > 10.0F));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhau\\util\DifficultyUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */