package chapter10;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj10_7 
{

	public static void main(String[] args) 
	{
		ShapePanel panel = new ShapePanel(Color.WHITE);
		
		JFrame frame = new JFrame("Project 10-7");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setSize(800, 200);
		frame.setVisible(true);
	}
	
	private static class ShapePanel extends JPanel
	{
		private static final long serialVersionUID = 1L;

		private static Random generator = new Random();
		
		private ShapeModel database = new ShapeModel(10);
		private Shape selectedShape = null;
		private int x, y;
		
		public ShapePanel(Color c)
		{
			setBackground(c);
			
			for(int i=0; i<10; i++)
			{
				Color color = new Color(generator.nextInt(256), generator.nextInt(256), generator.nextInt(256));
				Shape s;
				if(generator.nextBoolean())
					s = new Circle(i*40, 50, 25, color);
				else
					s = new Rect(i*40, 100, 50, 50, color);
				s.setFilled(true);
				database.add(s);
			}
			
			addMouseListener(new MouseAdapter()
			{
				@Override
				public void mousePressed(MouseEvent e)
				{
					x = e.getX();
					y = e.getY();
					selectedShape = database.containsPoint(x, y);
				}
				
				@Override
				public void mouseReleased(MouseEvent e)
				{
					x = e.getX();
					y = e.getY();
					selectedShape = null;
				}
			});
			
			addMouseMotionListener(new MouseMotionAdapter()
			{
				@Override
				public void mouseDragged(MouseEvent e)
				{
					int newX = e.getX();
					int newY = e.getY();
					int dx = newX - x;
					int dy = newY - y;
					if(selectedShape != null)
					{
						selectedShape.move(dx, dy);
						repaint();
					}
					x = newX;
					y = newY;
				}
			});
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			database.draw(g);
		}
	}
	
	private static class ShapeModel implements Iterable<Shape>
	{
		private Shape[] shapes;
		private int amount = 0;
		
		public ShapeModel(int size)
		{
			shapes = new Shape[size];
		}
		
		public void add(Shape s)
		{
			shapes[amount] = s;
			amount++;
		}
		
		public void draw(Graphics g)
		{
			for(Shape s : this)
				s.draw(g);
		}
		
		public Shape containsPoint(int x, int y)
		{
			for(Shape s : this)
			{
				if(s.containsPoint(x, y))
					return s;
			}
			return null;
		}
		
		@Override
		public Iterator<Shape> iterator()
		{
			return new ShapeIterator();
		}
		
		private class ShapeIterator implements Iterator<Shape>
		{
			private int index = 0;

			@Override
			public boolean hasNext() 
			{
				return index < amount;
			}

			@Override
			public Shape next() 
			{
				return shapes[index++];
			}
		}
	}

	private static interface Shape
	{
		public void draw(Graphics g);
		public boolean containsPoint(int x, int y);
		public void move(int xAmount, int yAmount);
		public void setFilled(boolean b);
	}
	
	abstract private static class AbstractShape implements Shape
	{
		protected boolean filled;
		protected int xPos, yPos;
		protected Color color;
		
		public AbstractShape(int x, int y, Color c)
		{
			xPos = x;
			yPos = y;
			color = c;
		}
		
		@Override
		public void setFilled(boolean b)
		{
			filled = b;
		}
		
		@Override
		public void move(int xAmount, int yAmount)
		{
			xPos += xAmount;
			yPos += yAmount;
		}
	}
	
	private static class Circle extends AbstractShape
	{
		private int radius;
		
		public Circle(int x, int y, int r, Color c)
		{
			super(x, y, c);
			radius = r;
		}
		
		@Override
		public void draw(Graphics g)
		{
			Color oldColor = g.getColor();
			g.setColor(color);
			if(filled)
				g.fillOval(xPos-radius, yPos-radius, radius*2, radius*2);
			else
				g.drawOval(xPos-radius, yPos-radius, radius*2, radius*2);
			g.setColor(oldColor);
		}
		
		@Override
		public boolean containsPoint(int x, int y)
		{
			return (x - xPos)*(x - xPos) + (y - yPos)*(y - yPos) <= radius*radius;
		}
	}
	
	private static class Rect extends AbstractShape
	{
		private int width, height;
		
		public Rect(int x, int y, int w, int h, Color c)
		{
			super(x, y, c);
			width = w;
			height = h;
		}
		
		@Override
		public void draw(Graphics g)
		{
			Color oldColor = g.getColor();
			g.setColor(color);
			if(filled)
				g.fillRect(xPos, yPos, width, height);
			else
				g.drawRect(xPos, yPos, width, height);
			g.setColor(oldColor);
		}
		
		@Override
		public boolean containsPoint(int x, int y)
		{
			int dx = x-xPos, dy = y-yPos;
			return dx >= 0 && dx <= width && dy >= 0 && dy <= height;
		}
	}
}
