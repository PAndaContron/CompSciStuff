package chapter3;

import java.text.NumberFormat;
import java.util.Scanner;

public class Proj3_5 
{

	public static void main(String[] args) 
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);
		final String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		System.out.println("Enter the hourly wage:");
		double wage = scan.nextDouble();
		int regular = 0, overtime = 0;
		for(int i = 0; i < 5; i++)
		{
			System.out.println("Enter the number of regular hours worked on " + DAYS[i] + ":");
			regular += scan.nextInt();
			System.out.println("Enter the number of overtime hours worked on " + DAYS[i] + ":");
			overtime += scan.nextInt();
		}
		System.out.println("The total weekly wage is " + formatter.format(regular*wage + overtime*wage*1.5) + ".");
		scan.close();
	}

}
