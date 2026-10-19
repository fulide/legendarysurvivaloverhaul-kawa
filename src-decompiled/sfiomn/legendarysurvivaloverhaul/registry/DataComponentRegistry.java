/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ 
/*    */ import com.mojang.datafixers.kinds.App;
/*    */ import com.mojang.datafixers.kinds.Applicative;
/*    */ import com.mojang.serialization.Codec;
/*    */ import com.mojang.serialization.codecs.RecordCodecBuilder;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.function.BiFunction;
/*    */ import net.minecraft.core.component.DataComponentType;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureEnum;
/*    */ 
/*    */ public class DataComponentRegistry
/*    */ {
/* 20 */   public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, "legendarysurvivaloverhaul");
/*    */ 
/*    */   
/* 23 */   public static final DeferredHolder<DataComponentType<?>, DataComponentType<TemperatureData>> TEMPERATURE_DATA = DATA_COMPONENTS
/* 24 */     .register("temperature_data", () -> DataComponentType.builder().persistent(TemperatureData.CODEC).networkSynchronized(TemperatureData.STREAM_CODEC).build());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void init(IEventBus modBus) {
/* 31 */     DATA_COMPONENTS.register(modBus);
/*    */   } public static final class TemperatureData extends Record {
/*    */     private final float temperature; private final long updateTick; public static final Codec<TemperatureData> CODEC; public final String toString() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/registry/DataComponentRegistry$TemperatureData;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #37	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/registry/DataComponentRegistry$TemperatureData;
/*    */     } public final int hashCode() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/registry/DataComponentRegistry$TemperatureData;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #37	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/registry/DataComponentRegistry$TemperatureData;
/* 37 */     } public TemperatureData(float temperature, long updateTick) { this.temperature = temperature; this.updateTick = updateTick; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/registry/DataComponentRegistry$TemperatureData;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #37	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/registry/DataComponentRegistry$TemperatureData;
/* 37 */       //   0	8	1	o	Ljava/lang/Object; } public float temperature() { return this.temperature; } public long updateTick() { return this.updateTick; }
/*    */     
/*    */     static {
/* 40 */       CODEC = RecordCodecBuilder.create(instance -> instance.group((App)Codec.FLOAT.fieldOf("temperature").forGetter(TemperatureData::temperature), (App)Codec.LONG.optionalFieldOf("updateTick", Long.valueOf(0L)).forGetter(TemperatureData::updateTick)).apply((Applicative)instance, TemperatureData::new));
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 47 */     public static final StreamCodec<ByteBuf, TemperatureData> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.FLOAT, TemperatureData::temperature, ByteBufCodecs.VAR_LONG, TemperatureData::updateTick, TemperatureData::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public TemperatureData() {
/* 55 */       this(TemperatureEnum.NORMAL.getValue(), 0L);
/*    */     }
/*    */ 
/*    */     
/*    */     public TemperatureData withTemperature(float newTemperature) {
/* 60 */       return new TemperatureData(newTemperature, this.updateTick);
/*    */     }
/*    */ 
/*    */     
/*    */     public TemperatureData withUpdateTick(long newUpdateTick) {
/* 65 */       return new TemperatureData(this.temperature, newUpdateTick);
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean shouldUpdate(long currentTick) {
/* 70 */       return (currentTick - this.updateTick > 10L);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\DataComponentRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */