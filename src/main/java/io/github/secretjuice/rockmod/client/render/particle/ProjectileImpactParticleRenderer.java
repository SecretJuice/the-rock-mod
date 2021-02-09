package io.github.secretjuice.rockmod.client.render.particle;

import io.github.secretjuice.rockmod.common.entites.RockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ProjectileImpactParticleRenderer {

    public static void renderImpactParticles(Entity entity, BlockState particleBlockState){

        ServerWorld serverWorld = entity.world.getServer().getWorld(entity.getEntityWorld().getDimensionKey());

        IParticleData iparticledata = new BlockParticleData(ParticleTypes.BLOCK, particleBlockState);

        Random rand = new Random();

        double randFlex = 0.1D;

        for(int i = 0; i < 8; ++i) {
            serverWorld.spawnParticle(iparticledata,
                    entity.getPosX() + ((rand.nextGaussian() - 0.5) * randFlex),
                    entity.getPosY() + ((rand.nextGaussian() - 0.5) * randFlex),
                    entity.getPosZ() + ((rand.nextGaussian() - 0.5) * randFlex),
                    1,
                    rand.nextDouble() * 0.2,
                    rand.nextDouble() * 0.2,
                    rand.nextDouble() * 0.2,
                    1);
        }

    }

}
