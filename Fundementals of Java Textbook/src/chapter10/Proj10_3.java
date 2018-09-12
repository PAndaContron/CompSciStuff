package chapter10;

import java.awt.Color;
import java.util.Scanner;

import TurtleGraphics.Pen;
import TurtleGraphics.StandardPen;

public class Proj10_3 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		Pen p = new StandardPen();
		Circle circle = new Circle(20, 20, 20);
		Wheel wheel = new Wheel(-20, 20, 20, 6);
		Rect rect = new Rect();
		
		circle.draw(p);
		wheel.draw(p);
		rect.draw(p);
		
		System.out.println(circle);
		System.out.println(wheel);
		System.out.println(rect);
		
		System.out.println("Press Enter to continue.");
		scan.nextLine();
		
		p.setColor(Color.WHITE);
		circle.draw(p);
		wheel.draw(p);
		rect.draw(p);
		p.setColor(Color.RED);
		
		circle.move(30, 30);
		circle.stretchBy(2);
		wheel.move(-30, 30);
		wheel.stretchBy(2);
		wheel.setSpokes(9);
		rect.move(-30, -30);
		rect.stretchBy(10);
		
		circle.draw(p);
		wheel.draw(p);
		rect.draw(p);
		
		scan.close();
	}
	
	private static interface Shape
	{
		public double area();
		public double perimeter();
		public void draw(Pen p);
		public double getXPos();
		public double getYPos();
		public void move(double xLoc, double yLoc);
		public void stretchBy(double factor);
		public String toString();
	}
	
	abstract private static class AbstractShape implements Shape
	{
		protected double xPos, yPos;
		
		public AbstractShape()
		{
			this(0, 0);
		}
		
		public AbstractShape(double xLoc, double yLoc)
		{
			xPos = xLoc;
			yPos = yLoc;
		}
		
		@Override
		public final double getXPos()
		{
			return xPos;
		}
		
		@Override
		public final double getYPos()
		{
			return yPos;
		}
		
		@Override
		public final void move(double xLoc, double yLoc)
		{
			xPos = xLoc;
			yPos = yLoc;
		}
		
		@Override
		public String toString()
		{
			return "Position: ("+xPos+", "+yPos+")\nArea: "+area()+"\nPerimeter: "+perimeter();
		}
	}
	
	private static class Circle extends AbstractShape
	{
		protected double radius;
		
		public Circle()
		{
			this(1);
		}
		
		public Circle(double r)
		{
			super();
			radius = r;
		}
		
		public Circle(double xLoc, double yLoc, double r)
		{
			super(xLoc, yLoc);
			radius = r;
		}
		
		@Override
		public double area()
		{
			return Math.PI * radius*radius;
		}
		
		@Override
		public double perimeter()
		{
			return 2 * Math.PI * radius;
		}
		
		@Override
		public void draw(Pen p)
		{
			double side = perimeter() / 120;
			p.up();
			p.move(xPos + radius, yPos - side/2);
			p.setDirection(90);
			p.down();
			for(int i=0; i<120; i++)
			{
				p.move(side);
				p.turn(3);
			}
		}
		
		@Override
		public void stretchBy(double factor)
		{
			radius *= factor;
		}
		
		@Override
		public String toString()
		{
			return "CIRCLE\nRadius: "+radius+"\n"+super.toString();
		}
	}
	
	private static class Wheel extends Circle
	{
		private int spokes;
		
		@SuppressWarnings("unused")
		public Wheel()
		{
			super();
			spokes = 0;
		}
		
		public Wheel(double xLoc, double yLoc, double r, int s)
		{
			super(xLoc, yLoc, r);
			spokes = s;
		}
		
		@Override
		public void draw(Pen p)
		{
			super.draw(p);
			
			for(int i=1; i<=spokes; i++)
			{
				p.up();
				p.move(xPos, yPos);
				p.setDirection(i * 360.0/spokes);
				p.down();
				p.move(radius);
			}
		}
		
		public void setSpokes(int s)
		{
			spokes = s;
		}
		
		@Override
		public String toString()
		{
			return "WHEEL\nSpokes: "+spokes + super.toString().substring(6);
		}
	}
	
	private static class Rect extends AbstractShape
	{
		private double height, width;
		
		public Rect()
		{
			this(0, 0, 1, 1);
		}
		
		public Rect(double xLoc, double yLoc, double w, double h)
		{
			super(xLoc, yLoc);
			height = h;
			width = w;
		}
		
		@Override
		public double area()
		{
			return height*width;
		}
		
		@Override
		public double perimeter()
		{
			return 2 * (height+width);
		}
		
		@Override
		public void draw(Pen p)
		{
			p.up();
			p.move(xPos, yPos);
			p.down();
			p.setDirection(0);
			p.move(width);
			p.turn(-90);
			p.move(height);
			p.turn(-90);
			p.move(width);
			p.turn(-90);
			p.move(height);
		}
		
		@Override
		public void stretchBy(double factor)
		{
			height *= factor;
			width *= factor;
		}
		
		@Override
		public String toString()
		{
			return "RECTANGLE\nWidth x Height: "+width+"x"+height+"\n"+super.toString();
		}
	}

}
