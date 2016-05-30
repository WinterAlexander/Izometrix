package me.winter.izometrix.objects;

import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricWorld;

public class CrackedStoneFloor extends Floor
{
	public CrackedStoneFloor(IsometricWorld world, int x, int y)
	{
		super(world, x, y);
	}

	@Override
	public GameTexture getTexture()
	{
		return GameTexture.FLOOR_STONE_CRACKED;
	}
}