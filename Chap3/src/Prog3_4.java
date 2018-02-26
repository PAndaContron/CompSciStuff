//***********************************************************************************
//  Rajat Patel
//  Prog3_4
//  12/14/2016
//  Prints the sum of all even integers between 2 and the user's input.
//***********************************************************************************
import java.util.Scanner;

public class Prog3_4 
{

	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		//Declare variables
		int input,sum = 0;
		final int MIN = 2;
		//Get input
		System.out.print("Enter an integer above "+MIN+": ");
		input = (int) scan.nextDouble();
		while (input < MIN)
		{
			System.out.print("The integer must be above "+MIN+": ");
			input = (int) scan.nextDouble();
		}
		for (int i = MIN;i <= input;i += 2)
			sum += i;
		System.out.print("The sum of all even integers between "+MIN+" and "+input+", inclusive, is "+sum+".");
		scan.close();
	}

}
