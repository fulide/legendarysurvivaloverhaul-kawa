/*    */ package sfiomn.legendarysurvivaloverhaul.common.commands;
/*    */ import com.mojang.brigadier.arguments.ArgumentType;
/*    */ import com.mojang.brigadier.arguments.FloatArgumentType;
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
/*    */ import sfiomn.legendarysurvivaloverhaul.common.attachments.thirst.ThirstAttachment;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.AttachmentUtil;
/*    */ import sfiomn.legendarysurvivaloverhaul.util.MathUtil;
/*    */ 
/*    */ public class ThirstCommand extends CommandBase {
/*    */   public ThirstCommand() {
/* 20 */     super((LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("thirst")
/* 21 */         .requires(p_198521_0_ -> p_198521_0_.hasPermission(2)))
/* 22 */         .then(Commands.literal("get").executes(src -> (new ThirstCommand()).get((CommandSourceStack)src.getSource()))))
/* 23 */         .then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)Commands.literal("set")
/* 24 */           .then(Commands.literal("hydration")
/* 25 */             .then(Commands.argument("value", (ArgumentType)IntegerArgumentType.integer(0, 20))
/* 26 */               .executes(src -> (new ThirstCommand()).setHydration((CommandSourceStack)src.getSource(), IntegerArgumentType.getInteger(src, "value"))))))
/* 27 */           .then(Commands.literal("saturation")
/* 28 */             .then(Commands.argument("value", (ArgumentType)FloatArgumentType.floatArg(0.0F, 20.0F))
/* 29 */               .executes(src -> (new ThirstCommand()).setSaturation((CommandSourceStack)src.getSource(), FloatArgumentType.getFloat(src, "value"))))))
/* 30 */           .then(Commands.literal("exhaustion")
/* 31 */             .then(Commands.argument("value", (ArgumentType)FloatArgumentType.floatArg(0.0F, 4.0F))
/* 32 */               .executes(src -> (new ThirstCommand()).setExhaustion((CommandSourceStack)src.getSource(), FloatArgumentType.getFloat(src, "value")))))));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int get(CommandSourceStack source) {
/*    */     try {
/* 41 */       Entity entity = source.getEntity(); if (entity instanceof Player) { Player player = (Player)entity;
/*    */         
/* 43 */         ThirstAttachment cap = AttachmentUtil.getThirstAttachment(player);
/*    */         
/* 45 */         int hydration = cap.getHydrationLevel();
/* 46 */         float saturation = MathUtil.round(cap.getSaturationLevel(), 2);
/* 47 */         float exhaustion = MathUtil.round(cap.getThirstExhaustion(), 2);
/*    */         
/* 49 */         String reply = "Hydration: " + hydration + "/20\nSaturation: " + saturation + "\nExhaustion: " + exhaustion;
/*    */         
/* 51 */         source.sendSuccess(() -> Component.literal(reply), false); }
/*    */     
/* 53 */     } catch (Exception e) {
/*    */       
/* 55 */       LegendarySurvivalOverhaul.LOGGER.error(e.getMessage());
/*    */     } 
/* 57 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   private int setHydration(CommandSourceStack src, int value) throws CommandSyntaxException {
/* 62 */     ThirstAttachment cap = AttachmentUtil.getThirstAttachment((Player)src.getPlayerOrException());
/* 63 */     cap.setHydrationLevel(value);
/* 64 */     src.sendSuccess(() -> Component.literal("Set hydration to " + value), false);
/* 65 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   private int setSaturation(CommandSourceStack src, float value) throws CommandSyntaxException {
/* 70 */     ThirstAttachment cap = AttachmentUtil.getThirstAttachment((Player)src.getPlayerOrException());
/* 71 */     cap.setThirstSaturation(value);
/* 72 */     src.sendSuccess(() -> Component.literal("Set saturation to " + value), false);
/* 73 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   private int setExhaustion(CommandSourceStack src, float value) throws CommandSyntaxException {
/* 78 */     ThirstAttachment cap = AttachmentUtil.getThirstAttachment((Player)src.getPlayerOrException());
/* 79 */     cap.setThirstExhaustion(value);
/* 80 */     src.sendSuccess(() -> Component.literal("Set exhaustion to " + value), false);
/* 81 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\commands\ThirstCommand.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */