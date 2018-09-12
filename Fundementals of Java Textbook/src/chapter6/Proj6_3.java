package chapter6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj6_3 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter a number grade:");
			int grade;
			try
			{
				grade = (int) scan.nextDouble();
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.out.println("Grade must be a number.");
				continue;
			}
			if(grade > 100 || grade < 0)
			{
				System.out.println("Grade must be between 1 and 100.");
				continue;
			}
			String letter;
			if(grade > 95) letter = "A+";
			else if(grade > 91) letter = "A";
			else if(grade > 89) letter = "A-";
			else if(grade > 85) letter = "B+";
			else if(grade > 81) letter = "B";
			else if(grade > 79) letter = "B-";
			else if(grade > 75) letter = "C+";
			else if(grade > 71) letter = "C";
			else if(grade > 69) letter = "C-";
			else if(grade > 65) letter = "D+";
			else if(grade > 61) letter = "D";
			else if(grade > 59) letter = "D-";
			else letter = "F";
			System.out.println("The letter grade is "+letter);
			break;
		}
		scan.close();
	}

}
