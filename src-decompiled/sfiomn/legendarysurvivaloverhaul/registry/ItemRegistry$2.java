/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.TooltipFlag;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.items.WearableCurioItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends WearableCurioItem
/*    */ {
/*    */   null(Item.Properties p_41383_) {
/* 46 */     super(p_41383_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
/* 51 */     super.appendHoverText(stack, context, tooltipComponents, isAdvanced);
/*    */     
/* 53 */     tooltipComponents.add(Component.translatable("tooltip.legendarysurvivaloverhaul.first_aid_supplies.description"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\ItemRegistry$2.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */