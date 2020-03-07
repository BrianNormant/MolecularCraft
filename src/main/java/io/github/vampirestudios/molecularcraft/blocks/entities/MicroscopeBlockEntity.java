package io.github.vampirestudios.molecularcraft.blocks.entities;

import io.github.vampirestudios.molecularcraft.recipes.DisassemblerRecipeManager;
import io.github.vampirestudios.molecularcraft.registries.ModBlockEntities;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import spinnery.common.BaseInventory;
import spinnery.util.InventoryUtilities;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

public class MicroscopeBlockEntity extends BlockEntity implements Tickable, EnergyStorage, BlockEntityClientSerializable {
    private double energy;
    public BaseInventory inventory = new BaseInventory(2);

    public MicroscopeBlockEntity() {
        super(ModBlockEntities.microscopeBlockEntityBlockEntityType);
        this.energy = 20_000;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        InventoryUtilities.write(this.inventory, tag);
        tag.putDouble("energy", this.getStored(EnergySide.UNKNOWN));
        return super.toTag(tag);
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        inventory = new BaseInventory(2);
        InventoryUtilities.read(inventory, tag);
        this.setStored(tag.getDouble("energy"));
    }

    @Override
    public void tick() {

    }

    @Override
    public World getWorld() {
        return super.getWorld();
    }

    @Override
    public double getStored(EnergySide face) {
        return this.energy;
    }

    @Override
    public void setStored(double amount) {
        this.energy = amount;
    }

    @Override
    public double getMaxStoredPower() {
        return 50_000;
    }

    @Override
    public EnergyTier getTier() {
        return EnergyTier.HIGH;
    }

    @Override
    public double getMaxInput(EnergySide side) {
        return 512;
    }

    @Override
    public double getMaxOutput(EnergySide side) {
        return 0;
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        super.fromTag(tag);
        inventory = new BaseInventory(2);
        InventoryUtilities.read(inventory, tag);
        this.setStored(tag.getDouble("energy"));

    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        InventoryUtilities.write(this.inventory, tag);
        tag.putDouble("energy", this.getStored(EnergySide.UNKNOWN));
        return super.toTag(tag);
    }

    public int getInvSize() {
        return this.inventory.getInvSize();
    }


    public ItemStack getInvStack(int k) {
        return this.inventory.getInvStack(k);
    }


    public void setInvStack(int k, ItemStack itemStack) {
        this.inventory.setInvStack(k, itemStack);
    }

    public boolean canInsertInvStack(int slot, ItemStack stack, Direction dir) {
        return slot != 3;
    }

    public boolean canExtractInvStack(int slot, ItemStack stack, Direction dir) {
        return slot == 3;
    }
}