/*    */ package sfiomn.legendarysurvivaloverhaul.common.items;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.sounds.SoundEvents;
/*    */ import net.minecraft.world.InteractionHand;
/*    */ import net.minecraft.world.InteractionResultHolder;
/*    */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.minecraft.world.level.material.Fluid;
/*    */ import net.minecraft.world.level.material.FluidState;
/*    */ import net.minecraft.world.level.material.Fluids;
/*    */ import net.minecraft.world.phys.BlockHitResult;
/*    */ import net.minecraft.world.phys.HitResult;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ public class NetherChaliceItem
/*    */   extends WearableCurioItem {
/*    */   public NetherChaliceItem(Item.Properties pProperties) {
/* 28 */     super(pProperties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
/* 34 */     if (LegendarySurvivalOverhaul.curiosLoaded) {
/* 35 */       return super.use(level, player, usedHand);
/*    */     }
/* 37 */     ItemStack itemstack = player.getItemInHand(usedHand);
/*    */     
/* 39 */     if (AttachmentUtil.getThirstAttachment(player).isHydrationLevelAtMax()) {
/* 40 */       return InteractionResultHolder.fail(itemstack);
/*    */     }
/* 42 */     HitResult positionLookedAt = player.pick(Math.max(3.0D, player.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE) / 2.0D), 0.0F, true);
/* 43 */     FluidState fluidState = null;
/*    */     
/* 45 */     if (positionLookedAt.getType() == HitResult.Type.BLOCK)
/*    */     {
/* 47 */       fluidState = level.getFluidState(((BlockHitResult)positionLookedAt).getBlockPos());
/*    */     }
/*    */     
/* 50 */     if (fluidState != null && (fluidState.is((Fluid)Fluids.LAVA) || fluidState.is((Fluid)Fluids.FLOWING_LAVA))) {
/*    */       
/* 52 */       player.swing(InteractionHand.MAIN_HAND);
/* 53 */       player.playSound(SoundEvents.GENERIC_DRINK, 1.0F, 1.0F);
/* 54 */       ThirstUtil.takeDrink(player, Config.Baked.hydrationLava, (float)Config.Baked.saturationLava);
/* 55 */       return InteractionResultHolder.pass(itemstack);
/*    */     } 
/*    */     
/* 58 */     return InteractionResultHolder.fail(itemstack);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void appendHoverText(ItemStack stack, @Nullable Item.TooltipContext level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
/* 64 */     super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
/*    */     
/* 66 */     tooltipComponents.add(Component.translatable("tooltip.legendarysurvivaloverhaul.nether_chalice.description"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
/* 72 */     return slotChanged;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\NetherChaliceItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */