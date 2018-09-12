package chapter2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Proj2_1 
{

	public static void main(String[] args) 
	{
		final int WIDTH = 200;
		final int HEIGHT = 75;
		
		JLabel name = new JLabel("Name: Someone");
		JLabel address = new JLabel("Address: Somewhere");
		JLabel number = new JLabel("Number: 888-222-2228");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setBackground(Color.YELLOW);
		panel.add(name);
		panel.add(address);
		panel.add(number);
		
		JFrame frame = new JFrame("Project 2-1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
