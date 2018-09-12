package chapter2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj2_7 
{

	public static void main(String[] args) 
	{
		JPanel black = new JPanel();
		black.setPreferredSize(new Dimension(100, 100));
		black.setBackground(Color.BLACK);
		JPanel white = new JPanel();
		white.setPreferredSize(new Dimension(100, 100));
		white.setBackground(Color.WHITE);
		JPanel black1 = new JPanel();
		black1.setPreferredSize(new Dimension(100, 100));
		black1.setBackground(Color.BLACK);
		JPanel white1 = new JPanel();
		white1.setPreferredSize(new Dimension(100, 100));
		white1.setBackground(Color.WHITE);
		JPanel black2 = new JPanel();
		black2.setPreferredSize(new Dimension(100, 100));
		black2.setBackground(Color.BLACK);
		JPanel white2 = new JPanel();
		white2.setPreferredSize(new Dimension(100, 100));
		white2.setBackground(Color.WHITE);
		JPanel black3 = new JPanel();
		black3.setPreferredSize(new Dimension(100, 100));
		black3.setBackground(Color.BLACK);
		JPanel white3 = new JPanel();
		white3.setPreferredSize(new Dimension(100, 100));
		white3.setBackground(Color.WHITE);
		JPanel black4 = new JPanel();
		black4.setPreferredSize(new Dimension(100, 100));
		black4.setBackground(Color.BLACK);
		
		JFrame frame = new JFrame("Project 2-7");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		pane.add(black);
		pane.add(white);
		pane.add(black1);
		pane.add(white1);
		pane.add(black2);
		pane.add(white2);
		pane.add(black3);
		pane.add(white3);
		pane.add(black4);
		
		frame.pack();
		frame.setVisible(true);
	}

}
