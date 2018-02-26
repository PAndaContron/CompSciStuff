//***********************************************************************************
//  Rajat Patel
//  Prog4_6
//  3/20/2017
//  Flips a coin 37x, locking every 10th time and unlocking every other 5th time
//***********************************************************************************

public class Prog5_6 
{

	public static void main(String[] args) 
	{
		//Constant for key
		final int KEY = 420;
		
		//Counters
		int heads = 0,tails = 0,locks = 0;
		
		//Initialize the coin
		Coin coin = new Coin();
		coin.setKey(KEY);
		
		//Flip the coin 37x
		for(int i = 1;i<=37;i++)
		{
			//Flip the coin
			coin.flip();
			System.out.println(coin);
			
			//Increment counters
			if(coin.locked())
				locks++;
			else
				if(coin.isHeads())
					heads++;
				else
					tails++;
			
			//If the step is divisible by 10
			if(i%10==0)
				coin.lock(KEY);
			else
				if(i%5==0)	//If the step is divisible by 5
					coin.unlock(KEY);
		}
		
		//Print out the counters
		System.out.println("Heads: "+heads+"\tTails: "+tails+"\tLocked: "+locks);
	}

}
