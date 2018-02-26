//***********************************************************************************
//  Rajat Patel
//  Prog6_3
//  5/9/2017
//  Demonstrates the sorts class
//***********************************************************************************

public class Prog6_3 
{
	public static void main(String[] args)
	{
		//Selection sort: integers
		System.out.println("Selection Sort:");
		int[] arr1 = {6,4,8,2,5,-5};
		Sorts.selectionSort(arr1);
		for(int i=0;i<arr1.length;i++)
			System.out.println(arr1[i]);
		
		//Insertion sort: integers
		System.out.println("\nInsertion Sort:");
		int[] arr2 = {6,4,8,2,5,-5};
		Sorts.insertionSort(arr2);
		for(int i=0;i<arr2.length;i++)
			System.out.println(arr2[i]);
		
		//Insertion sort: objects
		System.out.println("\nInsertion Sort (objects):");
		String[] arr3 = {"N","B","A","D","C","AB","E"};
		Sorts.insertionSort(arr3);
		for(int i=0;i<arr3.length;i++)
			System.out.println(arr3[i]);
	}
}
