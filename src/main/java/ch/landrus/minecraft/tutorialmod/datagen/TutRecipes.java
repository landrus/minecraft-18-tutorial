package ch.landrus.minecraft.tutorialmod.datagen;

import java.io.IOException;
import java.util.function.Consumer;

import ch.landrus.minecraft.tutorialmod.setup.Registration;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

public class TutRecipes extends RecipeProvider {

    public TutRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(Registration.POWERGEN.get()).pattern("mmm").pattern("x#x").pattern("#x#").define('x',
            Tags.Items.DUSTS_REDSTONE).define('#', Tags.Items.INGOTS_IRON).define('m', Registration.MY_INGOT.get())
            .group("tutorial").unlockedBy("mysterious",
            InventoryChangeTrigger.TriggerInstance.hasItems(Registration.MY_INGOT.get())).save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.MY_ORE_ITEM),
            Registration.MY_INGOT.get(), 1, 100).unlockedBy("has_ore", has(Registration.MY_ORE_ITEM)).save(consumer,
            "my_ingot_1");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_MY_CHUNK.get()),
            Registration.MY_INGOT.get(), 0, 100).unlockedBy("has_chunk", has(Registration.RAW_MY_CHUNK.get())).save(
            consumer, "my_ingot_2");
    }

}
