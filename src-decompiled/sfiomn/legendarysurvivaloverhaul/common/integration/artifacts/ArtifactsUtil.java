/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.artifacts;
/*    */ 
/*    */ import javax.annotation.Nonnull;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArtifactsUtil
/*    */ {
/*    */   public static boolean isHoldingUmbrella(Player player) {
/* 15 */     if (LegendarySurvivalOverhaul.artifactsLoaded && player != null)
/*    */     {
/*    */       
/* 18 */       if (player.isHolding(itemStack -> itemStack.getItem() instanceof artifacts.item.UmbrellaItem))
/* 19 */         return !(player.getUseItem().getItem() instanceof artifacts.item.UmbrellaItem); 
/*    */     }
/* 21 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean canProvideShade(@Nonnull ResourceLocation itemRegistryName) {
/* 26 */     return (LegendarySurvivalOverhaul.artifactsLoaded && itemRegistryName.toString().equals("artifacts:umbrella"));
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\artifacts\ArtifactsUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */