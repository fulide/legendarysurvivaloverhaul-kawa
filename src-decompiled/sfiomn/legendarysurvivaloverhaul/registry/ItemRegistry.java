/*     */ package sfiomn.legendarysurvivaloverhaul.registry;
/*     */ import java.util.List;
/*     */ import net.minecraft.core.Holder;
/*     */ import net.minecraft.network.chat.Component;
/*     */ import net.minecraft.world.item.ArmorItem;
/*     */ import net.minecraft.world.item.ArmorMaterial;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.ItemNameBlockItem;
/*     */ import net.minecraft.world.item.ItemStack;
/*     */ import net.minecraft.world.item.Rarity;
/*     */ import net.minecraft.world.item.TooltipFlag;
/*     */ import net.minecraft.world.level.block.Block;
/*     */ import net.neoforged.neoforge.registries.DeferredHolder;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.item.CoatEnum;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.CoatItem;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.WearableCurioItem;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.armor.ArmorMaterialBase;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.drink.CanteenItem;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.drink.JuiceItem;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.drink.LargeCanteenItem;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.drink.PurifiedWaterBottleItem;
/*     */ import sfiomn.legendarysurvivaloverhaul.common.items.heal.Medkit;
/*     */ 
/*     */ public class ItemRegistry {
/*  25 */   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, "legendarysurvivaloverhaul");
/*     */   
/*  27 */   public static final DeferredHolder<Item, ? extends Item> THERMOMETER = ITEMS.register("thermometer", () -> new ThermometerItem((new Item.Properties()).stacksTo(1)));
/*  28 */   public static final DeferredHolder<Item, ? extends Item> SEASONAL_CALENDAR = ITEMS.register("seasonal_calendar", () -> new SeasonalCalendarItem(new Item.Properties()));
/*     */   
/*  30 */   public static final DeferredHolder<Item, ? extends Item> NETHER_CHALICE = ITEMS.register("nether_chalice", () -> new NetherChaliceItem((new Item.Properties()).stacksTo(1).rarity(Rarity.EPIC)));
/*  31 */   public static final DeferredHolder<Item, ? extends Item> SPONGE = ITEMS.register("sponge", () -> new WearableCurioItem((new Item.Properties()).stacksTo(1).rarity(Rarity.RARE))
/*     */       {
/*     */ 
/*     */         
/*     */         public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag isAdvanced)
/*     */         {
/*  37 */           super.appendHoverText(stack, context, tooltipComponents, isAdvanced);
/*     */           
/*  39 */           tooltipComponents.add(Component.translatable("tooltip.legendarysurvivaloverhaul.sponge.description"));
/*     */         }
/*     */       });
/*  42 */   public static final DeferredHolder<Item, ? extends Item> HEAT_RESISTANCE_RING = ITEMS.register("heat_resistance_ring", () -> new WearableCurioItem((new Item.Properties()).stacksTo(1).rarity(Rarity.RARE)));
/*  43 */   public static final DeferredHolder<Item, ? extends Item> COLD_RESISTANCE_RING = ITEMS.register("cold_resistance_ring", () -> new WearableCurioItem((new Item.Properties()).stacksTo(1).rarity(Rarity.RARE)));
/*  44 */   public static final DeferredHolder<Item, ? extends Item> THERMAL_RESISTANCE_RING = ITEMS.register("thermal_resistance_ring", () -> new WearableCurioItem((new Item.Properties()).stacksTo(1).rarity(Rarity.EPIC)));
/*  45 */   public static final DeferredHolder<Item, ? extends Item> FIRST_AID_SUPPLIES = ITEMS.register("first_aid_supplies", () -> new WearableCurioItem((new Item.Properties()).stacksTo(1).rarity(Rarity.RARE))
/*     */       {
/*     */ 
/*     */         
/*     */         public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag isAdvanced)
/*     */         {
/*  51 */           super.appendHoverText(stack, context, tooltipComponents, isAdvanced);
/*     */           
/*  53 */           tooltipComponents.add(Component.translatable("tooltip.legendarysurvivaloverhaul.first_aid_supplies.description"));
/*     */         }
/*     */       });
/*     */   
/*  57 */   public static final DeferredHolder<Item, ? extends Item> SNOW_HELMET = ITEMS.register("snow_helmet", () -> new ArmorItem(ArmorMaterialBase.SNOW, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(6))));
/*  58 */   public static final DeferredHolder<Item, ? extends Item> SNOW_CHEST = ITEMS.register("snow_chestplate", () -> new ArmorItem(ArmorMaterialBase.SNOW, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(6))));
/*  59 */   public static final DeferredHolder<Item, ? extends Item> SNOW_LEGGINGS = ITEMS.register("snow_leggings", () -> new ArmorItem(ArmorMaterialBase.SNOW, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(6))));
/*  60 */   public static final DeferredHolder<Item, ? extends Item> SNOW_BOOTS = ITEMS.register("snow_boots", () -> new ArmorItem(ArmorMaterialBase.SNOW, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(6)))
/*     */       {
/*     */         
/*     */         public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer)
/*     */         {
/*  65 */           return true;
/*     */         }
/*     */       });
/*     */   
/*  69 */   public static final DeferredHolder<Item, ? extends Item> DESERT_HELMET = ITEMS.register("desert_helmet", () -> new ArmorItem(ArmorMaterialBase.DESERT, ArmorItem.Type.HELMET, (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(6))));
/*  70 */   public static final DeferredHolder<Item, ? extends Item> DESERT_CHEST = ITEMS.register("desert_chestplate", () -> new ArmorItem(ArmorMaterialBase.DESERT, ArmorItem.Type.CHESTPLATE, (new Item.Properties()).durability(ArmorItem.Type.CHESTPLATE.getDurability(6))));
/*  71 */   public static final DeferredHolder<Item, ? extends Item> DESERT_LEGGINGS = ITEMS.register("desert_leggings", () -> new ArmorItem(ArmorMaterialBase.DESERT, ArmorItem.Type.LEGGINGS, (new Item.Properties()).durability(ArmorItem.Type.LEGGINGS.getDurability(6))));
/*  72 */   public static final DeferredHolder<Item, ? extends Item> DESERT_BOOTS = ITEMS.register("desert_boots", () -> new ArmorItem(ArmorMaterialBase.DESERT, ArmorItem.Type.BOOTS, (new Item.Properties()).durability(ArmorItem.Type.BOOTS.getDurability(6))));
/*     */   
/*  74 */   public static final DeferredHolder<Item, ? extends Item> COOLING_COAT_1 = ITEMS.register("cooling_coat_1", () -> new CoatItem(CoatEnum.COOLING_1, (new Item.Properties()).rarity(Rarity.COMMON)));
/*  75 */   public static final DeferredHolder<Item, ? extends Item> COOLING_COAT_2 = ITEMS.register("cooling_coat_2", () -> new CoatItem(CoatEnum.COOLING_2, (new Item.Properties()).rarity(Rarity.RARE)));
/*  76 */   public static final DeferredHolder<Item, ? extends Item> COOLING_COAT_3 = ITEMS.register("cooling_coat_3", () -> new CoatItem(CoatEnum.COOLING_3, (new Item.Properties()).rarity(Rarity.EPIC)));
/*  77 */   public static final DeferredHolder<Item, ? extends Item> HEATING_COAT_1 = ITEMS.register("heating_coat_1", () -> new CoatItem(CoatEnum.HEATING_1, (new Item.Properties()).rarity(Rarity.COMMON)));
/*  78 */   public static final DeferredHolder<Item, ? extends Item> HEATING_COAT_2 = ITEMS.register("heating_coat_2", () -> new CoatItem(CoatEnum.HEATING_2, (new Item.Properties()).rarity(Rarity.RARE)));
/*  79 */   public static final DeferredHolder<Item, ? extends Item> HEATING_COAT_3 = ITEMS.register("heating_coat_3", () -> new CoatItem(CoatEnum.HEATING_3, (new Item.Properties()).rarity(Rarity.EPIC)));
/*  80 */   public static final DeferredHolder<Item, ? extends Item> THERMAL_COAT_1 = ITEMS.register("thermal_coat_1", () -> new CoatItem(CoatEnum.THERMAL_1, (new Item.Properties()).rarity(Rarity.COMMON)));
/*  81 */   public static final DeferredHolder<Item, ? extends Item> THERMAL_COAT_2 = ITEMS.register("thermal_coat_2", () -> new CoatItem(CoatEnum.THERMAL_2, (new Item.Properties()).rarity(Rarity.RARE)));
/*  82 */   public static final DeferredHolder<Item, ? extends Item> THERMAL_COAT_3 = ITEMS.register("thermal_coat_3", () -> new CoatItem(CoatEnum.THERMAL_3, (new Item.Properties()).rarity(Rarity.EPIC)));
/*     */   
/*  84 */   public static final DeferredHolder<Item, ? extends Item> COLD_STRING = ITEMS.register("cold_string", () -> new Item((new Item.Properties()).rarity(Rarity.COMMON)));
/*  85 */   public static final DeferredHolder<Item, ? extends Item> WARM_STRING = ITEMS.register("warm_string", () -> new Item((new Item.Properties()).rarity(Rarity.COMMON)));
/*     */   
/*  87 */   public static final DeferredHolder<Item, ? extends Item> SUN_FERN_SEEDS = ITEMS.register("sun_fern_seeds", () -> new ItemNameBlockItem((Block)BlockRegistry.SUN_FERN_CROP.get(), new Item.Properties()));
/*  88 */   public static final DeferredHolder<Item, ? extends Item> SUN_FERN = ITEMS.register("sun_fern_leaf", () -> new Item(new Item.Properties()));
/*  89 */   public static final DeferredHolder<Item, ? extends Item> SUN_FERN_GOLD = ITEMS.register("sun_fern_gold_leaf", () -> new Item(new Item.Properties()));
/*  90 */   public static final DeferredHolder<Item, ? extends Item> ICE_FERN_SEEDS = ITEMS.register("ice_fern_seeds", () -> new ItemNameBlockItem((Block)BlockRegistry.ICE_FERN_CROP.get(), new Item.Properties()));
/*  91 */   public static final DeferredHolder<Item, ? extends Item> ICE_FERN = ITEMS.register("ice_fern_leaf", () -> new Item(new Item.Properties()));
/*  92 */   public static final DeferredHolder<Item, ? extends Item> ICE_FERN_GOLD = ITEMS.register("ice_fern_gold_leaf", () -> new Item(new Item.Properties()));
/*     */ 
/*     */   
/*  95 */   public static final DeferredHolder<Item, ? extends Item> WATER_PURIFIER = ITEMS.register("water_purifier", () -> new WearableCurioItem((new Item.Properties()).stacksTo(1).rarity(Rarity.RARE))
/*     */       {
/*     */ 
/*     */         
/*     */         public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag isAdvanced)
/*     */         {
/* 101 */           super.appendHoverText(stack, context, tooltipComponents, isAdvanced);
/*     */           
/* 103 */           tooltipComponents.add(Component.translatable("tooltip.legendarysurvivaloverhaul.water_purifier.description"));
/*     */         }
/*     */       });
/*     */   
/* 107 */   public static final DeferredHolder<Item, ? extends Item> CANTEEN = ITEMS.register("canteen", () -> new CanteenItem((new Item.Properties()).rarity(Rarity.COMMON)));
/* 108 */   public static final DeferredHolder<Item, ? extends Item> LARGE_CANTEEN = ITEMS.register("large_canteen", () -> new LargeCanteenItem((new Item.Properties()).rarity(Rarity.UNCOMMON)));
/*     */   
/* 110 */   public static final DeferredHolder<Item, ? extends Item> APPLE_JUICE = ITEMS.register("apple_juice", () -> new JuiceItem(new Item.Properties()));
/* 111 */   public static final DeferredHolder<Item, ? extends Item> BEETROOT_JUICE = ITEMS.register("beetroot_juice", () -> new JuiceItem(new Item.Properties()));
/* 112 */   public static final DeferredHolder<Item, ? extends Item> CACTUS_JUICE = ITEMS.register("cactus_juice", () -> new JuiceItem(new Item.Properties()));
/* 113 */   public static final DeferredHolder<Item, ? extends Item> CARROT_JUICE = ITEMS.register("carrot_juice", () -> new JuiceItem(new Item.Properties()));
/* 114 */   public static final DeferredHolder<Item, ? extends Item> CHORUS_FRUIT_JUICE = ITEMS.register("chorus_fruit_juice", () -> new JuiceItem(new Item.Properties()));
/* 115 */   public static final DeferredHolder<Item, ? extends Item> GOLDEN_APPLE_JUICE = ITEMS.register("golden_apple_juice", () -> new JuiceItem((new Item.Properties()).rarity(Rarity.UNCOMMON)));
/* 116 */   public static final DeferredHolder<Item, ? extends Item> GOLDEN_CARROT_JUICE = ITEMS.register("golden_carrot_juice", () -> new JuiceItem((new Item.Properties()).rarity(Rarity.UNCOMMON)));
/* 117 */   public static final DeferredHolder<Item, ? extends Item> GLISTERING_MELON_JUICE = ITEMS.register("glistering_melon_juice", () -> new JuiceItem((new Item.Properties()).rarity(Rarity.UNCOMMON)));
/* 118 */   public static final DeferredHolder<Item, ? extends Item> MELON_JUICE = ITEMS.register("melon_juice", () -> new JuiceItem(new Item.Properties()));
/* 119 */   public static final DeferredHolder<Item, ? extends Item> PUMPKIN_JUICE = ITEMS.register("pumpkin_juice", () -> new JuiceItem(new Item.Properties()));
/* 120 */   public static final DeferredHolder<Item, ? extends Item> SWEET_BERRIES_JUICE = ITEMS.register("sweet_berries_juice", () -> new JuiceItem(new Item.Properties()));
/* 121 */   public static final DeferredHolder<Item, ? extends Item> GLOW_BERRIES_JUICE = ITEMS.register("glow_berries_juice", () -> new JuiceItem(new Item.Properties()));
/* 122 */   public static final DeferredHolder<Item, ? extends Item> PURIFIED_WATER_BOTTLE = ITEMS.register("purified_water_bottle", () -> new PurifiedWaterBottleItem(new Item.Properties()));
/* 123 */   public static final DeferredHolder<Item, ? extends Item> WATER_PLANT_BAG = ITEMS.register("water_plant_bag", () -> new DrinkItem(new Item.Properties()));
/* 124 */   public static final DeferredHolder<Item, ? extends Item> WATER_PLANT_SEEDS = ITEMS.register("water_plant_seeds", () -> new ItemNameBlockItem((Block)BlockRegistry.WATER_PLANT_CROP.get(), new Item.Properties()));
/*     */ 
/*     */   
/* 127 */   public static final DeferredHolder<Item, ? extends Item> HEART_CONTAINER = ITEMS.register("heart_container", () -> new HeartContainerItem((new Item.Properties()).rarity(Rarity.EPIC)));
/* 128 */   public static final DeferredHolder<Item, ? extends Item> HEART_FRAGMENT = ITEMS.register("heart_fragment", () -> new Item((new Item.Properties()).rarity(Rarity.RARE)));
/* 129 */   public static final DeferredHolder<Item, ? extends Item> SHIELD_CONTAINER = ITEMS.register("shield_container", () -> new ShieldContainerItem((new Item.Properties()).rarity(Rarity.EPIC)));
/*     */ 
/*     */   
/* 132 */   public static final DeferredHolder<Item, ? extends Item> HEALING_HERBS = ITEMS.register("healing_herbs", () -> new HealingHerbsItem(new Item.Properties()));
/* 133 */   public static final DeferredHolder<Item, ? extends Item> PLASTER = ITEMS.register("plaster", () -> new PlasterItem(new Item.Properties()));
/* 134 */   public static final DeferredHolder<Item, ? extends Item> BANDAGE = ITEMS.register("bandage", () -> new BandageItem(new Item.Properties()));
/* 135 */   public static final DeferredHolder<Item, ? extends Item> TONIC = ITEMS.register("tonic", () -> new TonicItem((new Item.Properties()).rarity(Rarity.RARE)));
/* 136 */   public static final DeferredHolder<Item, ? extends Item> MEDKIT = ITEMS.register("medkit", () -> new Medkit((new Item.Properties()).rarity(Rarity.EPIC)));
/* 137 */   public static final DeferredHolder<Item, ? extends Item> MORPHINE = ITEMS.register("morphine", () -> new MorphineItem(new Item.Properties()));
/*     */ 
/*     */   
/*     */   public static void register(IEventBus eventBus) {
/* 141 */     ITEMS.register(eventBus);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\registry\ItemRegistry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */