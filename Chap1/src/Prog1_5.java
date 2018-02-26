//***********************************************************************************
//  Rajat Patel
//  Prog1_5
//  9/21/2016
//  Prints a diamond made from asterisks
//***********************************************************************************

public class Prog1_5 
{

	public static void main(String[] args) 
	{
		//Print the diamond
		bop("    *    ","   ***   ","  *****  "," ******* ","*********"," ******* ","  *****  ","   ***   ","    *    ");
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
