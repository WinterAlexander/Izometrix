package me.winter.izometrix.objects;

import me.winter.izometrix.IsometricDrawer;

public interface Visible
{	
	public void render(IsometricDrawer drawer);
	public float getRenderPriority();
}
