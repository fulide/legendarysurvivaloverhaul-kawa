/*    */ package sfiomn.legendarysurvivaloverhaul.common.commands;
/*    */ 
/*    */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommandBase
/*    */ {
/*    */   CommandSourceStack source;
/*    */   LiteralArgumentBuilder<CommandSourceStack> builder;
/*    */   
/*    */   public CommandBase(LiteralArgumentBuilder<CommandSourceStack> builder) {
/* 17 */     this.builder = builder;
/*    */   }
/*    */ 
/*    */   
/*    */   public LiteralArgumentBuilder<CommandSourceStack> getBuilder() {
/* 22 */     return this.builder;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(CommandSourceStack source) throws CommandSyntaxException {
/* 27 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(CommandSourceStack source, String[] args) throws CommandSyntaxException {
/* 32 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\commands\CommandBase.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */