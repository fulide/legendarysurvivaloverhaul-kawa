/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.sounds.SoundEvent;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SoundRegistry
/*    */ {
/* 15 */   public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, "legendarysurvivaloverhaul");
/*    */   
/* 17 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> HEAT_STROKE_EARLY = registerSoundEvent("heat_stroke_early");
/* 18 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> HEAT_STROKE = registerSoundEvent("heat_stroke");
/* 19 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> PANTING = registerSoundEvent("panting");
/* 20 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> FROSTBITE_EARLY = registerSoundEvent("frostbite_early");
/* 21 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> FROSTBITE = registerSoundEvent("frostbite");
/* 22 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> SHIVERING = registerSoundEvent("shivering");
/* 23 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> SEWING_TABLE = registerSoundEvent("sewing_table");
/* 24 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> COOLER_BLOCK = registerSoundEvent("cooler_block");
/*    */   
/* 26 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> SELF_WATERING = registerSoundEvent("self_watering");
/*    */   
/* 28 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> HEADSHOT = registerSoundEvent("headshot");
/* 29 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> HEAL_BODY_PART = registerSoundEvent("heal_body_part");
/* 30 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> HARD_FALLING_HURT = registerSoundEvent("hard_falling_hurt");
/* 31 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> HEADACHE_HEARTBEAT = registerSoundEvent("headache_heartbeat");
/*    */   
/* 33 */   public static final DeferredHolder<SoundEvent, ? extends SoundEvent> HEART_CONTAINER = registerSoundEvent("heart_container");
/*    */ 
/*    */   
/*    */   private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
/* 37 */     return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", name)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 44 */     SOUND_EVENTS.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\SoundRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */