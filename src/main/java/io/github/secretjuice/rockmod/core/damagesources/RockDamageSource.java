package io.github.secretjuice.rockmod.core.damagesources;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;

import javax.annotation.Nullable;

public class RockDamageSource {

    public static final DamageSource ROCK = new DamageSource("sj_rock_mod.rock").setProjectile();
    public static final DamageSource MAGMA_ROCK = new DamageSource("sj_rock_mod.magmarock").setProjectile();
    public static final DamageSource END_ROCK = new DamageSource("sj_rock_mod.endrock").setProjectile();
    public static final DamageSource OBSIDIAN_ROCK = new DamageSource("sj_rock_mod.obsidianrock").setProjectile();
    public static final DamageSource BOB_ROCKS = new DamageSource("sj_rock_mod.bobrocks").setProjectile();
    public static final DamageSource BLAST_ROCK = new DamageSource("sj_rock_mod.blastrock").setProjectile();
    public static final DamageSource DIORITE_ROCK = new DamageSource("sj_rock_mod.dioriterock").setProjectile();
    public static final DamageSource ANDESITE_ROCK = new DamageSource("sj_rock_mod.andesiterock").setProjectile();
    public static final DamageSource GRANITE_ROCK = new DamageSource("sj_rock_mod.graniterock").setProjectile();
    public static final DamageSource BASALT_ROCK = new DamageSource("sj_rock_mod.basaltrock").setProjectile();
    public static final DamageSource SAND_ROCK = new DamageSource("sj_rock_mod.sandrock").setProjectile();
    public static final DamageSource NETHER_ROCK = new DamageSource("sj_rock_mod.netherrock").setProjectile();
    public static final DamageSource MOSSY_ROCK = new DamageSource("sj_rock_mod.mossyrock").setProjectile();
    public static final DamageSource FERTILE_ROCK = new DamageSource("sj_rock_mod.fertilerock").setProjectile();
    public static final DamageSource FORCE_ROCK = new DamageSource("sj_rock_mod.forcerock").setProjectile();
    public static final DamageSource WEB_ROCK = new DamageSource("sj_rock_mod.webrock").setProjectile();
    public static final DamageSource FLAME_ROCK = new DamageSource("sj_rock_mod.flamerock").setProjectile();

    public static DamageSource causeSourceDamage(DamageSource baseDamageSource, Entity source, @Nullable Entity indirectEntityIn) {
        return (new IndirectEntityDamageSource(baseDamageSource.getDamageType(), source, indirectEntityIn)).setProjectile();
    }

}
