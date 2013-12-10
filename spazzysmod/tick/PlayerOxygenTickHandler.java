package spazzysmod.tick;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import spazzysmod.SpazzysmodBase;
import spazzysmod.api.planets.PlanetAPI;
import spazzysmod.item.SpazzysItems;
import spazzysmod.world.SpazzysDimensions;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PlayerOxygenTickHandler implements ITickHandler {
	static Minecraft mc = Minecraft.getMinecraft();
	private final EnumSet<TickType> ticksToGet;

	public PlayerOxygenTickHandler(EnumSet<TickType> ticksToGet) {
		this.ticksToGet = ticksToGet;
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		playerTick((EntityPlayer) tickData[0]);
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		playerTick((EntityPlayer) tickData[0]);
	}

	@Override
	public EnumSet<TickType> ticks() {
		return ticksToGet;
	}

	@Override
	public String getLabel() {
		return "PlayerOxygenTick";
	}

	public static void playerTick(EntityPlayer player) {
		for (int i = 0; i < PlanetAPI.getPlanetsList().size(); i++) {
			if (PlanetAPI.getPlanetsList().get(i)
					.getHasPlanetBreathableOxygen() == false
					&& PlanetAPI.getPlanetsList().get(i).getPlanetDimensionID() == player.dimension) {
				ItemStack currentHelmet = player.getCurrentArmor(3);
				ItemStack currentJacket = player.getCurrentArmor(2);
				ItemStack currentPants = player.getCurrentArmor(1);
				ItemStack currentFeet = player.getCurrentArmor(0);
				if (currentHelmet != null
						&& currentHelmet.itemID == SpazzysItems.spaceHelmet.itemID
						&& currentJacket != null
						&& currentJacket.itemID == SpazzysItems.spaceJacket.itemID
						&& currentPants != null
						&& currentPants.itemID == SpazzysItems.spacePants.itemID
						&& currentFeet != null
						&& currentFeet.itemID == SpazzysItems.spaceShoes.itemID) {

					currentHelmet.damageItem(1, player);
					currentJacket.damageItem(1, player);
					currentPants.damageItem(1, player);
					currentFeet.damageItem(1, player);

				} else {
					player.attackEntityFrom(DamageSource.inWall, 1F);
				}

			}
		}

	}
}