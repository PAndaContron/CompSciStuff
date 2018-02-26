//***********************************************************************************
//  Rajat Patel
//  Prog3_2
//  11/18/2016
//  Determines if a year is a leap year
//***********************************************************************************
import java.util.Scanner;

public class Prog3_2 
{

	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		//Variables
		int input;
		boolean leap = false,invalid = false;
		//Input
		System.out.print("Enter a year from 1582 onwards, negative to quit: ");
		input = (int) scan.nextDouble();
		while (input >= 0)
		{
			//Determination
			if (input >= 1582)					//Make sure the input is valid
				if (input%4 == 0)				//Test divisibility by 4
					if (input%100 == 0)			//Test divisibility by 100
						if (input%400 == 0)		//Test divisibility by 400
							leap = true;		//If divisible by 400, it's a leap year
						else
							leap = false;		//If divisible by 100 and not 400, it's not a leap year
					else
						leap = true;			//If divisible by 4 and not 100, it is a leap year
				else
					leap = false;				//If not divisible by 4, it's not a leap year
			else
				invalid = true;					//If less than 1582, it's invalid
			//Output
			if (invalid)
					System.out.print("The Gregorian calendar was not adopted until 1582,"+
						" therefore, it cannot be determined if "+input+" is a leap year.");
			else
				if (leap)
					System.out.print(input+" is a leap year.");
				else
					System.out.print(input+" is not a leap year.");
			leap = false;
			invalid = false;
			System.out.println();
			System.out.print("Enter another year, negative to quit: ");
			input = (int) scan.nextDouble();
		}
		scan.close();
	}

}
/*
Enter a year from 1582 onwards, negative to quit: 1400
The Gregorian calendar was not adopted until 1582, therefore, it cannot be determined if 1400 is a leap year.
Enter another year, negative to quit: 1599
1599 is not a leap year.
Enter another year, negative to quit: 1996
1996 is a leap year.
Enter another year, negative to quit: 1700
1700 is not a leap year.
Enter another year, negative to quit: 2000
2000 is a leap year.
Enter another year, negative to quit: -1453

*/
