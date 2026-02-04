package com.corvuvr.cloudpiercer;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.Level;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CloudPiercer.MODID)
public class CloudPiercer
{
    public static final String MODID = "cloudpiercer";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CloudPiercer(FMLJavaModLoadingContext context)
    {
        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    public static float getRainIntensity(Level level, float intensity) {

        Minecraft mc = Minecraft.getInstance();
        if (level.isClientSide() && 
            mc.getCameraEntity() != null &&
            level instanceof ClientLevel clientLevel)
        {
            double cloudThickness = 3.0F;
            double cloudY = clientLevel.effects().getCloudHeight();
            double playerY = mc.player.getEyeY();

            return (float)(
                (playerY > cloudY + cloudThickness) ? 0.0F :
                (playerY > cloudY) ? intensity * (cloudThickness + cloudY - playerY) / cloudThickness : 
                intensity
            );
        }
        
        return intensity;
    }
}
