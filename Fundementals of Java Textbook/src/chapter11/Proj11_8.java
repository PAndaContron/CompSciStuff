package chapter11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Proj11_8 
{
	private static JPanel game = new JPanel(new BorderLayout());
	private static JPanel status = new JPanel();
	
	private static JLabel statusLabel = new JLabel("Click \"Play\" to start.");
	
	private static JButton play = new JButton("Play");
	private static JButton reset = new JButton("Reset");
	
	private static JFrame frame = new JFrame("Project 11-6");
	
	private static Deck deck = new Deck("Cards/", "blue");
	private static Player player1, player2;

	public static void main(String[] args) 
	{
		deck.shuffle();
		
		player1 = new Player(deck.deal(26), "Player 1");
		player2 = new Player(deck.deal(26), "Player 2");
		
		reset.setVisible(false);
		reset.setEnabled(false);
		
		game.add(player1.getPanel(), BorderLayout.NORTH);
		game.add(player2.getPanel(), BorderLayout.SOUTH);
		game.add(play, BorderLayout.CENTER);
		
		status.add(statusLabel);
		status.setBackground(Color.CYAN);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.add(reset, BorderLayout.NORTH);
		pane.add(game, BorderLayout.CENTER);
		pane.add(status, BorderLayout.SOUTH);
		frame.pack();
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.requestFocus();
		frame.setVisible(true);
		
		play.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				play.setVisible(false);
				play.setEnabled(false);
				
				reset.setVisible(true);
				reset.setEnabled(true);
				
				statusLabel.setText("<html>Press Enter to continue.<br> </html>");
				frame.pack();
				
				frame.addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent arg0) 
					{
						if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
						{
							int comp = player1.compareTo(player2);
							if(comp > 0)
							{
								statusLabel.setText("<html>Player 1 gets all the cards!<br>Press enter to continue.</html>");
								player1.addWinnings(player1.getWarPile());
								player1.addWinnings(player2.getWarPile());
							}
							else if(comp < 0)
							{
								statusLabel.setText("<html>Player 2 gets all the cards!<br>Press enter to continue.</html>");
								player2.addWinnings(player1.getWarPile());
								player2.addWinnings(player2.getWarPile());
							}
							else
							{
								if(player1.isEmpty() || player2.isEmpty())
								{
									if(player1.score() > player2.score())
										JOptionPane.showMessageDialog(frame, "Player 1 wins!", "Project 11-6 - Game Over", JOptionPane.INFORMATION_MESSAGE);
									else if(player1.score() < player2.score())
										JOptionPane.showMessageDialog(frame, "Player 2 wins!", "Project 11-6 - Game Over", JOptionPane.INFORMATION_MESSAGE);
									else
										JOptionPane.showMessageDialog(frame, "Tie!", "Project 11-6 - Game Over", JOptionPane.INFORMATION_MESSAGE);
									reset.getActionListeners()[0].actionPerformed(new ActionEvent(reset, ActionEvent.ACTION_PERFORMED, "Button pressed"));
								}
								statusLabel.setText("<html>Press Enter to continue.<br> </html>");
								
								player1.playCard();
								player2.playCard();
							}
							frame.pack();
						}
					}

					@Override
					public void keyReleased(KeyEvent arg0) {}

					@Override
					public void keyTyped(KeyEvent arg0) {}
					
				});
			}
		});
		
		reset.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				deck.reset();
				deck.shuffle();
				
				player1.reset(deck.deal(26));
				player2.reset(deck.deal(26));
				
				statusLabel.setText("<html>Press Enter to continue.<br> </html>");
				
				frame.requestFocus();
			}
		});
	}
	
	private static ImageIcon scale(ImageIcon original)
	{
		int width = original.getIconWidth()/4;
		int height = original.getIconHeight()/4;
		if(width * height == 0)
			return original;
		return new ImageIcon(
				original.getImage().getScaledInstance(width, height,
				Image.SCALE_SMOOTH));
	}

	private static class Player implements Comparable<Player>
	{
		private List<Card> unplayed = new ArrayList<>(),
				war = new ArrayList<>(),
				winnings = new ArrayList<>();
		
		private CardPanel unplayedCard = new CardPanel();
		private CardPanel warCard = new CardPanel();
		private CardPanel winningsCard = new CardPanel();
		
		private JLabel unplayedLabel = new JLabel("Unplayed: 0 Cards");
		private JLabel warLabel = new JLabel("War Pile: 0 Cards");
		private JLabel winningsLabel = new JLabel("Winnings: 0 Cards");
		private JLabel nameLabel = new JLabel();
		
		private JPanel namePanel = new JPanel();
		private JPanel cardPanel = new JPanel(new BorderLayout());
		private JPanel unplayedPanel = new JPanel(new BorderLayout());
		private JPanel warPanel = new JPanel(new BorderLayout());
		private JPanel winningsPanel = new JPanel(new BorderLayout());
		private JPanel panel = new JPanel(new BorderLayout());
		
		public Player(Card[] cards, String name)
		{
			nameLabel.setText(name);
			namePanel.add(nameLabel);
			
			unplayedPanel.add(unplayedLabel, BorderLayout.SOUTH);
			unplayedPanel.add(unplayedCard, BorderLayout.CENTER);
			
			warPanel.add(warLabel, BorderLayout.SOUTH);
			warPanel.add(warCard, BorderLayout.CENTER);
			
			winningsPanel.add(winningsLabel, BorderLayout.SOUTH);
			winningsPanel.add(winningsCard, BorderLayout.CENTER);
			
			cardPanel.add(unplayedPanel, BorderLayout.WEST);
			cardPanel.add(warPanel, BorderLayout.CENTER);
			cardPanel.add(winningsPanel, BorderLayout.EAST);
			
			panel.add(namePanel, BorderLayout.NORTH);
			panel.add(cardPanel, BorderLayout.CENTER);
			
			reset(cards);
		}
		
		public void reset(Card[] cards)
		{
			unplayed.clear();
			war.clear();
			winnings.clear();
			
			for(Card c : cards)
				unplayed.add(c);

			updateCardPanels();
		}
		
		public JPanel getPanel()
		{
			return panel;
		}
		
		public void playCard()
		{
			Card c = unplayed.remove(unplayed.size()-1);
			c.turn();
			war.add(c);
			updateCardPanels();
		}
		
		public boolean isEmpty()
		{
			return unplayed.isEmpty();
		}
		
		public Card topCard()
		{
			if(war.size() > 0)
				return war.get(war.size()-1);
			return Card.BLANK;
		}
		
		public List<Card> getWarPile()
		{
			List<Card> pile = war;
			war = new ArrayList<>();
			updateCardPanels();
			return pile;
		}
		
		public void addWinnings(List<Card> cards)
		{
			winnings.addAll(cards);
			updateCardPanels();
		}
		
		public int score()
		{
			return winnings.size();
		}
		
		@Override
		public int compareTo(Player other)
		{
			return topCard().compareTo(other.topCard());
		}
		
		@Override
		public String toString()
		{
			return "<table><tr><th>Unplayed</th><th>War</th><th>Winnings</th></tr><tr>"
				+ "<td>"+unplayed.size()+" Cards</td><td>"+(topCard()==null?"":topCard())+"</td><td>"
				+score()+" Cards</td></tr></table>";
		}
		
		private void updateCardPanels()
		{
			unplayedCard.setCard(isEmpty() ? Card.BLANK : unplayed.get(unplayed.size()-1));
			warCard.setCard(topCard());
			winningsCard.setCard(winnings.isEmpty() ? Card.BLANK : winnings.get(winnings.size()-1));
			
			unplayedLabel.setText("Unplayed: "+unplayed.size()+" Cards");
			warLabel.setText("War Pile: "+war.size()+" Cards");
			winningsLabel.setText("Winnings: "+score()+" Cards");
		}
	}
	
	private static class Deck
	{
		public static final int MAX_SIZE = 52;
		
		private static Random gen = new Random();
		
		private List<Card> cards = new ArrayList<>(), deck = new ArrayList<>();
		private String dir, color;
		
		public Deck(String imageDir, String backColor)
		{
			dir = imageDir;
			color = backColor;
			
			addSuit(Suit.CLUB, deck);
			addSuit(Suit.DIAMOND, deck);
			addSuit(Suit.HEART, deck);
			addSuit(Suit.SPADE, deck);
			
			reset();
		}
		
		public void reset()
		{
			cards.clear();
			cards.addAll(deck);
			for(Card c : cards)
				c.reset();
		}
		
		public boolean isEmpty()
		{
			return cards.isEmpty();
		}
		
		public int size()
		{
			return cards.size();
		}
		
		public Card deal()
		{
			return isEmpty() ? null : cards.remove(size()-1);
		}
		
		public Card[] deal(int number)
		{
			if(number > size())
				return null;
			Card[] hand = new Card[number];
			for (int i = 0; i < hand.length; i++) 
			{
				hand[i] = deal();
			}
			return hand;
		}
		
		public void shuffle()
		{
			if(size() < MAX_SIZE)
				return;
			
			Card[] array = new Card[MAX_SIZE];
			while(size() > 0)
			{
				int i = gen.nextInt(MAX_SIZE);
				if(array[i] == null)
					array[i] = cards.remove(size() - 1);
			}
			
			for(Card card : array)
				cards.add(card);
		}
		
		@Override
		public String toString()
		{
			String result = "Deck of Cards";
			for(Card card : cards)
				result += "\n" + card;
			return result;
		}
	
		private void addSuit(Suit suit, List<Card> list)
		{
			for(int i=2; i<=14; i++)
				list.add(new Card(suit, i, dir, color));
		}
	}

	private static class Card implements Comparable<Card>
	{
		public static final int J=11, Q=12, K=13, A=14;
		public static final Card BLANK = new BlankCard();
		
		private Suit suit;
		private int rank;
		private boolean faceUp = false;
		
		protected ImageIcon front, back;
		
		public Card(Suit suit, int rank, String imageDir, String backColor)
		{
			this.suit = suit;
			this.rank = rank;
			front = scale(new ImageIcon(imageDir+
				(rankToString().substring(0,1)+suit.toString().substring(0,1))
				.toUpperCase()+".png"));
			back = scale(new ImageIcon(imageDir+backColor+"_back.png"));
			System.out.println("Loading image "+imageDir+
				(rankToString().substring(0,1)+suit.toString().substring(0,1))
				.toUpperCase()+".png");
		}
		
		public ImageIcon getImage()
		{
			return isFaceUp() ? front : back;
		}
		
		public int getRank()
		{
			return rank;
		}
		
		public Suit getSuit()
		{
			return suit;
		}
		
		public boolean isFaceUp()
		{
			return faceUp;
		}
		
//		public boolean isRed()
//		{
//			return suit == Suit.HEART || suit == Suit.DIAMOND;
//		}
		
		public void turn()
		{
			faceUp = !faceUp;
		}
		
		public void reset()
		{
			faceUp = false;
		}
		
		@Override
		public int compareTo(Card other)
		{
			return rank - other.getRank();
		}
		
		@Override
		public boolean equals(Object other)
		{
			return other instanceof Card && rank == ((Card)other).getRank();
		}
		
		@Override
		public String toString()
		{
			return isFaceUp() ? rankToString()+" of "+getSuit() : "Card";
		}
		
		private String rankToString()
		{
			switch(rank)
			{
				case(J):
					return "Jack";
				case(Q):
					return "Queen";
				case(K):
					return "King";
				case(A):
					return "Ace";
				default:
					return ""+rank;
			}
		}
		
		private static final class BlankCard extends Card
		{
			public BlankCard()
			{
				super(Suit.CLUB, 0, "Cards/", "red");
			}
		}
	}

	private static enum Suit
	{
		CLUB, DIAMOND, HEART, SPADE;
		
		public String toString()
		{
			return super.toString().toLowerCase() + "s";
		}
	}

	private static class CardPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		private Card card;
		
		public void setCard(Card card)
		{
			this.card = card;
			ImageIcon image = card.getImage();
			setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
			repaint();
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Point p = getLocation();
			if(card != Card.BLANK)
				card.getImage().paintIcon(this, g, p.x, p.y);
		}
	}
}
