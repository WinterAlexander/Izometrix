package me.winter.izometrix;


public class Location
{
	private IsometricWorld world;
	private int x, y;
	
	public Location(IsometricWorld world, int x, int y)
	{
		this.world = world;
		this.x = x;
		this.y = y;
	}
	
	public IsometricWorld getWorld()
	{
		return world;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	@Override
	public String toString()
	{
		return (this.world != null ? this.world.getName() : "null") + ": " + x + ", " + y;
	}

	public Location add(Direction direction)
	{
		this.x += direction.getX();
		this.y += direction.getY();
		return this;
	}

	@Override
	public Location clone()
	{
		return new Location(this.world, this.x, this.y);
	}
	
	@Override
	public boolean equals(Object loc)
	{
		if(!(loc instanceof Location))
			return false;
		
		return this.world == ((Location) loc).getWorld() && this.x == ((Location) loc).getX() && this.y == ((Location) loc).getY();
	}
}
