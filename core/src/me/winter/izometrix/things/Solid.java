package me.winter.izometrix.things;

import me.winter.izometrix.Direction;
import me.winter.izometrix.Location;

public interface Solid
{
	boolean isBlocked(Location location, int width, int height, Direction direction);
}
