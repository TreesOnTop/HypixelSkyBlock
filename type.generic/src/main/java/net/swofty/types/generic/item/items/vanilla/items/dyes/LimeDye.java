package net.swofty.types.generic.item.items.vanilla.items.dyes;

import net.swofty.types.generic.item.ItemTypeLinker;
import net.swofty.types.generic.item.SkyBlockItem;
import net.swofty.types.generic.item.impl.CustomSkyBlockItem;
import net.swofty.types.generic.item.impl.DefaultCraftable;
import net.swofty.types.generic.item.impl.SkyBlockRecipe;
import net.swofty.types.generic.item.impl.recipes.ShapelessRecipe;
import net.swofty.commons.statistics.ItemStatistics;

public class LimeDye implements CustomSkyBlockItem, DefaultCraftable {
    @Override
    public SkyBlockRecipe<?> getRecipe() {
        return new ShapelessRecipe(SkyBlockRecipe.RecipeType.NONE,
                new SkyBlockItem(ItemTypeLinker.LIME_DYE), 2)
                .add(ItemTypeLinker.CACTUS_GREEN, 1)
                .add(ItemTypeLinker.WHITE_DYE, 1);
    }

    @Override
    public ItemStatistics getStatistics(SkyBlockItem instance) {
        return ItemStatistics.empty();
    }
}
