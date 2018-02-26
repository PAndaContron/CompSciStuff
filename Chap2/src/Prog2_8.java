//***********************************************************************************
//  Rajat Patel
//  Prog2_8
//  11/2/2016
//  Distance between two points
//***********************************************************************************
import java.util.Scanner;
import java.text.DecimalFormat;

public class Prog2_8 
{

	public static void main(String[] args) 
	{
		//Object references
		Scanner scan = new Scanner(System.in);			//Scanner
		DecimalFormat fmt = new DecimalFormat("0.###");	//Formatter
		//Variables
		double x1,x2,y1,y2,xTerm,yTerm,output;
		//Input
		System.out.print("Enter the coordinates of the first point, separated by spaces: ");
		x1 = scan.nextDouble();
		y1 = scan.nextDouble();
		System.out.print("Now the second point: ");
		x2 = scan.nextDouble();
		y2 = scan.nextDouble();
		//Calculations
		xTerm = Math.pow(x2-x1,2);
		yTerm = Math.pow(y2-y1,2);
		output = Math.sqrt(xTerm+yTerm);
		//Output
		System.out.print("The distance between those points is about "+fmt.format(output)+".");
		scan.close();
	}

}
