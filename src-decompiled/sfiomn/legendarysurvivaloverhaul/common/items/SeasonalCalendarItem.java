/*    */ package sfiomn.legendarysurvivaloverhaul.common.items;
/*    */ 
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.eclipticseasons.EclipticSeasonsUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons.SereneSeasonsUtil;
/*    */ 
/*    */ 
/*    */ public class SeasonalCalendarItem
/*    */   extends Item
/*    */ {
/*    */   public SeasonalCalendarItem(Item.Properties properties) {
/* 19 */     super(properties.stacksTo(1));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
/* 25 */     if (level.isClientSide())
/*    */     {
/* 27 */       if (LegendarySurvivalOverhaul.sereneSeasonsLoaded) {
/* 28 */         player.displayClientMessage(SereneSeasonsUtil.seasonTooltip(player.blockPosition(), player.level()), true);
/* 29 */       } else if (LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/* 30 */         player.displayClientMessage(EclipticSeasonsUtil.seasonTooltip(player.level()), true);
/*    */       } else {
/* 32 */         player.displayClientMessage((Component)Component.translatable("message.legendarysurvivaloverhaul.no_season_loaded"), true);
/*    */       }  } 
/* 34 */     return super.use(level, player, hand);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\SeasonalCalendarItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */