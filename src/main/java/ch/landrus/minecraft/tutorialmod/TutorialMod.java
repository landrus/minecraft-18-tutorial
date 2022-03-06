package ch.landrus.minecraft.tutorialmod;

import ch.landrus.minecraft.tutorialmod.setup.ClientSetup;
import ch.landrus.minecraft.tutorialmod.setup.ModSetup;
import ch.landrus.minecraft.tutorialmod.setup.Registration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {

    public static final String MOD_ID = "tutorialmod";
    private static final Logger LOGGER = LogManager.getLogger();

    public TutorialMod() {
        Registration.init();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(ModSetup::setup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(ClientSetup::init));
    }

}
