/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.vampirism;
/*    */ 
/*    */ import de.teamlapen.vampirism.api.VReference;
/*    */ import de.teamlapen.vampirism.api.event.PlayerFactionEvent;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.neoforge.event.entity.player.PlayerEvent;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ 
/*    */ public class VampirismEvents
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onFactionChanged(PlayerFactionEvent.FactionLevelChanged event) {
/* 17 */     Player player = event.getPlayer().asEntity();
/* 18 */     if (LegendarySurvivalOverhaul.vampirismLoaded && event.getCurrentFaction() == VReference.VAMPIRE_FACTION && !Config.Baked.thirstEnabledIfVampire) {
/* 19 */       ThirstUtil.deactivateThirst(player);
/*    */     } else {
/* 21 */       ThirstUtil.activateThirst(player);
/*    */     } 
/*    */   }
/*    */   @SubscribeEvent
/*    */   public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
/* 26 */     if (LegendarySurvivalOverhaul.vampirismLoaded && !Config.Baked.thirstEnabledIfVampire && VampirismUtil.isVampire(event.getEntity())) {
/* 27 */       ThirstUtil.deactivateThirst(event.getEntity());
/*    */     } else {
/* 29 */       ThirstUtil.activateThirst(event.getEntity());
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
/* 35 */     if (!ThirstUtil.isThirstActive(event.getEntity()))
/* 36 */       ThirstUtil.activateThirst(event.getEntity()); 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\vampirism\VampirismEvents.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */