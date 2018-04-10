import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//Rajat Patel

public class AreYouSure 
{
	private JFrame frame = new JFrame("Continue?");
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Continue?");
	private JButton button = new JButton("Yes");
	
	public static void main(String[] args) 
	{
		new AreYouSure();
	}

	public AreYouSure() 
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new YesListener());
		panel.setPreferredSize(new Dimension(300, 100));
		panel.add(label);
		panel.add(button);
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private class YesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int current = JOptionPane.YES_OPTION;
			for(int count=0;;count++)
			{
				String sureString = "Are you sure";
				for(int i=0;i<count;i++)
					sureString += " you're sure";
				sureString += "?";
				int result = JOptionPane.showConfirmDialog(frame, sureString, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(result != current)
				{
					current = result;
					count = -1;
				}
			}
		}
	}
}
