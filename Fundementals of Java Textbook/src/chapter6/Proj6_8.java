package chapter6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Proj6_8 
{

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Project 6-8");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ColorPanel(Color.YELLOW, 300, 300));
		frame.pack();
		frame.setVisible(true);
	}
	
	private static class ColorPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		private Circle circle;
		private Timer timer;
		
		public ColorPanel(Color backColor, int width, int height)
		{
			setBackground(backColor);
			setPreferredSize(new Dimension(width, height));
			circle = new Circle(25, height/2, 25, Color.red);
			circle.setDirection(180);
			circle.setVelocity(5);
			addMouseListener(new PauseListener());
			timer = new Timer(5, new MoveListener());
			timer.start();
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			circle.fill(g);
		}
		
		private class PauseListener extends MouseAdapter
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
				if(timer.isRunning())
					timer.stop();
				else
					timer.start();
			}
		}
		
		private class MoveListener implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				int x = circle.getX();
				int radius = circle.getRadius();
				int width = getWidth();
				if(x <= radius || x + radius >= width)
				{
					circle.turn(180);
				}
				circle.move();
				repaint();
			}
			
		}
	}

	private static class Circle
	{
		private int centerX, centerY, radius, velocity = 0, vectX, vectY;
		private double direction = 0;
		private Color color;
		
		public Circle(int x, int y, int r, Color c)
		{
			centerX = x;
			centerY = y;
			radius = r;
			color = c;
		}
		
		public int getX()
		{
			return centerX;
		}
		
		@SuppressWarnings("unused")
		public int getY()
		{
			return centerY;
		}
		
		public int getRadius()
		{
			return radius;
		}
		
		@SuppressWarnings("unused")
		public Color getColor()
		{
			return color;
		}
		
		@SuppressWarnings("unused")
		public void draw(Graphics g)
		{
			Color oldColor = g.getColor();
			g.setColor(color);
			g.drawOval(centerX-radius, centerY-radius, radius*2, radius*2);
			g.setColor(oldColor);
		}
		
		public void fill(Graphics g)
		{
			Color oldColor = g.getColor();
			g.setColor(color);
			g.fillOval(centerX-radius, centerY-radius, radius*2, radius*2);
			g.setColor(oldColor);
		}
		
		@SuppressWarnings("unused")
		public boolean containsPoint(int x, int y)
		{
			return (x - centerX)*(x - centerX) + (y - centerY)*(y - centerY) <= radius*radius;
		}
		
		public void moveAmount(int xAmount, int yAmount)
		{
			centerX += xAmount;
			centerY += yAmount;
		}
		
		public void move()
		{
			moveAmount(vectX, vectY);
		}
		
		public void setDirection(double degrees)
		{
			direction = degrees * Math.PI/180;
			updateVect();
		}
		
		public void turn(double degrees)
		{
			direction += degrees * Math.PI/180;
			updateVect();
		}
		
		public void setVelocity(int v)
		{
			velocity = v;
			updateVect();
		}
		
		private void updateVect()
		{
			vectX = (int) (Math.cos(direction) * velocity);
			vectY = (int) (Math.sin(direction) * velocity);
		}
	}
}
