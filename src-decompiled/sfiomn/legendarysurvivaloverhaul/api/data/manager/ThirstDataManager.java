/*    */ package sfiomn.legendarysurvivaloverhaul.api.data.manager;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraft.world.level.material.FluidState;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstConsumable;
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
/*    */ public class ThirstDataManager
/*    */ {
/*    */   public static IThirstBlockManager internalBlock;
/*    */   public static IThirstConsumableManager internalConsumable;
/*    */   
/*    */   @Nullable
/*    */   public static List<JsonThirstBlock> getBlock(ResourceLocation blockRegistryName) {
/* 28 */     return internalBlock.get(blockRegistryName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public static JsonThirstBlock getBlock(BlockState block) {
/* 40 */     return internalBlock.get(block);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public static JsonThirstBlock getBlock(FluidState fluid) {
/* 52 */     return internalBlock.get(fluid);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public static List<JsonThirstConsumable> getConsumable(ResourceLocation itemRegistryName) {
/* 64 */     return internalConsumable.get(itemRegistryName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Nullable
/*    */   public static JsonThirstConsumable getConsumable(ItemStack itemStack) {
/* 76 */     return internalConsumable.get(itemStack);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\api\data\manager\ThirstDataManager.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */