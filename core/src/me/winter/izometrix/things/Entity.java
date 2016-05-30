package me.winter.izometrix.things;

import me.winter.izometrix.IsometricWorld;

public abstract class Entity extends IsometricThing implements Visible
{
	public Entity(IsometricWorld world)
	{
		super(world);
	}
}
