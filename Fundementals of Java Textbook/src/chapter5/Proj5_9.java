package chapter5;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj5_9 
{

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Project 5-9");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(8, 8));
		for(int i=0; i<64; i++)
		{
			pane.add(new ColorPanel(Color.WHITE));
		}
		frame.pack();
		frame.setVisible(true);
	}

	private static class ColorPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		protected static Random generator;
		
		static
		{
			generator = new Random();
		}
		
		public ColorPanel(Color c)
		{
			setBackground(c);
			addMouseListener(new PanelListener());
			setPreferredSize(new Dimension(50, 50));
		}
		
		private class PanelListener extends MouseAdapter
		{
			
			private boolean in = false;
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				in = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				in = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				if(in)
				{
					setBackground(new Color(generator.nextInt(255), generator.nextInt(255), generator.nextInt(255)));
				}
			}
		}
	}
}
