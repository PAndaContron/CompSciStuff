//***********************************************************************************
//  Rajat Patel
//  Reverse Array
//  4/27/2017
//  Reverses an array created by the user
//***********************************************************************************

import java.util.Scanner;

public class ReverseArray 
{

	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Variables
		int temp,halfLength;
		
		//Create the array
		System.out.print("How many values would you like to enter? ");
		int[] array = new int[scan.nextInt()];
		halfLength = array.length/2;
		
		//Prompt the user for input
		System.out.println("Enter the values:");
		for(int i=0;i<array.length;i++)
		{
			array[i] = scan.nextInt();
		}
		
		//Print out the original array
		System.out.println("\nOriginal Array:");
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
		
		//Reverse the array
		for(int i=0;i<halfLength;i++)
		{
			temp = array[i];
			array[i] = array[array.length-i-1];
			array[array.length-i-1] = temp;
		}

		//Print out the reversed array
		System.out.println("\nReversed Array:");
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
		
		scan.close();
	}

}
