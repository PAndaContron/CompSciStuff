package chapter4;

import java.util.Scanner;

public class Proj4_1 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 2 numbers, separated by spaces:");
		int num1 = scan.nextInt(), num2 = scan.nextInt();
		if(num1 < num2)
		{
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		System.out.println(num1/num2 + "r. " + num1%num2);
		scan.close();
	}
}
