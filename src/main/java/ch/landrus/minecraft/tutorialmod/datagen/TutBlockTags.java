package ch.landrus.minecraft.tutorialmod.datagen;

import java.io.IOException;

import ch.landrus.minecraft.tutorialmod.TutorialMod;
import ch.landrus.minecraft.tutorialmod.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutBlockTags extends BlockTagsProvider {

    public TutBlockTags(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(Registration.POWERGEN.get()).add(Registration.MY_ORE_OVERWORLD.get())
            .add(Registration.MY_ORE_NETHER.get()).add(Registration.MY_ORE_END.get()).add(Registration.MY_ORE_DEEPSLATE
                .get());
        tag(BlockTags.NEEDS_IRON_TOOL).add(Registration.POWERGEN.get()).add(Registration.MY_ORE_OVERWORLD.get()).add(
            Registration.MY_ORE_NETHER.get()).add(Registration.MY_ORE_END.get()).add(Registration.MY_ORE_DEEPSLATE
                .get());
        tag(Tags.Blocks.ORES).add(Registration.MY_ORE_OVERWORLD.get()).add(Registration.MY_ORE_NETHER.get()).add(
            Registration.MY_ORE_END.get()).add(Registration.MY_ORE_DEEPSLATE.get());
        tag(Registration.MY_ORE).add(Registration.MY_ORE_OVERWORLD.get()).add(Registration.MY_ORE_NETHER.get()).add(
            Registration.MY_ORE_END.get()).add(Registration.MY_ORE_DEEPSLATE.get());
    }

    @Override
    public String getName() {
        return "Tutorial Tags";
    }
}
