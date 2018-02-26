//***********************************************************************************
//  Rajat Patel
//  Recursion
//  9/7/2017
//  Demonstrates recursion
//***********************************************************************************

public class Recursion 
{
	public static void main(String[] args)
	{
		System.out.println(sum(18930));	//Maximum without stack overflow
		System.out.println(factorial(8195));
		System.out.println();
		
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");
		list.add("Item 4");
		list.add("Item 5");
		list.add("Item 6");
	}
	
	//------------------------------------------------------------------------
	//	Returns the sum of n and all whole numbers less than n.
	//------------------------------------------------------------------------
	public static int sum(int n)
	{
		if(n==1)
			return 1;
		else
			return n+sum(n-1);
	}
	
	//------------------------------------------------------------------------
	//	Returns the factorial of n.
	//------------------------------------------------------------------------
	public static int factorial(int n)
	{
		if(n==1)
			return 1;
		else
			return n*factorial(n-1);
	}
}
