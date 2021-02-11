package io.github.secretjuice.rockmod.core.maps;

import io.github.secretjuice.rockmod.core.init.ItemInit;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.HashMap;

public class SmashableBlocks {

    public static HashMap<Item, Item> Smashables = new HashMap<Item, Item>();

    public static void initializeHashMap(){
        Smashables.put(Items.COBBLESTONE.asItem(), ItemInit.ROCK.get());
        Smashables.put(Items.MAGMA_BLOCK.asItem(), ItemInit.MAGMA_ROCK.get());
        Smashables.put(Items.END_STONE.asItem(), ItemInit.END_ROCK.get());
        Smashables.put(Items.OBSIDIAN.asItem(), ItemInit.OBSIDIAN_ROCK.get());
        Smashables.put(Items.ANDESITE.asItem(), ItemInit.ANDESITE_ROCK.get());
        Smashables.put(Items.BASALT.asItem(), ItemInit.BASALT_ROCK.get());
        Smashables.put(Items.DIORITE.asItem(), ItemInit.DIORITE_ROCK.get());
        Smashables.put(Items.GRANITE.asItem(), ItemInit.GRANITE_ROCK.get());
        Smashables.put(Items.MOSSY_COBBLESTONE.asItem(), ItemInit.MOSSY_ROCK.get());
        Smashables.put(Items.NETHERRACK.asItem(), ItemInit.NETHER_ROCK.get());
        Smashables.put(Items.SANDSTONE.asItem(), ItemInit.SAND_ROCK.get());
    }

}
