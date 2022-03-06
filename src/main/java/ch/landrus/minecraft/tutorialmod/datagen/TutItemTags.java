package ch.landrus.minecraft.tutorialmod.datagen;

import ch.landrus.minecraft.tutorialmod.TutorialMod;
import ch.landrus.minecraft.tutorialmod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.io.IOException;

public class TutItemTags extends ItemTagsProvider {

    public TutItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(generator, blockTags, TutorialMod.MOD_ID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(Registration.MY_ORE_OVERWORLD_ITEM.get())
                .add(Registration.MY_ORE_NETHER_ITEM.get())
                .add(Registration.MY_ORE_END_ITEM.get())
                .add(Registration.MY_ORE_DEEPSLATE_ITEM.get());
        tag(Tags.Items.INGOTS)
                .add(Registration.MY_INGOT.get());
        tag(Registration.MY_ORE_ITEM)
                .add(Registration.MY_ORE_OVERWORLD_ITEM.get())
                .add(Registration.MY_ORE_NETHER_ITEM.get())
                .add(Registration.MY_ORE_END_ITEM.get())
                .add(Registration.MY_ORE_DEEPSLATE_ITEM.get());
    }

    @Override
    public String getName() {
        return "Tutorial Tags";
    }

}
