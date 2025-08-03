package tannyjung.skywiza_handcode.systems.world_gen;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import tannyjung.core.GameUtils;

public class FeatureLast extends Feature <NoneFeatureConfiguration> {

    public FeatureLast () {

        super(NoneFeatureConfiguration.CODEC);

    }

    @Override
    public boolean place (FeaturePlaceContext <NoneFeatureConfiguration> context) {

        LevelAccessor level_accessor = context.level();
        ServerLevel level_server = context.level().getLevel();
        ChunkGenerator chunk_generator = context.chunkGenerator();
        String dimension = GameUtils.misc.getCurrentDimensionID(level_server).replace(":", "-");
        ChunkPos chunk_pos = new ChunkPos(context.origin().getX() >> 4, context.origin().getZ() >> 4);

        WorldGenSpawner.start(level_accessor, chunk_pos);

        return true;

    }

}