/*    */ package sfiomn.legendarysurvivaloverhaul.common.items.heal;
/*    */ 
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.UseAnim;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ public class HealingHerbsItem
/*    */   extends BodyHealingItem {
/*    */   public HealingHerbsItem(Item.Properties properties) {
/* 12 */     super(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public UseAnim getUseAnimation(ItemStack stack) {
/* 18 */     return UseAnim.EAT;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getUseDuration(ItemStack stack, LivingEntity entity) {
/* 24 */     return Config.Baked.healingHerbsUseTime;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\heal\HealingHerbsItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */