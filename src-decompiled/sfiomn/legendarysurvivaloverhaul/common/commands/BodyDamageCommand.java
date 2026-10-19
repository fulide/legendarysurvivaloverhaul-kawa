/*     */ package sfiomn.legendarysurvivaloverhaul.common.commands;
/*     */ 
/*     */ import com.mojang.brigadier.arguments.ArgumentType;
/*     */ import com.mojang.brigadier.arguments.FloatArgumentType;
/*     */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*     */ import com.mojang.brigadier.builder.RequiredArgumentBuilder;
/*     */ import com.mojang.brigadier.context.CommandContext;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import java.util.Collection;
/*     */ import net.minecraft.commands.CommandSourceStack;
/*     */ import net.minecraft.commands.Commands;
/*     */ import net.minecraft.commands.arguments.EntityArgument;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.neoforged.neoforge.server.command.EnumArgument;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.bodydamage.BodyPartEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.attachments.bodydamage.BodyDamageAttachment;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ 
/*     */ public class BodyDamageCommand extends CommandBase {
/*     */   public BodyDamageCommand() {
/*  24 */     super((LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.literal("bodydamage")
/*  25 */         .requires(p_198521_0_ -> p_198521_0_.hasPermission(2)))
/*  26 */         .then(((RequiredArgumentBuilder)((RequiredArgumentBuilder)Commands.argument("target", (ArgumentType)EntityArgument.entities())
/*  27 */           .then(((LiteralArgumentBuilder)Commands.literal("set")
/*  28 */             .then(Commands.argument("BodyPart", (ArgumentType)EnumArgument.enumArgument(BodyPartEnum.class))
/*  29 */               .then(Commands.argument("Health", (ArgumentType)FloatArgumentType.floatArg(0.0F))
/*  30 */                 .executes(src -> (new BodyDamageCommand()).set((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target"), (BodyPartEnum)src.getArgument("BodyPart", BodyPartEnum.class), FloatArgumentType.getFloat(src, "Health"))))))
/*  31 */             .then(Commands.literal("ALL")
/*  32 */               .then(Commands.argument("Health", (ArgumentType)FloatArgumentType.floatArg(0.0F))
/*  33 */                 .executes(src -> (new BodyDamageCommand()).setAll((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target"), FloatArgumentType.getFloat(src, "Health")))))))
/*  34 */           .then(((LiteralArgumentBuilder)Commands.literal("heal")
/*  35 */             .then(Commands.argument("BodyPart", (ArgumentType)EnumArgument.enumArgument(BodyPartEnum.class))
/*  36 */               .then(Commands.argument("Health", (ArgumentType)FloatArgumentType.floatArg(0.0F))
/*  37 */                 .executes(src -> (new BodyDamageCommand()).heal((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target"), (BodyPartEnum)src.getArgument("BodyPart", BodyPartEnum.class), FloatArgumentType.getFloat(src, "Health"))))))
/*  38 */             .then(Commands.literal("ALL")
/*  39 */               .then(Commands.argument("Health", (ArgumentType)FloatArgumentType.floatArg(0.0F))
/*  40 */                 .executes(src -> (new BodyDamageCommand()).healAll((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target"), FloatArgumentType.getFloat(src, "Health")))))))
/*  41 */           .then(((LiteralArgumentBuilder)Commands.literal("get")
/*  42 */             .then(Commands.argument("BodyPart", (ArgumentType)EnumArgument.enumArgument(BodyPartEnum.class))
/*  43 */               .executes(src -> (new BodyDamageCommand()).get((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target"), (BodyPartEnum)src.getArgument("BodyPart", BodyPartEnum.class)))))
/*  44 */             .then(Commands.literal("ALL")
/*  45 */               .executes(src -> (new BodyDamageCommand()).getAll((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target")))))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(CommandSourceStack source, Collection<? extends Entity> entities, BodyPartEnum bodyPart) {
/*     */     try {
/*  53 */       StringBuilder reply = new StringBuilder();
/*  54 */       for (Entity entity : entities) {
/*     */         
/*  56 */         if (entity instanceof Player) { Player player = (Player)entity; if (source.getEntity() instanceof Player)
/*     */           
/*  58 */           { BodyDamageAttachment cap = AttachmentUtil.getBodyDamageAttachment(player);
/*  59 */             float bodyPartMaxHealth = cap.getBodyPartMaxHealth(bodyPart);
/*  60 */             float bodyPartHealth = bodyPartMaxHealth - cap.getBodyPartDamage(bodyPart);
/*     */             
/*  62 */             reply.append("Player ").append(player.getName().getString()).append("\n")
/*  63 */               .append("Body Limb ").append(bodyPart.name())
/*  64 */               .append(" Health : ").append(bodyPartHealth)
/*  65 */               .append("/").append(bodyPartMaxHealth)
/*  66 */               .append("\n");
/*  67 */             source.sendSuccess(() -> Component.literal(reply.toString()), false); }  }
/*     */       
/*     */       } 
/*  70 */     } catch (Exception e) {
/*     */       
/*  72 */       LegendarySurvivalOverhaul.LOGGER.error(e.getMessage());
/*     */     } 
/*  74 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAll(CommandSourceStack source, Collection<? extends Entity> entities) {
/*     */     try {
/*  81 */       StringBuilder reply = new StringBuilder();
/*  82 */       for (Entity entity : entities) {
/*     */         
/*  84 */         if (entity instanceof Player) { Player player = (Player)entity; if (source.getEntity() instanceof Player)
/*     */           
/*  86 */           { BodyDamageAttachment cap = AttachmentUtil.getBodyDamageAttachment(player);
/*  87 */             reply.append("Player ").append(player.getName().getString()).append("\n");
/*  88 */             for (BodyPartEnum bodyPart : BodyPartEnum.values()) {
/*     */               
/*  90 */               float bodyPartMaxHealth = cap.getBodyPartMaxHealth(bodyPart);
/*  91 */               float bodyPartHealth = bodyPartMaxHealth - cap.getBodyPartDamage(bodyPart);
/*     */               
/*  93 */               reply
/*  94 */                 .append("Body Limb ").append(bodyPart.name())
/*  95 */                 .append(" Health : ").append(bodyPartHealth)
/*  96 */                 .append("/").append(bodyPartMaxHealth)
/*  97 */                 .append("\n");
/*     */             } 
/*     */             
/* 100 */             source.sendSuccess(() -> Component.literal(reply.toString()), false); }  }
/*     */       
/*     */       } 
/* 103 */     } catch (Exception e) {
/*     */       
/* 105 */       LegendarySurvivalOverhaul.LOGGER.error(e.getMessage());
/*     */     } 
/* 107 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int set(CommandSourceStack src, Collection<? extends Entity> entities, BodyPartEnum bodyPart, float healthValue) throws CommandSyntaxException {
/* 113 */     for (Entity entity : entities) {
/*     */       
/* 115 */       if (entity instanceof Player) { Player player = (Player)entity;
/*     */         
/* 117 */         BodyDamageAttachment cap = AttachmentUtil.getBodyDamageAttachment(player);
/* 118 */         cap.setBodyPartDamage(bodyPart, cap.getBodyPartMaxHealth(bodyPart) - healthValue); }
/*     */     
/*     */     } 
/* 121 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int setAll(CommandSourceStack src, Collection<? extends Entity> entities, float healthValue) throws CommandSyntaxException {
/* 127 */     for (Entity entity : entities) {
/*     */       
/* 129 */       if (entity instanceof Player) { Player player = (Player)entity;
/*     */         
/* 131 */         BodyDamageAttachment cap = AttachmentUtil.getBodyDamageAttachment(player);
/* 132 */         for (BodyPartEnum bodyPart : BodyPartEnum.values())
/* 133 */           cap.setBodyPartDamage(bodyPart, cap.getBodyPartMaxHealth(bodyPart) - healthValue);  }
/*     */     
/*     */     } 
/* 136 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int heal(CommandSourceStack src, Collection<? extends Entity> entities, BodyPartEnum bodyPart, float healthValue) throws CommandSyntaxException {
/* 142 */     for (Entity entity : entities) {
/*     */       
/* 144 */       if (entity instanceof Player) { Player player = (Player)entity;
/*     */         
/* 146 */         BodyDamageAttachment cap = AttachmentUtil.getBodyDamageAttachment(player);
/* 147 */         cap.setBodyPartDamage(bodyPart, cap.getBodyPartDamage(bodyPart) - healthValue); }
/*     */     
/*     */     } 
/* 150 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int healAll(CommandSourceStack src, Collection<? extends Entity> entities, float healthValue) throws CommandSyntaxException {
/* 156 */     for (Entity entity : entities) {
/*     */       
/* 158 */       if (entity instanceof Player) { Player player = (Player)entity;
/*     */         
/* 160 */         BodyDamageAttachment cap = AttachmentUtil.getBodyDamageAttachment(player);
/* 161 */         for (BodyPartEnum bodyPart : BodyPartEnum.values())
/* 162 */           cap.setBodyPartDamage(bodyPart, cap.getBodyPartDamage(bodyPart) - healthValue);  }
/*     */     
/*     */     } 
/* 165 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\commands\BodyDamageCommand.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */