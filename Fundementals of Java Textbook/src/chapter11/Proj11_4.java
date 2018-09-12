package chapter11;

import java.util.Arrays;

public class Proj11_4 
{

	public static void main(String[] args) 
	{
		int[] array = {5, 2, 9, 4, 7, 1, 8, 3, 10, 6};
		for(int i=0; i<array.length; i++)
		{
			System.out.println(linearSearch(array, array[i]));
		}
		System.out.println(linearSearch(array, 11));
		System.out.println(linearSearch(array, -1));
		
		selectionSort(array);
		System.out.println(Arrays.toString(array));
		
		for(int i=0; i<array.length; i++)
		{
			System.out.println(binarySearch(array, i+1));
		}
		System.out.println(binarySearch(array, 11));
		System.out.println(binarySearch(array, -1));
	}
	
	private static int linearSearch(int[] array, int key)
	{
		for (int i = 0; i < array.length; i++)
		{
			if(array[i] == key)
				return i;
		}
		return -1;
	}
	
	private static int binarySearch(int[] array, int key)
	{
		int min = 0, max = array.length-1;
		while(min <= max)
		{
			int mid = (min+max)/2;
			if(array[mid] == key)
				return mid;
			if(array[mid] < key)
				min = mid+1;
			else
				max = mid-1;
		}
		return -1;
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
