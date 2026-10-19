/*    */ package sfiomn.legendarysurvivaloverhaul.common.items;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.core.particles.ParticleOptions;
/*    */ import net.minecraft.core.particles.ParticleTypes;
/*    */ import net.minecraft.network.chat.Component;
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
/*    */ public class HeartContainerItem extends Item {
/*    */   public HeartContainerItem(Item.Properties properties) {
/* 27 */     super(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getUseDuration(@NotNull ItemStack stack, LivingEntity entity) {
/* 33 */     return 30;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public UseAnim getUseAnimation(@NotNull ItemStack stack) {
/* 39 */     return UseAnim.BOW;
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
/* 45 */     if (Config.Baked.healthOverhaulEnabled) {
/*    */       
/* 47 */       HealthAttachment cap = AttachmentUtil.getHealthAttachment(player);
/*    */       
/* 49 */       if (cap.getAdditionalHealth() >= Config.Baked.maxAdditionalHealth) {
/*    */         
/* 51 */         if (level.isClientSide)
/* 52 */           player.displayClientMessage((Component)Component.translatable("message.legendarysurvivaloverhaul.heart_container.additional_health_full"), true); 
/* 53 */         return InteractionResultHolder.fail(player.getItemInHand(hand));
/*    */       } 
/*    */     } 
/*    */     
/* 57 */     player.startUsingItem(hand);
/* 58 */     return InteractionResultHolder.success(player.getItemInHand(hand));
/*    */   }
/*    */ 
/*    */   
/*    */   @NotNull
/*    */   public ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
/* 64 */     if (entity instanceof Player) { Player player = (Player)entity;
/*    */       
/* 66 */       stack = super.finishUsingItem(stack, level, (LivingEntity)player);
/*    */       
/* 68 */       if (!level.isClientSide) {
/* 69 */         player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
/*    */       }
/* 71 */       if (Config.Baked.healthOverhaulEnabled) {
/*    */         
/* 73 */         HealthAttachment cap = AttachmentUtil.getHealthAttachment(player);
/*    */         
/* 75 */         cap.addAdditionalHealth(2.0F);
/*    */         
/* 77 */         level.playSound(null, (Entity)player, (SoundEvent)SoundRegistry.HEART_CONTAINER.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
/* 78 */         for (int i = 0; i < 100; i++)
/*    */         {
/* 80 */           level.addParticle((ParticleOptions)ParticleTypes.CRIMSON_SPORE, (player.position()).x, (player.position().add(0.0D, 1.5D, 0.0D)).y, (player.position()).z, 0.2D, 0.2D, 0.2D);
/*    */         }
/*    */         
/* 83 */         if (level.isClientSide)
/*    */         {
/* 85 */           (Minecraft.getInstance()).gameRenderer.displayItemActivation(stack);
/*    */         }
/*    */       } 
/* 88 */       if (!player.isCreative()) {
/* 89 */         stack.shrink(1);
/*    */       } }
/*    */     
/* 92 */     return stack;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\HeartContainerItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */