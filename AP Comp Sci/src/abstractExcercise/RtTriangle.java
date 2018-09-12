package abstractExcercise;

public class RtTriangle extends Shape 
{
	private double width, height;

	public RtTriangle(double width, double height) 
	{
		super(3);
		this.width = width;
		this.height = height;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public void setWidth(double width)
	{
		this.width = width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public void setHeight(double height)
	{
		this.height = height;
	}

	@Override
	public double getArea() 
	{
		return width*height / 2;
	}

	@Override
	public double getPerimeter() 
	{
		return width + height + Math.sqrt(width*width + height*height);
	}

}
