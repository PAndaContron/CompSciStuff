//***********************************************************************************
//  Rajat Patel
//  Coin
//  3/30/2017
//  Used to represent flippable and lockable coins
//***********************************************************************************

public class Coin implements Lockable 
{
	private int face,key;
	private boolean locked;
	private final int HEADS = 0;
	
	//------------------------------------------------------------------------
	//	Instantiates variables and flips the coin once.
	//------------------------------------------------------------------------
	public Coin()
	{
		key = 0;
		locked = false;
		flip();
	}
	
	//------------------------------------------------------------------------
	//	Flips the coin.
	//------------------------------------------------------------------------
	public void flip()
	{
		if(!locked)
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
	//	Changes the key.
	//------------------------------------------------------------------------
	public void setKey(int newKey) 
	{
		if(!locked)
			key = newKey;
	}

	//------------------------------------------------------------------------
	//	Locks the coin if the key is correct.
	//------------------------------------------------------------------------
	public void lock(int attempt) 
	{
		if(attempt==key)
			locked = true;
	}

	//------------------------------------------------------------------------
	//	Unlocks the coin if the key is correct.
	//------------------------------------------------------------------------
	public void unlock(int attempt) 
	{
		if(attempt==key)
			locked = false;
	}

	//------------------------------------------------------------------------
	//	Returns whether or not the object is locked.
	//------------------------------------------------------------------------
	public boolean locked() 
	{
		return locked;
	}

	//------------------------------------------------------------------------
	//	Returns the coin object as a string.
	//------------------------------------------------------------------------
	public String toString()
	{
		if(locked)
			return "Locked";
		String faceName;
		if(isHeads())
			faceName = "Heads";
		else
			faceName = "Tails";
		return faceName;
	}

}
