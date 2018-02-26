//***********************************************************************************
//  Rajat Patel
//  Shop
//  5/18/2017
//  Uses Item class to create and store items in an ArrayList
//***********************************************************************************

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop 
{
	public static void main(String[] args) 
	{
		//Variables
		String itemName;
		double itemPrice;
		int quantity;
		ArrayList<Item> cart = new ArrayList<Item>();
		String keepShopping = "y";
		
		//Scanner
		Scanner scan = new Scanner(System.in);
		
		//Formatter
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		do
		{
			//Input
			System.out.println("Enter the name of the item: ");
			itemName = scan.next();
			
			System.out.println("Enter the unit price: ");
			itemPrice = scan.nextDouble();
			
			System.out.println("Enter the quantity: ");
			quantity = scan.nextInt();
			
			//Add to cart
			cart.add(new Item(itemName,itemPrice,quantity));
			
			//Print out the contents of the cart
			double totalPrice = 0;
			for(int i=0;i<cart.size();i++)
			{
				System.out.println(cart.get(i));
				totalPrice += cart.get(i).getQuantity()*cart.get(i).getPrice();
			}
			System.out.println("Total price: "+fmt.format(totalPrice));
			
			//Ask the user to go again
			System.out.println("Continue shopping? (y/n) ");
			keepShopping = scan.next();
		}
		while(keepShopping.equals("y"));
		
		scan.close();
	}
}
