package chapter12;

import java.text.NumberFormat;
import java.util.Random;

public class Proj12_3 
{
	private static Random gen = new Random();
	private static NumberFormat f = NumberFormat.getInstance();

	public static void main(String[] args) 
	{
		f.setMinimumIntegerDigits(3);
		f.setMaximumIntegerDigits(3);
		while(true)
			System.out.println(format(gen.nextInt()));
	}

	private static String format(int i)
	{
		if(Math.abs(i) < 1000)
			return i+"";
		return format(i/1000) + "," + f.format(Math.abs(i%1000));
	}
}
