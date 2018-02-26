//***********************************************************************************
//  Rajat Patel
//  Prog4_5
//  2/10/2017
//  Plays a game of Pig
//***********************************************************************************

import java.util.Scanner;

public class Prog4_5 
{

	public static void main(String[] args) 
	{
		//Scanner
		Scanner scan = new Scanner(System.in);

		//Pair of Dice
		PairOfDice dice = new PairOfDice();
		
		//Variables
		int points = 0,compPoints = 0,turnPoints = 0,compTurnPoints = 0,face1 = 1,face2 = 1;
		boolean turn = true;	//False = computer; true = player
		char again = 'Y';
		
		//Start the game
		System.out.println("Welcome to Pig!");
		System.out.print("Enter anything to start. ");
		scan.next();
		
		//Main Loop
		while (points < 100 && compPoints < 100)
		{
			//Tell whose turn it is
			if(turn)
				System.out.println("\n\nPLAYER\'S TURN");
			else
				System.out.println("\n\nCOMPUTER\'S TURN");
			
			//Roll the dice and store the values
			dice.roll();
			face1 = dice.getFace1();
			face2 = dice.getFace2();
			
			if (face1 == 1 || face2 == 1)	//A one is somewhere
				if (face1*face2 == 1)	//Snake eyes!
				{
					System.out.println("Snake Eyes! All points lost!");
					
					//Take points from the player whose turn it is
					if(turn)
						points = 0;
					else
						compPoints = 0;
					
					//Switch turns
					turnPoints = 0;
					compTurnPoints = 0;
					turn = !turn;
				}
				else	//No Snake eyes
				{
					System.out.println("You got a one! Points for this turn lost!");
					
					//Delete all points for this turn and switch
					turnPoints = 0;
					compTurnPoints = 0;
					turn = !turn;
				}
			else	//No ones
			{
				System.out.println("You rolled a "+face1+" and a "+face2+" for a total of "+(face1+face2)+" points!");
				
				if(turn)	//Player's Turn
				{
					turnPoints += face1+face2;	//Add points
					
					//Ask the user whether they want to take another turn
					System.out.print("You have "+turnPoints+" points this turn. Take another turn? Y/N ");
					again = scan.next().toUpperCase().charAt(0);
					while(again != 'Y' && again != 'N')
					{
						System.out.print("Invalid input, please try again: ");
						again = scan.next().toUpperCase().charAt(0);
					}
				}
				
				else	//Computer's Turn
				{
					compTurnPoints += face1+face2;	//Add points
					System.out.print("You have "+compTurnPoints+" points this turn. Take another turn? Y/N ");
					
					//Take another turn if the computer has under 20 points
					if(compTurnPoints >= 20)
						again = 'N';
					else
						again = 'Y';
					System.out.println(again);	//Make the computer "type" its answer
				}
				
				//Switch turns
				if (again == 'N')
				{
					//Add points (turn points for other player will be 0, so it will not matter)
					points += turnPoints;
					compPoints += compTurnPoints;
					
					//Reset turn points
					turnPoints = 0;
					compTurnPoints = 0;
					
					//Switch turns
					turn = !turn;
				}
			}
			
			//Reset values
			face1 = 1;
			face2 = 1;
			
			//Print scores
			System.out.println("Player's Score: "+points);
			System.out.println("Computer's Score: "+compPoints);
			if(turnPoints+compTurnPoints != 0)
				if(turn)
					System.out.println("Player's points this turn: "+turnPoints);
				else
					System.out.println("Computer's points this turn: "+compTurnPoints);
			
			//Make sure the player can keep up with the text on the screen
			if((!turn || turnPoints == 0) && points < 100 && compPoints <100)
			{
				System.out.print("Enter anything to continue. ");
				scan.next();
			}
		}
		
		//Tell who won
		System.out.println("\n\n");
		if(points >= 100)
			System.out.println("Player won with "+points+" points!\nComputer lost with "+compPoints+".");
		else
			System.out.println("Computer won with "+compPoints+" points!\nPlayer lost with "+points+".");
		
		scan.close();
	}

}
