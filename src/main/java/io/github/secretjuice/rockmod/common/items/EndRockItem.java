package io.github.secretjuice.rockmod.common.items;

import io.github.secretjuice.rockmod.common.entites.EndRockEntity;
import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EndRockItem extends RockItem {

    public EndRockItem(Item.Properties properties) {
        super(properties);
        super.setTooltipTranslationKey(tooltipTranslationKey);
    }

    private String tooltipTranslationKey = "tooltip.sj_rock_mod.endrock.tooltip";
    private EntityType<?> rockEntityType = EntityTypeInit.END_ROCK_ENTITY;

    @Override
    protected ProjectileItemEntity createProjectileItemEntity(World worldIn, LivingEntity playerIn){
        return new EndRockEntity((EntityType<? extends RockEntity>) rockEntityType, worldIn, playerIn);
    }

}
