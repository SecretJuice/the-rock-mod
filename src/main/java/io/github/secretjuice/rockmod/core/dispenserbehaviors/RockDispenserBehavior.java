package io.github.secretjuice.rockmod.core.dispenserbehaviors;

import io.github.secretjuice.rockmod.common.entites.*;
import io.github.secretjuice.rockmod.core.init.EntityTypeInit;
import io.github.secretjuice.rockmod.core.init.ItemInit;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class RockDispenserBehavior {

    @MethodsReturnNonnullByDefault
    public static void init(){

        DispenserBlock.registerDispenseBehavior(ItemInit.ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new RockEntity((EntityType<? extends SnowballEntity>) EntityTypeInit.ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.MAGMA_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new MagmaRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.MAGMA_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.END_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new EndRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.END_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.OBSIDIAN_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new ObsidianRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.OBSIDIAN_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.BOB_ROCKS.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new BobRocksEntity((EntityType<? extends RockEntity>) EntityTypeInit.BOB_ROCKS_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.BLAST_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new BlastRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.BLAST_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.ANDESITE_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new AndesiteRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.ANDESITE_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.BASALT_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new BasaltRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.BASALT_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.DIORITE_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new DioriteRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.DIORITE_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.GRANITE_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new GraniteRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.GRANITE_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.SAND_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new SandRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.SAND_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.NETHER_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new NetherRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.NETHER_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.MOSSY_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new MossyRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.MOSSY_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.FERTILE_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new FertileRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.FERTILE_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

        DispenserBlock.registerDispenseBehavior(ItemInit.FORCE_ROCK.get(), new ProjectileDispenseBehavior() {
            @ParametersAreNonnullByDefault
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                return (ProjectileEntity) Util.make(new ForceRockEntity((EntityType<? extends RockEntity>) EntityTypeInit.FORCE_ROCK_ENTITY, worldIn, position.getX(), position.getY(), position.getZ()), (rock) -> {
                    rock.setItem(stackIn);
                });
            }
        });

    }



}
