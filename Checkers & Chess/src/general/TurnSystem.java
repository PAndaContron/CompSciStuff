package general;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages whose turn it is for any number of {@link Player}s.
 */
public class TurnSystem implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** Holds all of the players currently being managed by this object. */
	private List<Player> players = new ArrayList<>();
	/** The index in <b>players</b> of the next {@link Player} to have their turn. */
	private int index = 0;
	
	/**
	 * Creates a new TurnSystem.
	 * 
	 * @param players The players to add to this TurnSystem initially.
	 */
	public TurnSystem(Player... players)
	{
		for(Player p : players)
			this.players.add(p);
	}
	
	/**
	 * Adds another player such that they will take the next turn.
	 * 
	 * @param p The player to add.
	 */
	public void add(Player p)
	{
		players.add(index, p);
	}
	
	/**
	 * Removes a player from the TurnSystem. If the removed player would have had their turn next, the turn goes to the next player.
	 * 
	 * @param p The player to remove.
	 */
	public void remove(Player p)
	{
		int i = players.indexOf(p);
		if(i < 0)
			throw new IllegalArgumentException("Player is not in this TurnSystem.");
		players.remove(p);
		
		//Adjust index to compensate for the removed player.
		if(index > i)
			index--;
		index %= players.size();
	}
	
	/**
	 * Gets the player whose turn it is.
	 * 
	 * @return The player whose turn it is.
	 */
	public Player next()
	{
		if(players.isEmpty())
			throw new IllegalStateException("There are no Players in this TurnSystem.");
		Player next = players.get(index);
		index = (index + 1) % players.size();
		return next;
	}
}
