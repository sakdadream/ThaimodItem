package moderthai.item.register;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabCustomItem extends CreativeTabs {

	public CreativeTabCustomItem(int par1, String par2Str) {
		super(par1, par2Str);
		// TODO Auto-generated constructor stub
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
		return Item.appleGold.itemID;
	}

	public String getTranslatedTabLabel() {
		return "ThaimodItem";
	}
}
