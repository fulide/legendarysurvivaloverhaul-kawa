/*    */ package sfiomn.legendarysurvivaloverhaul.common.attachments;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.attachment.AttachmentType;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import net.neoforged.neoforge.registries.NeoForgeRegistries;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.bodydamage.BodyDamageAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.food.FoodAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.health.HealthAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.wetness.WetnessAttachment;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ModAttachments
/*    */ {
/* 20 */   public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, "legendarysurvivaloverhaul");
/* 21 */   public static final Supplier<AttachmentType<TemperatureAttachment>> TEMPERATURE = (Supplier<AttachmentType<TemperatureAttachment>>)ATTACHMENTS.register("temperature", () -> AttachmentType.serializable(TemperatureAttachment::new).copyOnDeath().build());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 27 */   public static final Supplier<AttachmentType<WetnessAttachment>> WETNESS = (Supplier<AttachmentType<WetnessAttachment>>)ATTACHMENTS.register("wetness", () -> AttachmentType.serializable(WetnessAttachment::new).copyOnDeath().build());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   public static final Supplier<AttachmentType<ThirstAttachment>> THIRST = (Supplier<AttachmentType<ThirstAttachment>>)ATTACHMENTS.register("thirst", () -> AttachmentType.serializable(ThirstAttachment::new).copyOnDeath().build());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 39 */   public static final Supplier<AttachmentType<HealthAttachment>> HEALTH = (Supplier<AttachmentType<HealthAttachment>>)ATTACHMENTS.register("health", () -> AttachmentType.serializable(HealthAttachment::new).copyOnDeath().build());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 46 */   public static final Supplier<AttachmentType<FoodAttachment>> FOOD = (Supplier<AttachmentType<FoodAttachment>>)ATTACHMENTS.register("food", () -> AttachmentType.builder(FoodAttachment::new).build());
/*    */ 
/*    */ 
/*    */   
/* 50 */   public static final Supplier<AttachmentType<BodyDamageAttachment>> BODY_DAMAGE = (Supplier<AttachmentType<BodyDamageAttachment>>)ATTACHMENTS.register("body_damage", () -> AttachmentType.serializable(BodyDamageAttachment::new).copyOnDeath().build());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void init(IEventBus modBus) {
/* 66 */     ATTACHMENTS.register(modBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\attachments\ModAttachments.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */