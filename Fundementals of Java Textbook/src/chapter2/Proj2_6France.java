package chapter2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj2_6France 
{

	public static void main(String[] args) 
	{
		JPanel blue = new JPanel();
		blue.setBackground(Color.BLUE);
		blue.setPreferredSize(new Dimension(100, 200));
		JPanel white = new JPanel();
		white.setBackground(Color.WHITE);
		white.setPreferredSize(new Dimension(100, 200));
		JPanel red = new JPanel();
		red.setBackground(Color.RED);
		red.setPreferredSize(new Dimension(100, 200));
		
		JFrame frame = new JFrame("Project 2-6 France");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(1, 3));
		pane.add(blue);
		pane.add(white);
		pane.add(red);
		
		frame.pack();
		frame.setVisible(true);
	}

}
