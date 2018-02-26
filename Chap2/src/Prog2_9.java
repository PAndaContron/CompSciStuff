//***********************************************************************************
//  Rajat Patel
//  Prog2_9
//  11/3/2016
//  Sphere volume and surface area
//***********************************************************************************
import java.util.Scanner;
import java.text.DecimalFormat;

public class Prog2_9 
{

	public static void main(String[] args) 
	{
		//Object references
		Scanner scan = new Scanner(System.in);				//Scanner
		DecimalFormat fmt = new DecimalFormat("0.0000");	//Formatter
		//Variables
		double radius,volume,surfaceArea;
		//Input
		System.out.print("Enter the radius of your sphere: ");
		radius = scan.nextDouble();
		//Volume: 4/3*pi*r^3
		volume = 4.0/3*Math.PI*Math.pow(radius,3);
		//Surface Area: 4*pi*r^2
		surfaceArea = 4*Math.PI*Math.pow(radius,2);
		//Output
		System.out.println("The volume of the sphere is about "+fmt.format(volume)+".");
		System.out.print("The surface area of the sphere is about "+fmt.format(surfaceArea)+".");
		scan.close();
	}

}
