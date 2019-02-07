package chess;

import java.awt.Color;
import java.util.List;

import general.Board;
import general.Piece;
import general.Side;
import general.Utils;

public class ChessBoard extends Board
{
	private static final long serialVersionUID = 1L;

	public ChessBoard()
	{
		super(8, Color.BLACK, Color.WHITE);
		
		for(int i=0; i<8; i++)
		{
			board[1][i] = new Pawn(Side.TOP, Color.WHITE);
			board[6][i] = new Pawn(Side.BOTTOM, Color.BLACK);
		}
		
		board[0][0] = new Rook(Side.TOP, Color.WHITE);
		board[0][1] = new Knight(Side.TOP, Color.WHITE);
		board[0][2] = new Bishop(Side.TOP, Color.WHITE);
		board[0][3] = new Queen(Side.TOP, Color.WHITE);
		board[0][4] = new King(Side.TOP, Color.WHITE);
		board[0][5] = new Bishop(Side.TOP, Color.WHITE);
		board[0][6] = new Knight(Side.TOP, Color.WHITE);
		board[0][7] = new Rook(Side.TOP, Color.WHITE);
		
		board[7][0] = new Rook(Side.BOTTOM, Color.BLACK);
		board[7][1] = new Knight(Side.BOTTOM, Color.BLACK);
		board[7][2] = new Bishop(Side.BOTTOM, Color.BLACK);
		board[7][3] = new Queen(Side.BOTTOM, Color.BLACK);
		board[7][4] = new King(Side.BOTTOM, Color.BLACK);
		board[7][5] = new Bishop(Side.BOTTOM, Color.BLACK);
		board[7][6] = new Knight(Side.BOTTOM, Color.BLACK);
		board[7][7] = new Rook(Side.BOTTOM, Color.BLACK);
		
		updatePanels();
		
	}
	
	public void move(int[] from, int[] to)
	{
		Piece p = board[from[0]][from[1]];
		
		List<int[]> valid = p.getMoves(board, from);
		if(Utils.indexOfArray(valid, to)>-1)
		{
			super.move(from, to);
		}
		else
		{
			throw new IllegalArgumentException("Invalid move");
		}
	}
}
