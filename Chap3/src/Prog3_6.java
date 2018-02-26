//***********************************************************************************
//  Rajat Patel
//  Prog3_6
//  12/14/2016
//  Counts the number of odd, even, and zero digits in an integer.
//***********************************************************************************
import java.util.Scanner;

public class Prog3_6 
{

	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		//Declare variables
		int odd = 0,even = 0,zero = 0,digits = 0,input;
		boolean finished = false;
		//Get input
		System.out.print("Enter an integer (any decimals will be removed): ");
		input = (int) scan.nextDouble();	//Error trap for doubles
		//Find the number of digits
		for (int i = 0;!finished;i++)
		{
			if (input > Math.pow(10,i)-1)
				digits++;
			else
				finished = true;
		}
		//Find the number of zeroes, odds, and evens
		for (int i = 0;i < digits;i++)
			if (input/(int)Math.pow(10,i+1)*10-input/(int)Math.pow(10,i) == 0)
				zero++;
			else
				if ((input/(int)Math.pow(10,i)-input/(int)Math.pow(10,i+1)*10)%2 == 0)
					even++;
				else
					odd++;
		//Output
		System.out.print("There are "+zero+" zeroes, "+even+" even numbers, and "+odd+" odd numbers.");
		scan.close();
	}

}
/*
Output:

Enter an integer (any decimals will be removed): 6043070
There are 3 zeroes, 2 even numbers, and 2 odd numbers.
*/