package chapter6;

import java.util.Scanner;

public class Proj6_2 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int top = 101, bottom = 0, tries = 0;
		while(true)
		{
			tries++;
			int guess = (top + bottom)/2;
			System.out.println("Is your number "+guess+"? (y/n)");
			char ans = scan.next().toLowerCase().charAt(0);
			if(ans == 'y') break;
			System.out.println("Is your number higher or lower? (h/l)");
			ans = scan.next().toLowerCase().charAt(0);
			switch(ans)
			{
				case 'h': bottom = guess; break;
				default: top = guess; break;
			}
		}
		System.out.println("I got it after "+tries+" tries!");
		scan.close();
	}

}
