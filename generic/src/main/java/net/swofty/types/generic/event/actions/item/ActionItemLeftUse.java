package net.swofty.types.generic.event.actions.item;

import lombok.SneakyThrows;
import net.minestom.server.event.Event;
import net.minestom.server.event.player.PlayerHandAnimationEvent;
import net.minestom.server.item.ItemStack;
import net.swofty.types.generic.event.EventNodes;
import net.swofty.types.generic.event.SkyBlockEventClass;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.Interactable;
import net.swofty.types.generic.user.SkyBlockPlayer;
import net.swofty.types.generic.event.SkyBlockEvent;

public class ActionItemLeftUse implements SkyBlockEventClass {

    @SneakyThrows
    @SkyBlockEvent(node = EventNodes.PLAYER , requireDataLoaded = true)
    public void run(PlayerHandAnimationEvent event) {
        ItemStack itemStack = event.getPlayer().getItemInMainHand();
        SkyBlockItem item = new SkyBlockItem(itemStack);
        SkyBlockPlayer player = (SkyBlockPlayer) event.getPlayer();

        if (item.getGenericInstance() != null && item.getGenericInstance() instanceof Interactable interactable) {
            interactable.onLeftInteract(player, item);
        }
    }
}
