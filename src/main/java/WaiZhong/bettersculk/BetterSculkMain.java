package WaiZhong.bettersculk;

import WaiZhong.bettersculk.init.ItemInit;
import net.fabricmc.api.ModInitializer;

public class BetterSculkMain implements ModInitializer {
    @Override
    public void onInitialize() {
        ItemInit.init();
    }
}
