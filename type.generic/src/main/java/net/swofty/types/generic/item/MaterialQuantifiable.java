package net.swofty.types.generic.item;

import com.mongodb.annotations.Immutable;
import lombok.Getter;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import net.swofty.commons.item.ItemType;

@Immutable
@Getter
public class MaterialQuantifiable {
    private ItemType material;
    private int amount;

    public MaterialQuantifiable(ItemType material, int amount) {
        this.material = material;
        this.amount = amount;
    }

    public MaterialQuantifiable(ItemTypeLinker material, int amount) {
        this(material.type, amount);
    }

    public MaterialQuantifiable(ItemTypeLinker material) {
        this(material, 1);
    }

    public MaterialQuantifiable(MaterialQuantifiable materialQuantifiable) {
        this(materialQuantifiable.material, materialQuantifiable.amount);
    }

    public MaterialQuantifiable setMaterial(ItemTypeLinker material) {
        return setMaterial(material.type);
    }

    public MaterialQuantifiable setMaterial(ItemType material) {
        this.material = material;
        return this;
    }

    public MaterialQuantifiable setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MaterialQuantifiable potentialMaterial)) return false;
        return potentialMaterial.material == this.material && potentialMaterial.amount == this.amount;
    }

    public boolean matches(ItemTypeLinker material) {
        return this.material == material.type;
    }

    public boolean matches(ItemType material) {
        return this.material == material;
    }

    public MaterialQuantifiable clone() {
        return new MaterialQuantifiable(material, amount);
    }

    public SkyBlockItem toSkyBlockItem() {
        return new SkyBlockItem(material, amount);
    }

    public String toString() {
        return "MQ{material=" + (material != null ? material.name() : "?")
                + ", amount=" + amount + "}";
    }

    public static MaterialQuantifiable of(ItemStack stack) {
        if (stack == null || stack.material() == Material.AIR)
            return new MaterialQuantifiable(ItemType.AIR, (stack != null ? stack.amount() : 1));
        SkyBlockItem found = new SkyBlockItem(stack);
        return new MaterialQuantifiable(found.getAttributeHandler().getPotentialClassLinker(), stack.amount());
    }

    public static MaterialQuantifiable[] of(ItemStack[] stacks) {
        MaterialQuantifiable[] materials = new MaterialQuantifiable[stacks.length];
        for (int i = 0; i < stacks.length; i++)
            materials[i] = of(stacks[i]);
        return materials;
    }

    public static MaterialQuantifiable one(ItemTypeLinker type) {
        return new MaterialQuantifiable(type, 1);
    }
}