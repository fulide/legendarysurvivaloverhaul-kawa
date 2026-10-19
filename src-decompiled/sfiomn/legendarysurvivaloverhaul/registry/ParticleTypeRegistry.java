/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import net.minecraft.core.particles.ParticleType;
/*    */ import net.minecraft.core.particles.SimpleParticleType;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParticleTypeRegistry
/*    */ {
/* 14 */   public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, "legendarysurvivaloverhaul");
/*    */   
/* 16 */   public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SUN_FERN_BLOSSOM = PARTICLE_TYPES.register("sun_fern_blossom", () -> new SimpleParticleType(true));
/* 17 */   public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ICE_FERN_BLOSSOM = PARTICLE_TYPES.register("ice_fern_blossom", () -> new SimpleParticleType(true));
/* 18 */   public static final DeferredHolder<ParticleType<?>, SimpleParticleType> COLD_BREATH = PARTICLE_TYPES.register("cold_breath", () -> new SimpleParticleType(true));
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 22 */     PARTICLE_TYPES.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\ParticleTypeRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */