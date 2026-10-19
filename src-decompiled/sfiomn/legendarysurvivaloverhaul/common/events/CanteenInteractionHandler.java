/*    */ package sfiomn.legendarysurvivaloverhaul.common.events;
/*    */ 
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResult;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.neoforged.bus.api.EventPriority;
/*    */ import net.neoforged.bus.api.SubscribeEvent;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.crayfish.CrayfishFurnitureUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.items.drink.CanteenItem;
/*    */ 
/*    */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.GAME)
/*    */ public class CanteenInteractionHandler {
/*    */   @SubscribeEvent(priority = EventPriority.HIGH)
/*    */   public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
/* 21 */     Player player = event.getEntity();
/* 22 */     InteractionHand hand = event.getHand();
/* 23 */     ItemStack itemStack = player.getItemInHand(hand);
/* 24 */     Level level = event.getLevel();
/*    */ 
/*    */     
/* 27 */     Item item = itemStack.getItem(); if (item instanceof CanteenItem) { CanteenItem canteenItem = (CanteenItem)item; }
/*    */     else
/*    */     { return; }
/*    */ 
/*    */     
/* 32 */     if (LegendarySurvivalOverhaul.crayfishFurnitureLoaded) {
/*    */       
/* 34 */       InteractionResult fillResult = CrayfishFurnitureUtil.tryFillCanteenFromSinkOrBasin(level, event
/*    */           
/* 36 */           .getPos(), player, itemStack);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 41 */       if (fillResult.consumesAction()) {
/* 42 */         event.setCanceled(true);
/* 43 */         event.setCancellationResult(fillResult);
/* 44 */         player.swing(hand, true);
/*    */         
/*    */         return;
/*    */       } 
/*    */       
/* 49 */       InteractionResult emptyResult = CrayfishFurnitureUtil.tryEmptyCanteenIntoSinkOrBasin(level, event
/*    */           
/* 51 */           .getPos(), player, itemStack);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 56 */       if (emptyResult.consumesAction()) {
/* 57 */         event.setCanceled(true);
/* 58 */         event.setCancellationResult(emptyResult);
/* 59 */         player.swing(hand, true);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\events\CanteenInteractionHandler.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */