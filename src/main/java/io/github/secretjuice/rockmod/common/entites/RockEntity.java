package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

public class RockEntity extends SnowballEntity {


    public RockEntity(EntityType<? extends SnowballEntity> type, World worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
    }


    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        //int i = entity instanceof BlazeEntity ? 3 : 0;
        int i = 2;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
    }

}
