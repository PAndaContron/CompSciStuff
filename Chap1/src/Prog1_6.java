//***********************************************************************************
//  Rajat Patel
//  Prog1_6
//  9/21/2016
//  Prints my initials in block letters
//***********************************************************************************

public class Prog1_6 
{

	public static void main(String[] args) 
	{
		// Print "RP" in 9 tall block letters.
		/*
		RRRRRRRRRRRRRRR       PPPPPPPPPPPPPPP
		RRRRRRRRRRRRRRRR      PPPPPPPPPPPPPPPP
		RRRRR       RRRRR     PPPPP       PPPPP
		RRRRR       RRRR      PPPPP       PPPP
		RRRRRRRRRRRRRRR       PPPPPPPPPPPPPPP
		RRRRRRRRRRRRRR        PPPPPPPPPPPPPP
		RRRRR    RRRRR        PPPPP
		RRRRR     RRRRR       PPPPP
		RRRRR      RRRRR      PPPPP
		*/
		bop("RRRRRRRRRRRRRRR       PPPPPPPPPPPPPPP","RRRRRRRRRRRRRRRR      PPPPPPPPPPPPPPPP","RRRRR       RRRRR     PPPPP       PPPPP","RRRRR       RRRR      PPPPP       PPPP","RRRRRRRRRRRRRRR       PPPPPPPPPPPPPPP","RRRRRRRRRRRRRR        PPPPPPPPPPPPPP","RRRRR    RRRRR        PPPPP","RRRRR     RRRRR       PPPPP","RRRRR      RRRRR      PPPPP");
	}
	public static void bop(String line1,String line2,String line3,String line4,String line5,String line6,String line7,String line8,String line9)
	{
		sop(line1);
		sop(line2);
		sop(line3);
		sop(line4);
		sop(line5);
		sop(line6);
		sop(line7);
		sop(line8);
		sop(line9);
	}
	public static void sop(String str)
	{
		System.out.println(str);
	}
}