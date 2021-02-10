package io.github.secretjuice.rockmod.common.items;

import io.github.secretjuice.rockmod.common.entites.BasaltRockEntity;
import io.github.secretjuice.rockmod.common.entites.ObsidianRockEntity;
import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BasaltRockItem extends RockItem{

    public BasaltRockItem(Item.Properties properties) {
        super(properties);
        super.setTooltipTranslationKey(tooltipTranslationKey);
    }

    private String tooltipTranslationKey = "tooltip.sj_rock_mod.basaltrock.tooltip";
    private EntityType<?> rockEntityType = EntityTypeInit.BASALT_ROCK_ENTITY;

    @Override
    protected ProjectileItemEntity createProjectileItemEntity(World worldIn, LivingEntity playerIn){
        return new BasaltRockEntity((EntityType<? extends RockEntity>) rockEntityType, worldIn, playerIn);
    }

}
