package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.core.damagesources.RockDamageSource;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BasaltRockEntity extends RockEntity{

    public BasaltRockEntity(EntityType<? extends RockEntity> type, World worldIn, LivingEntity throwerIn) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.BASALT_ROCK_ENTITY, worldIn, throwerIn);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    public BasaltRockEntity(EntityType<? extends RockEntity> type, World worldIn, double x, double y, double z) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.BASALT_ROCK_ENTITY, worldIn, x, y, z);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    private BlockState particleBlockState = Blocks.BASALT.getDefaultState();
    private DamageSource entityDamageSource = RockDamageSource.BASALT_ROCK;

}
