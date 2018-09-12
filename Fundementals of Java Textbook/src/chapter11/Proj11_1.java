package chapter11;

import java.util.Scanner;

public class Proj11_1 
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a sentence:");
		String sentence = scan.nextLine();
		String[] words = sentence.split("\\s");
		
		int sum = 0;
		for(String s : words)
		{
			sum += s.length();
		}
		
		System.out.println("Word count: "+words.length);
		System.out.println("Average word length: "+sum/(double) words.length);
		System.out.println("Sentence length: "+sentence.length());
		
		scan.close();
	}

}
