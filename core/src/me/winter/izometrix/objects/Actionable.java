package me.winter.izometrix.objects;

import me.winter.izometrix.Direction;
import me.winter.izometrix.Location;

public interface Actionable
{
	public void onClick(float mouseX, float mouseY);
	public void onPush(Location loc, Direction direction);
}
