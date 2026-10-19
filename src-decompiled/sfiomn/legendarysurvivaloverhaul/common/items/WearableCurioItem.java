/*    */ package sfiomn.legendarysurvivaloverhaul.common.items;
/*    */ 
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.curios.CuriosUtil;
/*    */ 
/*    */ public class WearableCurioItem
/*    */   extends Item
/*    */ {
/*    */   public WearableCurioItem(Item.Properties p_41383_) {
/* 17 */     super(p_41383_);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
/* 24 */     ItemStack itemstack = player.getItemInHand(hand);
/*    */     
/* 26 */     boolean isWorn = CuriosUtil.equipCurio(player, itemstack, hand);
/* 27 */     if (isWorn) {
/* 28 */       level.playSound(null, player.blockPosition(), (SoundEvent)SoundEvents.ARMOR_EQUIP_GENERIC.value(), player.getSoundSource(), 1.0F, 1.0F);
/*    */     }
/* 30 */     return isWorn ? InteractionResultHolder.success(itemstack) : InteractionResultHolder.fail(itemstack);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\WearableCurioItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */