package shapes;

public abstract class Quadrilateral extends Shape
{
	protected double[] sides = new double[4];
	
	public Quadrilateral() {}
	
	public Quadrilateral(double a, double b, double c, double d)
	{
		sides = new double[] {a, b, c, d};
		for(double i : sides)
		{
			if(i <= 0)
				throw new IllegalArgumentException("Side lengths must be positive");
		}
	}
	
	public double getPerimeter()
	{
		double sum = 0;
		for(double i : sides)
			sum += i;
		return sum;
	}
}
