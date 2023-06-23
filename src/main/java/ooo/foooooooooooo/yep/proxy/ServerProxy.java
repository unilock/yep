package ooo.foooooooooooo.yep.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import ooo.foooooooooooo.yep.EventListener;
import ooo.foooooooooooo.yep.Yep;
import ooo.foooooooooooo.yep.compat.ModCompat;

public class ServerProxy implements CommonProxy {
    @Override
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventListener());
        ModCompat.init();

        Yep.LOGGER.info("Yep is enabled!");
    }
}
