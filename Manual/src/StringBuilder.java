//***********************************************************************************
//  Rajat Patel
//  Tail Recursion
//  9/20/2017
//  Multiple methods that remove punctuation from strings
//***********************************************************************************

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringBuilder 
{

	public static void main(String[] args) 
	{
		/*
		System.out.println((int)'A');	//65
		System.out.println((int)'Z');	//90
		System.out.println((int)'a');	//97
		System.out.println((int)'z');	//122
		System.out.println((int)' ');	//32
		System.out.println((int)'\n');	//10
		System.out.println((int)'\t');	//9
		System.out.println((int)'\r');	//13
		System.out.println((int)'0');	//48
		System.out.println((int)'9');	//57
		*/
		
		System.out.println(stringBuilder1("h3llo, I is\t\nhappy!!!!"));
		System.out.println(stringBuilder2("h3llo, I is\t\nhappy!!!!"));
		System.out.println(stringBuilder3("test1 \\\"\'!@]#$%^&*(),./-=_+`~test2"));
		
		System.out.println("\n\n");
		
		String s = "supercalifragilisticexpialidocious";
		int i = 0,j = s.length();
		while(i<=j)
		{
			System.out.println(s.substring(i,j));
			i++;
			j--;
		}
		
		System.out.println("\n\n");
		
		System.out.println(isPhoneNumber("732-420-6969"));
		System.out.println(isPhoneNumber("HI"));
		System.out.println(isPhoneNumber("732-KYS-6969"));
		System.out.println(isPhoneNumber("732-420-6969ajg"));
		System.out.println(isPhoneNumber("agr732-420-6969"));
		System.out.println(isPhoneNumber("732-420-6969593"));
		System.out.println(isPhoneNumber("358732-420-6969"));
	}

	public static String stringBuilder1(String str)
	{
		String output = "";
		
		for(int i=0;i<str.length();i++)
		{
			int current = str.charAt(i);
			
			if(current>=65 && current<=90)			//Capital letters
				output += (char)current;
			else if(current>=97 && current<=122)	//Lowercase letters
				output += (char)current;
			else if(current>=48 && current<=57)		//Digits
				output += (char)current;
			else if(current==32 || current==10 || current==9 || current==13)	//Whitespace
				output += (char)current;
		}
		
		return output;
	}
	
	public static String stringBuilder2(String str)
	{
		String output = "";
		StringTokenizer token = new StringTokenizer(str,"\\\"\'!@#$%^&*(),./;[]<>?:{}|-=_+`~");
		
		while(token.hasMoreTokens())
			output += token.nextToken();
		
		return output;
	}
	
	public static String stringBuilder3(String str)
	{
		String output = "";
		Scanner scan = new Scanner(str);
		scan.useDelimiter("[\\\\\\\"\\\'!@#\\$%\\^&\\*\\(\\)\\,\\./;\\[\\]<>\\?:\\{\\}\\|\\-=_\\+`~]");
		
		while(scan.hasNext())
			output += scan.next();
		
		scan.close();
		return output;
	}
	
	public static boolean isPhoneNumber(String str)
	{
		return str.matches("^\\d\\d\\d\\-\\d\\d\\d\\-\\d\\d\\d\\d$");
	}
}
