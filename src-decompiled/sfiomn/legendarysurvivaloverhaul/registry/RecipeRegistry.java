/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.item.crafting.RecipeSerializer;
/*    */ import net.minecraft.world.item.crafting.RecipeType;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.recipe.PurificationBlastingRecipe;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.recipe.PurificationSmeltingRecipe;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.recipe.RemoveCoatRecipe;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.recipe.SewingRecipe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RecipeRegistry
/*    */ {
/* 19 */   public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, "legendarysurvivaloverhaul");
/*    */   
/* 21 */   public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<SewingRecipe>> SEWING_SERIALIZER = RECIPE_SERIALIZERS.register("sewing", () -> SewingRecipe.Serializer.INSTANCE);
/* 22 */   public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PurificationSmeltingRecipe>> PURIFICATION_SMELTING_SERIALIZER = RECIPE_SERIALIZERS.register("purification_smelting", () -> PurificationSmeltingRecipe.Serializer.INSTANCE);
/* 23 */   public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PurificationBlastingRecipe>> PURIFICATION_BLASTING_SERIALIZER = RECIPE_SERIALIZERS.register("purification_blasting", () -> PurificationBlastingRecipe.Serializer.INSTANCE);
/* 24 */   public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<RemoveCoatRecipe>> REMOVE_COAT_SERIALIZER = RECIPE_SERIALIZERS.register("remove_coat", () -> RemoveCoatRecipe.Serializer.INSTANCE);
/*    */   
/* 26 */   public static final DeferredRegister<RecipeType<?>> RECIPE_TYPE = DeferredRegister.create(Registries.RECIPE_TYPE, "legendarysurvivaloverhaul");
/*    */   
/* 28 */   public static final DeferredHolder<RecipeType<?>, RecipeType<SewingRecipe>> SEWING_RECIPE = RECIPE_TYPE.register("sewing", () -> RecipeType.simple(SewingRecipe.Type.ID));
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 32 */     RECIPE_SERIALIZERS.register(eventBus);
/* 33 */     RECIPE_TYPE.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\RecipeRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */