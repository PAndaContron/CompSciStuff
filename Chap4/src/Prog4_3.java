//***********************************************************************************
//  Rajat Patel
//  Prog4_3
//  2/7/2017
//  Rolls a die with the specified amount of sides, then rolls and prints the result
//***********************************************************************************

import java.util.Scanner;

public class Prog4_3 
{

	public static void main(String[] args) 
	{
		//Objects
		Scanner scan = new Scanner(System.in);
		Die die;
		
		//Input
		System.out.println("How many sides do you want your die to have?");
		System.out.println("(Anything below 4 will default to 6)");
		die = new Die(scan.nextInt());
		
		//Output
		System.out.println("Your result is: "+die.roll());
		
		scan.close();
	}

}
