package WaiZhong.bettersculk.init;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

import static WaiZhong.bettersculk.init.BlockInit.SCULK_ORE;

public class OreInit {
    // test ore replaced feature
    // fill ~15 ~10 ~15 ~-15 ~-20 ~-15 air replace stone
    private static ConfiguredFeature<?, ?> OVERWORLD_ECHO_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
            (Feature.ORE, new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.SCULK),
                    SCULK_ORE.getDefaultState(),
                    7)); // vein size

    public static PlacedFeature OVERWORLD_ECHO_ORE_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(OVERWORLD_ECHO_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(45), // number of veins per chunk
                    SquarePlacementModifier.of(), // spreading horizontally
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(20))
            )); // height

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("bettersculk", "sculk_ore"), OVERWORLD_ECHO_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("bettersculk", "sculk_ore"),
                OVERWORLD_ECHO_ORE_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("bettersculk", "sculk_ore")));
    }
}
