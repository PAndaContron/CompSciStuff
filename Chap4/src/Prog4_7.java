//***********************************************************************************
//  Rajat Patel
//  Prog4_7
//  2/27/2017
//  Users can add, subtract, multiply, or divide rational numbers
//***********************************************************************************

import java.util.Scanner;

public class Prog4_7 
{

	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Variables
		String input = "",temp = "";
		Rational r1,r2;
		boolean again = true;
		int temp1,temp2;
		
		//Main loop
		while(again)
		{
			//Get the input from the user
			System.out.println("Enter an operation (Add, Subtract, Multiply, or Divide),\nfollowed by 2 numbers.");
			System.out.println("The numbers may or may not be fractions, but no decimals.");
			System.out.println("Separate the three terms by spaces.");
			input = scan.next();
			
			//Create the two Rational objects
			temp = scan.next();
			temp1 = 0;
			temp2 = 0;
			if(temp.indexOf("/")==-1)
				temp += "/1";
			for(int i = 0;i<temp.length();i++)
			{
				char curr = temp.charAt(i);
				if(curr == '/')
				{
					temp1 = temp2;
					temp2 = 0;
				}
				else if(curr=='0')
					temp2 = 10*temp2;
				else if(curr=='1')
					temp2 = 10*temp2+1;
				else if(curr=='2')
					temp2 = 10*temp2+2;
				else if(curr=='3')
					temp2 = 10*temp2+3;
				else if(curr=='4')
					temp2 = 10*temp2+4;
				else if(curr=='5')
					temp2 = 10*temp2+5;
				else if(curr=='6')
					temp2 = 10*temp2+6;
				else if(curr=='7')
					temp2 = 10*temp2+7;
				else if(curr=='8')
					temp2 = 10*temp2+8;
				else
					temp2 = 10*temp2+9;
			}
			r1 = new Rational(temp1,temp2);
			
			temp = scan.next();
			temp1 = 0;
			temp2 = 0;
			if(temp.indexOf("/")==-1)
				temp += "/1";
			for(int i = 0;i<temp.length();i++)
			{
				char curr = temp.charAt(i);
				if(curr == '/')
				{
					temp1 = temp2;
					temp2 = 0;
				}
				else if(curr=='0')
					temp2 = 10*temp2;
				else if(curr=='1')
					temp2 = 10*temp2+1;
				else if(curr=='2')
					temp2 = 10*temp2+2;
				else if(curr=='3')
					temp2 = 10*temp2+3;
				else if(curr=='4')
					temp2 = 10*temp2+4;
				else if(curr=='5')
					temp2 = 10*temp2+5;
				else if(curr=='6')
					temp2 = 10*temp2+6;
				else if(curr=='7')
					temp2 = 10*temp2+7;
				else if(curr=='8')
					temp2 = 10*temp2+8;
				else
					temp2 = 10*temp2+9;
			}
			r2 = new Rational(temp1,temp2);
			
			if(input.equalsIgnoreCase("add"))
				System.out.println(r1.add(r2));
			else if(input.equalsIgnoreCase("subtract"))
				System.out.println(r1.subtract(r2));
			else if(input.equalsIgnoreCase("multiply"))
				System.out.println(r1.multiply(r2));
			else
				System.out.println(r1.divide(r2));
			
			//Ask the user if they want to go again
			System.out.print("Would you like to enter another number?(y/n) ");
			again = scan.next().toUpperCase().charAt(0) == 'Y';
		}
		
		scan.close();
	}

}
