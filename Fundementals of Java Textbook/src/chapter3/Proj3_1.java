package chapter3;

import java.util.Scanner;

public class Proj3_1 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the length of the edge of a cube:");
		int edge = scan.nextInt();
		System.out.println("The surface area of the cube is " + 6*edge*edge + ".");
		scan.close();
	}

}
