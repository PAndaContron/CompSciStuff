package chapter6;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Proj6_1 
{

	public static void main(String[] args) 
	{
		Random generator = new Random();
		Scanner scan = new Scanner(System.in);
		int tries = 0, number = generator.nextInt(100)+1, guess = 101;
		System.out.println("I'm thinking of a number between 1 and 100...");
		while(true)
		{
			System.out.println("Guess a number:");
			try
			{
				guess = (int) scan.nextDouble();
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.out.println("Guess must be a number.");
				continue;
			}
			if(guess < 1 || guess > 100)
			{
				System.out.println("Guess must be between 1 and 100.");
				continue;
			}
			tries++;
			if(guess == number)
			{
				break;
			}
			if(guess < number)
			{
				System.out.println("Wrong, the number is greater.");
				continue;
			}
			if(guess > number)
			{
				System.out.println("Wrong, the number is less.");
				continue;
			}
		}
		System.out.println("Correct! You got it after "+tries+" tries.");
		scan.close();
	}

}
