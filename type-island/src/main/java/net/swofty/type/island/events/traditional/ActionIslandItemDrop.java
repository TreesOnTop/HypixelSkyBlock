package net.swofty.type.island.events.traditional;

import net.minestom.server.coordinate.Pos;
import net.minestom.server.event.Event;
import net.minestom.server.event.player.PlayerBlockBreakEvent;
import net.minestom.server.instance.block.Block;
import net.minestom.server.item.Material;
import net.swofty.types.generic.entity.DroppedItemEntityImpl;
import net.swofty.types.generic.event.EventNodes;
import net.swofty.types.generic.event.SkyBlockEventClass;
import net.swofty.types.generic.event.SkyBlockEventHandler;
import net.swofty.types.generic.item.ItemDropChanger;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.user.SkyBlockPlayer;
import net.swofty.types.generic.event.SkyBlockEvent;
import net.swofty.types.generic.event.custom.CustomBlockBreakEvent;

public class ActionIslandItemDrop implements SkyBlockEventClass {


    @SkyBlockEvent(node = EventNodes.PLAYER , requireDataLoaded = false)
    public void run(PlayerBlockBreakEvent playerBreakEvent) {
        final SkyBlockPlayer player = (SkyBlockPlayer) playerBreakEvent.getPlayer();

        Block block = playerBreakEvent.getBlock();
        Material material = Material.fromNamespaceId(block.name());

        if (material == null) return;

        SkyBlockItem item;
        if (ItemDropChanger.get(material) != null) {
            item = ItemDropChanger.get(material).getItemSupplier().get();
        } else {
            item = new SkyBlockItem(material);
        }

        SkyBlockEventHandler.callSkyBlockEvent(new CustomBlockBreakEvent(
                player, item.getMaterial(), playerBreakEvent.getBlockPosition()
        ));

        /**
         * Handle block dropping
         */

        if (playerBreakEvent.getResultBlock().name().equals("minecraft:air")) return;

        DroppedItemEntityImpl droppedItem = new DroppedItemEntityImpl(item, player);
        Pos pos = Pos.fromPoint(playerBreakEvent.getBlockPosition());
        // Move the dropped item to the center of the block
        pos = pos.add(0.5, 0.5, 0.5);
        // Move block closer to player by 0.5 blocks
        Pos playerPos = player.getPosition().add(0, 0.5, 0);
        double x = playerPos.x() - pos.x();
        double y = playerPos.y() - pos.y();
        double z = playerPos.z() - pos.z();
        double distance = Math.sqrt(x * x + y * y + z * z);
        double multiplier = 1.2 / distance;
        pos = pos.add(x * multiplier, y * multiplier * 3, z * multiplier);

        droppedItem.setInstance(player.getInstance(), pos);
        droppedItem.addViewer(player);
    }
}
