//***********************************************************************************
//  Rajat Patel
//  Sorts
//  5/9/2017
//  Contains sorts for sorting an array in descending order
//***********************************************************************************

public class Sorts 
{
	//------------------------------------------------------------------------
	//	Selection sort on integers
	//------------------------------------------------------------------------
	public static void selectionSort(int[] numbers)
	{
		int min,temp;
		
		for(int index=0;index<numbers.length-1;index++)
		{
			min = index;
			for(int scan=index+1;scan<numbers.length;scan++)
				if(numbers[scan] > numbers[min])
					min = scan;
			
			//Swap the values
			temp = numbers[min];
			numbers[min] = numbers[index];
			numbers[index] = temp;
		}
	}
	
	//------------------------------------------------------------------------
	//	Insertion sort on integers
	//------------------------------------------------------------------------
	public static void insertionSort(int[] numbers)
	{
		for(int index=1;index<numbers.length;index++)
		{
			int key = numbers[index];
			int position = index;
			
			//Shift smaller values to the right
			while(position>0 && numbers[position-1]<key)
			{
				numbers[position] = numbers[position-1];
				position--;
			}
			
			numbers[position] = key;
		}
	}
	
	//------------------------------------------------------------------------
	//	Insertion sort on integers
	//------------------------------------------------------------------------
	public static void insertionSort(Comparable[] objects)
	{
		for(int index=1;index<objects.length;index++)
		{
			Comparable key = objects[index];
			int position = index;
			
			//Shift smaller values to the right
			while(position>0 && objects[position-1].compareTo(key)<0)
			{
				objects[position] = objects[position-1];
				position--;
			}
			
			objects[position] = key;
		}
	}
}
