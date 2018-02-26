//***********************************************************************************
//  Rajat Patel
//  Prog2_10
//  11/7/2016
//  Uses Heron's formula for area of a triangle.
//***********************************************************************************
import java.util.Scanner;
import java.text.DecimalFormat;

public class Prog2_10 
{

	public static void main(String[] args) 
	{
		//Object references
		Scanner scan = new Scanner(System.in);			//Scanner
		DecimalFormat fmt = new DecimalFormat("0.000");	//Formatter
		//Variables
		double a,b,c,s,aTerm,bTerm,cTerm,output;
		//Input
		System.out.print("Enter the side lengths of your triangle, separated by spaces: ");
		a = scan.nextDouble();
		b = scan.nextDouble();
		c = scan.nextDouble();
		//Calculations
		s = (a+b+c)/2;
		aTerm = s-a;
		bTerm = s-b;
		cTerm = s-c;
		output = Math.sqrt(s*aTerm*bTerm*cTerm);
		//Output
		System.out.print("The area of the triangle is about "+fmt.format(output)+".");
		scan.close();
	}

}
