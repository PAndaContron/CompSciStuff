//***********************************************************************************
//  Rajat Patel
//  Banking
//  2/6/2017
//  Demonstrates Account.java's functions
//***********************************************************************************

public class Prog4_1Banking 
{

	public static void main(String[] args) 
	{
		Prog4_1Account acct1 = new Prog4_1Account("Ted Murphy",72354,102.56);
		Prog4_1Account acct2 = new Prog4_1Account("Anita Gomez",69713,40.00);
		Prog4_1Account acct3 = new Prog4_1Account("Sanchit Reddy",93757,759.32);
		
		acct1.deposit(25.85);
		
		double gomezBalance = acct2.deposit(500.00);
		System.out.println("Gomez balance after deposit: "+gomezBalance);
		
		System.out.println("Gomez balance after withdrawl: "+acct2.withdraw(430.75,1.50));
		
		acct3.withdraw(800.00,0.0);
		
		acct1.addInterest();
		acct2.addInterest();
		acct3.addInterest();
		
		System.out.println();
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3);
		
		acct1.transfer(32.00,0.90,acct2);
		System.out.println();
		System.out.println(acct1);
		System.out.println(acct2);
	}

}
