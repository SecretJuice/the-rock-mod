package io.github.secretjuice.rockmod.core.init;

import io.github.secretjuice.rockmod.RockMod;
import io.github.secretjuice.rockmod.common.blocks.StrangeGravelBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RockMod.MOD_ID);

    public static final RegistryObject<Block> STRANGE_GRAVEL = BLOCKS.register("strangegravel",
            () -> new StrangeGravelBlock(AbstractBlock.Properties.from(Blocks.GRAVEL)));

}
