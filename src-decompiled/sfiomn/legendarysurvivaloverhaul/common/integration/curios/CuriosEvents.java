/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.curios;
/*    */ 
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CuriosEvents
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onCurioAttributeModifierEvent(CurioAttributeModifierEvent event) {
/* 13 */     CuriosModifier.addAttribute(event);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\curios\CuriosEvents.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */