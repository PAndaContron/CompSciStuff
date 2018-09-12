package chapter9;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj9_1 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		int[] even = new int[0], odd = new int[0], negative = new int[0];
		System.out.println("Enter 10 numbers, separated by spaces: ");
		for(int i=0; i<10; i++)
		{
			try
			{
				int num = (int) scan.nextDouble();
				if(num % 2 == 0)
					even = add(even, num);
				else
					odd = add(odd, num);
				if(num < 0)
					negative = add(negative, num);
			}
			catch(InputMismatchException e)
			{
				System.err.println("Input must be a number.");
				i--;
				scan.next();
			}
		}
		
		System.out.println("Even List: "+Arrays.toString(even));
		System.out.println("Odd List: "+Arrays.toString(odd));
		System.out.println("Negative List: "+Arrays.toString(negative));
		
		scan.close();
	}
	
	private static int[] add(int[] array, int num)
	{
		int[] newArray = new int[array.length + 1];
		for(int i=0; i<array.length; i++)
		{
			newArray[i] = array[i];
		}
		newArray[array.length] = num;
		return newArray;
	}

}
