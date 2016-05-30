package me.winter.izometrix.gui;

import me.winter.izometrix.GameTexture;

public class MenuHeader extends Button
{

	public MenuHeader()
	{
		super(1, null, new Runnable()
		{
			@Override
			public void run(){}
		});
	}

	public GameTexture getTexture()
	{
		return GameTexture.LOGO;
	}
	
	public GameTexture getHoverTexture()
	{
		return getTexture();
	}
}
