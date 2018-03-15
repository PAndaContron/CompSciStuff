import java.awt.Color;
import java.awt.Dimension;

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
	private JPanel panel, panel2;
	private final int WIDTH = 300, HEIGHT = 100;
	private JTextField name;
	private JLabel nameLabel, meatLabel, veggieLabel, sauceLabel, listLabel, priceLabel;
	private JRadioButton salami, pastrami, bologna, tomato, onion, lettuce;
	private JCheckBox mayo, ranch, hot;
	private JButton order, newCustomer;
	
	public Deli()
	{
		frame = new JFrame("The Dry Deli");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		name = new JTextField(20);
		
		nameLabel = new JLabel("Name: ");
		meatLabel = new JLabel("\nMeat");
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
		
		tomato = new JRadioButton("Tomato - $3.42", true);
		tomato.setBackground(Color.cyan);
		onion = new JRadioButton("Onion - $4.82");
		onion.setBackground(Color.cyan);
		lettuce = new JRadioButton("Lettuce - $2.62");
		lettuce.setBackground(Color.cyan);
		ButtonGroup veggie = new ButtonGroup();
		veggie.add(tomato);
		veggie.add(onion);
		veggie.add(lettuce);
		
		mayo = new JCheckBox("Mayo - $0.99");
		mayo.setBackground(Color.cyan);
		ranch= new JCheckBox("Ranch - $0.99");
		ranch.setBackground(Color.cyan);
		hot = new JCheckBox("Spicy - $1.99");
		hot.setBackground(Color.cyan);
		
		panel = new JPanel();
		panel.setBackground(Color.cyan);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.add(nameLabel);
		panel.add(name);
		
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}
