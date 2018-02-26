//***********************************************************************************
//  Rajat Patel
//  Student
//  2/15/2017
//  Represents a student object
//***********************************************************************************

import java.util.Scanner;

public class Student 
{
	//Instance data
	private String name;
	private double test1,test2;
	private Scanner scan = new Scanner(System.in);
	
	//Constructor
	public Student(String studentName)
	{
		name = studentName;
	}
	
	//Prompt user to enter grades
	public void inputGrades()
	{
		System.out.print("Enter "+name+"\'s score for test1: ");
		test1 = scan.nextDouble();
		System.out.print("Enter "+name+"\'s score for test2: ");
		test2 = scan.nextDouble();
	}
	
	//Return the average
	public double getAverage()
	{
		return (test1+test2)/2;
	}
	
	//Print the student's name
	public void getName()
	{
		System.out.println(name);
	}
	
	//Return a formatted string
	public String toString()
	{
		return "Name: "+name+"\tTest1: "+test1+"\tTest2: "+test2;
	}
}
