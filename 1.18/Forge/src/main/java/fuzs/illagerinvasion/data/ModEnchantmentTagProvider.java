package fuzs.illagerinvasion.data;

import fuzs.illagerinvasion.init.ModRegistry;
import fuzs.puzzleslib.api.data.v1.AbstractTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class ModEnchantmentTagProvider extends AbstractTagProvider.Simple<Enchantment> {

    public ModEnchantmentTagProvider(GatherDataEvent evt, String modId) {
        super(Registry.ENCHANTMENT, evt, modId);
    }

    @Override
    protected void addTags() {
        // list taken from Quark's ancient tomes, thanks!
        this.tag(ModRegistry.IMBUING_ENCHANTMENT_TAG).add(Enchantments.ALL_DAMAGE_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.FIRE_PROTECTION, Enchantments.FALL_PROTECTION, Enchantments.THORNS, Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.KNOCKBACK, Enchantments.FIRE_ASPECT, Enchantments.MOB_LOOTING, Enchantments.SWEEPING_EDGE, Enchantments.BLOCK_EFFICIENCY, Enchantments.UNBREAKING, Enchantments.BLOCK_FORTUNE, Enchantments.POWER_ARROWS, Enchantments.PUNCH_ARROWS, Enchantments.FISHING_LUCK, Enchantments.FISHING_SPEED, Enchantments.LOYALTY, Enchantments.RIPTIDE, Enchantments.IMPALING, Enchantments.PIERCING);
    }
}
