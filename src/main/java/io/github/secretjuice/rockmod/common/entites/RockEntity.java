package io.github.secretjuice.rockmod.common.entites;

import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
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
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class RockEntity extends SnowballEntity {


    public RockEntity(EntityType<? extends SnowballEntity> type, World worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        return new BlockParticleData(ParticleTypes.BLOCK, Blocks.COBBLESTONE.getDefaultState());
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            IParticleData iparticledata = this.makeParticle();

            Random rand = new Random();

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(iparticledata, true, this.getPosX() + rand.nextGaussian(), this.getPosY() + rand.nextGaussian(), this.getPosZ() + rand.nextGaussian(), rand.nextDouble() * 0.2, rand.nextDouble() * 0.2, rand.nextDouble() * 0.2);
            }
        }

    }

    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        //int i = entity instanceof BlazeEntity ? 3 : 0;
        int i = 2;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
    }

}
