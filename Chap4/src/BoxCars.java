//***********************************************************************************
//  Rajat Patel
//  BoxCars
//  2/8/2017
//  Rolls two dice 1000 times, counting the number of double 6's
//***********************************************************************************

public class BoxCars 
{

	public static void main(String[] args) 
	{
		//Variables
		int count = 0;
		PairOfDice dice = new PairOfDice();
		
		//Main Loop
		for(int i = 0;i < 1000;i++)
		{
			dice.roll();
			if (dice.getFace1()+dice.getFace2() == 12)
				count++;
		}
		
		//Output
		System.out.println("Number of Boxcars: "+count);
	}

}
