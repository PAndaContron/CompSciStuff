//***********************************************************************************
//  Rajat Patel
//  Account
//  1/25/2017
//  Used for bank account objects
//***********************************************************************************

import java.text.NumberFormat;

public class Prog4_1Account 
{
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	private final double RATE = 0.035;	// interest rate of 3.5%
	
	//Instance variables
	private int acctNumber;
	private double balance;
	private String name;
	
	//Constructor
	public Prog4_1Account(String owner, int account, double initial)
	{
		name = owner;
		acctNumber = account;
		balance = initial;
	}
	
	//Deposits money, then returns balance
	public double deposit(double amount)
	{
		if (amount < 0)	//If the amount is negative, print an error
		{
			System.out.println();
			System.out.println("Error: Deposit amount is invalid.");
			System.out.println(acctNumber+" "+fmt.format(amount));
		}
		else
			balance = balance+amount;
		return balance;
	}
	
	//Withdraws money, then returns balance
	public double withdraw(double amount, double fee)
	{
		amount += fee;	//Combine the two amounts
		if (amount < 0)	//If the amount is negative, print an error
		{
			System.out.println();
			System.out.println("Error: Withdraw amount is invalid.");
			System.out.println("Account: "+acctNumber);
			System.out.println("Requested: "+fmt.format(amount));
		}
		else
			if (amount > balance)	//If the person doesn't have enough money, print an error
			{
				System.out.println();
				System.out.println("Error: Insufficient funds.");
				System.out.println("Account: "+acctNumber);
				System.out.println("Requested: "+fmt.format(amount));
				System.out.println("Available: "+fmt.format(balance));
			}
			else
				balance = balance-amount;
		return balance;
	}
	
	//Adds interest to the account
	public double addInterest()
	{
		balance += balance*RATE;
		return balance;
	}
	
	//Accessor for balance
	public double getBalance()
	{
		return balance;
	}
	
	//Accessor for account number
	public int getAccountNumber()
	{
		return acctNumber;
	}
	
	//For transferring funds to another account directly; returns the balance on the calling account
	public double transfer(double amount, double fee, Prog4_1Account acct)
	{
		double oldBalance = balance;	//Saves the old balance
		withdraw(amount,fee);	//Withdraw from the calling account
		if (balance != oldBalance)	//Only add to the recieving account if the withdrawl was successful
			acct.deposit(amount);
		return balance;
	}
	
	//Returns a formatted String with this object's information
	public String toString()
	{
		return (acctNumber+"\t"+name+"\t"+fmt.format(balance));
	}
}
