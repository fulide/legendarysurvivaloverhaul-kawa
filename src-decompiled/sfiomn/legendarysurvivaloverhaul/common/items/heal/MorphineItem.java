/*    */ package sfiomn.legendarysurvivaloverhaul.common.items.heal;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.item.UseAnim;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MorphineItem
/*    */   extends Item
/*    */ {
/*    */   public MorphineItem(Item.Properties p_i48487_1_) {
/* 28 */     super(p_i48487_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public UseAnim getUseAnimation(@NotNull ItemStack stack) {
/* 34 */     return UseAnim.BOW;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getUseDuration(@NotNull ItemStack stack, LivingEntity entity) {
/* 40 */     return Config.Baked.morphineUseTime;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
/* 46 */     ItemStack stack = player.getItemInHand(hand);
/*    */     
/* 48 */     if (player.hasEffect((Holder)MobEffectRegistry.PAINKILLER_ADDICTION)) {
/*    */       
/* 50 */       player.displayClientMessage((Component)Component.translatable("message.legendarysurvivaloverhaul.morphine_use_under_painkiller_addiction"), true);
/* 51 */       return InteractionResultHolder.fail(stack);
/*    */     } 
/*    */     
/* 54 */     player.startUsingItem(hand);
/* 55 */     return InteractionResultHolder.success(stack);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ItemStack finishUsingItem(@NotNull ItemStack stack, Level level, @NotNull LivingEntity entity) {
/*    */     Player player;
/* 61 */     if (!level.isClientSide && entity instanceof Player) { player = (Player)entity; }
/* 62 */     else { return stack; }
/*    */     
/* 64 */     player.addEffect(new MobEffectInstance((Holder)MobEffectRegistry.PAINKILLER, Config.Baked.morphinePainkillerTickDuration, 0, false, false, true));
/* 65 */     player.addEffect(new MobEffectInstance((Holder)MobEffectRegistry.PAINKILLER_ADDICTION, Config.Baked.painkillerAddictionDuration, 0, false, false, true));
/*    */     
/* 67 */     if (!player.isCreative()) {
/* 68 */       stack.shrink(1);
/*    */     }
/* 70 */     return stack;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEnchantable(@NotNull ItemStack stack) {
/* 76 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void appendHoverText(@NotNull ItemStack stack, @Nullable Item.TooltipContext level, @NotNull List<Component> tooltip, @NotNull TooltipFlag isAdvanced) {
/* 82 */     if (Config.Baked.localizedBodyDamageEnabled)
/* 83 */       tooltip.add(Component.translatable("tooltip.legendarysurvivaloverhaul.body_heal_item.morphine")); 
/* 84 */     super.appendHoverText(stack, level, tooltip, isAdvanced);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\heal\MorphineItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */