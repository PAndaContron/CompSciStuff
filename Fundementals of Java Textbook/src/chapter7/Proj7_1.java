package chapter7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj7_1 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int number;
		int iterations;
		while(true)
		{
			System.out.println("Enter a number:");
			try
			{
				number = (int) scan.nextDouble();
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.err.println("Input must be a number.");
				continue;
			}
			break;
		}
		while(true)
		{
			System.out.println("Enter a number of iterations:");
			try
			{
				iterations = (int) scan.nextDouble();
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.err.println("Input must be a number.");
				continue;
			}
			break;
		}
		
		double guess = 1;
		for(int i=0; i < iterations; i++)
		{
			guess = (guess + number/guess)/2;
		}
		
		System.out.println("The number's square root is about "+guess+".");
		
		scan.close();
	}

}
