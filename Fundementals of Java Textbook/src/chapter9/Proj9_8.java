package chapter9;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Proj9_8 
{
	
	private static JLabel prompt = new JLabel("Enter the number of rows:");
	private static JTextField entry = new JTextField(5);
	private static JButton display = new JButton("Display");
	
	private static JFrame frame = new JFrame("Project 9-8");
	
	public static void main(String[] args) 
	{
		ActionListener displayListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int rows;
				try
				{
					rows = (int) Double.parseDouble(entry.getText());
				}
				catch(NumberFormatException exc)
				{
					JOptionPane.showMessageDialog(frame, "Input must be a number.", "Project 9-8 - Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int[][] triangle = new int[rows][];
				
				frame.setVisible(false);
				frame = new JFrame("Project 9-8");
				
				JPanel panel = new JPanel(new GridBagLayout());
				GridBagConstraints c = new GridBagConstraints();
				c.gridx = 0;
				c.anchor = GridBagConstraints.CENTER;
				for(c.gridy = 0; c.gridy<rows; c.gridy++)
				{
					triangle[c.gridy] = new int[c.gridy+1];
					triangle[c.gridy][0] = 1;
					triangle[c.gridy][c.gridy] = 1;
					for(int i=1; i<c.gridy; i++)
					{
						triangle[c.gridy][i] = triangle[c.gridy-1][i-1]+triangle[c.gridy-1][i];
					}
					String str = "";
					for(int i : triangle[c.gridy])
					{
						str += "    "+i;
					}
					panel.add(new JLabel(str.substring(4)), c);
				}
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(panel);
				frame.pack();
				frame.setVisible(true);
			}
		};
		display.addActionListener(displayListener);
		
		JPanel panel = new JPanel();
		panel.add(prompt);
		panel.add(entry);
		panel.add(display);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setSize(330, 75);
		frame.setVisible(true);
	}

}
