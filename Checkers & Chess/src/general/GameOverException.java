package general;

/**
 * Thrown when the game ends to exit the loop. The <b>detailMessage</b> should contain the reason why the game ended.
 */
public class GameOverException extends Exception
{
	/** This class is probably never going to be serialized, but Eclipse made me add this anyway. */
	private static final long serialVersionUID = 1258705957863889299L;
	
	/** The player who won the game, null if it is a stalemate. */
	private Player winner;
	
	/**
	 * Creates the exception with a reason why the game ended.
	 * 
	 * @param p The player who won, or null for a stalemate.
	 */
	public GameOverException(Player p)
	{
		super(p == null ? "Stalemate" : p.toString());
		winner = p;
	}
	
	/**
	 * Gets the player who won the game.
	 * 
	 * @return The player who won the game, or null if it is a stalemate.
	 */
	public Player getWinner()
	{
		return winner;
	}
}
