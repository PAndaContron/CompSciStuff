//***********************************************************************************
//  Rajat Patel
//  Shopping Cart
//  4/27/2017
//  Represents a shopping cart
//***********************************************************************************

import java.text.NumberFormat;

public class ShoppingCart 
{
	private int itemCount;
	private double totalPrice;
	private int capacity;
	private Item[] cart;

	//------------------------------------------------------------------------
	//	Create a new shopping cart with capacity of 5 items
	//------------------------------------------------------------------------
	public ShoppingCart() 
	{
		capacity = 5;
		itemCount = 0;
		totalPrice = 0;
		cart = new Item[capacity];
	}
	
	//------------------------------------------------------------------------
	//	Adds an item to the cart
	//------------------------------------------------------------------------
	public void addToCart(String itemName,double price,int quantity)
	{
		if(itemCount==capacity)
			increaseSize();
		cart[itemCount] = new Item(itemName,price,quantity);
		totalPrice += price*quantity;
		itemCount++;
	}
	
	//------------------------------------------------------------------------
	//	Returns a summary of the cart
	//------------------------------------------------------------------------
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		String contents = "\nShopping Cart\n";
		contents += "\nItem\tUnit Price\tQuantity\tTotal\n";
		
		for(int i=0;i<itemCount;i++)
			contents += cart[i].toString()+"\n";
		
		contents += "\nTotal Price: "+fmt.format(totalPrice);
		contents += "\n";
		
		return contents;
	}
	
	//------------------------------------------------------------------------
	//	Increase capacity of the cart by 3
	//------------------------------------------------------------------------
	private void increaseSize()
	{
		capacity += 3;
		Item[] temp = new Item[capacity];
		for(int i=0;i<cart.length;i++)
			temp[i] = cart[i];
		cart = temp;
	}
}
