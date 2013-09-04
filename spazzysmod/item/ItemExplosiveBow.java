package spazzysmod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import spazzysmod.SpazzysmodBase;
import spazzysmod.entity.projectile.EntityExplosiveArrow;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemExplosiveBow extends ItemBow {

	public ItemExplosiveBow(int par1) {
		super(par1);
	}

	@SideOnly(Side.CLIENT)
    private Icon [] bowIcons = new Icon [4];

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons ( IconRegister iconreg ) {
        this.itemIcon = iconreg.registerIcon ( SpazzysmodBase.modid + ":" + this.getUnlocalizedName ().substring ( 5 ) );

        for ( int i = 1; i < this.bowIcons.length; i++ )
            this.bowIcons[i] = iconreg.registerIcon ( SpazzysmodBase.modid + ":" + this.getUnlocalizedName().substring ( 5 ) + "_pull_" + ( i - 1 ) );
    }

    @Override
    public Icon getIcon ( ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining ) {
        if ( player.getItemInUse() == null )
            return this.itemIcon;
        int time = stack.getMaxItemUseDuration () - useRemaining;
        if ( time >= 18 )
            return this.bowIcons [3];
        else if ( time > 13 )
            return this.bowIcons [2];
        else if ( time > 0 )
            return this.bowIcons [1];

        return this.bowIcons [0];
    }

	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return;
		}
		j = event.charge;

		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

		if (flag || par3EntityPlayer.inventory.hasItem(SpazzysItems.explosiveArrow.itemID))
		{
			float f = (float)j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if ((double)f < 0.1D)
			{
				return;
			}

			if (f > 1.0F)
			{
				f = 1.0F;
			}

			EntityExplosiveArrow explosiveArrow = new EntityExplosiveArrow(par2World, par3EntityPlayer, f * 2.0F);

			if (f == 1.0F)
			{
				explosiveArrow.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

			if (k > 0)
			{
				explosiveArrow.setDamage(explosiveArrow.getDamage() + (double)k * 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

			if (l > 0)
			{
				explosiveArrow.setKnockbackStrength(l);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
			{
				explosiveArrow.setFire(100);
			}

			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag)
			{
				explosiveArrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.consumeInventoryItem(SpazzysItems.explosiveArrow.itemID);
			}

			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(explosiveArrow);
			}
		}
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		return par1ItemStack;
	}
}
