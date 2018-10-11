package moderthai.item.register;

import moderthai.item.MainMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CustomItems extends Item {

	public CustomItems(int par1) {
		super(par1);
		this.setUnlocalizedName("customItem");
		this.setCreativeTab(MainMod.ThaiModItem);
	}

}
