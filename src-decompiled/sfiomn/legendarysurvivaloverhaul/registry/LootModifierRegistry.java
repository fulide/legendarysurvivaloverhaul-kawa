/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import com.mojang.serialization.MapCodec;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import net.neoforged.neoforge.registries.NeoForgeRegistries;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.loot_modifiers.AdditionalLootTable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LootModifierRegistry
/*    */ {
/* 17 */   public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, "legendarysurvivaloverhaul");
/*    */   
/* 19 */   public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AdditionalLootTable>> ADDITIONAL_LOOT_TABLE_MODIFIER = LOOT_MODIFIERS.register("additional_loot_table", AdditionalLootTable.CODEC);
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 23 */     LOOT_MODIFIERS.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\LootModifierRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */