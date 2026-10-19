/*    */ package sfiomn.legendarysurvivaloverhaul.client.itemproperties;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
/*    */ import net.minecraft.util.Mth;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureItemAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThermometerProperty
/*    */   implements ClampedItemPropertyFunction
/*    */ {
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public float unclampedCall(@NotNull ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity entity, int i) {
/*    */     Level level;
/* 27 */     ClientLevel clientLevel1 = clientLevel;
/* 28 */     Entity holder = (entity != null) ? (Entity)entity : (Entity)itemStack.getFrame();
/*    */     
/* 30 */     if (clientLevel1 == null && holder != null)
/*    */     {
/* 32 */       level = holder.level();
/*    */     }
/*    */     
/* 35 */     if (level == null)
/*    */     {
/* 37 */       return 0.5F;
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 42 */       TemperatureItemAttachment tempItemCap = AttachmentUtil.getTempItemAttachment(itemStack);
/* 43 */       if (holder != null && tempItemCap.shouldUpdate(level.getGameTime()))
/*    */       {
/* 45 */         tempItemCap.updateWorldTemperature(level, holder, level.getGameTime());
/*    */       }
/* 47 */       return Mth.positiveModulo(TemperatureUtil.clampTemperature((int)tempItemCap.getWorldTemperatureLevel()) / TemperatureEnum.getMax(), 1.0333333F);
/* 48 */     } catch (NullPointerException e) {
/*    */       
/* 50 */       return 0.5F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\itemproperties\ThermometerProperty.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */