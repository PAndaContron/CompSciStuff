package chapter4;

import java.util.Scanner;

public class Proj4_2 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the lengths of the sides of a triangle, separated by spaces:");
		double s1 = scan.nextDouble(), s2 = scan.nextDouble(), s3 = scan.nextDouble();
		if(s3 < s1)
		{
			double temp = s1;
			s1 = s3;
			s3 = temp;
		}
		if(s3 < s2)
		{
			double temp = s2;
			s2 = s3;
			s3 = temp;
		}
		System.out.println(Math.abs(s1*s1 + s2*s2 - s3*s3) < 0.00000001 ? "This is a right triangle." : "This is not a right triangle.");
		scan.close();
	}

}
