package me.winter.izometrix.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Settings 
{
	private boolean open;
	
	public void render(SpriteBatch batch)
	{
		if(!open)
			return;
	}
	
	public void onClick(int mouseX, int mouseY)
	{
		
	}

	public boolean isOpen()
	{
		return open;
	}

	public void setOpen(boolean open)
	{
		this.open = open;
	}
}
