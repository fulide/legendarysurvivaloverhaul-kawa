/*    */ package sfiomn.legendarysurvivaloverhaul.common.integration.mutantmonsters;
/*    */ 
/*    */ import net.minecraft.world.item.Item;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MutantMonstersUtil
/*    */ {
/*    */   public static boolean isMutantMonstersArmor(Item item) {
/* 12 */     return (LegendarySurvivalOverhaul.mutantMonstersLoaded && item instanceof fuzs.mutantmonsters.world.item.ArmorBlockItem);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\integration\mutantmonsters\MutantMonstersUtil.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */