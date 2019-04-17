package general;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * Represents a generic piece in a board game such as Chess or Checkers.
 */
public abstract class Piece implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** A single character String used to represent this piece in a terminal. */
	private String icon;
	/** The path to the {@link ImageIcon} used to represent this piece in a GUI in <b>resources/images/</b>. */
	private String imageIconPath;
	/** The color of this piece, used to identify which player it is associated with. */
	private Color color;
	/** The side of the board this piece starts on. */
	private Side side;
	
	private boolean hasMoved = false;
	
	/**
	 * Creates a new Piece with a blank icon.
	 * 
	 * @param s The side this piece starts on.
	 * @param c The color of this piece.
	 */
	public Piece(Side s, Color c)
	{
		this(s, c, " ");
	}

	/**
	 * Creates a new Piece with the specified values.
	 * 
	 * @param s The side this piece starts on.
	 * @param c The color of this piece.
	 * @param ic A one-character String used to display this piece in a terminal.
	 */
	protected Piece(Side s, Color c, String ic)
	{
		icon = ic;
		color = c;
		side = s;
	}
	
	/**
	 * Changes the icon of this Piece.
	 * 
	 * @param s A one-character String used to display this piece in a terminal.
	 */
	protected void setIcon(String s)
	{
		icon = s;
	}
	
	/**
	 * Changes the {@link ImageIcon} of this piece.
	 * 
	 * @param s The path to the {@link ImageIcon} in <b>resources/images/</b>.
	 */
	protected void setImageIcon(String s)
	{
		imageIconPath = s;
	}
	
	public void setMoved(boolean moved)
	{
		hasMoved = moved;
	}
	
	public boolean hasMoved()
	{
		return hasMoved;
	}
	
	/**
	 * Gets the color of this piece.
	 * 
	 * @return This piece's color.
	 */
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * Gets the side of the board that this piece started on.
	 * 
	 * @return This piece's side.
	 */
	public Side getSide()
	{
		return side;
	}
	
	/**
	 * Draws this piece's {@link ImageIcon} in a GUI.
	 * 
	 * @param c The component drawing this piece.
	 * @param g The graphics context used to draw this piece.
	 * @param x The x coordinate to draw this piece at.
	 * @param y The y coordinate to draw this piece at.
	 * @param width The width to scale this piece's {@link ImageIcon} to.
	 * @param height The height to scale this piece's {@link ImageIcon} to.
	 */
	public void draw(Component c, Graphics g, int x, int y, int width, int height)
	{
		ImageIcon image = Utils.scale(ImageSystem.getIcon(imageIconPath), width, height);
		image.paintIcon(c, g, x, y);
	}
	
	/**
	 * Gets this piece's icon, to be used for printing it out.
	 * 
	 * @return This piece's icon.
	 */
	public String toString()
	{
		return icon;
	}
	
	/**
	 * Finds whether or not this piece has valid moves on <b>board</b>.
	 * 
	 * @param board The board the moves should work on.
	 * @param current The position of this piece, to save time that would be used searching.
	 * 
	 * @return Whether or not there are any valid moves.
	 */
	public boolean hasMoves(Piece[][] board, int[] current)
	{
		return !getMoves(board, current).isEmpty();
	}
	
	/**
	 * Finds all valid moves for this piece on <b>board</b>.
	 * 
	 * @param board The board the moves should work on.
	 * @param current The position of this piece, to save time that would be used searching.
	 * 
	 * @return A list of all valid moves as coordinates. If there are multiple stops, each coordinate is appended to the end of the list in order.
	 */
	abstract public List<int[]> getMoves(Piece[][] board, int[] current);
}
