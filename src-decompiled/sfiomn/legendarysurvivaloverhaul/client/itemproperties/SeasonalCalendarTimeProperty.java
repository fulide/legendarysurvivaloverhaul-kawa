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
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.eclipticseasons.EclipticSeasonsUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons.SereneSeasonsUtil;
/*    */ 
/*    */ public class SeasonalCalendarTimeProperty
/*    */   implements ClampedItemPropertyFunction
/*    */ {
/* 21 */   float olderD0 = 0.0F;
/*    */ 
/*    */   
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
/* 37 */       return 0.0F;
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 42 */       double d0 = 0.0D;
/*    */       
/* 44 */       if (LegendarySurvivalOverhaul.sereneSeasonsLoaded) {
/*    */         
/* 46 */         d0 = SereneSeasonsUtil.getTimeInSeasonCycle(level);
/* 47 */       } else if (LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/* 48 */         d0 = EclipticSeasonsUtil.getDayInSeasonCycle(level);
/*    */       } 
/* 50 */       return Mth.positiveModulo((float)d0, 1.0F);
/* 51 */     } catch (NullPointerException e) {
/*    */       
/* 53 */       return 0.0F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\itemproperties\SeasonalCalendarTimeProperty.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */