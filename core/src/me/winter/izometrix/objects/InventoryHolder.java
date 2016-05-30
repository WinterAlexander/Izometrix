package me.winter.izometrix.objects;

public interface InventoryHolder
{
	public Item[] getItems();
	public int getMaxCapacity();
	public void open(Player p);
	public boolean addItem(Item item);
	public void clear();
}
