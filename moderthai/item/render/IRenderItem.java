package moderthai.item.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import sun.java2d.loops.ScaledBlit;

public class IRenderItem implements IItemRenderer {
	//tutorial
	//https://www.minecraftforum.net/forums/mapping-and-modding-java-edition/mapping-and-modding-tutorials/1571595-1-10-2-how-to-code-custom-3d-armor-models?page=6#entry30852686
	
	ModelBase swordmodel ;
	
	public IRenderItem(ModelBase model) {
		this.swordmodel = model ;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		switch (type) {
		case INVENTORY:
			return true;
		default:
			break;
		}
		return false;

	}
	float scale = 0 ;
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {

		case EQUIPPED: // render in third person
			GL11.glPushMatrix(); // start gl rendering for this section
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("subaraki:weapons/Sword.png"));
			GL11.glRotatef(0F, 1.0f, 0.0f, 0.0f); // rotate 0 ° on X axis
			GL11.glRotatef(-5F, 0.0f, 1.0f, 0.0f); // rotate -5 ° on Y axis
			GL11.glRotatef(-150F, 0.0f, 0.0f, 1.0f); // rotate -150 ° on Z axis
			GL11.glTranslatef(-0.8F, 0.6F, -0.1F); // translate model to fit in the hand of the player
			// the entity argument can/could be passed to as null.
			swordmodel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix(); // Stop gl rendering for this section
			break;

		case EQUIPPED_FIRST_PERSON:

			// rince and repeat the rendering. adjust axis' and translation as needed
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("subaraki:weapons/Sword.png"));
			GL11.glRotatef(0F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(-5F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(-150F, 0.0f, 0.0f, 1.0f);
			GL11.glTranslatef(-0.8F, 0.9F, -0.1F);
			swordmodel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			break;

		case ENTITY:
			GL11.glPushMatrix();
			scale = 1.5F;
			GL11.glScalef(scale, scale, scale);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("subaraki:weapons/Sword.png"));
			GL11.glRotatef(90F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(0F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(45F, 0.0f, 0.0f, 1.0f);
			GL11.glTranslatef(-0.2F, 1F, 0F);
			swordmodel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			break;

		case INVENTORY:
			GL11.glPushMatrix();
			scale = 0.7F;
			GL11.glScalef(scale, scale, scale);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("subaraki:weapons/Sword.png"));

			//get WorldTime and Rotate 
			GL11.glRotatef(Minecraft.getMinecraft().theWorld.getWorldTime(), 1.0f, 1.0f, 1.0f);
			
			
			GL11.glRotatef(200F, 1.0f, 0.0f, 0.0f);
			GL11.glRotatef(-80F, 0.0f, 1.0f, 0.0f);
			GL11.glTranslatef(0.0F, 1.2F, 0F);
			// this is a method made by me in my model class to render only the modelparts,
			// without an entity argument, because in your inventory, //the entity is always
			// null.
			swordmodel.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			break;

		default:
			break;
		}
	}

}
