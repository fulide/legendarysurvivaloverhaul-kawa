/*     */ package sfiomn.legendarysurvivaloverhaul.common.recipe;
/*     */ 
/*     */ import com.mojang.datafixers.kinds.App;
/*     */ import com.mojang.datafixers.kinds.Applicative;
/*     */ import com.mojang.serialization.MapCodec;
/*     */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.network.RegistryFriendlyByteBuf;
/*     */ import net.minecraft.network.codec.StreamCodec;
/*     */ import net.minecraft.resources.ResourceLocation;
/*     */ import net.minecraft.world.item.crafting.CraftingBookCategory;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Serializer
/*     */   implements RecipeSerializer<RemoveCoatRecipe>
/*     */ {
/* 101 */   public static final Serializer INSTANCE = new Serializer();
/*     */   
/* 103 */   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "remove_coat");
/*     */   static {
/* 105 */     CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(RemoveCoatRecipe::category)).apply((Applicative)instance, RemoveCoatRecipe::new));
/*     */   }
/*     */   
/*     */   private static final MapCodec<RemoveCoatRecipe> CODEC;
/* 109 */   private static final StreamCodec<RegistryFriendlyByteBuf, RemoveCoatRecipe> STREAM_CODEC = StreamCodec.composite(CraftingBookCategory.STREAM_CODEC, RemoveCoatRecipe::category, RemoveCoatRecipe::new);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MapCodec<RemoveCoatRecipe> codec() {
/* 117 */     return CODEC;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StreamCodec<RegistryFriendlyByteBuf, RemoveCoatRecipe> streamCodec() {
/* 123 */     return STREAM_CODEC;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\recipe\RemoveCoatRecipe$Serializer.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */