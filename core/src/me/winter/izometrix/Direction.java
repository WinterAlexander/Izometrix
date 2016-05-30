package me.winter.izometrix;

public enum Direction
{
	TOP_LEFT(Text.DIRECTION_WEST, -1, 0),
	TOP_RIGHT(Text.DIRECTION_NORTH, 0, -1),
	BOTTOM_LEFT(Text.DIRECTION_SOUTH, 0, 1),
	BOTTOM_RIGHT(Text.DIRECTION_EAST, 1, 0),
	;
	
	private Text name;
	private int x, y;
	
	private Direction(Text name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public String getName()
	{
		return name.toString();
	}

	public int getX()
	{
		return x;
	}


	public int getY()
	{
		return y;
	}
}
