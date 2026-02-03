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
        
        double playerY = 0; 
        double cloudY = 0;
        double cloudThickness = 3.0F;

        Minecraft mc = Minecraft.getInstance();

        if (level.isClientSide() && mc.getCameraEntity() != null) 
        {
            if (level instanceof ClientLevel clientLevel)
            {
                cloudY = clientLevel.effects().getCloudHeight() + cloudThickness;
            }
            
            playerY = mc.player.getEyeY();

            LOGGER.info(String.format("HELLO playerY: %.02f", playerY));
            LOGGER.info(String.format("HELLO cloudY: %.02f", cloudY));
        }
        else
        {
            // ...
        }

        return (playerY < cloudY) ? intensity : 0.0F;
    }
}
