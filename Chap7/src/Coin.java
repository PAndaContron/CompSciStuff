//***********************************************************************************
//  Rajat Patel
//  Coin
//  6/6/2017
//  Used to represent flippable coins
//***********************************************************************************

public class Coin
{
	private int face;
	private final int HEADS = 0;
	
	//------------------------------------------------------------------------
	//	Instantiates variables and flips the coin once.
	//------------------------------------------------------------------------
	public Coin()
	{
		flip();
	}
	
	//------------------------------------------------------------------------
	//	Flips the coin.
	//------------------------------------------------------------------------
	public void flip()
	{
		face = (int) (Math.random()*2);
	}
	
	//------------------------------------------------------------------------
	//	Returns the face as a boolean, where heads is true and tails is false.
	//------------------------------------------------------------------------
	public boolean isHeads()
	{
		return face==HEADS;
	}

	//------------------------------------------------------------------------
	//	Returns the coin object as a string.
	//------------------------------------------------------------------------
	public String toString()
	{
		String faceName;
		if(isHeads())
			faceName = "Heads";
		else
			faceName = "Tails";
		return faceName;
	}

}
