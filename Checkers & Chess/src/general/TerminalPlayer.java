package general;

import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Represents a human player playing the game through a terminal.
 */
@Name("Human Player")
public class TerminalPlayer extends Player
{
	private static final long serialVersionUID = 1L;

	/** Used to take in user input. */
	private Scanner scan;
	
	/**
	 * Creates a new TerminalPlayer.
	 * 
	 * @param name The name of this player.
	 * @param c The color of this player's pieces.
	 * @param scan A Scanner used to input moves.
	 */
	public TerminalPlayer(String name, Color c, Scanner scan)
	{
		super(name, c);
		this.scan = scan;
	}
	
	/**
	 * Takes in user input from the provided {@link Scanner} until a valid move is entered using chess coordinates, then makes the move and returns.
	 * If a move has multiple stops, each one should be entered in order after the starting position.
	 */
	public void makeMove(Board b) 
	{
		System.out.println(this+"\'s turn!");
		System.out.println(b);
		System.out.println("Enter your move:");
		
		while(true)
		{
			try
			{
				String s = scan.nextLine();
				
				//Cheats for debugging
//				if(s.equals("skip"))
//					return;
//				if(s.equals("hasMoves"))
//				{
//					System.out.println(b.hasMoves(getColor()));
//					continue;
//				}
//				if(s.startsWith("getMoves"))
//				{
//					System.out.println("Getting moves...");
//					int[] coords = Utils.parseCoord(s.toUpperCase().split("\\s")[1]);
//					Piece p = b.getPiece(coords[0], coords[1]);
//					p.getMoves(b.board, coords).forEach(move -> System.out.println(Arrays.toString(move)));
//					continue;
//				}
				
				
				int[] move = Utils.parseCoords(s);
				if(b.getPiece(move[0], move[1]).getColor().equals(getColor()))
					b.move(Arrays.copyOf(move, 2), Arrays.copyOfRange(move, 2, move.length));
				else
					throw new IllegalArgumentException("Wrong color");
				break;
			}
			//There are a multitude of exceptions which could be caused by incorrect user input, and nearly none due to
			//actual bugs, so if there is any kind of Exception thrown, it must be the user's input.
			catch(Exception e)
			{
//				e.printStackTrace();
				System.out.println("That's not a valid move!");
			}
		}
	}
	
	public int makeChoice(Board b, String prompt, Object[] choices)
	{
		System.out.printf("%s: %s%n", toString(), prompt);
		System.out.println("Enter the number of your choice: ");
		for(int i=0; i<choices.length; i++)
		{
			System.out.printf("%2d - %s%n", i+1, choices[i]);
		}
		while(true)
		{
			try
			{
				int i = Integer.parseInt(scan.nextLine().trim());
				if(i > choices.length || i <= 0)
					throw new IllegalArgumentException();
				return i-1;
			}
			catch(NumberFormatException e)
			{
				System.out.println("You must enter an integer.");
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("The number is outside of the range.");
			}
		}
	}
}
