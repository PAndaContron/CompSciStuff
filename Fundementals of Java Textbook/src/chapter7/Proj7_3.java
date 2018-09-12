package chapter7;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj7_3 
{

	public static void main(String[] args) 
	{
		NumberFormat f = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the principal amount:");
		double principal;
		while(true)
		{
			try
			{
				principal = scan.nextDouble();
				break;
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.err.println("Input must be a number.");
			}
		}
		
		System.out.println("Enter the interest rate:");
		double rate;
		while(true)
		{
			try
			{
				rate = scan.nextDouble();
				break;
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.err.println("Input must be a number.");
			}
		}
		
		System.out.println("Enter the number of years:");
		int years;
		while(true)
		{
			try
			{
				years = (int) scan.nextDouble();
				break;
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.err.println("Input must be a number.");
			}
		}
		
		System.out.println("Year\tStart\tGain\tEnd");
		for(int i=1; i<=years; i++)
		{
			System.out.print(i + "\t" + f.format(principal) + "\t");
			double newPrincipal = principal*(1+rate/400);
			System.out.println(f.format(newPrincipal-principal) + "\t" + f.format(newPrincipal));
			principal = newPrincipal;
		}
		
		scan.close();
	}

}
