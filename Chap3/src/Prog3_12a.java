//***********************************************************************************
//  Rajat Patel
//  Prog3_12
//  12/22/2016
//  Prints a star pyramid thingamajig.
//***********************************************************************************

public class Prog3_12a 
{

	public static void main(String[] args) 
	{
		//Output loop
		/*
		**********
		*********
		********
		*******
		******
		*****
		****
		***
		**
		*
		*/
		for (int i = 10;i > 0;i--)
		{
			for (int j = 0;j < i;j++)
				System.out.print('*');
			System.out.println();
		}
	}

}
