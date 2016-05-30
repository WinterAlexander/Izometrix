package me.winter.izometrix;

import me.winter.izometrix.gui.Button;
import me.winter.izometrix.gui.Gui;
import me.winter.izometrix.gui.MenuHeader;
import me.winter.izometrix.objects.Bookcase;
import me.winter.izometrix.objects.Buffet;
import me.winter.izometrix.objects.Door;
import me.winter.izometrix.objects.Player;
import me.winter.izometrix.objects.StoneFloor;
import me.winter.izometrix.objects.StoneWall;
import me.winter.izometrix.objects.Table;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Izometrix extends ApplicationAdapter
{	
	private Scheduler scheduler;
	private SpriteBatch batch;
	private IsometricWorld world;
	private Gui gui;
	
	@Override
	public void create()
	{
		Gdx.input.setInputProcessor(new InputListener(this));
		
		this.scheduler = new Scheduler();
		this.batch = new SpriteBatch();
		
		this.gui = new Gui();
		this.gui.getMenu().addButton(new MenuHeader());
		this.gui.getMenu().addButton(new Button(3, Text.MENU_PLAY, new Runnable()
		{
			@Override
			public void run()
			{
				gui.getMenu().setOpen(false);
				gui.getMenu().clearSlot(3);
				gui.getMenu().addButton(new Button(3, Text.MENU_RESUME, new Runnable()
				{
					@Override
					public void run()
					{
						gui.getMenu().setOpen(false);
					}
					
				}));
			}
			
		}));
		this.gui.getMenu().addButton(new Button(5, Text.MENU_CREDIT, new Runnable()
		{

			@Override
			public void run()
			{
				gui.getMenu().setOpen(false);
				gui.getDialogBox().read(new String[]{"Test", "Test2", "Test3\nTest3"});
			}
			
		}));
		this.gui.getMenu().addButton(new Button(7, Text.MENU_SETTINGS, new Runnable()
		{
			@Override
			public void run()
			{
				//gui.getSettings().setOpen(true);
			}
			
		}));
		this.gui.getMenu().addButton(new Button(9, Text.MENU_QUIT, new Runnable()
		{
			@Override
			public void run()
			{
				Gdx.app.exit();
			}
			
		}));
		this.gui.getMenu().setOpen(true);
		
		this.world = new IsometricWorld(this, new IsometricDrawer(batch, 4), new int[]{-10, -10, 10, 10});
		for(int x = 0; x < 6; x++)
			for(int y = 0; y < 3; y++)
				this.world.addThing(new StoneFloor(world, x, y));
		
		for(int x = 0; x < 6; x++)
			for(int y = 0; y < 3; y++)
				this.world.addThing(new StoneFloor(world, x, y));
		
		for(int x = -1; x < 2; x++)
			for(int y = -4; y < -1; y++)
				this.world.addThing(new StoneFloor(world, x, y));
		
		for(int x = 3; x < 6; x++)
			for(int y = -3; y < 0; y++)
				this.world.addThing(new StoneFloor(world, x, y));
		
		for(int x = 0; x < 10; x++)
			for(int y = 3; y < 6; y++)
				this.world.addThing(new StoneFloor(world, x, y));
		
		for(int x = 6; x < 10; x++)
			for(int y = -3; y < 3; y++)
				this.world.addThing(new StoneFloor(world, x, y));
		
		this.world.addThing(new StoneWall(world, 0, 0, 1, 0));
		this.world.addThing(new StoneWall(world, 1, 0, 2, 0));
		this.world.addThing(new StoneWall(world, 2, 0, 3, 0));
		
		this.world.addThing(new StoneWall(world, 0, 0, 0, 1));
		this.world.addThing(new StoneWall(world, 0, 1, 0, 2));
		this.world.addThing(new StoneWall(world, 0, 2, 0, 3));
		
		this.world.addThing(new StoneWall(world, -1, -1, -1, 0));
		this.world.addThing(new StoneWall(world, -1, 0, -1, 1));
		this.world.addThing(new StoneWall(world, -1, 1, -1, 2));
		
		this.world.addThing(new StoneWall(world, -1, -2, -1, -1));
		this.world.addThing(new StoneWall(world, -1, -3, -1, -2));
		this.world.addThing(new StoneWall(world, -1, -4, -1, -3));
		
		this.world.addThing(new StoneWall(world, -2, 1, -2, 0));
		this.world.addThing(new StoneWall(world, -2, 0, -2, -1));
		this.world.addThing(new StoneWall(world, -2, -1, -2, -2));
		
		this.world.addThing(new StoneWall(world, -2, -2, -2, -3));
		this.world.addThing(new StoneWall(world, -2, -3, -2, -4));
		this.world.addThing(new StoneWall(world, -2, -4, -2, -5));
		
		this.world.addThing(new StoneWall(world, 8, 6, 8, 5));
		this.world.addThing(new StoneWall(world, 8, 5, 8, 4));
		
		this.world.addThing(new StoneWall(world, 3, 0, 3, -1));
		this.world.addThing(new StoneWall(world, 3, -1, 3, -2));
		this.world.addThing(new StoneWall(world, 3, -2, 3, -3));
		
		for(int i = 3; i < 10; i++)
		{
			if(i != 6)
				this.world.addThing(new StoneWall(world, i, -3, i + 1, -3));
			this.world.addThing(new StoneWall(world, i - 1, -4, i, -4));
		}
		
		this.world.addThing(new Door(world, 6, -3, 7, -3));
		
		this.world.addThing(new Table(world, 0, 2));
		
		this.world.addThing(new Buffet(world, 3, -3, 20));
		
		this.world.addThing(new Player(world, 1, 1));
		
		this.world.addThing(new Bookcase(world, 8, 5));

		
		this.world.getScheduler().start();
	}

	@Override
	public void render()
	{
		this.world.getScheduler().update();
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.batch.begin();
		this.world.render();
		Location loc = this.world.getDrawer().getLocationFromPixel(world, Gdx.input.getX(), Gdx.input.getY());
		this.world.getDrawer().drawFloor(GameTexture.FLOOR_STONE_NORMAL, loc.getX(), loc.getY());
		this.gui.render(batch);
		this.batch.end();
	}
	
	public void resize(int width, int height)
	{
		this.batch = new SpriteBatch();
		this.world.getDrawer().setSpriteBatch(batch);
	}

	public void pause()
	{ 
		this.world.getScheduler().stop();
		this.gui.getMenu().setOpen(true);
	}
	
	public void resume()
	{
		this.world.getScheduler().start();
	}
	
	public void dispose()
	{ 
		batch.dispose();
		SoundEffect.dispose();
	}

	public IsometricWorld getWorld()
	{
		return this.world;
	}
	
	public Gui getGui()
	{
		return gui;
	}
	
	public Scheduler getScheduler()
	{
		return this.scheduler;
	}
}
