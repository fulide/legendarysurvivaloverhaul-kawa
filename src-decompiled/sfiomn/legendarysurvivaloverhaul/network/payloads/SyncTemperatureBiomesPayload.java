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
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonTemperatureBiomeOverride;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.listeners.TemperatureBiomeListener;
/*    */ 
/*    */ public final class SyncTemperatureBiomesPayload extends Record implements CustomPacketPayload {
/*    */   private final Map<ResourceLocation, JsonTemperatureBiomeOverride> temperatureBiomes;
/*    */   
/* 17 */   public SyncTemperatureBiomesPayload(Map<ResourceLocation, JsonTemperatureBiomeOverride> temperatureBiomes) { this.temperatureBiomes = temperatureBiomes; } public Map<ResourceLocation, JsonTemperatureBiomeOverride> temperatureBiomes() { return this.temperatureBiomes; } public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBiomesPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBiomesPayload;
/*    */   } public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBiomesPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBiomesPayload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBiomesPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncTemperatureBiomesPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/* 23 */   } public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sync_temperature_biomes");
/* 24 */   public static final CustomPacketPayload.Type<SyncTemperatureBiomesPayload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 27 */   public static final StreamCodec<RegistryFriendlyByteBuf, SyncTemperatureBiomesPayload> STREAM_CODEC = StreamCodec.composite(
/* 28 */       ByteBufCodecs.map(java.util.HashMap::new, ResourceLocation.STREAM_CODEC, 
/*    */ 
/*    */         
/* 31 */         ByteBufCodecs.fromCodecTrusted(JsonTemperatureBiomeOverride.CODEC)), SyncTemperatureBiomesPayload::temperatureBiomes, SyncTemperatureBiomesPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(SyncTemperatureBiomesPayload pkt, IPayloadContext ctx) {
/* 39 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 40 */       return;  ctx.enqueueWork(() -> TemperatureBiomeListener.acceptServerTemperatureBiomes(pkt.temperatureBiomes()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToServer(Map<ResourceLocation, JsonTemperatureBiomeOverride> data) {
/* 45 */     PacketDistributor.sendToServer(new SyncTemperatureBiomesPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, Map<ResourceLocation, JsonTemperatureBiomeOverride> data) {
/* 50 */     PacketDistributor.sendToPlayer(player, new SyncTemperatureBiomesPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToAll(Map<ResourceLocation, JsonTemperatureBiomeOverride> data) {
/* 56 */     PacketDistributor.sendToAllPlayers(new SyncTemperatureBiomesPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 62 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\SyncTemperatureBiomesPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */