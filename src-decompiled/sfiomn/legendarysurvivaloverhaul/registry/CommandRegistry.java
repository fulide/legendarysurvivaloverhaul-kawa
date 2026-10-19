/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ import com.mojang.brigadier.CommandDispatcher;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.neoforged.neoforge.event.RegisterCommandsEvent;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.commands.BodyDamageCommand;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.commands.CommandBase;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.commands.HealthCommand;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.commands.WetnessCommand;
/*    */ 
/*    */ public class CommandRegistry {
/* 11 */   public static final CommandBase TEMPERATURE = (CommandBase)new TemperatureCommand();
/* 12 */   public static final CommandBase BODY_DAMAGE = (CommandBase)new BodyDamageCommand();
/* 13 */   public static final CommandBase HEALTH_COMMAND = (CommandBase)new HealthCommand();
/* 14 */   public static final CommandBase THIRST = (CommandBase)new ThirstCommand();
/* 15 */   public static final CommandBase WETNESS = (CommandBase)new WetnessCommand();
/* 16 */   public static final CommandBase FERN_TEST = (CommandBase)new FernTestCommand();
/*    */ 
/*    */   
/*    */   public static void registerCommandsEvent(RegisterCommandsEvent event) {
/* 20 */     CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
/*    */     
/* 22 */     dispatcher.register(TEMPERATURE.getBuilder());
/* 23 */     dispatcher.register(BODY_DAMAGE.getBuilder());
/* 24 */     dispatcher.register(HEALTH_COMMAND.getBuilder());
/* 25 */     dispatcher.register(THIRST.getBuilder());
/* 26 */     dispatcher.register(WETNESS.getBuilder());
/* 27 */     dispatcher.register(FERN_TEST.getBuilder());
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\CommandRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */