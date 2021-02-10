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

    public static DamageSource causeSourceDamage(DamageSource baseDamageSource, Entity source, @Nullable Entity indirectEntityIn) {
        return (new IndirectEntityDamageSource(baseDamageSource.getDamageType(), source, indirectEntityIn)).setProjectile();
    }

}
