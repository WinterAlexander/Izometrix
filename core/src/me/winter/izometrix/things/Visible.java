package me.winter.izometrix.things;

import me.winter.izometrix.IsometricDrawer;

public interface Visible
{	
	public void render(IsometricDrawer drawer);
	public float getRenderPriority();
}
