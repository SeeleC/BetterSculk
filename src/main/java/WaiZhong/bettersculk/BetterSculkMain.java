package WaiZhong.bettersculk;

import WaiZhong.bettersculk.init.BlockInit;
import WaiZhong.bettersculk.init.ItemInit;
import WaiZhong.bettersculk.init.OreInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static WaiZhong.bettersculk.init.BlockInit.SCULK_ORE;
import static WaiZhong.bettersculk.init.ItemInit.*;

public class BetterSculkMain implements ModInitializer {


    @Override
    public void onInitialize() {
        ItemInit.init();
        BlockInit.init();
        OreInit.init();
    }

    public static final ItemGroup GROUP = FabricItemGroupBuilder.create(
                    new Identifier("bettersculk", "group")
            ).icon(() -> new ItemStack(SCULK_BONE))
            .appendItems(itemStacks -> {
                itemStacks.add(new ItemStack(SCULK_ORE));
                itemStacks.add(new ItemStack(ECHO_ARMOR_HELMET));
                itemStacks.add(new ItemStack(ECHO_ARMOR_CHESTPLATE));
                itemStacks.add(new ItemStack(ECHO_ARMOR_LEGGINGS));
                itemStacks.add(new ItemStack(ECHO_ARMOR_BOOTS));
                itemStacks.add(new ItemStack(SCULK_BONE));
            }).build();
}
