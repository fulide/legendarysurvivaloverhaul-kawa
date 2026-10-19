/*    */ package sfiomn.legendarysurvivaloverhaul.common.items.drink;
/*    */ 
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.UseAnim;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ 
/*    */ public class DrinkItem
/*    */   extends Item
/*    */ {
/*    */   public DrinkItem(Item.Properties properties) {
/* 21 */     super(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void runSecondaryEffect(Player player, ItemStack stack) {}
/*    */ 
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public UseAnim getUseAnimation(@NotNull ItemStack stack) {
/* 32 */     return UseAnim.DRINK;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getUseDuration(@NotNull ItemStack stack, LivingEntity entity) {
/* 38 */     return 16;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
/* 44 */     ItemStack stack = player.getItemInHand(hand);
/*    */     
/* 46 */     if (!Config.Baked.thirstEnabled) {
/*    */ 
/*    */       
/* 49 */       player.startUsingItem(hand);
/* 50 */       return InteractionResultHolder.success(stack);
/*    */     } 
/*    */     
/* 53 */     ThirstAttachment thirstAttachment = AttachmentUtil.getThirstAttachment(player);
/* 54 */     if (!thirstAttachment.isHydrationLevelAtMax()) {
/*    */       
/* 56 */       player.startUsingItem(hand);
/* 57 */       return InteractionResultHolder.success(stack);
/*    */     } 
/*    */     
/* 60 */     return InteractionResultHolder.fail(stack);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ItemStack finishUsingItem(@NotNull ItemStack stack, Level level, @NotNull LivingEntity entity) {
/*    */     Player player;
/* 66 */     if (!level.isClientSide && entity instanceof Player) { player = (Player)entity; }
/* 67 */     else { return stack; }
/*    */     
/* 69 */     runSecondaryEffect(player, stack);
/*    */     
/* 71 */     stack.shrink(1);
/*    */     
/* 73 */     return stack;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEnchantable(ItemStack stack) {
/* 79 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\drink\DrinkItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */