package chapter11;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj11_2 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int[] array = new int[10];
		System.out.println("Enter 10 numbers, separated by spaces: ");
		for(int i=0; i<array.length; i++)
		{
			while(true)
			{
				try
				{
					array[i] = (int) scan.nextDouble();
					break;
				}
				catch(InputMismatchException e)
				{
					scan.next();
					System.err.println("Input must be a number.");
				}
			}
		}
		
		System.out.println(Arrays.toString(array));
		selectionSort(array);
		System.out.println(Arrays.toString(array));
		
		scan.close();
	}

	private static void selectionSort(int[] array)
	{
		for(int i=0; i < array.length-1; i++)
		{
			int minIndex = i;
			for(int j=i+1; j<array.length; j++)
			{
				if(array[j] < array[minIndex])
					minIndex = j;
			}
			
			if(minIndex != i)
				swap(i, minIndex, array);
		}
	}
	
	private static void swap(int a, int b, int[] array)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
