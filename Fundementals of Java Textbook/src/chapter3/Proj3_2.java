package chapter3;

import java.util.Scanner;

public class Proj3_2 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the radius of a sphere:");
		double r = scan.nextDouble();
		System.out.println("Diameter: " + r*2);
		System.out.println("Circumference: " + Math.PI*r*2);
		System.out.println("Surface Area: " + 4*Math.PI*r*r);
		System.out.println("Volume: " + 4*Math.PI*r*r*r/3);
		scan.close();
	}

}
