import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StyleGUI 
{
	private final int WIDTH = 300, HEIGHT = 100, FONT_SIZE = 36;
	private JLabel saying;
	private JCheckBox bold, italic;
	private JPanel primary;
	private JFrame frame;
	
	public StyleGUI()
	{
		saying = new JLabel("Say it with style!");
		saying.setFont(new Font("Helvetica", Font.PLAIN, FONT_SIZE));
		
		bold = new JCheckBox("Bold");
		bold.setBackground(Color.cyan);
		italic = new JCheckBox("Italic");
		italic.setBackground(Color.cyan);
		
		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		
		primary = new JPanel();
		primary.add(saying);
		primary.add(bold);
		primary.add(italic);
		primary.setBackground(Color.cyan);
		primary.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame = new JFrame("Style Options");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(primary);
	}
	
	public void display()
	{
		frame.pack();
		frame.setVisible(true);
	}
	
	private class StyleListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			int style = Font.PLAIN;
			
			if(bold.isSelected())
				style = Font.BOLD;
			if(italic.isSelected())
				style += Font.ITALIC;
			
			saying.setFont(new Font("Helvetica", style, FONT_SIZE));
		}
	}
}
