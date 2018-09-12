package chapter4;

import java.util.Scanner;

public class Proj4_6 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the initial number of organisms:");
		int num = scan.nextInt();
		System.out.println("Enter the growth rate:");
		double rate = scan.nextDouble();
		System.out.println("Enter the number of hours it takes to achieve this growth:");
		int growthTime = scan.nextInt();
		System.out.println("Enter the total number of hours to predict:");
		double time = scan.nextDouble()/growthTime;
		System.out.println("There should be about " + (int) (num*Math.pow(rate, time)) + " organisms.");
		scan.close();
	}

}
