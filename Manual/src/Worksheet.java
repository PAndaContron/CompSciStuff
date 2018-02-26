//***********************************************************************************
//  Rajat Patel
//  Worksheet
//  10/28/2016
//  For checking the worksheet.
//***********************************************************************************

public class Worksheet 
{

	public static void main(String[] args) 
	{
		//Create Strings
		String one = "abcdefghijklm",two = "01234567890",three = "01 23 45 67 89 0";
		//Statements
		System.out.println(one.length());
		System.out.println(two.length());
		System.out.println(three.length());
		System.out.println(one.charAt(0));
		System.out.println(one.charAt(1));
		System.out.println(one.charAt(one.length()-1));
		System.out.println(one.charAt(9));
		System.out.println(one.substring(0,4));
		System.out.println(one.substring(5));
		System.out.println(one.substring(9));
		System.out.println(one.substring(2,7));
		System.out.println(one.indexOf("abc"));
		System.out.println(one.indexOf("e"));
		System.out.println(one.indexOf("hij"));
		System.out.println(two.indexOf("56"));
		System.out.println(two.indexOf("24"));
		System.out.println(one.indexOf('c'));
		System.out.println(two.indexOf('r'));
		System.out.println(two.indexOf('0'));
		System.out.println(three.indexOf("45"));
	}

}
