package me.winter.izometrix.things;

import me.winter.izometrix.IsometricWorld;

public abstract class IsometricThing
{
	private IsometricWorld world;
	
	public IsometricThing(IsometricWorld world)
	{
		this.world = world;
	}
	
	public IsometricWorld getWorld()
	{
		return world;
	}
	
	public abstract void init();
}
