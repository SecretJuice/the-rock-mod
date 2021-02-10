package io.github.secretjuice.rockmod.core.init;

import io.github.secretjuice.rockmod.RockMod;
import io.github.secretjuice.rockmod.common.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            RockMod.MOD_ID);

    public static final RegistryObject<RockItem> ROCK = ITEMS.register("rock",
            () -> new RockItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(16)));
    public static final RegistryObject<MagmaRockItem> MAGMA_ROCK = ITEMS.register("magmarock",
            () -> new MagmaRockItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(16)));
    public static final RegistryObject<EndRockItem> END_ROCK = ITEMS.register("endrock",
            () -> new EndRockItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(16)));
    public static final RegistryObject<ObsidianRockItem> OBSIDIAN_ROCK = ITEMS.register("obsidianrock",
            () -> new ObsidianRockItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(16)));
    public static final RegistryObject<BobRocksItem> BOB_ROCKS = ITEMS.register("bobrocks",
            () -> new BobRocksItem(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16)));
    public static final RegistryObject<BlastRockItem> BLAST_ROCK = ITEMS.register("blastrock",
            () -> new BlastRockItem(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(16)));

}
