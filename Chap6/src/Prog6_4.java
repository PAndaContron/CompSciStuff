//***********************************************************************************
//  Rajat Patel
//  Prog6_4
//  5/10/2017
//  Prints out a graph showing the amount of times the user entered a range of
//	values.
//***********************************************************************************

import java.util.Scanner;

public class Prog6_4 
{
	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Variables
		int[] values = new int[10];
		for(int i=0;i<values.length;i++)
			values[i] = 0;
		
		//Input loop
		System.out.println("Enter 60 integers from 1 to 100 inclusive:");
		for(int i=0;i<60;i++)
			values[(scan.nextInt()-1)/10]++;
		
		//Print the graph
		System.out.println();
		for(int i=0;i<10;i++)
		{
			System.out.print((i)*10+1+" - "+((i+1)*10));
			if(i==9)
				System.out.print("\t| ");
			else
				System.out.print("\t\t| ");
			for(int j=0;j<values[i];j++)
				System.out.print("*");
			System.out.println();
		}
		
		scan.close();
	}
}
