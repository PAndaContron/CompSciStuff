package chapter10;

import java.text.NumberFormat;

public class Proj10_5 
{

	public static void main(String[] args) 
	{
		CheckingAccount checking = new CheckingAccount("John");
		System.out.println(checking);
		System.out.println(checking.withdraw(50));
		checking.deposit(50);
		System.out.println(checking);
		System.out.println(checking.withdraw(50));
		System.out.println(checking);
		System.out.println();
		
		SavingsAccount savings = new SavingsAccount("John", 2.5);
		System.out.println(savings);
		System.out.println(savings.withdraw(50));
		savings.deposit(50);
		savings.addInterest();
		System.out.println(savings);
		System.out.println(savings.withdraw(50));
		System.out.println(savings);
		System.out.println();
		
		CreditAccount credit = new CreditAccount("John", 2.5, 2000);
		System.out.println(credit);
		System.out.println(credit.withdraw(1500));
		System.out.println(credit);
		System.out.println(credit.withdraw(1000));
		credit.addInterest();
		System.out.println(credit);
		credit.deposit(1000);
		credit.addInterest();
		System.out.println(credit);
	}

	private static interface BankAccount
	{
		public void deposit(double amount);
		public double withdraw(double amount);
		public double getBalance();
		public String getName();
	}
	
	abstract private static class AbstractBankAccount implements BankAccount
	{
		private static NumberFormat f = NumberFormat.getCurrencyInstance();
		protected double balance;
		protected String name;
		
		public AbstractBankAccount(String name)
		{
			this(name, 0);
		}
		
		public AbstractBankAccount(String name, double balance)
		{
			this.name = name;
			this.balance = balance;
		}
		
		@Override
		public void deposit(double amount)
		{
			balance += amount;
		}
		
		@Override
		public double withdraw(double amount)
		{
			if(balance > amount)
			{
				balance -= amount;
				return amount;
			}
			amount = balance;
			balance = 0;
			return amount;
		}
		
		@Override
		public double getBalance()
		{
			return balance;
		}
		
		@Override
		public String getName()
		{
			return name;
		}
		
		@Override
		public String toString()
		{
			return "Owner: "+name+"\nBalance: "+f.format(balance);
		}
	}
	
	abstract private static class InterestBankAccount extends AbstractBankAccount
	{
		protected double rate;

		public InterestBankAccount(String name, double rate) 
		{
			this(name, 0, rate);
		}
		
		public InterestBankAccount(String name, double balance, double rate)
		{
			super(name, balance);
			this.rate = rate;
		}
		
		public void addInterest()
		{
			balance *= 1 + rate/100;
		}
		
		@Override
		public String toString()
		{
			return super.toString()+"\nInterest Rate: "+rate;
		}
	}
	
	private static class CheckingAccount extends AbstractBankAccount
	{
		public CheckingAccount(String name)
		{
			super(name);
		}
		
		public CheckingAccount(String name, double balance)
		{
			super(name, balance);
		}
		
		@Override
		public String toString()
		{
			return "CHECKING ACCOUNT\n"+super.toString();
		}
	}
	
	private static class SavingsAccount extends InterestBankAccount
	{
		public SavingsAccount(String name, double rate)
		{
			super(name, rate);
		}
		
		public SavingsAccount(String name, double balance, double rate)
		{
			super(name, balance, rate);
		}
		
		@Override
		public String toString()
		{
			return "SAVINGS ACCOUNT\n"+super.toString();
		}
	}
	
	private static class CreditAccount extends InterestBankAccount
	{
		protected double creditLine;
		
		public CreditAccount(String name, double rate, double creditLine)
		{
			this(name, 0, rate, creditLine);
		}
		
		public CreditAccount(String name, double balance, double rate, double creditLine)
		{
			super(name, balance, rate);
			this.creditLine = creditLine;
		}
		
		@Override
		public void deposit(double amount)
		{
			super.deposit(-amount);
		}
		
		@Override
		public double withdraw(double amount)
		{
			if(amount+balance > creditLine)
			{
				amount = creditLine-balance;
				balance = creditLine;
				return amount;
			}
			balance += amount;
			return amount;
		}
		
		@Override
		public void addInterest()
		{
			super.addInterest();
			balance = Math.min(balance, creditLine);
		}
		
		@Override
		public String toString()
		{
			return "CREDIT ACCOUNT\n"+super.toString()+"\nCredit Line: "+creditLine;
		}
	}
}
