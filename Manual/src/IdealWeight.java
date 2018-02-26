//***********************************************************************************
//  Rajat Patel
//  Ideal Weight
//  10/20/2016
//  Calculates the ideal weight range for males and females.
//***********************************************************************************
import java.util.Scanner;

public class IdealWeight 
{

	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		//Variables
		int inFeet,inInches,height,feWeight,maWeight;
		double feWeightMin,maWeightMin,feWeightMax,maWeightMax;
		//Input
		System.out.print("Enter your height in feet, then inches, leaving a space in between: ");
		inFeet = scan.nextInt();
		inInches = scan.nextInt();
		//Calculations
		height = inInches+inFeet*12;
		feWeight = 100+5*(height-60);
		maWeight = 106+6*(height-60);
		feWeightMin = feWeight*.85;
		maWeightMin = maWeight*.85;
		feWeightMax = feWeight*1.15;
		maWeightMax = maWeight*1.15;
		//Print results
		System.out.println("If you are a female, your weight should be between "+feWeightMin+" and "+feWeightMax+" pounds.");
		System.out.println("Ideally, you should weigh "+feWeight+" pounds.");
		System.out.println("If you are a male, your weight should be between "+maWeightMin+" and "+maWeightMax+" pounds.");
		System.out.print("Ideally, you should weigh "+maWeight+" pounds.");
		scan.close();
	}

}
