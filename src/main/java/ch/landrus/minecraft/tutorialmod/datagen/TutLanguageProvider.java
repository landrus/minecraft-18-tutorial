package ch.landrus.minecraft.tutorialmod.datagen;

import ch.landrus.minecraft.tutorialmod.TutorialMod;
import ch.landrus.minecraft.tutorialmod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraftforge.common.data.LanguageProvider;

import java.io.IOException;

import static ch.landrus.minecraft.tutorialmod.setup.ModSetup.TAB_NAME;

public class TutLanguageProvider extends LanguageProvider {

    public TutLanguageProvider(DataGenerator generator, String locale) {
        super(generator, TutorialMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "Tutorial");

        add(Registration.MY_ORE_OVERWORLD.get(), "My ore");
        add(Registration.MY_ORE_NETHER.get(), "My ore");
        add(Registration.MY_ORE_END.get(), "My ore");
        add(Registration.MY_ORE_DEEPSLATE.get(), "My ore");
    }

}
