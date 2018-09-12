package chapter5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj5_8 
{

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Project 5-8");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ColorPanel(Color.YELLOW));
		frame.pack();
		frame.setVisible(true);
	}
	
	private static class ColorPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;

		public ColorPanel(Color c)
		{
			setBackground(c);
			setPreferredSize(new Dimension(150, 150));
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Rectangle r1 = new Rectangle(25, 25, 50, 50, Color.RED);
			Rectangle r2 = new Rectangle(25, 25, 50, 50, Color.BLUE);
			
			r2.setX1(70);
			r2.setY1(20);
			r2.setX2(95);
			r2.setY2(45);
			r2.move(5, 5);
			
			System.out.println(r1.containsPoint(27, 27));
			
			r1.fill(g);
			r2.draw(g);
		}
	}

	private static class Rectangle
	{
		private int x1, x2, y1, y2;
		private Color c;
		
		public Rectangle(int x1, int y1, int x2, int y2, Color c)
		{
			setCorners(x1, y1, x2, y2);
			setColor(c);
		}
		
		public int getX1()
		{
			return x1;
		}
		
		public int getY1()
		{
			return y1;
		}
		
		public int getX2()
		{
			return x2;
		}
		
		public int getY2()
		{
			return y2;
		}
		
		public Color getColor()
		{
			return c;
		}
		
		public void setX1(int x1)
		{
			setCorners(x1, y1, x2, y2);
		}
		
		public void setY1(int y1)
		{
			setCorners(x1, y1, x2, y2);
		}
		
		public void setX2(int x2)
		{
			setCorners(x1, y1, x2, y2);
		}
		
		public void setY2(int y2)
		{
			setCorners(x1, y1, x2, y2);
		}
		
		public void setCorners(int x1, int y1, int x2, int y2)
		{
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			
			if(this.x1 > this.x2)
			{
				int temp = this.x1;
				this.x1 = this.x2;
				this.x2 = temp;
			}
			if(this.y1 > this.y2)
			{
				int temp = this.y1;
				this.y1 = this.y2;
				this.y2 = temp;
			}
		}
		
		public void setColor(Color c)
		{
			this.c = c;
		}
		
		public void draw(Graphics g)
		{
			Color oldColor = g.getColor();
			g.setColor(c);
			g.drawRect(x1, y1, x2-x1, y2-y1);
			g.setColor(oldColor);
		}
		
		public void fill(Graphics g)
		{
			Color oldColor = g.getColor();
			g.setColor(c);
			g.fillRect(x1, y1, x2-x1, y2-y1);
			g.setColor(oldColor);
		}
		
		public boolean containsPoint(int x, int y)
		{
			return x>=x1 && x<=x2 && y>=y1 && y<=y2;
		}
		
		public void move(int xAmount, int yAmount)
		{
			x1 += xAmount;
			x2 += xAmount;
			y1 += yAmount;
			y2 += yAmount;
		}
		
		public String toString()
		{
			return getColor() + " rectangle at " + getX1() + ", " + getY1() + " to " + getX2() + ", " + getY2();
		}
	}
}
