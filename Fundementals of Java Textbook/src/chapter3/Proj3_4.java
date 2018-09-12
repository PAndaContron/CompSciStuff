package chapter3;

import java.text.NumberFormat;
import java.util.Scanner;

public class Proj3_4 
{

	public static void main(String[] args) 
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the hourly wage:");
		double wage = scan.nextDouble();
		System.out.println("Enter the number of regular hours worked:");
		int regular = scan.nextInt();
		System.out.println("Enter the number of overtime hours worked:");
		int overtime = scan.nextInt();
		System.out.println("The total weekly wage is " + formatter.format(regular*wage + overtime*wage*1.5) + ".");
		scan.close();
	}

}
