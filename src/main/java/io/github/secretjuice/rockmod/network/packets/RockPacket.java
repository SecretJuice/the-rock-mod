package io.github.secretjuice.rockmod.network.packets;

import io.github.secretjuice.rockmod.core.event.EventHandler;
import io.github.secretjuice.rockmod.core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class RockPacket {

    private final ItemStack rockItemStack;
    private final Vector3i interactFacing;
    private final Vector3d interactPos;

    public RockPacket(ItemStack itemStack, Vector3d pos, Vector3i facing){

        this.rockItemStack = itemStack;
        this.interactPos = pos;
        this.interactFacing = facing;
    }

    public static void encode(RockPacket msg, PacketBuffer buffer) {

        buffer.writeItemStack(msg.rockItemStack);
        buffer.writeDouble(msg.interactPos.getX());
        buffer.writeDouble(msg.interactPos.getY());
        buffer.writeDouble(msg.interactPos.getZ());
        buffer.writeInt(msg.interactFacing.getX());
        buffer.writeInt(msg.interactFacing.getY());
        buffer.writeInt(msg.interactFacing.getZ());

    }

    public static RockPacket decode(PacketBuffer buffer) {

        return new RockPacket(buffer.readItemStack(),
                new Vector3d(buffer.readDouble(),
                            buffer.readDouble(),
                            buffer.readDouble()),
                new Vector3i(buffer.readInt(),
                            buffer.readInt(),
                            buffer.readInt()));
    }

    public static void handle(RockPacket msg, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            PlayerEntity player = context.get().getSender();

            World world = player.getEntityWorld();

            Vector3d pos = msg.interactPos;

            Vector3i facing = msg.interactFacing;

            if (msg.rockItemStack.getItem().equals(Blocks.COBBLESTONE.asItem())){
                ItemStack stack = new ItemStack(ItemInit.ROCK.get(), 1);
                spawnItemEntity(world, stack, pos, facing);
            }
            else if (msg.rockItemStack.getItem().equals(Blocks.MAGMA_BLOCK.asItem())){
                ItemStack stack = new ItemStack(ItemInit.MAGMA_ROCK.get(), 1);
                spawnItemEntity(world, stack, pos, facing);
            }
            else if (msg.rockItemStack.getItem().equals(Blocks.END_STONE.asItem())){
                ItemStack stack = new ItemStack(ItemInit.END_ROCK.get(), 1);
                spawnItemEntity(world, stack, pos, facing);
            }

            ServerWorld serverWorld = world.getServer().getWorld(player.getEntityWorld().getDimensionKey());


            for (int i = 0; i < 12; i++){

                serverWorld.spawnParticle(new BlockParticleData(ParticleTypes.BLOCK, Block.getBlockFromItem(msg.rockItemStack.getItem()).getDefaultState()),
                        pos.getX() + ((world.rand.nextFloat() - 0.5F) * 0.75F),
                        pos.getY() + ((world.rand.nextFloat() - 0.5F) * 0.75F),
                        pos.getZ() + ((world.rand.nextFloat() - 0.5F) * 0.75F),
                        1,
                        0, 0, 0,1);

            }

            world.playSound(player, pos.getX(), pos.getY(), pos.getZ(),new SoundEvent(new ResourceLocation("minecraft", "block.lodestone.break")), SoundCategory.BLOCKS, 1.0F, 0F);
            world.playSound(player, pos.getX(), pos.getY(), pos.getZ(),new SoundEvent(new ResourceLocation("minecraft", "block.nether_bricks.break")), SoundCategory.BLOCKS, 1.0F, 1.0F);


            if (!player.isCreative()) {
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
            }

            EventHandler.setSmashingStone(true);

        });
        context.get().setPacketHandled(true);
    }

    private static void spawnItemEntity(World world, ItemStack itemStack, Vector3d pos, Vector3i facing){

        double speed = 0.3D;

        ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY() + facing.getY() * 0.2F, pos.getZ(), itemStack);

        double d3 = world.rand.nextDouble() * 0.05D + 0.2D;

        itemEntity.setMotion(world.rand.nextGaussian() * (double)0.1F * (double)speed + (double)facing.getX() * d3, world.rand.nextGaussian() * (double)0.1F * (double)speed + (double)facing.getY() * d3, world.rand.nextGaussian() * (double)0.1F * (double)speed + (double)facing.getZ() * d3);


        world.addEntity(itemEntity);

    }


}
