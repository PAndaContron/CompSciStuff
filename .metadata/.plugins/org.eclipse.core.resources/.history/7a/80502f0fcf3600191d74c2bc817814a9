package shapes;

import java.util.Arrays;

public class Triangle extends Shape
{
	protected double[] sides = new double[3];
	
	public Triangle() {}
	
	public Triangle(double a, double b, double c)
	{
		sides = new double[] {a, b, c};
		Arrays.sort(sides);
		if(sides[0]+sides[1] <= sides[2])
			throw new IllegalArgumentException();
	}

	public double getArea()
	{
		return 0;
	}

	public double getPerimeter()
	{
		return 0;
	}
}
