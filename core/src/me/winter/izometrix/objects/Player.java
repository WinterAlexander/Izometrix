package me.winter.izometrix.objects;

import me.winter.izometrix.Direction;
import me.winter.izometrix.IsometricDrawer;
import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricWorld;
import me.winter.izometrix.Location;
import me.winter.izometrix.Task;

public class Player extends Entity implements InventoryHolder, Controllable
{
	private Item[] items;
	
	private Direction direction;
	private int x, y;
	private float movement;

	
	public Player(IsometricWorld world, int x, int y)
	{
		super(world);
		this.x = x;
		this.y = y;
		this.movement = 0;
		this.direction = Direction.TOP_LEFT;
		
		this.items = new Item[20];
	}

	@Override
	public void init()
	{
		getWorld().getScheduler().addTask(new PlayerMoveTask(25));
	}
	
	@Override
	public void render(IsometricDrawer drawer)
	{
		GameTexture texture = null;
		switch(direction)
		{
		case BOTTOM_LEFT:
			if(movement == 0)
				texture = GameTexture.PLAYER_FRONTLEFT_STANDBY;
			else if(movement <= 0.5f)
				texture = GameTexture.PLAYER_FRONTLEFT_WALK_RIGHTFEET;
			else
				texture = GameTexture.PLAYER_FRONTLEFT_WALK_LEFTFEET;
			break;
		case BOTTOM_RIGHT:
			if(movement == 0)
				texture = GameTexture.PLAYER_FRONTRIGHT_STANDBY;
			else if(movement <= 0.5f)
				texture = GameTexture.PLAYER_FRONTRIGHT_WALK_RIGHTFEET;
			else
				texture = GameTexture.PLAYER_FRONTRIGHT_WALK_LEFTFEET;
			break;
		case TOP_LEFT:
			if(movement == 0)
				texture = GameTexture.PLAYER_BEHINDLEFT_STANDBY;
			else if(movement <= 0.5f)
				texture = GameTexture.PLAYER_BEHINDLEFT_WALK_RIGHTFEET;
			else
				texture = GameTexture.PLAYER_BEHINDLEFT_WALK_LEFTFEET;
			break;
		case TOP_RIGHT:
			if(movement == 0)
				texture = GameTexture.PLAYER_BEHINDRIGHT_STANDBY;
			else if(movement <= 0.5f)
				texture = GameTexture.PLAYER_BEHINDRIGHT_WALK_RIGHTFEET;
			else
				texture = GameTexture.PLAYER_BEHINDRIGHT_WALK_LEFTFEET;
			break;
		}

		drawer.drawOnTile(texture, getMovingX(), getMovingY(), 1f, 1.5f);
		
	}
	
	public Location getLocation()
	{
		return new Location(getWorld(), x, y);
	}
	
	public float getMovingX()
	{
		return x + direction.getX() * Math.min(movement, 1);
	}
	
	public float getMovingY()
	{
		return y + direction.getY() * Math.min(movement, 1);
	}
	
	private class PlayerMoveTask extends Task
	{
		public PlayerMoveTask(long d)
		{
			super(d);
		}

		@Override
		public void run()
		{
			getWorld().getDrawer().center(getMovingX(), getMovingY());
			if(movement >= 1)
			{
				movement = 0;
				x += direction.getX();
				y += direction.getY();
				
			}
			
			if(movement != 0)
			{
				movement += 0.1f;
				return;
			}

			if(getWorld().getGame().getGui().getArrows().getCurrentDirection() == null)
				return;

			if(direction != getWorld().getGame().getGui().getArrows().getCurrentDirection())
			{
				direction = getWorld().getGame().getGui().getArrows().getCurrentDirection();
				return;
			}

			if(getWorld().canMove(getLocation(), 1, 1, direction))
				movement = 0.1f;
			else
				getWorld().push(getLocation(), direction);

		}
	}

	@Override
	public float getRenderPriority()
	{
		return getMovingX() + getMovingY();
	}

	@Override
	public Item[] getItems()
	{
		return items;
	}

	@Override
	public int getMaxCapacity()
	{
		return this.items.length;
	}

	@Override
	public void open(Player p)
	{
		
	}

	@Override
	public boolean addItem(Item item)
	{
		for(int i = 0; i < getMaxCapacity(); i++)
			if(this.items[i] == null)
			{
				this.items[i] = item;
				return true;
			}
		
		return false;
	}

	@Override
	public void clear()
	{
		this.items = new Item[this.items.length];
	}
}
