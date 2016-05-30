package me.winter.izometrix;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;

public enum GameTexture
{
	FLOOR_STONE_NORMAL("Floor/stone_brick.png"),
	FLOOR_STONE_CRACKED("Floor/stone_brick_cracked.png"),
	
	WALL_STONE_LEFT("Wall/stone_left.png"),
	WALL_STONE_RIGHT("Wall/stone_right.png"),
	
	PLAYER("Entity/player.png"),
	
	PLAYER_FRONTLEFT_STANDBY(PLAYER, 0, 0, 16, 24, false, false),
	PLAYER_FRONTRIGHT_STANDBY(PLAYER, 0, 0, 16, 24, true, false),
	PLAYER_BEHINDLEFT_STANDBY(PLAYER, 0, 24, 16, 24, true, false),
	PLAYER_BEHINDRIGHT_STANDBY(PLAYER, 0, 24, 16, 24, false, false),
	
	PLAYER_FRONTLEFT_WALK_LEFTFEET(PLAYER, 32, 0, 16, 24, false, false),
	PLAYER_FRONTLEFT_WALK_RIGHTFEET(PLAYER, 16, 0, 16, 24, false, false),
	
	PLAYER_FRONTRIGHT_WALK_LEFTFEET(PLAYER, 32, 0, 16, 24, true, false),
	PLAYER_FRONTRIGHT_WALK_RIGHTFEET(PLAYER, 16, 0, 16, 24, true, false),
	
	PLAYER_BEHINDLEFT_WALK_LEFTFEET(PLAYER, 32, 24, 16, 24, true, false),
	PLAYER_BEHINDLEFT_WALK_RIGHTFEET(PLAYER, 16, 24, 16, 24, true, false),
	
	PLAYER_BEHINDRIGHT_WALK_LEFTFEET(PLAYER, 32, 24, 16, 24, false, false),
	PLAYER_BEHINDRIGHT_WALK_RIGHTFEET(PLAYER, 16, 24, 16, 24, false, false),
	
	OLDMAN("Entity/player.png"),
	
	OLDMAN_FRONTLEFT_STANDBY(OLDMAN, 0, 0, 16, 24, false, false),
	OLDMAN_FRONTRIGHT_STANDBY(OLDMAN, 0, 0, 16, 24, true, false),
	OLDMAN_BEHINDLEFT_STANDBY(OLDMAN, 0, 24, 16, 24, true, false),
	OLDMAN_BEHINDRIGHT_STANDBY(OLDMAN, 0, 24, 16, 24, false, false),
	
	OLDMAN_FRONTLEFT_WALK_LEFTFEET(OLDMAN, 32, 0, 16, 24, false, false),
	OLDMAN_FRONTLEFT_WALK_RIGHTFEET(OLDMAN, 16, 0, 16, 24, false, false),
	
	OLDMAN_FRONTRIGHT_WALK_LEFTFEET(OLDMAN, 32, 0, 16, 24, true, false),
	OLDMAN_FRONTRIGHT_WALK_RIGHTFEET(OLDMAN, 16, 0, 16, 24, true, false),
	
	OLDMAN_BEHINDLEFT_WALK_LEFTFEET(OLDMAN, 32, 24, 16, 24, true, false),
	OLDMAN_BEHINDLEFT_WALK_RIGHTFEET(OLDMAN, 16, 24, 16, 24, true, false),
	
	OLDMAN_BEHINDRIGHT_WALK_LEFTFEET(OLDMAN, 32, 24, 16, 24, false, false),
	OLDMAN_BEHINDRIGHT_WALK_RIGHTFEET(OLDMAN, 16, 24, 16, 24, false, false),
	
	WOODEN_TABLE("Furniture/wooden/table.png"),
	WOODEN_BUFFET("Furniture/wooden/buffet.png"),
	WOODEN_BOOKCASE("Furniture/wooden/bookcase.png"),
	WOODEN_CHEST("Furniture/wooden/chest.png"),
	
	WOODEN_DOOR_LEFT("Furniture/wooden/door.png"),
	WOODEN_DOOR_RIGHT(WOODEN_DOOR_LEFT, true, false),
	
	TV_1("Furniture/TV1.png"),
	TV_2("Furniture/TV2.png"),
	TV_3("Furniture/TV3.png"),
	
	BOOK("Item/book.png"), 
	CANDLE_SMALL("Item/candle_small.png"),
	CANDLE_MEDIUM_OFF("Item/candle_medium.png", 0, 0, 8, 16, false, false),
	CANDLE_MEDIUM_ON(CANDLE_MEDIUM_OFF, 8, 0, 8, 16, false, false),
	
	
	DIALOG_BOX("Gui/dialog.png"),
	MENU("Gui/menu.png"),
	LOGO("Gui/logo.png"),
	BUTTON("Gui/button.png"),
	BUTTON_HOVER("Gui/button_hover.png"),
	
	;
	
	private Texture texture;
	private int x, y, width, height;
	private boolean flipX, flipY;
	

	GameTexture(String file, int x, int y, int width, int height, boolean flipX, boolean flipY)
	{
		this(file);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.flipX = flipX;
		this.flipY = flipY;
	}
	
	GameTexture(GameTexture texture, int x, int y, int width, int height, boolean flipX, boolean flipY)
	{
		this.texture = texture.getTexture();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.flipX = flipX;
		this.flipY = flipY;
	}
	
	GameTexture(String file)
	{
		try
		{
			this.texture = new Texture(file);
		}
		catch(Exception e)
		{
			Pixmap pixmap = new Pixmap(64, 64, Format.RGBA8888);
			pixmap.setColor(0.8f, 0.8f, 0.8f, 1f);
			this.texture = new Texture(pixmap);
		}
		this.x = 0;
		this.y = 0;
		this.width = this.texture.getWidth();
		this.height = this.texture.getHeight();
		this.flipX = false;
		this.flipY = false;
	}
	
	GameTexture(GameTexture texture, boolean flipX, boolean flipY)
	{
		this.texture = texture.getTexture();
		this.x = texture.getX();
		this.y = texture.getY();
		this.width = texture.getWidth();
		this.height = texture.getHeight();
		this.flipX = flipX;
		this.flipY = flipY;
	}
	
	public Texture getTexture()
	{
		return this.texture;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public boolean isFlipX()
	{
		return flipX;
	}

	public boolean isFlipY()
	{
		return flipY;
	}

}
