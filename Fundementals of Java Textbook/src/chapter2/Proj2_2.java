package chapter2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Proj2_2 
{

	public static void main(String[] args) 
	{
		final int WIDTH = 200;
		final int HEIGHT = 250;
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setBackground(Color.YELLOW);
		panel.add(new JLabel("                             *                             "));
		panel.add(new JLabel("                          *     *                          "));
		panel.add(new JLabel("                       *           *                       "));
		panel.add(new JLabel("                    *                 *                    "));
		panel.add(new JLabel("                 *                       *                 "));
		panel.add(new JLabel("              *                             *              "));
		panel.add(new JLabel("           *            YIELD            *           "));
		panel.add(new JLabel("        *                                         *        "));
		panel.add(new JLabel("     *                                               *     "));
		panel.add(new JLabel("  *                                                     *  "));
		panel.add(new JLabel("*************************************"));
		
		JFrame frame = new JFrame("Project 2-2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
