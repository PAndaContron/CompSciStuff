package chapter4;

import java.util.Scanner;

public class Proj4_8 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the base:");
		int base = scan.nextInt();
		System.out.println("The base is " + base + ".");
		while(true)
		{
			System.out.println("Enter an exponent:");
			double exp = scan.nextDouble();
			if(exp < 0)
				break;
			System.out.println(base + "^" + exp + " = " + Math.pow(base, exp));
		}
		scan.close();
	}

}
