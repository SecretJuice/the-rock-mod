package io.github.secretjuice.rockmod.core.init;

import io.github.secretjuice.rockmod.RockMod;
import io.github.secretjuice.rockmod.common.items.*;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            RockMod.MOD_ID);

    //ITEMS

    //ROCKS
    public static final RegistryObject<RockItem> ROCK = ITEMS.register("rock",
            () -> new RockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<MagmaRockItem> MAGMA_ROCK = ITEMS.register("magmarock",
            () -> new MagmaRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<EndRockItem> END_ROCK = ITEMS.register("endrock",
            () -> new EndRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<ObsidianRockItem> OBSIDIAN_ROCK = ITEMS.register("obsidianrock",
            () -> new ObsidianRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<BlastRockItem> BLAST_ROCK = ITEMS.register("blastrock",
            () -> new BlastRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<AndesiteRockItem> ANDESITE_ROCK = ITEMS.register("andesiterock",
            () -> new AndesiteRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<BasaltRockItem> BASALT_ROCK = ITEMS.register("basaltrock",
            () -> new BasaltRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<DioriteRockItem> DIORITE_ROCK = ITEMS.register("dioriterock",
            () -> new DioriteRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<GraniteRockItem> GRANITE_ROCK = ITEMS.register("graniterock",
            () -> new GraniteRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<SandRockItem> SAND_ROCK = ITEMS.register("sandrock",
            () -> new SandRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<NetherRockItem> NETHER_ROCK = ITEMS.register("netherrock",
            () -> new NetherRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));
    public static final RegistryObject<PetRockItem> PET_ROCK = ITEMS.register("petrock",
            () -> new PetRockItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(1)));
    public static final RegistryObject<BobRocksItem> BOB_ROCKS = ITEMS.register("bobrocks",
            () -> new BobRocksItem(new Item.Properties().group(RockMod.ROCK_GROUP).maxStackSize(16)));

    //OTHER ITEMS
    public static final RegistryObject<StrangeDustItem> STRANGE_DUST = ITEMS.register("strangedust",
            () -> new StrangeDustItem(new Item.Properties().group(RockMod.ROCK_GROUP)));

    //BLOCKS

    public static final RegistryObject<StrangeGravelItem> STRANGE_GRAVEL = ITEMS.register("strangegravel",
            () -> new StrangeGravelItem(BlockInit.STRANGE_GRAVEL.get(), new Item.Properties().group(RockMod.ROCK_GROUP)));

}
