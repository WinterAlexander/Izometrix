package me.winter.izometrix.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gui
{
	private DirectionalArrows arrows;
	private DialogBox dialogBox;
	private Menu menu;
	private Settings settings;
	
	public Gui()
	{
		this.arrows = new DirectionalArrows();
		this.dialogBox = new DialogBox();
		this.menu = new Menu();
		this.settings = new Settings();
	}
	
	public void render(SpriteBatch batch)
	{
		this.arrows.render(batch);
		this.dialogBox.render(batch);
		this.menu.render(batch);
		this.settings.render(batch);
	}
	
	public DirectionalArrows getArrows()
	{
		return arrows;
	}

	public DialogBox getDialogBox()
	{
		return dialogBox;
	}
	
	public Menu getMenu()
	{
		return this.menu;
	}
	
	public Settings getSettings()
	{
		return this.settings;
	}
}
