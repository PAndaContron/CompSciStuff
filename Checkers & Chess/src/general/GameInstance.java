package general;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public abstract class GameInstance
{
	protected Board board;
	protected TurnSystem turnSystem;
	protected JFrame frame;
	
	private Object game;
	private Map<Action, Method> methods;
	
	public GameInstance(Board b, TurnSystem ts, JFrame f, Object g)
	{
		board = b;
		turnSystem = ts;
		frame = f;
		game = g;
		methods = new HashMap<>();
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public TurnSystem getTurnSystem()
	{
		return turnSystem;
	}
	
	public Object getGame()
	{
		return game;
	}

	public void setAction(Action action, Method m)
	{
		methods.put(action, m);
	}
	
	public Method getMethod(Action action)
	{
		if(!methods.containsKey(action))
			return null;
		return methods.get(action);
	}
	
	abstract public int makeChoice(String prompt, Object[] choices);
	
	abstract public void message(String message, String title);
	
}
