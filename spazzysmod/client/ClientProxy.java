package spazzysmod.client;

import spazzysmod.CommonProxy;
import spazzysmod.entity.SpazzysEntitys;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerEntities () {
		SpazzysEntitys.registerEntitySpawns();
		SpazzysEntitys.registerEntities();
	}
}