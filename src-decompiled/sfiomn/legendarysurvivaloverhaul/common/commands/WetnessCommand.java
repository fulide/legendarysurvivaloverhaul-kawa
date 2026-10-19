/*    */ package sfiomn.legendarysurvivaloverhaul.common.commands;
/*    */ import com.mojang.brigadier.arguments.ArgumentType;
/*    */ import com.mojang.brigadier.arguments.IntegerArgumentType;
/*    */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.commands.Commands;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.wetness.WetnessAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ 
/*    */ public class WetnessCommand extends CommandBase {
/*    */   public WetnessCommand() {
/* 18 */     super((LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("wetness")
/* 19 */         .requires(p_198521_0_ -> p_198521_0_.hasPermission(2)))
/* 20 */         .then(Commands.literal("get").executes(src -> (new WetnessCommand()).get((CommandSourceStack)src.getSource()))))
/* 21 */         .then(Commands.literal("set")
/* 22 */           .then(Commands.argument("value", (ArgumentType)IntegerArgumentType.integer(0, 400))
/* 23 */             .executes(src -> (new WetnessCommand()).setWetness((CommandSourceStack)src.getSource(), IntegerArgumentType.getInteger(src, "value"))))));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int get(CommandSourceStack source) {
/*    */     try {
/* 32 */       Entity entity = source.getEntity(); if (entity instanceof Player) { Player player = (Player)entity;
/*    */         
/* 34 */         WetnessAttachment cap = AttachmentUtil.getWetnessAttachment(player);
/*    */         
/* 36 */         int wetness = cap.getWetness();
/* 37 */         int ticksWet = cap.getWetnessTickTimer();
/*    */         
/* 39 */         String reply = "Wetness: " + wetness + "/400\nTicks Wet: " + ticksWet;
/*    */         
/* 41 */         source.sendSuccess(() -> Component.literal(reply), false); }
/*    */     
/* 43 */     } catch (Exception e) {
/*    */       
/* 45 */       LegendarySurvivalOverhaul.LOGGER.error(e.getMessage());
/*    */     } 
/* 47 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   private int setWetness(CommandSourceStack src, int value) throws CommandSyntaxException {
/* 52 */     WetnessAttachment cap = AttachmentUtil.getWetnessAttachment((Player)src.getPlayerOrException());
/* 53 */     cap.setWetness(value);
/* 54 */     src.sendSuccess(() -> Component.literal("Set wetness to " + value), false);
/* 55 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\commands\WetnessCommand.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */