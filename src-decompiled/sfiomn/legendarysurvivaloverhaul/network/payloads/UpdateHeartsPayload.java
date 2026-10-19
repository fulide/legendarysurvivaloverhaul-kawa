/*    */ package sfiomn.legendarysurvivaloverhaul.network.payloads;
/*    */ 
/*    */ import net.minecraft.nbt.CompoundTag;
/*    */ import net.minecraft.network.codec.StreamCodec;
/*    */ import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraft.server.level.ServerPlayer;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.neoforged.neoforge.network.PacketDistributor;
/*    */ import net.neoforged.neoforge.network.handling.IPayloadContext;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.health.HealthAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ public final class UpdateHeartsPayload extends Record implements CustomPacketPayload {
/*    */   private final CompoundTag compound;
/*    */   
/* 17 */   public UpdateHeartsPayload(CompoundTag compound) { this.compound = compound; } public CompoundTag compound() { return this.compound; } public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/UpdateHeartsPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/UpdateHeartsPayload;
/*    */   } public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/UpdateHeartsPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/UpdateHeartsPayload;
/*    */   } public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lsfiomn/legendarysurvivaloverhaul/network/payloads/UpdateHeartsPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lsfiomn/legendarysurvivaloverhaul/network/payloads/UpdateHeartsPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/* 23 */   } public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath("legendarysurvivaloverhaul", "update_hearts");
/* 24 */   public static final CustomPacketPayload.Type<UpdateHeartsPayload> TYPE = new CustomPacketPayload.Type(ID);
/*    */ 
/*    */   
/* 27 */   public static final StreamCodec<RegistryFriendlyByteBuf, UpdateHeartsPayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.COMPOUND_TAG, UpdateHeartsPayload::compound, UpdateHeartsPayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void handle(UpdateHeartsPayload pkt, IPayloadContext ctx) {
/* 35 */     if (ctx.flow() != PacketFlow.CLIENTBOUND)
/* 36 */       return;  ctx.enqueueWork(() -> {
/*    */           Player player = ctx.player();
/*    */           if (player != null) {
/*    */             HealthAttachment healthAttachment = AttachmentUtil.getHealthAttachment(player);
/*    */             healthAttachment.readNBT(pkt.compound());
/*    */           } 
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendToServer(CompoundTag compound) {
/* 48 */     PacketDistributor.sendToServer(new UpdateHeartsPayload(compound), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(ServerPlayer player, CompoundTag compound) {
/* 53 */     PacketDistributor.sendToPlayer(player, new UpdateHeartsPayload(compound), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToAll(CompoundTag compound) {
/* 58 */     PacketDistributor.sendToAllPlayers(new UpdateHeartsPayload(compound), new CustomPacketPayload[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
/* 64 */     return (CustomPacketPayload.Type)TYPE;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\network\payloads\UpdateHeartsPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */