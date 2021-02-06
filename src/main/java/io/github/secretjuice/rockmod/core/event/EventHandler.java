package io.github.secretjuice.rockmod.core.event;

import io.github.secretjuice.rockmod.RockMod;
import io.github.secretjuice.rockmod.core.init.ItemInit;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = RockMod.MOD_ID, bus = Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onStoneSmash(final PlayerInteractEvent.LeftClickBlock event) {

        final World world = event.getWorld();

        if (world.isRemote()){
            return;
        }

        System.out.println("Is Server: " + event.getSide().isServer());

        if (world != null && event.getUseBlock() != Result.DENY) {
            final PlayerEntity player = event.getPlayer();

            System.out.println("Made it 2nd Stage");

            if (player != null && !player.isSpectator() && !world.isAirBlock(event.getPos())){
                final BlockPos pos = event.getPos();

                System.out.println("Made it 3rd Stage");

                if (world.getBlockState(pos).getBlock().equals(Blocks.OBSIDIAN) && player.inventory.getCurrentItem().getItem().equals(Blocks.COBBLESTONE.asItem())){
                    player.inventory.addItemStackToInventory(new ItemStack(ItemInit.ROCK.get(), 1));
                    player.inventory.decrStackSize(player.inventory.currentItem, 1);

                    System.out.println("Made it Final Stage");

                }
            }
        }
    }
}