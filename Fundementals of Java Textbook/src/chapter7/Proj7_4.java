package chapter7;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj7_4 
{

	public static void main(String[] args) 
	{
		NumberFormat f = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the listed purchase price:");
		double initialPrice, balance;
		while(true)
		{
			try
			{
				initialPrice = balance = .9*scan.nextDouble();
				break;
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.err.println("Input must be a number.");
			}
		}
		
		System.out.println("Month\t\tCurrent Owed\tInterest\tPrincipal\tTotal Payment\tRemaining Balance Owed");
		for(int month = 1; balance > 0; month++)
		{
			double interest = balance*.01, payment = Math.min(interest+balance, initialPrice*.05), principal = payment-interest;
			double newBalance = balance-principal;
			if(Math.abs(newBalance) < .005)
				newBalance = 0;
			System.out.println(month + "\t\t" + f.format(balance) + "\t\t"
					+ f.format(interest) + "\t\t" + f.format(principal) + "\t\t"
					+ f.format(payment) + "\t\t" + f.format(newBalance));
			balance = newBalance;
		}
		
		scan.close();
	}

}
