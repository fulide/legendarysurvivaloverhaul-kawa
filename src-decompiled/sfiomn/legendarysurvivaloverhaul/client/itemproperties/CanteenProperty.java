/*    */ package sfiomn.legendarysurvivaloverhaul.client.itemproperties;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.thirst.HydrationEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.thirst.ThirstUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CanteenProperty
/*    */   implements ClampedItemPropertyFunction
/*    */ {
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public float unclampedCall(@NotNull ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity entity, int i) {
/* 22 */     HydrationEnum hydrationEnum = ThirstUtil.getHydrationEnumTag(itemStack);
/*    */     
/* 24 */     if (hydrationEnum != null)
/*    */     {
/* 26 */       return hydrationEnum.ordinal() / 10.0F;
/*    */     }
/*    */     
/* 29 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\itemproperties\CanteenProperty.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */