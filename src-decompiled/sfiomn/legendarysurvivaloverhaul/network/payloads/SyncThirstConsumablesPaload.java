/*    */ package sfiomn.legendarysurvivaloverhaul.network.payloads;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.network.codec.ByteBufCodecs;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.neoforged.neoforge.network.PacketDistributor;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadContext;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.data.json.JsonThirstConsumable;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.listeners.ThirstConsumableListener;
/*    */ 
/*    */ public final class SyncThirstConsumablesPaload extends Record implements CustomPacketPayload {
/*    */   private final Map<ResourceLocation, List<JsonThirstConsumable>> thirstConsumables;
/*    */   
/* 18 */   public SyncThirstConsumablesPaload(Map<ResourceLocation, List<JsonThirstConsumable>> thirstConsumables) { this.thirstConsumables = thirstConsumables; } public Map<ResourceLocation, List<JsonThirstConsumable>> thirstConsumables() { return this.thirstConsumables; } public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstConsumablesPaload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstConsumablesPaload;
/*    */   } public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstConsumablesPaload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstConsumablesPaload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstConsumablesPaload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #18	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/SyncThirstConsumablesPaload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/* 24 */   } public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "sync_thirst_consumables");
/*    */   
/* 26 */   public static final CustomPacketPayload.Type<SyncThirstConsumablesPaload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 29 */   public static final StreamCodec<RegistryFriendlyByteBuf, SyncThirstConsumablesPaload> STREAM_CODEC = StreamCodec.composite(
/* 30 */       ByteBufCodecs.map(java.util.HashMap::new, ResourceLocation.STREAM_CODEC, 
/*    */ 
/*    */         
/* 33 */         ByteBufCodecs.fromCodecTrusted(JsonThirstConsumable.LIST_CODEC)), SyncThirstConsumablesPaload::thirstConsumables, SyncThirstConsumablesPaload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(SyncThirstConsumablesPaload pkt, IPayloadContext ctx) {
/* 42 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 43 */       return;  ctx.enqueueWork(() -> ThirstConsumableListener.acceptServerThirstConsumables(pkt.thirstConsumables()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToServer(Map<ResourceLocation, List<JsonThirstConsumable>> data) {
/* 49 */     PacketDistributor.sendToServer(new SyncThirstConsumablesPaload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, Map<ResourceLocation, List<JsonThirstConsumable>> data) {
/* 58 */     PacketDistributor.sendToPlayer(player, new SyncThirstConsumablesPaload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToAll(Map<ResourceLocation, List<JsonThirstConsumable>> data) {
/* 64 */     PacketDistributor.sendToAllPlayers(new SyncThirstConsumablesPaload(data), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 70 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\SyncThirstConsumablesPaload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */