package shapes;

public class ShapeDriver
{
	public static void main(String[] args)
	{
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\tTesting Square");
		System.out.println("--------------------------------------------------------------------------------");
		Shape square = new Square(4);
		System.out.printf("Perimeter: %f%n", square.getPerimeter());
		System.out.printf("Area:      %f%n", square.getArea());
		System.out.println();
		try
		{
			new Square(0);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
		}
		try
		{
			new Square(-2);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e);
		}
		System.out.println();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\tTesting Triangle");
		System.out.println("--------------------------------------------------------------------------------");
		Triangle tri1 = new Triangle(3, 4, 5);
	}
}
