import javax.swing.JOptionPane;

//Rajat Patel

public class Quiz 
{

	public static void main(String[] args) 
	{
		final int NUM = 10;
		
		String[] answers = new String[NUM];
		String[] answerKey = {"Ottawa", "Albania", "Kazakhstan", "Egypt", "Denmark", "193", "Croatia", "Romania", "Colombia", "Russia"};
		
		String[] options1 = {"Quebec", "Ottawa", "Montreal", "Colombia"};	//Ottawa
		answers[0] = (String) JOptionPane.showInputDialog(null, "What is the capital of Canada? ", "Question 1",
				JOptionPane.QUESTION_MESSAGE, null, options1, "Quebec");
		
		String[] options2 = {"Serbia", "Montenegro", "Slovenia", "Albania"};	//Albania
		answers[1] = (String) JOptionPane.showInputDialog(null, "Which country was NOT part of Yugoslavia? ", "Question 2",
				JOptionPane.QUESTION_MESSAGE, null, options2, "Serbia");
		
		String[] options3 = {"Kazakhstan", "Kyrgyzstan", "China", "Colombia"};	//Kazakhstan
		answers[2] = (String) JOptionPane.showInputDialog(null, "Which country is considered transcontinental? ", "Question 3",
				JOptionPane.QUESTION_MESSAGE, null, options3, "Kazakhstan");
		
		String[] options4 = {"Israel", "Egypt", "Panama", "Korea"};	//Egypt
		answers[3] = (String) JOptionPane.showInputDialog(null, "Where is the Suez Canal? ", "Question 4",
				JOptionPane.QUESTION_MESSAGE, null, options4, "Israel");
		
		String[] options5 = {"Canada", "It's independent", "Norway", "Denmark"};	//Denmark
		answers[4] = (String) JOptionPane.showInputDialog(null, "What country owns Greenland? ", "Question 5",
				JOptionPane.QUESTION_MESSAGE, null, options5, "Canada");
		
		String[] options6 = {"196", "200", "197", "193"};	//193
		answers[5] = (String) JOptionPane.showInputDialog(null, "How many countries are in the UN? ", "Question 6",
				JOptionPane.QUESTION_MESSAGE, null, options6, "196");
		
		String[] options7 = {"Ukraine", "Vatican City", "Croatia", "Norway"};	//Croatia
		answers[6] = (String) JOptionPane.showInputDialog(null, "Which of the following countries is an EU member? ", "Question 7",
				JOptionPane.QUESTION_MESSAGE, null, options7, "Ukraine");
		
		String[] options8 = {"Serbia", "Romania", "Norway", "Thailand"};	//Romania
		answers[7] = (String) JOptionPane.showInputDialog(null, "Which country's flag does NOT have red, white, and blue? ", "Question 8",
				JOptionPane.QUESTION_MESSAGE, null, options8, "Serbia");
		
		String[] options9 = {"Nicaragua", "Costa Rica", "Colombia", "Panama"};	//Colombia
		answers[8] = (String) JOptionPane.showInputDialog(null, "Which country is NOT in North America? ", "Question 9",
				JOptionPane.QUESTION_MESSAGE, null, options9, "Nicaragua");
		
		String[] options10 = {"Bulgaria", "Luxembourg", "Russia", "Slovenia"};	//Russia
		answers[9] = (String) JOptionPane.showInputDialog(null, "Which country does Poland border? ", "Question 10",
				JOptionPane.QUESTION_MESSAGE, null, options10, "Bulgaria");
		
		boolean[] correct = new boolean[NUM];
		int numCorrect = 0;
		for(int i = 0; i<NUM; i++)
			if(answers[i] != null && answers[i].equals(answerKey[i]))
			{
				correct[i] = true;
				numCorrect++;
			}
		
		String message = "You got "+numCorrect+"/10 questions correct.";
		
		for(int i = 0; i<NUM; i++)
		{
			message += "\n\nQuestion "+(i+1)+": You put "+(answers[i]==null ? "nothing" : answers[i])+", "
					+ (correct[i] ? "which is correct." : ("the correct answer was "+answerKey[i]+"."));
		}
		
		JOptionPane.showMessageDialog(null, message, "Results", JOptionPane.INFORMATION_MESSAGE);
	}

}
