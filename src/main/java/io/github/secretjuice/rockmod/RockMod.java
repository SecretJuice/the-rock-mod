package io.github.secretjuice.rockmod;

import io.github.secretjuice.rockmod.core.dispenserbehaviors.RockDispenserBehavior;
import io.github.secretjuice.rockmod.core.init.BlockInit;
import io.github.secretjuice.rockmod.core.init.ItemInit;
import io.github.secretjuice.rockmod.core.maps.SmashableBlocks;
import io.github.secretjuice.rockmod.network.handler.RockModPacketHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RockMod.MOD_ID)
public class RockMod
{

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "sj_rock_mod";
    public static final ItemGroup ROCK_GROUP = new RockItemGroup("sj_rock_mod_tab");

    public RockMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        RockModPacketHandler.register();
        RockDispenserBehavior.init();
        SmashableBlocks.initializeHashMap();
    }

    public static class RockItemGroup extends ItemGroup {
        public RockItemGroup(String label) {
            super(label);
        }

        @Override
        public ItemStack createIcon(){
            return ItemInit.ROCK.get().getDefaultInstance();
        }


    }

}
