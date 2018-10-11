package moderthai.item;

import moderthai.item.register.IRegisterItem;
import moderthai.item.render.IRenderItem;
import net.minecraft.client.model.ModelBoat;
import net.minecraftforge.client.MinecraftForgeClient;

public class clientproxy extends serverproxy{
@Override
public void proxyregister() {
	super.proxyregister();
	MinecraftForgeClient.registerItemRenderer(IRegisterItem.item3d.itemID,new IRenderItem(new ModelBoat()));
}
}
