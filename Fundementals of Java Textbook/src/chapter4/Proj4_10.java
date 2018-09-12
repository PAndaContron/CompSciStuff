package chapter4;

import java.text.NumberFormat;
import java.util.Scanner;

public class Proj4_10 
{

	public static void main(String[] args) 
	{
		NumberFormat f = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the starting salary:");
		double salary = scan.nextDouble();
		System.out.println("Enter the annual percent increase:");
		double inc = 1 + scan.nextDouble()/100;
		System.out.println("Enter the number of years:");
		int years = scan.nextInt();
		for(int i = 1; i <= years; i++)
		{
			System.out.println("Year: "+i + "\tSalary: "+f.format(salary));
			salary *= inc;
		}
		scan.close();
	}

}
