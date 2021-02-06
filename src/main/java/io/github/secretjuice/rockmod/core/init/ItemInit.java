package io.github.secretjuice.rockmod.core.init;

import io.github.secretjuice.rockmod.RockMod;
import io.github.secretjuice.rockmod.common.items.RockItem;
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

}
