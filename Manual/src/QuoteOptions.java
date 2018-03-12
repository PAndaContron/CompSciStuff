import javax.swing.JFrame;

public class QuoteOptions {

	
	public static void main (String[] args)
	{
		JFrame quoteFrame = new JFrame ("Quote Options");
		quoteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		QuoteGUI gui = new QuoteGUI();
		quoteFrame.getContentPane().add(gui.getPanel());
		quoteFrame.pack();
		quoteFrame.setVisible(true);
	}
}