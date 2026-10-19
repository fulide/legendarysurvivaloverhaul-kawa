/*     */ package sfiomn.legendarysurvivaloverhaul.common.items.heal;
/*     */ 
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.core.registries.BuiltInRegistries;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.InteractionResultHolder;
/*     */ import net.minecraft.world.effect.MobEffectInstance;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.UseAnim;
/*     */ import net.minecraft.world.level.Level;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyDamageUtil;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonHealingConsumable;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.manager.BodyDamageDataManager;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.bodydamage.BodyDamageAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.MobEffectRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ 
/*     */ public class BodyHealingItem
/*     */   extends Item
/*     */ {
/*     */   public BodyHealingItem(Item.Properties properties) {
/*  28 */     super(properties);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UseAnim getUseAnimation(ItemStack stack) {
/*  34 */     return UseAnim.BOW;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUseDuration(ItemStack stack, LivingEntity entity) {
/*  40 */     return 20;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
/*  46 */     ItemStack stack = player.getItemInHand(hand);
/*     */     
/*  48 */     if (!Config.Baked.localizedBodyDamageEnabled) {
/*     */ 
/*     */       
/*  51 */       player.startUsingItem(hand);
/*  52 */       return InteractionResultHolder.success(stack);
/*     */     } 
/*     */     
/*  55 */     ResourceLocation registryName = BuiltInRegistries.ITEM.getKey(this);
/*  56 */     JsonHealingConsumable jsonConsumableHeal = BodyDamageDataManager.getHealingItem(registryName);
/*     */     
/*  58 */     if (jsonConsumableHeal != null) {
/*     */       
/*  60 */       BodyDamageAttachment bodyDamageAttachment = AttachmentUtil.getBodyDamageAttachment(player);
/*     */       
/*  62 */       if (jsonConsumableHeal.healingCharges == 0) {
/*     */         
/*  64 */         for (BodyPartEnum bodyPart : BodyPartEnum.values()) {
/*     */           
/*  66 */           if (bodyDamageAttachment.getBodyPartDamage(bodyPart) > 0.0F || player.getHealth() < player.getMaxHealth()) {
/*     */             
/*  68 */             player.startUsingItem(hand);
/*  69 */             return InteractionResultHolder.success(stack);
/*     */           } 
/*     */         } 
/*  72 */       } else if (jsonConsumableHeal.healingCharges > 0) {
/*     */         
/*  74 */         player.startUsingItem(hand);
/*  75 */         return InteractionResultHolder.success(stack);
/*     */       } 
/*     */     } 
/*     */     
/*  79 */     return InteractionResultHolder.fail(stack);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
/*     */     Player player;
/*  85 */     if (entity instanceof Player) { player = (Player)entity; }
/*  86 */     else { return stack; }
/*     */     
/*  88 */     ResourceLocation registryName = BuiltInRegistries.ITEM.getKey(this);
/*  89 */     JsonHealingConsumable jsonConsumableHeal = BodyDamageDataManager.getHealingItem(registryName);
/*     */     
/*  91 */     if (jsonConsumableHeal == null) {
/*  92 */       return stack;
/*     */     }
/*  94 */     if (!Config.Baked.localizedBodyDamageEnabled) {
/*     */       
/*  96 */       if (jsonConsumableHeal.recoveryEffectDuration > 0) {
/*  97 */         player.addEffect(new MobEffectInstance((Holder)MobEffectRegistry.RECOVERY, jsonConsumableHeal.recoveryEffectDuration, jsonConsumableHeal.recoveryEffectAmplifier, false, true, true));
/*     */       }
/*     */ 
/*     */       
/* 101 */       stack.shrink(1);
/* 102 */       return stack;
/*     */     } 
/*     */     
/* 105 */     BodyDamageUtil.applyConsumableHealing(player, stack, false);
/*     */     
/* 107 */     return stack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnchantable(ItemStack stack) {
/* 113 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\heal\BodyHealingItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */