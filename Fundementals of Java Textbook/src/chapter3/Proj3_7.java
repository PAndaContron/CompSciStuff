package chapter3;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Proj3_7 
{

	public static void main(String[] args) 
	{
		JLabel center = new JLabel("");
		center.setHorizontalAlignment(SwingConstants.CENTER);
		center.setVerticalAlignment(SwingConstants.CENTER);
		center.setAlignmentX(Component.CENTER_ALIGNMENT);
		center.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.add(center);
		
		JFrame frame = new JFrame("Project 3-7");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		
		while(true)
		{
			int centerX = panel.getSize().width/2;
			int centerY = panel.getSize().height/2;
			center.setText("(" + centerX + ", " + centerY + ")");
			center.setLocation(centerX, centerY);
		}
	}

}
