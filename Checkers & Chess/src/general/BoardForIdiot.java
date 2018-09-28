package general;

public class BoardForIdiot {

	public BoardForIdiot() {
		char[][] idiotBoard = new char[8][8];
		
		
		//initialize a board full of values 
		{
			for (int x = 0; x <= 7; x++) {
				for (int y = 0; y <= 7; y++) {
					if ((x % 2) != (y % 2))
						idiotBoard[x][y] = 'h';
				}
			}

			for (int x = 0; x <= 7; x++) {
				for (int y = 0; y <= 7; y++) {
					if (idiotBoard[x][y] != 'h') {
						if (y <= 2)
							idiotBoard[x][y] = 'b';
						else if (y >= 5)
							idiotBoard[x][y] = 'r';
					}
				}
			}

			for (int x = 0; x <= 7; x++) {
				for (int y = 3; y <= 4; y++) {
					if (idiotBoard[x][y] != 'h')
						idiotBoard[x][y] = 'n';
				}
			}
		}
		
	
		   for(int x = 0; x < 8; x++)
		   {
		      for(int y = 0; y < 8; y++)
		      {
		         System.out.print(idiotBoard[x][y]);
		      }
		      System.out.println();
		   }

		// r stored means red piece
		// k stored means red king
		// b stored means black piece
		// q stored means black king
		// n stored means square is empty
		// h stored means square is not to be moved onto

		// if a specific square has one even and one odd coord it is an invalid
		// square
	}
}
