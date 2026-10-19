/*    */ package sfiomn.legendarysurvivaloverhaul.common.commands;
/*    */ import com.mojang.brigadier.arguments.ArgumentType;
/*    */ import com.mojang.brigadier.arguments.IntegerArgumentType;
/*    */ import com.mojang.brigadier.arguments.StringArgumentType;
/*    */ import com.mojang.brigadier.builder.LiteralArgumentBuilder;
/*    */ import com.mojang.brigadier.context.CommandContext;
/*    */ import com.mojang.brigadier.exceptions.CommandSyntaxException;
/*    */ import net.minecraft.commands.CommandSourceStack;
/*    */ import net.minecraft.commands.Commands;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.core.Holder;
/*    */ import net.minecraft.core.HolderLookup;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.network.chat.Component;
/*    */ import net.minecraft.server.level.ServerLevel;
/*    */ import net.minecraft.util.RandomSource;
/*    */ import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
/*    */ import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.level.gen.ModConfiguredFeatures;
/*    */ 
/*    */ public class FernTestCommand extends CommandBase {
/*    */   public FernTestCommand() {
/* 23 */     super((LiteralArgumentBuilder<CommandSourceStack>)((LiteralArgumentBuilder)Commands.literal("lso")
/* 24 */         .requires(p_198521_0_ -> p_198521_0_.hasPermission(2)))
/* 25 */         .then(Commands.literal("fernpatch")
/* 26 */           .then(Commands.argument("type", (ArgumentType)StringArgumentType.word())
/* 27 */             .then(Commands.argument("radius", (ArgumentType)IntegerArgumentType.integer(1, 256))
/* 28 */               .then(Commands.argument("attempts", (ArgumentType)IntegerArgumentType.integer(1, 10000))
/* 29 */                 .executes(ctx -> (new FernTestCommand()).spawnFernPatches((CommandSourceStack)ctx.getSource(), StringArgumentType.getString(ctx, "type"), IntegerArgumentType.getInteger(ctx, "radius"), IntegerArgumentType.getInteger(ctx, "attempts"))))))));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private int spawnFernPatches(CommandSourceStack source, String type, int radius, int attempts) {
/*    */     try {
/*    */       Holder.Reference reference;
/* 41 */       ServerLevel level = source.getLevel();
/* 42 */       if (source.getEntity() == null)
/*    */       {
/* 44 */         return 1;
/*    */       }
/*    */       
/* 47 */       HolderLookup.RegistryLookup<ConfiguredFeature<?, ?>> registry = level.registryAccess().lookupOrThrow(Registries.CONFIGURED_FEATURE);
/*    */ 
/*    */       
/* 50 */       if (type.equalsIgnoreCase("ice")) {
/*    */         
/* 52 */         reference = registry.getOrThrow(ModConfiguredFeatures.ICE_FERN_CONFIG_KEY);
/* 53 */       } else if (type.equalsIgnoreCase("sun")) {
/*    */         
/* 55 */         reference = registry.getOrThrow(ModConfiguredFeatures.SUN_FERN_CONFIG_KEY);
/*    */       } else {
/*    */         
/* 58 */         source.sendFailure((Component)Component.literal("Unknown type: " + type + " (use: ice | sun)"));
/* 59 */         return 1;
/*    */       } 
/*    */       
/* 62 */       RandomSource random = level.getRandom();
/* 63 */       BlockPos center = source.getEntity().blockPosition();
/*    */       
/* 65 */       int placed = 0;
/* 66 */       for (int i = 0; i < attempts; i++) {
/*    */         
/* 68 */         int dx = random.nextInt(radius * 2 + 1) - radius;
/* 69 */         int dz = random.nextInt(radius * 2 + 1) - radius;
/* 70 */         int x = center.getX() + dx;
/* 71 */         int z = center.getZ() + dz;
/* 72 */         int y = level.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
/*    */         
/* 74 */         BlockPos origin = new BlockPos(x, y, z);
/* 75 */         if (((ConfiguredFeature)reference.value()).place((WorldGenLevel)level, level.getChunkSource().getGenerator(), random, origin))
/*    */         {
/* 77 */           placed++;
/*    */         }
/*    */       } 
/*    */       
/* 81 */       int finalPlaced = placed;
/* 82 */       source.sendSuccess(() -> Component.literal("Placed " + finalPlaced + " fern patches (type=" + type + ") within radius " + radius), false);
/* 83 */     } catch (Exception e) {
/*    */       
/* 85 */       LegendarySurvivalOverhaul.LOGGER.error(e.getMessage());
/*    */     } 
/*    */     
/* 88 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\common\commands\FernTestCommand.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */