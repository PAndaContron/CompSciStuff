//***********************************************************************************
//  Rajat Patel
//  Shopping
//  5/11/2017
//  Represents an item
//***********************************************************************************

import java.text.NumberFormat;
import java.util.Scanner;

public class Shopping 
{
	public static void main(String[] args) 
	{
		//Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Number Formatter
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		//ShoppingCart
		ShoppingCart cart = new ShoppingCart();
		
		//Variables
		double price,totalPrice = 0;
		int quantity;
		String name,again = "Y";
		
		//Input loop
		while(again.equals("Y"))
		{
			System.out.println("Please enter the name, price, and quantity of the item separated by spaces:");
			name = scan.next();
			price = scan.nextDouble();
			quantity = scan.nextInt();
			totalPrice += price*quantity;
			cart.addToCart(name,price,quantity);
			
			System.out.println(cart);
			System.out.print("Keep shopping? (Y/N)");
			again = scan.next();
		}
		
		System.out.println("Please pay "+fmt.format(totalPrice)+".");
		
		scan.close();
	}
}
