//***********************************************************************************
//  Rajat Patel
//  Prog6_6
//  5/18/2017
//  Holds 30 accounts for L&L Bank
//***********************************************************************************

import java.util.Scanner;

public class Prog6_6 
{
	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Array of accounts
		Account[] accounts = new Account[30];
		int numUsed = 0,current;
		String name,input,again = "y";
		
		while(again.equals("y"))
		{
			System.out.print("What would you like to do? (c for create an account, l for log in) ");
			input = scan.next();
			if(input.equals("c"))
			{
				//Check if there are accounts left
				if(numUsed<30)
				{
					//Get the user's name
					System.out.print("Enter your first and last name: ");
					input = scan.next();
					input += " ";
					input += scan.next();
					name = input;
					
					System.out.print("Would you like to make an intial deposit? (y/n)");
					input = scan.next();
					if(input.equals("y"))
					{
						System.out.print("How much? ");
						
					}
				}
				else
					System.out.println("Sorry, we have no space left for a new account.");
			}
		}
	}
}
