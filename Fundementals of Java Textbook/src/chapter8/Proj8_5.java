package chapter8;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Proj8_5 extends JApplet 
{
	private static final long serialVersionUID = 1L;
	private static Random generator = new Random();
	
	private int min, max, num;
	
	private JLabel range = new JLabel();
	private JLabel response = new JLabel();
	private JTextField guess = new JTextField(5);
	private JButton submit = new JButton("Submit");
	
	public void init()
	{
		ActionListener submitListener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					int guessNum = (int) Double.parseDouble(guess.getText());
					if(guessNum < min || guessNum > max) throw new IllegalArgumentException();
					if(guessNum < num)
						response.setText("Too low!");
					else if(guessNum > num)
						response.setText("Too high!");
					else
					{
						JOptionPane.showMessageDialog(null, "Correct!", "Project 8-5", JOptionPane.PLAIN_MESSAGE);
						reset();
					}
				}
				catch(NumberFormatException exc)
				{
					response.setText("Input must be a number!");
				}
				catch(IllegalArgumentException exc)
				{
					response.setText("Input must be between "+min+" and "+max+".");
				}
			}
		};
		submit.addActionListener(submitListener);
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints rangeC = new GridBagConstraints();
		rangeC.gridx = 1;
		rangeC.gridy = 0;
		rangeC.anchor = GridBagConstraints.CENTER;
		panel.add(range, rangeC);

		GridBagConstraints guessC = new GridBagConstraints();
		guessC.gridx = 0;
		guessC.gridy = 1;
		guessC.gridwidth = 3;
		panel.add(guess, guessC);

		GridBagConstraints responseC = new GridBagConstraints();
		responseC.gridx = 1;
		responseC.gridy = 2;
		responseC.anchor = GridBagConstraints.CENTER;
		panel.add(response, responseC);

		GridBagConstraints submitC = new GridBagConstraints();
		submitC.gridx = 0;
		submitC.gridy = 3;
		submitC.gridwidth = 3;
		submitC.fill = GridBagConstraints.HORIZONTAL;
		panel.add(submit, submitC);
		
		getContentPane().add(panel);
		setSize(300, 100);
		
		reset();
	}
	
	private void reset()
	{
		max = generator.nextInt(1000)+1;
		min = generator.nextInt(max);
		num = generator.nextInt(max-min+1)+min;
		
		range.setText("I'm thinking of a number between "+min+" and "+max+".");
		response.setText("Guess!");
		guess.setText("");
	}
}
