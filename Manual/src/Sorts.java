//***********************************************************************************
//  Rajat Patel
//  Sorts
//  11/29/2017
//  All sorts of sorts
//***********************************************************************************

public class Sorts 
{
	public static void insertionSort(int[] array)
	{
		int i, key, j;
		for(i=1;i<array.length;i++)
		{
			key = array[i];
			j = i-1;
			while(j>=0 && array[j]>key)
			{
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
	}

	public static void selectionSort(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			int least = array[i];
			int leastJ = i;
			for(int j=i+1;j<array.length;j++)
				if(array[j]<least)
				{
					least=array[j];
					leastJ=j;
				}	
			int temp = array[i];
			array[i] = array[leastJ];
			array[leastJ] = temp;
		}
	}
}
