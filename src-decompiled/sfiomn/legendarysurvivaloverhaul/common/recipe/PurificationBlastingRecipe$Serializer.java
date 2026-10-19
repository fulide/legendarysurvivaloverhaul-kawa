/*     */ package sfiomn.legendarysurvivaloverhaul.common.recipe;
/*     */ 
/*     */ import com.mojang.datafixers.kinds.App;
/*     */ import com.mojang.datafixers.kinds.Applicative;
/*     */ import com.mojang.datafixers.util.Function6;
/*     */ import com.mojang.serialization.Codec;
/*     */ import com.mojang.serialization.MapCodec;
/*     */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*     */ import net.minecraft.network.RegistryFriendlyByteBuf;
/*     */ import net.minecraft.network.codec.ByteBufCodecs;
/*     */ import net.minecraft.network.codec.StreamCodec;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.crafting.AbstractCookingRecipe;
/*     */ import net.minecraft.world.item.crafting.CookingBookCategory;
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
/*     */ public class Serializer
/*     */   implements RecipeSerializer<PurificationBlastingRecipe>
/*     */ {
/*  85 */   public static final Serializer INSTANCE = new Serializer(100); static {
/*  86 */     STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, AbstractCookingRecipe::getGroup, 
/*     */         
/*  88 */         ByteBufCodecs.fromCodec((Codec)CookingBookCategory.CODEC), AbstractCookingRecipe::category, Ingredient.CONTENTS_STREAM_CODEC, r -> PurificationBlastingRecipe.access$700(r), ItemStack.STREAM_CODEC, r -> PurificationBlastingRecipe.access$600(r), ByteBufCodecs.FLOAT, r -> Float.valueOf(PurificationBlastingRecipe.access$500(r)), ByteBufCodecs.VAR_INT, r -> Integer.valueOf(PurificationBlastingRecipe.access$400(r)), PurificationBlastingRecipe::new);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final StreamCodec<RegistryFriendlyByteBuf, PurificationBlastingRecipe> STREAM_CODEC;
/*     */   
/*     */   private final int defaultCookingTime;
/*     */ 
/*     */   
/*     */   public Serializer(int cookingTime) {
/*  99 */     this.defaultCookingTime = cookingTime;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MapCodec<PurificationBlastingRecipe> codec() {
/* 105 */     return RecordCodecBuilder.mapCodec(instance -> instance.group((App)Codec.STRING.optionalFieldOf("group", "").forGetter(AbstractCookingRecipe::getGroup), (App)CookingBookCategory.CODEC.optionalFieldOf("category", CookingBookCategory.MISC).forGetter(AbstractCookingRecipe::category), (App)Ingredient.CODEC.fieldOf("ingredient").forGetter(()), (App)ItemStack.CODEC.fieldOf("result").forGetter(()), (App)Codec.FLOAT.optionalFieldOf("experience", Float.valueOf(0.0F)).forGetter(()), (App)Codec.INT.optionalFieldOf("cookingtime", Integer.valueOf(this.defaultCookingTime)).forGetter(())).apply((Applicative)instance, ()));
/*     */   }
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
/*     */   public StreamCodec<RegistryFriendlyByteBuf, PurificationBlastingRecipe> streamCodec() {
/* 118 */     return STREAM_CODEC;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\recipe\PurificationBlastingRecipe$Serializer.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */