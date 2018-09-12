package chapter7;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Proj7_5 
{
	
	private static Thermometer thermo = new Thermometer();
	
	private static JLabel fahrenheitLabel = new JLabel("Degrees Fahrenheit");
	private static JLabel celsiusLabel = new JLabel("Degrees Celsius");
	private static JTextField fahrenheitField = new JTextField("32.0");
	private static JTextField celsiusField = new JTextField("0.0");
	private static JButton fahrenheitButton = new JButton("Convert >>>");
	private static JButton celsiusButton = new JButton("<<< Convert");
	
	private static JFrame frame = new JFrame("Project 7-5");

	public static void main(String[] args) 
	{
		ActionListener fahrenheitListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				double fahrenheit;
				try
				{
					fahrenheit = Double.parseDouble(fahrenheitField.getText());
					thermo.setFahrenheit(fahrenheit);
					celsiusField.setText(""+thermo.getCelsius());
				}
				catch(NumberFormatException exc)
				{
					JOptionPane.showMessageDialog(frame, "Temperature must be a number",
							"Project 7-5 - Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		ActionListener celsiusListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				double celsius;
				try
				{
					celsius = Double.parseDouble(celsiusField.getText());
					thermo.setCelsius(celsius);
					fahrenheitField.setText(""+thermo.getFahrenheit());
				}
				catch(NumberFormatException exc)
				{
					JOptionPane.showMessageDialog(frame, "Temperature must be a number",
							"Project 7-5 - Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		
		fahrenheitButton.addActionListener(fahrenheitListener);
		celsiusButton.addActionListener(celsiusListener);
		
		JPanel dataPanel = new JPanel(new GridLayout(2, 2, 12, 6));
		dataPanel.add(fahrenheitLabel);
		dataPanel.add(celsiusLabel);
		dataPanel.add(fahrenheitField);
		dataPanel.add(celsiusField);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(fahrenheitButton);
		buttonPanel.add(celsiusButton);
		Container pane = frame.getContentPane();
		pane.add(dataPanel, BorderLayout.CENTER);
		pane.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	private static class Thermometer
	{
		private double degreesC;
		private static final double FACTOR = 5.0/9;
		
		public void setCelsius(double degrees)
		{
			degreesC = degrees;
		}
		
		public void setFahrenheit(double degrees)
		{
			degreesC = (degrees - 32) * FACTOR;
		}
		
		public double getCelsius()
		{
			return degreesC;
		}
		
		public double getFahrenheit()
		{
			return degreesC * 1.8 + 32;
		}
	}
}
