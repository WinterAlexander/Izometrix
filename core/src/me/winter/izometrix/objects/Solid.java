package me.winter.izometrix.objects;

import me.winter.izometrix.Direction;
import me.winter.izometrix.Location;

public interface Solid
{
	boolean isBlocked(Location location, int width, int height, Direction direction);
}
