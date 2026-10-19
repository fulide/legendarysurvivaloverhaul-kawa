/*     */ package sfiomn.legendarysurvivaloverhaul.common.commands;
/*     */ import com.mojang.brigadier.arguments.ArgumentType;
/*     */ import com.mojang.brigadier.arguments.DoubleArgumentType;
/*     */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*     */ import com.mojang.brigadier.builder.RequiredArgumentBuilder;
/*     */ import com.mojang.brigadier.context.CommandContext;
/*     */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*     */ import java.util.Collection;
/*     */ import net.minecraft.commands.CommandSourceStack;
/*     */ import net.minecraft.commands.Commands;
/*     */ import net.minecraft.commands.arguments.EntityArgument;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*     */ import sfiomn.legendarysurvivaloverhaul.config.Config;
/*     */ import sfiomn.legendarysurvivaloverhaul.registry.AttributeRegistry;
/*     */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*     */ 
/*     */ public class HealthCommand extends CommandBase {
/*     */   public HealthCommand() {
/*  23 */     super((LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.literal("healthoverhaul")
/*  24 */         .requires(p_198521_0_ -> p_198521_0_.hasPermission(2)))
/*  25 */         .then(((RequiredArgumentBuilder)Commands.argument("target", (ArgumentType)EntityArgument.entities())
/*  26 */           .then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("get")
/*  27 */             .then(Commands.literal("shield")
/*  28 */               .executes(src -> (new HealthCommand()).getShield((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target")))))
/*  29 */             .then(Commands.literal("additionalHealth")
/*  30 */               .executes(src -> (new HealthCommand()).getHealth((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target")))))
/*  31 */             .then(Commands.literal("brokenHearts")
/*  32 */               .executes(src -> (new HealthCommand()).getBrokenHeart((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target"))))))
/*  33 */           .then(((LiteralArgumentBuilder)Commands.literal("set")
/*  34 */             .then(Commands.literal("shield")
/*  35 */               .then(Commands.argument("shieldValue", (ArgumentType)DoubleArgumentType.doubleArg(0.0D, Config.Baked.maxShieldHealth))
/*  36 */                 .executes(src -> (new HealthCommand()).setShield((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target"), DoubleArgumentType.getDouble(src, "shieldValue"))))))
/*  37 */             .then(Commands.literal("additionalHealth")
/*  38 */               .then(Commands.argument("healthValue", (ArgumentType)DoubleArgumentType.doubleArg(0.0D, Config.Baked.maxAdditionalHealth))
/*  39 */                 .executes(src -> (new HealthCommand()).setHealth((CommandSourceStack)src.getSource(), EntityArgument.getEntities(src, "target"), DoubleArgumentType.getDouble(src, "healthValue"))))))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getShield(CommandSourceStack src, Collection<? extends Entity> entities) {
/*     */     try {
/*  49 */       StringBuilder reply = new StringBuilder();
/*  50 */       for (Entity entity : entities) {
/*     */         
/*  52 */         if (entity instanceof Player) { Player player = (Player)entity; if (src.getEntity() instanceof Player)
/*     */           
/*  54 */           { reply.append("Player ").append(player.getName().getString()).append(" ");
/*  55 */             float shieldValue = AttachmentUtil.getHealthAttachment(player).getShieldHealth();
/*     */             
/*  57 */             reply.append("Shield: ")
/*  58 */               .append(shieldValue)
/*  59 */               .append("\n");
/*     */             
/*  61 */             src.sendSuccess(() -> Component.literal(reply.toString()), false); }  }
/*     */       
/*     */       } 
/*  64 */     } catch (Exception e) {
/*     */       
/*  66 */       LegendarySurvivalOverhaul.LOGGER.error(e.getMessage());
/*     */     } 
/*  68 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int getHealth(CommandSourceStack src, Collection<? extends Entity> entities) {
/*     */     try {
/*  75 */       StringBuilder reply = new StringBuilder();
/*  76 */       for (Entity entity : entities) {
/*     */         
/*  78 */         if (entity instanceof Player) { Player player = (Player)entity; if (src.getEntity() instanceof Player)
/*     */           
/*  80 */           { reply.append("Player ").append(player.getName().getString()).append(" ");
/*  81 */             float healthValue = AttachmentUtil.getHealthAttachment(player).getAdditionalHealth();
/*     */             
/*  83 */             reply.append("Additional Health: ")
/*  84 */               .append(healthValue)
/*  85 */               .append("\n");
/*     */             
/*  87 */             src.sendSuccess(() -> Component.literal(reply.toString()), false); }  }
/*     */       
/*     */       } 
/*  90 */     } catch (Exception e) {
/*     */       
/*  92 */       LegendarySurvivalOverhaul.LOGGER.error(e.getMessage());
/*     */     } 
/*  94 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int getBrokenHeart(CommandSourceStack src, Collection<? extends Entity> entities) {
/*     */     try {
/* 101 */       StringBuilder reply = new StringBuilder();
/* 102 */       for (Entity entity : entities) {
/*     */         
/* 104 */         if (entity instanceof Player) { Player player = (Player)entity; if (src.getEntity() instanceof Player)
/*     */           
/* 106 */           { reply.append("Player ").append(player.getName().getString()).append(" ");
/* 107 */             float brokenHearts = (int)player.getAttributeValue((Holder)AttributeRegistry.BROKEN_HEART);
/*     */             
/* 109 */             reply.append("Broken Hearts: ")
/* 110 */               .append(brokenHearts)
/* 111 */               .append("\n");
/*     */             
/* 113 */             src.sendSuccess(() -> Component.literal(reply.toString()), false); }  }
/*     */       
/*     */       } 
/* 116 */     } catch (Exception e) {
/*     */       
/* 118 */       LegendarySurvivalOverhaul.LOGGER.error(e.getMessage());
/*     */     } 
/* 120 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private int setShield(CommandSourceStack src, Collection<? extends Entity> entities, double shieldValue) throws CommandSyntaxException {
/* 125 */     for (Entity entity : entities) {
/*     */       
/* 127 */       if (entity instanceof Player) { Player player = (Player)entity;
/*     */         
/* 129 */         AttachmentUtil.getHealthAttachment(player).setShieldHealth((float)shieldValue); }
/*     */     
/*     */     } 
/* 132 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private int setHealth(CommandSourceStack src, Collection<? extends Entity> entities, double healthValue) throws CommandSyntaxException {
/* 137 */     for (Entity entity : entities) {
/*     */       
/* 139 */       if (entity instanceof Player) { Player player = (Player)entity;
/*     */         
/* 141 */         AttachmentUtil.getHealthAttachment(player).setAdditionalHealth((float)healthValue); }
/*     */     
/*     */     } 
/* 144 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\commands\HealthCommand.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */