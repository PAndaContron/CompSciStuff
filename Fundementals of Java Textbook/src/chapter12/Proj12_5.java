package chapter12;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Proj12_5 
{
	private static int swaps, comparisons;
	
	private static Random gen = new Random();
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			int arrayLength = 0;
			while(true)
			{
				System.out.println("Enter the array length (0 to quit):");
				try
				{
					arrayLength = (int) scan.nextDouble();
					break;
				}
				catch(InputMismatchException e)
				{
					System.err.println("Input must be a number.");
				}
			}
			if(arrayLength == 0)
				break;
			
			int[] a1 = new int[arrayLength];
			int[] a2 = new int[arrayLength*100];
			
			for(int i=0; i<a1.length; i++)
				a1[i] = gen.nextInt(100001);
			
			for(int i=0; i<a2.length; i++)
				a2[i] = gen.nextInt(100001);
			
			reset();
			long t1 = System.currentTimeMillis();
			bubbleSort(a1);
			long t2 = System.currentTimeMillis();
			long bubbleTime = t2-t1;
			int bubbleSwaps = swaps, bubbleComps = comparisons;
			
			reset();
			t1 = System.currentTimeMillis();
			quickSort(a2);
			t2 = System.currentTimeMillis();
			long quickTime = t2-t1;
			int quickSwaps = swaps, quickComps = comparisons;
			
			System.out.printf("            %12s %14s%n", "Bubble Sort", "Quick Sort");
			System.out.printf("Length      %8d %16d%n", arrayLength, arrayLength*100);
			System.out.printf("Time        %8d %16d%n", bubbleTime, quickTime);
			System.out.printf("Swaps       %8d %16d%n", bubbleSwaps, quickSwaps);
			System.out.printf("Comparisons %8d %16d%n", bubbleComps, quickComps);
		}
		
		scan.close();
	}
	
	private static void bubbleSort(int[] array)
	{
		for(int i=0; i<array.length-1; i++)
		{
			for(int j=i+1; j<array.length; j++)
			{
				if(compare(array[i], array[j]) > 0)
					swap(array, i, j);
			}
		}
	}
	
	private static void quickSort(int[] array)
	{
		quickSort(array, 0, array.length-1);
	}
	
	private static void quickSort(int[] array, int left, int right)
	{
		if(left >= right)
			return;
		
		int i=left;
		int j=right;
		int pivot = array[(left + right)/2];
		while(i < j)
		{
			while(compare(array[i], pivot) < 0)
				i++;
			while(compare(pivot, array[j]) < 0)
				j--;
			if(i <= j)
			{
				swap(array, i, j);
				i++;
				j--;
			}
		}
		quickSort(array, left, j);
		quickSort(array, i, right);
	}

	private static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		swaps++;
	}
	
	private static int compare(int i, int j)
	{
		comparisons++;
		return i-j;
	}
	
	private static void reset()
	{
		swaps = 0;
		comparisons = 0;
	}
}
