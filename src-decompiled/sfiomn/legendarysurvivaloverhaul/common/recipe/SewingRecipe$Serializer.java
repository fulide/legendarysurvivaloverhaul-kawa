/*     */ package sfiomn.legendarysurvivaloverhaul.common.recipe;
/*     */ 
/*     */ import com.mojang.datafixers.kinds.App;
/*     */ import com.mojang.datafixers.kinds.Applicative;
/*     */ import com.mojang.datafixers.util.Function3;
/*     */ import com.mojang.serialization.MapCodec;
/*     */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*     */ import net.minecraft.network.RegistryFriendlyByteBuf;
/*     */ import net.minecraft.network.codec.StreamCodec;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.crafting.Ingredient;
/*     */ import net.minecraft.world.item.crafting.RecipeSerializer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Serializer
/*     */   implements RecipeSerializer<SewingRecipe>
/*     */ {
/*  94 */   public static final Serializer INSTANCE = new Serializer();
/*     */   
/*  96 */   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sewing");
/*     */   static {
/*  98 */     CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)Ingredient.CODEC.fieldOf("base").forGetter(SewingRecipe::getBase), (App)Ingredient.CODEC.fieldOf("addition").forGetter(SewingRecipe::getAddition), (App)ItemStack.CODEC.fieldOf("result").forGetter(())).apply((Applicative)instance, SewingRecipe::new));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     STREAM_CODEC = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC, r -> r.base, Ingredient.CONTENTS_STREAM_CODEC, r -> r.addition, ItemStack.STREAM_CODEC, r -> r.result, SewingRecipe::new);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final MapCodec<SewingRecipe> CODEC;
/*     */   
/*     */   private static final StreamCodec<RegistryFriendlyByteBuf, SewingRecipe> STREAM_CODEC;
/*     */ 
/*     */   
/*     */   public MapCodec<SewingRecipe> codec() {
/* 114 */     return CODEC;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StreamCodec<RegistryFriendlyByteBuf, SewingRecipe> streamCodec() {
/* 120 */     return STREAM_CODEC;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\recipe\SewingRecipe$Serializer.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */