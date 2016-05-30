package me.winter.izometrix.objects;

import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricWorld;

public class StoneWall extends Wall
{
	public StoneWall(IsometricWorld world, int x, int y, int destX, int destY)
	{
		super(world, x, y, destX, destY);
	}

	@Override
	public GameTexture getLeftTexture()
	{
		return GameTexture.WALL_STONE_LEFT;
	}

	@Override
	public GameTexture getRightTexture()
	{
		return GameTexture.WALL_STONE_RIGHT;
		
	}
}
