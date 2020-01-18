package io.github.vampirestudios.molecularcraft.enums;

import io.github.vampirestudios.molecularcraft.molecules.Molecule;
import io.github.vampirestudios.molecularcraft.molecules.MoleculeStack;
import io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MoleculeAmount;

import java.util.*;

import static io.github.vampirestudios.molecularcraft.enums.Molecules.*;
import static io.github.vampirestudios.molecularcraft.enums.MoleculesAmountHelper.MetalOres.*;
import static io.github.vampirestudios.molecularcraft.enums.Atoms.*;

public class ItemMolecules {

    public static List<ItemMolecules> registry = new ArrayList<>();

    private String id;
    private List<MoleculeStack> list;

    public ItemMolecules(String id, MoleculeStack... stack) {
        this.id = id;
        this.list = Arrays.asList(stack);
        registry.add(this);
    }

    public String getId() {
        return id;
    }

    public List<MoleculeStack> getList() {
        return list;
    }

    public static void init() {
        new ItemMolecules("minecraft:water_bucket",
                water.setAmount(16),
                new MoleculeStack(new MoleculeAmount(3, INGOT), ironMolecule)
        );

        new ItemMolecules("minecraft:bucket",
                new MoleculeStack(new MoleculeAmount(3, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_ingot",
                new MoleculeStack(INGOT, ironMolecule));

        new ItemMolecules("minecraft:iron_nugget",
                new MoleculeStack(NUGGET, ironMolecule));

        new ItemMolecules("minecraft:iron_block",
                new MoleculeStack(BLOCK, ironMolecule));

        new ItemMolecules("minecraft:iron_helmet",
                new MoleculeStack(new MoleculeAmount(5, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_chestplate",
                new MoleculeStack(new MoleculeAmount(8, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_leggings",
                new MoleculeStack(new MoleculeAmount(7, INGOT), ironMolecule));

        new ItemMolecules("minecraft:cauldron",
                new MoleculeStack(new MoleculeAmount(7, INGOT), ironMolecule));

        new ItemMolecules("minecraft:minecart",
                new MoleculeStack(new MoleculeAmount(5, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_boots",
                new MoleculeStack(new MoleculeAmount(4, INGOT), ironMolecule));

        new ItemMolecules("minecraft:heavy_weighted_pressure_plate",
                new MoleculeStack(new MoleculeAmount(2, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_bars",
                new MoleculeStack(new MoleculeAmount(6, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_door",
                new MoleculeStack(new MoleculeAmount(6, INGOT), ironMolecule));

        new ItemMolecules("minecraft:iron_trapdoor",
                new MoleculeStack(new MoleculeAmount(4, INGOT), ironMolecule));

    }
}