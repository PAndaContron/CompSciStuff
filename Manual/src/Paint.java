//***********************************************************************************
//  Rajat Patel
//  Paint
//  10/18/2016
//  Calculates how much paint is needed to cover a room.
//***********************************************************************************
import java.util.Scanner;

public class Paint {

	public static void main(String[] args) 
	{
		//Variables/Constants
		final int COVERAGE = 350, DOOR_AREA = 20, WINDOW_AREA = 15; //paint covers 350 sq ft/gal
		int length, width, height, doors, windows;
		double totalSqFt,paintNeeded;
		//Scanner object
		Scanner scan = new Scanner(System.in);
		//Prompt the user
		System.out.print("Enter the length of your room: ");
		length = scan.nextInt();
		System.out.print("Enter the width of your room: ");
		width = scan.nextInt();
		System.out.print("Enter the height of your room: ");
		height = scan.nextInt();
		System.out.print("Enter the number of doors: ");
		doors = scan.nextInt();
		System.out.print("Enter the number of windows: ");
		windows = scan.nextInt();
		//Calculations
		totalSqFt = (length*2 + width*2)*height-(doors*DOOR_AREA+windows*WINDOW_AREA);
		paintNeeded = totalSqFt/COVERAGE;
		//Output
		System.out.print("For this room, you will need "+paintNeeded+" gallons of paint.");
		scan.close();
	}

}
