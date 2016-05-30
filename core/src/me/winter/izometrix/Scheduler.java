package me.winter.izometrix;

import java.util.ArrayList;
import java.util.Collection;

public class Scheduler 
{
	private ArrayList<Task> tasks;
	private ArrayList<Task> standby;
	private ArrayList<Task> corbeille;
	private long pauseTime;
	private long lastPause;
	private long lastPauseTime;
	private boolean paused;
	private boolean updating;
	
	public Scheduler()
	{
		this.tasks = new ArrayList<Task>();
		this.standby = new ArrayList<Task>();
		this.corbeille = new ArrayList<Task>();
		this.paused = true;
		this.lastPause = System.currentTimeMillis();
		this.lastPauseTime = 0;
		this.pauseTime = 0;
		this.updating = false;
	}
	
	public void addTask(Task task)
	{
		if(!this.updating)
			this.tasks.add(task);
		
		else
			this.standby.add(task);
	}
	
	public void addTasks(Collection<Task> tasks)
	{
		for(Task task : tasks)
			this.addTask(task);
	}
	
	public void cancel(Task task)
	{
		this.corbeille.add(task);
	}
	
	public void cancelAll()
	{
		this.tasks = new ArrayList<Task>();
		this.corbeille = new ArrayList<Task>();
	}
	
	public void update()
	{
		if(!this.paused)
		{
			this.updating = true;
			this.removeCancelled();
			
			for(Task task : this.tasks)
			{
				try
				{
					int turns = (int) (((System.currentTimeMillis() - this.pauseTime) - task.getLastWork()) / task.getDelay());
					for(int i = 0; i < turns; i++)
						task.run();
					
					task.setLastWork(task.getLastWork() + task.getDelay() * turns);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			this.updating = false;
			if(this.standby.size() != 0)
				for(Task task : this.standby)
					this.addTask(task);
			this.standby = new ArrayList<Task>();
		}
	}

	private void removeCancelled() 
	{
		for(Task current : this.corbeille)
		{
			if(this.tasks.contains(current))
			{
				this.tasks.remove(current);
			}
		}
		this.corbeille.clear();
	}
	
	public void stop()
	{
		if(!this.paused)
		{
			this.paused = true;
			this.lastPause = System.currentTimeMillis();
		}
	}
	
	public void start()
	{
		this.paused = false;
		this.pauseTime += System.currentTimeMillis() - this.lastPause;
		this.lastPauseTime = System.currentTimeMillis() - this.lastPause;
	}

	public boolean isPause()
	{
		return this.paused;
	}

	public long getLastPauseTime()
	{
		return lastPauseTime;
	}
	
	public long getLastPause()
	{
		return lastPause;
	}
	
	public long getTimeMillis()
	{
		return System.currentTimeMillis() - this.pauseTime;
	}
}
