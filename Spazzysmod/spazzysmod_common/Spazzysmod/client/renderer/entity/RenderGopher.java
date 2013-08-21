package Spazzysmod.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import Spazzysmod.client.model.ModelGopher;
import Spazzysmod.entity.passive.EntityGopher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGopher extends RenderLiving {

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
}