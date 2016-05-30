package me.winter.izometrix.objects;

import me.winter.izometrix.IsometricWorld;

public abstract class Entity extends IsometricObject implements Visible
{
	public Entity(IsometricWorld world)
	{
		super(world);
	}
}
