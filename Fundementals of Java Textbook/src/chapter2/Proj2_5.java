package chapter2;

import java.util.Scanner;

public class Proj2_5 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the mass of an object in kg:");
		double mass = scan.nextDouble();
		System.out.println("Enter the velocity of the object in m/s:");
		double velocity = scan.nextDouble();
		System.out.println("The momentum of the object is " + mass*velocity + "kgm/s.");
		scan.close();
	}

}
