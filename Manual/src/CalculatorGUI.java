import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CalculatorGUI 
{
	private JFrame frame;
	private JPanel panel;
	private final int WIDTH = 300, HEIGHT = 100;
	private JTextField input1, input2;
	private JRadioButton add, sub, mult, div;
	private JCheckBox scientific;
	private JButton calculate;
	private JLabel resultLabel, result;
	
	
	public CalculatorGUI()
	{
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		resultLabel = new JLabel("Result: ");
		result = new JLabel("---");
		
		input1 = new JTextField(5);
		input2 = new JTextField(5);
		
		add = new JRadioButton("+", true);
		add.setBackground(Color.cyan);
		sub = new JRadioButton("-");
		sub.setBackground(Color.cyan);
		mult = new JRadioButton("*");
		mult.setBackground(Color.cyan);
		div = new JRadioButton("/");
		div.setBackground(Color.cyan);
		
		ButtonGroup group = new ButtonGroup();
		group.add(add);
		group.add(sub);
		group.add(mult);
		group.add(div);
		
		CalcListener listener = new CalcListener();
		
		scientific = new JCheckBox("Output in scientific notation");
		scientific.setBackground(Color.cyan);
		scientific.addItemListener(listener);
		
		calculate = new JButton("Calculate");
		calculate.addActionListener(listener);
		
		panel = new JPanel();
		panel.add(input1);
		panel.add(input2);
		panel.add(add);
		panel.add(sub);
		panel.add(mult);
		panel.add(div);
		panel.add(scientific);
		panel.add(calculate);
		panel.add(resultLabel);
		panel.add(result);
		panel.setBackground(Color.cyan);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame.getContentPane().add(panel);
	}
	
	public void display()
	{
		frame.pack();
		frame.setVisible(true);
	}
	
	private class CalcListener implements ActionListener, ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			calculate();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			calculate();
		}
		
		public void calculate()
		{
			double param1, param2;
			
			String text1 = input1.getText();
			
			try
			{
				param1 = Double.parseDouble(text1);
			}
			catch(NumberFormatException e)
			{
				input1.setBackground(Color.red);
				return;
			}
			input1.setBackground(Color.white);
			
			String text2 = input2.getText();
			
			try
			{
				param2 = Double.parseDouble(text2);
			}
			catch(NumberFormatException e)
			{
				input2.setBackground(Color.red);
				return;
			}
			input2.setBackground(Color.white);
			
			double output;
			
			if(add.isSelected())
				output = param1+param2;
			else if(sub.isSelected())
				output = param1-param2;
			else if(mult.isSelected())
				output = param1*param2;
			else
				output = param1/param2;
			
			String outText = String.valueOf(output);
			if(scientific.isSelected())
				outText = String.format("%6.3e", output);
			result.setText(outText);
		}
	}
}
