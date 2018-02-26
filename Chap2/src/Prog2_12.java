//***********************************************************************************
//  Rajat Patel
//  Prog2_12
//  11/7/2016
//  Counts the value of coins in a jar
//***********************************************************************************
import java.util.Scanner;
import java.text.NumberFormat;

public class Prog2_12 
{

	public static void main(String[] args) 
	{
		//Object references
		Scanner scan = new Scanner(System.in);
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		//Variables
		int quarters,dimes,nickels,pennies;
		double money;
		System.out.print("Enter the number of quarters: ");
		quarters = scan.nextInt();
		System.out.print("Enter the number of dimes: ");
		dimes = scan.nextInt();
		System.out.print("Enter the number of nickels: ");
		nickels = scan.nextInt();
		System.out.print("Enter the number of pennies: ");
		pennies = scan.nextInt();
		//Calculations
		money = quarters*.25+dimes*.1+nickels*.05+pennies*.01;
		//Output
		System.out.print("You have "+fmt.format(money));
		scan.close();
	}

}
