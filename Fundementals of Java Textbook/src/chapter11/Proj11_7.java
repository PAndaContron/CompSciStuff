package chapter11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Proj11_7 
{
	private static Deck deck;
	
	private static CardPanel card = new CardPanel();
	private static JPanel controls = new JPanel(new BorderLayout());
	
	private static JButton deal = new JButton("Deal");
	private static JButton flip = new JButton("Flip");
	private static JButton reset = new JButton("Reset");
	
	private static JFrame frame = new JFrame("Project 11-7");

	public static void main(String[] args) 
	{
		reset();
		
		controls.add(deal, BorderLayout.WEST);
		controls.add(flip, BorderLayout.CENTER);
		controls.add(reset, BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.add(card, BorderLayout.CENTER);
		pane.add(controls, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		
		deal.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(deck.isEmpty())
				{
					JOptionPane.showMessageDialog(frame, "Deck finished!", "Project 11-7", JOptionPane.INFORMATION_MESSAGE);
					reset();
				}
				else
					card.setCard(deck.deal());
				card.repaint();
			}
		});
		
		flip.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				card.getCard().turn();
				card.repaint();
			}
		});
		
		reset.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				reset();
				card.repaint();
			}
		});
	}
	
	private static void reset()
	{
		deck = new Deck("Cards/", "red");
		deck.shuffle();
		card.setCard(deck.deal());;
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

	@SuppressWarnings("unused")
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
			return String.format("%-20s%-20s%-20s", "Unplayed", "War", "Winnings") + "\n"
				+ String.format("%-20s%-20s%-20s", unplayed.size()+" Cards", topCard()==null?"":topCard(), score()+" Cards");
		}
	}

	private static class Deck
	{
		public static final int MAX_SIZE = 52;
		
		private static Random gen = new Random();
		
		private List<Card> cards;
		
		private String dir, color;
		
		public Deck(String imageDir, String backColor)
		{
			dir = imageDir;
			color = backColor;
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
		
		@SuppressWarnings("unused")
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
				cards.add(new Card(suit, i, dir, color));
		}
	}

	private static class Card implements Comparable<Card>
	{
		public static final int J=11, Q=12, K=13, A=14;
		
		private Suit suit;
		private int rank;
		private boolean faceUp = false;
		
		private ImageIcon front, back;
		
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
	
	private static class CardPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		private Card card;
		
		public void setCard(Card card)
		{
			this.card = card;
			ImageIcon image = card.getImage();
			setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
		}
		
		public Card getCard()
		{
			return card;
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Point p = getLocation();
			card.getImage().paintIcon(this, g, p.x, p.y);
		}
	}

}
