//***********************************************************************************
//  Rajat Patel
//  Prog2_5
//  10/17/2016
//  Converts miles to kilometers.
//***********************************************************************************
import java.util.Scanner;

public class Prog2_5 
{

	public static void main(String[] args) 
	{
		//Create scanner
		Scanner scan = new Scanner(System.in);
		//Create variables and constants
		double miles, km;
		final double factor = 1.60935;
		//Prompt the user and read input
		System.out.print("Enter an amount in miles: ");
		miles = scan.nextDouble();
		//Perform calculations
		km = miles/factor;
		//Print answer
		System.out.print(miles+" miles is equal to "+km+" kilometers.");
		scan.close();
	}

}
