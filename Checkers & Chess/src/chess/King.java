package chess;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import general.Piece;
import general.Side;
import general.Utils;

public class King extends ChessPiece
{
	private static final long serialVersionUID = 1L;

	public King(Side s, Color c)
	{
		super(s, c);
		if(c.equals(Color.WHITE))
		{
			setIcon("k");
		}
		else if(c.equals(Color.BLACK))
		{
			setIcon("K");
		}
	}

	public List<int[]> getMovesNoCheck(Piece[][] board, int[] current)
	{
		List<int[]> moves = new ArrayList<>();
		List<int[]> directions = new ArrayList<>();
		
		directions.addAll(getSide().getDiagonals(true));
		directions.addAll(getSide().getOrthogonals(true));
		
		for(int[] direction : directions)
		{
			int[] move = Utils.add(current, direction);
			try
			{
				if(board[move[0]][move[1]] != null && board[move[0]][move[1]].getColor().equals(getColor()))
					continue;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				continue;
			}
			
			moves.add(move);
		}
		
		return moves;
	}

}
