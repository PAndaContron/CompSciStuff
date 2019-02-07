package general;

import java.awt.Color;
import java.io.Serializable;

/**
 * Represents a player, who can make moves on a {@link Board}.
 */
@Name
public abstract class Player implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** A name used to identify this player in the interface. */
	private String name;
	/** The color of this player's pieces, used to validate moves. */
	private Color c;
	
	/**
	 * Creates a new Player with the specified parameters.
	 * 
	 * @param name A name used to identify this player in the interface.
	 * @param c The color of this player's pieces, used to validate moves.
	 */
	public Player(String name, Color c)
	{
		this.name = name;
		this.c = c;
	}
	
	/**
	 * Gets the color of this player's pieces, used to validate moves.
	 * 
	 * @return This player's color.
	 */
	public Color getColor()
	{
		return c;
	}
	
	/**
	 * Gets the name of this player.
	 * 
	 * @return This player's name.
	 */
	public String toString()
	{
		return name;
	}
	
	/**
	 * Moves a <b>Piece</b>.
	 * 
	 * @param b The board which the game is being played on.
	 */
	abstract public void makeMove(Board b);
	
	/**
	 * Makes a choice about something
	 * 
	 * @param b The board which the game is being played on, needed for AI players.
	 * @param prompt The question to ask the player
	 * @param choices The possible choices
	 * 
	 * @return The index of the choice the player made
	 */
	abstract public int makeChoice(Board b, String prompt, Object[] choices);
}
