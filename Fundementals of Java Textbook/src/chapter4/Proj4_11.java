package chapter4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj4_11 
{

	public static void main(String[] args) 
	{
		final Color[] COLORS = {Color.BLACK, Color.RED};
		int width = 8;
		int height = 8;
		JFrame frame = new JFrame("Project 4-11");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(height, width));
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
			{
				frame.getContentPane().add(square(COLORS[(i+j)%2]));
			}
		}
		frame.pack();
		frame.setVisible(true);
	}

	private static JPanel square(Color c)
	{
		JPanel panel = new JPanel();
		panel.setBackground(c);
		panel.setPreferredSize(new Dimension(50, 50));
		return panel;
	}
}
