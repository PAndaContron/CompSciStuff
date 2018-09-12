package chapter7;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Proj7_6 
{
	private static JLabel prompt = new JLabel("Radius:");
	private static JLabel area = new JLabel("Area:");
	private static JLabel surfaceArea = new JLabel("Surface Area:");
	private static JLabel volume = new JLabel("Volume:");
	
	private static JButton calculate = new JButton("Calculate");
	
	private static JTextField radius = new JTextField(5);
	
	private static JFrame frame = new JFrame("Project 7-6");

	public static void main(String[] args) 
	{
		ActionListener listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double r = Double.parseDouble(radius.getText());
					if(r <= 0) throw new IllegalArgumentException();
					
					area.setText("Area: " + Math.PI*r*r);
					surfaceArea.setText("Surface Area: " + 4*Math.PI*r*r);
					volume.setText("Volume: " + 4*Math.PI*r*r*r/3);
				}
				catch(NumberFormatException exc)
				{
					JOptionPane.showMessageDialog(frame, "Input must be a number.", "Project 7-6 - Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(IllegalArgumentException exc)
				{
					JOptionPane.showMessageDialog(frame, "Input must be positive.", "Project 7-6 - Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		calculate.addActionListener(listener);
		
		JPanel input = new JPanel();
		input.add(prompt);
		input.add(radius);
		
		JPanel panel = new JPanel(new GridLayout(5, 1));
		panel.setPreferredSize(new Dimension(250, 200));
		panel.add(input);
		panel.add(area);
		panel.add(surfaceArea);
		panel.add(volume);
		panel.add(calculate);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
