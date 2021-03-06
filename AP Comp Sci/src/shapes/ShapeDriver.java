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
		System.out.println("Creating square with side length 0:");
		System.out.println(tryCode(() -> new Square(0)));
		System.out.println("Creating square with side length -2:");
		System.out.println(tryCode(() -> new Square(-2)));
		System.out.println();
		System.out.println();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\tTesting Triangle");
		System.out.println("--------------------------------------------------------------------------------");
		Shape tri1 = new Triangle(3, 4, 5);
		System.out.println("3-4-5 Triangle:");
		System.out.printf("\tPerimeter: %f%n", tri1.getPerimeter());
		System.out.printf("\tArea:      %f%n", tri1.getArea());
		System.out.printf("\tType:      %d%n", ((Triangle) tri1).getType());
		System.out.println("Different orders of parameters (should be the same output):");
		Shape tri1a1 = new Triangle(4, 3, 5);
		System.out.printf("\tPerimeter: %f%n", tri1a1.getPerimeter());
		System.out.printf("\tArea:      %f%n", tri1a1.getArea());
		System.out.printf("\tType:      %d%n", ((Triangle) tri1a1).getType());
		Shape tri1a2 = new Triangle(5, 4, 3);
		System.out.printf("\tPerimeter: %f%n", tri1a2.getPerimeter());
		System.out.printf("\tArea:      %f%n", tri1a2.getArea());
		System.out.printf("\tType:      %d%n", ((Triangle) tri1a2).getType());
		Shape tri1a3 = new Triangle(3, 5, 4);
		System.out.printf("\tPerimeter: %f%n", tri1a3.getPerimeter());
		System.out.printf("\tArea:      %f%n", tri1a3.getArea());
		System.out.printf("\tType:      %d%n", ((Triangle) tri1a3).getType());
		System.out.println();
		Shape tri2 = new Triangle(1, 1, 1);
		System.out.println("Equilateral Triangle:");
		System.out.printf("\tPerimeter: %f%n", tri2.getPerimeter());
		System.out.printf("\tArea:      %f%n", tri2.getArea());
		System.out.printf("\tType:      %d%n", ((Triangle) tri2).getType());
		System.out.println();
		Shape tri3 = new Triangle(2, 2, 3);
		System.out.println("2-2-3 Triangle:");
		System.out.printf("\tPerimeter: %f%n", tri3.getPerimeter());
		System.out.printf("\tArea:      %f%n", tri3.getArea());
		System.out.printf("\tType:      %d%n", ((Triangle) tri3).getType());
		System.out.println("Different orders of parameters (should be the same output):");
		Shape tri3a1 = new Triangle(3, 2, 2);
		System.out.printf("\tPerimeter: %f%n", tri3a1.getPerimeter());
		System.out.printf("\tArea:      %f%n", tri3a1.getArea());
		System.out.printf("\tType:      %d%n", ((Triangle) tri3a1).getType());
		Shape tri3a2 = new Triangle(2, 3, 2);
		System.out.printf("\tPerimeter: %f%n", tri3a2.getPerimeter());
		System.out.printf("\tArea:      %f%n", tri3a2.getArea());
		System.out.printf("\tType:      %d%n", ((Triangle) tri3a2).getType());
		System.out.println();
		System.out.println("Creating triangle with side lengths of 0:");
		System.out.println(tryCode(() -> new Triangle(0, 0, 0)));
		System.out.println("Creating triangle with negative side lengths:");
		System.out.println(tryCode(() -> new Triangle(-1, -1, -1)));
		System.out.println();
		System.out.println("Creating triangle with side lengths of 1, 1, 2:");
		System.out.println(tryCode(() -> new Triangle(1, 1, 2)));
		System.out.println("Different orders of parameters (should be the same output):");
		System.out.println(tryCode(() -> new Triangle(1, 2, 1)));
		System.out.println(tryCode(() -> new Triangle(2, 1, 1)));
		System.out.println();
		System.out.println("Creating triangle with side lengths of 1, 1, 3:");
		System.out.println(tryCode(() -> new Triangle(1, 1, 3)));
		System.out.println("Different orders of parameters (should be the same output):");
		System.out.println(tryCode(() -> new Triangle(1, 3, 1)));
		System.out.println(tryCode(() -> new Triangle(3, 1, 1)));
		System.out.println();
		System.out.println();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\tTesting compareTo");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("Area of Square:     %f%n", square.getArea());
		System.out.printf("Area of Triangle 1: %f%n", tri1.getArea());
		System.out.printf("Area of Triangle 2: %f%n", tri2.getArea());
		System.out.printf("Area of Triangle 3: %f%n", tri3.getArea());
		System.out.printf("Area of Triangle 4: %f%n", tri1a2.getArea());
		System.out.println();
		System.out.printf("Square <=> Triangle 1:     %d%n", square.compareTo(tri1));
		System.out.printf("Triangle 1 <=> Square:     %d%n", tri1.compareTo(square));
		System.out.printf("Triangle 1 <=> Triangle 2: %d%n", tri1.compareTo(tri2));
		System.out.printf("Triangle 2 <=> Triangle 1: %d%n", tri2.compareTo(tri1));
		System.out.printf("Triangle 2 <=> Triangle 3: %d%n", tri2.compareTo(tri3));
		System.out.printf("Triangle 3 <=> Triangle 2: %d%n", tri3.compareTo(tri2));
		System.out.printf("Triangle 1 <=> Triangle 3: %d%n", tri1.compareTo(tri3));
		System.out.printf("Triangle 3 <=> Triangle 1: %d%n", tri3.compareTo(tri1));
		System.out.printf("Triangle 1 <=> Triangle 4: %d%n", tri1.compareTo(tri1a1));
		System.out.printf("Triangle 4 <=> Triangle 1: %d%n", tri1a1.compareTo(tri1));
	}
	
	private static String tryCode(Runnable code)
	{
		try
		{
			code.run();
		}
		catch(Exception e)
		{
			return e.toString();
		}
		return "Ran without error!";
	}
}
