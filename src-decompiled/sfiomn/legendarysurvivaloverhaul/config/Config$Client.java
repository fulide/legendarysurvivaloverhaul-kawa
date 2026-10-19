/*      */ package sfiomn.legendarysurvivaloverhaul.config;
/*      */ 
/*      */ import net.neoforged.neoforge.common.ModConfigSpec;
/*      */ import sfiomn.legendarysurvivaloverhaul.util.EnumUtil;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Client
/*      */ {
/*      */   public final ModConfigSpec.BooleanValue foodSaturationDisplayed;
/*      */   public final ModConfigSpec.BooleanValue showVanillaBarAnimationOverlay;
/*      */   public final ModConfigSpec.EnumValue<EnumUtil.temperatureDisplayMode> temperatureDisplayMode;
/*      */   public final ModConfigSpec.IntValue temperatureDisplayOffsetX;
/*      */   public final ModConfigSpec.IntValue temperatureDisplayOffsetY;
/*      */   public final ModConfigSpec.IntValue bodyTemperatureDisplayOffsetX;
/*      */   public final ModConfigSpec.IntValue bodyTemperatureDisplayOffsetY;
/*      */   public final ModConfigSpec.BooleanValue heatTemperatureOverlay;
/*      */   public final ModConfigSpec.BooleanValue coldTemperatureOverlay;
/*      */   public final ModConfigSpec.BooleanValue breathingSoundEnabled;
/*      */   public final ModConfigSpec.DoubleValue coldBreathEffectThreshold;
/*      */   public final ModConfigSpec.BooleanValue renderTemperatureInFahrenheit;
/*      */   public final ModConfigSpec.IntValue wetnessIndicatorOffsetX;
/*      */   public final ModConfigSpec.IntValue wetnessIndicatorOffsetY;
/*      */   public final ModConfigSpec.IntValue bodyDamageIndicatorOffsetX;
/*      */   public final ModConfigSpec.IntValue bodyDamageIndicatorOffsetY;
/*      */   public final ModConfigSpec.DoubleValue bodyDamageIndicatorRenderHealthLimit;
/*      */   public final ModConfigSpec.IntValue seasonCardsDisplayOffsetX;
/*      */   public final ModConfigSpec.IntValue seasonCardsDisplayOffsetY;
/*      */   public final ModConfigSpec.IntValue seasonCardsSpawnDimensionDelayInTicks;
/*      */   public final ModConfigSpec.IntValue seasonCardsDisplayTimeInTicks;
/*      */   public final ModConfigSpec.IntValue seasonCardsFadeInInTicks;
/*      */   public final ModConfigSpec.IntValue seasonCardsFadeOutInTicks;
/*      */   public final ModConfigSpec.BooleanValue showHydrationTooltip;
/*      */   public final ModConfigSpec.BooleanValue mergeHydrationAndSaturationTooltip;
/*      */   public final ModConfigSpec.BooleanValue hydrationSaturationDisplayed;
/*      */   public final ModConfigSpec.BooleanValue hydrationExhaustionDisplayed;
/*      */   public final ModConfigSpec.BooleanValue lowHydrationEffect;
/*      */   public final ModConfigSpec.BooleanValue showHydrationBar;
/*      */   public final ModConfigSpec.BooleanValue showDrinkPreview;
/*      */   public final ModConfigSpec.IntValue hydrationBarOffsetX;
/*      */   public final ModConfigSpec.IntValue hydrationBarOffsetY;
/*      */   public final ModConfigSpec.BooleanValue appendBrokenShieldHeartsToHealthBar;
/*      */   
/*      */   Client(ModConfigSpec.Builder builder) {
/* 1179 */     builder.comment(new String[] { " Options related to the heads up display.", " These options will automatically update upon being saved."
/*      */         
/* 1181 */         }).push("hud");
/* 1182 */     builder.push("general");
/*      */     
/* 1184 */     this
/*      */       
/* 1186 */       .foodSaturationDisplayed = builder.comment(" If enabled, the food saturation will be rendered on the Food Bar while the player suffers Cold Hunger Effect (secondary temperature effect).").define("Show Food Saturation Bar", true);
/*      */     
/* 1188 */     this
/*      */ 
/*      */ 
/*      */       
/* 1192 */       .showVanillaBarAnimationOverlay = builder.comment(new String[] { " Whether the vanilla animation of the Food bar and Hydration bar is rendered. The bar shakes more the lower they are.", " This mod render a new food bar as a secondary effect of a cold temperature.", " Disable this animation if the temperature secondary effect is enabled to allow a compatibility with other mods rendering the food bar (for example Appleskin)." }).define("Show Vanilla Bar Animation Overlay", true);
/* 1193 */     builder.pop();
/*      */     
/* 1195 */     builder.push("temperature");
/* 1196 */     this
/*      */ 
/*      */ 
/*      */       
/* 1200 */       .temperatureDisplayMode = builder.comment(new String[] { " How temperature is displayed. Accepted values are as follows:", "    SYMBOL - Display the player's current temperature as a symbol above the hotbar.", "    NONE - Disable the temperature indicator." }).defineEnum("Temperature Display Mode", (Enum)EnumUtil.temperatureDisplayMode.SYMBOL);
/* 1201 */     this
/*      */       
/* 1203 */       .temperatureDisplayOffsetX = builder.comment(" The X and Y offset of the temperature indicator. Set both to 0 for no offset.").defineInRange("Temperature Display X Offset", 0, -10000, 10000);
/* 1204 */     this
/* 1205 */       .temperatureDisplayOffsetY = builder.defineInRange("Temperature Display Y Offset", 0, -10000, 10000);
/* 1206 */     this
/*      */ 
/*      */       
/* 1209 */       .bodyTemperatureDisplayOffsetX = builder.comment(new String[] { " The X and Y offset of the body temperature, shown when thermometer is equipped as a bauble (needs the curios mod).", " Set both to 0 for no offset." }).defineInRange("Body Temperature Display X Offset", 0, -10000, 10000);
/* 1210 */     this
/* 1211 */       .bodyTemperatureDisplayOffsetY = builder.defineInRange("Body Temperature Display Y Offset", 0, -10000, 10000);
/* 1212 */     this
/*      */       
/* 1214 */       .heatTemperatureOverlay = builder.comment(" If enabled, player will see a foggy effect when the heat is high.").define("Heat Temperature Overlay", true);
/* 1215 */     this
/*      */       
/* 1217 */       .coldTemperatureOverlay = builder.comment(" If enabled, player will see a frost effect when the cold is low.").define("Cold Temperature Overlay", true);
/* 1218 */     this
/*      */       
/* 1220 */       .breathingSoundEnabled = builder.comment(" If enabled, breathing sound can be heard while player faces harsh temperatures.").define("Breathing Sound Enabled", true);
/* 1221 */     this
/*      */       
/* 1223 */       .coldBreathEffectThreshold = builder.comment(" Temperature threshold below which a cold breath effect is rendered by the player. -1000 disable the feature.").defineInRange("Cold Breath Temperature Threshold", 10.0D, -1000.0D, 1000.0D);
/* 1224 */     this
/*      */       
/* 1226 */       .renderTemperatureInFahrenheit = builder.comment(" If enabled, render the temperature values in Fahrenheit.").define("Temperature In Fahrenheit", false);
/* 1227 */     builder.push("wetness");
/* 1228 */     this
/*      */       
/* 1230 */       .wetnessIndicatorOffsetX = builder.comment(" The X and Y offset of the wetness indicator. Set both to 0 for no offset.").defineInRange("Wetness Indicator X Offset", 0, -10000, 10000);
/* 1231 */     this
/* 1232 */       .wetnessIndicatorOffsetY = builder.defineInRange("Wetness Indicator Y Offset", 0, -10000, 10000);
/* 1233 */     builder.pop();
/* 1234 */     builder.pop();
/*      */     
/* 1236 */     builder.pop();
/*      */     
/* 1238 */     builder.push("body-damage");
/* 1239 */     this
/*      */       
/* 1241 */       .bodyDamageIndicatorOffsetX = builder.comment(new String[] { " The X and Y offset of the body damage indicator. Set both to 0 for no offset.", " By default, render next to the inventory bar." }).defineInRange("Body Damage Indicator X Offset", 0, -10000, 10000);
/* 1242 */     this.bodyDamageIndicatorOffsetY = builder.defineInRange("Body Damage Indicator Y Offset", 0, -10000, 10000);
/* 1243 */     this
/*      */       
/* 1245 */       .bodyDamageIndicatorRenderHealthLimit = builder.comment(new String[] { " Limb health threshold below which the body damage indicator is rendered.", " If set to 1.1, the body damage indicator is always rendered.", " If set to 1.0, the body damage indicator is rendered as soon as a limb is wounded." }).defineInRange("Body Damage Indicator Limb Health Threshold", 1.0D, 0.0D, 1.1D);
/* 1246 */     builder.pop();
/*      */     
/* 1248 */     builder.push("season-cards");
/* 1249 */     this
/*      */       
/* 1251 */       .seasonCardsDisplayOffsetX = builder.comment(new String[] { " The X and Y offset of the season cards. Set both to 0 for no offset.", " By default, render first top quarter vertically and centered horizontally." }).defineInRange("Season Cards Display X Offset", 0, -10000, 10000);
/* 1252 */     this
/* 1253 */       .seasonCardsDisplayOffsetY = builder.defineInRange("Season Cards Display Y Offset", 0, -10000, 10000);
/* 1254 */     this
/*      */       
/* 1256 */       .seasonCardsSpawnDimensionDelayInTicks = builder.comment(" The delay before rendering the season card at first player spawn or player dimension change.").defineInRange("Season Cards Delay In Ticks", 80, 0, 2147483647);
/* 1257 */     this
/*      */       
/* 1259 */       .seasonCardsDisplayTimeInTicks = builder.comment(" The display time in ticks that the season card will be fully rendered.").defineInRange("Season Cards Display Time In Ticks", 40, 0, 2147483647);
/* 1260 */     this
/*      */       
/* 1262 */       .seasonCardsFadeInInTicks = builder.comment(" The fade in time in ticks that the season card will appear.").defineInRange("Season Cards Fade in In Ticks", 20, 0, 2147483647);
/* 1263 */     this
/*      */       
/* 1265 */       .seasonCardsFadeOutInTicks = builder.comment(" The fade out time in ticks that the season card will disappear.").defineInRange("Season Cards Fade Out In Ticks", 20, 0, 2147483647);
/* 1266 */     builder.pop();
/*      */     
/* 1268 */     builder.push("thirst");
/*      */     
/* 1270 */     builder.push("tooltip");
/* 1271 */     this
/*      */       
/* 1273 */       .showHydrationTooltip = builder.comment(" If enabled, show the hydration values in the item tooltip.").define("Show Hydration Tooltip", true);
/* 1274 */     this
/*      */       
/* 1276 */       .mergeHydrationAndSaturationTooltip = builder.comment(" If enabled, show the hydration and the saturation values on the same line in the tooltip.").define("Merge Hydration And Saturation Tooltip", true);
/* 1277 */     builder.pop();
/*      */     
/* 1279 */     this
/*      */       
/* 1281 */       .hydrationSaturationDisplayed = builder.comment(" Whether the Hydration Saturation is displayed or not.").define("Render the hydration saturation", true);
/* 1282 */     this
/*      */       
/* 1284 */       .hydrationExhaustionDisplayed = builder.comment(" Whether the Hydration Exhaustion is displayed or not (grey bar behind the hydration bar).").define("Render the hydration exhaustion", true);
/* 1285 */     this
/*      */       
/* 1287 */       .lowHydrationEffect = builder.comment(" If enabled, player's vision will become blurry when running low on hydration.").define("Low Hydration Effect", true);
/* 1288 */     builder.push("hydration-bar");
/* 1289 */     this
/*      */       
/* 1291 */       .showHydrationBar = builder.comment(" If enabled, the hydration bar will be displayed.").define("Show Hydration Bar", true);
/* 1292 */     this
/*      */       
/* 1294 */       .showDrinkPreview = builder.comment(" If enabled, a preview on hydration bar will be displayed if player holds a drink item.").define("Show Drink Preview", true);
/* 1295 */     this
/*      */       
/* 1297 */       .hydrationBarOffsetX = builder.comment(" How much the hydration bar is moved to the right.").defineInRange("Hydration Bar Offset X", 0, -10000, 10000);
/* 1298 */     this
/*      */       
/* 1300 */       .hydrationBarOffsetY = builder.comment(" How much the hydration bar is moved to the bottom.").defineInRange("Hydration Bar Offset Y", 0, -10000, 10000);
/* 1301 */     builder.pop();
/* 1302 */     builder.pop();
/*      */     
/* 1304 */     builder.push("health-overhaul");
/* 1305 */     this
/*      */ 
/*      */       
/* 1308 */       .appendBrokenShieldHeartsToHealthBar = builder.comment(new String[] { " If enabled, will try to append the broken and shield hearts at the end of the Health Bar.", " A compat is made with overflowing-bars mod." }).define("Append Broken/Shield Hearts To Health Bar", true);
/* 1309 */     builder.pop();
/*      */   }
/*      */ }


/* Location:              D:\minecraft\原版+\.minecraft\mods\【传说生存】legendarysurvivaloverhaul-1.21.1-2.4.2-fixed3.jar!\sfiomn\legendarysurvivaloverhaul\config\Config$Client.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */