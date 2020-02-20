package io.github.vampirestudios.molecularcraft.registries;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.recipes.molecularinfo.AbstractMolecularInfoSetter;
import io.github.vampirestudios.molecularcraft.recipes.molecularinfo.CraftingMolecularInfoSetter;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;

public class MolecularInfoSetters {

    public static final SimpleRegistry<AbstractMolecularInfoSetter> REGISTRY =
            Registry.register(Registry.REGISTRIES, new Identifier(MolecularCraft.MODID, "molecularinfosetters"),
                    new SimpleRegistry<AbstractMolecularInfoSetter>());

    public static AbstractMolecularInfoSetter CRAFTING;

    public static void init() {
        CRAFTING = register(new CraftingMolecularInfoSetter(RecipeType.CRAFTING, new Identifier(MolecularCraft.MODID, "crafting")));
    }

    private static AbstractMolecularInfoSetter register(AbstractMolecularInfoSetter abstractMolecularInfoSetter) {
        return Registry.register(REGISTRY, abstractMolecularInfoSetter.getIdentifier(), abstractMolecularInfoSetter);
    }
}