//***********************************************************************************
//  Rajat Patel
//  Item
//  4/27/2017
//  Represents an item
//***********************************************************************************

import java.text.NumberFormat;

public class Item 
{
	private String name;
	private double price;
	private int quantity;
	
	//------------------------------------------------------------------------
	//	Create a new item
	//------------------------------------------------------------------------
	public Item(String itemName,double itemPrice,int numPurchased)
	{
		name = itemName;
		price = itemPrice;
		quantity = numPurchased;
	}
	
	//------------------------------------------------------------------------
	//	Returns unit price
	//------------------------------------------------------------------------
	public double getPrice()
	{
		return price;
	}
	
	//------------------------------------------------------------------------
	//	Returns the name
	//------------------------------------------------------------------------
	public String getName()
	{
		return name;
	}
	
	//------------------------------------------------------------------------
	//	Returns the quantity
	//------------------------------------------------------------------------
	public int getQuantity()
	{
		return quantity;
	}
	
	//------------------------------------------------------------------------
	//	Returns a formatted string with information about the item
	//------------------------------------------------------------------------
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		return name + "\t" + fmt.format(price) + "\t\t" + quantity + "\t\t" + fmt.format(price*quantity);
	}
}
