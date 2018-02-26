//***********************************************************************************
//  Rajat Patel
//  Prog2_4
//  10/11/2016
//  Converts Fahrenheit to Celsius.
//***********************************************************************************
import java.util.Scanner;

public class Prog2_4 
{

	public static void main(String[] args) 
	{
		//Create scanner object
		Scanner scan = new Scanner (System.in);
		//Create variables and constants
		double faTemp, ceTemp;
		final double factor = 5.0/9;
		//Take input
		System.out.print("Enter a temperature in Fahrenheit to be converted to Celsius. ");
		faTemp = scan.nextDouble();
		//Calculate: C = (F-32)*5/9
		ceTemp = (faTemp-32)*factor;
		//Print the results
		System.out.print("Your result is "+ceTemp+" degrees Celsius.");
		scan.close();
	}

}
/*
Enter a temperature in Fahrenheit to be converted to Celsius. 98.6
Your result is 37.0 degrees Celsius.
*/