/*    */ package sfiomn.legendarysurvivaloverhaul.network.payloads;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.neoforged.neoforge.network.PacketDistributor;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadContext;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureResistance;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureOriginListener;
/*    */ 
/*    */ public final class SyncTemperatureOriginsPayload extends Record implements CustomPacketPayload {
/*    */   private final Map<ResourceLocation, JsonTemperatureResistance> temperatureOrigins;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureOriginsPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureOriginsPayload;
/*    */   }
/*    */   
/* 18 */   public SyncTemperatureOriginsPayload(Map<ResourceLocation, JsonTemperatureResistance> temperatureOrigins) { this.temperatureOrigins = temperatureOrigins; } public Map<ResourceLocation, JsonTemperatureResistance> temperatureOrigins() { return this.temperatureOrigins; }
/*    */    public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureOriginsPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureOriginsPayload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureOriginsPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureOriginsPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/* 24 */   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sync_temperature_origins");
/*    */   
/* 26 */   public static final CustomPacketPayload.Type<SyncTemperatureOriginsPayload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 29 */   public static final StreamCodec<RegistryFriendlyByteBuf, SyncTemperatureOriginsPayload> STREAM_CODEC = StreamCodec.composite(
/* 30 */       ByteBufCodecs.map(java.util.HashMap::new, ResourceLocation.STREAM_CODEC, 
/*    */ 
/*    */         
/* 33 */         ByteBufCodecs.fromCodecTrusted(JsonTemperatureResistance.CODEC)), SyncTemperatureOriginsPayload::temperatureOrigins, SyncTemperatureOriginsPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(SyncTemperatureOriginsPayload pkt, IPayloadContext ctx) {
/* 42 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 43 */       return;  ctx.enqueueWork(() -> TemperatureOriginListener.acceptServerTemperatureOrigins(pkt.temperatureOrigins()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToServer(Map<ResourceLocation, JsonTemperatureResistance> data) {
/* 49 */     PacketDistributor.sendToServer(new SyncTemperatureOriginsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, Map<ResourceLocation, JsonTemperatureResistance> data) {
/* 58 */     PacketDistributor.sendToPlayer(player, new SyncTemperatureOriginsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToAll(Map<ResourceLocation, JsonTemperatureResistance> data) {
/* 64 */     PacketDistributor.sendToAllPlayers(new SyncTemperatureOriginsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 70 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\SyncTemperatureOriginsPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */