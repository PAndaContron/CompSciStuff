package chapter11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Proj11_9 
{

	public static void main(String[] args) 
	{
		new TestScoresView(new TestScoresModel());
	}

	private static class Student 
	{	
		public static Student unpack(String s)
		{
			String[] tokens = s.split(",*\\s+");
			String name = tokens[0];
			
			int[] scores = new int[tokens.length-1];
			for(int i=0; i<scores.length; i++)
			{
				scores[i] = Integer.parseInt(tokens[i+1]);
			}
			
			return new Student(name, scores);
		}
		
		private String name;
		private int[] tests;
		
		public Student(Student s)
		{
			this(s.getName(), s.getTests());
		}
		
		public Student()
		{
			this("");
		}
		
		public Student(String nm)
		{
			this(nm, 3);
		}
		
		public Student(String nm, int n)
		{
			this(nm, new int[n]);
		}
		
		public Student(String nm, int[] t)
		{
			name = nm;
			setTests(t);
		}
		
		public String pack()
		{
			String s = name;
			for(int i : tests)
				s += ", "+i;
			return s;
		}
		
		public void setName(String nm)
		{
			name = nm;
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setScore(int i, int score)
		{
			tests[i] = score;
		}
		
		public int getScore(int i)
		{
			return tests[i];
		}
		
		public void setTests(int[] t)
		{
			tests = Arrays.copyOf(t, t.length);
		}
		
		public int[] getTests()
		{
			return Arrays.copyOf(tests, tests.length);
		}
		
		public int getAverage()
		{
			int sum = 0;
			for (int i : tests) 
			{
				sum += i;
			}
			return (int) Math.round(sum / (double) tests.length);
		}
		
		public int getHighScore()
		{
			int high = 0;
			for (int i : tests) 
			{
				high = Math.max(i, high);
			}
			return high;
		}
		
		public String validateData()
		{
			if(name.equals(""))
				return "SORRY: name required";
			for (int i : tests) 
			{
				if(i < 0)
					return "SORRY: test score cannot be negative.";
				else if(i > 100)
					return "SORRY: test score cannot be over 100.";
			}
			return null;
		}
		
		public String toString()
		{
			String str = "Name: \t"+name;
			for (int i = 0; i < tests.length; i++) 
			{
				str += "\nTest "+i+": \t" + tests[i];
			}
			str += "\nAverage: \t" + getAverage();
			return str;
		}
	}
	
	private static class TestScoresModel implements Iterable<Student>
	{
		private List<Student> students = new ArrayList<>();
		private int index = -1;
		
		@Override
		public Iterator<Student> iterator()
		{
			return students.iterator();
		}
		
		public void save(File f) throws FileNotFoundException
		{
			PrintWriter file = new PrintWriter(f);
			
			for(Student s : this)
			{
				file.println(s.pack());
			}
			
			file.close();
		}
		
		public void load(String s)
		{
			Scanner scan = new Scanner(s);
			
			students.clear();
			while(scan.hasNextLine())
			{
				students.add(Student.unpack(scan.nextLine()));
			}
			index = -1;
			
			scan.close();
		}
		
		public String add(Student s)
		{
			students.add(s);
			index = students.size()-1;
			return null;
		}
		
		public String replace(Student s)
		{
			if(index == -1)
				return "Must add a student first";
			students.set(index, s);
			return null;
		}
		
		public void remove()
		{
			students.remove(index);
			if(index >= size())
				previous();
		}
		
		public Student first()
		{
			Student s = null;
			if(size() == 0)
				index = -1;
			else
			{
				index = 0;
				s = students.get(0);
			}
			return s;
		}
		
		public Student previous()
		{
			Student s = null;
			if(size() == 0)
				index = -1;
			else
			{
				index = Math.max(index-1, 0);
				s = students.get(index);
			}
			return s;
		}
		
		public Student next()
		{
			Student s = null;
			if(size() == 0)
				index = -1;
			else
			{
				index = Math.min(index+1, size()-1);
				s = students.get(index);
			}
			return s;
		}
		
		public Student last()
		{
			Student s = null;
			if(size() == 0)
				index = -1;
			else
			{
				index = size()-1;
				s = students.get(index);
			}
			return s;
		}
		
		public Student currentStudent()
		{
			return index == -1 ? null : students.get(index);
		}
		
		public int size()
		{
			return students.size();
		}
		
		public int currentPosition()
		{
			return index;
		}
		
		public int getClassAverage()
		{
			if(size() == 0)
				return 0;
			double sum = 0;
			for (Student s : this) 
			{
				sum += s.getAverage();
			}
			return (int) Math.round(sum/size());
		}
		
		public Student getHighScore()
		{
			if(size() == 0)
				return null;
			Student high = students.get(0);
			for(Student s : this)
			{
				if(high.getHighScore() < s.getHighScore())
					high = s;
			}
			return high;
		}
		
		public String toString()
		{
			String str = "";
			for(Student s : this)
				str += s+"\n";
			return str;
		}
	}
	
	private static class TestScoresView extends JFrame
	{
		private static final long serialVersionUID = 1L;

		private TestScoresModel model;
		
		private JMenuItem newMI = new JMenuItem("New");
		private JMenuItem openMI = new JMenuItem("Open");
		private JMenuItem saveMI = new JMenuItem("Save");
		private JMenuItem addMI = new JMenuItem("Add");
		private JMenuItem modifyMI = new JMenuItem("Modify");
		private JMenuItem deleteMI = new JMenuItem("Delete");
		private JMenuItem highScoreMI = new JMenuItem("Highest Score");
		private JMenuItem aveScoreMI = new JMenuItem("Class Average");
		
		private JButton firstButton = new JButton("<<");
		private JButton previousButton = new JButton("<");
		private JButton nextButton = new JButton(">");
		private JButton lastButton = new JButton(">>");
		
		private JLabel nameLabel = new JLabel("Name");
		private JLabel test1Label = new JLabel("Test 1");
		private JLabel test2Label = new JLabel("Test 2");
		private JLabel test3Label = new JLabel("Test 3");
		private JLabel averageLabel = new JLabel("Average");
		private JLabel countLabel = new JLabel("Count");
		private JLabel indexLabel = new JLabel("Index");
		
		private JTextField nameField = new JTextField("");
		private JTextField test1Field = new JTextField("0");
		private JTextField test2Field = new JTextField("0");
		private JTextField test3Field = new JTextField("0");
		private JTextField averageField = new JTextField("0");
		private JTextField countField = new JTextField("0");
		private JTextField indexField = new JTextField("-1");
		
		public TestScoresView(TestScoresModel m)
		{
			model = m;
			
			ActionListener fileListener = new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(e.getSource() == newMI)
						model.load("");
					else if(e.getSource() == openMI)
					{
						File f;
						try 
						{
							f = getFile(true);
							model.load(new String(Files.readAllBytes(f.toPath())));
						} 
						catch (IOException e1) 
						{
							e1.printStackTrace();
						}
					}
					else if(e.getSource() == saveMI)
					{
						File f;
						try 
						{
							f = getFile(false);
							model.save(f);
						} 
						catch (IOException e1) 
						{
							e1.printStackTrace();
						}
					}
					displayInfo();
				}
				
				private File getFile(boolean exists) throws IOException
				{
					String s = JOptionPane.showInputDialog(TestScoresView.this, "Enter a filename:", "Project 11-9 - File", JOptionPane.QUESTION_MESSAGE);
					File f = new File(s);
					if(exists && !f.exists())
					{
						JOptionPane.showMessageDialog(TestScoresView.this, "File not found.", "Project 11-9 - Error", JOptionPane.ERROR_MESSAGE);
						return getFile(true);
					}
					f.createNewFile();
					return f;
				}
			};
			newMI.addActionListener(fileListener);
			openMI.addActionListener(fileListener);
			saveMI.addActionListener(fileListener);
			
			ActionListener studentListener = new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					Student s = getInfoFromScreen();
					if(s == null)
						return;
					if(e.getSource() == addMI)
					{
						String message = model.add(s);
						if(message != null)
							JOptionPane.showMessageDialog(TestScoresView.this, message, "Project 11-9 - Error", JOptionPane.ERROR_MESSAGE);
					}
					else if(e.getSource() == modifyMI)
					{
						model.replace(s);
					}
					else if(e.getSource() == deleteMI)
					{
						model.remove();
					}
					displayInfo();
				}
			};
			addMI.addActionListener(studentListener);
			modifyMI.addActionListener(studentListener);
			deleteMI.addActionListener(studentListener);
			
			ActionListener statListener = new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					String s = "";
					if(e.getSource() == highScoreMI)
					{
						s = "The highest scoring student is:\n"+model.getHighScore();
					}
					else if(e.getSource() == aveScoreMI)
					{
						s = "The average score is "+model.getClassAverage()+".";
					}
					JOptionPane.showMessageDialog(TestScoresView.this, s, "Project 11-9", JOptionPane.INFORMATION_MESSAGE);
				}
			};
			highScoreMI.addActionListener(statListener);
			aveScoreMI.addActionListener(statListener);
			
			JMenu file = new JMenu("File");
			file.add(newMI);
			file.add(openMI);
			file.add(saveMI);
			
			JMenu edit = new JMenu("Edit");
			edit.add(addMI);
			edit.add(modifyMI);
			edit.add(deleteMI);
			
			JMenu data = new JMenu("Data");
			data.add(highScoreMI);
			data.add(aveScoreMI);
			
			JMenuBar bar = new JMenuBar();
			bar.add(file);
			bar.add(edit);
			bar.add(data);
			setJMenuBar(bar);
			
			ActionListener navigationListener = new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					switch(((JButton)e.getSource()).getText())
					{
						case("<"):	model.previous();
							break;
						case("<<"):	model.first();
							break;
						case(">"):	model.next();
							break;
						case(">>"):	model.last();
							break;
					}
					
					displayInfo();
				}
			};
			firstButton.addActionListener(navigationListener);
			previousButton.addActionListener(navigationListener);
			nextButton.addActionListener(navigationListener);
			lastButton.addActionListener(navigationListener);
			
			averageField.setEditable(false);
			countField.setEditable(false);
			indexField.setEditable(false);
			averageField.setBackground(Color.WHITE);
			countField.setBackground(Color.WHITE);
			indexField.setBackground(Color.WHITE);
			
			JPanel centerPanel = new JPanel(new GridLayout(5, 4, 10, 5));
			JPanel southPanel = new JPanel();
			
			Container pane = getContentPane();
			pane.add(centerPanel, BorderLayout.CENTER);
			pane.add(southPanel, BorderLayout.SOUTH);
			
			centerPanel.add(nameLabel);
			centerPanel.add(nameField);
			centerPanel.add(countLabel);
			centerPanel.add(countField);

			centerPanel.add(test1Label);
			centerPanel.add(test1Field);
			centerPanel.add(indexLabel);
			centerPanel.add(indexField);

			centerPanel.add(test2Label);
			centerPanel.add(test2Field);
			centerPanel.add(new JLabel(""));
			centerPanel.add(new JLabel(""));

			centerPanel.add(test3Label);
			centerPanel.add(test3Field);
			centerPanel.add(new JLabel(""));
			centerPanel.add(new JLabel(""));

			centerPanel.add(averageLabel);
			centerPanel.add(averageField);
			centerPanel.add(new JLabel(""));
			centerPanel.add(new JLabel(""));
			
			southPanel.add(firstButton);
			southPanel.add(previousButton);
			southPanel.add(nextButton);
			southPanel.add(lastButton);
			
			setTitle("Student Test Scores");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			pack();
			setVisible(true);
		}
		
		private void displayInfo()
		{
			Student s = model.currentStudent();
			if(s==null)
			{
				nameField.setText("");
				test1Field.setText("0");
				test2Field.setText("0");
				test3Field.setText("0");
				averageField.setText("0");
				countField.setText("0");
				indexField.setText("-1");
			}
			else
			{
				nameField.setText(s.getName());
				test1Field.setText(""+s.getScore(0));
				test2Field.setText(""+s.getScore(1));
				test3Field.setText(""+s.getScore(2));
				averageField.setText(""+s.getAverage());
				countField.setText(""+model.size());
				indexField.setText(""+model.currentPosition());
			}
		}
		
		private Student getInfoFromScreen()
		{
			Student s = new Student(nameField.getText());
			try
			{
				s.setScore(0, (int) Double.parseDouble(test1Field.getText()));
				s.setScore(1, (int) Double.parseDouble(test2Field.getText()));
				s.setScore(2, (int) Double.parseDouble(test3Field.getText()));
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(this, "Grade must be a number.", "Project 11-9 - Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
			if(s.validateData() != null)
			{
				JOptionPane.showMessageDialog(this, s.validateData(), "Project 11-9 - Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
			return s;
		}
	}

}
