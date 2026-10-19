/*    */ package sfiomn.legendarysurvivaloverhaul.common.items.heal;
/*    */ 
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ public class PlasterItem
/*    */   extends BodyHealingItem {
/*    */   public PlasterItem(Item.Properties properties) {
/* 11 */     super(properties);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getUseDuration(ItemStack stack, LivingEntity entity) {
/* 17 */     return Config.Baked.plasterUseTime;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\heal\PlasterItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */