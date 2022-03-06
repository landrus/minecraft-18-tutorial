package ch.landrus.minecraft.tutorialmod.datagen;

import ch.landrus.minecraft.tutorialmod.TutorialMod;
import ch.landrus.minecraft.tutorialmod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.io.IOException;

public class TutBlockStates extends BlockStateProvider {

    public TutBlockStates(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, TutorialMod.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Registration.MY_ORE_OVERWORLD.get());
        simpleBlock(Registration.MY_ORE_NETHER.get());
        simpleBlock(Registration.MY_ORE_END.get());
        simpleBlock(Registration.MY_ORE_DEEPSLATE.get());
    }

}
