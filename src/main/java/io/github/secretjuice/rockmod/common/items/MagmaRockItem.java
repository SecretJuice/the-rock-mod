package io.github.secretjuice.rockmod.common.items;

import io.github.secretjuice.rockmod.common.entites.MagmaRockEntity;
import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.world.World;

public class MagmaRockItem extends RockItem {

    public MagmaRockItem(Properties properties) {
        super(properties);
        super.setTooltipTranslationKey(tooltipTranslationKey);
    }

    private String tooltipTranslationKey = "tooltip.sj_rock_mod.magmarock.tooltip";
    private EntityType<?> rockEntityType = EntityTypeInit.MAGMA_ROCK_ENTITY;

    @Override
    protected ProjectileItemEntity createProjectileItemEntity(World worldIn, LivingEntity playerIn){
        return new MagmaRockEntity((EntityType<? extends RockEntity>) rockEntityType, worldIn, playerIn);
    }

}
