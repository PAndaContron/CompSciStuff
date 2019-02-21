package shapes;

public abstract class Shape implements Comparable<Shape>
{
	public int compareTo(Shape other)
	{
		return (int) (getArea()-other.getArea());
	}
	
	abstract public double getArea();
	abstract public double getPerimeter();
}
