package io.github.secretjuice.rockmod.core.event;

import io.github.secretjuice.rockmod.RockMod;
import io.github.secretjuice.rockmod.core.init.ItemInit;

import io.github.secretjuice.rockmod.network.handler.RockModPacketHandler;
import io.github.secretjuice.rockmod.network.packets.RockPacket;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.lwjgl.glfw.GLFW;

import java.util.Random;

@EventBusSubscriber(modid = RockMod.MOD_ID, bus = Bus.FORGE)
public class EventHandler {

    private static boolean smashingStone = false;

    @SubscribeEvent
    public static void onStoneSmash(final PlayerInteractEvent.RightClickBlock event) {

        final World world = event.getWorld();

        if (world.isRemote()){

            if (event.getHand().equals(Hand.OFF_HAND)){
                return;
            }

            if (event.getUseBlock() != Result.DENY) {
                final PlayerEntity player = event.getPlayer();

                if (player != null && !player.isSpectator() && !world.isAirBlock(event.getPos())) {
                    final BlockPos pos = event.getPos();

                    if (InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_CONTROL) && world.getBlockState(pos).getBlock().equals(Blocks.OBSIDIAN) && player.inventory.getCurrentItem().getItem().equals(Blocks.COBBLESTONE.asItem())) {

                        float offsetX = 0.5F + (event.getFace().getXOffset() * 0.7F);
                        float offsetY = 0.5F + (event.getFace().getYOffset() * 0.7F);
                        float offsetZ = 0.5F + (event.getFace().getZOffset() * 0.7F);

                        Vector3d packetPos = new Vector3d(pos.getX() + offsetX, pos.getY() + offsetY, pos.getZ() + offsetZ);

                        Vector3i packetFacing = new Vector3i((int)event.getFace().getXOffset(),  (int)event.getFace().getYOffset(), (int)event.getFace().getZOffset());

                        RockPacket packet = new RockPacket(player.inventory.getCurrentItem(), packetPos, packetFacing);
                        RockModPacketHandler.CHANNEL.sendToServer(packet);

                        Random rand = new Random();

                        for (int i = 0; i < 12; i++){

                            world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.COBBLESTONE.getDefaultState()),
                                    pos.getX() + offsetX + ((rand.nextFloat() - 0.5F) * 0.75F),
                                    pos.getY() + offsetY + ((rand.nextFloat() - 0.5F) * 0.75F),
                                    pos.getZ() + offsetZ + ((rand.nextFloat() - 0.5F) * 0.75F),
                                    0, 0, 0);

                        }
                        smashingStone = true;
                        event.setCanceled(true);

                    }
                }
            }

        }
        else if (!world.isRemote() && smashingStone == true){

            if (event.getHand().equals(Hand.OFF_HAND)){
                return;
            }

            smashingStone = false;
            event.setCanceled(true);
        }

    }
}