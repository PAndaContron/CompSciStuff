package org.djtrump.memes;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Venezuela implements Communism 
{
	private boolean isCommunist = false;
	private int[] wealth = {500, 320, 49, 620, 14325, 4, 2, 3, 5, 123, 234};
	
	public Object getFood() 
	{
		if(isCommunist)
			throw new NoSuchElementException();
		throw new IllegalStateException();
	}

	public void revolt() 
	{
		if(isCommunist)
			throw new IllegalStateException();
		isCommunist = true;
	}

	public void redistributeWealth() 
	{
		if(!isCommunist)
			throw new IllegalStateException();
		int sum = 0;
		for(int i : wealth)
			sum += i;
		int distributedWealth = sum/wealth.length;
		Arrays.fill(wealth,distributedWealth);
	}

}
