/*     */ package sfiomn.legendarysurvivaloverhaul.common.recipe;
/*     */ import com.mojang.datafixers.kinds.App;
/*     */ import com.mojang.datafixers.kinds.Applicative;
/*     */ import com.mojang.datafixers.util.Function3;
/*     */ import com.mojang.serialization.MapCodec;
/*     */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.core.component.DataComponents;
/*     */ import net.minecraft.network.RegistryFriendlyByteBuf;
/*     */ import net.minecraft.network.codec.StreamCodec;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.component.CustomData;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraft.world.item.crafting.RecipeInput;
/*     */ import net.minecraft.world.item.crafting.RecipeSerializer;
/*     */ import net.minecraft.world.item.crafting.RecipeType;
/*     */ import net.minecraft.world.level.Level;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ public class SewingRecipe implements Recipe<RecipeInput> {
/*     */   private final Ingredient base;
/*     */   
/*     */   public SewingRecipe(Ingredient base, Ingredient addition, ItemStack result) {
/*  25 */     this.base = base;
/*  26 */     this.addition = addition;
/*  27 */     this.result = result;
/*     */   }
/*     */   private final Ingredient addition; private final ItemStack result;
/*     */   
/*     */   public Ingredient getBase() {
/*  32 */     return this.base;
/*     */   }
/*     */ 
/*     */   
/*     */   public Ingredient getAddition() {
/*  37 */     return this.addition;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(@NotNull RecipeInput input, Level level) {
/*  43 */     if (level.isClientSide) return false; 
/*  44 */     return (this.base.test(input.getItem(0)) && this.addition
/*  45 */       .test(input.getItem(1)));
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public ItemStack assemble(@NotNull RecipeInput input, @NotNull HolderLookup.Provider provider) {
/*  51 */     ItemStack itemstack = this.result.copy();
/*  52 */     ItemStack base = input.getItem(0);
/*  53 */     CustomData custom = (CustomData)base.get(DataComponents.CUSTOM_DATA);
/*  54 */     if (custom != null)
/*     */     {
/*  56 */       itemstack.set(DataComponents.CUSTOM_DATA, CustomData.of(custom.copyTag()));
/*     */     }
/*  58 */     return itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canCraftInDimensions(int i, int i1) {
/*  64 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @NotNull
/*     */   public ItemStack getResultItem(@NotNull HolderLookup.Provider provider) {
/*  70 */     return this.result.copy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RecipeSerializer<?> getSerializer() {
/*  76 */     return Serializer.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RecipeType<?> getType() {
/*  82 */     return Type.INSTANCE;
/*     */   }
/*     */   
/*     */   public static class Type
/*     */     implements RecipeType<SewingRecipe> {
/*  87 */     public static final Type INSTANCE = new Type();
/*     */     
/*  89 */     public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sewing");
/*     */   }
/*     */   
/*     */   public static class Serializer
/*     */     implements RecipeSerializer<SewingRecipe> {
/*  94 */     public static final Serializer INSTANCE = new Serializer();
/*     */     
/*  96 */     public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sewing"); private static final MapCodec<SewingRecipe> CODEC; private static final StreamCodec<RegistryFriendlyByteBuf, SewingRecipe> STREAM_CODEC;
/*     */     static {
/*  98 */       CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)Ingredient.CODEC.fieldOf("base").forGetter(SewingRecipe::getBase), (App)Ingredient.CODEC.fieldOf("addition").forGetter(SewingRecipe::getAddition), (App)ItemStack.CODEC.fieldOf("result").forGetter(())).apply((Applicative)instance, SewingRecipe::new));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 104 */       STREAM_CODEC = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, r -> r.base, Ingredient.CONTENTS_STREAM_CODEC, r -> r.addition, ItemStack.STREAM_CODEC, r -> r.result, SewingRecipe::new);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MapCodec<SewingRecipe> codec() {
/* 114 */       return CODEC;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public StreamCodec<RegistryFriendlyByteBuf, SewingRecipe> streamCodec() {
/* 120 */       return STREAM_CODEC;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\recipe\SewingRecipe.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */