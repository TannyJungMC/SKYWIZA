package tannyjung.skywiza_handcode.world_gen.spawner;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FeatureSpawner extends Feature <NoneFeatureConfiguration> {

    public FeatureSpawner() {

        super(NoneFeatureConfiguration.CODEC);

    }

    @Override
    public boolean place (FeaturePlaceContext <NoneFeatureConfiguration> context) {

        Spawner.start(context);

        return true;

    }

}