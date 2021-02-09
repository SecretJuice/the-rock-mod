package io.github.secretjuice.rockmod.core.dispenserbehaviors;

import io.github.secretjuice.rockmod.common.entites.MagmaRockEntity;
import io.github.secretjuice.rockmod.common.entites.RockEntity;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import io.github.secretjuice.rockmod.core.init.ItemInit;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Util;
import net.minecraft.world.World;

public class RockDispenserBehavior {

    public static void init(){

        DispenserBlock.registerDispenseBehavior(ItemInit.ROCK.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new RockEntity((EntityType<? extends SnowballEntity>) EntityTypeInit.ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.MAGMA_ROCK.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new MagmaRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.MAGMA_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

    }



}
