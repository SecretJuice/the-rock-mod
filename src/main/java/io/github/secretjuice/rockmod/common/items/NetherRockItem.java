package io.github.secretjuice.rockmod.common.items;

import io.github.secretjuice.rockmod.common.entites.MagmaRockEntity;
import io.github.secretjuice.rockmod.common.entites.NetherRockEntity;
import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.world.World;

public class NetherRockItem extends RockItem{

    public NetherRockItem(Properties properties) {
        super(properties);
        super.setTooltipTranslationKey(tooltipTranslationKey);
    }

    private String tooltipTranslationKey = "tooltip.sj_rock_mod.netherrock.tooltip";
    private EntityType<?> rockEntityType = EntityTypeInit.NETHER_ROCK_ENTITY;

    @Override
    protected ProjectileItemEntity createProjectileItemEntity(World worldIn, LivingEntity playerIn){
        return new NetherRockEntity((EntityType<? extends RockEntity>) rockEntityType, worldIn, playerIn);
    }


}
