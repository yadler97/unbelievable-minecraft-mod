package com.yannick.unbelievablemod.inventory;

import com.google.common.collect.Lists;
import com.yannick.unbelievablemod.setup.WoodsawingRecipe;
import com.yannick.unbelievablemod.setup.RecipeTypes;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class SawmillMenu extends AbstractContainerMenu {
    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level level;
    private List<WoodsawingRecipe> recipes = Lists.newArrayList();
    private ItemStack input = ItemStack.EMPTY;
    long lastSoundTime;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener = () -> {};
    public final Container container = new SimpleContainer(1) {
        @Override
        public void setChanged() {
            super.setChanged();
            SawmillMenu.this.slotsChanged(this);
            SawmillMenu.this.slotUpdateListener.run();
        }
    };
    final ResultContainer resultContainer = new ResultContainer();

    public SawmillMenu(int windowId, Inventory inventory, final ContainerLevelAccess containerLevelAccess) {
        super(Registration.SAWMILL_MENU.get(), windowId);
        this.access = containerLevelAccess;
        this.level = inventory.player.level;
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            public boolean mayPlace(ItemStack itemStack) {
                return false;
            }

            public void onTake(Player player, ItemStack itemStack) {
                itemStack.onCraftedBy(player.level, player, itemStack.getCount());
                SawmillMenu.this.resultContainer.awardUsedRecipes(player);
                ItemStack itemstack = SawmillMenu.this.inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    SawmillMenu.this.setupResultSlot();
                }

                containerLevelAccess.execute((level, pos) -> {
                    long l = level.getGameTime();
                    if (SawmillMenu.this.lastSoundTime != l) {
                        level.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                        SawmillMenu.this.lastSoundTime = l;
                    }

                });
                super.onTake(player, itemStack);
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<WoodsawingRecipe> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    public boolean stillValid(Player player) {
        return stillValid(this.access, player, Registration.SAWMILL.get());
    }

    public boolean clickMenuButton(Player player, int index) {
        if (this.isValidRecipeIndex(index)) {
            this.selectedRecipeIndex.set(index);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int index) {
        return index >= 0 && index < this.recipes.size();
    }

    public void slotsChanged(Container container) {
        ItemStack itemstack = this.inputSlot.getItem();
        if (!itemstack.is(this.input.getItem())) {
            this.input = itemstack.copy();
            this.setupRecipeList(container, itemstack);
        }

    }

    private void setupRecipeList(Container container, ItemStack itemStack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!itemStack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(RecipeTypes.WOODSAWING, container, this.level);
        }

    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            WoodsawingRecipe woodsawingRecipe = this.recipes.get(this.selectedRecipeIndex.get());
            this.resultContainer.setRecipeUsed(woodsawingRecipe);
            this.resultSlot.set(woodsawingRecipe.assemble(this.container));
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public MenuType<?> getType() {
        return Registration.SAWMILL_MENU.get();
    }

    public void registerUpdateListener(Runnable runnable) {
        this.slotUpdateListener = runnable;
    }

    public boolean canTakeItemForPickAll(ItemStack itemStack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(itemStack, slot);
    }

    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            itemstack = itemstack1.copy();
            if (index == 1) {
                item.onCraftedBy(itemstack1, player.level, player);
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (index == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(RecipeTypes.WOODSAWING, new SimpleContainer(itemstack1), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 29) {
                if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 29 && index < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
            this.broadcastChanges();
        }

        return itemstack;
    }

    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> {
            this.clearContainer(player, this.container);
        });
    }
}
