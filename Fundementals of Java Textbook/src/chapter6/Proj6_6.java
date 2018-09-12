package chapter6;

import java.util.Random;
import java.util.Scanner;

public class Proj6_6 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		
		System.out.print("How many dollars do you have? ");
		int startMoney = scan.nextInt();
		
		int sum = 0;
		for(int i=0; i < 100; i++)
		{
			int money = startMoney;
			int rolls = 0;
			while(money > 0)
			{
				rolls++;
				if(d1.getFace()+d2.getFace() == 7)
					money += 4;
				else
					money--;
				d1.roll();
				d2.roll();
			}
			sum += rolls;
		}
		
		System.out.println("You are broke after " + sum/100 + " rolls on average.");
		
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
