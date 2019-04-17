package chess;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import general.Board;
import general.GameOverException;
import general.Player;
import general.TerminalPlayer;
import general.TurnSystem;

public class TerminalInterface
{

	public static void main(String... args)
	{
		Scanner scan = new Scanner(System.in);
		try
		{
			scan = new Scanner(new File(args[0]));
		}
		catch(FileNotFoundException | ArrayIndexOutOfBoundsException e){}
		
		Player p1 = new TerminalPlayer("Player 1", Color.WHITE, scan);
		Player p2 = new TerminalPlayer("Player 2", Color.BLACK, scan);
		TurnSystem turns = new TurnSystem(p1, p2);
		
		Board b = new ChessBoard();
		
		try
		{
			while(true)
			{
				Player next = turns.next();
				
				if(!b.hasMoves(next.getColor()))
				{
					if(((ChessBoard)b).inCheck(next.getColor()))
						throw new GameOverException(turns.next());
					throw new GameOverException(null);
				}
				
				if(((ChessBoard)b).inCheck(next.getColor()))
					System.out.println(next + " is in check!");
				
				next.makeMove(b);
				
				((ChessBoard)b).promotePiece(next);
			}
		}
		catch(GameOverException e)
		{
			System.out.println(b);
			if(e.getWinner() == null)
				System.out.println("Stalemate!");
			else
				System.out.printf("Checkmate - %s wins!%n",e.getWinner());
		}
		
		scan.close();
	}

}
