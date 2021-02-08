package io.github.secretjuice.rockmod.network.packets;

import io.github.secretjuice.rockmod.core.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class RockPacket {

    private final boolean controlDown;

    public RockPacket(boolean bool){
        this.controlDown = bool;
    }

    public static void encode(RockPacket msg, PacketBuffer buffer) {
        buffer.writeBoolean(msg.controlDown);
    }

    public static RockPacket decode(PacketBuffer buffer) {
        return new RockPacket(buffer.readBoolean());
    }

    public static void handle(RockPacket msg, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            PlayerEntity player = context.get().getSender();

            player.inventory.addItemStackToInventory(new ItemStack(ItemInit.ROCK.get(), 1));
            if (!player.isCreative()) {
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
            }

        });
        context.get().setPacketHandled(true);
    }


}
