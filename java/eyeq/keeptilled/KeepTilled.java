package eyeq.keeptilled;

import eyeq.keeptilled.event.KeepTiledEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static eyeq.keeptilled.KeepTilled.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class KeepTilled {
    public static final String MOD_ID = "eyeq_keeptiled";

    @Mod.Instance(MOD_ID)
    public static KeepTilled instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new KeepTiledEventHandler());
    }
}
