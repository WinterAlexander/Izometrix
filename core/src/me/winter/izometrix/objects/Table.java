package me.winter.izometrix.objects;

import me.winter.izometrix.IsometricDrawer;
import me.winter.izometrix.GameTexture;
import me.winter.izometrix.IsometricWorld;

public class Table extends Furniture implements InventoryHolder
{
	private Item[] item;
	
	public Table(IsometricWorld world, int x, int y)
	{
		super(world, x, y, 1, 1);
		this.item = new Item[1];
	}
	
	@Override
	public void render(IsometricDrawer drawer)
	{
		drawer.drawOnTile(GameTexture.WOODEN_TABLE, getX(), getY(), 1f, 1f);
		if(this.item != null && this.item[0] instanceof VisibleItem)
			drawer.drawOnTile(((VisibleItem) this.item[0]).getTexture(), getX(), getY(), 0.5f, 0.5f, 0.5f, 0.5f);
	}

	@Override
	public int getMaxCapacity()
	{
		return this.item.length;
	}

	@Override
	public void open(Player p)
	{
		p.addItem(this.item[0]);
		this.item[0] = null;
	}

	@Override
	public Item[] getItems()
	{
		return this.item;
	}

	@Override
	public boolean addItem(Item item)
	{
		if(this.item[0] != null)
			return false;
		this.item[0] = item;
		return true;
	}

	@Override
	public void clear()
	{
		this.item[0] = null;
	}
}
