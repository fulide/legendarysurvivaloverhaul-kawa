/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.vampirism;
/*    */ 
/*    */ import de.teamlapen.vampirism.api.VReference;
/*    */ import de.teamlapen.vampirism.api.VampirismAPI;
/*    */ import de.teamlapen.vampirism.api.entity.factions.IFaction;
/*    */ import de.teamlapen.vampirism.api.entity.factions.IFactionPlayerHandler;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VampirismUtil
/*    */ {
/*    */   public static boolean isVampire(Player player) {
/* 15 */     if (LegendarySurvivalOverhaul.vampirismLoaded && player != null) {
/*    */       
/* 17 */       IFactionPlayerHandler factionHandler = VampirismAPI.getFactionPlayerHandler(player).orElse(null);
/* 18 */       if (factionHandler != null)
/*    */       {
/* 20 */         return factionHandler.isInFaction((IFaction)VReference.VAMPIRE_FACTION);
/*    */       }
/*    */     } 
/*    */     
/* 24 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\vampirism\VampirismUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */