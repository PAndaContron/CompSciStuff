package chapter4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj4_9 
{

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("Proj4_9Input"));
		while(scan.hasNext())
		{
			double base = scan.nextDouble();
			double exp = scan.nextDouble();
			System.out.println(base + "^" + exp + " = " + Math.pow(base, exp));
		}
		scan.close();
	}

}
