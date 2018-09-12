package chapter4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj4_13 
{

	public static void main(String[] args) 
	{
		RectPanel black = new RectPanel(Color.BLACK);
		RectPanel white = new RectPanel(Color.WHITE);
		
		JFrame frame = new JFrame("Project 4-13");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 2));
		frame.getContentPane().add(black);
		frame.getContentPane().add(white);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static class RectPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;

		public RectPanel(Color c)
		{
			setBackground(c);
			setPreferredSize(new Dimension(100, 200));
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			g.setColor(Color.GRAY);
			g.fillRect(getWidth()/2 - 25, getHeight()/2 - 25, 50, 50);
		}
	}

}
