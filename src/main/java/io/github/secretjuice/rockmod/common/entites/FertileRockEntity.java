package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.client.render.particle.ProjectileImpactParticleRenderer;
import io.github.secretjuice.rockmod.core.damagesources.RockDamageSource;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class FertileRockEntity extends RockEntity{

    public FertileRockEntity(EntityType<? extends RockEntity> type, World worldIn, LivingEntity throwerIn) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.FERTILE_ROCK_ENTITY, worldIn, throwerIn);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    public FertileRockEntity(EntityType<? extends RockEntity> type, World worldIn, double x, double y, double z) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.FERTILE_ROCK_ENTITY, worldIn, x, y, z);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    private BlockState particleBlockState = Blocks.OAK_LEAVES.getDefaultState();
    private DamageSource entityDamageSource = RockDamageSource.FERTILE_ROCK;

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            ProjectileImpactParticleRenderer.renderImpactParticles(this, getParticleBlockState());
            boneMealArea();
            this.remove();
        }

    }

    protected void boneMealArea(){
        BlockPos entityPos = this.getPosition();

        BlockPos checkingPos = new BlockPos(entityPos.getX() - 1, entityPos.getY() - 1, entityPos.getZ() - 1);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){

                for (int k = 0; k < 3; k++){

                    BlockState blockstate = world.getBlockState(checkingPos);

                    if (blockstate.getBlock() instanceof IGrowable){
                        IGrowable igrowable = (IGrowable)blockstate.getBlock();

                        if (igrowable.canGrow(world, checkingPos, blockstate, world.isRemote)) {

                            if (world instanceof ServerWorld) {

                                if (igrowable.canUseBonemeal(world, world.rand, checkingPos, blockstate)) {

                                    igrowable.grow((ServerWorld)world, world.rand, checkingPos, blockstate);
                                }
                            }
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
