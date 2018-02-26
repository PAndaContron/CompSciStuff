//***********************************************************************************
//  Rajat Patel
//  Student
//  2/15/2017
//  Used for student objects
//***********************************************************************************

public class Student 
{
	private String firstName, lastName;
	private Address homeAddress, schoolAddress;
	private double test1,test2,test3;
	
	//------------------------------------------------------------------------
	//	Sets up this Student object with the specified initial values.
	//------------------------------------------------------------------------
	public Student(String first,String last,Address home,Address school)
	{
		firstName = first;
		lastName = last;
		homeAddress = home;
		schoolAddress = school;
		test1 = test2 = test3 = 0;
		
	}
	
	//------------------------------------------------------------------------
	//	Sets up this Student object with the specified initial values.
	//------------------------------------------------------------------------
	public Student(String first,String last,Address home,Address school,double score1,double score2,double score3)
	{
		firstName = first;
		lastName = last;
		homeAddress = home;
		schoolAddress = school;
		test1 = score1;
		test2 = score2;
		test3 = score3;
	}
	
	//------------------------------------------------------------------------
	//	Mutator for test scores.
	//------------------------------------------------------------------------
	public void setTestScore(int test,double newScore)
	{
		if(test == 1)
			test1 = newScore;
		else if(test == 2)
			test2 = newScore;
		else
			test3 = newScore;
	}
	
	//------------------------------------------------------------------------
	//	Accessor for test scores.
	//------------------------------------------------------------------------
	public double getTestScore(int test)
	{
		if(test == 1)
			return test1;
		if(test == 2)
			return test2;
		return test3;
	}
	
	//------------------------------------------------------------------------
	//	Calculates the average.
	//------------------------------------------------------------------------
	public double average()
	{
		return (test1+test2+test3)/3;
	}
	
	//------------------------------------------------------------------------
	//	Returns this Student object as a String.
	//------------------------------------------------------------------------
	public String toString()
	{
		String result;
		
		result = firstName+" "+lastName+"\n";
		result += "Test score 1: "+test1+"\n";
		result += "Test score 2: "+test2+"\n";
		result += "Test score 3: "+test3+"\n";
		result += "Average: "+average()+"\n";
		result += "Home Address:\n"+homeAddress+"\n";
		result += "School Address:\n"+schoolAddress;
		
		return result;
	}
}
