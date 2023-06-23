package ooo.foooooooooooo.yep;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.Achievement;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AchievementEvent;
import ooo.foooooooooooo.yep.messages.AdvancementMessage;
import ooo.foooooooooooo.yep.messages.DeathMessage;

public class EventListener {
    @SubscribeEvent
    public void onDeathEvent(LivingDeathEvent event) {
        if (event.entityLiving instanceof EntityPlayerMP player) {
            var username = player.getCommandSenderName();
            // func_151519_b() = get death message from source
            var message = getComponentText(event.source.func_151519_b(player)).replace(username + " ", "");

            PluginMessenger.sendMessage(player, new DeathMessage(message));
        }
    }

    @SubscribeEvent
    public void onAchievementEvent(AchievementEvent event) {
        Achievement achievement = event.achievement;
        EntityPlayerMP player = (EntityPlayerMP) event.entityPlayer;

        // if ("announce-player-achievements" == true)
        if (player.mcServer.func_147136_ar()) {
            // if (player can unlock achievement (i.e. prereqs are met) && player does NOT already have achievement)
            if (player.func_147099_x().canUnlockAchievement(achievement) && !player.func_147099_x().hasAchievementUnlocked(achievement)) {
                var title = StatCollector.translateToLocal(achievement.statId);
                var description = StatCollector.translateToLocal(achievement.statId + ".desc");

                if (achievement.statId.equals("achievement.openInventory")) {
                    description = description.replace("%1$s", "E");
                }

                PluginMessenger.sendMessage(player, new AdvancementMessage(title, description));
            }
        }
    }

    private static String getComponentText(IChatComponent component) {
        return component.getUnformattedText();
    }
}
