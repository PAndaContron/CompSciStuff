package chapter2;

import java.util.Scanner;

public class Proj2_3 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a distance in kilometers:");
		double km = scan.nextDouble();
		System.out.println(km + " kilometers is equivalent to " + km*0.48617081072 + " nautical miles.");
		scan.close();
	}
}
