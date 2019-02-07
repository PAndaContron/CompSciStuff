package general;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * Represents a single square on a {@link Board}, with a background {@link Color} and a {@link Piece}.
 */
public class BoardSquare extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	/** The color used when this square is selected. */
	private static final Color SELECTED_COLOR = Color.YELLOW;
	
	/** The piece currently sitting in this square. */
	private Piece piece;
	/** The color to be used for this piece when it is not selected. */
	private Color backColor;
	/** Whether or not this square is currently selected. */
	private boolean selected = false;
	
	/** Functional interfaces listening for the component being selected. */
	private List<SelectionListener> selectedListeners = new ArrayList<>();
	/** Functional interfaces listening for the component being deselected. */
	private List<SelectionListener> deselectedListeners = new ArrayList<>();
	
	/** The row number of this piece on the board. */
	private int row;
	/** The column number of this piece on the board. */
	private int column;

	/**
	 * Creates a new BoardSquare.
	 * 
	 * @param c The background color.
	 */
	public BoardSquare(Color c, int row, int column)
	{
		backColor = c;
		setBackground(c);
		addMouseListener(new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					if(selected)
						deselect();
					else
						select();
				}
				
				public void mouseReleased(MouseEvent e)
				{
					
				}
			}
		);
		
		this.row = row;
		this.column = column;
//		addComponentListener(new ResizeListener());
	}
	
	/**
	 * Sets the {@link Piece} to be displayed in this square.
	 * 
	 * @param p The piece in this square.
	 */
	public void setPiece(Piece p)
	{
		piece = p;
	}
	
	/**
	 * Changes the background color to indicate that this square is selected.
	 */
	public void select()
	{
		setBackground(SELECTED_COLOR);
		selected = true;
		selectedListeners.forEach(listener -> listener.react(this, row, column));
	}
	
	/**
	 * Reverts the background color to the original to indicate that this square is no longer selected.
	 */
	public void deselect()
	{
		setBackground(backColor);
		selected = false;
		deselectedListeners.forEach(listener -> listener.react(this, row, column));
	}
	
	/**
	 * Adds a listener for this square being selected.
	 * 
	 * @param listener
	 */
	public void addSelectionListener(SelectionListener listener)
	{
		selectedListeners.add(listener);
	}
	
	/**
	 * Adds a listener for this square being deselected.
	 */
	public void addDeselectionListener(SelectionListener listener)
	{
		deselectedListeners.add(listener);
	}
	
	/**
	 * Draws this panel, then draws the {@link Piece} on top of it, scaled to fit exactly in this square.
	 */
	public void paintComponent(Graphics g)
	{
//		int s = Math.min(getWidth(), getHeight());
//		setSize(new Dimension(s, s));
		
		super.paintComponent(g);
		if(piece != null)
		{
			piece.draw(this, g, 0, 0, getWidth(), getHeight());
		}
	}
	
	public interface SelectionListener
	{
		public void react(BoardSquare source, int row, int column);
	}
	
//	public Dimension getPreferredSize()
//	{
//		Dimension d = super.getPreferredSize();
//        Container c = getParent();
//        if (c != null)
//        {
//            d = c.getSize();
//        }
//        else
//        {
//            return new Dimension(10, 10);
//        }
//        int w = (int) d.getWidth();
//        int h = (int) d.getHeight();
//        int s = (w < h ? w : h);
//        return new Dimension(s, s);
//	}
	
//	private class ResizeListener extends ComponentAdapter
//	{
//        public void componentResized(ComponentEvent e)
//        {
//            int s = Math.min(getWidth(), getHeight());
//            setSize(new Dimension(s, s));
//        }
//	}
}
