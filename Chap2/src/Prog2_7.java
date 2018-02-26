//***********************************************************************************
//  Rajat Patel
//  Prog2_7
//  10/18/2016
//  Converts seconds to time.
//***********************************************************************************
import java.util.Scanner;

public class Prog2_7 
{

	public static void main(String[] args) 
	{
		//Create scanner object
		Scanner scan = new Scanner(System.in);
		//Create variables
		int hours,minutes,seconds,minuteSeconds,input;
		//Take input
		System.out.print("Enter a number of seconds: ");
		input = scan.nextInt();
		//Perform calculations
		hours = input/3600;
		minuteSeconds = input%3600;
		minutes = minuteSeconds/60;
		seconds = minuteSeconds%60;
		//Print output
		System.out.print(input+" second(s) is equal to "+hours+" hour(s), "+minutes+" minute(s), and "+seconds+" second(s).");
		scan.close();
	}

}
