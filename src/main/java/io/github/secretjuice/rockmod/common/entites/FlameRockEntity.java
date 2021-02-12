package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.client.render.particle.ProjectileImpactParticleRenderer;
import io.github.secretjuice.rockmod.core.damagesources.RockDamageSource;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class FlameRockEntity extends RockEntity{

    public FlameRockEntity(EntityType<? extends RockEntity> type, World worldIn, LivingEntity throwerIn) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.FLAME_ROCK_ENTITY, worldIn, throwerIn);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    public FlameRockEntity(EntityType<? extends RockEntity> type, World worldIn, double x, double y, double z) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.FLAME_ROCK_ENTITY, worldIn, x, y, z);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    private BlockState particleBlockState = Blocks.LAVA.getDefaultState();
    private DamageSource entityDamageSource = RockDamageSource.FLAME_ROCK;

    private int secondsOnFire = 8;

    @Override
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        super.dealDamageToHitEntity(entity);
        super.applyKnockbackToHitEntity(entity);

        setFireToHitEntity(entity);

    }

    private void setFireToHitEntity(Entity entity){
        entity.setFire(secondsOnFire);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            ProjectileImpactParticleRenderer.renderImpactParticles(this, getParticleBlockState());
            setFireToArea();
            this.remove();
        }

    }

    protected void setFireToArea(){
        BlockPos entityPos = this.getPosition();

        BlockPos checkingPos = new BlockPos(entityPos.getX() - 1, entityPos.getY() - 1, entityPos.getZ() - 1);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){

                for (int k = 0; k < 3; k++){

                    Random rand =  new Random();

                    for (Direction dir : Direction.values()){

                        if (AbstractFireBlock.canLightBlock(world, checkingPos, dir) && rand.nextFloat() < 0.25F){

                            BlockPos blockpos1 = checkingPos.offset(dir);

                            BlockState blockstate1 = AbstractFireBlock.getFireForPlacement(world, blockpos1);
                            world.setBlockState(checkingPos, blockstate1, 11);
                        }
                    }
                    checkingPos = new BlockPos(checkingPos.getX() + 1, checkingPos.getY(), checkingPos.getZ());
                }
                checkingPos = new BlockPos(checkingPos.getX() - 3, checkingPos.getY(), checkingPos.getZ() + 1);
            }
            checkingPos = new BlockPos(checkingPos.getX(), checkingPos.getY() + 1, checkingPos.getZ() - 3);
        }
    }
}
