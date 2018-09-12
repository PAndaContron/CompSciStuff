package chapter9;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj9_5 
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
		System.out.println("The median of these numbers is "+median(list)+".");
		
		double[][] data = frequencies(list);
		double[] nums = data[0];
		double[] times = data[1];
		
		System.out.println("\nNumber\tFrequency");
		for (int i = 0; i < times.length; i++) 
		{
			System.out.println(nums[i] + "\t" + times[i]);
		}
		
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
	
	private static int indexOf(double[] array, double value)
	{
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i] == value)
				return i;
		}
		return -1;
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
	
	private static double[][] frequencies(double[] array)
	{
		double[] nums = new double[0];
		double[] times = new double[0];
		
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
		}
		
		return new double[][] {nums, times};
	}

	private static double median(double[] array)
	{
		double[] sortedArray = Arrays.copyOf(array, array.length);
		Arrays.sort(sortedArray);
		if(sortedArray.length % 2 == 0)
		{
			return (sortedArray[sortedArray.length/2]+sortedArray[sortedArray.length/2-1])/2;
		}
		return sortedArray[sortedArray.length/2];
	}

}
