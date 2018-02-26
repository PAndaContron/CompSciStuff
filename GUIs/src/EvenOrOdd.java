import javax.swing.JOptionPane;

public class EvenOrOdd 
{

	public static void main(String[] args) 
	{
		while(true)
		{
			int i;
			String input = JOptionPane.showInputDialog(null, "Enter an integer: ",
					"Even or Odd", JOptionPane.QUESTION_MESSAGE);
			try
			{
				i = Integer.parseInt(input);
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, input+" is not an integer.",
						"Error", JOptionPane.ERROR_MESSAGE);
				continue;
			}
			
			if(JOptionPane.showConfirmDialog(null,
					"The number " + i + (i%2==0 ? " is even." : " is odd.") + "\n\nEnter another number?",
					"Even or Odd", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)
					== JOptionPane.NO_OPTION)
				break;
		}
	}

}
