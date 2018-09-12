package chapter12;

public class Proj12_7 
{
	private static int calls;

	public static void main(String[] args) 
	{
		System.out.printf("%-10s%-10s%n", "Size", "Calls");
		for(int i=1; i<=10; i++)
		{
			boolean[][] board = new boolean[i][i];
			reset(board);
			canPlaceQueen(0, board);
			System.out.printf("%-10d%-10d%n", i, calls);
		}
	}
	
	private static boolean canPlaceQueen(int col, boolean[][] board)
	{
		calls++;
		for(int row = 0; row < board.length; row++)
		{
			if(!attacked(row, col, board))
			{
				board[row][col] = true;
				if(col == board.length-1 || canPlaceQueen(col + 1, board))
					return true;
				board[row][col] = false;
			}
		}
		return false;
	}
	
	private static boolean attacked(int row, int col, boolean[][] board)
	{
		int i, j, k;
		
		for(j=0; j<col; j++)
		{
			if(board[row][j])
				return true;
		}
		
		i = row-1;
		j = row-1;
		for(k = 0; k <= Math.min(i, j); k++)
		{
			if(board[i][j])
				return true;
			i--;
			j--;
		}
		
		i = row+1;
		j = row-1;
		for(k = 0; k <= Math.min(board.length-i-1, j); k++)
		{
			if(board[i][j])
				return true;
			i++;
			j--;
		}
		
		return false;
	}
	
	private static void reset(boolean[][] board)
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[0].length; j++)
			{
				board[i][j] = false;
			}
		}
		calls = 0;
	}

}
