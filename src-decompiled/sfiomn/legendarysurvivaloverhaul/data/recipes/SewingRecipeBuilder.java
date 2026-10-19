/*    */ package sfiomn.legendarysurvivaloverhaul.data.recipes;
/*    */ 
/*    */ import net.minecraft.advancements.Advancement;
/*    */ import net.minecraft.advancements.AdvancementHolder;
/*    */ import net.minecraft.advancements.Criterion;
/*    */ import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
/*    */ import net.minecraft.data.recipes.RecipeBuilder;
/*    */ import net.minecraft.data.recipes.RecipeCategory;
/*    */ import net.minecraft.data.recipes.RecipeOutput;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.item.crafting.Ingredient;
/*    */ import net.minecraft.world.item.crafting.Recipe;
/*    */ import net.minecraft.world.item.crafting.RecipeSerializer;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.recipe.SewingRecipe;
/*    */ import sfiomn.legendarysurvivaloverhaul.registry.RecipeRegistry;
/*    */ 
/*    */ public class SewingRecipeBuilder {
/*    */   private final RecipeCategory category;
/*    */   private final Ingredient base;
/*    */   private final Ingredient addition;
/*    */   private final ItemStack result;
/* 23 */   private final Advancement.Builder advancement = Advancement.Builder.advancement();
/*    */   
/*    */   private final RecipeSerializer<SewingRecipe> type;
/*    */   private boolean hasCriterion = false;
/*    */   
/*    */   public SewingRecipeBuilder(RecipeSerializer<SewingRecipe> type, RecipeCategory category, Ingredient base, Ingredient addition, ItemStack result) {
/* 29 */     this.category = category;
/* 30 */     this.type = type;
/* 31 */     this.base = base;
/* 32 */     this.addition = addition;
/* 33 */     this.result = result;
/*    */   }
/*    */ 
/*    */   
/*    */   public static SewingRecipeBuilder sewingRecipe(Ingredient base, Ingredient addition, ItemStack result, RecipeCategory category) {
/* 38 */     return new SewingRecipeBuilder((RecipeSerializer<SewingRecipe>)RecipeRegistry.SEWING_SERIALIZER.get(), category, base, addition, result);
/*    */   }
/*    */ 
/*    */   
/*    */   public SewingRecipeBuilder unlockedBy(String name, Criterion<?> trigger) {
/* 43 */     this.advancement.addCriterion(name, trigger);
/* 44 */     this.hasCriterion = true;
/* 45 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(RecipeOutput output, String id) {
/* 50 */     save(output, ResourceLocation.parse(id));
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(RecipeOutput output, ResourceLocation id) {
/* 55 */     ensureValid(id);
/*    */ 
/*    */     
/* 58 */     AdvancementHolder advancementHolder = this.advancement.parent(RecipeBuilder.ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).build(id.withPrefix("recipes/" + this.category.getFolderName() + "/"));
/*    */     
/* 60 */     SewingRecipe recipe = new SewingRecipe(this.base, this.addition, this.result);
/* 61 */     output.accept(id, (Recipe)recipe, advancementHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   private void ensureValid(ResourceLocation id) {
/* 66 */     if (!this.hasCriterion)
/*    */     {
/* 68 */       throw new IllegalStateException("No way of obtaining recipe " + String.valueOf(id));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\recipes\SewingRecipeBuilder.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */