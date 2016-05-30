package me.winter.izometrix.objects;

import me.winter.izometrix.IsometricWorld;

public abstract class IsometricObject
{
	private IsometricWorld world;
	
	public IsometricObject(IsometricWorld world)
	{
		this.world = world;
	}
	
	public IsometricWorld getWorld()
	{
		return world;
	}
	
	public abstract void init();
}
