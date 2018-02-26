//***********************************************************************************
//  Rajat Patel
//  Prog3_5
//  12/14/2016
//  Prints the user's input one char per line.
//***********************************************************************************
import java.util.Scanner;

public class Prog3_5 
{

	public static void main(String[] args) 
	{
		//Scanner Object
		Scanner scan = new Scanner(System.in);
		//Declare variables
		String input;
		//Get input
		System.out.println("Type something, it will be printed vertically:");
		input = scan.nextLine();
		System.out.println();
		//Print it vertically
		for (int i = 0;i < input.length();i++)
			System.out.println(input.charAt(i));
		scan.close();
	}

}
