package me.winter.izometrix.things;

import me.winter.izometrix.Direction;
import me.winter.izometrix.IsometricWorld;
import me.winter.izometrix.Location;

public abstract class Furniture extends IsometricThing implements Solid, Visible
{
	private int x, y, width, height;

	public Furniture(IsometricWorld world, int x, int y, int width, int height)
	{
		super(world);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public float getRenderPriority()
	{
		return x + y;
	}

	@Override
	public boolean isBlocked(Location loc, int width, int height, Direction direction)
	{
		if(this.getX() >= loc.getX() + width + direction.getX())
			return false;
		if(this.getX() + this.width <= loc.getX() + direction.getX())
			return false;
		if(this.getY() >= loc.getY() + height + direction.getY())
			return false;
		if(this.getY() + this.height <= loc.getY() + direction.getY())
			return false;
		
		return true;
	}

	@Override
	public void init()
	{

	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
}
