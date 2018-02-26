//***********************************************************************************
//  Rajat Patel
//  Prog6_2
//  4/27/2017
//  Lets the user enter in numbers and counts how many times each is entered.
//***********************************************************************************

import java.util.Scanner;

public class Prog6_2 
{

	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Variables
		boolean again = true;
		
		//Counting array
		int[] numEntered = new int[51];
		for(int i=0;i<51;i++)
			numEntered[i] = 0;
		
		//Prompt the user for input
		while(again)
		{
			System.out.print("Enter a number from -25 to 25 inclusive. ");
			numEntered[scan.nextInt()+25]++;
			System.out.print("Enter another number? (y/n) ");
			again = scan.next().equals("y");
		}
		
		//Print the output
		System.out.println("Number\tTimes Entered");
		for(int i=0;i<51;i++)
			System.out.println(i-25+"\t"+numEntered[i]);
		
		scan.close();
	}

}
