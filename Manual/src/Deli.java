import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Deli 
{
	private JFrame frame;
	private JPanel panel;
	private final int WIDTH = 400, HEIGHT = 300;
	private JTextField name;
	private JLabel nameLabel, meatLabel, veggieLabel, sauceLabel, priceLabel;
	private JRadioButton salami, pastrami, bologna, tomato, onion, lettuce;
	private JCheckBox mayo, ranch, hot;
	private JButton order, newCustomer;
	
	PriceListener listener = new PriceListener();
	
	public Deli()
	{
		frame = new JFrame("The Dry Deli");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		name = new JTextField(20);
		
		nameLabel = new JLabel("Name: ");
		meatLabel = new JLabel("Meat");
		veggieLabel = new JLabel("Vegetables");
		sauceLabel = new JLabel("Sauces");
		priceLabel = new JLabel("TOTAL: $0.00");
		
		salami = new JRadioButton("Salami - $4.98", true);
		salami.setBackground(Color.cyan);
		salami.setToolTipText("$4.98");
		salami.addActionListener(listener);
		pastrami = new JRadioButton("Pastrami - $5.98");
		pastrami.setBackground(Color.cyan);
		pastrami.setToolTipText("$5.98");
		pastrami.addActionListener(listener);
		bologna = new JRadioButton("Bologna - $3.98");
		bologna.setBackground(Color.cyan);
		bologna.setToolTipText("$3.98");
		bologna.addActionListener(listener);
		ButtonGroup meat = new ButtonGroup();
		meat.add(salami);
		meat.add(pastrami);
		meat.add(bologna);
		
		tomato = new JRadioButton("Tomato - $3.42", true);
		tomato.setBackground(Color.cyan);
		tomato.setToolTipText("$3.42");
		tomato.addActionListener(listener);
		onion = new JRadioButton("Onion - $4.82");
		onion.setBackground(Color.cyan);
		onion.setToolTipText("$4.82");
		onion.addActionListener(listener);
		lettuce = new JRadioButton("Lettuce - $2.62");
		lettuce.setBackground(Color.cyan);
		lettuce.setToolTipText("$2.62");
		lettuce.addActionListener(listener);
		ButtonGroup veggie = new ButtonGroup();
		veggie.add(tomato);
		veggie.add(onion);
		veggie.add(lettuce);
		
		mayo = new JCheckBox("Mayo - $0.99");
		mayo.setBackground(Color.cyan);
		mayo.setToolTipText("$0.99");
		mayo.addItemListener(listener);
		ranch= new JCheckBox("Ranch - $0.99");
		ranch.setBackground(Color.cyan);
		ranch.setToolTipText("$0.99");
		ranch.addItemListener(listener);
		hot = new JCheckBox("Spicy - $1.99");
		hot.setBackground(Color.cyan);
		hot.setToolTipText("$1.99");
		hot.addItemListener(listener);
		
		order = new JButton("Order");
		order.setToolTipText("Finalize your order");
		order.addActionListener(new OrderListener());
		newCustomer = new JButton("New Customer");
		newCustomer.setToolTipText("Start a new order");
		newCustomer.addActionListener(new ResetListener());
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.cyan);
		namePanel.add(nameLabel);
		namePanel.add(name);
		
		JPanel meatTitlePanel = new JPanel();
		meatTitlePanel.setBackground(Color.cyan);
		meatTitlePanel.add(meatLabel);
		
		JPanel meatPanel = new JPanel();
		meatPanel.setBackground(Color.cyan);
		meatPanel.add(salami);
		meatPanel.add(pastrami);
		meatPanel.add(bologna);
		
		JPanel veggieTitlePanel = new JPanel();
		veggieTitlePanel.setBackground(Color.cyan);
		veggieTitlePanel.add(veggieLabel);
		
		JPanel veggiePanel = new JPanel();
		veggiePanel.setBackground(Color.cyan);
		veggiePanel.add(tomato);
		veggiePanel.add(onion);
		veggiePanel.add(lettuce);
		
		JPanel sauceTitlePanel = new JPanel();
		sauceTitlePanel.setBackground(Color.cyan);
		sauceTitlePanel.add(sauceLabel);
		
		JPanel saucePanel = new JPanel();
		saucePanel.setBackground(Color.cyan);
		saucePanel.add(mayo);
		saucePanel.add(ranch);
		saucePanel.add(hot);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.cyan);
		buttonPanel.add(order);
		buttonPanel.add(newCustomer);
		
		JPanel pricePanel = new JPanel();
		pricePanel.setBackground(Color.cyan);
		pricePanel.add(priceLabel);

		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;
		
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.cyan);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.add(namePanel, grid);
		grid.gridy++;
		panel.add(meatTitlePanel, grid);
		grid.gridy++;
		panel.add(meatPanel, grid);
		grid.gridy++;
		panel.add(veggieTitlePanel, grid);
		grid.gridy++;
		panel.add(veggiePanel, grid);
		grid.gridy++;
		panel.add(sauceTitlePanel, grid);
		grid.gridy++;
		panel.add(saucePanel, grid);
		grid.gridy++;
		panel.add(buttonPanel, grid);
		grid.gridy++;
		panel.add(pricePanel, grid);
		
		frame.getContentPane().add(panel);
		
		listener.calculatePrice();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void reset()
	{
		name.setText("");
		salami.setSelected(true);
		tomato.setSelected(true);
		mayo.setSelected(false);
		ranch.setSelected(false);
		hot.setSelected(false);
		
		listener.calculatePrice();
	}
	
	private class PriceListener implements ActionListener, ItemListener
	{
		public void itemStateChanged(ItemEvent e) 
		{
			calculatePrice();
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			calculatePrice();
		}
		
		public void calculatePrice()
		{
			int price = 0;
			
			if(salami.isSelected())
				price += 498;
			else if(pastrami.isSelected())
				price += 598;
			else
				price += 398;
			
			if(tomato.isSelected())
				price += 342;
			else if(onion.isSelected())
				price += 482;
			else
				price += 262;
			
			if(mayo.isSelected())
				price += 99;
			if(ranch.isSelected())
				price += 99;
			if(hot.isSelected())
				price += 199;
			
			priceLabel.setText("TOTAL: $"+(price/100)+"."+(price%100));
		}
	}
	
	private class OrderListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(name.getText().equals(""))
			{
				JOptionPane.showMessageDialog(frame, "Please enter your name.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String listString = "";
			
			if(salami.isSelected())
				listString += salami.getText()+"\n";
			else if(pastrami.isSelected())
				listString += pastrami.getText()+"\n";
			else
				listString += bologna.getText()+"\n";
			
			if(tomato.isSelected())
				listString += tomato.getText()+"\n";
			else if(onion.isSelected())
				listString += onion.getText()+"\n";
			else
				listString += lettuce.getText()+"\n";
			
			if(mayo.isSelected())
				listString += mayo.getText()+"\n";
			if(ranch.isSelected())
				listString += ranch.getText()+"\n";
			if(hot.isSelected())
				listString += hot.getText()+"\n";
			
			listString += priceLabel.getText();
			
			JOptionPane.showMessageDialog(frame, listString, name.getText()+"'s Order", JOptionPane.INFORMATION_MESSAGE);
			
			reset();
		}
	}
	
	private class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(JOptionPane.showConfirmDialog(frame, "Are you sure you want to discard your current order?", "New Order", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)
					== JOptionPane.YES_OPTION)
				reset();
		}
	}
}
