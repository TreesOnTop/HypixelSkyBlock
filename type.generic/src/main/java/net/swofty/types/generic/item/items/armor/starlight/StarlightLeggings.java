package net.swofty.types.generic.item.items.armor.starlight;

import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.CustomSkyBlockItem;
import net.swofty.types.generic.item.impl.Sellable;
import net.swofty.types.generic.item.impl.StandardItem;
import net.swofty.commons.statistics.ItemStatistic;
import net.swofty.commons.statistics.ItemStatistics;

public class StarlightLeggings implements CustomSkyBlockItem, StandardItem, Sellable {
    @Override
    public double getSellValue() {
        return 22500;
    }

    @Override
    public StandardItemType getStandardItemType() {
        return StandardItemType.LEGGINGS;
    }

    @Override
    public ItemStatistics getStatistics(SkyBlockItem instance) {
        return ItemStatistics.builder()
                .withBase(ItemStatistic.HEALTH, 30D)
                .withBase(ItemStatistic.DEFENSE, 30D)
                .withBase(ItemStatistic.INTELLIGENCE, 50D)
                .build();
    }
}
