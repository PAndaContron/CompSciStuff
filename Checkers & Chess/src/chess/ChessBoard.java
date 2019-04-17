package chess;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import general.Board;
import general.Piece;
import general.Player;
import general.Side;
import general.Utils;

public class ChessBoard extends Board
{
	private static final long serialVersionUID = 1L;
	
	private int[][][] enPassant = new int[8][8][0];

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
			if(p instanceof Pawn)
			{
				if(Math.abs(from[0]-to[0]) == 2)
				{
					int[] mid = {(from[0]+to[0])/2, to[1]};
					enPassant[mid[0]][mid[1]] = Arrays.copyOf(to, 2);
					super.move(from, to);
					return;
				}
				else
				{
					for(int i=0; i<8; i++)
					{
						for(int j=0; j<8; j++)
						{
							if(Arrays.equals(enPassant[i][j], to))
								enPassant[i][j] = new int[0];
						}
					}
				}
			}
			super.move(from, to);
		}
		else if(p instanceof King && board[to[0]][to[1]] != null &&
				board[to[0]][to[1]] instanceof Rook &&
				board[to[0]][to[1]].getColor().equals(p.getColor()) &&
				!p.hasMoved() && !board[to[0]][to[1]].hasMoved())
		{
			Piece rook = board[to[0]][to[1]];
			int dir = to[1] > from[1] ? 1 : -1;
			for(int i=from[1]+dir; i != to[1]; i += dir)
			{
				if(board[to[0]][i] != null)
					throw new IllegalArgumentException("Invalid move");
			}
			
			int[] pos1 = {to[0], from[1]+dir};
			int[] pos2 = {to[0], pos1[1]+dir};
			
			super.move(from, pos1);
			if(inCheck(p.getColor()))
			{
				super.move(pos1, from);
				p.setMoved(false);
				throw new IllegalArgumentException("Invalid move");
			}

			super.move(pos1, pos2);
			if(inCheck(p.getColor()))
			{
				super.move(pos2, from);
				p.setMoved(false);
				throw new IllegalArgumentException("Invalid move");
			}

			super.move(to, pos1);
			if(inCheck(p.getColor()))
			{
				super.move(pos1, to);
				super.move(pos2, from);
				p.setMoved(false);
				rook.setMoved(false);
				throw new IllegalArgumentException("Invalid move");
			}
		}
		else if(p instanceof Pawn)
		{
			List<int[]> moves = new ArrayList<>();
			p.getSide().getDiagonals(false).forEach(m ->
			{
				int[] move = Utils.add(from, m);
				try
				{
					Utils.noOp(board[move[0]][move[1]]);
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					return;
				}
				moves.add(move);
			});
			
			if(Utils.indexOfArray(moves, to) > -1)
			{
				int[] capture = enPassant[to[0]][to[1]];
				if(capture != null && capture.length > 0 &&
						!board[capture[0]][capture[1]].getColor().equals(p.getColor()))
				{
					enPassant[to[0]][to[1]] = new int[0];
					super.move(from, to);
					Piece captured = board[capture[0]][capture[1]];
					board[capture[0]][capture[1]] = null;
					if(inCheck(p.getColor()))
					{
						super.move(to, from);
						enPassant[to[0]][to[1]] = capture;
						board[capture[0]][capture[1]] = captured;
						throw new IllegalArgumentException("Invalid move");
					}
				}
				else
				{
					throw new IllegalArgumentException("Invalid move");
				}
			}
			else
			{
				throw new IllegalArgumentException("Invalid move");
			}
		}
		else
		{
			throw new IllegalArgumentException("Invalid move");
		}
		
		enPassant = new int[8][8][0];
	}
	
	public boolean inCheck(Color c)
	{
		List<int[]> allMoves = new ArrayList<>();
		
		for(int i=0; i<board.length; i++)
		{
			Piece[] row = board[i];
			for(int j=0; j<row.length; j++)
			{
				Piece p = row[j];
				if(p != null && p instanceof ChessPiece && !p.getColor().equals(c))
				{
					allMoves.addAll(((ChessPiece) p).getMovesNoCheck(board, new int[] {i, j}));
				}
			}
		}
		
		for(int[] newMove : allMoves)
		{
			if(board[newMove[0]][newMove[1]] instanceof King && board[newMove[0]][newMove[1]].getColor().equals(c))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void promotePiece(Player p)
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board.length; j++)
			{
				Piece current = board[i][j];
				
				if(current == null)
					continue;
				
				if(current.getColor() != p.getColor())
					continue;
				
				if(!(current instanceof Pawn))
					continue;
				
				if(Side.getSide(new int[] {i, j}, board.length) == current.getSide().getOpposite())
				{
					int choice = p.makeChoice(this, "Promote pawn to:", new String[]
					{
						"Queen",
						"Knight",
						"Rook",
						"Bishop"
					});
					
					switch(choice)
					{
						case 0:
							board[i][j] = new Queen(current.getSide(), p.getColor());
							break;
						case 1:
							board[i][j] = new Knight(current.getSide(), p.getColor());
							break;
						case 2:
							board[i][j] = new Rook(current.getSide(), p.getColor());
							break;
						case 3:
							board[i][j] = new Bishop(current.getSide(), p.getColor());
							break;
					}
				}
			}
		}
	}
}
