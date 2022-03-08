package ch.landrus.minecraft.tutorialmod.datagen;

import java.io.IOException;

import ch.landrus.minecraft.tutorialmod.TutorialMod;
import ch.landrus.minecraft.tutorialmod.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TutItemModels extends ItemModelProvider {

    public TutItemModels(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, TutorialMod.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(Registration.MY_ORE_OVERWORLD_ITEM.get().getRegistryName().getPath(),
            modLoc("block/my_ore_overworld"));
        withExistingParent(Registration.MY_ORE_NETHER_ITEM.get().getRegistryName().getPath(),
            modLoc("block/my_ore_nether"));
        withExistingParent(Registration.MY_ORE_END_ITEM.get().getRegistryName().getPath(), modLoc("block/my_ore_end"));
        withExistingParent(Registration.MY_ORE_DEEPSLATE_ITEM.get().getRegistryName().getPath(),
            modLoc("block/my_ore_deepslate"));

        withExistingParent(Registration.POWERGEN_ITEM.get().getRegistryName().getPath(), modLoc("block/powergen/main"));

        singleTexture(Registration.RAW_MY_CHUNK.get().getRegistryName().getPath(),
            mcLoc("item/generated"),
            "layer0", modLoc("item/raw_my_chunk"));
        singleTexture(Registration.MY_INGOT.get().getRegistryName().getPath(),
            mcLoc("item/generated"),
            "layer0", modLoc("item/my_ingot"));
    }

}
