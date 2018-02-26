//***********************************************************************************
//  Rajat Patel
//  Prog2_6
//  10/17/2016
//  Converts hours, minutes, and seconds to seconds.
//***********************************************************************************
import java.util.Scanner;

public class Prog2_6 
{

	public static void main(String[] args) 
	{
		//Create scanner object
		Scanner scan = new Scanner(System.in);
		//Create variables
		int hours,minutes,seconds,hourSeconds,minuteSeconds,output;
		//Take input
		System.out.print("Enter a number of hours: ");
		hours = scan.nextInt();
		System.out.print("Enter a number of minutes: ");
		minutes = scan.nextInt();
		System.out.print("Enter a number of seconds: ");
		seconds = scan.nextInt();
		//Perform calculations
		hourSeconds = hours*3600;
		minuteSeconds = minutes*60;
		output = hourSeconds+minuteSeconds+seconds;
		//Print output
		System.out.print(hours+" hour(s), "+minutes+" minute(s), and "+seconds+" second(s) is equal to "+output+" second(s).");
		scan.close();
	}

}
