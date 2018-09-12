package chapter10;

import java.awt.Color;
import java.util.Scanner;

import TurtleGraphics.Pen;
import TurtleGraphics.StandardPen;

public class Proj10_4 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		Pen p = new StandardPen();
		Circle circle = new Circle(20, 20, 20);
		Wheel wheel = new Wheel(-20, 20, 20, 6);
		Rect rect = new Rect();
		Triangle tri = new Triangle(-50, -50, -60, -60, -50, -60);
		
		circle.draw(p);
		wheel.draw(p);
		rect.draw(p);
		tri.draw(p);
		
		System.out.println(circle);
		System.out.println(wheel);
		System.out.println(rect);
		System.out.println(tri);
		
		System.out.println("Press Enter to continue.");
		scan.nextLine();
		
		p.setColor(Color.WHITE);
		circle.draw(p);
		wheel.draw(p);
		rect.draw(p);
		tri.draw(p);
		p.setColor(Color.RED);
		
		circle.move(30, 30);
		circle.stretchBy(2);
		wheel.move(-30, 30);
		wheel.stretchBy(2);
		wheel.setSpokes(9);
		rect.move(-30, -30);
		rect.stretchBy(10);
		tri.move(50, -50);
		tri.stretchBy(.5);
		
		circle.draw(p);
		wheel.draw(p);
		rect.draw(p);
		tri.draw(p);
		
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
		public void move(double xLoc, double yLoc)
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
	
	private static class Triangle extends AbstractShape
	{
		private double x2, y2, x3, y3;
		
		public Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
		{
			super(x1, y1);
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
		}

		@Override
		public double area() 
		{
			return .5 * Math.abs(xPos*y2 - x2*yPos + x2*y3 - x3*y2 + x3*yPos - xPos*y3);
		}

		@Override
		public double perimeter() 
		{
			return distance(xPos, yPos, x2, y2)
					+ distance(x2, y2, x3, y3)
					+ distance(x3, y3, xPos, yPos);
		}

		@Override
		public void draw(Pen p) 
		{
			p.up();
			p.move(xPos, yPos);
			p.down();
			p.move(x2, y2);
			p.move(x3, y3);
			p.move(xPos, yPos);
		}
		
		@Override
		public void move(double xLoc, double yLoc)
		{
			x2 += xLoc-xPos;
			y2 += yLoc-yPos;
			x3 += xLoc-xPos;
			y3 += yLoc-yPos;
			super.move(xLoc, yLoc);
		}

		@Override
		public void stretchBy(double factor) 
		{
			x2 = xPos + (x2-xPos)*factor;
			y2 = yPos + (y2-yPos)*factor;
			x3 = xPos + (x3-xPos)*factor;
			y3 = yPos + (y3-yPos)*factor;
		}
		
		@Override
		public String toString()
		{
			return "TRIANGLE\nVertices: ("+xPos+", "+yPos+"), ("+x2+", "+y2+"), ("+x3+", "+y3+")\n"
					+"Area: "+area()+"\nPerimeter: "+perimeter();
		}
		
		private static double distance(double x1, double y1, double x2, double y2)
		{
			return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		}
		
	}

}
