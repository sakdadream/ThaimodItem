package moderthai.item;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import moderthai.item.register.CreativeTabCustomItem;
import moderthai.item.register.IRegisterItem;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid="ModderThaiItem", name="ModderThaiItem", version="1.6.4")
public class MainMod {

	
	@SidedProxy(clientSide = "moderthai.item.clientproxy" , serverSide = "moderthai.item.serverproxy")
	public static serverproxy proxy;

	public static CreativeTabs ThaiModItem = new CreativeTabCustomItem(CreativeTabs.getNextID(), "ThaiModItem");
	@EventHandler
	public void preload(FMLPreInitializationEvent e) {

		IRegisterItem.preload();
		
	}
	@EventHandler
	public void load(FMLInitializationEvent e) {
		proxy.proxyregister();
	}
}
