package moderthai.item.register;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IRegisterItem {

	static int startID = 2000;
	
	public static Item item,item3d;
	
	
	public static void preload() {
		item = new CustomItems(startID++);
		GameRegistry.registerItem(item, "customItem");
		LanguageRegistry.addName(item, "CustomItem");
		
		
		item3d = new CustomItems(startID++);
		GameRegistry.registerItem(item3d, "customItem3D");
		LanguageRegistry.addName(item3d, "CustomItem3D");
	}

}
