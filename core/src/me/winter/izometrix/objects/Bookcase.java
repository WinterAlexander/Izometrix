package me.winter.izometrix.objects;

import me.winter.izometrix.Direction;
import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricDrawer;
import me.winter.izometrix.IsometricWorld;
import me.winter.izometrix.Location;

public class Bookcase extends Furniture implements Actionable
{

	public Bookcase(IsometricWorld world, int x, int y)
	{
		super(world, x, y, 1, 2);
	}

	@Override
	public void render(IsometricDrawer drawer)
	{
		drawer.drawOnTile(GameTexture.WOODEN_BOOKCASE, getX(), getY(), 1f, 1.5f, -0.25f, -0.25f);
	}

	@Override
	public void onClick(float mouseX, float mouseY)
	{
		//getWorld().getGame().getGui().getDialogBox().read(new String[]{"Tout cela n'a pas l'air vraiment intéressant...\nEn plus ça sent mauvais."});
	}

	@Override
	public void onPush(Location loc, Direction direction)
	{
		if(this.isBlocked(loc, 1, 1, direction))
			getWorld().getGame().getGui().getDialogBox().read(new String[]{"Tout cela n'a pas l'air vraiment intéressant...\nEn plus ça sent mauvais."});
	}
}
