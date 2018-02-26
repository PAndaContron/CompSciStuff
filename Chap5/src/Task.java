//***********************************************************************************
//  Rajat Patel
//  Task
//  3/31/2017
//  Represents a task, has a priority
//***********************************************************************************

public class Task implements Priority 
{
	private int priority;
	private String name;
	private boolean done;
	
	public Task(int priority,String name)
	{
		setPriority(priority);
		this.name = name;
		done = false;
	}

	public void setPriority(int priority) 
	{
		this.priority = priority;
	}

	public int getPriority()
	{
		return priority;
	}
	
	public void finish()
	{
		done = true;
		priority = -1;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		if(done)
			return "Task: "+name+"\tThis task has been completed.";
		return "Task: "+name+"\tPriority: "+priority;
	}

}
