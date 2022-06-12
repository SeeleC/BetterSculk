package WaiZhong.bettersculk.item;

import WaiZhong.bettersculk.material.SculkArmorMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class EchoArmorItem extends ArmorItem {
    public EchoArmorItem(EquipmentSlot slot) {
        super(new SculkArmorMaterial(), slot, new Item.Settings());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        MutableText mutableText = Text.translatable("armor.echo.tooltip");
        tooltip.add(mutableText.formatted(Formatting.GRAY));
    }
}
