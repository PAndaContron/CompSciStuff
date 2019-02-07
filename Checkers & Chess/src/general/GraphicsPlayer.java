package general;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * Represents a player interacting with the game through a GUI.
 */
@Name("Human Player")
public class GraphicsPlayer extends Player
{
	private static final long serialVersionUID = 1L;

	public GraphicsPlayer(String name, Color c)
	{
		super(name, c);
	}
	
	public void makeMove(Board b)
	{
		int[] move = Utils.join(b.getSelections());
		if(b.getPiece(move[0], move[1]).getColor().equals(getColor()))
			b.move(Arrays.copyOf(move, 2), Arrays.copyOfRange(move, 2, move.length));
		else
			throw new IllegalArgumentException("Wrong color");
	}
	
	public int makeChoice(Board b, String prompt, Object[] choices)
	{
		Object choice = JOptionPane.showInputDialog(null, prompt, this+": Decision", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		return Utils.arrayIndexOf(choices, choice);
	}
}
