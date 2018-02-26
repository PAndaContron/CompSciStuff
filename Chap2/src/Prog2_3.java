//***********************************************************************************
//  Rajat Patel
//  Prog2_3
//  10/7/2016
//  Prints the sum, difference, and product of two numbers.
//***********************************************************************************
import java.util.Scanner;

public class Prog2_3 
{

	public static void main(String[] args) 
	{
		//Create scanner object
		Scanner scan = new Scanner (System.in);
		//Create two "double" variables to store input
		double a,b;
		//Take input to store in the two numbers
		System.out.print("Enter 2 numbers to add, subtract, and multiply, with the greater one first. They can be decimals and should be separated by spaces. ");
		a = scan.nextDouble();
		b = scan.nextDouble();
		//Perform calculations
		double sum = a+b;
		double difference = a-b;
		double product = a*b;
		//Print results
		System.out.println("The sum is: " + sum);
		System.out.println("The difference is: " + difference);
		System.out.println("The product is: " + product);
		scan.close();
	}

}
