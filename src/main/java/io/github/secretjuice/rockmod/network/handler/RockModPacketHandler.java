package io.github.secretjuice.rockmod.network.handler;

import io.github.secretjuice.rockmod.RockMod;
import io.github.secretjuice.rockmod.network.packets.RockPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class RockModPacketHandler {

    private static final String PROTOCOL_VERSION = "1.16.4-0.0.5.0";
    public static SimpleChannel CHANNEL;

    public static void register() {

        CHANNEL = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(RockMod.MOD_ID, "main"),
                () -> PROTOCOL_VERSION,
                PROTOCOL_VERSION::equals,
                PROTOCOL_VERSION::equals
        );

        int id = 0;

        CHANNEL.registerMessage(id++, RockPacket.class, RockPacket::encode, RockPacket::decode, RockPacket::handle);
    }

}
