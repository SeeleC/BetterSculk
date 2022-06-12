package WaiZhong.bettersculk.mixin;

import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import static WaiZhong.bettersculk.init.ItemInit.*;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity{
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow
    public PlayerInventory getInventory() { return null; }

    @Override
    protected float applyArmorToDamage(DamageSource source, float amount) {
        System.out.println(this.getInventory().getArmorStack(3).getItem().equals(ECHO_ARMOR_HELMET));
        if (!source.bypassesArmor() | this.getInventory().getArmorStack(3).getItem().equals(ECHO_ARMOR_HELMET) | this.getInventory().getArmorStack(2).getItem().equals(ECHO_ARMOR_CHESTPLATE) | this.getInventory().getArmorStack(1).getItem().equals(ECHO_ARMOR_LEGGINGS) | this.getInventory().getArmorStack(0).getItem().equals(ECHO_ARMOR_BOOTS)) {
            this.damageArmor(source, amount);
            amount = DamageUtil.getDamageLeft(amount, (float)this.getArmor(), (float)this.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS));
        }

        return amount;
    }
}
