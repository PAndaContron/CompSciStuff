//***********************************************************************************
//  Rajat Patel
//  Prog5_2
//  3/30/2017
//  Demonstrates the RationalCompare class
//***********************************************************************************

public class Prog5_2 
{

	public static void main(String[] args) 
	{
		RationalCompare r1 = new RationalCompare(1,1);
		RationalCompare r2 = new RationalCompare(2,1);
		RationalCompare r3 = new RationalCompare(2,2);
		RationalCompare r4 = new RationalCompare(3,1);
		
		System.out.println(r1.compareTo(r2));
		System.out.println(r1.compareTo(r3));
		System.out.println(r1.compareTo(r4));
		System.out.println(r2.compareTo(r1));
		System.out.println(r2.compareTo(r3));
		System.out.println(r2.compareTo(r4));
		System.out.println(r3.compareTo(r1));
		System.out.println(r3.compareTo(r2));
		System.out.println(r3.compareTo(r4));
		System.out.println(r4.compareTo(r1));
		System.out.println(r4.compareTo(r2));
		System.out.println(r4.compareTo(r3));
	}

}
