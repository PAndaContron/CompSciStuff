package general;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * Represents a square board with {@link BoardSquare}s of alternating colors. Each space can hold one {@link Piece}.
 */
public abstract class Board implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** Holds all of the {@link Piece}s on the board. */
	protected Piece[][] board;
	/** {@link JPanel} which can be used by another program for a GUI display. */
	private JPanel mainPanel;
	/** Holds all of the {@link BoardSquare}s that make up the board. */
	private BoardSquare[][] boardPanels;
	
	/** Holds squares which have been selected through the GUI. */
	private List<int[]> selections = new ArrayList<>();
	
	/**
	 * Creates a new board with all of its {@link BoardSquare}s.
	 * 
	 * @param size The height and width of this board in squares.
	 * @param c1 The color used on all {@link BoardSquare} where the sum of their coordinates is even.
	 * @param c2 The color used on all {@link BoardSquare} where the sum of their coordinates is odd.
	 */
	public Board(int size, Color c1, Color c2)
	{
		BoardSquare.SelectionListener selectionListener = new BoardSquare.SelectionListener()
		{
			public void react(BoardSquare source, int row, int column)
			{
				selections.add(new int[] {row, column});
				
			}
		};
		BoardSquare.SelectionListener deselectionListener = new BoardSquare.SelectionListener()
		{
			public void react(BoardSquare source, int row, int column)
			{
				int[] coords = {row, column};
				int index = Utils.indexOfArray(selections, coords);
				if(index > -1)
					selections.remove(index);
			}
		};
		
		board = new Piece[size][size];
		mainPanel = new JPanel(new GridLayout(size, size))
			{
				private static final long serialVersionUID = -3286801522412130579L;

				public void setPreferredSize(Dimension d)
				{
					super.setPreferredSize(d);
					addComponentListener(new ResizeListener());
				}
				
				public void paintComponent(Graphics g)
				{
					resize();
//					super.paintComponent(g);
				}
				
				private void resize()
				{
		            int s = Math.min(getWidth(), getHeight());
		            int rows = ((GridLayout) getLayout()).getRows();
		            int columns = ((GridLayout) getLayout()).getColumns();
		            int width = s/columns, height = s/rows;
		            for(Component c : getComponents())
		            	c.setSize(new Dimension(width, height));
		            setSize(new Dimension(s, s));
		            ((GridLayout) getLayout()).setHgap(0);
		            ((GridLayout) getLayout()).setVgap(0);
		            doLayout();
		            
		            if(getParent().getWidth() > getWidth())
		            {
		            	int prefX = getParent().getWidth()/2 - getWidth()/2;
		            	setLocation(prefX, getY());
		            }
		            else if(getParent().getHeight() > getHeight())
		            {
		            	int prefY = getParent().getHeight()/2 - getHeight()/2;
		            	setLocation(getX(), prefY);
		            }
				}
			
				class ResizeListener extends ComponentAdapter
				{
			        public void componentResized(ComponentEvent e)
			        {
			            resize();
			        }
				}
			};
		mainPanel.setPreferredSize(new Dimension(size*100, size*100));
		boardPanels = new BoardSquare[size][size];
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				if((i+j) % 2 == 0)
					boardPanels[i][j] = new BoardSquare(c1, i, j);
				else
					boardPanels[i][j] = new BoardSquare(c2, i, j);
				boardPanels[i][j].addSelectionListener(selectionListener);
				boardPanels[i][j].addDeselectionListener(deselectionListener);
				mainPanel.add(boardPanels[i][j]);
			}
		}
	}
	
	/**
	 * Sets the {@link Piece} for each {@link BoardSquare} to the one at its position.
	 */
	public void updatePanels()
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board.length; j++)
			{
				boardPanels[i][j].setPiece(board[i][j]);
			}
		}
	}
	
	/**
	 * Moves a {@link Piece}, without any checks for validity, and updates the {@link BoardSquare}s appropriately.
	 * 
	 * @param from The position of the {@link Piece} to move.
	 * @param to The final position of the {@link Piece}.
	 * <br> If the array is longer than 2 (in the case of multiple jumps), the last 2 values are used.
	 */
	public void move(int[] from, int[] to)
	{
		board[to[to.length-2]][to[to.length-1]] = board[from[0]][from[1]];
		board[from[0]][from[1]] = null;
		updatePanels();
	}
	
	/**
	 * Finds whether there are any pieces on the board of a certain color which can make a valid move.
	 * This can be used to check a victory condition for some games.
	 * 
	 * @param c The color to look for.
	 * 
	 * @return Whether or not any pieces with that color can move.
	 */
	public boolean hasMoves(Color c)
	{
		for(int i=0; i<board.length; i++)
			for(int j=0; j<board.length; j++)
				if(board[i][j]!=null && board[i][j].getColor().equals(c) && board[i][j].hasMoves(board, new int[] {i, j}))
				{
//					System.out.printf("Piece at %d, %d has a move%n", i, j);
					return true;
				}
		return false;
	}
	
	/**
	 * Counts the number of pieces on the board.
	 * This can be used to check if any pieces have been captured.
	 * 
	 * @return The number of pieces.
	 */
	public int countPieces()
	{
		int i = 0;
		for(Piece[] row : board)
			for(Piece p : row)
				if(p!=null)
					i++;
		return i;
	}
	
	/**
	 * Counts the number of pieces with the specified {@link Color}.
	 * This can be used to check a victory condition for some games.
	 * 
	 * @param c The color to look for.
	 * 
	 * @return The number of pieces with that color.
	 */
	public int countPieces(Color c)
	{
		int i = 0;
		for(Piece[] row : board)
			for(Piece p : row)
				if(p!=null && p.getColor().equals(c))
					i++;
		return i;
	}
	
	/**
	 * Gets the {@link Piece} at a specified position.
	 * 
	 * @param row The row of the board, starting at 0 for the top.
	 * @param col The column of the board, starting at 0 for the side.
	 * 
	 * @return The {@link Piece} at <b>row</b>, <b>col</b>.
	 */
	public Piece getPiece(int row, int col)
	{
		return board[row][col];
	}
	
	/**
	 * Gets a {@link JPanel} which can be used in a GUI to display the current state of the board.
	 * 
	 * @return This board's panel.
	 */
	public JPanel getPanel()
	{
		return mainPanel;
	}
	
	/**
	 * Gets the positions which have been selected by the user, in order.
	 * 
	 * @return A list of 2-element arrays representing the row and column of each selected square.
	 */
	public List<int[]> getSelections()
	{
		return selections;
	}
	
	public void clearSelections()
	{
		List<int[]> selectionsClone = new ArrayList<>();
		selectionsClone.addAll(selections);
		selectionsClone.forEach(coords -> boardPanels[coords[0]][coords[1]].deselect());
	}
	
	/**
	 * Creates a {@link String} with a picture of the board using each {@link Piece}'s icon. Includes numerical labels for rows and alphabetical labels for columns.
	 * 
	 * @return The picture of the board.
	 */
	public String toString()
	{
		String out = " ";
		//Chess coordinate column headers
		for(int i=0; i<board.length; i++)
			out += Utils.ALPHABET[i];
		out += "\n";
		
		for(int i=board.length-1; i>=0; i--)
		{
			//Chess coordinate row headers
			out += (i+1);
			
			//Print out the piece if there is one, or the checkerboard in the background if there isn't
			Piece[] row = board[i];
			for(int j=0; j<row.length; j++)
			{
				Piece p = row[j];
				if(p != null)
					out += p;
				else
					if((i+j)%2 == 0)
						out += " ";
					else
						out += "\u25A1";
			}
			out += "\n";
		}
		return out;
	}
}
