package chapter9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj9_3 
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
		
		System.out.println("The mode of these numbers is "+mode(list)+".");
		
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
	
	private static double mode(double[] array)
	{
		double[] nums = new double[0];
		double[] times = new double[0];
		int greatest = 0;
		
		for (double d : array) 
		{
			int index = indexOf(nums, d);
			if(index == -1)
			{
				index = nums.length;
				nums = add(nums, d);
				times = add(times, 1);
			}
			else
			{
				times[index]++;
			}
			if(times[index] > times[greatest])
			{
				greatest = index;
			}
		}
		
		return nums[greatest];
	}
	
	private static int indexOf(double[] array, double value)
	{
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i] == value)
				return i;
		}
		return -1;
	}

}
