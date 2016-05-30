package me.winter.izometrix.gui;

import me.winter.izometrix.GameTexture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DialogBox
{
	private boolean visible;
	private String[] content;
	private BitmapFont font;
	
	public DialogBox()
	{
		this.visible = false;
		this.content = null;
		this.font = new BitmapFont();
		this.font.setColor(Color.BLACK);
	}

	public void render(SpriteBatch batch)
	{
		if(!this.visible)
			return;
		
		int width = GameTexture.DIALOG_BOX.getWidth();
		
		if(Gdx.graphics.getWidth() < width)
			width = Gdx.graphics.getWidth();
		
		int height = width / GameTexture.DIALOG_BOX.getWidth() * GameTexture.DIALOG_BOX.getHeight();
		
		batch.draw(GameTexture.DIALOG_BOX.getTexture(), Gdx.graphics.getWidth() / 2 - width / 2, 0, width, height, GameTexture.DIALOG_BOX.getX(), GameTexture.DIALOG_BOX.getY(), GameTexture.DIALOG_BOX.getWidth(), GameTexture.DIALOG_BOX.getHeight(), GameTexture.DIALOG_BOX.isFlipX(), GameTexture.DIALOG_BOX.isFlipY());
		if(this.content != null && this.content.length != 0)
		{
			int y = height * 3 / 4;
			for(String line : content[0].split("\n"))
			{
				font.draw(batch, line, Gdx.graphics.getWidth() / 2 - width * 0.375f, y);
				y -= height / 4;
			}
		}
	}

	public boolean isVisible()
	{
		return visible;
	}

	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
	
	public void clear()
	{
		this.content = null;
		this.visible = false;
	}
	
	public void read(String[] content)
	{
		this.content = content;
		this.visible = true;
	}
	
	public void next()
	{
		if(this.content.length == 1)
		{
			this.visible = false;
			this.content = null;
		}
		else
		{
			String[] copy = new String[this.content.length - 1];
			for(int i = 0; i < copy.length; i++)
				copy[i] = this.content[i + 1];
			
			this.content = copy;
		}
	}
}
