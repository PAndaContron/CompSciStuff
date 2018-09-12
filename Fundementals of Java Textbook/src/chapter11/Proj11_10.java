package chapter11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Proj11_10 
{
	private static JMenuItem create = new JMenuItem("Create");
	private static JMenuItem move = new JMenuItem("Move");
	private static JMenuItem delete = new JMenuItem("Delete");
	private static JMenuItem circle = new JMenuItem("Circle");
	private static JMenuItem rect = new JMenuItem("Rectangle");
	private static JMenuItem black = new JMenuItem("Black");
	private static JMenuItem blue = new JMenuItem("Blue");
	private static JMenuItem red = new JMenuItem("Red");
	private static JMenuItem random = new JMenuItem("Random");
	
	private static ShapePanel panel = new ShapePanel();
	
	private static JFrame frame = new JFrame("Project 11-10");
	
	private static Random gen = new Random();

	public static void main(String[] args) 
	{
		ActionListener shapeListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				panel.setManipType(((JMenuItem)e.getSource()).getText());
			}
		};
		
		create.addActionListener(shapeListener);
		move.addActionListener(shapeListener);
		delete.addActionListener(shapeListener);
		
		JMenu shape = new JMenu("Shape");
		shape.add(create);
		shape.add(move);
		shape.add(delete);
		
		ActionListener typeListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				panel.setShapeType(((JMenuItem)e.getSource()).getText());
			}
		};
		
		circle.addActionListener(typeListener);
		rect.addActionListener(typeListener);
		
		JMenu type = new JMenu("Type");
		type.add(circle);
		type.add(rect);
		
		ActionListener colorListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Color c;
				switch(((JMenuItem)e.getSource()).getText())
				{
					case("Black"):
						c = Color.BLACK;
						break;
					case("Blue"):
						c = Color.BLUE;
						break;
					case("Red"):
						c = Color.RED;
						break;
					default:
						c = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));
						break;
				}
				
				panel.setColor(c);
			}
		};
		
		black.addActionListener(colorListener);
		blue.addActionListener(colorListener);
		red.addActionListener(colorListener);
		random.addActionListener(colorListener);
		
		JMenu color = new JMenu("Color");
		color.add(black);
		color.add(blue);
		color.add(red);
		color.add(random);
		
		JMenuBar bar = new JMenuBar();
		bar.add(shape);
		bar.add(type);
		bar.add(color);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(bar);
		frame.getContentPane().add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	private static class ShapePanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		
		private ShapeModel model = new ShapeModel();
		private Shape selectedShape = null;
		private int x, y;
		private String manipType = "Create";
		private String shapeType = "Circle";
		private Color color = Color.BLACK;
		
		public ShapePanel()
		{
			addMouseListener(new MouseAdapter()
			{
				@Override
				public void mousePressed(MouseEvent e)
				{
					x = e.getX();
					y = e.getY();
					
					if(manipType.equals("Create"))
						return;
					
					selectedShape = model.containsPoint(x, y);
					
					if(manipType.equals("Delete") && selectedShape != null)
					{
						model.delete(selectedShape);
						selectedShape = null;
						repaint();
					}
				}

				@Override
				public void mouseReleased(MouseEvent e)
				{
					int newX = e.getX();
					int newY = e.getY();
					if(manipType.equals("Create"))
					{
						int dx = newX - x;
						int dy = newY - y;
						
						Shape s;
						if(shapeType.equals("Circle"))
							s = new Circle(x, y, (int)Math.sqrt(dx*dx + dy*dy), color);
						else
							s = new Rect(x, y, dx, dy, color);
						
						s.setFilled(true);
						model.add(s);
						repaint();
					}
					
					x = newX;
					y = newY;
					
					selectedShape = null;
				}
			});
			
			addMouseMotionListener(new MouseMotionAdapter()
			{
				@Override
				public void mouseDragged(MouseEvent e)
				{
					if(manipType.equals("Move"))
					{
						int newX = e.getX();
						int newY = e.getY();
						int dx = newX - x;
						int dy = newY - y;
						if(selectedShape != null)
							selectedShape.move(dx, dy);
						x = newX;
						y = newY;
						repaint();
					}
				}
			});
		}
		
		public void setManipType(String type)
		{
			manipType = type;
		}
		
		public void setShapeType(String type)
		{
			shapeType = type;
		}
		
		public void setColor(Color c)
		{
			color = c;
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			model.draw(g);
		}
	}

	private static class ShapeModel implements Iterable<Shape>
	{
		private List<Shape> shapes = new ArrayList<>();
		
		public void add(Shape s)
		{
			shapes.add(s);
		}
		
		public void delete(Shape s)
		{
			shapes.remove(s);
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
			return shapes.iterator();
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
