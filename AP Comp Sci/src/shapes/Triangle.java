package shapes;

import java.util.Arrays;

public class Triangle extends Shape
{
	private double[] sides = new double[3];
	
	public Triangle() {}
	
	public Triangle(double a, double b, double c)
	{
		sides = new double[] {a, b, c};
		Arrays.sort(sides);
		if(sides[0]+sides[1] <= sides[2])
			throw new IllegalArgumentException("Sides do not fit triangle inequality");
		for(double i : sides)
		{
			if(i <= 0)
				throw new IllegalArgumentException("Side lengths must be positive");
		}
	}

	public double getArea()
	{
		double s = getPerimeter()/2;
		double prod = s;
		
		for(double i : sides)
			prod *= s-i;
		
		return Math.sqrt(prod);
	}

	public double getPerimeter()
	{
		double sum = 0;
		for(double i : sides)
			sum += i;
		return sum;
	}
	
	public int getType()
	{
		double left = sides[0]*sides[0] + sides[1]*sides[1];
		double right = sides[2]*sides[2];
		
		if(Math.abs(left-right) < 0.00001)
			return 0;
		return left>right ? -1 : 1;
	}
}
