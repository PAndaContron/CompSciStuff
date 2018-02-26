//***********************************************************************************
//  Rajat Patel
//  Prog7_1
//  6/6/2017
//  Demonstrates the MonetaryCoin class.
//***********************************************************************************

public class Prog7_1 
{

	public static void main(String[] args) 
	{
		//Instantiate several monetary coins
		MonetaryCoin quarter1 = new MonetaryCoin(0.25);
		MonetaryCoin quarter2 = new MonetaryCoin(0.25);
		MonetaryCoin dime1 = new MonetaryCoin(0.1);
		MonetaryCoin dime2 = new MonetaryCoin(0.1);
		MonetaryCoin nickel = new MonetaryCoin(0.05);
		MonetaryCoin penny = new MonetaryCoin(0.01);
		
		//Print each coin
		System.out.println(quarter1);
		System.out.println(quarter2);
		System.out.println(dime1);
		System.out.println(dime2);
		System.out.println(nickel);
		System.out.println(penny);
		
		//Get the sum of the coins' value and print it out
		double sum = 0;
		sum += quarter1.getValue();
		sum += quarter2.getValue();
		sum += dime1.getValue();
		sum += dime2.getValue();
		sum += nickel.getValue();
		sum += penny.getValue();
		System.out.println("\nTotal Value: "+sum);
		
		//Flip each coin, then print it out again
		System.out.println("\nFlipping coins...");
		quarter1.flip();
		quarter2.flip();
		dime1.flip();
		dime2.flip();
		nickel.flip();
		penny.flip();
		System.out.println(quarter1);
		System.out.println(quarter2);
		System.out.println(dime1);
		System.out.println(dime2);
		System.out.println(nickel);
		System.out.println(penny);
	}

}
