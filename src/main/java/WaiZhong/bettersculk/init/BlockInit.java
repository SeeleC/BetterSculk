package WaiZhong.bettersculk.init;

import WaiZhong.bettersculk.block.EchoOre;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockInit {
    public static final Block SCULK_ORE = new EchoOre(FabricBlockSettings
            .of(Material.SCULK)
            .hardness(0.6f)
            .requiresTool()
            .nonOpaque()
    );

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier("bettersculk", "sculk_ore"), SCULK_ORE);
        Registry.register(Registry.ITEM, new Identifier("bettersculk", "sculk_ore"), new BlockItem(SCULK_ORE, new Item.Settings()));
    }
}
