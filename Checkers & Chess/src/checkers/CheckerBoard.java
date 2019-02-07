package checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import general.Board;
import general.Piece;
import general.Side;
import general.Utils;

/**
 * Represents a checkerboard, a black and red 8 by 8 {@link Board}.
 */
public class CheckerBoard extends Board
{
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new CheckerBoard with {@link CheckerPiece}s in their proper starting positions.
	 */
	public CheckerBoard()
	{
		super(8, Color.BLACK, Color.RED);

		for (int x = 0; x < 8; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				if ((x+y) % 2 == 0)
				{
					if (x <= 2)
						board[x][y] = new CheckerPiece(Side.TOP, Color.BLACK);
					else if (x >= 5)
						board[x][y] = new CheckerPiece(Side.BOTTOM, Color.RED);
				}
			}
		}
		
		updatePanels();
	}
	
	/**
	 * Moves the piece at <b>from</b> to <b>to</b> and performs necessary captures if the move is valid.
	 * 
	 * @param from The location of the piece to be moved.
	 * @param to The location the piece should be moved to. If the piece is doing more than one jump, the coordinates for the jumps should be put in the array directly after each other.
	 * <br>For example, <b>{2, 2, 4, 4}</b> means jump to (2, 2), then (3,3).
	 * 
	 * @throws IllegalArgumentException if the move is invalid
	 */
	public void move(int[] from, int[] to)
	{
		Piece p = board[from[0]][from[1]];
		
		//If a piece other than this one can capture, that capture must be made, making this move invalid.
		List<int[]> capturePieces = new ArrayList<>();
		for(int i=0; i<board.length; i++)
			for(int j=0; j<board.length; j++)
			{
				Piece current = board[i][j];
				if(current!=null
						&& current.getColor().equals(p.getColor())
						&& ((CheckerPiece) current).hasCaptures(board, new int[] {i, j}))
					capturePieces.add(new int[] {i, j});
			}
		if(!capturePieces.isEmpty() && Utils.indexOfArray(capturePieces, from)==-1)
			throw new IllegalArgumentException("Invalid move");
		
		//If the piece says the move is valid, move and perform captures. Otherwise, throw an exception because it is invalid.
		List<int[]> valid = p.getMoves(board, from);
		if(Utils.indexOfArray(valid, to)>-1)
		{
			List<int[]> captures = Utils.seqAverage(Utils.split(Utils.append(from, to)));
			for(int[] pos : captures)
			{
				if(board[pos[0]][pos[1]]!=null && !board[pos[0]][pos[1]].getColor().equals(p.getColor()))
				{
					board[pos[0]][pos[1]] = null;
				}
			}
			
			super.move(from, to);
			Side s = Side.getSide(to, board.length);
			if(s!=null && s.getOpposite().equals(p.getSide()))
				((CheckerPiece) p).king();
		}
		else
		{
			throw new IllegalArgumentException("Invalid move");
		}
	}
	
}
