//***********************************************************************************
//  Rajat Patel
//  Prog3_10
//  12/21/2016
//  Plays the "Hi-Lo" game
//***********************************************************************************
import java.util.Scanner;
import java.util.Random;

public class Prog3_10 
{

	public static void main(String[] args) 
	{
		//Objects
		Scanner scan = new Scanner(System.in);	//Scanner
		Random rand = new Random();				//Random Number Generator
		//Variables
		int input,number,count = 1;
		char play = 'Y';
		while (play == 'Y')
		{
			//Generate the first number, then ask the user to guess it
			number = rand.nextInt(100)+1;
			System.out.println("A number from 1 to 100 (inclusive) has been picked.");
			System.out.println("Can you guess it? (Enter a negative number to quit.)");
			input = (int) scan.nextDouble();	//Error trap for doubles
			while (input != number && input > 0)
			{
				if (input < number)
					System.out.println("Sorry, that number is too low. Try again!");
				else
					System.out.println("Sorry, that number is too high. Try again!");
				input = (int) scan.nextDouble();
				count++;
			}
			//Give the user a different message depending on how they ended the game and their score.
			if (input <= 0)
				if (count == 1)
					System.out.println("Come on, you didn't even try! The number was "+number+".");
				else
					System.out.println("You gave up after "+(count-1)+"tries. The number was "+number+".");
			else
				if (count == 1)
					System.out.println("Great job! You got it on your first try!");
				else
					System.out.println("You got it! It only took you "+count+" tries.");
			System.out.print("Play again? (y/n) ");
			play = scan.next().toUpperCase().charAt(0);
		}
		scan.close();
	}

}
