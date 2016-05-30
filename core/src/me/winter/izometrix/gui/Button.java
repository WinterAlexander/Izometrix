package me.winter.izometrix.gui;


import me.winter.izometrix.GameTexture;
import me.winter.izometrix.Text;

public class Button
{
	private int slot;
	private Text content;
	private Runnable action;
	
	public Button(int slot, Text content, Runnable action)
	{
		this.slot = slot;
		this.content = content;
		this.action = action;
	}
	
	public int getSlot()
	{
		return slot;
	}
	
	public String getContent()
	{
		if(content == null)
			return null;
		return content.toString();
	}
	
	public void onClick()
	{
		if(this.action == null)
			return;
		this.action.run();
	}
	
	public GameTexture getTexture()
	{
		return GameTexture.BUTTON;
	}
	
	public GameTexture getHoverTexture()
	{
		return GameTexture.BUTTON_HOVER;
	}
}
