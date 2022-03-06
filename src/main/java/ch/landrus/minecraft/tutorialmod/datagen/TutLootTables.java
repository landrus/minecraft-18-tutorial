package ch.landrus.minecraft.tutorialmod.datagen;

import ch.landrus.minecraft.tutorialmod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;

import java.io.IOException;

public class TutLootTables extends BaseLootTableProvider {

    public TutLootTables(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addTables() {
        lootTables.put(Registration.MY_ORE_OVERWORLD.get(),
                createSilkTouchTable("my_ore_overworld", Registration.MY_ORE_OVERWORLD.get(),
                    Registration.RAW_MY_CHUNK.get(), 1, 3));
        lootTables.put(Registration.MY_ORE_NETHER.get(),
                createSilkTouchTable("my_ore_overworld", Registration.MY_ORE_NETHER.get(),
                        Registration.RAW_MY_CHUNK.get(), 1, 3));
        lootTables.put(Registration.MY_ORE_END.get(),
                createSilkTouchTable("my_ore_overworld", Registration.MY_ORE_END.get(),
                        Registration.RAW_MY_CHUNK.get(), 1, 3));
        lootTables.put(Registration.MY_ORE_DEEPSLATE.get(),
                createSilkTouchTable("my_ore_overworld", Registration.MY_ORE_DEEPSLATE.get(),
                        Registration.RAW_MY_CHUNK.get(), 1, 3));
    }

}
