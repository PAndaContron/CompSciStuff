//***********************************************************************************
//  Rajat Patel
//  Prog2_2
//  10/7/2016
//  Averages three numbers.
//***********************************************************************************
import java.util.Scanner;

public class Prog2_2 
{

	public static void main(String[] args) 
	{
		//Create scanner object
		Scanner scan = new Scanner (System.in);
		//Create three "int" variables to store input
		int a,b,c;
		//Take input to store in the three numbers
		System.out.print("Enter 3 numbers to take the average of. They can't be decimals and should be separated by spaces. ");
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		//Find and print the average
		double finalAverage = (a+b+c)/3.0;
		System.out.print("Your result is: "+finalAverage);
		scan.close();
	}

}
/*
Enter 3 numbers to take the average of. They can't be decimals and should be separated by spaces. 93 88 75
Your result is: 85.33333333333333
*/