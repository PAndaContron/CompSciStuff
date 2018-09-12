package chapter12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Proj12_8 
{
	private static JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 10, 0);
	private static MondrianPanel panel = new MondrianPanel(Color.WHITE);

	public static void main(String[] args) 
	{
		slider.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				panel.setLevel(slider.getValue());
			}
		});
		
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		JPanel sliderPanel = new JPanel();
		sliderPanel.add(slider);
		
		JFrame frame = new JFrame("Project 12-8");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.getContentPane().add(sliderPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	private static class MondrianPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		private static Random gen = new Random();
		
		private int level = 0;
		private long seed = gen.nextLong();
		
		public MondrianPanel(Color backColor)
		{
			setBackground(backColor);
			setPreferredSize(new Dimension(300, 200));
		}
		
		public void setLevel(int newLevel)
		{
			level = newLevel;
			repaint();
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			gen.setSeed(seed);
			mondrian(g, 0, 0, getWidth(), getHeight(), level);
		}
		
		private void mondrian(Graphics g, int x1, int y1, int x2, int y2, int level)
		{
			if(level > 0)
			{
				g.setColor(new Color(gen.nextInt(256), gen.nextInt(256),
						gen.nextInt(256)));
				g.fillRect(x1, y1, x2-x1, y2-y1);
				g.setColor(Color.BLACK);
				g.drawRect(x1, y1, x2-x1, y2-y1);
				if(gen.nextBoolean())
				{
					mondrian(g, x1, y1, (x2-x1)/3 + x1, y2, level-1);
					mondrian(g, (x2-x1)/3 + x1, y1, x2, y2, level-1);
				}
				else
				{
					mondrian(g, x1, y1, x2, (y2-y1)/3 + y1, level-1);
					mondrian(g, x1, (y2-y1)/3 + y1, x2, y2, level-1);
				}
			}
		}
	}
}
