package chapter4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Proj4_12 
{

	public static void main(String[] args) 
	{
		JLabel width = new JLabel("Width: ");
		JLabel height = new JLabel("Height: ");
		
		JTextField widthEntry = new JTextField(5);
		JTextField heightEntry = new JTextField(5);
		
		JButton start = new JButton("Start");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setPreferredSize(new Dimension(300, 35));
		panel.add(width);
		panel.add(widthEntry);
		panel.add(height);
		panel.add(heightEntry);
		panel.add(start);
		
		JFrame frame = new JFrame("Project 4-12");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		start.addActionListener(new StartListener(frame, widthEntry, heightEntry));
		frame.pack();
		frame.setVisible(true);
	}
	
	private static class StartListener implements ActionListener
	{
		private JFrame settings;
		private JTextField widthEntry, heightEntry;
		
		public StartListener(JFrame frame, JTextField width, JTextField height)
		{
			settings = frame;
			widthEntry = width;
			heightEntry = height;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			final Color[] COLORS = {Color.BLACK, Color.RED};
			int width;
			int height;
			try
			{
				width = parseEntry(widthEntry);
				height = parseEntry(heightEntry);
			}
			catch(NumberFormatException e)
			{
				return;
			}
			settings.setVisible(false);
			JFrame frame = new JFrame("Project 4-12");
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
		
		private static int parseEntry(JTextField t)
		{
			try
			{
				int i = Integer.parseInt(t.getText());
				t.setBackground(Color.WHITE);
				return i;
			}
			catch(NumberFormatException e)
			{
				t.setBackground(Color.RED);
				throw e;
			}
		}
	}
}
