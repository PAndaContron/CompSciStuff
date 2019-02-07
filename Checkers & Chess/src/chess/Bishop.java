package chess;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import general.Piece;
import general.Side;
import general.Utils;

public class Bishop extends ChessPiece
{
	private static final long serialVersionUID = 1L;

	public Bishop(Side s, Color c)
	{
		super(s, c);
		if(c.equals(Color.WHITE))
		{
			setIcon("b");
		}
		else if(c.equals(Color.BLACK))
		{
			setIcon("B");
		}
	}

	public List<int[]> getMovesNoCheck(Piece[][] board, int[] current)
	{
		List<int[]> moves = new ArrayList<>();
		List<int[]> diagonals = getSide().getDiagonals(true);
		
		for(int[] diagonal : diagonals)
		{
			int[] checkPos = current;
			while(!(board[checkPos[0]][checkPos[1]] != this && board[checkPos[0]][checkPos[1]] != null))
			{
				checkPos = Utils.add(checkPos, diagonal);
				
				try
				{
					if(board[checkPos[0]][checkPos[1]] != null && board[checkPos[0]][checkPos[1]].getColor().equals(getColor()))
						break;
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					break;
				}
				
				moves.add(checkPos);
			}
		}
		
		return moves;
	}

}
