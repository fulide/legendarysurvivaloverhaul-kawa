/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.core.Registry;
/*    */ import net.minecraft.resources.ResourceKey;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import net.neoforged.neoforge.registries.RegistryBuilder;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.AttributeModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.DynamicModifierBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.ModifierBase;
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
/*    */ public class TemperatureModifierRegistry
/*    */ {
/* 26 */   public static final ResourceKey<Registry<ModifierBase>> MODIFIERS_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "temperature_modifiers"));
/*    */   
/* 28 */   public static final ResourceKey<Registry<DynamicModifierBase>> DYNAMIC_MODIFIERS_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "dynamic_temperature_modifiers"));
/*    */   
/* 30 */   public static final ResourceKey<Registry<AttributeModifierBase>> ITEM_ATTRIBUTE_MODIFIERS_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "item_attribute_temperature_modifiers"));
/*    */ 
/*    */   
/* 33 */   public static final DeferredRegister<ModifierBase> MODIFIERS = DeferredRegister.create(MODIFIERS_KEY, "legendarysurvivaloverhaul");
/*    */   
/* 35 */   public static final DeferredHolder<ModifierBase, ModifierBase> ALTITUDE = MODIFIERS.register("altitude", sfiomn.legendarysurvivaloverhaul.common.temperature.AltitudeModifier::new);
/* 36 */   public static final DeferredHolder<ModifierBase, ModifierBase> ATTRIBUTE = MODIFIERS.register("attribute", sfiomn.legendarysurvivaloverhaul.common.temperature.AttributeModifier::new);
/* 37 */   public static final DeferredHolder<ModifierBase, ModifierBase> BIOME = MODIFIERS.register("biome", sfiomn.legendarysurvivaloverhaul.common.temperature.BiomeModifier::new);
/* 38 */   public static final DeferredHolder<ModifierBase, ModifierBase> BLOCKS = MODIFIERS.register("blocks", sfiomn.legendarysurvivaloverhaul.common.temperature.BlockModifier::new);
/* 39 */   public static final DeferredHolder<ModifierBase, ModifierBase> DIMENSION = MODIFIERS.register("dimension", sfiomn.legendarysurvivaloverhaul.common.temperature.DimensionModifier::new);
/* 40 */   public static final DeferredHolder<ModifierBase, ModifierBase> MOUNT = MODIFIERS.register("mount", sfiomn.legendarysurvivaloverhaul.common.temperature.MountModifier::new);
/* 41 */   public static final DeferredHolder<ModifierBase, ModifierBase> FREEZE = MODIFIERS.register("freeze", sfiomn.legendarysurvivaloverhaul.common.temperature.FreezeModifier::new);
/* 42 */   public static final DeferredHolder<ModifierBase, ModifierBase> ON_FIRE = MODIFIERS.register("on_fire", sfiomn.legendarysurvivaloverhaul.common.temperature.OnFireModifier::new);
/* 43 */   public static final DeferredHolder<ModifierBase, ModifierBase> PLAYER_HUDDLING = MODIFIERS.register("player_huddling", sfiomn.legendarysurvivaloverhaul.common.temperature.PlayerHuddlingModifier::new);
/* 44 */   public static final DeferredHolder<ModifierBase, ModifierBase> SPRINT = MODIFIERS.register("sprint", sfiomn.legendarysurvivaloverhaul.common.temperature.SprintModifier::new);
/* 45 */   public static final DeferredHolder<ModifierBase, ModifierBase> TIME = MODIFIERS.register("time", sfiomn.legendarysurvivaloverhaul.common.temperature.TimeModifier::new);
/* 46 */   public static final DeferredHolder<ModifierBase, ModifierBase> WEATHER = MODIFIERS.register("weather", sfiomn.legendarysurvivaloverhaul.common.temperature.WeatherModifier::new);
/* 47 */   public static final DeferredHolder<ModifierBase, ModifierBase> WETNESS = MODIFIERS.register("wetness", sfiomn.legendarysurvivaloverhaul.common.temperature.WetModifier::new);
/*    */   
/* 49 */   public static final DeferredHolder<ModifierBase, ModifierBase> SERENE_SEASONS = MODIFIERS.register("integration/serene_seasons", sfiomn.legendarysurvivaloverhaul.common.integration.sereneseasons.SereneSeasonsModifier::new);
/* 50 */   public static final DeferredHolder<ModifierBase, ModifierBase> ECLIPTIC_SEASONS = MODIFIERS.register("integration/ecliptic_seasons", sfiomn.legendarysurvivaloverhaul.common.integration.eclipticseasons.EclipticSeasonsModifier::new);
/* 51 */   public static final DeferredHolder<ModifierBase, ModifierBase> WORLD_TEMPERATURE_TERRA_FIRMA_CRAFT = MODIFIERS.register("integration/world_temp_tfc", sfiomn.legendarysurvivaloverhaul.common.integration.terrafirmacraft.TerraFirmaCraftModifier::new);
/*    */   
/* 53 */   public static final DeferredRegister<DynamicModifierBase> DYNAMIC_MODIFIERS = DeferredRegister.create(DYNAMIC_MODIFIERS_KEY, "legendarysurvivaloverhaul");
/* 54 */   public static final DeferredHolder<DynamicModifierBase, DynamicModifierBase> TEMPERATURE_RESISTANCE = DYNAMIC_MODIFIERS.register("temperature_resistance", sfiomn.legendarysurvivaloverhaul.common.temperature.dynamic.TemperatureResistanceModifier::new);
/* 55 */   public static final DeferredHolder<DynamicModifierBase, DynamicModifierBase> MOUNT_DYNAMIC = DYNAMIC_MODIFIERS.register("mount_dynamic", sfiomn.legendarysurvivaloverhaul.common.temperature.dynamic.MountDynamicModifier::new);
/*    */   
/* 57 */   public static final DeferredRegister<AttributeModifierBase> ITEM_ATTRIBUTE_MODIFIERS = DeferredRegister.create(ITEM_ATTRIBUTE_MODIFIERS_KEY, "legendarysurvivaloverhaul");
/* 58 */   public static final DeferredHolder<AttributeModifierBase, AttributeModifierBase> ITEM_ATTRIBUTE = ITEM_ATTRIBUTE_MODIFIERS.register("item_attribute", sfiomn.legendarysurvivaloverhaul.common.temperature.attribute.ItemAttributeModifier::new);
/* 59 */   public static final DeferredHolder<AttributeModifierBase, AttributeModifierBase> COAT_ATTRIBUTE = ITEM_ATTRIBUTE_MODIFIERS.register("coat_attribute", sfiomn.legendarysurvivaloverhaul.common.temperature.attribute.CoatAttributeModifier::new);
/* 60 */   public static final DeferredHolder<AttributeModifierBase, AttributeModifierBase> ITEM_TEMPERATURE_TERRA_FIRMA_CRAFT = ITEM_ATTRIBUTE_MODIFIERS.register("integration/item_temp_tfc", sfiomn.legendarysurvivaloverhaul.common.integration.terrafirmacraft.TerraFirmaCraftHeatItemModifier::new);
/*    */ 
/*    */   
/*    */   static {
/* 64 */     MODIFIERS.makeRegistry(b -> {
/*    */         
/* 66 */         }); DYNAMIC_MODIFIERS.makeRegistry(b -> {
/*    */         
/* 68 */         }); ITEM_ATTRIBUTE_MODIFIERS.makeRegistry(b -> {
/*    */         
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 77 */     MODIFIERS.register(eventBus);
/* 78 */     DYNAMIC_MODIFIERS.register(eventBus);
/* 79 */     ITEM_ATTRIBUTE_MODIFIERS.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\TemperatureModifierRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */