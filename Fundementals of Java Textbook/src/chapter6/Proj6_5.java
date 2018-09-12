package chapter6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj6_5 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int greater, lower;
		while(true)
		{
			System.out.println("Enter 2 numbers separated by spaces:");
			try
			{
				greater = (int) scan.nextDouble();
				lower = (int) scan.nextDouble();
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.out.println("Input must be numbers.");
				continue;
			}
			break;
		}
		if(greater < lower)
		{
			int temp = greater;
			greater = lower;
			lower = temp;
		}
		System.out.println("GCD: "+gcd(greater, lower));
		scan.close();
	}

	public static int gcd(int greater, int lower)
	{
		System.out.println("Greater: "+greater+"\tLower: "+lower);
		return lower==0 ? greater : gcd(lower, greater % lower);
	}
}
