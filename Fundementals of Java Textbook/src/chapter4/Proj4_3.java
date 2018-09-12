package chapter4;

import java.text.NumberFormat;
import java.util.Scanner;

public class Proj4_3 
{

	public static void main(String[] args) 
	{
		NumberFormat f = NumberFormat.getCurrencyInstance();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the length of the call in minutes:");
		int min = scan.nextInt();
		System.out.println("The call costs " + f.format(1.15 + Math.max(min - 2, 0)*.5) + ".");
		scan.close();
	}

}
