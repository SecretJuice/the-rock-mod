package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.client.render.particle.ProjectileImpactParticleRenderer;
import io.github.secretjuice.rockmod.core.damagesources.RockDamageSource;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class ForceRockEntity extends RockEntity{

    public ForceRockEntity(EntityType<? extends RockEntity> type, World worldIn, LivingEntity throwerIn) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.FORCE_ROCK_ENTITY, worldIn, throwerIn);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    public ForceRockEntity(EntityType<? extends RockEntity> type, World worldIn, double x, double y, double z) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.FORCE_ROCK_ENTITY, worldIn, x, y, z);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    private BlockState particleBlockState = Blocks.END_PORTAL_FRAME.getDefaultState();
    private DamageSource entityDamageSource = RockDamageSource.FORCE_ROCK;

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            ProjectileImpactParticleRenderer.renderImpactParticles(this, getParticleBlockState());
            applyForceToEntities();
            this.remove();
        }

    }

    protected void applyForceToEntities(){
        Vector3d entityPos = new Vector3d(this.getPosX(), this.getPosY(), this.getPosZ());

        List<Entity> entityList = this.world.getEntitiesWithinAABB(Entity.class,
                new AxisAlignedBB(
                        entityPos.getX(),
                        entityPos.getY(),
                        entityPos.getZ(),
                        entityPos.getX() + 1,
                        entityPos.getZ() + 1,
                        entityPos.getY() + 1));

        for(Entity affectedEntity : entityList){
            Vector3d directionRaw = new Vector3d(
                    affectedEntity.getPosX() - entityPos.getX(),
                    affectedEntity.getPosY() - entityPos.getY(),
                    affectedEntity.getPosZ() - entityPos.getZ());

            Vector3d direction = directionRaw.normalize();

            double distanceFromEpicenter = directionRaw.length();

            Vector3d addedVelocity = direction.scale(1F);//(1 / distanceFromEpicenter));

            affectedEntity.setMotion(getMotion().add(addedVelocity));

        }

    }


}
