//***********************************************************************************
//  Rajat Patel
//  Sales
//  4/20/2017
//  Measures and reports sales from a specified number of salespeople.
//***********************************************************************************

import java.text.NumberFormat;
import java.util.Scanner;

public class Sales 
{

	public static void main(String[] args) 
	{
		//Scanner
		Scanner scan = new Scanner(System.in);
		
		//Number Formatter
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		//Read in the number of salespeople
		System.out.print("How many salespeople are there? ");
		final int SALESPEOPLE = scan.nextInt();
		
		//Variables
		int[] sales = new int[SALESPEOPLE];
		int sum = 0,least = (int)Math.pow(2,31)-1,greatest = 0,leastIndex = 0,greatestIndex = 0,minSales,numGreater = 0;
		
		//Input loop
		for(int i = 0;i<sales.length;i++)
		{
			System.out.print("Enter sales for salesperson "+(i+1)+": $");
			sales[i] = scan.nextInt();
		}
		
		//Output
		System.out.println("\nSalesperson Sales");
		System.out.println("-----------------");
		for(int i=0;i<sales.length;i++)
		{
			System.out.println(" "+(i+1)+" "+fmt.format(sales[i]));
			sum += sales[i];
			if (sales[i] > greatest)
			{
				greatest = sales[i];
				greatestIndex = i+1;
			}
			if (sales[i] < least)
			{
				least = sales[i];
				leastIndex = i+1;
			}
		}
		
		System.out.println("\nTotal sales: "+fmt.format(sum));
		System.out.println("Average sales: "+fmt.format(((double)sum)/SALESPEOPLE));
		System.out.println("Salesperson "+greatestIndex+" had the highest sale with "+fmt.format(greatest)+".");
		System.out.println("Salesperson "+leastIndex+" had the lowest sale with "+fmt.format(least)+".");
		
		//Sales exceeding a certain amount
		System.out.print("\nEnter an amount of sales to see who exceeded it: $");
		minSales = scan.nextInt();
		
		//Count the number of sales exceeding the amount
		for(int i=0;i<sales.length;i++)
		{
			if(sales[i]>minSales)
				numGreater++;
		}
		
		//Make sure at least one sale exceeded the amount
		if(numGreater>0)
		{
			//Create an array with indexes of the salespeople exceeding the amount
			int[] higherSales = new int[numGreater];
			int i = 0;
			for(int j=0;j<SALESPEOPLE;j++)
			{
				if(sales[j]>minSales)
				{
					higherSales[i] = j;
					i++;
				}
			}
			
			//Print out the data
			System.out.println(numGreater+" salespeople exceeded this amount:");
			for(int j=0;j<numGreater;j++)
			{
				System.out.println("Salesperson "+(higherSales[j]+1)+"\t"+fmt.format(sales[higherSales[j]]));
			}
		}
		else
			System.out.println("No sales exceeded this amount.");
		
		scan.close();
	}

}

//Output:
/*
How many salespeople are there? 6
Enter sales for salesperson 1: $2496
Enter sales for salesperson 2: $1315
Enter sales for salesperson 3: $1427
Enter sales for salesperson 4: $806
Enter sales for salesperson 5: $3599
Enter sales for salesperson 6: $2893

Salesperson Sales
-----------------
 1 $2,496.00
 2 $1,315.00
 3 $1,427.00
 4 $806.00
 5 $3,599.00
 6 $2,893.00

Total sales: $12,536.00
Average sales: $2,089.33
Salesperson 5 had the highest sale with $3,599.00.
Salesperson 4 had the lowest sale with $806.00.

Enter an amount of sales to see who exceeded it: $2000
3 salespeople exceeded this amount:
Salesperson 1	$2,496.00
Salesperson 5	$3,599.00
Salesperson 6	$2,893.00
*/