package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.client.render.particle.ProjectileImpactParticleRenderer;
import io.github.secretjuice.rockmod.core.damagesources.RockDamageSource;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlastRockEntity extends RockEntity{

    public BlastRockEntity(EntityType<? extends RockEntity> type, World worldIn, LivingEntity throwerIn) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.BLAST_ROCK_ENTITY, worldIn, throwerIn);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    public BlastRockEntity(EntityType<? extends RockEntity> type, World worldIn, double x, double y, double z) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.BLAST_ROCK_ENTITY, worldIn, x, y, z);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    private BlockState particleBlockState = Blocks.STONE.getDefaultState();
    private DamageSource entityDamageSource = RockDamageSource.BLAST_ROCK;

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte) 3);
            ProjectileImpactParticleRenderer.renderImpactParticles(this, getParticleBlockState());
            createExplosion();
            this.remove();
        }
    }

    private void createExplosion(){

        this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 2F, Explosion.Mode.BREAK);

    }

}
