package me.winter.izometrix.gui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.winter.izometrix.Direction;

public class DirectionalArrows
{ 
	private Direction currentDirection;
	
	public DirectionalArrows()
	{
		this.currentDirection = null;
	}
	
	public void onClick(int mouseX, int mouseY)
	{
		
	}
	
	public void activateArrow(Direction direction)
	{
		this.currentDirection = direction;
	}
	
	public void desactivateArrow(Direction direction)
	{
		if(this.currentDirection != direction)
			return;
		
		this.currentDirection = null;
	}
	
	public Direction getCurrentDirection()
	{
		return this.currentDirection;
	}
	
	public void render(SpriteBatch batch)
	{
		
	}
}
