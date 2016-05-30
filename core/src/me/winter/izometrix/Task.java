package me.winter.izometrix;

public abstract class Task 
{
	private long delay;
	private long lastWork;
	
	public abstract void run();
	
	public Task(long d)
	{
		this.delay = d;
		this.lastWork = System.currentTimeMillis();
	}
	
	public long getDelay() 
	{
		return this.delay;
	}
	
	public void setDelay(int d) 
	{
		this.delay = d;
	}
	
	public long getLastWork() 
	{
		return lastWork;
	}
	
	public void setLastWork(long lastWork) 
	{
		this.lastWork = lastWork;
	}
}
