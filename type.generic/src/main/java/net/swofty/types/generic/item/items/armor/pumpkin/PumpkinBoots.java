package net.swofty.types.generic.item.items.armor.pumpkin;

import net.minestom.server.color.Color;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.*;
import net.swofty.commons.statistics.ItemStatistic;
import net.swofty.commons.statistics.ItemStatistics;

public class PumpkinBoots implements CustomSkyBlockItem, StandardItem, LeatherColour, Sellable, NotFinishedYet {
    @Override
    public Color getLeatherColour() {
        return new Color(237, 170, 54);
    }

    @Override
    public double getSellValue() {
        return 8;
    }

    @Override
    public StandardItemType getStandardItemType() {
        return StandardItemType.BOOTS;
    }

    @Override
    public ItemStatistics getStatistics(SkyBlockItem instance) {
        return ItemStatistics.builder()
                .withBase(ItemStatistic.DEFENSE, 8D)
                .withBase(ItemStatistic.HEALTH, 8D)
                .build();
    }
}
