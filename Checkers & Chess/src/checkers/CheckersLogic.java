package checkers;

import general.Game;
import general.GameInstance;
import general.GraphicsPlayer;
import general.Name;
import general.Player;
import general.TerminalPlayer;

@Game
(
	music = "music/opus.wav",
	boardClass = CheckerBoard.class,
	colors = {0xff000000, 0xffff0000},	//Black, Red
	playersGraphics = {GraphicsPlayer.class},
	playersTerminal = {TerminalPlayer.class}
)
@Name("Checkers")
public class CheckersLogic
{
	public void init(GameInstance gameInstance)
	{
		
	}
	
	public void preMove(Player currentPlayer, GameInstance gameInstance)
	{
		
	}
	
	public void postMove(Player previousPlayer, GameInstance gameInstance)
	{
		
	}
}
