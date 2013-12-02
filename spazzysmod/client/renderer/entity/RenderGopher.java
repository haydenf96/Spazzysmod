package spazzysmod.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import spazzysmod.client.model.ModelGopher;
import spazzysmod.entity.passive.EntityGopher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGopher extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(
			"spazzysmod:textures/models/Gopher.png");
	protected ModelGopher ModelGopher;

	public RenderGopher() {
		super(new ModelGopher(), 0.5F);
		this.ModelGopher = (ModelGopher) this.mainModel;
		this.setRenderPassModel(this.mainModel);
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		this.renderTameEbby((EntityGopher) par1Entity, par2, par4, par6, par8,
				par9);
	}

	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		this.renderTameEbby((EntityGopher) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}

	public void renderTameEbby(EntityGopher par1EntityTameEbby, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityTameEbby, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation func_110832_a(EntityGopher par1EntityGopher) {
		return texture;
	}

	protected ResourceLocation func_110775_a(Entity par1Entity) {
		return this.func_110832_a((EntityGopher) par1Entity);
	}
}