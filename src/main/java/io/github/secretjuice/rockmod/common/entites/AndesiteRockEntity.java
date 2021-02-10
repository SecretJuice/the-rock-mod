package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.core.damagesources.RockDamageSource;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class AndesiteRockEntity extends RockEntity{

    public AndesiteRockEntity(EntityType<? extends RockEntity> type, World worldIn, LivingEntity throwerIn) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.ANDESITE_ROCK_ENTITY, worldIn, throwerIn);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    public AndesiteRockEntity(EntityType<? extends RockEntity> type, World worldIn, double x, double y, double z) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.ANDESITE_ROCK_ENTITY, worldIn, x, y, z);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    private BlockState particleBlockState = Blocks.ANDESITE.getDefaultState();
    private DamageSource entityDamageSource = RockDamageSource.ANDESITE_ROCK;

}
