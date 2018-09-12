package chapter5;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Proj5_7 
{

	public static void main(String[] args) 
	{
		JRadioButton one = new JRadioButton("1");
		one.setBackground(Color.YELLOW);
		JRadioButton two = new JRadioButton("2");
		two.setBackground(Color.YELLOW);
		JRadioButton four = new JRadioButton("4");
		four.setBackground(Color.YELLOW);
		one.setSelected(true);
		
		ButtonGroup num = new ButtonGroup();
		num.add(one);
		num.add(two);
		num.add(four);
		
		JButton start = new JButton("Start");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setPreferredSize(new Dimension(200, 35));
		panel.add(one);
		panel.add(two);
		panel.add(four);
		panel.add(start);
		
		JFrame frame = new JFrame("Project 5-7");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.addActionListener(new StartListener(frame, num));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	private static class ColorPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		private ImageIcon image;
		
		public ColorPanel(Color c, ImageIcon i)
		{
			setBackground(c);
			image = i;
			setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			image.paintIcon(this, g, (getWidth()-image.getIconWidth())/2, (getHeight()-image.getIconHeight())/2);
		}
	}
	
	private static class StartListener implements ActionListener
	{
		private ButtonGroup selection;
		private JFrame old;
		
		public StartListener(JFrame frame, ButtonGroup num)
		{
			old = frame;
			selection = num;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			old.setVisible(false);
			JRadioButton b;
			Enumeration<AbstractButton> e = selection.getElements();
			for(b = (JRadioButton) e.nextElement(); e.hasMoreElements(); b = (JRadioButton) e.nextElement())
			{
				if(b.isSelected())
					break;
			}
			int i = Integer.parseInt(b.getText());
			
			JFrame frame = new JFrame("Project 5-7");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container pane = frame.getContentPane();
			pane.setLayout(new GridLayout(Math.max(i/2, 1), Math.min(2, i)));
			for(int j=0; j<i; j++)
			{
				pane.add(new ColorPanel(Color.RED, new ImageIcon("Ball.png")));
			}
			frame.pack();
			frame.setVisible(true);
		}
		
	}
}
