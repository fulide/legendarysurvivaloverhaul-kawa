/*    */ package sfiomn.legendarysurvivaloverhaul.registry;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.core.registries.Registries;
/*    */ import net.minecraft.world.item.BlockItem;
/*    */ import net.minecraft.world.item.Item;
/*    */ import net.minecraft.world.level.block.Block;
/*    */ import net.minecraft.world.level.block.SoundType;
/*    */ import net.minecraft.world.level.block.state.BlockBehaviour;
/*    */ import net.minecraft.world.level.material.MapColor;
/*    */ import net.neoforged.bus.api.IEventBus;
/*    */ import net.neoforged.neoforge.registries.DeferredHolder;
/*    */ import net.neoforged.neoforge.registries.DeferredRegister;
/*    */ import sfiomn.legendarysurvivaloverhaul.api.block.ThermalTypeEnum;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.CoolerBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.HeaterBaseBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.HeaterTopBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.IceFernGoldBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SewingTableBlock;
/*    */ import sfiomn.legendarysurvivaloverhaul.common.blocks.SunFernGoldBlock;
/*    */ 
/*    */ public class BlockRegistry {
/* 22 */   public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, "legendarysurvivaloverhaul");
/*    */ 
/*    */ 
/*    */   
/* 26 */   public static final DeferredHolder<Block, HeaterBaseBlock> HEATER = registerBlock("heater", () -> new HeaterBaseBlock(ThermalTypeEnum.HEATING));
/*    */   
/* 28 */   public static final DeferredHolder<Block, HeaterTopBlock> HEATER_TOP = BLOCKS
/* 29 */     .register("heater_top", () -> new HeaterTopBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(3.5F).sound(SoundType.METAL).noOcclusion()));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 36 */   public static final DeferredHolder<Block, CoolerBlock> COOLER = registerBlock("cooler", () -> new CoolerBlock(ThermalTypeEnum.COOLING));
/*    */ 
/*    */   
/* 39 */   public static final DeferredHolder<Block, SewingTableBlock> SEWING_TABLE = registerBlock("sewing_table", () -> new SewingTableBlock(SewingTableBlock.getProperties()));
/*    */ 
/*    */   
/* 42 */   public static final DeferredHolder<Block, SunFernBlock> SUN_FERN_CROP = BLOCKS
/* 43 */     .register("sun_fern_crop", SunFernBlock::new);
/*    */ 
/*    */   
/* 46 */   public static final DeferredHolder<Block, SunFernGoldBlock> SUN_FERN_GOLD = registerBlock("sun_fern_gold", () -> new SunFernGoldBlock(SunFernGoldBlock.getProperties()));
/*    */   
/* 48 */   public static final DeferredHolder<Block, IceFernBlock> ICE_FERN_CROP = BLOCKS
/* 49 */     .register("ice_fern_crop", IceFernBlock::new);
/*    */ 
/*    */   
/* 52 */   public static final DeferredHolder<Block, IceFernGoldBlock> ICE_FERN_GOLD = registerBlock("ice_fern_gold", () -> new IceFernGoldBlock(IceFernGoldBlock.getProperties()));
/*    */   
/* 54 */   public static final DeferredHolder<Block, WaterPlantBlock> WATER_PLANT_CROP = BLOCKS
/* 55 */     .register("water_plant_crop", WaterPlantBlock::new);
/*    */ 
/*    */   
/*    */   private static <T extends Block> DeferredHolder<Block, T> registerBlock(String name, Supplier<T> block) {
/* 59 */     DeferredHolder<Block, T> holder = BLOCKS.register(name, block);
/* 60 */     registerBlockItem(name, holder);
/* 61 */     return holder;
/*    */   }
/*    */ 
/*    */   
/*    */   private static <T extends Block> void registerBlockItem(String name, DeferredHolder<Block, T> block) {
/* 66 */     ItemRegistry.ITEMS.register(name, () -> new BlockItem((Block)block.get(), new Item.Properties()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void register(IEventBus eventBus) {
/* 71 */     BLOCKS.register(eventBus);
/*    */   }
/*    */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\BlockRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */