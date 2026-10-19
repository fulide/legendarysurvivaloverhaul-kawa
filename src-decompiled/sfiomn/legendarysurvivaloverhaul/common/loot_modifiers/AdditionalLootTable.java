/*    */ package sfiomn.legendarysurvivaloverhaul.common.loot_modifiers;
/*    */ import com.google.common.base.Suppliers;
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.datafixers.util.Function3;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.MapCodec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import it.unimi.dsi.fastutil.objects.ObjectArrayList;
/*    */ import java.util.Objects;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraft.world.level.storage.loot.LootContext;
/*    */ import net.minecraft.world.level.storage.loot.LootTable;
/*    */ import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
/*    */ import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
/*    */ import net.neoforged.neoforge.common.loot.LootModifier;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ 
/*    */ public class AdditionalLootTable extends LootModifier {
/* 26 */   public static final Supplier<MapCodec<AdditionalLootTable>> CODEC = (Supplier<MapCodec<AdditionalLootTable>>)Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(()));
/*    */ 
/*    */ 
/*    */   
/*    */   private final ResourceLocation lootTable;
/*    */ 
/*    */ 
/*    */   
/*    */   private final boolean replace;
/*    */ 
/*    */ 
/*    */   
/*    */   public AdditionalLootTable(LootItemCondition[] conditions, ResourceLocation lootTable, boolean replace) {
/* 39 */     super(conditions);
/* 40 */     this.lootTable = lootTable;
/* 41 */     this.replace = replace;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
/* 47 */     if (this.replace)
/*    */     {
/* 49 */       generatedLoot.clear();
/*    */     }
/*    */     
/* 52 */     ServerLevel level = context.getLevel();
/* 53 */     ResourceKey<LootTable> lootTableKey = ResourceKey.create(Registries.LOOT_TABLE, this.lootTable);
/* 54 */     context.getResolver().get(Registries.LOOT_TABLE, lootTableKey).ifPresent(table -> {
/*    */           Objects.requireNonNull(generatedLoot);
/*    */           
/*    */           ((LootTable)table.value()).getRandomItemsRaw(context, LootTable.createStackSplitter(level, generatedLoot::add));
/*    */           LegendarySurvivalOverhaul.LOGGER.debug(lootTableKey);
/*    */           LegendarySurvivalOverhaul.LOGGER.debug("gen loot : " + String.valueOf(generatedLoot));
/*    */         });
/* 61 */     return generatedLoot;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MapCodec<? extends IGlobalLootModifier> codec() {
/* 67 */     return (MapCodec<? extends IGlobalLootModifier>)CODEC.get();
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\loot_modifiers\AdditionalLootTable.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */