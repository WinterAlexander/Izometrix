package me.winter.izometrix;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class IsometricDrawer
{
	private static final int[] TILE_SIZES = new int[]{4, 8, 16, 32, 64, 128, 256, 512};
	
	private int zoom;
	private SpriteBatch batch;
	private float centerX, centerY;
	
	public IsometricDrawer(SpriteBatch batch, int zoom)
	{
		if(zoom < 0)
			zoom = 0;
		
		if(zoom >= TILE_SIZES.length)
			zoom = TILE_SIZES.length -1;
		this.zoom = zoom;
		this.batch = batch;
	}
	
	public void drawOnTile(GameTexture texture, float x, float y, float width, float height, float offsetX, float offsetY)
	{
		batch.draw(texture.getTexture(), getXFromTile(x, y) + offsetX * getTileWidth(), getYFromTile(x, y) + offsetY * getTileWidth(), width * getTileWidth(), height * getTileWidth(), texture.getX(), texture.getY(), texture.getWidth(), texture.getHeight(), texture.isFlipX(), texture.isFlipY());
	}
	
	public void drawOnTile(GameTexture texture, float x, float y, float width, float height)
	{
		batch.draw(texture.getTexture(), getXFromTile(x, y) + getTileWidth() / 2 - width * getTileWidth() / 2, getYFromTile(x, y) + getTileWidth() / 2 - width * getTileWidth() / 2, width * getTileWidth(), height * getTileWidth(), texture.getX(), texture.getY(), texture.getWidth(), texture.getHeight(), texture.isFlipX(), texture.isFlipY());
	}
	
	public void drawFloor(GameTexture texture, float x, float y)
	{
		batch.draw(texture.getTexture(), getXFromTile(x, y), getYFromTile(x, y), getTileWidth(), getTileWidth() / 2, texture.getX(), texture.getY(), texture.getWidth(), texture.getHeight(), texture.isFlipX(), texture.isFlipY());
	}
	
	public void drawWall(GameTexture leftTexture, GameTexture rightTexture, int x, int y, int destX, int destY)
	{
		if(destX == x)
		{
			if(y < destY)
			{
				drawLeftWall(leftTexture, x, y);
			}
			else if(y > destY)
			{
				drawLeftWall(leftTexture, x, destY);
			}
		}
		else if(destY == y)
		{
			if(x < destX)
			{
				drawRightWall(rightTexture, x, y);
			}
			else if(x > destX)
			{
				drawRightWall(rightTexture, destX, y);
			}
		}
	}
	
	public void drawLeftWall(GameTexture texture, int x, int y)
	{
		batch.draw(texture.getTexture(), getXFromLeftWall(x, y), getYFromLeftWall(x, y), getTileWidth() / 2, getTileWidth(), texture.getX(), texture.getY(), texture.getWidth(), texture.getHeight(), texture.isFlipX(), texture.isFlipY());
	}
	
	public void drawRightWall(GameTexture texture, int x, int y)
	{
		batch.draw(texture.getTexture(), getXFromRightWall(x, y), getYFromRightWall(x, y), getTileWidth() / 2, getTileWidth(), texture.getX(), texture.getY(), texture.getWidth(), texture.getHeight(), texture.isFlipX(), texture.isFlipY());
	}
	
	public float getXFromTile(float x, float y)
	{
		return getCenterX() + (x - y) * getTileWidth() / 2;
	}
	
	public float getYFromTile(float x, float y)
	{
		return getCenterY() - (x + y) * getTileWidth() / 4;
	}
	
	public float getXFromLeftWall(int x, int y)
	{
		return getCenterX() + x * getTileWidth() / 2 - y * getTileWidth() / 2;
	}
	
	public float getYFromLeftWall(int x, int y)
	{
		return getCenterY() - x * getTileWidth() / 4 - y * getTileWidth() / 4 + getTileWidth() / 4;
	}
	
	public float getXFromRightWall(int x, int y)
	{
		return getCenterX() + x * getTileWidth() / 2 - y * getTileWidth() / 2 + getTileWidth() / 2;
	}
	
	public float getYFromRightWall(int x, int y)
	{
		return getCenterY() - x * getTileWidth() / 4 - y * getTileWidth() / 4 + getTileWidth() / 4;
	}
	
	public Location getLocationFromPixel(IsometricWorld world, int mouseX, int mouseY)
	{
		float x = -2 * (((getGameHeight() - mouseY) - getTileWidth() / 4 - getCenterY()) - mouseX + getTileWidth() + getCenterX()) / getTileWidth();
		float y = (mouseX - 2 * (getGameHeight() - mouseY) + getCenterX() + 2 * getCenterY()) / getTileWidth();
		
		return new Location(world, (int)x, (int)y);
	}
	
	public float getTileWidth()
	{
		return TILE_SIZES[zoom];
	}
	
	public int getGameWidth()
	{
		return Gdx.graphics.getWidth();
	}
	
	public int getGameHeight()
	{
		return Gdx.graphics.getHeight();
	}
	
	public float getCenterX()
	{
		return centerX;
	}
	
	public float getCenterY()
	{
		return centerY;
	}
	
	public void center(float x, float y)
	{
		this.centerX = getGameWidth() / 2 - getTileWidth() / 2 - x * getTileWidth() / 2 + y * getTileWidth() / 2;
		this.centerY = getGameHeight() / 2 - getTileWidth() / 4 + x * getTileWidth() / 4 + y * getTileWidth() / 4;
	}
	
	public SpriteBatch getSpriteBatch()
	{
		return batch;
	}
	
	public void setSpriteBatch(SpriteBatch batch)
	{
		this.batch = batch;
	}
	
	public int getZoom()
	{
		return this.zoom;
	}
	
	public void setZoom(int zoom)
	{
		if(zoom < 0)
			zoom = 0;
		
		if(zoom >= TILE_SIZES.length)
			zoom = TILE_SIZES.length -1;
		this.zoom = zoom;
	}
}
