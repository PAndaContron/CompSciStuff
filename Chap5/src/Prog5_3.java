//***********************************************************************************
//  Rajat Patel
//  Prog5_3
//  3/31/2017
//  Demonstrates the Task class
//***********************************************************************************

public class Prog5_3 
{

	public static void main(String[] args) 
	{
		//Initialize the objects
		Task shop = new Task(1,"Grocery Shopping");
		Task homework = new Task(2,"Do Homework");
		Task sleep = new Task(3,"Go to sleep on time");
		
		//Print them out
		System.out.println(shop);
		System.out.println(homework);
		System.out.println(sleep);
		System.out.println();
		
		//Finish some tasks
		shop.finish();
		homework.setPriority(homework.getPriority()-1);
		sleep.setPriority(sleep.getPriority()-1);
		
		//Print objects out again
		System.out.println(shop);
		System.out.println(homework);
		System.out.println(sleep);
	}

}
