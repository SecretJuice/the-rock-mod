package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.core.damagesources.RockDamageSource;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import io.github.secretjuice.rockmod.core.util.RandomEnumSelector;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IShearable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.IForgeShearable;

public class BobRocksEntity extends RockEntity{

    public BobRocksEntity(EntityType<? extends RockEntity> type, World worldIn, LivingEntity throwerIn) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.BOB_ROCKS_ENTITY, worldIn, throwerIn);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    public BobRocksEntity(EntityType<? extends RockEntity> type, World worldIn, double x, double y, double z) {
        super((EntityType<? extends RockEntity>) EntityTypeInit.BOB_ROCKS_ENTITY, worldIn, x, y, z);
        super.setParticleBlockState(particleBlockState);
        super.setEntityDamageSource(entityDamageSource);
    }

    private BlockState particleBlockState = Blocks.ROSE_BUSH.getDefaultState();
    private DamageSource entityDamageSource = RockDamageSource.BOB_ROCKS;

    @Override
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        super.dealDamageToHitEntity(entity);
        super.applyKnockbackToHitEntity(entity);

        setColorOfHitEntity(entity);

    }

    private void setColorOfHitEntity(Entity entity){

        if (entity instanceof SheepEntity){
            ((SheepEntity) entity).setFleeceColor(RandomEnumSelector.randomEnum(DyeColor.class));
        };
    }

}
