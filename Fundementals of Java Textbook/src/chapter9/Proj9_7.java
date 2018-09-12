package chapter9;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Proj9_7 
{

	private static JTextField[][] square = new JTextField[4][4];
	
	private static JLabel prompt = new JLabel("Fill in the square below:");
	private static JLabel result = new JLabel(" ");
	
	private static JButton check = new JButton("Check");
	
	private static JFrame frame = new JFrame("Project 9-7");
	
	public static void main(String[] args) 
	{
		ActionListener checkListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int[][] numSquare = input(square);
				if(numSquare == null)
					return;
				if(magicSquare(numSquare))
					result.setText("This is a magic square.");
				else
					result.setText("This is not a magic square.");
			}
		};
		check.addActionListener(checkListener);
		
		JPanel top = new JPanel();
		top.add(prompt);
		
		JPanel center = new JPanel(new GridLayout(4, 4));
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
			{
				square[i][j] = new JTextField(1);
				center.add(square[i][j]);
			}
		
		JPanel bottom = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		bottom.add(check, c);
		c.gridy = 1;
		bottom.add(result, c);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.add(top, BorderLayout.NORTH);
		pane.add(center, BorderLayout.CENTER);
		pane.add(bottom, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
	
	private static int[][] input(JTextField[][] grid)
	{
		int[][] in = new int[grid.length][grid[0].length];
		for(int i=0; i<grid.length; i++)
		{
			for(int j=0; j<grid[0].length; j++)
			{
				try
				{
					in[i][j] = (int) Double.parseDouble(grid[i][j].getText());
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(frame, "Input must be numerical.", "Project 9-7 - Error", JOptionPane.ERROR_MESSAGE);
					return null;
				}
			}
		}
		return in;
	}
	
	private static boolean magicSquare(int[][] numSquare)
	{
		if(numSquare.length!=numSquare[0].length)
			return false;
		
		if(numSquare.length == 1)
			return true;
		
		boolean[] used = new boolean[(int)Math.pow(numSquare.length,2)];
		int[] sums = new int[numSquare.length*2+2];
		boolean returnVal = true;
		
		for(int i=0;i<numSquare.length;i++)
		{
			for(int j=0;j<numSquare.length;j++)
			{
				used[numSquare[i][j]-1] = true;
				sums[i] += numSquare[i][j];
				sums[j+numSquare.length] += numSquare[i][j];
				if(i==j)
					sums[sums.length-2] += numSquare[i][j];
				if(i+j+1 == numSquare.length)
				{
					sums[sums.length-1] += numSquare[i][j];
				}
			}
		}
		
		for(int i=0;i<used.length && returnVal;i++)
			returnVal = returnVal && used[i];
		
		for(int i=1;i<sums.length && returnVal;i++)
			returnVal = returnVal && sums[i-1]==sums[i];
		
		return returnVal;
	}

}
