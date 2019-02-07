package chess;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import general.Piece;
import general.Side;
import general.Utils;

public class Pawn extends ChessPiece
{
	private static final long serialVersionUID = 1L;

	public Pawn(Side s, Color c)
	{
		super(s, c);
		if(c.equals(Color.WHITE))
		{
			setIcon("p");
		}
		else if(c.equals(Color.BLACK))
		{
			setIcon("P");
		}
	}

	public List<int[]> getMovesNoCheck(Piece[][] board, int[] current)
	{
		List<int[]> moves = new ArrayList<>();
		
		List<int[]> diagonals = getSide().getDiagonals(false);
		List<int[]> orthogonals = getSide().getOrthogonals(false);
		
		for(int[] diagonal : diagonals)
		{
			int[] move = Utils.add(current, diagonal);
			
			try
			{
				if(board[move[0]][move[1]] != null && !board[move[0]][move[1]].getColor().equals(getColor()))
				{
					moves.add(move);
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				continue;
			}
		}
		
		for(int[] orthogonal : orthogonals)
		{
			int[] move = Utils.add(current, orthogonal);
			
			try
			{
				if(board[move[0]][move[1]] == null)
				{
					moves.add(move);
				}
				
				int[] behind = Utils.subtract(current, orthogonal);
				if(Side.getSide(behind, board.length) == getSide())
				{
					//Double jump is possible
					move = Utils.add(move, orthogonal);
					if(board[move[0]][move[1]] == null)
					{
						moves.add(move);
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				continue;
			}
		}
		
		return moves;
	}
}
