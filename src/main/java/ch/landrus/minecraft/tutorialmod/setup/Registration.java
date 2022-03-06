package ch.landrus.minecraft.tutorialmod.setup;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static ch.landrus.minecraft.tutorialmod.TutorialMod.MOD_ID;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }

    public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    public static final RegistryObject<Block> MY_ORE_OVERWORLD = BLOCKS.register("my_ore_overworld", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MY_ORE_OVERWORLD_ITEM = fromBlock(MY_ORE_OVERWORLD);
    public static final RegistryObject<Block> MY_ORE_NETHER = BLOCKS.register("my_ore_nether", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MY_ORE_NETHER_ITEM = fromBlock(MY_ORE_NETHER);
    public static final RegistryObject<Block> MY_ORE_END = BLOCKS.register("my_ore_end", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MY_ORE_END_ITEM = fromBlock(MY_ORE_END);
    public static final RegistryObject<Block> MY_ORE_DEEPSLATE = BLOCKS.register("my_ore_deepslate", () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MY_ORE_DEEPSLATE_ITEM = fromBlock(MY_ORE_DEEPSLATE);

    private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }

}
