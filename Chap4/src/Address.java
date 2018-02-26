//***********************************************************************************
//  Rajat Patel
//  Address
//  2/27/2017
//  Used to represent addresses
//***********************************************************************************

public class Address 
{
	private String streetAddress, city, state;
	private int zipCode;
	
	//------------------------------------------------------------------------
	//	Sets up this Address object with the specified data.
	//------------------------------------------------------------------------
	public Address(String street,String town,String st,int zip)
	{
		streetAddress = street;
		city = town;
		state = st;
		zipCode = zip;
	}
	
	//------------------------------------------------------------------------
	//	Returns this Address object as a String.
	//------------------------------------------------------------------------
	public String toString()
	{
		String result;
		
		result = streetAddress+"\n";
		result += city+", "+state+" "+zipCode;
		
		return result;
	}
}
