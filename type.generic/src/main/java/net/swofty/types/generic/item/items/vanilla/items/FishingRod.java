package net.swofty.types.generic.item.items.vanilla.items;

import net.swofty.types.generic.item.ItemTypeLinker;
import net.swofty.types.generic.item.MaterialQuantifiable;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.CustomSkyBlockItem;
import net.swofty.types.generic.item.impl.DefaultCraftable;
import net.swofty.types.generic.item.impl.SkyBlockRecipe;
import net.swofty.types.generic.item.impl.recipes.ShapedRecipe;
import net.swofty.commons.statistics.ItemStatistic;
import net.swofty.commons.statistics.ItemStatistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FishingRod implements CustomSkyBlockItem, DefaultCraftable {
    @Override
    public ItemStatistics getStatistics(SkyBlockItem instance) {
        return ItemStatistics.builder()
                .withBase(ItemStatistic.DAMAGE, 10D)
                .withBase(ItemStatistic.STRENGTH, 5D)
                .build();
    }

    @Override
    public SkyBlockRecipe<?> getRecipe() {
        Map<Character, MaterialQuantifiable> ingredientMap = new HashMap<>();
        ingredientMap.put('A', new MaterialQuantifiable(ItemTypeLinker.STICK, 1));
        ingredientMap.put('B', new MaterialQuantifiable(ItemTypeLinker.STRING, 1));
        ingredientMap.put(' ', new MaterialQuantifiable(ItemTypeLinker.AIR, 1));
        List<String> pattern = List.of(
                "  A",
                " AB",
                "A B");
        return new ShapedRecipe(SkyBlockRecipe.RecipeType.NONE, new SkyBlockItem(ItemTypeLinker.FISHING_ROD), ingredientMap, pattern);
    }
}
