/*     */ package sfiomn.legendarysurvivaloverhaul.data.integration.providers;
/*     */ 
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import net.minecraft.core.HolderLookup;
/*     */ import net.minecraft.data.PackOutput;
/*     */ import net.neoforged.neoforge.common.data.ExistingFileHelper;
/*     */ import sfiomn.legendarysurvivaloverhaul.api.data.providers.BodyDamageDataProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IceAndFireBodyDamageProvider
/*     */   extends BodyDamageDataProvider
/*     */ {
/*     */   public IceAndFireBodyDamageProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
/*  15 */     super("iceandfire", output, lookupProvider, fileHelper);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(HolderLookup.Provider provider, ExistingFileHelper existingFileHelper) {
/*  22 */     item("dragonsteel_ice_helmet").headResistance(0.2F);
/*  23 */     item("dragonsteel_ice_chestplate").chestResistance(0.2F);
/*  24 */     item("dragonsteel_ice_leggings").legsResistance(0.2F);
/*  25 */     item("dragonsteel_ice_boots").feetResistance(0.2F);
/*  26 */     item("dragonsteel_fire_helmet").headResistance(0.2F);
/*  27 */     item("dragonsteel_fire_chestplate").chestResistance(0.2F);
/*  28 */     item("dragonsteel_fire_leggings").legsResistance(0.2F);
/*  29 */     item("dragonsteel_fire_boots").feetResistance(0.2F);
/*  30 */     item("dragonsteel_lightning_helmet").headResistance(0.2F);
/*  31 */     item("dragonsteel_lightning_chestplate").chestResistance(0.2F);
/*  32 */     item("dragonsteel_lightning_leggings").legsResistance(0.2F);
/*  33 */     item("dragonsteel_lightning_boots").feetResistance(0.2F);
/*     */     
/*  35 */     item("armor_red_helmet").headResistance(0.15F);
/*  36 */     item("armor_red_chestplate").chestResistance(0.15F);
/*  37 */     item("armor_red_leggings").legsResistance(0.15F);
/*  38 */     item("armor_red_boots").feetResistance(0.15F);
/*  39 */     item("armor_bronze_helmet").headResistance(0.15F);
/*  40 */     item("armor_bronze_chestplate").chestResistance(0.15F);
/*  41 */     item("armor_bronze_leggings").legsResistance(0.15F);
/*  42 */     item("armor_bronze_boots").feetResistance(0.15F);
/*  43 */     item("armor_green_helmet").headResistance(0.15F);
/*  44 */     item("armor_green_chestplate").chestResistance(0.15F);
/*  45 */     item("armor_green_leggings").legsResistance(0.15F);
/*  46 */     item("armor_green_boots").feetResistance(0.15F);
/*  47 */     item("armor_gray_helmet").headResistance(0.15F);
/*  48 */     item("armor_gray_chestplate").chestResistance(0.15F);
/*  49 */     item("armor_gray_leggings").legsResistance(0.15F);
/*  50 */     item("armor_gray_boots").feetResistance(0.15F);
/*  51 */     item("armor_blue_helmet").headResistance(0.15F);
/*  52 */     item("armor_blue_chestplate").chestResistance(0.15F);
/*  53 */     item("armor_blue_leggings").legsResistance(0.15F);
/*  54 */     item("armor_blue_boots").feetResistance(0.15F);
/*  55 */     item("armor_silver_helmet").headResistance(0.15F);
/*  56 */     item("armor_silver_chestplate").chestResistance(0.15F);
/*  57 */     item("armor_silver_leggings").legsResistance(0.15F);
/*  58 */     item("armor_silver_boots").feetResistance(0.15F);
/*  59 */     item("armor_white_helmet").headResistance(0.15F);
/*  60 */     item("armor_white_chestplate").chestResistance(0.15F);
/*  61 */     item("armor_white_leggings").legsResistance(0.15F);
/*  62 */     item("armor_white_boots").feetResistance(0.15F);
/*  63 */     item("armor_sapphire_helmet").headResistance(0.15F);
/*  64 */     item("armor_sapphire_chestplate").chestResistance(0.15F);
/*  65 */     item("armor_sapphire_leggings").legsResistance(0.15F);
/*  66 */     item("armor_sapphire_boots").feetResistance(0.15F);
/*  67 */     item("armor_amythest_helmet").headResistance(0.15F);
/*  68 */     item("armor_amythest_chestplate").chestResistance(0.15F);
/*  69 */     item("armor_amythest_leggings").legsResistance(0.15F);
/*  70 */     item("armor_amythest_boots").feetResistance(0.15F);
/*  71 */     item("armor_copper_helmet").headResistance(0.15F);
/*  72 */     item("armor_copper_chestplate").chestResistance(0.15F);
/*  73 */     item("armor_copper_leggings").legsResistance(0.15F);
/*  74 */     item("armor_copper_boots").feetResistance(0.15F);
/*  75 */     item("armor_black_helmet").headResistance(0.15F);
/*  76 */     item("armor_black_chestplate").chestResistance(0.15F);
/*  77 */     item("armor_black_leggings").legsResistance(0.15F);
/*  78 */     item("armor_black_boots").feetResistance(0.15F);
/*  79 */     item("armor_electric_helmet").headResistance(0.15F);
/*  80 */     item("armor_electric_chestplate").chestResistance(0.15F);
/*  81 */     item("armor_electric_leggings").legsResistance(0.15F);
/*  82 */     item("armor_electric_boots").feetResistance(0.15F);
/*  83 */     item("tide_red_helmet").headResistance(0.15F);
/*  84 */     item("tide_red_chestplate").chestResistance(0.15F);
/*  85 */     item("tide_red_leggings").legsResistance(0.15F);
/*  86 */     item("tide_red_boots").feetResistance(0.15F);
/*  87 */     item("tide_blue_helmet").headResistance(0.15F);
/*  88 */     item("tide_blue_chestplate").chestResistance(0.15F);
/*  89 */     item("tide_blue_leggings").legsResistance(0.15F);
/*  90 */     item("tide_blue_boots").feetResistance(0.15F);
/*  91 */     item("tide_bronze_helmet").headResistance(0.15F);
/*  92 */     item("tide_bronze_chestplate").chestResistance(0.15F);
/*  93 */     item("tide_bronze_leggings").legsResistance(0.15F);
/*  94 */     item("tide_bronze_boots").feetResistance(0.15F);
/*  95 */     item("tide_green_helmet").headResistance(0.15F);
/*  96 */     item("tide_green_chestplate").chestResistance(0.15F);
/*  97 */     item("tide_green_leggings").legsResistance(0.15F);
/*  98 */     item("tide_green_boots").feetResistance(0.15F);
/*  99 */     item("tide_deepblue_helmet").headResistance(0.15F);
/* 100 */     item("tide_deepblue_chestplate").chestResistance(0.15F);
/* 101 */     item("tide_deepblue_leggings").legsResistance(0.15F);
/* 102 */     item("tide_deepblue_boots").feetResistance(0.15F);
/* 103 */     item("tide_purple_helmet").headResistance(0.15F);
/* 104 */     item("tide_purple_chestplate").chestResistance(0.15F);
/* 105 */     item("tide_purple_leggings").legsResistance(0.15F);
/* 106 */     item("tide_purple_boots").feetResistance(0.15F);
/* 107 */     item("tide_teal_helmet").headResistance(0.15F);
/* 108 */     item("tide_teal_chestplate").chestResistance(0.15F);
/* 109 */     item("tide_teal_leggings").legsResistance(0.15F);
/* 110 */     item("tide_teal_boots").feetResistance(0.15F);
/*     */   }
/*     */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\data\integration\providers\IceAndFireBodyDamageProvider.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */