package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.client.render.particle.ProjectileImpactParticleRenderer;
import io.github.secretjuice.rockmod.core.damagesources.RockDamageSource;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class RockEntity extends SnowballEntity {


    public RockEntity(EntityType<? extends SnowballEntity> type, World worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
    }

    public RockEntity(EntityType<? extends SnowballEntity> type, World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    protected float knockbackStrength = 0.5F;
    protected int entityDamage = 2;

    protected BlockState particleBlockState = Blocks.SMOOTH_STONE.getDefaultState();
    protected DamageSource entityDamageSource = RockDamageSource.ROCK;

    public BlockState getParticleBlockState(){
        return particleBlockState;
    }
    public void setParticleBlockState(BlockState blockState){
        particleBlockState = blockState;
    }

    public DamageSource getEntityDamageSource(){
        return entityDamageSource;
    }

    public void setEntityDamageSource(DamageSource damageSource){
        entityDamageSource = damageSource;
    }

    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        dealDamageToHitEntity(entity);
        applyKnockbackToHitEntity(entity);
    }

    protected void dealDamageToHitEntity(Entity entity){
        entity.attackEntityFrom(this.entityDamageSource, (float)this.entityDamage);
    }

    protected void applyKnockbackToHitEntity(Entity entity){
        if (this.knockbackStrength > 0) {
            Vector3d vector3d = this.getMotion().mul(1.0D, 0.0D, 1.0D).normalize().scale((double)this.knockbackStrength * 0.6D);
            if (vector3d.lengthSquared() > 0.0D) {
                entity.addVelocity(vector3d.x, 0.1D, vector3d.z);
            }
        }
    }

    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            ProjectileImpactParticleRenderer.renderImpactParticles(this, getParticleBlockState());
            this.remove();
        }

    }

}