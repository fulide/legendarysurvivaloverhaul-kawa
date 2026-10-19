/*     */ package sfiomn.legendarysurvivaloverhaul.data.providers;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.data.PackOutput;
/*     */ import net.minecraft.data.recipes.RecipeCategory;
/*     */ import net.minecraft.data.recipes.RecipeOutput;
/*     */ import net.minecraft.data.recipes.RecipeProvider;
/*     */ import net.minecraft.data.recipes.ShapedRecipeBuilder;
/*     */ import net.minecraft.data.recipes.ShapelessRecipeBuilder;
/*     */ import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
/*     */ import net.minecraft.data.recipes.SpecialRecipeBuilder;
/*     */ import net.minecraft.nbt.CompoundTag;
/*     */ import net.minecraft.tags.ItemTags;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraft.world.level.ItemLike;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.neoforged.neoforge.common.Tags;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.thirst.HydrationEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SewingTableBlock;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.recipes.PurificationRecipeBuilder;
/*     */ import sfiomn.legendarysurvivaloverhaul.data.recipes.SewingRecipeBuilder;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.BlockRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.ItemRegistry;
/*     */ 
/*     */ public class ModRecipeProvider extends RecipeProvider {
/*     */   public ModRecipeProvider(PackOutput generator, CompletableFuture<HolderLookup.Provider> lookupProvider) {
/*  32 */     super(generator, lookupProvider);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void smelting(@NotNull RecipeOutput output, Ingredient input, ItemLike result, float experience, int cookingTime, String recipeName) {
/*  38 */     SimpleCookingRecipeBuilder.smelting(input, RecipeCategory.MISC, result, experience, cookingTime)
/*  39 */       .unlockedBy(getHasName((ItemLike)input.getItems()[0].getItem()), has((ItemLike)input.getItems()[0].getItem()))
/*  40 */       .save(output, "legendarysurvivaloverhaul:" + recipeName + "_from_smelting_" + getItemName((ItemLike)input.getItems()[0].getItem()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void purification_smelting(@NotNull RecipeOutput output, Ingredient input, ItemLike result, float experience, int cookingTime, String recipeName) {
/*  46 */     PurificationRecipeBuilder.smelting(input, RecipeCategory.MISC, result, experience, cookingTime)
/*  47 */       .unlockedBy(getHasName((ItemLike)input.getItems()[0].getItem()), has((ItemLike)input.getItems()[0].getItem()))
/*  48 */       .group("purification")
/*  49 */       .save(output, "legendarysurvivaloverhaul:" + recipeName + "_from_purification_smelting_" + getItemName((ItemLike)input.getItems()[0].getItem()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void blasting(@NotNull RecipeOutput output, Ingredient input, ItemLike result, float experience, int cookingTime, String recipeName) {
/*  55 */     SimpleCookingRecipeBuilder.blasting(input, RecipeCategory.MISC, result, experience, cookingTime)
/*  56 */       .unlockedBy(getHasName((ItemLike)input.getItems()[0].getItem()), has((ItemLike)input.getItems()[0].getItem()))
/*  57 */       .save(output, "legendarysurvivaloverhaul:" + recipeName + "_from_blasting_" + getItemName((ItemLike)input.getItems()[0].getItem()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void purification_blasting(@NotNull RecipeOutput output, Ingredient input, ItemLike result, float experience, int cookingTime, String recipeName) {
/*  63 */     PurificationRecipeBuilder.blasting(input, RecipeCategory.MISC, result, experience, cookingTime)
/*  64 */       .unlockedBy(getHasName((ItemLike)input.getItems()[0].getItem()), has((ItemLike)input.getItems()[0].getItem()))
/*  65 */       .group("purification")
/*  66 */       .save(output, "legendarysurvivaloverhaul:" + recipeName + "_from_purification_blasting_" + getItemName((ItemLike)input.getItems()[0].getItem()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void sewing(@NotNull RecipeOutput output, Ingredient input, Ingredient addition, ItemStack result, String recipeName) {
/*  71 */     String additionName = getItemName((ItemLike)addition.getItems()[0].getItem());
/*     */ 
/*     */     
/*  74 */     SewingRecipeBuilder.sewingRecipe(input, addition, result, RecipeCategory.MISC)
/*  75 */       .unlockedBy("has_coat", has((ItemLike)addition.getItems()[0].getItem()))
/*  76 */       .unlockedBy(getHasName((ItemLike)((SewingTableBlock)BlockRegistry.SEWING_TABLE.get()).asItem()), insideOf((Block)BlockRegistry.SEWING_TABLE.get()))
/*  77 */       .save(output, "legendarysurvivaloverhaul:" + recipeName + "_from_sewing_" + getItemName((ItemLike)input.getItems()[0].getItem()) + "_" + additionName);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void juice(RecipeOutput consumer, ItemLike fruit, Item juice) {
/*  82 */     ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, (ItemLike)juice)
/*  83 */       .requires((ItemLike)ItemRegistry.PURIFIED_WATER_BOTTLE.get())
/*  84 */       .requires((ItemLike)Items.SUGAR)
/*  85 */       .requires(fruit)
/*  86 */       .requires(fruit)
/*  87 */       .requires(fruit)
/*  88 */       .group("drink")
/*  89 */       .unlockedBy(getHasName(fruit), has(fruit))
/*  90 */       .save(consumer);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Ingredient partialNbtIngredient(ItemLike item, CompoundTag nbt) {
/*  96 */     return Ingredient.of(new ItemLike[] { item });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void buildRecipes(@NotNull RecipeOutput output) {
/* 102 */     ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)ItemRegistry.DESERT_HELMET.get())
/* 103 */       .pattern("r#r")
/* 104 */       .pattern("r r")
/* 105 */       .define(Character.valueOf('#'), (ItemLike)Items.LEATHER)
/* 106 */       .define(Character.valueOf('r'), (ItemLike)Items.STRING)
/* 107 */       .group("desert_armor")
/* 108 */       .unlockedBy(getHasName((ItemLike)Items.LEATHER), has((ItemLike)Items.LEATHER))
/* 109 */       .save(output);
/*     */     
/* 111 */     ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)ItemRegistry.DESERT_BOOTS.get())
/* 112 */       .pattern("r r")
/* 113 */       .pattern("# #")
/* 114 */       .define(Character.valueOf('#'), (ItemLike)Items.LEATHER)
/* 115 */       .define(Character.valueOf('r'), (ItemLike)Items.STRING)
/* 116 */       .group("desert_armor")
/* 117 */       .unlockedBy(getHasName((ItemLike)Items.LEATHER), has((ItemLike)Items.LEATHER))
/* 118 */       .save(output);
/*     */     
/* 120 */     ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)ItemRegistry.DESERT_CHEST.get())
/* 121 */       .pattern("r r")
/* 122 */       .pattern("#r#")
/* 123 */       .pattern("###")
/* 124 */       .define(Character.valueOf('#'), (ItemLike)Items.LEATHER)
/* 125 */       .define(Character.valueOf('r'), (ItemLike)Items.STRING)
/* 126 */       .unlockedBy(getHasName((ItemLike)Items.LEATHER), has((ItemLike)Items.LEATHER))
/* 127 */       .group("desert_armor")
/* 128 */       .save(output);
/*     */     
/* 130 */     ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)ItemRegistry.DESERT_LEGGINGS.get())
/* 131 */       .pattern("###")
/* 132 */       .pattern("###")
/* 133 */       .pattern("r r")
/* 134 */       .define(Character.valueOf('#'), (ItemLike)Items.LEATHER)
/* 135 */       .define(Character.valueOf('r'), (ItemLike)Items.STRING)
/* 136 */       .unlockedBy(getHasName((ItemLike)Items.LEATHER), has((ItemLike)Items.LEATHER))
/* 137 */       .group("desert_armor")
/* 138 */       .save(output);
/*     */     
/* 140 */     ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)ItemRegistry.SNOW_HELMET.get())
/* 141 */       .pattern("w#w")
/* 142 */       .pattern("w w")
/* 143 */       .define(Character.valueOf('#'), (ItemLike)Items.LEATHER)
/* 144 */       .define(Character.valueOf('w'), ItemTags.WOOL)
/* 145 */       .group("snow_Armor")
/* 146 */       .unlockedBy("has_wool", has(ItemTags.WOOL))
/* 147 */       .save(output);
/*     */     
/* 149 */     ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)ItemRegistry.SNOW_BOOTS.get())
/* 150 */       .pattern("w w")
/* 151 */       .pattern("w w")
/* 152 */       .define(Character.valueOf('w'), ItemTags.WOOL)
/* 153 */       .group("snow_Armor")
/* 154 */       .unlockedBy("has_wool", has(ItemTags.WOOL))
/* 155 */       .save(output);
/*     */     
/* 157 */     ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)ItemRegistry.SNOW_CHEST.get())
/* 158 */       .pattern("w w")
/* 159 */       .pattern("www")
/* 160 */       .pattern("w#w")
/* 161 */       .define(Character.valueOf('#'), (ItemLike)Items.LEATHER)
/* 162 */       .define(Character.valueOf('w'), ItemTags.WOOL)
/* 163 */       .group("snow_Armor")
/* 164 */       .unlockedBy("has_wool", has(ItemTags.WOOL))
/* 165 */       .save(output);
/*     */     
/* 167 */     ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, (ItemLike)ItemRegistry.SNOW_LEGGINGS.get())
/* 168 */       .pattern("www")
/* 169 */       .pattern("w w")
/* 170 */       .pattern("w w")
/* 171 */       .define(Character.valueOf('w'), ItemTags.WOOL)
/* 172 */       .group("snow_Armor")
/* 173 */       .unlockedBy("has_wool", has(ItemTags.WOOL))
/* 174 */       .save(output);
/*     */     
/* 176 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.COOLING_COAT_1.get())
/* 177 */       .pattern(" is")
/* 178 */       .pattern("isc")
/* 179 */       .pattern("scc")
/* 180 */       .define(Character.valueOf('i'), (ItemLike)Items.IRON_INGOT)
/* 181 */       .define(Character.valueOf('c'), (ItemLike)ItemRegistry.COLD_STRING.get())
/* 182 */       .define(Character.valueOf('s'), (ItemLike)Items.STICK)
/* 183 */       .group("cooling_coat")
/* 184 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.COLD_STRING.get()), has((ItemLike)ItemRegistry.COLD_STRING.get()))
/* 185 */       .save(output);
/*     */     
/* 187 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.COOLING_COAT_2.get())
/* 188 */       .pattern(" db")
/* 189 */       .pattern("db#")
/* 190 */       .pattern("b##")
/* 191 */       .define(Character.valueOf('d'), (ItemLike)Items.DIAMOND)
/* 192 */       .define(Character.valueOf('b'), (ItemLike)Items.BLAZE_ROD)
/* 193 */       .define(Character.valueOf('#'), (ItemLike)ItemRegistry.COOLING_COAT_1.get())
/* 194 */       .group("cooling_coat")
/* 195 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.COLD_STRING.get()), has((ItemLike)ItemRegistry.COLD_STRING.get()))
/* 196 */       .save(output);
/*     */     
/* 198 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.COOLING_COAT_3.get())
/* 199 */       .pattern(" ne")
/* 200 */       .pattern("ne#")
/* 201 */       .pattern("e##")
/* 202 */       .define(Character.valueOf('n'), (ItemLike)Items.NETHERITE_INGOT)
/* 203 */       .define(Character.valueOf('e'), (ItemLike)Items.END_ROD)
/* 204 */       .define(Character.valueOf('#'), (ItemLike)ItemRegistry.COOLING_COAT_2.get())
/* 205 */       .group("cooling_coat")
/* 206 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.COLD_STRING.get()), has((ItemLike)ItemRegistry.COLD_STRING.get()))
/* 207 */       .save(output);
/*     */     
/* 209 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.HEATING_COAT_1.get())
/* 210 */       .pattern(" is")
/* 211 */       .pattern("isw")
/* 212 */       .pattern("sww")
/* 213 */       .define(Character.valueOf('i'), (ItemLike)Items.IRON_INGOT)
/* 214 */       .define(Character.valueOf('w'), (ItemLike)ItemRegistry.WARM_STRING.get())
/* 215 */       .define(Character.valueOf('s'), (ItemLike)Items.STICK)
/* 216 */       .group("heating_coat")
/* 217 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.WARM_STRING.get()), has((ItemLike)ItemRegistry.WARM_STRING.get()))
/* 218 */       .save(output);
/*     */     
/* 220 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.HEATING_COAT_2.get())
/* 221 */       .pattern(" db")
/* 222 */       .pattern("db#")
/* 223 */       .pattern("b##")
/* 224 */       .define(Character.valueOf('d'), (ItemLike)Items.DIAMOND)
/* 225 */       .define(Character.valueOf('b'), (ItemLike)Items.BLAZE_ROD)
/* 226 */       .define(Character.valueOf('#'), (ItemLike)ItemRegistry.HEATING_COAT_1.get())
/* 227 */       .group("heating_coat")
/* 228 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.WARM_STRING.get()), has((ItemLike)ItemRegistry.WARM_STRING.get()))
/* 229 */       .save(output);
/*     */     
/* 231 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.HEATING_COAT_3.get())
/* 232 */       .pattern(" ne")
/* 233 */       .pattern("ne#")
/* 234 */       .pattern("e##")
/* 235 */       .define(Character.valueOf('n'), (ItemLike)Items.NETHERITE_INGOT)
/* 236 */       .define(Character.valueOf('e'), (ItemLike)Items.END_ROD)
/* 237 */       .define(Character.valueOf('#'), (ItemLike)ItemRegistry.HEATING_COAT_2.get())
/* 238 */       .group("heating_coat")
/* 239 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.WARM_STRING.get()), has((ItemLike)ItemRegistry.WARM_STRING.get()))
/* 240 */       .save(output);
/*     */     
/* 242 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.THERMAL_COAT_1.get())
/* 243 */       .pattern(" cs")
/* 244 */       .pattern(" sh")
/* 245 */       .pattern("   ")
/* 246 */       .define(Character.valueOf('c'), (ItemLike)ItemRegistry.COOLING_COAT_1.get())
/* 247 */       .define(Character.valueOf('s'), (ItemLike)Items.STICK)
/* 248 */       .define(Character.valueOf('h'), (ItemLike)ItemRegistry.HEATING_COAT_1.get())
/* 249 */       .group("thermal_coat")
/* 250 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.COOLING_COAT_1.get()), has((ItemLike)ItemRegistry.COOLING_COAT_1.get()))
/* 251 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.HEATING_COAT_1.get()), has((ItemLike)ItemRegistry.HEATING_COAT_1.get()))
/* 252 */       .save(output);
/*     */     
/* 254 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.THERMAL_COAT_2.get())
/* 255 */       .pattern(" cb")
/* 256 */       .pattern(" bh")
/* 257 */       .pattern("   ")
/* 258 */       .define(Character.valueOf('c'), (ItemLike)ItemRegistry.COOLING_COAT_2.get())
/* 259 */       .define(Character.valueOf('b'), (ItemLike)Items.BLAZE_ROD)
/* 260 */       .define(Character.valueOf('h'), (ItemLike)ItemRegistry.HEATING_COAT_2.get())
/* 261 */       .group("thermal_coat")
/* 262 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.COOLING_COAT_2.get()), has((ItemLike)ItemRegistry.COOLING_COAT_2.get()))
/* 263 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.HEATING_COAT_2.get()), has((ItemLike)ItemRegistry.HEATING_COAT_2.get()))
/* 264 */       .save(output);
/*     */     
/* 266 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.THERMAL_COAT_3.get())
/* 267 */       .pattern(" ce")
/* 268 */       .pattern(" eh")
/* 269 */       .pattern("   ")
/* 270 */       .define(Character.valueOf('c'), (ItemLike)ItemRegistry.COOLING_COAT_3.get())
/* 271 */       .define(Character.valueOf('e'), (ItemLike)Items.END_ROD)
/* 272 */       .define(Character.valueOf('h'), (ItemLike)ItemRegistry.HEATING_COAT_3.get())
/* 273 */       .group("thermal_coat")
/* 274 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.COOLING_COAT_3.get()), has((ItemLike)ItemRegistry.COOLING_COAT_3.get()))
/* 275 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.HEATING_COAT_3.get()), has((ItemLike)ItemRegistry.HEATING_COAT_3.get()))
/* 276 */       .save(output);
/*     */     
/* 278 */     ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, (ItemLike)BlockRegistry.COOLER.get())
/* 279 */       .pattern("psp")
/* 280 */       .pattern("prp")
/* 281 */       .pattern("ppp")
/* 282 */       .define(Character.valueOf('s'), (ItemLike)Items.SNOW_BLOCK)
/* 283 */       .define(Character.valueOf('p'), ItemTags.PLANKS)
/* 284 */       .define(Character.valueOf('r'), (ItemLike)Items.REDSTONE)
/* 285 */       .unlockedBy(getHasName((ItemLike)Items.STONE), has((ItemLike)Items.STONE))
/* 286 */       .save(output);
/*     */     
/* 288 */     ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, (ItemLike)BlockRegistry.HEATER.get())
/* 289 */       .pattern(" i ")
/* 290 */       .pattern("ici")
/* 291 */       .pattern("iwi")
/* 292 */       .define(Character.valueOf('i'), (ItemLike)Items.IRON_INGOT)
/* 293 */       .define(Character.valueOf('c'), (ItemLike)Items.CAMPFIRE)
/* 294 */       .define(Character.valueOf('w'), (ItemLike)Items.COAL_BLOCK)
/* 295 */       .unlockedBy(getHasName((ItemLike)Items.CAMPFIRE), has((ItemLike)Items.CAMPFIRE))
/* 296 */       .save(output);
/*     */     
/* 298 */     ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, (ItemLike)ItemRegistry.SEASONAL_CALENDAR.get())
/* 299 */       .pattern("ppp")
/* 300 */       .pattern("pcp")
/* 301 */       .pattern("ppp")
/* 302 */       .define(Character.valueOf('p'), (ItemLike)Items.PAPER)
/* 303 */       .define(Character.valueOf('c'), (ItemLike)Items.CLOCK)
/* 304 */       .unlockedBy(getHasName((ItemLike)Items.PAPER), has((ItemLike)Items.PAPER))
/* 305 */       .save(output);
/*     */     
/* 307 */     ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, (ItemLike)ItemRegistry.THERMOMETER.get())
/* 308 */       .pattern("#g#")
/* 309 */       .pattern("#r#")
/* 310 */       .pattern("i#i")
/* 311 */       .define(Character.valueOf('#'), (ItemLike)Items.GLASS)
/* 312 */       .define(Character.valueOf('g'), (ItemLike)Items.GOLD_INGOT)
/* 313 */       .define(Character.valueOf('i'), (ItemLike)Items.IRON_INGOT)
/* 314 */       .define(Character.valueOf('r'), (ItemLike)Items.REDSTONE)
/* 315 */       .unlockedBy("has_glass", has((ItemLike)Items.GLASS))
/* 316 */       .unlockedBy("has_iron", has((ItemLike)Items.IRON_INGOT))
/* 317 */       .unlockedBy("has_redstone", has((ItemLike)Items.REDSTONE))
/* 318 */       .unlockedBy("has_gold_ingot", has((ItemLike)Items.GOLD_INGOT))
/* 319 */       .save(output);
/*     */     
/* 321 */     ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, (ItemLike)BlockRegistry.SEWING_TABLE.get())
/* 322 */       .pattern("iii")
/* 323 */       .pattern("r i")
/* 324 */       .pattern("ppp")
/* 325 */       .define(Character.valueOf('i'), (ItemLike)Items.IRON_INGOT)
/* 326 */       .define(Character.valueOf('r'), (ItemLike)Items.REDSTONE)
/* 327 */       .define(Character.valueOf('p'), ItemTags.PLANKS)
/* 328 */       .unlockedBy("has_planks", has(ItemTags.PLANKS))
/* 329 */       .unlockedBy("has_iron", has((ItemLike)Items.IRON_INGOT))
/* 330 */       .unlockedBy("has_redstone", has((ItemLike)Items.REDSTONE))
/* 331 */       .save(output);
/*     */     
/* 333 */     ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, (ItemLike)ItemRegistry.HEART_CONTAINER.get())
/* 334 */       .pattern("hhh")
/* 335 */       .pattern("hhh")
/* 336 */       .pattern("hhh")
/* 337 */       .define(Character.valueOf('h'), (ItemLike)ItemRegistry.HEART_FRAGMENT.get())
/* 338 */       .unlockedBy("has_heart_fragment", has((ItemLike)ItemRegistry.HEART_FRAGMENT.get()))
/* 339 */       .save(output);
/*     */     
/* 341 */     CompoundTag nbt = new CompoundTag();
/* 342 */     nbt.putString("Potion", "legendarysurvivaloverhaul:temperature_immunity");
/* 343 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.THERMAL_RESISTANCE_RING.get())
/* 344 */       .pattern(" wh")
/* 345 */       .pattern("stw")
/* 346 */       .pattern("cs ")
/* 347 */       .define(Character.valueOf('w'), (ItemLike)ItemRegistry.WARM_STRING.get())
/* 348 */       .define(Character.valueOf('s'), (ItemLike)ItemRegistry.COLD_STRING.get())
/* 349 */       .define(Character.valueOf('t'), partialNbtIngredient((ItemLike)Items.POTION, nbt))
/* 350 */       .define(Character.valueOf('h'), (ItemLike)ItemRegistry.HEAT_RESISTANCE_RING.get())
/* 351 */       .define(Character.valueOf('c'), (ItemLike)ItemRegistry.COLD_RESISTANCE_RING.get())
/* 352 */       .unlockedBy("has_heat_resistance_ring", has((ItemLike)ItemRegistry.HEAT_RESISTANCE_RING.get()))
/* 353 */       .unlockedBy("has_cold_resistance_ring", has((ItemLike)ItemRegistry.COLD_RESISTANCE_RING.get()))
/* 354 */       .save(output);
/*     */     
/* 356 */     juice(output, (ItemLike)Items.APPLE, (Item)ItemRegistry.APPLE_JUICE.get());
/* 357 */     juice(output, (ItemLike)Items.BEETROOT, (Item)ItemRegistry.BEETROOT_JUICE.get());
/* 358 */     juice(output, (ItemLike)Items.CACTUS, (Item)ItemRegistry.CACTUS_JUICE.get());
/* 359 */     juice(output, (ItemLike)Items.CARROT, (Item)ItemRegistry.CARROT_JUICE.get());
/* 360 */     juice(output, (ItemLike)Items.CHORUS_FRUIT, (Item)ItemRegistry.CHORUS_FRUIT_JUICE.get());
/* 361 */     juice(output, (ItemLike)Items.GLISTERING_MELON_SLICE, (Item)ItemRegistry.GLISTERING_MELON_JUICE.get());
/* 362 */     juice(output, (ItemLike)Items.GOLDEN_APPLE, (Item)ItemRegistry.GOLDEN_APPLE_JUICE.get());
/* 363 */     juice(output, (ItemLike)Items.GOLDEN_CARROT, (Item)ItemRegistry.GOLDEN_CARROT_JUICE.get());
/* 364 */     juice(output, (ItemLike)Items.MELON_SLICE, (Item)ItemRegistry.MELON_JUICE.get());
/* 365 */     juice(output, (ItemLike)Items.PUMPKIN, (Item)ItemRegistry.PUMPKIN_JUICE.get());
/* 366 */     juice(output, (ItemLike)Items.SWEET_BERRIES, (Item)ItemRegistry.SWEET_BERRIES_JUICE.get());
/* 367 */     juice(output, (ItemLike)Items.GLOW_BERRIES, (Item)ItemRegistry.GLOW_BERRIES_JUICE.get());
/*     */     
/* 369 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.CANTEEN.get())
/* 370 */       .pattern(" i ")
/* 371 */       .pattern("l l")
/* 372 */       .pattern("lll")
/* 373 */       .define(Character.valueOf('i'), (ItemLike)Items.IRON_INGOT)
/* 374 */       .define(Character.valueOf('l'), (ItemLike)Items.LEATHER)
/* 375 */       .group("drink")
/* 376 */       .unlockedBy(getHasName((ItemLike)Items.LEATHER), has((ItemLike)Items.LEATHER))
/* 377 */       .save(output);
/*     */     
/* 379 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.LARGE_CANTEEN.get())
/* 380 */       .pattern(" n ")
/* 381 */       .pattern("l l")
/* 382 */       .pattern("lll")
/* 383 */       .define(Character.valueOf('n'), (ItemLike)Items.NETHERITE_SCRAP)
/* 384 */       .define(Character.valueOf('l'), (ItemLike)Items.LEATHER)
/* 385 */       .group("healing")
/* 386 */       .unlockedBy(getHasName((ItemLike)Items.LEATHER), has((ItemLike)Items.LEATHER))
/* 387 */       .save(output);
/*     */     
/* 389 */     ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, (ItemLike)ItemRegistry.HEALING_HERBS.get())
/* 390 */       .pattern("ff ")
/* 391 */       .pattern("ss ")
/* 392 */       .pattern("   ")
/* 393 */       .define(Character.valueOf('f'), ItemTags.FLOWERS)
/* 394 */       .define(Character.valueOf('s'), Tags.Items.SEEDS)
/* 395 */       .group("healing")
/* 396 */       .unlockedBy("has_flower", has(ItemTags.FLOWERS))
/* 397 */       .save(output);
/*     */     
/* 399 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.PLASTER.get())
/* 400 */       .pattern("ss ")
/* 401 */       .pattern("ww ")
/* 402 */       .pattern("   ")
/* 403 */       .define(Character.valueOf('s'), (ItemLike)Items.STRING)
/* 404 */       .define(Character.valueOf('w'), ItemTags.WOOL)
/* 405 */       .group("healing")
/* 406 */       .unlockedBy("has_wool", has(ItemTags.WOOL))
/* 407 */       .save(output);
/*     */     
/* 409 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.MEDKIT.get())
/* 410 */       .pattern("sis")
/* 411 */       .pattern("gbg")
/* 412 */       .pattern("www")
/* 413 */       .define(Character.valueOf('s'), (ItemLike)Items.STRING)
/* 414 */       .define(Character.valueOf('i'), (ItemLike)Items.IRON_INGOT)
/* 415 */       .define(Character.valueOf('g'), (ItemLike)Items.GOLD_INGOT)
/* 416 */       .define(Character.valueOf('b'), (ItemLike)ItemRegistry.BANDAGE.get())
/* 417 */       .define(Character.valueOf('w'), ItemTags.WOOL)
/* 418 */       .group("healing")
/* 419 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.BANDAGE.get()), has((ItemLike)ItemRegistry.BANDAGE.get()))
/* 420 */       .save(output);
/*     */     
/* 422 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.MORPHINE.get())
/* 423 */       .pattern("  n")
/* 424 */       .pattern(" t ")
/* 425 */       .pattern("g  ")
/* 426 */       .define(Character.valueOf('n'), (ItemLike)Items.IRON_NUGGET)
/* 427 */       .define(Character.valueOf('t'), (ItemLike)ItemRegistry.TONIC.get())
/* 428 */       .define(Character.valueOf('g'), (ItemLike)Items.GLASS)
/* 429 */       .group("healing")
/* 430 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.PLASTER.get()), has((ItemLike)ItemRegistry.PLASTER.get()))
/* 431 */       .save(output);
/*     */     
/* 433 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.BANDAGE.get())
/* 434 */       .pattern("  p")
/* 435 */       .pattern(" h ")
/* 436 */       .pattern("p  ")
/* 437 */       .define(Character.valueOf('p'), (ItemLike)ItemRegistry.PLASTER.get())
/* 438 */       .define(Character.valueOf('h'), (ItemLike)ItemRegistry.HEALING_HERBS.get())
/* 439 */       .group("healing")
/* 440 */       .unlockedBy("has_plaster", has((ItemLike)ItemRegistry.PLASTER.get()))
/* 441 */       .save(output);
/*     */     
/* 443 */     ShapedRecipeBuilder.shaped(RecipeCategory.MISC, (ItemLike)ItemRegistry.TONIC.get())
/* 444 */       .pattern(" h ")
/* 445 */       .pattern("gbg")
/* 446 */       .pattern(" g ")
/* 447 */       .define(Character.valueOf('h'), (ItemLike)ItemRegistry.HEALING_HERBS.get())
/* 448 */       .define(Character.valueOf('b'), (ItemLike)Items.GLASS_BOTTLE)
/* 449 */       .define(Character.valueOf('g'), (ItemLike)Items.GOLD_INGOT)
/* 450 */       .group("healing")
/* 451 */       .unlockedBy(getHasName((ItemLike)ItemRegistry.HEALING_HERBS.get()), has((ItemLike)ItemRegistry.HEALING_HERBS.get()))
/* 452 */       .save(output);
/*     */     
/* 454 */     nbt = new CompoundTag();
/* 455 */     nbt.putString("Potion", "minecraft:water");
/* 456 */     smelting(output, partialNbtIngredient((ItemLike)Items.POTION, nbt), (ItemLike)ItemRegistry.PURIFIED_WATER_BOTTLE.get(), 1.0F, 200, "purified_water_bottle");
/* 457 */     blasting(output, partialNbtIngredient((ItemLike)Items.POTION, nbt), (ItemLike)ItemRegistry.PURIFIED_WATER_BOTTLE.get(), 1.0F, 60, "purified_water_bottle");
/*     */     
/* 459 */     nbt = new CompoundTag();
/* 460 */     nbt.putString("legendarysurvivaloverhaul:HydrationPurity", HydrationEnum.NORMAL.getName());
/* 461 */     purification_smelting(output, partialNbtIngredient((ItemLike)ItemRegistry.CANTEEN.get(), nbt), (ItemLike)ItemRegistry.CANTEEN.get(), 1.0F, 240, "purified_canteen");
/* 462 */     purification_smelting(output, partialNbtIngredient((ItemLike)ItemRegistry.LARGE_CANTEEN.get(), nbt), (ItemLike)ItemRegistry.LARGE_CANTEEN.get(), 1.0F, 240, "purified_large_canteen");
/* 463 */     purification_blasting(output, partialNbtIngredient((ItemLike)ItemRegistry.CANTEEN.get(), nbt), (ItemLike)ItemRegistry.CANTEEN.get(), 1.0F, 80, "purified_canteen");
/* 464 */     purification_blasting(output, partialNbtIngredient((ItemLike)ItemRegistry.LARGE_CANTEEN.get(), nbt), (ItemLike)ItemRegistry.LARGE_CANTEEN.get(), 1.0F, 80, "purified_large_canteen");
/*     */     
/* 466 */     sewing(output, Ingredient.of(new ItemLike[] { (ItemLike)Items.STRING }, ), Ingredient.of(new ItemLike[] { (ItemLike)ItemRegistry.ICE_FERN.get() }, ), new ItemStack((ItemLike)ItemRegistry.COLD_STRING.get()), "cold_string");
/* 467 */     sewing(output, Ingredient.of(new ItemLike[] { (ItemLike)Items.STRING }, ), Ingredient.of(new ItemLike[] { (ItemLike)ItemRegistry.SUN_FERN.get() }, ), new ItemStack((ItemLike)ItemRegistry.WARM_STRING.get()), "warm_string");
/*     */     
/* 469 */     SpecialRecipeBuilder.special(sfiomn.legendarysurvivaloverhaul.common.recipe.RemoveCoatRecipe::new)
/* 470 */       .save(output, "legendarysurvivaloverhaul:remove_coat");
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\providers\ModRecipeProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */