package general;

import java.awt.Color;
import java.lang.reflect.Constructor;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PlayGameGraphics
{

	public static void main(String[] args)
	{
		Set<Class<? extends Object>> games = Utils.getClassesWith(Game.class);
		System.out.println(games);
		
		
	}
	
	private static GraphicsGameInstance getGameInstance(JFrame frame, Class<? extends Object> gameClass)
	{
		try
		{
			Game gameAnnotation = gameClass.getAnnotation(Game.class);
			
			
			Class<? extends Board> boardClass = gameAnnotation.boardClass();
			Constructor<? extends Board> boardConst = boardClass.getConstructor();
			Board board = boardConst.newInstance();
			
			
			
			Name nameAnnotation = gameClass.getAnnotation(Name.class);
			frame.setName(nameAnnotation.value());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getStackTrace(), e.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		return null;
	}
	
	private static TurnSystem selectPlayers(JFrame frame, int[] intColors)
	{
		Color[] colors = new Color[intColors.length];
//		Color color = new Color(, false)
		return null;
	}

}
