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
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.temperature.TemperatureUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.temperature.TemperatureAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.MathUtil;
/*    */ 
/*    */ public class TemperatureCommand extends CommandBase {
/*    */   public TemperatureCommand() {
/* 21 */     super((LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("temperature")
/* 22 */         .requires(p_198521_0_ -> p_198521_0_.hasPermission(2)))
/* 23 */         .then(Commands.literal("set").then(Commands.argument("Temperature", (ArgumentType)IntegerArgumentType.integer((int)TemperatureEnum.getMin(), (int)TemperatureEnum.getMax())).executes(src -> (new TemperatureCommand()).set((CommandSourceStack)src.getSource(), IntegerArgumentType.getInteger(src, "Temperature"))))))
/* 24 */         .then(Commands.literal("get").executes(src -> (new TemperatureCommand()).get((CommandSourceStack)src.getSource()))));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int get(CommandSourceStack source) {
/*    */     try {
/* 33 */       Entity entity = source.getEntity(); if (entity instanceof Player) { Player player = (Player)entity;
/*    */         
/* 35 */         float targetTemperature = TemperatureUtil.getPlayerTargetTemperature(player);
/* 36 */         TemperatureAttachment cap = AttachmentUtil.getTempAttachment(player);
/* 37 */         float playerTemp = MathUtil.round(cap.getTemperatureLevel(), 2);
/* 38 */         float worldTemp = TemperatureUtil.getWorldTemperature(player.level(), player.blockPosition());
/*    */         
/* 40 */         String reply = "Temp: " + playerTemp + "\nTarget Temp: " + targetTemperature + "\nWorld Temp: " + worldTemp;
/*    */         
/* 42 */         source.sendSuccess(() -> Component.literal(reply), false); }
/*    */     
/* 44 */     } catch (Exception e) {
/*    */       
/* 46 */       LegendarySurvivalOverhaul.LOGGER.error(e.getMessage());
/*    */     } 
/* 48 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   private int set(CommandSourceStack src, int temp) throws CommandSyntaxException {
/* 53 */     AttachmentUtil.getTempAttachment((Player)src.getPlayerOrException()).setTemperatureLevel(temp);
/* 54 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\commands\TemperatureCommand.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */