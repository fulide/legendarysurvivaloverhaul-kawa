/*    */ package sfiomn.legendarysurvivaloverhaul.common.items.drink;
/*    */ 
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.level.ItemLike;
/*    */ import net.minecraft.world.level.Level;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*    */ 
/*    */ public abstract class BottledDrinkItem
/*    */   extends DrinkItem {
/*    */   public BottledDrinkItem(Item.Properties properties) {
/* 16 */     super(properties.stacksTo(64));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getUseDuration(@NotNull ItemStack stack, LivingEntity entity) {
/* 22 */     return 32;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public ItemStack finishUsingItem(@NotNull ItemStack stack, Level level, @NotNull LivingEntity entity) {
/*    */     Player player;
/* 28 */     if (!level.isClientSide && entity instanceof Player) { player = (Player)entity; }
/* 29 */     else { return stack; }
/*    */     
/* 31 */     stack = super.finishUsingItem(stack, level, (LivingEntity)player);
/*    */     
/* 33 */     if (Config.Baked.glassBottleLootAfterDrink) {
/*    */       
/* 35 */       ItemStack glassBottle = new ItemStack((ItemLike)Items.GLASS_BOTTLE);
/*    */       
/* 37 */       if (stack.isEmpty())
/*    */       {
/* 39 */         return glassBottle;
/*    */       }
/*    */       
/* 42 */       int slot = player.getInventory().findSlotMatchingUnusedItem(glassBottle);
/* 43 */       if (slot == -1)
/* 44 */         slot = player.getInventory().getFreeSlot(); 
/* 45 */       if (slot > -1) {
/* 46 */         player.getInventory().add(slot, glassBottle);
/*    */       } else {
/* 48 */         player.drop(glassBottle, false);
/*    */       } 
/*    */     } 
/* 51 */     return stack;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isEnchantable(ItemStack stack) {
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\items\drink\BottledDrinkItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */