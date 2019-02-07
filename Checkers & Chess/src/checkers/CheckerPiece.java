package checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import general.Piece;
import general.Side;
import general.Utils;

/**
 *	Represents a checker, with a {@link Side} of the board and a piece {@link Color}.
 */
public class CheckerPiece extends Piece
{
	private static final long serialVersionUID = 1L;

	/** Stores whether or not this piece is a King. */
	private boolean isKing;
	
	/**
	 * Creates a new Checker and sets the icon and {@link ImageIcon} appropriately.
	 * 
	 * @param s The {@link Side} of the board this piece is on.
	 * @param c The {@link Color} of the piece. Currently supported colors are: <ul>
	 * 	<li>Black</li>
	 * 	<li>Red</li>
	 * </ul>
	 */
	public CheckerPiece(Side s, Color c)
	{
		super(s, c);
		if(c.equals(Color.RED))
		{
//			setIcon("\u25E6");
			setIcon("O");
			setImageIcon("checkers/redPiece.png");
		}
		else if(c.equals(Color.BLACK))
		{
			setIcon("\u2022");
			setImageIcon("checkers/blackPiece.png");
		}
	}
	
	
	/**
	 * Changes this piece to a king, updating the icon and {@link ImageIcon} appropriately.
	 */
	public void king()
	{
		isKing = true;
		if(getColor().equals(Color.RED))
		{
//			setIcon("\uD835\uDD42");
			setIcon("R");
			setImageIcon("checkers/redKing.png");
		}
		else if(getColor().equals(Color.BLACK))
		{
			setIcon("K");
			setImageIcon("checkers/blackKing.png");
		}
	}
	
	/**
	 * Finds all valid moves for this piece on <b>board</b>.
	 * <br>
	 * A checker can move diagonally forward (away from the {@link Side} it started out on) if there is nothing blocking its path.
	 * If it is a king, it can move diagonally in all directions. However, if there is a piece of the opposite {@link Color} blocking its path in any direction,
	 * then it must be jumped over and captured. If any more pieces can be jumped over from there, they must be jumped over as well.
	 * 
	 * @throws IllegalArgumentException if this piece is not at <b>current</b>
	 */
	public List<int[]> getMoves(Piece[][] board, int[] current) 
	{
		if(board[current[0]][current[1]] != this)
				throw new IllegalArgumentException();
		
		//Gets the diagonals for this piece depending on where it started and if it's a king
		List<int[]> curDiagonals = getSide().getDiagonals(isKing);
		
		//If this piece can capture another piece, it must.
		List<int[]> captures = getCaptures(board, current);
		if(!captures.isEmpty())
			return captures;

		//Otherwise, the valid moves are regular diagonals.
		List<int[]> validMoves = new ArrayList<>();
		for(int[] diag : curDiagonals)
		{
			try
			{
				int[] coords = Utils.add(current, diag);
				if(board[coords[0]][coords[1]] == null)
					validMoves.add(coords);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				//Continue on with the loop
			}
		}
		
//		System.out.println("Valid Moves:");
//		for(int[] move : validMoves)
//		{
//			System.out.println(Arrays.toString(move));
//		}
		return validMoves;
	}
	
	/**
	 * Checks if this piece can capture any pieces.
	 * 
	 * @param board The board the move should work on.
	 * @param current The position of this piece, to save time that would be used searching.
	 * 
	 * @return Whether or not this piece can make any captures.
	 */
	public boolean hasCaptures(Piece[][] board, int[] current)
	{
		return !getCaptures(board, current).isEmpty();
	}
	
	/**
	 * Finds all valid moves for the piece at <b>current</b> on <b>board</b> where a piece is captured.
	 * 
	 * @param board The board the move should work on.
	 * @param current The position of the piece to be tested. For this method, it does not have to be the current piece.
	 * This is done so that it can be called recursively to test for multiple jumps.
	 * 
	 * @return A list of all moves where a piece is captured as coordinates. If there are multiple jumps, each coordinate is appended to the end of the list in order.
	 */
	private List<int[]> getCaptures(Piece[][] board, int[] current)
	{
		List<int[]> captures = new ArrayList<>();
		
		List<int[]> curDiagonals = getSide().getDiagonals(isKing);
		
		//Test each diagonal this piece can move along for captures
		for(int[] diag : curDiagonals)
		{
			try
			{
				int[] coords = Utils.add(current, diag);
				int[] nextCoords = Utils.add(coords, diag);
				Piece p = board[coords[0]][coords[1]];
				Piece next = board[nextCoords[0]][nextCoords[1]];
				
				//Checks for a piece on this diagonal that can be captured
				if(p != null && !p.getColor().equals(getColor()) && next == null)
				{
					//If there is a capture, temporarily remove the captured piece and call this method recursively to test for more
					board[coords[0]][coords[1]] = null;
					List<int[]> doubles = getCaptures(board, nextCoords);
					board[coords[0]][coords[1]] = p;
					
					//If a double jump is possible it must be done, so only add the single moves if there are none.
					if(doubles.isEmpty())
						captures.add(nextCoords);
					//Otherwise, return the current jump plus all of the additional jumps that can be made.
					else
					{
						for(int i=0; i<doubles.size(); i++)
							doubles.set(i, Utils.append(nextCoords, doubles.get(i)));
						captures.addAll(doubles);
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				//Continue on with the loop
			}
		}
		
		return captures;
	}
}
