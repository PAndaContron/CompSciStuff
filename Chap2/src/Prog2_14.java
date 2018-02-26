//***********************************************************************************
//  Rajat Patel
//  Prog2_14
//  11/9/2016
//  Generates a random number
//***********************************************************************************
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class Prog2_14 
{

	public static void main(String[] args) 
	{
		//Objects
		Scanner scan = new Scanner(System.in);			//Scanner
		Random gen = new Random();						//Random number generator
		DecimalFormat fmt3 = new DecimalFormat("000");	//Formatter for 2nd set
		DecimalFormat fmt4 = new DecimalFormat("0000");	//Formatter for 3rd set
		//Variables
		int one1,one2,one3,two,three;
		//Generation
		one1 = gen.nextInt(8);
		one2 = gen.nextInt(8);
		one3 = gen.nextInt(8);
		two = gen.nextInt(743);
		three = gen.nextInt(10000);
		//Print the number
		System.out.print("A random phone number: "+one1+one2+one3+"-"+fmt3.format(two)+"-"+fmt4.format(three));
		scan.close();
	}

}
