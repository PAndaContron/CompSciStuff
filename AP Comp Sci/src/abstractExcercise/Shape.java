package abstractExcercise;

public abstract class Shape 
{
	private int numSides;
	
	public Shape(int sides)
	{
		numSides = sides;
	}
	
	public int getSides()
	{
		return numSides;
	}
	
	abstract public double getArea();
	abstract public double getPerimeter();
}
