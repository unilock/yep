package ooo.foooooooooooo.yep.compat;

import cpw.mods.fml.common.Loader;
import net.minecraftforge.common.MinecraftForge;
import ooo.foooooooooooo.yep.Yep;
import ooo.foooooooooooo.yep.compat.chromaticraft.EventListenerCC;

public class ModCompat {
    public static void init() {
        if (Loader.isModLoaded("ChromatiCraft")) {
            Yep.LOGGER.info("ChromatiCraft detected - loading support");
            MinecraftForge.EVENT_BUS.register(new EventListenerCC());
        }
    }
}
