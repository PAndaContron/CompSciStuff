package chess;

import java.io.File;
import java.io.IOException;

public class TestChess
{

	public static void main(String[] args) throws IOException
	{
		File inputFolder = new File("resources/testInput/chess");
		for(File test : inputFolder.listFiles())
		{
			System.out.println();
			System.out.println("====================================================================================");
			System.out.printf("| RUNNING CHESS WITH TEST FILE: %50s |%n", test);
			System.out.println("====================================================================================");
			System.out.println();
			
			TerminalInterface.main(test.toString());
		}
	}

}
