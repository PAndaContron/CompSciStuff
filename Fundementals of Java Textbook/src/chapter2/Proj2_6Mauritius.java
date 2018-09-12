package chapter2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj2_6Mauritius 
{

	public static void main(String[] args) 
	{
		JPanel red = new JPanel();
		red.setBackground(Color.RED);
		red.setPreferredSize(new Dimension(300, 50));
		JPanel blue = new JPanel();
		blue.setBackground(Color.BLUE);
		blue.setPreferredSize(new Dimension(300, 50));
		JPanel yellow = new JPanel();
		yellow.setBackground(Color.YELLOW);
		yellow.setPreferredSize(new Dimension(300, 50));
		JPanel green = new JPanel();
		green.setBackground(new Color(0, 153, 102));
		green.setPreferredSize(new Dimension(300, 50));
		
		JFrame frame = new JFrame("Project 2-6 Mauritius");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(4, 1));
		pane.add(red);
		pane.add(blue);
		pane.add(yellow);
		pane.add(green);
		
		frame.pack();
		frame.setVisible(true);
	}

}
