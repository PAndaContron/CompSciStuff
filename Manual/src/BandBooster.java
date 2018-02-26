//***********************************************************************************
//  Rajat Patel
//  Band Booster
//  2/15/2017
//  Used for band booster (fundraiser) objects
//***********************************************************************************

public class BandBooster 
{
	String name;
	int boxesSold;
	
	//------------------------------------------------------------------------
	//	Initializes object with name and no boxes sold.
	//------------------------------------------------------------------------
	public BandBooster(String inName)
	{
		name = inName;
		boxesSold = 0;
	}
	
	//------------------------------------------------------------------------
	//	Returns the name.
	//------------------------------------------------------------------------
	public String getName()
	{
		return name;
	}
	
	//------------------------------------------------------------------------
	//	Adds boxes that have been sold.
	//------------------------------------------------------------------------
	public void updateSales(int boxes)
	{
		boxesSold += boxes;
	}
	
	//------------------------------------------------------------------------
	//	Returns a formatted string.
	//------------------------------------------------------------------------
	public String toString()
	{
		return name+":\t"+boxesSold+" boxes";
	}
}
