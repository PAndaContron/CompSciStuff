package chapter6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Proj6_4 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter numeric grades separated by spaces, ending with -1:");
		int sum = 0, total = 0, max = 0, min = 100;
		while(true)
		{
			int grade;
			try
			{
				grade = (int) scan.nextDouble();
			}
			catch(InputMismatchException e)
			{
				scan.next();
				continue;
			}
			if(grade > 100)
				continue;
			if(grade < 0)
				break;
			sum += grade;
			total++;
			if(grade > max)
				max = grade;
			if(grade < min)
				min = grade;
		}
		if(total == 0)
			System.out.println("No valid grades were entered.");
		else
			System.out.println("Average: " + getLetterGrade(sum/total)
				+ "\nMinimum: " + getLetterGrade(min)
				+ "\nMaximum: " + getLetterGrade(max));
		scan.close();
	}

	public static String getLetterGrade(int grade)
	{
		if(grade > 95) return "A+";
		if(grade > 91) return "A";
		if(grade > 89) return "A-";
		if(grade > 85) return "B+";
		if(grade > 81) return "B";
		if(grade > 79) return "B-";
		if(grade > 75) return "C+";
		if(grade > 71) return "C";
		if(grade > 69) return "C-";
		if(grade > 65) return "D+";
		if(grade > 61) return "D";
		if(grade > 59) return "D-";
		return "F";
	}
}
