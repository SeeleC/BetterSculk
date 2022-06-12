package WaiZhong.bettersculk.init;

import WaiZhong.bettersculk.material.SculkArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ItemInit {
    public static final ArmorMaterial SCULK_ARMOR_MATERIAL = new SculkArmorMaterial();
    public static final Item ECHO_ARMOR_HELMET = new ArmorItem(SCULK_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings());
    public static final Item ECHO_ARMOR_CHESTPLATE = new ArmorItem(SCULK_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings());
    public static final Item ECHO_ARMOR_LEGGINGS = new ArmorItem(SCULK_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings());
    public static final Item ECHO_ARMOR_BOOTS = new ArmorItem(SCULK_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings());
    public static final Item SCULK_BONE = new Item(new Item.Settings().rarity(Rarity.RARE));

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier("bettersculk", "echo_helmet"), ECHO_ARMOR_HELMET);
        Registry.register(Registry.ITEM, new Identifier("bettersculk", "echo_chestplate"), ECHO_ARMOR_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("bettersculk", "echo_leggings"), ECHO_ARMOR_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("bettersculk", "echo_boots"), ECHO_ARMOR_BOOTS);

        Registry.register(Registry.ITEM, new Identifier("bettersculk", "sculk_bone"), SCULK_BONE);
    }
}
