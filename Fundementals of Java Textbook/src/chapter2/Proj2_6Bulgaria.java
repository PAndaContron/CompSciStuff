package chapter2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj2_6Bulgaria 
{

	public static void main(String[] args) 
	{
		JPanel white = new JPanel();
		white.setBackground(Color.WHITE);
		white.setPreferredSize(new Dimension(500, 100));
		JPanel green = new JPanel();
		green.setBackground(new Color(0, 175, 102));
		green.setPreferredSize(new Dimension(500, 100));
		JPanel red = new JPanel();
		red.setBackground(Color.RED);
		red.setPreferredSize(new Dimension(500, 100));
		
		JFrame frame = new JFrame("Project 2-6 Bulgaria");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(3, 1));
		pane.add(white);
		pane.add(green);
		pane.add(red);
		
		frame.pack();
		frame.setVisible(true);
	}

}
