package general;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GraphicsGameInstance extends GameInstance {

	public GraphicsGameInstance(Board b, TurnSystem ts, JFrame f, Object g)
	{
		super(b, ts, f, g);
	}

	public int makeChoice(String prompt, Object[] choices)
	{
		Object choice = JOptionPane.showInputDialog(frame, prompt, "All Players: Decision", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		return Utils.arrayIndexOf(choices, choice);
	}

	public void message(String message, String title)
	{
		JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

}
