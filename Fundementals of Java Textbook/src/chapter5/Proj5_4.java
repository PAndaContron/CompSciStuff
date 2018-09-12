package chapter5;

import java.util.Random;
import java.util.Scanner;

public class Proj5_4 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		
		System.out.print("How many dollars do you have? ");
		int money = scan.nextInt();
		int high = money;
		int highRoll = 0;
		int rolls = 0;
		while(money > 0)
		{
			rolls++;
			if(d1.getFace()+d2.getFace() == 7)
				money += 4;
			else
				money--;
			if(money>high)
			{
				high = money;
				highRoll = rolls;
			}
			d1.roll();
			d2.roll();
		}
		System.out.println("You are broke after " + rolls + " rolls.");
		System.out.println("You should have quit after " + highRoll + " rolls when you had $" + high);
		
		scan.close();
	}

	private static class Dice
	{
		private int face;
		private static Random generator;
		
		static
		{
			generator = new Random();
		}
		
		public Dice()
		{
			roll();
		}
		
		public void roll()
		{
			face = 1 + generator.nextInt(6);
		}
		
		public int getFace()
		{
			return face;
		}
		
	}
}
