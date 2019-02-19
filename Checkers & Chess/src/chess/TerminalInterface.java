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
			while(args.length == 0 || scan.hasNextLine())
			{
				Player next = turns.next();
				next.makeMove(b);

				if(!b.hasMoves(Color.WHITE) || !b.hasMoves(Color.BLACK))
				{
					throw new GameOverException(null);
				}
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
		
//		if(args.length > 0)
//			System.out.println(b);
		
		scan.close();
	}

}
