import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FahrenheitGUI 
{
	private int WIDTH = 300;
	private int HEIGHT = 75;
	
	private JFrame frame;
	private JPanel panel;
	private JLabel inputLabel, outputLabel, resultLabel;
	private JTextField fahrenheit;
	
	public FahrenheitGUI()
	{
		frame = new JFrame("Temperature Conversion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inputLabel = new JLabel("Enter Fahrenheit temperature:");
		outputLabel = new JLabel("Temperature in Celsius: ");
		resultLabel = new JLabel("---");
		
		fahrenheit = new JTextField(5);
		fahrenheit.addActionListener(new TempListener());
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setBackground(Color.yellow);
		panel.add(inputLabel);
		panel.add(fahrenheit);
		panel.add(outputLabel);
		panel.add(resultLabel);
		
		frame.getContentPane().add(panel);
	}
	
	public void display()
	{
		frame.pack();
		frame.setVisible(true);
	}
	
	private class TempListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			double fahrenheitTemp, celsiusTemp;
			
			String text = fahrenheit.getText();
			
			try
			{
				fahrenheitTemp = Double.parseDouble(text);
			}
			catch(NumberFormatException e)
			{
				fahrenheit.setBackground(Color.red);
				return;
			}
			
			fahrenheit.setBackground(Color.white);
			celsiusTemp = (fahrenheitTemp-32) * 5/9;
			
			resultLabel.setText(String.valueOf(celsiusTemp));
		}
	}
}
