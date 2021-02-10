package io.github.secretjuice.rockmod.common.items;

import io.github.secretjuice.rockmod.common.entites.GraniteRockEntity;
import io.github.secretjuice.rockmod.common.entites.ObsidianRockEntity;
import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class GraniteRockItem extends RockItem{

    public GraniteRockItem(Item.Properties properties) {
        super(properties);
        super.setTooltipTranslationKey(tooltipTranslationKey);
    }

    private String tooltipTranslationKey = "tooltip.sj_rock_mod.graniterock.tooltip";
    private EntityType<?> rockEntityType = EntityTypeInit.GRANITE_ROCK_ENTITY;

    @Override
    protected ProjectileItemEntity createProjectileItemEntity(World worldIn, LivingEntity playerIn){
        return new GraniteRockEntity((EntityType<? extends RockEntity>) rockEntityType, worldIn, playerIn);
    }

}
