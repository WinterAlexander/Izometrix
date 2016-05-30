package me.winter.izometrix.objects;

import me.winter.izometrix.Direction;
import me.winter.izometrix.IsometricDrawer;
import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricWorld;
import me.winter.izometrix.Location;

public abstract class Wall extends IsometricObject implements Visible, Solid
{
	private int x, y, destX, destY;
	
	public Wall(IsometricWorld world, int x, int y, int destX, int destY)
	{
		super(world);
		this.x = x;
		this.y = y;
		this.destX = destX;
		this.destY = destY;
	}

	@Override
	public void init()
	{

	}

	@Override
	public void render(IsometricDrawer drawer)
	{
		drawer.drawWall(getLeftTexture(), getRightTexture(), this.x, this.y, this.destX, this.destY);
	}

	@Override
	public float getRenderPriority()
	{
		return (this.x + this.destX + this.y + this.destY) / 2;
	}
	
	@Override
	public boolean isBlocked(Location loc, int width, int height, Direction direction)
	{	
		if(this.x == this.destX)
		{
			if(loc.getX() == this.x && loc.getY() == Math.min(this.y, this.destY) && loc.getX() + direction.getX() == this.x - 1 && loc.getY() + direction.getY() == Math.min(this.y, this.destY))
				return true;
			
			if(loc.getX() + direction.getX() == this.x && loc.getY() + direction.getY() == Math.min(this.y, this.destY) && loc.getX() == this.x - 1 && loc.getY() == Math.min(this.y, this.destY))
				return true;
		}
		
		if(this.y == this.destY)
		{
			if(loc.getX() == Math.min(this.x, this.destX) && loc.getY() == this.y && loc.getX() + direction.getX() == Math.min(this.x, this.destX) && loc.getY() + direction.getY() == this.y - 1)
				return true;
			
			if(loc.getX() + direction.getX() == Math.min(this.x, this.destX) && loc.getY() + direction.getY() == this.y && loc.getX() == Math.min(this.x, this.destX) && loc.getY() == this.y - 1)
				return true;
		}
		
		return false;
	}
	
	public abstract GameTexture getLeftTexture();
	public abstract GameTexture getRightTexture();
}
