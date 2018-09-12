package abstractExcercise;

public class Driver 
{

	public static void main(String[] args) 
	{
		Rectangle rect = new Rectangle(4, 5);
		System.out.println(rect.getPerimeter());
		System.out.println(rect.getArea());

		RtTriangle tri = new RtTriangle(4, 5);
		System.out.println(tri.getPerimeter());
		System.out.println(tri.getArea());
	}

}
