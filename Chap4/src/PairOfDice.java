//***********************************************************************************
//  Rajat Patel
//  PairOfDice
//  2/7/2017
//  Rolls two dice
//***********************************************************************************

public class PairOfDice 
{
	private Die die1,die2;
	
	public PairOfDice()
	{
		die1 = new Die();
		die2 = new Die();
	}
	
	public void roll()
	{
		die1.roll();
		die2.roll();
	}
	
	public int getFace1()
	{
		return die1.getFaceValue();
	}
	
	
	public int getFace2()
	{
		return die2.getFaceValue();
	}
}
