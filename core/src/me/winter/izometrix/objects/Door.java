package me.winter.izometrix.objects;

import me.winter.izometrix.Direction;
import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricDrawer;
import me.winter.izometrix.IsometricWorld;
import me.winter.izometrix.Location;

public class Door extends Wall implements Actionable
{
	private boolean open;
	
	public Door(IsometricWorld world, int x, int y, int destX, int destY)
	{
		super(world, x, y, destX, destY);
		this.open = false;
	}


	@Override
	public void onClick(float mouseX, float mouseY)
	{

	}

	@Override
	public void onPush(Location loc, Direction direction)
	{
		if(this.isBlocked(loc, 1, 1, direction))
			this.open = true;
	}

	@Override
	public void render(IsometricDrawer drawer)
	{
		if(!this.open)
			super.render(drawer);
	}
	
	@Override
	public boolean isBlocked(Location location, int width, int height, Direction direction)
	{
		if(open)
			return false;
		return super.isBlocked(location, width, height, direction);
	}

	@Override
	public GameTexture getLeftTexture()
	{
		return GameTexture.WOODEN_DOOR_LEFT;
	}

	@Override
	public GameTexture getRightTexture()
	{
		return GameTexture.WOODEN_DOOR_RIGHT;
	}

}
