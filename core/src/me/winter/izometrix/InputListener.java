package me.winter.izometrix;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class InputListener implements InputProcessor
{
	private Izometrix game;

	public InputListener(Izometrix game)
	{
		this.game = game;
	}

	@Override
	public boolean keyDown(int keycode)
	{
		if(keycode == Input.Keys.ESCAPE)
		{
			game.getGui().getMenu().setOpen(!game.getGui().getMenu().isOpen());
			return true;
		}
		
		if(keycode == Input.Keys.F11 && Gdx.app.getType() == ApplicationType.Desktop)
		{
			//GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			//if(Gdx.graphics.isFullscreen())
			//	Gdx.graphics.setDisplayMode(gd.getDisplayMode().getWidth() / 2, gd.getDisplayMode().getHeight() / 2, false);
			//else
			//	Gdx.graphics.setDisplayMode(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight(), true);
			return false;
		}
		
		if(game.getGui().getMenu().isOpen() || game.getGui().getDialogBox().isVisible())
			return false;
		
		if(keycode == Input.Keys.UP && Gdx.app.getType() == ApplicationType.Desktop)
		{
			game.getGui().getArrows().activateArrow(Direction.TOP_RIGHT);
			return true;
		}
		if(keycode == Input.Keys.DOWN && Gdx.app.getType() == ApplicationType.Desktop)
		{
			game.getGui().getArrows().activateArrow(Direction.BOTTOM_LEFT);
			return true;
		}
		if(keycode == Input.Keys.LEFT && Gdx.app.getType() == ApplicationType.Desktop)
		{
			game.getGui().getArrows().activateArrow(Direction.TOP_LEFT);
			return true;
		}
		if(keycode == Input.Keys.RIGHT && Gdx.app.getType() == ApplicationType.Desktop)
		{
			game.getGui().getArrows().activateArrow(Direction.BOTTOM_RIGHT);
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		if(Gdx.app.getType() != ApplicationType.Desktop)
			return false;

		if(keycode == Input.Keys.UP)
			game.getGui().getArrows().desactivateArrow(Direction.TOP_RIGHT);

		else if(keycode == Input.Keys.DOWN)
			game.getGui().getArrows().desactivateArrow(Direction.BOTTOM_LEFT);

		else if(keycode == Input.Keys.LEFT)
			game.getGui().getArrows().desactivateArrow(Direction.TOP_LEFT);

		else if(keycode == Input.Keys.RIGHT)
			game.getGui().getArrows().desactivateArrow(Direction.BOTTOM_RIGHT);

		else
			return false;
		return true;
	}

	@Override
	public boolean keyTyped(char character)
	{
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		if(game.getGui().getSettings().isOpen())
		{
			game.getGui().getSettings().onClick(screenX, screenY);
			return true;
		}
		
		if(game.getGui().getMenu().isOpen())
		{
			game.getGui().getMenu().onClick(screenX, screenY);
			return true;
		}
		
		if(game.getGui().getDialogBox().isVisible())
		{
			game.getGui().getDialogBox().next();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		return true;
	}

	@Override
	public boolean scrolled(int amount)
	{
		if(game.getGui().getMenu().isOpen())
			return false;
		
		game.getWorld().getDrawer().setZoom(game.getWorld().getDrawer().getZoom() + amount);
		return true;
	}

}
