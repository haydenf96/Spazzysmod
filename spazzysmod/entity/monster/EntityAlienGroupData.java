package spazzysmod.entity.monster;

import net.minecraft.entity.EntityLivingData;

class EntityAlienGroupData implements EntityLivingData {
	public boolean field_142048_a;
	public boolean field_142046_b;

	final EntityAlien field_142047_c;

	private EntityAlienGroupData(EntityAlien par1EntityZombie, boolean par2,
			boolean par3) {
		this.field_142047_c = par1EntityZombie;
		this.field_142048_a = false;
		this.field_142046_b = false;
		this.field_142048_a = par2;
		this.field_142046_b = par3;
	}

	EntityAlienGroupData(EntityAlien par1EntityZombie, boolean par2,
			boolean par3, EntityAlienINNER1 par4EntityZombieINNER1) {
		this(par1EntityZombie, par2, par3);
	}
}
