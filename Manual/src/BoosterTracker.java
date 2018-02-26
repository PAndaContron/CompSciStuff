//***********************************************************************************
//  Rajat Patel
//  Booster Tracker
//  2/15/2017
//  Tracks 2 band boosters over 3 weeks
//***********************************************************************************

import java.util.Scanner;

public class BoosterTracker 
{

	public static void main(String[] args) 
	{
		//Scanner
		Scanner scan = new Scanner(System.in);
		
		//Band Booster objects
		System.out.print("Enter the name of the first band booster: ");
		BandBooster boost1 = new BandBooster(scan.next());
		System.out.print("Enter the name of the second band booster: ");
		BandBooster boost2 = new BandBooster(scan.next());
		
		//Input loop
		for(int i = 0;i<3;i++)
		{
			System.out.println("WEEK "+(i+1));
			System.out.print("Enter the number of boxes sold by "+boost1.getName()+" this week: ");
			boost1.updateSales(scan.nextInt());
			System.out.print("Enter the number of boxes sold by "+boost2.getName()+" this week: ");
			boost2.updateSales(scan.nextInt());
			System.out.println();
		}
		
		System.out.println(boost1);
		System.out.println(boost2);
		
		scan.close();
	}

}
