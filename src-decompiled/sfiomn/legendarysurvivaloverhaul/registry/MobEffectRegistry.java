/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeModifier;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.item.Items;
/*    */ import net.minecraft.world.item.alchemy.Potion;
/*    */ import net.minecraft.world.item.alchemy.PotionBrewing;
/*    */ import net.minecraft.world.item.alchemy.Potions;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.fml.common.EventBusSubscriber;
/*    */ import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.effects.FrostbiteEffect;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.effects.HeatImmunityEffect;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.effects.SimpleAttributeEffect;
/*    */ 
/*    */ @EventBusSubscriber(modid = "legendarysurvivaloverhaul", bus = EventBusSubscriber.Bus.GAME)
/*    */ public class MobEffectRegistry {
/* 26 */   public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, "legendarysurvivaloverhaul");
/* 27 */   public static final DeferredRegister<Potion> TEMPERATURE_POTIONS = DeferredRegister.create(Registries.POTION, "legendarysurvivaloverhaul");
/* 28 */   public static final DeferredRegister<Potion> THIRST_POTIONS = DeferredRegister.create(Registries.POTION, "legendarysurvivaloverhaul");
/*    */   
/* 30 */   public static final DeferredHolder<MobEffect, ThirstEffect> THIRST = EFFECTS.register("thirst", ThirstEffect::new);
/* 31 */   public static final DeferredHolder<Potion, Potion> THIRST_POTION = THIRST_POTIONS.register("thirst", () -> new Potion("thirst", new MobEffectInstance[] { new MobEffectInstance((Holder)THIRST, 3600, 0, false, true, true) }));
/* 32 */   public static final DeferredHolder<Potion, Potion> THIRST_POTION_LONG = THIRST_POTIONS.register("thirst_long", () -> new Potion("thirst_long", new MobEffectInstance[] { new MobEffectInstance((Holder)THIRST, 9600, 0, false, true, true) }));
/* 33 */   public static final DeferredHolder<MobEffect, HydrationFillEffect> HYDRATION_FILL = EFFECTS.register("hydration_fill", HydrationFillEffect::new);
/* 34 */   public static final DeferredHolder<Potion, Potion> HYDRATION_FILL_POTION = THIRST_POTIONS.register("hydration_fill", () -> new Potion("hydration_fill", new MobEffectInstance[] { new MobEffectInstance((Holder)HYDRATION_FILL, 3600, 0, false, true, true) }));
/* 35 */   public static final DeferredHolder<Potion, Potion> HYDRATION_FILL_POTION_LONG = THIRST_POTIONS.register("hydration_fill_long", () -> new Potion("hydration_fill_long", new MobEffectInstance[] { new MobEffectInstance((Holder)HYDRATION_FILL, 9600, 0, false, true, true) }));
/*    */   
/* 37 */   public static final DeferredHolder<MobEffect, MobEffect> HOT_FOOD = EFFECTS.register("hot_food", () -> (new SimpleAttributeEffect(MobEffectCategory.BENEFICIAL, 16714764, 1.0D)).addAttributeModifier((Holder)AttributeRegistry.HEATING_TEMPERATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "hot_food_modifier"), 1.0D, AttributeModifier.Operation.ADD_VALUE));
/* 38 */   public static final DeferredHolder<MobEffect, MobEffect> HOT_DRINk = EFFECTS.register("hot_drink", () -> (new SimpleAttributeEffect(MobEffectCategory.BENEFICIAL, 16714764, 1.0D)).addAttributeModifier((Holder)AttributeRegistry.HEATING_TEMPERATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "hot_drink_modifier"), 1.0D, AttributeModifier.Operation.ADD_VALUE));
/* 39 */   public static final DeferredHolder<MobEffect, MobEffect> COLD_FOOD = EFFECTS.register("cold_food", () -> (new SimpleAttributeEffect(MobEffectCategory.BENEFICIAL, 1166574, -1.0D)).addAttributeModifier((Holder)AttributeRegistry.COOLING_TEMPERATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "cold_food_modifier"), -1.0D, AttributeModifier.Operation.ADD_VALUE));
/* 40 */   public static final DeferredHolder<MobEffect, MobEffect> COLD_DRINK = EFFECTS.register("cold_drink", () -> (new SimpleAttributeEffect(MobEffectCategory.BENEFICIAL, 1166574, -1.0D)).addAttributeModifier((Holder)AttributeRegistry.COOLING_TEMPERATURE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "cold_drink_modifier"), -1.0D, AttributeModifier.Operation.ADD_VALUE));
/* 41 */   public static final DeferredHolder<MobEffect, MobEffect> HEAT_RESISTANCE = EFFECTS.register("heat_resistance", () -> (new SimpleAttributeEffect(MobEffectCategory.BENEFICIAL, 16420407, 1.0D)).addAttributeModifier((Holder)AttributeRegistry.HEAT_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "heat_resistance_modifier"), 1.0D, AttributeModifier.Operation.ADD_VALUE));
/* 42 */   public static final DeferredHolder<Potion, ? extends Potion> HEAT_RESISTANCE_POTION = TEMPERATURE_POTIONS.register("heat_resistance", () -> new Potion("heat_resistance", new MobEffectInstance[] { new MobEffectInstance((Holder)HEAT_RESISTANCE, 1800, 1, false, true, true) }));
/* 43 */   public static final DeferredHolder<Potion, ? extends Potion> HEAT_RESISTANCE_POTION_LONG = TEMPERATURE_POTIONS.register("heat_resistance_long", () -> new Potion("heat_resistance_long", new MobEffectInstance[] { new MobEffectInstance((Holder)HEAT_RESISTANCE, 2400, 1, false, true, true) }));
/* 44 */   public static final DeferredHolder<MobEffect, MobEffect> COLD_RESISTANCE = EFFECTS.register("cold_resistance", () -> (new SimpleAttributeEffect(MobEffectCategory.BENEFICIAL, 6466303, 1.0D)).addAttributeModifier((Holder)AttributeRegistry.COLD_RESISTANCE, ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "cold_resistance_modifier"), 1.0D, AttributeModifier.Operation.ADD_VALUE));
/* 45 */   public static final DeferredHolder<Potion, ? extends Potion> COLD_RESISTANCE_POTION = TEMPERATURE_POTIONS.register("cold_resistance", () -> new Potion("cold_resistance", new MobEffectInstance[] { new MobEffectInstance((Holder)COLD_RESISTANCE, 1800, 1, false, true, true) }));
/* 46 */   public static final DeferredHolder<Potion, ? extends Potion> COLD_RESISTANCE_POTION_LONG = TEMPERATURE_POTIONS.register("cold_resistance_long", () -> new Potion("cold_resistance_long", new MobEffectInstance[] { new MobEffectInstance((Holder)COLD_RESISTANCE, 2400, 1, false, true, true) }));
/* 47 */   public static final DeferredHolder<MobEffect, FrostbiteEffect> FROSTBITE = EFFECTS.register("frostbite", FrostbiteEffect::new);
/* 48 */   public static final DeferredHolder<MobEffect, ColdHungerEffect> COLD_HUNGER = EFFECTS.register("cold_hunger", ColdHungerEffect::new);
/* 49 */   public static final DeferredHolder<MobEffect, HeatStrokeEffect> HEAT_STROKE = EFFECTS.register("heat_stroke", HeatStrokeEffect::new);
/* 50 */   public static final DeferredHolder<MobEffect, HeatThirstEffect> HEAT_THIRST = EFFECTS.register("heat_thirst", HeatThirstEffect::new);
/* 51 */   public static final DeferredHolder<MobEffect, ColdImmunityEffect> COLD_IMMUNITY = EFFECTS.register("cold_immunity", ColdImmunityEffect::new);
/* 52 */   public static final DeferredHolder<Potion, ? extends Potion> COLD_IMMUNITY_POTION = TEMPERATURE_POTIONS.register("cold_immunity", () -> new Potion("cold_immunity", new MobEffectInstance[] { new MobEffectInstance((Holder)COLD_IMMUNITY, 1800, 0, false, true, true) }));
/* 53 */   public static final DeferredHolder<Potion, ? extends Potion> COLD_IMMUNITY_POTION_LONG = TEMPERATURE_POTIONS.register("cold_immunity_long", () -> new Potion("cold_immunity_long", new MobEffectInstance[] { new MobEffectInstance((Holder)COLD_IMMUNITY, 2400, 0, false, true, true) }));
/* 54 */   public static final DeferredHolder<MobEffect, HeatImmunityEffect> HEAT_IMMUNITY = EFFECTS.register("heat_immunity", HeatImmunityEffect::new);
/* 55 */   public static final DeferredHolder<Potion, Potion> HEAT_IMMUNITY_POTION = TEMPERATURE_POTIONS.register("heat_immunity", () -> new Potion("heat_immunity", new MobEffectInstance[] { new MobEffectInstance((Holder)HEAT_IMMUNITY, 1800, 0, false, true, true) }));
/* 56 */   public static final DeferredHolder<Potion, ? extends Potion> HEAT_IMMUNITY_POTION_LONG = TEMPERATURE_POTIONS.register("heat_immunity_long", () -> new Potion("heat_immunity_long", new MobEffectInstance[] { new MobEffectInstance((Holder)HEAT_IMMUNITY, 2400, 0, false, true, true) }));
/* 57 */   public static final DeferredHolder<MobEffect, TemperatureImmunityEffect> TEMPERATURE_IMMUNITY = EFFECTS.register("temperature_immunity", TemperatureImmunityEffect::new);
/* 58 */   public static final DeferredHolder<Potion, ? extends Potion> TEMPERATURE_IMMUNITY_POTION = TEMPERATURE_POTIONS.register("temperature_immunity", () -> new Potion("temperature_immunity", new MobEffectInstance[] { new MobEffectInstance((Holder)TEMPERATURE_IMMUNITY, 1800, 0, false, true, true) }));
/* 59 */   public static final DeferredHolder<Potion, ? extends Potion> TEMPERATURE_IMMUNITY_POTION_LONG = TEMPERATURE_POTIONS.register("temperature_immunity_long", () -> new Potion("temperature_immunity_long", new MobEffectInstance[] { new MobEffectInstance((Holder)TEMPERATURE_IMMUNITY, 2400, 0, false, true, true) }));
/*    */   
/* 61 */   public static final DeferredHolder<MobEffect, ? extends MobEffect> PAINKILLER = EFFECTS.register("painkiller", sfiomn.legendarysurvivaloverhaul.common.effects.PainKillerEffect::new);
/* 62 */   public static final DeferredHolder<MobEffect, ? extends MobEffect> PAINKILLER_ADDICTION = EFFECTS.register("painkiller_addiction", sfiomn.legendarysurvivaloverhaul.common.effects.PainkillerAddictionEffect::new);
/*    */   
/* 64 */   public static final DeferredHolder<MobEffect, ? extends MobEffect> HARD_FALLING = EFFECTS.register("hard_falling", sfiomn.legendarysurvivaloverhaul.common.effects.HardFallingEffect::new);
/* 65 */   public static final DeferredHolder<MobEffect, ? extends MobEffect> VULNERABILITY = EFFECTS.register("vulnerability", sfiomn.legendarysurvivaloverhaul.common.effects.VulnerabilityEffect::new);
/* 66 */   public static final DeferredHolder<MobEffect, ? extends MobEffect> HEADACHE = EFFECTS.register("headache", sfiomn.legendarysurvivaloverhaul.common.effects.HeadacheEffect::new);
/* 67 */   public static final DeferredHolder<MobEffect, ? extends MobEffect> RECOVERY = EFFECTS.register("recovery", sfiomn.legendarysurvivaloverhaul.common.effects.RecoveryEffect::new);
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
/* 72 */     PotionBrewing.Builder builder = event.getBuilder();
/*    */     
/* 74 */     builder.addMix(Potions.AWKWARD, (Item)ItemRegistry.SUN_FERN.get(), (Holder)HEAT_RESISTANCE_POTION);
/* 75 */     builder.addMix((Holder)HEAT_RESISTANCE_POTION, Items.REDSTONE, (Holder)HEAT_RESISTANCE_POTION_LONG);
/*    */     
/* 77 */     builder.addMix(Potions.AWKWARD, (Item)ItemRegistry.ICE_FERN.get(), (Holder)COLD_RESISTANCE_POTION);
/* 78 */     builder.addMix((Holder)COLD_RESISTANCE_POTION, Items.REDSTONE, (Holder)COLD_RESISTANCE_POTION_LONG);
/*    */     
/* 80 */     builder.addMix(Potions.AWKWARD, (Item)ItemRegistry.SUN_FERN_GOLD.get(), (Holder)HEAT_IMMUNITY_POTION);
/* 81 */     builder.addMix((Holder)HEAT_IMMUNITY_POTION, Items.REDSTONE, (Holder)HEAT_IMMUNITY_POTION_LONG);
/*    */     
/* 83 */     builder.addMix(Potions.AWKWARD, (Item)ItemRegistry.ICE_FERN_GOLD.get(), (Holder)COLD_IMMUNITY_POTION);
/* 84 */     builder.addMix((Holder)COLD_IMMUNITY_POTION, Items.REDSTONE, (Holder)COLD_IMMUNITY_POTION_LONG);
/*    */     
/* 86 */     builder.addMix((Holder)HEAT_IMMUNITY_POTION, (Item)ItemRegistry.ICE_FERN_GOLD.get(), (Holder)TEMPERATURE_IMMUNITY_POTION);
/* 87 */     builder.addMix((Holder)HEAT_IMMUNITY_POTION_LONG, (Item)ItemRegistry.ICE_FERN_GOLD.get(), (Holder)TEMPERATURE_IMMUNITY_POTION_LONG);
/*    */     
/* 89 */     builder.addMix((Holder)COLD_IMMUNITY_POTION, (Item)ItemRegistry.SUN_FERN_GOLD.get(), (Holder)TEMPERATURE_IMMUNITY_POTION);
/* 90 */     builder.addMix((Holder)COLD_IMMUNITY_POTION_LONG, (Item)ItemRegistry.SUN_FERN_GOLD.get(), (Holder)TEMPERATURE_IMMUNITY_POTION_LONG);
/* 91 */     builder.addMix((Holder)TEMPERATURE_IMMUNITY_POTION, Items.REDSTONE, (Holder)TEMPERATURE_IMMUNITY_POTION_LONG);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 96 */     EFFECTS.register(eventBus);
/* 97 */     TEMPERATURE_POTIONS.register(eventBus);
/* 98 */     THIRST_POTIONS.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\MobEffectRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */