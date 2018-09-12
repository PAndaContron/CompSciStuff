package chapter5;

import java.text.NumberFormat;

public class Proj5_5 
{

	public static void main(String[] args) 
	{
		BankAccount b1 = new BankAccount("Jim");
		BankAccount b2 = new BankAccount("John", 200);
		
		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println(b1.withdraw(200));
		System.out.println(b2.withdraw(200));
		
		b1.deposit(200);
		
		System.out.println(b1);
		System.out.println(b2);
	}

	private static class BankAccount
	{
		private static NumberFormat f;
		
		private String owner;
		private double balance;
		
		static
		{
			f = NumberFormat.getCurrencyInstance();
		}
		
		public BankAccount(String name)
		{
			this(name, 0);
		}
		
		public BankAccount(String name, double initial)
		{
			owner = name;
			balance = initial;
		}
		
		public String getOwner()
		{
			return owner;
		}
		
		public double getBalance()
		{
			return balance;
		}
		
		public void deposit(double amount)
		{
			balance += amount;
		}
		
		public boolean withdraw(double amount)
		{
			if(balance < amount)
				return false;
			balance -= amount;
			return true;
		}
		
		public String toString()
		{
			return "Owner: "+getOwner()+"\tBalance: "+f.format(getBalance());
		}
	}
}
