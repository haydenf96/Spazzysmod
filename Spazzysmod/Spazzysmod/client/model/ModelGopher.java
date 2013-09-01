package spazzysmod.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGopher extends ModelBase {

	// fields
	ModelRenderer head;
	ModelRenderer tail;
	ModelRenderer ear2;
	ModelRenderer body;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer ear1;
	ModelRenderer leg4;

	public ModelGopher() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -4F, -8F, 5, 5, 4);
		head.setRotationPoint(0F, 18F, -2F);
		head.setTextureSize(64, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		tail = new ModelRenderer(this, 16, 20);
		tail.addBox(0F, 0F, 0F, 1, 1, 2);
		tail.setRotationPoint(-2F, 17F, 0F);
		tail.setTextureSize(64, 64);
		tail.mirror = true;
		setRotation(tail, 0F, 0F, 0F);
		ear2 = new ModelRenderer(this, 26, 4);
		ear2.addBox(0F, 0F, 0F, 1, 1, 1);
		ear2.setRotationPoint(-3F, 13F, -10F);
		ear2.setTextureSize(64, 64);
		ear2.mirror = true;
		setRotation(ear2, 0F, 0F, 0F);
		body = new ModelRenderer(this, 28, 8);
		body.addBox(-5F, -10F, -7F, 7, 7, 5);
		body.setRotationPoint(0F, 15F, 3F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 1.570796F, 0F, 0F);
		leg1 = new ModelRenderer(this, 28, 36);
		leg1.addBox(-2F, 0F, -2F, 2, 3, 2);
		leg1.setRotationPoint(-3F, 21F, 0F);
		leg1.setTextureSize(64, 64);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 8, 40);
		leg2.addBox(-2F, 0F, -10F, 2, 3, 2);
		leg2.setRotationPoint(2F, 21F, 8F);
		leg2.setTextureSize(64, 64);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 12, 30);
		leg3.addBox(-2F, 18F, -2F, 2, 3, 2);
		leg3.setRotationPoint(-3F, 3F, -5F);
		leg3.setTextureSize(64, 64);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		ear1 = new ModelRenderer(this, 20, 6);
		ear1.addBox(-1F, 8F, -9F, 1, 1, 1);
		ear1.setRotationPoint(0F, 5F, -1F);
		ear1.setTextureSize(64, 64);
		ear1.mirror = true;
		setRotation(ear1, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 22, 28);
		leg4.addBox(-2F, 0F, -2F, 2, 3, 2);
		leg4.setRotationPoint(2F, 21F, -5F);
		leg4.setTextureSize(64, 64);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		head.render(f5);
		tail.render(f5);
		ear2.render(f5);
		body.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		ear1.render(f5);
		leg4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
		leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * .1F * f1;
		leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* .15F * f1;
		leg1.rotateAngleY = 0.0F;
		leg2.rotateAngleY = 0.0F;
		leg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * .1F * f1;
		leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* .15F * f1;
		leg3.rotateAngleY = 0.0F;
		leg4.rotateAngleY = 0.0F;
	}

}
