package checkers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import general.Board;
import general.GraphicsPlayer;
import general.Player;
import general.TurnSystem;

/**
 * Runs the game using a GUI
 * Old version, does not work with main menu
 */
public class GraphicsInterface
{
	private static JFrame game = new JFrame("Checkers");
	private static Board board = new CheckerBoard();
	
	private static JButton move = new JButton("Move");
	private static JLabel turn = new JLabel();
	
	private static Player player1 = new GraphicsPlayer("Player 1", Color.BLACK);
	private static Player player2 = new GraphicsPlayer("Player 2", Color.RED);
	
	private static TurnSystem turnSystem = new TurnSystem(player1, player2);
	private static Player currentPlayer = turnSystem.next();
	
	//Variables related to detecting stalemates
	private static int prevPieces = board.countPieces();
	private static int movesSinceCap = 0;
	private static boolean stalemate = true;

	public static void main(String[] args)
	{
		updateTurnLabel();
		
		move.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					currentPlayer.makeMove(board);
					board.clearSelections();
					
					//Victory conditions: One side loses when all its pieces are gone or can't make a valid move
					if(board.countPieces(Color.BLACK) == 0 || !board.hasMoves(Color.BLACK))
						endGame(player2);
					if(board.countPieces(Color.RED) == 0 || !board.hasMoves(Color.RED))
						endGame(player1);
					
					if(prevPieces != board.countPieces())
					{
						prevPieces = board.countPieces();
						movesSinceCap = 0;
					}
					else
					{
						movesSinceCap++;
					}
					
					//If the game has gone more than 50 turns without a capture, ask the user if they want to declare a stalemate.
					//If they say yes, end the game with a stalemate. Otherwise, never ask again.
					if(movesSinceCap > 50 && stalemate)
					{
						int response = JOptionPane.showConfirmDialog(game, "This game has been going on for quite some time with no progress."
								+"\nWould you like to declare a stalemate?", "Stalemate", JOptionPane.YES_NO_OPTION);
						if(response == JOptionPane.YES_OPTION)
							endGame(null);
						stalemate = false;
					}
					
					currentPlayer = turnSystem.next();
					updateTurnLabel();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(game, "Invalid move!", "Invalid Move", JOptionPane.ERROR_MESSAGE);
				}
				
				board.getPanel().repaint();
			}
		});
		
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		game.getContentPane().add(board.getPanel(), BorderLayout.CENTER);
		game.getContentPane().add(move, BorderLayout.SOUTH);
		game.getContentPane().add(turn, BorderLayout.NORTH);
		game.pack();
		
		game.setVisible(true);
	}

	private static void updateTurnLabel()
	{
		turn.setText(currentPlayer + "'s turn!");
	}
	
	private static void endGame(Player winner)
	{
		board.getPanel().repaint();
		JOptionPane.showMessageDialog(game, winner==null ? "Stalemate!" : winner+" wins!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
}