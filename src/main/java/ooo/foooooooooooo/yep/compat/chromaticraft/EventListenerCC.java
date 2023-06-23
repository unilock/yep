package ooo.foooooooooooo.yep.compat.chromaticraft;

import Reika.ChromatiCraft.API.Event.ProgressionEvent;
import Reika.ChromatiCraft.Magic.Progression.ProgressStage;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import ooo.foooooooooooo.yep.PluginMessenger;
import ooo.foooooooooooo.yep.Yep;
import ooo.foooooooooooo.yep.compat.chromaticraft.messages.ProgressionMessage;

public class EventListenerCC {
    @SubscribeEvent
    public void onCCProgressionEvent(ProgressionEvent event) {
        if (event.entityPlayer instanceof EntityPlayerMP player && event.type == ProgressionEvent.ResearchType.PROGRESS) {
            ProgressStage stage;

            try {
                stage = ProgressStage.valueOf(event.researchKey);
            } catch (IllegalArgumentException e) {
                Yep.LOGGER.trace("CC: Ignoring non-stage progression");
                return;
            }

            // note: it's possible to get the stage description via "stage.getShortDesc()", but it's often somewhat spoilery, and isn't displayed in chat anyway
            if (stage.getShareability() == ProgressStage.Shareability.ALWAYS || stage.getShareability() == ProgressStage.Shareability.PROXIMITY) {
                PluginMessenger.sendMessage(player, new ProgressionMessage(stage.getTitle()));
            } else {
                Yep.LOGGER.trace("CC: Ignoring non-shareable progression");
            }
        }
    }
}
