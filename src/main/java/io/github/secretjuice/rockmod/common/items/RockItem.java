package io.github.secretjuice.rockmod.common.items;

import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class RockItem extends SnowballItem {

    public RockItem(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.sj_rock_mod.rock.tooltip"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            RockEntity rockEntity = new RockEntity((EntityType<? extends SnowballEntity>) EntityTypeInit.ROCK_ENTITY, worldIn, playerIn);
            rockEntity.setItem(itemstack);
            rockEntity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.0F, 1.0F);
            worldIn.addEntity(rockEntity);
        }

        playerIn.addStat(Stats.ITEM_USED.get(this));
        if (!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }
}
