package ch.landrus.minecraft.tutorialmod.setup;

import static ch.landrus.minecraft.tutorialmod.TutorialMod.MOD_ID;
import ch.landrus.minecraft.tutorialmod.blocks.PowergenBE;
import ch.landrus.minecraft.tutorialmod.blocks.PowergenBlock;
import ch.landrus.minecraft.tutorialmod.blocks.PowergenContainer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
            ForgeRegistries.BLOCK_ENTITIES, MOD_ID);
    private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS,
            MOD_ID);

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        CONTAINERS.register(modEventBus);
    }

    // Some common properties for our blocks and items
    public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE)
            .strength(2);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    public static final RegistryObject<Block> MY_ORE_OVERWORLD = BLOCKS.register("my_ore_overworld",
            () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MY_ORE_OVERWORLD_ITEM = fromBlock(MY_ORE_OVERWORLD);
    public static final RegistryObject<Block> MY_ORE_NETHER = BLOCKS.register("my_ore_nether",
            () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MY_ORE_NETHER_ITEM = fromBlock(MY_ORE_NETHER);
    public static final RegistryObject<Block> MY_ORE_END = BLOCKS.register("my_ore_end",
            () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MY_ORE_END_ITEM = fromBlock(MY_ORE_END);
    public static final RegistryObject<Block> MY_ORE_DEEPSLATE = BLOCKS.register("my_ore_deepslate",
            () -> new Block(ORE_PROPERTIES));
    public static final RegistryObject<Item> MY_ORE_DEEPSLATE_ITEM = fromBlock(MY_ORE_DEEPSLATE);

    public static final RegistryObject<PowergenBlock> POWERGEN = BLOCKS.register("powergen", PowergenBlock::new);
    public static final RegistryObject<Item> POWERGEN_ITEM = fromBlock(POWERGEN);
    public static final RegistryObject<BlockEntityType<PowergenBE>> POWERGEN_BE = BLOCK_ENTITIES.register("powergen",
            () -> BlockEntityType.Builder.of(PowergenBE::new, POWERGEN.get()).build(null));
    public static final RegistryObject<MenuType<PowergenContainer>> POWERGEN_CONTAINER = CONTAINERS.register("powergen",
            () ->
                IForgeMenuType.create(((windowId, inv, data) ->
                            new PowergenContainer(windowId, data.readBlockPos(), inv, inv.player))));

    public static final RegistryObject<Item> RAW_MY_CHUNK = ITEMS.register("raw_my_chunk",
            () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> MY_INGOT = ITEMS.register("my_ingot", () -> new Item(ITEM_PROPERTIES));

    public static final Tags.IOptionalNamedTag<Block> MY_ORE = BlockTags.createOptional(new ResourceLocation(MOD_ID,
                "my_ore"));
    public static final Tags.IOptionalNamedTag<Item> MY_ORE_ITEM = ItemTags.createOptional(new ResourceLocation(MOD_ID,
                "my_ore"));

    private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }

}
