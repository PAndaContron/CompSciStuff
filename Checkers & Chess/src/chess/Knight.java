package chess;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import general.Piece;
import general.Side;
import general.Utils;

public class Knight extends ChessPiece
{
	private static final long serialVersionUID = 1L;
	
	private static final int[][] PATTERN = 
	{
			{1, 2},
			{1, -2},
			{-1, 2},
			{-1, -2},
			{2, 1},
			{2, -1},
			{-2, 1},
			{-2, -1},
	};

	public Knight(Side s, Color c)
	{
		super(s, c);
		if(c.equals(Color.WHITE))
		{
			setIcon("n");
		}
		else if(c.equals(Color.BLACK))
		{
			setIcon("N");
		}
	}

	public List<int[]> getMovesNoCheck(Piece[][] board, int[] current)
	{
		List<int[]> moves = new ArrayList<>();
		
		for(int[] possibleMove : PATTERN)
		{
			int[] move = Utils.add(current, possibleMove);
			
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
