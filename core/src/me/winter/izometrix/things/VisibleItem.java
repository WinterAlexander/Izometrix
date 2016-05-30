package me.winter.izometrix.things;

import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricWorld;

public abstract class VisibleItem extends Item
{
	public VisibleItem(IsometricWorld world) 
	{
		super(world);
	}

	public abstract GameTexture getTexture();
}
