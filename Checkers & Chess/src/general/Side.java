package general;

public enum Side 
{
	LEFT,
	RIGHT,
	TOP,
	BOTTOM;
	
	public Side getOpposite(Side s)
	{
		switch(s)
		{
			case LEFT:
				return RIGHT;
			case RIGHT:
				return LEFT;
			case TOP:
				return BOTTOM;
			case BOTTOM:
				return TOP;
		}
		throw new IllegalArgumentException();
	}
}
