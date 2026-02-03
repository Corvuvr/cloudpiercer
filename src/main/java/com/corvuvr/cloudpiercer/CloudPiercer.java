package com.corvuvr.cloudpiercer;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
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

    // Unused yet
    public static float getRainIntensity(Level level, Player player, float intensity) {
        
        double playerY = 0; 
        double cloudY = 0;

        if (level.isClientSide()) 
        {
            playerY = player.getY();
        } 

        LOGGER.info(String.format("HELLO playerY: %.02f", playerY));
        LOGGER.info(String.format("HELLO cloudY: %.02f", cloudY));

        return intensity;
    }
}
