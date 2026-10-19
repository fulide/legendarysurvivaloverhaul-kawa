package sfiomn.legendarysurvivaloverhaul.client.shaders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import sfiomn.legendarysurvivaloverhaul.LegendarySurvivalOverhaul;

/**
 * Thirst / low-hydration vision blur.
 *
 * 1.20.1 simply reused the vanilla chain {@code minecraft:shaders/post/blobs2.json}, which existed
 * up to 1.20.1 and was removed in 1.21.  A vanilla 1.21 "blur" chain is a completely different
 * effect (six box-blur passes), so it cannot be used as a drop-in replacement.
 *
 * This implementation ships the 1.20.1 chain with the mod:
 * <ul>
 *   <li>post chain: {@code legendarysurvivaloverhaul:shaders/post/blobs2.json}</li>
 *   <li>programs: {@code minecraft:shaders/program/blobs2.json}, {@code blobs2.fsh}, {@code blobs.vsh}</li>
 * </ul>
 * The program JSONs have to live in the {@code minecraft} namespace because 1.21.1
 * {@link net.minecraft.client.renderer.EffectInstance} resolves the program path with
 * {@code ResourceLocation.withDefaultNamespace(...)}; the pass name is reduced to its path, so a
 * mod namespace is silently ignored there.
 *
 * The {@code Radius} uniform is refreshed every frame with the 0..4 hydration intensity, exactly
 * like 1.20.1 did through reflection.
 */
public class FocusShader
{
    public static final ResourceLocation BLOBS2_SHADER =
            ResourceLocation.fromNamespaceAndPath(LegendarySurvivalOverhaul.MOD_ID, "shaders/post/blobs2.json");
    public static final ResourceLocation FALLBACK_BLUR_SHADER =
            ResourceLocation.withDefaultNamespace("shaders/post/blur.json");

    private static boolean blobs2Unavailable = false;
    private static boolean fallbackLogged = false;

    public FocusShader() {}

    public void render(float intensity)
    {
        if (intensity <= 0.0F)
            return;

        Minecraft mc = Minecraft.getInstance();

        ResourceLocation wanted = blobs2Unavailable ? FALLBACK_BLUR_SHADER : BLOBS2_SHADER;
        PostChain currentEffect = mc.gameRenderer.currentEffect();

        if (currentEffect == null || !wanted.toString().equals(currentEffect.getName()))
        {
            mc.gameRenderer.loadEffect(wanted);
            currentEffect = mc.gameRenderer.currentEffect();

            // GameRenderer#loadEffect swallows loading errors (it only logs them), so a null effect is
            // the failure signal.  Latch the failure once to avoid retrying a missing chain every frame.
            if (currentEffect == null && !blobs2Unavailable)
            {
                blobs2Unavailable = true;
                wanted = FALLBACK_BLUR_SHADER;
                mc.gameRenderer.loadEffect(wanted);
                currentEffect = mc.gameRenderer.currentEffect();

                if (!fallbackLogged)
                {
                    fallbackLogged = true;
                    LegendarySurvivalOverhaul.LOGGER.warn(
                            "Thirst blur: {} could not be loaded, falling back to {} (the result will not match 1.20.1)",
                            BLOBS2_SHADER, wanted);
                }
            }

            if (currentEffect == null || !wanted.toString().equals(currentEffect.getName()))
                return;
        }

        updateIntensity(intensity);
    }

    public void stopRender()
    {
        Minecraft mc = Minecraft.getInstance();
        PostChain currentEffect = mc.gameRenderer.currentEffect();
        if (currentEffect == null)
            return;

        String name = currentEffect.getName();
        if (BLOBS2_SHADER.toString().equals(name) || FALLBACK_BLUR_SHADER.toString().equals(name))
            mc.gameRenderer.shutdownEffect();
    }

    @OnlyIn(Dist.CLIENT)
    public void updateIntensity(float intensity)
    {
        PostChain currentEffect = Minecraft.getInstance().gameRenderer.currentEffect();
        if (currentEffect != null)
            currentEffect.setUniform("Radius", intensity);
    }
}
