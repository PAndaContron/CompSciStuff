package chapter3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Proj3_6 
{

	public static void main(String[] args) 
	{
		JPanel panel = new JPanel()
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics context)
			{
				super.paintComponent(context);
				
				context.drawLine(50, 60, 250, 60);
				context.drawLine(50, 60, 70, 80);
				context.drawLine(50, 60, 70, 40);
				context.drawLine(250, 60, 230, 80);
				context.drawLine(250, 60, 230, 40);
				
				context.drawLine(50, 140, 250, 140);
				context.drawLine(50, 140, 30, 160);
				context.drawLine(50, 140, 30, 120);
				context.drawLine(250, 140, 270, 160);
				context.drawLine(250, 140, 270, 120);
			}
		};
		panel.setPreferredSize(new Dimension(300, 200));
		panel.setBackground(Color.WHITE);
		
		JFrame frame = new JFrame("Project 3-6");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
