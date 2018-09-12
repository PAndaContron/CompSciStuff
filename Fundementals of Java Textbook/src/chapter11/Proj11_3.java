package chapter11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Proj11_3 
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the filename:");
		
		Scanner fileScan;
		while(true)
		{
			try
			{
				fileScan = new Scanner(new File(scan.next()));
				break;
			}
			catch (FileNotFoundException e)
			{
				System.err.println("File not found.");
			}
		}
		
		System.out.println("Enter the word to search for:");
		String word = scan.next();
		
		int index = -1, matches = 0;
		for(int i = 0; fileScan.hasNext(); i++)
		{
			if(word.equalsIgnoreCase(fileScan.next()))
			{
				if(index==-1)
					index = i;
				matches++;
			}
		}
		
		System.out.println(index==-1 ? "Word not found." : "Word found "+matches+" times, first one at index "+index);
		
		fileScan.close();
		scan.close();
	}

}
