package net.swofty.types.generic.item.items.armor.mushroom;

import net.minestom.server.color.Color;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.*;
import net.swofty.commons.statistics.ItemStatistic;
import net.swofty.commons.statistics.ItemStatistics;

public class MushroomChestplate implements CustomSkyBlockItem, NotFinishedYet, Sellable, StandardItem, LeatherColour {
    @Override
    public Color getLeatherColour() {
        return new Color(255, 0, 0);
    }

    @Override
    public double getSellValue() {
        return 16;
    }

    @Override
    public StandardItemType getStandardItemType() {
        return StandardItemType.CHESTPLATE;
    }

    @Override
    public ItemStatistics getStatistics(SkyBlockItem instance) {
        return ItemStatistics.builder()
                .withBase(ItemStatistic.HEALTH, 10D)
                .withBase(ItemStatistic.DEFENSE, 10D)
                .build();
    }
}
