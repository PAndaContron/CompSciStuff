import java.util.Arrays;

//***********************************************************************************
//  Rajat Patel
//  Array Operations
//  11/2/2017
//  Combines & shows all recursion and stringBuilder methods
//***********************************************************************************

public class ArrayOperations 
{
	public static void main(String[] args) 
	{
		int[] array1 = {20,30,40,50,60,70,0};
		int[] array2 = {10,20,30,40,50,60};
		
		//Insert
		System.out.println("Original:\n"+Arrays.toString(array1));
		insertNumInArray(array1,2,35);
		System.out.println("Inserted 35 at index 2:\n"+Arrays.toString(array1));
		
		System.out.println();
		
		//Remove
		System.out.println("Original:\n"+Arrays.toString(array2));
		removeNumInArray(array2,4);
		System.out.println("Removed number at index 4:\n"+Arrays.toString(array2));
	}

	public static void insertNumInArray(int[] array, int index, int value)
	{
		//Move all of the other values forward
		for(int i=array.length-2;i>=index;i--)
			array[i+1] = array[i];
		
		//Put the value in the proper index
		array[index] = value;
	}
	
	public static void removeNumInArray(int[] array, int index)
	{
		//Move back every number in the array
		for(int i=index;i<array.length-1;i++)
			array[i] = array[i+1];
		
		//Put a 0 in the last index
		array[array.length-1] = 0;
	}
}

/*
Original:
[20, 30, 40, 50, 60, 70, 0]
Inserted 35 at index 2:
[20, 30, 35, 40, 50, 60, 70]

Original:
[10, 20, 30, 40, 50, 60]
Removed number at index 4:
[10, 20, 30, 40, 60, 0]
*/
