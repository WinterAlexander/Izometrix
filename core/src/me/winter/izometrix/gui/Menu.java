package me.winter.izometrix.gui;

import me.winter.izometrix.GameTexture;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu
{
	private boolean open;
	private ArrayList<Button> buttons;
	private BitmapFont font;
	private GlyphLayout layout;
	
	public Menu()
	{
		this.buttons = new ArrayList<Button>();
		this.font = new BitmapFont();
		this.font.setColor(Color.BLACK);
		this.layout = new GlyphLayout();
		this.open = false;
	}
	
	public void render(SpriteBatch batch)
	{
		if(!open)
			return;
		
		int width = GameTexture.MENU.getWidth();
		
		if(Gdx.graphics.getWidth() < width)
			width = Gdx.graphics.getWidth();
		
		int height = width / GameTexture.MENU.getWidth() * GameTexture.MENU.getHeight();
		
		batch.draw(GameTexture.MENU.getTexture(), Gdx.graphics.getWidth() / 2 - width / 2, Gdx.graphics.getHeight() / 2 - height / 2, width, height, GameTexture.MENU.getX(), GameTexture.MENU.getY(), GameTexture.MENU.getWidth(), GameTexture.MENU.getHeight(), GameTexture.MENU.isFlipX(), GameTexture.MENU.isFlipY());
		
		int buttonWidth = width / 2;
		int buttonHeight = buttonWidth / GameTexture.BUTTON.getWidth() * GameTexture.BUTTON.getHeight();
		
		for(Button button : this.buttons)
		{
			int x = Gdx.graphics.getWidth() / 2 - buttonWidth / 2;
			int y = Gdx.graphics.getHeight() / 2 + height / 2 - buttonHeight * (button.getSlot() + 1);
			
			GameTexture texture;
			
			switch(Gdx.app.getType())
			{
			case Android:
			case iOS:
				if(!Gdx.input.isTouched())
				{
					texture = button.getTexture();
					break;
				}
			case HeadlessDesktop:
			case Desktop:
			case Applet:
			case WebGL:
				if(Gdx.input.getX() >= x && Gdx.input.getX() <= x + buttonWidth && (Gdx.graphics.getHeight() - Gdx.input.getY()) >= y && (Gdx.graphics.getHeight() - Gdx.input.getY()) <= y + buttonHeight)
				{
					texture = button.getHoverTexture();
					break;
				}
				texture = button.getTexture();
				break;
			default:
				texture = null;
			}
			
			if(texture != null)
				batch.draw(texture.getTexture(), x, y, buttonWidth, buttonHeight, texture.getX(), texture.getY(), texture.getWidth(), texture.getHeight(), texture.isFlipX(), texture.isFlipY());
			
			if(button.getContent() != null)
			{
				this.layout.setText(this.font, button.getContent());
				this.font.draw(batch, this.layout, Gdx.graphics.getWidth() / 2 - this.layout.width / 2, y + this.font.getCapHeight() + this.font.getCapHeight());
			}
		}
	}
	
	public void onClick(int mouseX, int mouseY)
	{
		if(!open)
			return;
		
		int width = GameTexture.MENU.getWidth();
		
		if(Gdx.graphics.getWidth() < width)
			width = Gdx.graphics.getWidth();
		
		int height = width / GameTexture.MENU.getWidth() * GameTexture.MENU.getHeight();
		
		int buttonWidth = width / 2;
		int buttonHeight = buttonWidth / GameTexture.BUTTON.getWidth() * GameTexture.BUTTON.getHeight();
		
		for(Button button : new ArrayList<Button>(this.buttons))
		{
			int x = Gdx.graphics.getWidth() / 2 - buttonWidth / 2;
			int y = Gdx.graphics.getHeight() / 2 + height / 2 - buttonHeight * (button.getSlot() + 1);
			
			if(Gdx.input.getX() >= x && Gdx.input.getX() <= x + buttonWidth && (Gdx.graphics.getHeight() - Gdx.input.getY()) >= y && (Gdx.graphics.getHeight() - Gdx.input.getY()) <= y + buttonHeight)
				button.onClick();
		}
	}
	
	public void addButton(Button button)
	{
		if(button == null)
			return;
		
		this.buttons.add(button);
	}
	
	public void clearSlot(int slot)
	{
		for(Button button : new ArrayList<Button>(this.buttons))
			if(button.getSlot() == slot)
				this.buttons.remove(button);
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
