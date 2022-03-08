package ch.landrus.minecraft.tutorialmod.datagen;

import java.io.IOException;

import ch.landrus.minecraft.tutorialmod.TutorialMod;
import static ch.landrus.minecraft.tutorialmod.blocks.PowergenBlock.MESSAGE_POWERGEN;
import static ch.landrus.minecraft.tutorialmod.blocks.PowergenBlock.SCREEN_TUTORIAL_POWERGEN;
import static ch.landrus.minecraft.tutorialmod.setup.ModSetup.TAB_NAME;
import ch.landrus.minecraft.tutorialmod.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraftforge.common.data.LanguageProvider;

public class TutLanguageProvider extends LanguageProvider {

    public TutLanguageProvider(DataGenerator generator, String locale) {
        super(generator, TutorialMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "Tutorial");

        add(MESSAGE_POWERGEN, "Power generator generating %s per tick!");
        add(SCREEN_TUTORIAL_POWERGEN, "Power generator");
        add(Registration.POWERGEN.get(), "Power generator");

        add(Registration.MY_ORE_OVERWORLD.get(), "My ore");
        add(Registration.MY_ORE_NETHER.get(), "My ore");
        add(Registration.MY_ORE_END.get(), "My ore");
        add(Registration.MY_ORE_DEEPSLATE.get(), "My ore");

        add(Registration.RAW_MY_CHUNK.get(), "My Raw Chunk");
        add(Registration.MY_INGOT.get(), "My Ingot");
    }

}
