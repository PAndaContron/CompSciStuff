//***********************************************************************************
//  Rajat Patel
//  Lab Grades
//  10/20/2016
//  Calculates your lab grade based on an overcomplicated formula a fictional science
//  teacher made.
//***********************************************************************************
import java.util.Scanner;

public class LabGrades 
{

	public static void main(String[] args) 
	{
		//Variables
		int preLabPts,preLabMax,labPts,labMax,postLabPts,postLabMax;
		double labGrade,inWeight,outWeight,outClassAvg,inClassAvg;
		Scanner scan = new Scanner(System.in);
		//Get the input
		System.out.println("\nWelcome to the Lab Grade Calculator\n");
		System.out.print("Enter the number of points you earned on the pre-lab: ");
		preLabPts = scan.nextInt();
		System.out.print("What was the maximum number of points you could have earned? ");
		preLabMax = scan.nextInt();
		System.out.print("Enter the number of points you earned on the lab: ");
		labPts = scan.nextInt();
		System.out.print("What was the maximum number of points for the lab? ");
		labMax = scan.nextInt();
		System.out.print("Enter the number of points you earned on the post-lab: ");
		postLabPts = scan.nextInt();
		System.out.print("What was the maximum number of points for the post-lab? ");
		postLabMax = scan.nextInt();
		System.out.print("What was the weight for in-class work, as a percent? ");
		inWeight = scan.nextDouble()/100.0;
		outWeight = 1-inWeight;
		//Calculations
		outClassAvg = (double) (preLabPts+postLabPts)/(preLabMax+postLabMax)*100;
		inClassAvg = (double) labPts/labMax*100;
		labGrade = outWeight*outClassAvg+inWeight*inClassAvg;
		//Print results
		System.out.println("Your average on out-of-class work is "+outClassAvg+"%");
		System.out.println("Yoour average on in-class work is "+inClassAvg+"%");
		System.out.println("Your lab grade is "+labGrade+"%");
		System.out.println();
		scan.close();
	}

}
