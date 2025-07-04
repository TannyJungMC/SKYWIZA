package tannyjung.skywiza_handcode.systems.world_gen;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FeatureLast extends Feature <NoneFeatureConfiguration> {

    public FeatureLast() {

        super(NoneFeatureConfiguration.CODEC);

    }

    @Override
    public boolean place (FeaturePlaceContext <NoneFeatureConfiguration> context) {

        WorldGenSpawner.start(context);
        return true;

    }

}