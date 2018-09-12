package chapter12;

public class Proj12_2 
{

	public static void main(String[] args) 
	{
		String[] sentence = "I have a lot of large potatoes".split("\\s");
		System.out.printf("%-20s%-20s%n", "Forwards", "Backwards");
		for(String s : sentence)
		{
			System.out.printf("%-20s%-20s%n", s, reverse(s));
		}
	}
	
	private static String reverse(String s)
	{
		return s.length()>1 ? reverse(s.substring(1))+s.charAt(0) : s;
	}

}
