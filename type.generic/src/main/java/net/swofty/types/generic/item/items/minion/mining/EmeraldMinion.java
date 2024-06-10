package net.swofty.types.generic.item.items.minion.mining;

import net.swofty.types.generic.item.ItemTypeLinker;
import net.swofty.types.generic.item.impl.CustomSkyBlockItem;
import net.swofty.types.generic.item.impl.Minion;
import net.swofty.types.generic.minion.MinionRegistry;

public class EmeraldMinion implements CustomSkyBlockItem, Minion {
    @Override
    public MinionRegistry getMinionRegistry() {
        return MinionRegistry.EMERALD;
    }

    @Override
    public ItemTypeLinker getBaseCraftMaterial() {
        return ItemTypeLinker.EMERALD;
    }

    @Override
    public ItemTypeLinker getEnchantedCraftMaterial() {
        return ItemTypeLinker.ENCHANTED_EMERALD_BLOCK;
    }

    @Override
    public ItemTypeLinker getFirstBaseItem() {
        return ItemTypeLinker.WOODEN_PICKAXE;
    }

    @Override
    public boolean isByDefaultCraftable() {
        return false;
    }

}
