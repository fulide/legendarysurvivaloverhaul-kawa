/*    */ package sfiomn.legendarysurvivaloverhaul.network.payloads;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.neoforged.neoforge.network.PacketDistributor;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadContext;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonBodyPartResistance;
/*    */ 
/*    */ public final class SyncBodyPartResistanceItemsPayload extends Record implements CustomPacketPayload {
/*    */   private final Map<ResourceLocation, JsonBodyPartResistance> bodyPartResistanceItems;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncBodyPartResistanceItemsPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncBodyPartResistanceItemsPayload;
/*    */   }
/*    */   
/* 18 */   public SyncBodyPartResistanceItemsPayload(Map<ResourceLocation, JsonBodyPartResistance> bodyPartResistanceItems) { this.bodyPartResistanceItems = bodyPartResistanceItems; } public Map<ResourceLocation, JsonBodyPartResistance> bodyPartResistanceItems() { return this.bodyPartResistanceItems; }
/*    */    public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncBodyPartResistanceItemsPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncBodyPartResistanceItemsPayload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncBodyPartResistanceItemsPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncBodyPartResistanceItemsPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/* 24 */   public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sync_body_part_resistance_items");
/* 25 */   public static final CustomPacketPayload.Type<SyncBodyPartResistanceItemsPayload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 28 */   public static final StreamCodec<RegistryFriendlyByteBuf, SyncBodyPartResistanceItemsPayload> STREAM_CODEC = StreamCodec.composite(
/* 29 */       ByteBufCodecs.map(java.util.HashMap::new, ResourceLocation.STREAM_CODEC, 
/*    */ 
/*    */         
/* 32 */         ByteBufCodecs.fromCodecTrusted(JsonBodyPartResistance.CODEC)), SyncBodyPartResistanceItemsPayload::bodyPartResistanceItems, SyncBodyPartResistanceItemsPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(SyncBodyPartResistanceItemsPayload pkt, IPayloadContext ctx) {
/* 41 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 42 */       return;  ctx.enqueueWork(() -> BodyPartResistanceItemListener.acceptServerBodyPartResistanceItems(pkt.bodyPartResistanceItems()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToServer(Map<ResourceLocation, JsonBodyPartResistance> data) {
/* 48 */     PacketDistributor.sendToServer(new SyncBodyPartResistanceItemsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, Map<ResourceLocation, JsonBodyPartResistance> data) {
/* 57 */     PacketDistributor.sendToPlayer(player, new SyncBodyPartResistanceItemsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToAll(Map<ResourceLocation, JsonBodyPartResistance> data) {
/* 63 */     PacketDistributor.sendToAllPlayers(new SyncBodyPartResistanceItemsPayload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 69 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\SyncBodyPartResistanceItemsPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */