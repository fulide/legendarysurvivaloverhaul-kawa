/*    */ package sfiomn.legendarysurvivaloverhaul.client.itemproperties;
/*    */ 
/*    */ import net.minecraft.client.multiplayer.ClientLevel;
/*    */ import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.Level;
/*    */ import net.neoforged.api.distmarker.Dist;
/*    */ import net.neoforged.api.distmarker.OnlyIn;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons.SereneSeasonsUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SeasonalCalendarSeasonTypeProperty
/*    */   implements ClampedItemPropertyFunction
/*    */ {
/*    */   @OnlyIn(Dist.CLIENT)
/*    */   public float unclampedCall(@NotNull ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity entity, int i) {
/*    */     Level level;
/* 24 */     ClientLevel clientLevel1 = clientLevel;
/* 25 */     Entity holder = (entity != null) ? (Entity)entity : (Entity)itemStack.getFrame();
/*    */     
/* 27 */     if (clientLevel1 == null && holder != null)
/*    */     {
/* 29 */       level = holder.level();
/*    */     }
/*    */     
/* 32 */     if (level == null || holder == null)
/*    */     {
/* 34 */       return 0.9F;
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 39 */       float d0 = 0.0F;
/*    */       
/* 41 */       if (LegendarySurvivalOverhaul.sereneSeasonsLoaded) {
/*    */         
/* 43 */         if (!SereneSeasonsUtil.hasSeasons(level)) {
/* 44 */           return 0.9F;
/*    */         }
/* 46 */         SereneSeasonsUtil.SeasonType seasonType = SereneSeasonsUtil.getSeasonType(level.getBiome(holder.blockPosition()));
/* 47 */         d0 = seasonType.propertyValue;
/*    */       }
/* 49 */       else if (LegendarySurvivalOverhaul.eclipticSeasonsLoaded) {
/*    */         
/* 51 */         d0 = 0.3F;
/*    */       } 
/*    */       
/* 54 */       return d0;
/* 55 */     } catch (NullPointerException e) {
/*    */       
/* 57 */       return 0.9F;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\client\itemproperties\SeasonalCalendarSeasonTypeProperty.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */