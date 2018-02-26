//***********************************************************************************
//  Rajat Patel
//  Student Body
//  2/27/2017
//  Used to represent multiple students.
//***********************************************************************************

public class StudentBody 
{

	public static void main(String[] args) 
	{
		Address school = new Address("800 Lancaster Ave.","Villanova","PA",19085);
		Address jHome = new Address("21 Jump Street","Lynchburg","VA",24551);
		Student john = new Student("John","Gomez",jHome,school);
		Address mHome = new Address("123 Main Street","Euclid","OH",44132);
		Student marsha = new Student("Marsha","Jones",mHome,school);
		
		System.out.println(john);
		System.out.println();
		System.out.println(marsha);
		
		john.setTestScore(1,90);
		john.setTestScore(2,87);
		john.setTestScore(3,116);

		marsha.setTestScore(1,99);
		marsha.setTestScore(2,85);
		marsha.setTestScore(3,93);
		
		System.out.println();
		System.out.println(john);
		System.out.println();
		System.out.println(marsha);
	}

}
