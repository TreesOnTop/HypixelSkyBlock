package net.swofty.types.generic.item.items.vanilla.items.armor;

import net.swofty.types.generic.item.ItemTypeLinker;
import net.swofty.types.generic.item.MaterialQuantifiable;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.CustomSkyBlockItem;
import net.swofty.types.generic.item.impl.DefaultCraftable;
import net.swofty.types.generic.item.impl.SkyBlockRecipe;
import net.swofty.types.generic.item.impl.StandardItem;
import net.swofty.types.generic.item.impl.recipes.ShapedRecipe;
import net.swofty.commons.statistics.ItemStatistic;
import net.swofty.commons.statistics.ItemStatistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IronBoots implements CustomSkyBlockItem, StandardItem, DefaultCraftable {
    @Override
    public ItemStatistics getStatistics(SkyBlockItem instance) {
        return ItemStatistics.builder()
                .withBase(ItemStatistic.HEALTH, 15D)
                .withBase(ItemStatistic.DEFENSE, 10D)
                .build();
    }

    @Override
    public StandardItemType getStandardItemType() {
        return StandardItemType.BOOTS;
    }

    @Override
    public SkyBlockRecipe<?> getRecipe() {
        Map<Character, MaterialQuantifiable> ingredientMap = new HashMap<>();
        ingredientMap.put('A', new MaterialQuantifiable(ItemTypeLinker.IRON_INGOT, 1));
        ingredientMap.put(' ', new MaterialQuantifiable(ItemTypeLinker.AIR, 1));
        List<String> pattern = List.of(
                "A A",
                "A A");

        return new ShapedRecipe(SkyBlockRecipe.RecipeType.NONE, new SkyBlockItem(ItemTypeLinker.IRON_BOOTS), ingredientMap, pattern);
    }
}
