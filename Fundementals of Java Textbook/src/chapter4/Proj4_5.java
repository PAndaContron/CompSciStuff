package chapter4;

import java.util.Scanner;

public class Proj4_5 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number of iterations:");
		int n = scan.nextInt();
		double pi = 0;
		for(int i=0; i < n; i++)
		{
			pi += 1.0/(i*2 + 1) * (i%2==0 ? 1 : -1);
		}
		System.out.println("Pi is approximately " + pi*4 + ".");
		scan.close();
	}

}
