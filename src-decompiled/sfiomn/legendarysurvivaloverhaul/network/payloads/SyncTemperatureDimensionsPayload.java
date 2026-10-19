/*    */ package sfiomn.legendarysurvivaloverhaul.network.payloads;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.neoforged.neoforge.network.PacketDistributor;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadContext;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureDimension;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureDimensionListener;
/*    */ 
/*    */ public final class SyncTemperatureDimensionsPayload extends Record implements CustomPacketPayload {
/*    */   private final Map<ResourceLocation, JsonTemperatureDimension> temperatureDimensions;
/*    */   
/* 17 */   public SyncTemperatureDimensionsPayload(Map<ResourceLocation, JsonTemperatureDimension> temperatureDimensions) { this.temperatureDimensions = temperatureDimensions; } public Map<ResourceLocation, JsonTemperatureDimension> temperatureDimensions() { return this.temperatureDimensions; } public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureDimensionsPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureDimensionsPayload;
/*    */   } public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureDimensionsPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureDimensionsPayload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureDimensionsPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureDimensionsPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/* 23 */   } public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sync_temperature_dimensions");
/* 24 */   public static final CustomPacketPayload.Type<SyncTemperatureDimensionsPayload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 27 */   public static final StreamCodec<RegistryFriendlyByteBuf, SyncTemperatureDimensionsPayload> STREAM_CODEC = StreamCodec.composite(
/* 28 */       ByteBufCodecs.map(java.util.HashMap::new, ResourceLocation.STREAM_CODEC, 
/*    */ 
/*    */         
/* 31 */         ByteBufCodecs.fromCodecTrusted(JsonTemperatureDimension.CODEC)), SyncTemperatureDimensionsPayload::temperatureDimensions, SyncTemperatureDimensionsPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(SyncTemperatureDimensionsPayload pkt, IPayloadContext ctx) {
/* 40 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 41 */       return;  ctx.enqueueWork(() -> TemperatureDimensionListener.acceptServerTemperatureDimensions(pkt.temperatureDimensions()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToServer(Map<ResourceLocation, JsonTemperatureDimension> data) {
/* 47 */     PacketDistributor.sendToServer(new SyncTemperatureDimensionsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, Map<ResourceLocation, JsonTemperatureDimension> data) {
/* 56 */     PacketDistributor.sendToPlayer(player, new SyncTemperatureDimensionsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToAll(Map<ResourceLocation, JsonTemperatureDimension> data) {
/* 62 */     PacketDistributor.sendToAllPlayers(new SyncTemperatureDimensionsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 68 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\SyncTemperatureDimensionsPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */