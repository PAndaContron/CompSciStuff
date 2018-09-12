package chapter11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Proj11_6 
{
	private static JPanel game = new JPanel(new BorderLayout());
	private static JPanel status = new JPanel();
	
	private static JLabel p1Label = new JLabel("");
	private static JLabel p2Label = new JLabel("");
	private static JLabel statusLabel = new JLabel("Click \"Play\" to start.");
	
	private static JButton play = new JButton("Play");
	private static JButton reset = new JButton("Reset");
	
	private static JFrame frame = new JFrame("Project 11-6");
	
	private static Deck deck = new Deck();
	private static Player player1, player2;

	public static void main(String[] args) 
	{
		deck.shuffle();
		
		player1 = new Player(deck.deal(26));
		player2 = new Player(deck.deal(26));
		
		reset.setVisible(false);
		reset.setEnabled(false);
		
		game.add(p1Label, BorderLayout.NORTH);
		game.add(p2Label, BorderLayout.SOUTH);
		game.add(play, BorderLayout.CENTER);
		game.setBackground(Color.YELLOW);
		
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
				
				statusLabel.setText("Press Enter to continue.");
				updatePlayerLabels();
				
				frame.addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent arg0) 
					{
						if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
						{
							if(player1.isEmpty() || player2.isEmpty())
							{
								updatePlayerLabels();
								
								if(player1.score() > player2.score())
									JOptionPane.showMessageDialog(frame, "Player 1 wins!", "Project 11-6 - Game Over", JOptionPane.INFORMATION_MESSAGE);
								else if(player1.score() < player2.score())
									JOptionPane.showMessageDialog(frame, "Player 2 wins!", "Project 11-6 - Game Over", JOptionPane.INFORMATION_MESSAGE);
								else
									JOptionPane.showMessageDialog(frame, "Tie!", "Project 11-6 - Game Over", JOptionPane.INFORMATION_MESSAGE);
								reset.getActionListeners()[0].actionPerformed(new ActionEvent(reset, ActionEvent.ACTION_PERFORMED, "Button pressed"));
							}
							
							player1.playCard();
							player2.playCard();
							updatePlayerLabels();
							
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
				deck = new Deck();
				deck.shuffle();
				
				player1 = new Player(deck.deal(26));
				player2 = new Player(deck.deal(26));
				
				statusLabel.setText("Press Enter to continue.");
				updatePlayerLabels();
				
				frame.requestFocus();
			}
		});
	}
	
	private static void updatePlayerLabels()
	{
		p1Label.setText("<html><strong>Player 1:</strong><br>"+player1+"</html>");
		p2Label.setText("<html><strong>Player 2:</strong><br>"+player2+"</html>");
		frame.pack();
	}
	
	private static class Player implements Comparable<Player>
	{
		private List<Card> unplayed = new ArrayList<>(),
				war = new ArrayList<>(),
				winnings = new ArrayList<>();
		
		public Player(Card[] cards)
		{
			for(Card c : cards)
				unplayed.add(c);
		}
		
		public void playCard()
		{
			Card c = unplayed.remove(unplayed.size()-1);
			c.turn();
			war.add(c);
		}
		
		public boolean isEmpty()
		{
			return unplayed.isEmpty();
		}
		
		public Card topCard()
		{
			if(war.size() > 0)
				return war.get(war.size()-1);
			return null;
		}
		
		public List<Card> getWarPile()
		{
			List<Card> pile = war;
			war = new ArrayList<>();
			return pile;
		}
		
		public void addWinnings(List<Card> cards)
		{
			winnings.addAll(cards);
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
	}
	
	private static class Deck
	{
		public static final int MAX_SIZE = 52;
		
		private static Random gen = new Random();
		
		private List<Card> cards;
		
		public Deck()
		{
			reset();
		}
		
		public void reset()
		{
			cards = new ArrayList<>();
			addSuit(Suit.CLUB);
			addSuit(Suit.DIAMOND);
			addSuit(Suit.HEART);
			addSuit(Suit.SPADE);
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

		private void addSuit(Suit suit)
		{
			for(int i=2; i<=14; i++)
				cards.add(new Card(suit, i));
		}
	}
	
	private static class Card implements Comparable<Card>
	{
		public static final int J=11, Q=12, K=13, A=14;
		
		private Suit suit;
		private int rank;
		private boolean faceUp = false;
		
		public Card(Suit suit, int rank)
		{
			this.suit = suit;
			this.rank = rank;
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
	}
	
	private static enum Suit
	{
		CLUB, DIAMOND, HEART, SPADE;
		
		public String toString()
		{
			return super.toString().toLowerCase() + "s";
		}
	}
}
