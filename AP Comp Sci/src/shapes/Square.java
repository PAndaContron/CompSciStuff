package shapes;

public class Square extends Quadrilateral
{
	public Square() {}
	
	public Square(double s)
	{
		super(s, s, s, s);
	}
	
	public double getArea()
	{
		return sides[0]*sides[0];
	}
}
