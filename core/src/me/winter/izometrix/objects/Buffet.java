package me.winter.izometrix.objects;

import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricDrawer;
import me.winter.izometrix.IsometricWorld;

public class Buffet extends Furniture implements InventoryHolder
{
	private Item[] items;
	
	public Buffet(IsometricWorld world, int x, int y, int capacity)
	{
		super(world, x, y, 1, 1);
		this.items = new Item[capacity];
	}

	@Override
	public void render(IsometricDrawer drawer)
	{	
		drawer.drawOnTile(GameTexture.WOODEN_BUFFET, getX(), getY(), 0.75f, 0.75f);
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
