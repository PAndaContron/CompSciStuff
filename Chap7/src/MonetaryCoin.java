//***********************************************************************************
//  Rajat Patel
//  MonetaryCoin
//  6/6/2017
//  Represents a coin with a monetary value
//***********************************************************************************

import java.text.NumberFormat;

public class MonetaryCoin extends Coin 
{
	private double value;
	NumberFormat fmt;
	
	//------------------------------------------------------------------------
	//	Instantiates variables and flips the coin once.
	//------------------------------------------------------------------------
	public MonetaryCoin(double moneyValue)
	{
		super();
		value = moneyValue;
		fmt = NumberFormat.getCurrencyInstance();
	}
	
	//------------------------------------------------------------------------
	//	Returns the value of this coin.
	//------------------------------------------------------------------------
	public double getValue()
	{
		return value;
	}
	
	//------------------------------------------------------------------------
	//	Returns a string with information about the coin.
	//------------------------------------------------------------------------
	public String toString()
	{
		return fmt.format(value)+"\t"+super.toString();
	}
}
