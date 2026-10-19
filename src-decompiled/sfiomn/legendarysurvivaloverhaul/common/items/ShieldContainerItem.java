/*    */ package sfiomn.legendarysurvivaloverhaul.common.items;
/*    */ 
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.minecraft.sounds.SoundSource;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.effect.MobEffects;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.UseAnim;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.health.HealthAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.SoundRegistry;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ public class ShieldContainerItem extends Item {
/*    */   public ShieldContainerItem(Item.Properties properties) {
/* 24 */     super(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getUseDuration(@NotNull ItemStack stack, LivingEntity entity) {
/* 30 */     return 30;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public UseAnim getUseAnimation(@NotNull ItemStack stack) {
/* 36 */     return UseAnim.BOW;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
/* 42 */     if (Config.Baked.healthOverhaulEnabled) {
/*    */       
/* 44 */       HealthAttachment cap = AttachmentUtil.getHealthAttachment(player);
/*    */       
/* 46 */       if (cap.getShieldHealth() > Config.Baked.maxShieldHealth)
/*    */       {
/* 48 */         return InteractionResultHolder.fail(player.getItemInHand(hand));
/*    */       }
/*    */     } 
/*    */     
/* 52 */     player.startUsingItem(hand);
/* 53 */     return InteractionResultHolder.success(player.getItemInHand(hand));
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
/* 59 */     if (entity instanceof Player) { Player player = (Player)entity;
/*    */       
/* 61 */       stack = super.finishUsingItem(stack, level, (LivingEntity)player);
/*    */       
/* 63 */       if (!level.isClientSide) {
/* 64 */         player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
/*    */       }
/* 66 */       if (Config.Baked.healthOverhaulEnabled) {
/*    */         
/* 68 */         HealthAttachment cap = AttachmentUtil.getHealthAttachment(player);
/*    */         
/* 70 */         cap.addShieldHealth(2.0F);
/*    */         
/* 72 */         level.playSound(null, (Entity)player, (SoundEvent)SoundRegistry.HEART_CONTAINER.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/*    */       } 
/*    */       
/* 75 */       if (!player.isCreative()) {
/* 76 */         stack.shrink(1);
/*    */       } }
/*    */     
/* 79 */     return stack;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\ShieldContainerItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */