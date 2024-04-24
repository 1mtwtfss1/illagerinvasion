package fuzs.illagerinvasion.init;

import fuzs.extensibleenums.api.v2.CommonAbstractions;
import fuzs.illagerinvasion.IllagerInvasion;
import fuzs.illagerinvasion.world.entity.monster.*;
import fuzs.illagerinvasion.world.entity.projectile.FlyingMagma;
import fuzs.illagerinvasion.world.entity.projectile.Hatchet;
import fuzs.illagerinvasion.world.entity.projectile.SkullBolt;
import fuzs.illagerinvasion.world.inventory.ImbuingMenu;
import fuzs.illagerinvasion.world.item.*;
import fuzs.illagerinvasion.world.level.block.ImbuingTableBlock;
import fuzs.illagerinvasion.world.level.block.MagicFireBlock;
import fuzs.illagerinvasion.world.level.levelgen.structure.pools.LegacySingleNoLiquidPoolElement;
import fuzs.illagerinvasion.world.level.levelgen.structure.pools.SingleNoLiquidPoolElement;
import fuzs.illagerinvasion.world.level.levelgen.structure.structures.LabyrinthStructure;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.puzzleslib.api.init.v3.tags.BoundTagFactory;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.SpellcasterIllager;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.LegacySinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElementType;
import net.minecraft.world.level.material.MapColor;

public class ModRegistry {
    static final RegistryManager REGISTRY = RegistryManager.from(IllagerInvasion.MOD_ID);
    public static final Holder.Reference<Block> IMBUING_TABLE_BLOCK = REGISTRY.registerBlock("imbuing_table", () -> new ImbuingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));
    public static final Holder.Reference<Block> MAGIC_FIRE_BLOCK = REGISTRY.registerBlock("magic_fire", () -> new MagicFireBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_FIRE).mapColor(MapColor.COLOR_PURPLE).randomTicks()));
    public static final Holder.Reference<Item> IMBUIING_TABLE_ITEM = REGISTRY.registerBlockItem(ModRegistry.IMBUING_TABLE_BLOCK);
    public static final Holder.Reference<Item> UNUSUAL_DUST_ITEM = REGISTRY.registerItem("unusual_dust", () -> new Item(new Item.Properties()));
    public static final Holder.Reference<Item> MAGICAL_FIRE_CHARGE_ITEM = REGISTRY.registerItem("magical_fire_charge", () -> new MagicalFireChargeItem(new Item.Properties()));
    public static final Holder.Reference<Item> ILLUSIONARY_DUST_ITEM = REGISTRY.registerItem("illusionary_dust", () -> new IllusionaryDustItem(new Item.Properties()));
    public static final Holder.Reference<Item> LOST_CANDLE_ITEM = REGISTRY.registerItem("lost_candle", () -> new LostCandleItem(new Item.Properties()));
    public static final Holder.Reference<Item> HORN_OF_SIGHT_ITEM = REGISTRY.registerItem("horn_of_sight", () -> new HornOfSightItem(new Item.Properties().stacksTo(1), ModRegistry.HORN_OF_SIGHT_INSTRUMENT_TAG));
    public static final Holder.Reference<Item> HALLOWED_GEM_ITEM = REGISTRY.registerItem("hallowed_gem", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final Holder.Reference<Item> PRIMAL_ESSENCE_ITEM = REGISTRY.registerItem("primal_essence", () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final Holder.Reference<Item> PLATINUM_CHUNK_ITEM = REGISTRY.registerItem("platinum_chunk", () -> new Item(new Item.Properties()));
    public static final Holder.Reference<Item> PLATINUM_SHEET_ITEM = REGISTRY.registerItem("platinum_sheet", () -> new Item(new Item.Properties()));
    public static final Holder.Reference<Item> PLATINUM_INFUSED_HATCHET_ITEM = REGISTRY.registerItem("platinum_infused_hatchet", () -> new HatchetItem(new Item.Properties().durability(327)));
    public static final Holder.Reference<EntityType<Provoker>> PROVOKER_ENTITY_TYPE = REGISTRY.registerEntityType("provoker", () -> EntityType.Builder.of(Provoker::new, MobCategory.MONSTER).sized(0.5F, 1.92F));
    public static final Holder.Reference<EntityType<Invoker>> INVOKER_ENTITY_TYPE = REGISTRY.registerEntityType("invoker", () -> EntityType.Builder.of(Invoker::new, MobCategory.MONSTER).sized(0.5f, 1.92f).fireImmune());
    public static final Holder.Reference<EntityType<Necromancer>> NECROMANCER_ENTITY_TYPE = REGISTRY.registerEntityType("necromancer", () -> EntityType.Builder.of(Necromancer::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final Holder.Reference<EntityType<Basher>> BASHER_ENTITY_TYPE = REGISTRY.registerEntityType("basher", () -> EntityType.Builder.of(Basher::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final Holder.Reference<EntityType<Sorcerer>> SORCERER_ENTITY_TYPE = REGISTRY.registerEntityType("sorcerer", () -> EntityType.Builder.of(Sorcerer::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final Holder.Reference<EntityType<Archivist>> ARCHIVIST_ENTITY_TYPE = REGISTRY.registerEntityType("archivist", () -> EntityType.Builder.of(Archivist::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final Holder.Reference<EntityType<Inquisitor>> INQUISITOR_ENTITY_TYPE = REGISTRY.registerEntityType("inquisitor", () -> EntityType.Builder.of(Inquisitor::new, MobCategory.MONSTER).sized(0.5f, 2.48f));
    public static final Holder.Reference<EntityType<Marauder>> MARAUDER_ENTITY_TYPE = REGISTRY.registerEntityType("marauder", () -> EntityType.Builder.of(Marauder::new, MobCategory.MONSTER).sized(0.5f, 1.92f).canSpawnFarFromPlayer());
    public static final Holder.Reference<EntityType<Alchemist>> ALCHEMIST_ENTITY_TYPE = REGISTRY.registerEntityType("alchemist", () -> EntityType.Builder.of(Alchemist::new, MobCategory.MONSTER).sized(0.5f, 1.92f));
    public static final Holder.Reference<EntityType<Firecaller>> FIRECALLER_ENTITY_TYPE = REGISTRY.registerEntityType("firecaller", () -> EntityType.Builder.of(Firecaller::new, MobCategory.MONSTER).sized(0.5f, 1.92f).fireImmune());
    public static final Holder.Reference<EntityType<Surrendered>> SURRENDERED_ENTITY_TYPE = REGISTRY.registerEntityType("surrendered", () -> EntityType.Builder.of(Surrendered::new, MobCategory.MONSTER).sized(0.5f, 1.42f).fireImmune());
    public static final Holder.Reference<EntityType<SkullBolt>> SKULL_BOLT_ENTITY_TYPE = REGISTRY.registerLazily(Registries.ENTITY_TYPE, "skull_bolt");
    public static final Holder.Reference<EntityType<Hatchet>> HATCHET_ENTITY_TYPE = REGISTRY.registerLazily(Registries.ENTITY_TYPE, "hatchet");
    public static final Holder.Reference<EntityType<InvokerFangs>> INVOKER_FANGS_ENTITY_TYPE = REGISTRY.registerEntityType("invoker_fangs", () -> EntityType.Builder.<InvokerFangs>of(InvokerFangs::new, MobCategory.MISC).sized(0.65f, 1.05f));
    public static final Holder.Reference<EntityType<FlyingMagma>> FLYING_MAGMA_ENTITY_TYPE = REGISTRY.registerEntityType("flying_magma", () -> EntityType.Builder.<FlyingMagma>of(FlyingMagma::new, MobCategory.MISC).sized(0.95f, 1.05f));
    public static final Holder.Reference<Item> PROVOKER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(PROVOKER_ENTITY_TYPE, 9541270, 9399876);
    public static final Holder.Reference<Item> BASHER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(BASHER_ENTITY_TYPE, 9541270, 5985087);
    public static final Holder.Reference<Item> SORCERER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(SORCERER_ENTITY_TYPE, 9541270, 10899592);
    public static final Holder.Reference<Item> ARCHIVIST_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(ARCHIVIST_ENTITY_TYPE, 9541270, 13251893);
    public static final Holder.Reference<Item> INQUISITOR_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(INQUISITOR_ENTITY_TYPE, 9541270, 4934471);
    public static final Holder.Reference<Item> MARAUDER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(MARAUDER_ENTITY_TYPE, 9541270, 5441030);
    public static final Holder.Reference<Item> INVOKER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(INVOKER_ENTITY_TYPE, 9541270, 0xCEC987);
    public static final Holder.Reference<Item> ALCHEMIST_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(ALCHEMIST_ENTITY_TYPE, 9541270, 7550099);
    public static final Holder.Reference<Item> FIRECALLER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(FIRECALLER_ENTITY_TYPE, 9541270, 14185784);
    public static final Holder.Reference<Item> NECROMANCER_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(NECROMANCER_ENTITY_TYPE, 9541270, 9585210);
    public static final Holder.Reference<Item> SURRENDERED_SPAWN_EGG_ITEM = REGISTRY.registerSpawnEggItem(SURRENDERED_ENTITY_TYPE, 11260369, 11858160);
    public static final Holder.Reference<Item> ILLUSIONER_SPAWN_EGG_ITEM = REGISTRY.registerItem("illusioner_spawn_egg", () -> new SpawnEggItem(EntityType.ILLUSIONER, 0x135893, 9541270, new Item.Properties()));
    public static final Holder.Reference<Potion> BERSERKING_POTION = REGISTRY.registerPotion("berserking", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 1), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1)));
    public static final Holder.Reference<Potion> LONG_BERSERKING_POTION = REGISTRY.registerPotion("long_berserking", () -> new Potion("berserking", new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0)));
    public static final Holder.Reference<Potion> STRONG_BERSERKING_POTION = REGISTRY.registerPotion("strong_berserking", () -> new Potion("berserking", new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 2), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 2)));
    public static final Holder.Reference<MenuType<ImbuingMenu>> IMBUING_MENU_TYPE = REGISTRY.registerMenuType("imbuing", () -> ImbuingMenu::new);
    public static final Holder.Reference<SimpleParticleType> MAGIC_FLAME_PARTICLE_TYPE = REGISTRY.register(Registries.PARTICLE_TYPE, "magic_flame", () -> new SimpleParticleType(false));
    public static final Holder.Reference<SimpleParticleType> NECROMANCER_BUFF_PARTICLE_TYPE = REGISTRY.register(Registries.PARTICLE_TYPE, "necromancer_buff", () -> new SimpleParticleType(false));
    public static final Holder.Reference<SoundEvent> HORN_OF_SIGHT_SOUND_EVENT = REGISTRY.registerSoundEvent("item.horn_of_sight.blow");
    public static final Holder.Reference<SoundEvent> LOST_CANDLE_DIAMOND_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.diamond");
    public static final Holder.Reference<SoundEvent> LOST_CANDLE_IRON_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.iron");
    public static final Holder.Reference<SoundEvent> LOST_CANDLE_COAL_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.coal");
    public static final Holder.Reference<SoundEvent> LOST_CANDLE_COPPER_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.copper");
    public static final Holder.Reference<SoundEvent> LOST_CANDLE_GOLD_SOUND_EVENT = REGISTRY.registerSoundEvent("item.lost_candle.gold");
    public static final Holder.Reference<SoundEvent> SURRENDERED_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.surrendered.ambient");
    public static final Holder.Reference<SoundEvent> SURRENDERED_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.surrendered.hurt");
    public static final Holder.Reference<SoundEvent> SURRENDERED_CHARGE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.surrendered.charge");
    public static final Holder.Reference<SoundEvent> SURRENDERED_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.surrendered.death");
    public static final Holder.Reference<SoundEvent> NECROMANCER_SUMMON_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.necromancer.summon");
    public static final Holder.Reference<SoundEvent> ARCHIVIST_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.archivist.ambient");
    public static final Holder.Reference<SoundEvent> ARCHIVIST_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.archivist.hurt");
    public static final Holder.Reference<SoundEvent> ARCHIVIST_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.archivist.death");
    public static final Holder.Reference<SoundEvent> INVOKER_FANGS_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.fangs");
    public static final Holder.Reference<SoundEvent> INVOKER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.hurt");
    public static final Holder.Reference<SoundEvent> INVOKER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.death");
    public static final Holder.Reference<SoundEvent> INVOKER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.ambient");
    public static final Holder.Reference<SoundEvent> INVOKER_COMPLETE_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.completecast");
    public static final Holder.Reference<SoundEvent> INVOKER_TELEPORT_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.teleport_cast");
    public static final Holder.Reference<SoundEvent> INVOKER_FANGS_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.fangs_cast");
    public static final Holder.Reference<SoundEvent> INVOKER_BIG_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.big_cast");
    public static final Holder.Reference<SoundEvent> INVOKER_SUMMON_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.summon_cast");
    public static final Holder.Reference<SoundEvent> INVOKER_SHIELD_BREAK_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.shield_break");
    public static final Holder.Reference<SoundEvent> INVOKER_SHIELD_CREATE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.invoker.shield_create");
    public static final Holder.Reference<SoundEvent> ILLAGER_BRUTE_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.illager_brute.ambient");
    public static final Holder.Reference<SoundEvent> ILLAGER_BRUTE_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.illager_brute.hurt");
    public static final Holder.Reference<SoundEvent> ILLAGER_BRUTE_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.illager_brute.death");
    public static final Holder.Reference<SoundEvent> PROVOKER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.provoker.idle");
    public static final Holder.Reference<SoundEvent> PROVOKER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.provoker.hurt");
    public static final Holder.Reference<SoundEvent> PROVOKER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.provoker.death");
    public static final Holder.Reference<SoundEvent> PROVOKER_CELEBRATE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.provoker.celebrate");
    public static final Holder.Reference<SoundEvent> BASHER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.basher.idle");
    public static final Holder.Reference<SoundEvent> BASHER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.basher.hurt");
    public static final Holder.Reference<SoundEvent> BASHER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.basher.death");
    public static final Holder.Reference<SoundEvent> BASHER_CELEBRATE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.basher.celebrate");
    public static final Holder.Reference<SoundEvent> FIRECALLER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.firecaller.idle");
    public static final Holder.Reference<SoundEvent> FIRECALLER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.firecaller.hurt");
    public static final Holder.Reference<SoundEvent> FIRECALLER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.firecaller.death");
    public static final Holder.Reference<SoundEvent> FIRECALLER_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.firecaller.cast");
    public static final Holder.Reference<SoundEvent> SORCERER_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.cast");
    public static final Holder.Reference<SoundEvent> SORCERER_COMPLETE_CAST_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.complete_cast");
    public static final Holder.Reference<SoundEvent> SORCERER_HURT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.hurt");
    public static final Holder.Reference<SoundEvent> SORCERER_DEATH_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.death");
    public static final Holder.Reference<SoundEvent> SORCERER_AMBIENT_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.idle");
    public static final Holder.Reference<SoundEvent> SORCERER_CELEBRATE_SOUND_EVENT = REGISTRY.registerSoundEvent("entity.sorcerer.celebrate");
    public static final Holder.Reference<Instrument> REVEAL_INSTRUMENT = REGISTRY.register(Registries.INSTRUMENT, "reveal", () -> new Instrument(ModRegistry.HORN_OF_SIGHT_SOUND_EVENT, 120, 48.0F));
    public static final Holder.Reference<StructurePoolElementType<SinglePoolElement>> SINGLE_POOL_ELEMENT_TYPE = REGISTRY.register(Registries.STRUCTURE_POOL_ELEMENT, "single_pool_element", () -> () -> SingleNoLiquidPoolElement.CODEC);
    public static final Holder.Reference<StructurePoolElementType<LegacySinglePoolElement>> LEGACY_SINGLE_POOL_ELEMENT_TYPE = REGISTRY.register(Registries.STRUCTURE_POOL_ELEMENT, "legacy_single_pool_element", () -> () -> LegacySingleNoLiquidPoolElement.CODEC);
    public static final Holder.Reference<StructureType<LabyrinthStructure>> LABYRINTH_STRUCTURE_TYPE = REGISTRY.register(Registries.STRUCTURE_TYPE, "labyrinth", () -> () -> LabyrinthStructure.CODEC);

    static final BoundTagFactory TAGS = BoundTagFactory.make(IllagerInvasion.MOD_ID);
    public static final TagKey<Enchantment> IMBUING_ENCHANTMENT_TAG = TAGS.registerEnchantmentTag("imbuing");
    public static final TagKey<Instrument> HORN_OF_SIGHT_INSTRUMENT_TAG = TAGS.registerTagKey(Registries.INSTRUMENT, "horn_of_sight");
    public static final TagKey<Biome> HAS_FIRECALLER_HUT_BIOME_TAG = TAGS.registerTagKey(Registries.BIOME, "has_structure/firecaller_hut");
    public static final TagKey<Biome> HAS_ILLAGER_FORT_BIOME_TAG = TAGS.registerTagKey(Registries.BIOME, "has_structure/illager_fort");
    public static final TagKey<Biome> HAS_ILLUSIONER_TOWER_BIOME_TAG = TAGS.registerTagKey(Registries.BIOME, "has_structure/illusioner_tower");
    public static final TagKey<Biome> HAS_SORCERER_HUT_BIOME_TAG = TAGS.registerTagKey(Registries.BIOME, "has_structure/sorcerer_hut");
    public static final TagKey<Biome> HAS_LABYRINTH_BIOME_TAG = TAGS.registerTagKey(Registries.BIOME, "has_structure/labyrinth");

    public static final ResourceKey<TrimMaterial> PLATINUM_TRIM_MATERIAL = REGISTRY.makeResourceKey(Registries.TRIM_MATERIAL, "platinum");

    public static final ResourceLocation ILLAGER_FORT_TOWER_LOOT_TABLE = REGISTRY.makeKey("chests/illager_fort_tower");
    public static final ResourceLocation ILLAGER_FORT_GROUND_LOOT_TABLE = REGISTRY.makeKey("chests/illager_fort_ground");
    public static final ResourceLocation ILLUSIONER_TOWER_ENTRANCE_LOOT_TABLE = REGISTRY.makeKey("chests/illusioner_tower_entrance");
    public static final ResourceLocation ILLUSIONER_TOWER_STAIRS_LOOT_TABLE = REGISTRY.makeKey("chests/illusioner_tower_stairs");
    public static final ResourceLocation LABYRINTH_LOOT_TABLE = REGISTRY.makeKey("chests/labyrinth");
    public static final ResourceLocation LABYRINTH_MAP_LOOT_TABLE = REGISTRY.makeKey("chests/labyrinth_map");
    public static final ResourceLocation SORCERER_HUT_LOOT_TABLE = REGISTRY.makeKey("chests/sorcerer_hut");
    public static final ResourceLocation ILLUSIONER_INJECT_LOOT_TABLE = REGISTRY.makeKey("entities/inject/illusioner");
    public static final ResourceLocation PILLAGER_INJECT_LOOT_TABLE = REGISTRY.makeKey("entities/inject/pillager");
    public static final ResourceLocation RAVAGER_INJECT_LOOT_TABLE = REGISTRY.makeKey("entities/inject/ravager");

    public static final SpellcasterIllager.IllagerSpell ENCHANT_ILLAGER_SPELL = registerIllagerSpell("enchant", 121, 161, 161);
    public static final SpellcasterIllager.IllagerSpell CONJURE_FLAMES_ILLAGER_SPELL = registerIllagerSpell("conjure_flames", 194, 41, 36);
    public static final SpellcasterIllager.IllagerSpell CONJURE_TELEPORT_ILLAGER_SPELL = registerIllagerSpell("conjure_teleport", 64, 35, 81);
    public static final SpellcasterIllager.IllagerSpell NECRO_RAISE_ILLAGER_SPELL = registerIllagerSpell("necro_raise", 78, 73, 52);
    public static final SpellcasterIllager.IllagerSpell CONJURE_SKULL_BOLT_ILLAGER_SPELL = registerIllagerSpell("conjure_skull_bolt", 44, 53, 26);
    public static final SpellcasterIllager.IllagerSpell PROVOKE_ILLAGER_SPELL = registerIllagerSpell("provoke", 235, 123, 109);

    private static SpellcasterIllager.IllagerSpell registerIllagerSpell(String internalName, int redColor, int greenColor, int blueColor) {
        return CommonAbstractions.createIllagerSpell(IllagerInvasion.id(internalName), redColor / 255.0, greenColor / 255.0, blueColor / 255.0);
    }

    public static void touch() {

    }
}
