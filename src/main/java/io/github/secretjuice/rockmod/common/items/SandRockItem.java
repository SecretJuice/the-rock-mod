package io.github.secretjuice.rockmod.common.items;

import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.common.entites.SandRockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class SandRockItem extends RockItem {

    public SandRockItem(Item.Properties properties) {
        super(properties);
        super.setTooltipTranslationKey(tooltipTranslationKey);
    }

    private String tooltipTranslationKey = "tooltip.sj_rock_mod.sandrock.tooltip";
    private EntityType<?> rockEntityType = EntityTypeInit.SAND_ROCK_ENTITY;

    @Override
    protected ProjectileItemEntity createProjectileItemEntity(World worldIn, LivingEntity playerIn){
        return new SandRockEntity((EntityType<? extends RockEntity>) rockEntityType, worldIn, playerIn);
    }

}
