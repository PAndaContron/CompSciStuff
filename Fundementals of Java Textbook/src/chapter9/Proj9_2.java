package chapter9;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj9_2 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter 10 numbers, separated by spaces:");
		
		double[] list = new double[10];
		for(int i=0; i<10; i++)
		{
			try
			{
				double num = scan.nextDouble();
				list[i] = num;
			}
			catch(InputMismatchException e)
			{
				i--;
				scan.next();
				System.err.println("Input must be a number.");
			}
		}
		
		double avg = average(list);
		double[] greater = new double[0];
		for(int i=0; i<10; i++)
		{
			if(list[i] > avg)
			{
				greater = add(greater, list[i]);
			}
		}
		
		System.out.println("Average: "+avg);
		System.out.println("Greater than average: "+Arrays.toString(greater));
		
		scan.close();
	}
	
	private static double[] add(double[] array, double num)
	{
		double[] newArray = new double[array.length + 1];
		for(int i=0; i<array.length; i++)
		{
			newArray[i] = array[i];
		}
		newArray[array.length] = num;
		return newArray;
	}
	
	private static double average(double[] list)
	{
		double sum = 0;
		for (int i = 0; i < list.length; i++)
		{
			sum += list[i];
		}
		return sum/list.length;
	}

}
