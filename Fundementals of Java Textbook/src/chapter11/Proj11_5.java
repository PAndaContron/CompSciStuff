package chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Proj11_5 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		Deck deck = new Deck();
		deck.shuffle();
		
		Player player1 = new Player(deck.deal(26));
		Player player2 = new Player(deck.deal(26));
		
		while(!(player1.isEmpty() || player2.isEmpty()))
		{
			player1.playCard();
			player2.playCard();
			System.out.println("Player 1:");
			System.out.println(player1);
			System.out.println();
			System.out.println("Player 2:");
			System.out.println(player2);
			System.out.println();
			
			int comp = player1.compareTo(player2);
			if(comp > 0)
			{
				System.out.println("Player 1 gets all the cards!");
				player1.addWinnings(player1.getWarPile());
				player1.addWinnings(player2.getWarPile());
			}
			else if(comp < 0)
			{
				System.out.println("Player 2 gets all the cards!");
				player2.addWinnings(player1.getWarPile());
				player2.addWinnings(player2.getWarPile());
			}
			
			System.out.println("Press Enter to continue.");
			scan.nextLine();
		}
		
		System.out.println("Player 1:");
		System.out.println(player1);
		System.out.println();
		System.out.println("Player 2:");
		System.out.println(player2);
		System.out.println();
		
		if(player1.score() > player2.score())
			System.out.println("Player 1 wins!");
		else if(player1.score() < player2.score())
			System.out.println("Player 2 wins!");
		else
			System.out.println("Tie!");
		
		scan.close();
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
			return String.format("%-20s%-20s%-20s", "Unplayed", "War", "Winnings") + "\n"
				+ String.format("%-20s%-20s%-20s", unplayed.size()+" Cards", topCard()==null?"":topCard(), score()+" Cards")
	;
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
