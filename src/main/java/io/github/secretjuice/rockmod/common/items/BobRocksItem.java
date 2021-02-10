package io.github.secretjuice.rockmod.common.items;

import io.github.secretjuice.rockmod.common.entites.BobRocksEntity;
import io.github.secretjuice.rockmod.common.entites.EndRockEntity;
import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BobRocksItem extends RockItem {

    public BobRocksItem(Item.Properties properties) {
        super(properties);
        super.setTooltipTranslationKey(tooltipTranslationKey);
    }

    private String tooltipTranslationKey = "tooltip.sj_rock_mod.bobrocks.tooltip";
    private EntityType<?> rockEntityType = EntityTypeInit.BOB_ROCKS_ENTITY;

    @Override
    protected ProjectileItemEntity createProjectileItemEntity(World worldIn, LivingEntity playerIn){
        return new BobRocksEntity((EntityType<? extends RockEntity>) rockEntityType, worldIn, playerIn);
    }

}
