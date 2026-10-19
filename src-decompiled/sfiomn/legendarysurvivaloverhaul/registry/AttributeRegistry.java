/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.world.entity.ai.attributes.RangedAttribute;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttributeRegistry
/*    */ {
/* 15 */   public static DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, "legendarysurvivaloverhaul");
/*    */   
/* 17 */   public static final DeferredHolder<Attribute, ? extends Attribute> HEATING_TEMPERATURE = ATTRIBUTES.register("heating_temperature", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.heating_temperature", 0.0D, -10000.0D, 10000.0D)).setSyncable(true));
/* 18 */   public static final DeferredHolder<Attribute, ? extends Attribute> COOLING_TEMPERATURE = ATTRIBUTES.register("cooling_temperature", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.cooling_temperature", 0.0D, -10000.0D, 10000.0D)).setSyncable(true));
/* 19 */   public static final DeferredHolder<Attribute, ? extends Attribute> HEAT_RESISTANCE = ATTRIBUTES.register("heat_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.heat_resistance", 0.0D, 0.0D, 10000.0D)).setSyncable(true));
/* 20 */   public static final DeferredHolder<Attribute, ? extends Attribute> COLD_RESISTANCE = ATTRIBUTES.register("cold_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.cold_resistance", 0.0D, 0.0D, 10000.0D)).setSyncable(true));
/* 21 */   public static final DeferredHolder<Attribute, ? extends Attribute> THERMAL_RESISTANCE = ATTRIBUTES.register("thermal_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.thermal_resistance", 0.0D, 0.0D, 10000.0D)).setSyncable(true));
/*    */   
/* 23 */   public static final DeferredHolder<Attribute, ? extends Attribute> BODY_RESISTANCE = ATTRIBUTES.register("body_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.body_resistance", 0.0D, -200.0D, 100.0D)).setSyncable(true));
/* 24 */   public static final DeferredHolder<Attribute, ? extends Attribute> HEAD_RESISTANCE = ATTRIBUTES.register("head_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.head_resistance", 0.0D, -200.0D, 100.0D)).setSyncable(true));
/* 25 */   public static final DeferredHolder<Attribute, ? extends Attribute> CHEST_RESISTANCE = ATTRIBUTES.register("chest_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.chest_resistance", 0.0D, -200.0D, 100.0D)).setSyncable(true));
/* 26 */   public static final DeferredHolder<Attribute, ? extends Attribute> RIGHT_ARM_RESISTANCE = ATTRIBUTES.register("right_arm_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.right_arm_resistance", 0.0D, -200.0D, 100.0D)).setSyncable(true));
/* 27 */   public static final DeferredHolder<Attribute, ? extends Attribute> LEFT_ARM_RESISTANCE = ATTRIBUTES.register("left_arm_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.left_arm_resistance", 0.0D, -200.0D, 100.0D)).setSyncable(true));
/* 28 */   public static final DeferredHolder<Attribute, ? extends Attribute> LEGS_RESISTANCE = ATTRIBUTES.register("legs_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.legs_resistance", 0.0D, -200.0D, 100.0D)).setSyncable(true));
/* 29 */   public static final DeferredHolder<Attribute, ? extends Attribute> FEET_RESISTANCE = ATTRIBUTES.register("feet_resistance", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.feet_resistance", 0.0D, -200.0D, 100.0D)).setSyncable(true));
/*    */   
/* 31 */   public static final DeferredHolder<Attribute, ? extends Attribute> BROKEN_HEART = ATTRIBUTES.register("broken_heart", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.broken_heart", 0.0D, 0.0D, 10000.0D)).setSyncable(true));
/* 32 */   public static final DeferredHolder<Attribute, ? extends Attribute> PERMANENT_HEART = ATTRIBUTES.register("permanent_heart", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.permanent_heart", 1.0D, 1.0D, 10000.0D)).setSyncable(true));
/* 33 */   public static final DeferredHolder<Attribute, ? extends Attribute> BROKEN_HEART_RESILIENCE = ATTRIBUTES.register("broken_heart_resilience", () -> (new RangedAttribute("attribute.legendarysurvivaloverhaul.broken_heart_resilience", 1.0D, 0.0D, 10000.0D)).setSyncable(true));
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 37 */     ATTRIBUTES.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\AttributeRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */