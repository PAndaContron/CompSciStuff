import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Deli 
{
	private JFrame frame;
	private JPanel panel;
	private final int WIDTH = 300, HEIGHT = 100;
	private JTextField name;
	private JLabel nameLabel, meatLabel, veggieLabel, sauceLabel, listLabel, priceLabel;
	private JRadioButton salami, pastrami, bologna, tomato, onion, lettuce;
	private JCheckBox mayo, ranch, hot;
	private JButton order, newCustomer;
	
	public Deli()
	{
		frame = new JFrame("Deli");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		nameLabel = new JLabel("Name: ");
		meatLabel = new JLabel("Meat");
		veggieLabel = new JLabel("Vegetables");
		sauceLabel = new JLabel("Sauces");
		listLabel = new JLabel("");
		priceLabel = new JLabel("$0.00");
		
		salami = new JRadioButton("Salami - $4.98", true);
		salami.setBackground(Color.cyan);
		pastrami = new JRadioButton("Pastrami - $5.98");
		pastrami.setBackground(Color.cyan);
		bologna = new JRadioButton("Bologna - $3.98");
		bologna.setBackground(Color.cyan);
		ButtonGroup meat = new ButtonGroup();
		meat.add(salami);
		meat.add(pastrami);
		meat.add(bologna);
		
		salami = new JRadioButton("Salami - $4.98", true);
		salami.setBackground(Color.cyan);
		pastrami = new JRadioButton("Pastrami - $5.98");
		pastrami.setBackground(Color.cyan);
		bologna = new JRadioButton("Bologna - $3.98");
		bologna.setBackground(Color.cyan);
		ButtonGroup veggie = new ButtonGroup();
		veggie.add(tomato);
		veggie.add(onion);
		veggie.add(lettuce);
	}
}
