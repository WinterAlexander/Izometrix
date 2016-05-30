package me.winter.izometrix;

import me.winter.izometrix.objects.Actionable;
import me.winter.izometrix.objects.IsometricObject;
import me.winter.izometrix.objects.Solid;
import me.winter.izometrix.objects.Visible;

import java.util.ArrayList;
import java.util.List;

public class IsometricWorld
{
	private int[] limits;
	
	private Izometrix game;
	private ArrayList<IsometricObject> things;
	private IsometricDrawer drawer;
	
	public IsometricWorld(Izometrix game, IsometricDrawer drawer, int[] limits)
	{
		if(game == null)
			throw new NullPointerException("scheduler CANNOT be null !");
		
		this.game = game;
		
		this.things = new ArrayList<IsometricObject>();
		
		if(drawer == null)
			throw new NullPointerException("drawer CANNOT be null !");
		
		this.drawer = drawer;
		
		
		if(limits != null)
			this.limits = limits;
		else
			this.limits = new int[]{-10, -10, 10, 10};
	}
	
	public String getName()
	{
		return "static-world";
	}
	
	public void render()
	{
		for(Visible thing : this.getThingsByPriority())
			if(thing != null)
				thing.render(drawer);
	}
	
	public Visible[] getThingsByPriority()
	{
		List<Visible> visibles = new ArrayList<Visible>();
		
		for(IsometricObject thing : this.things)
			if(thing instanceof Visible)
				visibles.add((Visible) thing);
		
		Visible[] result = new Visible[visibles.size()];
		
		for(int i = 0; i < result.length; i++)
		{
			for(Visible current : visibles)
			{
				boolean doContinue = false;
				for(Visible visible : result)
					if(current == visible)
					{
						doContinue = true;
						break;
					}
				if(doContinue)
					continue;
						
				
				if(result[i] == null || result[i].getRenderPriority() > current.getRenderPriority())
					result[i] = current;
			}
		}
		return result;
	}
	
	public void addThing(IsometricObject thing)
	{
		this.things.add(thing);
		thing.init();
	}
	
	public Izometrix getGame()
	{
		return this.game;
	}

	public Scheduler getScheduler()
	{
		return this.game.getScheduler();
	}
	
	public IsometricDrawer getDrawer()
	{
		return this.drawer;
	}
	
	public void setDrawer(IsometricDrawer drawer)
	{
		if(drawer == null)
			throw new NullPointerException("drawer CANNOT be null !");
		
		this.drawer = drawer;
	}
	
	public boolean canMove(Location loc, int width, int height, Direction direction)
	{
		if(loc.getX() + direction.getX() < limits[0])
			return false;
		
		if(loc.getX() + direction.getX() > limits[2])
			return false;
		
		if(loc.getY() + direction.getY() < limits[1])
			return false;
		
		if(loc.getY() + direction.getY() > limits[3])
			return false;
		
		for(IsometricObject thing : this.things)
			if(thing instanceof Solid)
				if(((Solid) thing).isBlocked(loc, width, height, direction))
					return false;
		return true;
	}

	public void push(Location loc, Direction direction)
	{
		for(IsometricObject thing : this.things)
			if(thing instanceof Actionable)
				((Actionable) thing).onPush(loc, direction);
	}

	public List<IsometricObject> getThings()
	{
		return this.things;
	}
}
