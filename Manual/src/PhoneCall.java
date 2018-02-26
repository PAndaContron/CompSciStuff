//***********************************************************************************
//  Rajat Patel
//  Prog3_2
//  11/18/2016
//  Determines if a year is a leap year
//***********************************************************************************
import java.util.Scanner;
import java.text.NumberFormat;

public class PhoneCall 
{

	public static void main(String[] args) 
	{
		//Object references
		Scanner scan = new Scanner(System.in);					//Scanner
		NumberFormat fmt = NumberFormat.getCurrencyInstance();	//Formatter
		//Variables
		final double START_RATE = .15,RATE = .1,EVE_DISCOUNT = .4,NIGHT_DISCOUNT = .6,STATE_TAX = .04,FED_TAX = .03;
		double total,subtotal,subsubtotal,startTime,discount = 0,fedTax,stateTax = 0;
		int length;
		char nonProfitChar;
		boolean nonProfit = false,invalidIn = false;
		
		//Input
		System.out.print("Enter the start time of the call, in 24 hour time with a decimal instead of a colon. ");
		startTime = scan.nextDouble();
		
		//Stop the rest of the program from running if the time is invalid.
		if (((startTime - Math.floor(startTime)) > 0.59) || (startTime >= 24) || (startTime < 0))
			System.out.print("Sorry, that time is invalid.");
		else
		{
			System.out.print("Enter the length of your call, in whole minutes. ");
			length = Math.abs((int)scan.nextDouble());
			
			System.out.print("Enter if you are a nonprofit organization, Y/N. ");
			nonProfitChar = (scan.next().toUpperCase()).charAt(0);
			
			//Convert that value to boolean, and stop the program if it is invalid.
			if (nonProfitChar == 'Y')
					nonProfit = true;
			else
				if (nonProfitChar != 'N')
					invalidIn = true;
			if (invalidIn)
				System.out.print("Sorry, that input is not valid. ");
			else
			//Calculations
			{
				//Basic total, no taxes or discounts.
				if (length <= 1)
					subsubtotal = START_RATE * length;
				else
					subsubtotal = START_RATE+RATE*(length-1);
				
				//Time discounts
				if ((startTime >= 17) && (startTime < 23))
					discount = subsubtotal*EVE_DISCOUNT;
				else
					if ((startTime >= 23) || (startTime < 8))
						discount = subsubtotal*NIGHT_DISCOUNT;
				subtotal = subsubtotal-discount;
				
				//Federal tax
				fedTax = subtotal*FED_TAX;
				//State tax
				if (!nonProfit)
					stateTax = subtotal*STATE_TAX;
				total = subtotal+stateTax+fedTax;
				
				//Output
				System.out.println();
				System.out.println("Basic cost:                           "+fmt.format(total));
				System.out.println("Time discount:                        "+fmt.format(discount));
				System.out.println();
				System.out.println("Subtotal:                             "+fmt.format(subtotal));
				System.out.println("State tax (4%, ignored if nonprofit): "+fmt.format(stateTax));
				System.out.println("Federal tax (3%):                     "+fmt.format(fedTax));
				System.out.println("Final cost:                           "+fmt.format(total));
			}
		}
		scan.close();
	}

}
