//***********************************************************************************
//  Rajat Patel
//  Grades
//  2/15/2017
//  Driver for student objects
//***********************************************************************************

public class Grades 
{

	public static void main(String[] args) 
	{
		//Create student objects
		Student student1 = new Student("Mary");
		Student student2 = new Student("Mike");
		
		//Input grades for Mary and print her average
		student1.inputGrades();
		System.out.println("The average for Mary is "+student1.getAverage());
		
		System.out.println();
		
		//Input grades for Mike and print his average
		student2.inputGrades();
		System.out.println("The average for Mike is "+student2.getAverage());
		
		//Print out both student objects
		System.out.println("Student 1: "+student1);
		System.out.println("Student 2: "+student2);
	}

}
