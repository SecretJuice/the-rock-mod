package io.github.secretjuice.rockmod.common.items;

import io.github.secretjuice.rockmod.common.entites.BlastRockEntity;
import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlastRockItem extends RockItem{

    public BlastRockItem(Item.Properties properties) {
        super(properties);
        super.setTooltipTranslationKey(tooltipTranslationKey);
    }

    private String tooltipTranslationKey = "tooltip.sj_rock_mod.blastrock.tooltip";
    private EntityType<?> rockEntityType = EntityTypeInit.BLAST_ROCK_ENTITY;

    @Override
    protected ProjectileItemEntity createProjectileItemEntity(World worldIn, LivingEntity playerIn){
        return new BlastRockEntity((EntityType<? extends RockEntity>) rockEntityType, worldIn, playerIn);
    }

}
