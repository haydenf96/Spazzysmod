package spazzysmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import spazzysmod.SpazzysmodBase;
import spazzysmod.client.renderer.entity.RenderAlien;
import spazzysmod.client.renderer.entity.RenderGopher;
import spazzysmod.entity.monster.EntityAlien;
import spazzysmod.entity.passive.EntityGopher;
import spazzysmod.world.biome.SpazzysBiomes;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SpazzysEntitys {
	static int startEntityId = 215;

	public static void registerEntitySpawns() {
		EntityRegistry.addSpawn(EntityGopher.class, 20, 2, 4,
				EnumCreatureType.creature, BiomeGenBase.forest,
				BiomeGenBase.desert, BiomeGenBase.desertHills,
				BiomeGenBase.forestHills, BiomeGenBase.beach,
				BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.plains);

		EntityRegistry.addSpawn(EntityAlien.class, 20, 2, 4,
				EnumCreatureType.monster, SpazzysBiomes.marsBiome);

		LanguageRegistry.instance().addStringLocalization("entity.spazzysmod.Gopher.name", "en_US", "Gopher");
		registerEntityEgg(EntityGopher.class, 0x7F3300, 0x8E3900);

		LanguageRegistry.instance().addStringLocalization("entity.spazzysmod.Alien.name", "en_US", "Alien");
		registerEntityEgg(EntityAlien.class, 0x7F3300, 0x8E3900);
	}

	public static void registerEntities() {
		EntityRegistry.registerModEntity(EntityGopher.class, "Gopher", 1, SpazzysmodBase.instance, 80, 1, true);
		RenderingRegistry.registerEntityRenderingHandler(EntityGopher.class, new RenderGopher());

		EntityRegistry.registerModEntity(EntityAlien.class, "Alien", 1, SpazzysmodBase.instance, 80, 1, true);
		RenderingRegistry.registerEntityRenderingHandler(EntityAlien.class, new RenderAlien());
	}

	public static int getUniqueEntityId() {

		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);

		return startEntityId;
	}

	public static void registerEntityEgg(Class<? extends Entity> entity,
			int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();

		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,
				secondaryColor));
	}
}
