package chapter9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Proj9_10 
{
	
	private static int tries = 5;
	private static int score = 0;
	
	private static JLabel scoreLabel = new JLabel("Score: 0");
	private static JLabel triesLabel = new JLabel("Tries remaining: 5");
	private static Square[][] grid = new Square[5][5];

	private static JFrame frame = new JFrame("Project 9-10");

	public static void main(String[] args) 
	{
		KeyListener enterListener = new KeyListener()
		{
			
			private Random generator = new Random();

			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					Square s;
					while(true)
					{
						s = grid[generator.nextInt(5)][generator.nextInt(5)];
						if(!s.hasLanded())
							break;
					}
					
					score += s.hit();
					tries--;
					
					scoreLabel.setText("Score: "+score);
					triesLabel.setText("Tries remaining: "+tries);
					
					if(tries == 0)
					{
						JOptionPane.showMessageDialog(frame, "You got a score of "+score, "Project 9-10 - Game Over", JOptionPane.INFORMATION_MESSAGE);
						
						for(int i=0; i<5; i++)
						{
							for(int j=0; j<5; j++)
							{
								grid[i][j].reset();
							}
						}
						score = 0;
						tries = 5;
						
						scoreLabel.setText("Score: 0");
						triesLabel.setText("Tries remaining: 5");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		};
		
		JPanel gridPanel = new JPanel(new GridLayout(5, 5));
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				grid[i][j] = new Square(3-Math.max(Math.abs(2-i), Math.abs(2-j)), 50, 50);
				gridPanel.add(grid[i][j]);
			}
		}
		
		JPanel scorePanel = new JPanel(new GridBagLayout());
		scorePanel.setBackground(Color.CYAN);
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1;
		scorePanel.add(scoreLabel, c);
		c.gridx = 1;
		scorePanel.add(triesLabel, c);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(enterListener);
		frame.setFocusable(true);
		frame.requestFocus();
		Container pane = frame.getContentPane();
		pane.add(gridPanel, BorderLayout.CENTER);
		pane.add(scorePanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	private static class Square extends JPanel
	{
		private static final long serialVersionUID = 1L;
		
		private static final Color[] COLORS = {Color.WHITE, Color.YELLOW, Color.ORANGE, Color.RED};
		
		private JLabel text;
		private int num;
		private boolean landed = false;
		
		public Square(int value, int width, int height)
		{
			super(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			c.anchor = GridBagConstraints.CENTER;
			text = new JLabel(value+"");
			add(text, c);
			num = value;
			setPreferredSize(new Dimension(width, height));
			setColor();
		}
		
		public int hit()
		{
			landed = true;
			text.setText("P");
			setBackground(COLORS[0]);
			return num;
		}
		
		public boolean hasLanded()
		{
			return landed;
		}
		
		public void reset()
		{
			text.setText(num+"");
			landed = false;
			setColor();
		}
		
		private void setColor()
		{
			setBackground(COLORS[num]);
		}
	}
}
