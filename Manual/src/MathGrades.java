//***********************************************************************************
//  Rajat Patel
//  Math Grades
//  4/25/2017
//  Grades math quizzes
//***********************************************************************************

import java.util.Scanner;

public class MathGrades 
{

	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Variables
		int[] key;
		boolean[] correct;
		int numCorrect;
		boolean again = true;
		
		//Ask the number of questions
		System.out.print("How many questions are on the quiz? ");
		key = new int[scan.nextInt()];
		correct = new boolean[key.length];
		
		//Fill in the key
		System.out.println("Enter the correct answers, separated by spaces.");
		for(int i=0;i<key.length;i++)
		{
			key[i] = scan.nextInt();
		}
		
		while(again)
		{
			//Fill in if the student's answers are correct
			numCorrect = 0;
			System.out.println("Enter the student's answers, separated by spaces.");
			for(int i=0;i<key.length;i++)
			{
				correct[i] = scan.nextInt()==key[i];
				if(correct[i])
					numCorrect++;
			}
			
			//Print out the student's score
			System.out.println(numCorrect+" answers correct for a score of "+((double)numCorrect)/key.length*100+"%.");
			
			//Ask the user if they want to enter another score
			System.out.print("Grade another quiz? (y/n) ");
			again = scan.next().toUpperCase().charAt(0)=='Y';
		}
		
		scan.close();
	}

}
