package io.github.vampirestudios.molecularcraft.molecules;

import io.github.vampirestudios.molecularcraft.MolecularCraft;
import io.github.vampirestudios.molecularcraft.utils.ItemMoleculeComponment;
import io.github.vampirestudios.molecularcraft.utils.StringHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoleculeStack implements ItemMoleculeComponment {
    private List<Molecule> molecules = new ArrayList<>();
    private int amount;

    public MoleculeStack(int amount, Molecule... molecules) {
        this.amount = amount;
        this.molecules.addAll(Arrays.asList(molecules));
    }

    public MoleculeStack(int amount, List<Molecule> list) {
        this.amount = amount;
        this.molecules = list;
    }

    public MoleculeStack(Molecule... molecules) {
        this.amount = 1;
        this.molecules.addAll(Arrays.asList(molecules));
    }

    public MoleculeStack setAmount(int amount) {
        return new MoleculeStack(amount, this.getMolecules());
    }

    public MoleculeStack multiplyAmountBy(int multiplier) {
        return this.setAmount(this.getAmount() * multiplier);
    }

    public int getAmount() {
        return amount;
    }

    public List<Molecule> getMolecules() {
        return molecules;
    }

    public String getRegistryName() {
        StringBuilder string = new StringBuilder();

        for (Molecule molecule : getMolecules()) {
            string.append(molecule.getAtom().getSymbol());
            if (molecule.getAmount() > 1) {
                string.append(molecule.getAmount());
            }
        }

        return string.toString().toLowerCase();
    }

    @Override
    public Item getItem() {
        return Registry.ITEM.get(new Identifier(MolecularCraft.MODID, this.getRegistryName()));
    }

    @Override
    public ItemStack getItemStack() {
        return new ItemStack(this::getItem, getAmount());
    }

    public String getFormula() {
        StringBuilder string = new StringBuilder();

        for (Molecule molecule : getMolecules()) {
            string.append(molecule.getAtom().getSymbol());
            if (molecule.getAmount() > 1) {
                string.append(molecule.getAmount());
            }
        }

        return StringHelper.subscriptNumbers(string.toString());
    }
}
