package me.winter.izometrix.things;

import me.winter.izometrix.IsometricDrawer;
import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricWorld;

public abstract class Floor extends IsometricThing implements Visible
{
	private int x, y;
	
	public Floor(IsometricWorld world, int x, int y)
	{
		super(world);
		this.x = x;
		this.y = y;
	}

	@Override
	public void render(IsometricDrawer drawer)
	{
		drawer.drawFloor(getTexture(), x, y);
	}

	@Override
	public float getRenderPriority()
	{
		return x + y - 1;
	}

	@Override
	public void init()
	{
		
	}
	
	public abstract GameTexture getTexture();
}
