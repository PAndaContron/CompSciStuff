package chess;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import general.Piece;
import general.Side;
import general.Utils;

public class Queen extends ChessPiece
{
	private static final long serialVersionUID = 1L;

	public Queen(Side s, Color c)
	{
		super(s, c);
		if(c.equals(Color.WHITE))
		{
			setIcon("q");
		}
		else if(c.equals(Color.BLACK))
		{
			setIcon("Q");
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
			int[] checkPos = current;
			while(!(board[checkPos[0]][checkPos[1]] != this && board[checkPos[0]][checkPos[1]] != null))
			{
				checkPos = Utils.add(checkPos, direction);
				
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
