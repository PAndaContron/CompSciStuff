package chapter9;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Proj9_6 
{

	public static void main(String[] args) 
	{
		new TestScoresView(new TestScoresModel());
	}

	private static class Student 
	{
		private String name;
		private int[] tests;
		
		@SuppressWarnings("unused")
		public Student(Student s)
		{
			this(s.getName(), s.getTests());
		}
		
		@SuppressWarnings("unused")
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
		
		@SuppressWarnings("unused")
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
		
		@SuppressWarnings("unused")
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
			String str = "Name:\t"+name;
			for (int i = 0; i < tests.length; i++) 
			{
				str += "\nTest "+i+":\t" + tests[i];
			}
			str += "\nAverage:\t" + getAverage();
			return str;
		}
	}
	
	private static class TestScoresModel implements Iterable<Student>
	{
		private Student[] students = new Student[10];
		private int index = -1;
		private int studentCount = 0;
		
		@Override
		public Iterator<Student> iterator()
		{
			return new StudentIterator();
		}
		
		public String add(Student s)
		{
			if(studentCount == students.length)
				return "SORRY: student list is full";
			students[studentCount] = s;
			index = studentCount;
			studentCount++;
			return null;
		}
		
		@SuppressWarnings("unused")
		public String replace(Student s)
		{
			if(index == -1)
				return "Must add a student first";
			students[index] = s;
			return null;
		}
		
		public Student first()
		{
			Student s = null;
			if(studentCount == 0)
				index = -1;
			else
			{
				index = 0;
				s = students[index];
			}
			return s;
		}
		
		public Student previous()
		{
			Student s = null;
			if(studentCount == 0)
				index = -1;
			else
			{
				index = Math.max(index-1, 0);
				s = students[index];
			}
			return s;
		}
		
		public Student next()
		{
			Student s = null;
			if(studentCount == 0)
				index = -1;
			else
			{
				index = Math.min(index+1, studentCount-1);
				s = students[index];
			}
			return s;
		}
		
		public Student last()
		{
			Student s = null;
			if(studentCount == 0)
				index = -1;
			else
			{
				index = studentCount-1;
				s = students[index];
			}
			return s;
		}
		
		public Student currentStudent()
		{
			return index == -1 ? null : students[index];
		}
		
		public int size()
		{
			return studentCount;
		}
		
		public int currentPosition()
		{
			return index;
		}
		
		public int getClassAverage()
		{
			if(studentCount == 0)
				return 0;
			double sum = 0;
			for (Student s : this) 
			{
				sum += s.getAverage();
			}
			return (int) Math.round(sum/studentCount);
		}
		
		public Student getHighScore()
		{
			if(studentCount == 0)
				return null;
			Student high = students[0];
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
		
		private class StudentIterator implements Iterator<Student>
		{
			private int index = 0;
			
			@Override
			public boolean hasNext() 
			{
				return index < studentCount;
			}

			@Override
			public Student next() 
			{
				index++;
				return students[index-1];
			}
		}
	}
	
	private static class TestScoresView
	{
		private TestScoresModel model;
		private static Scanner scan;
		
		public TestScoresView(TestScoresModel m)
		{
			model = m;
			run();
		}
		
		private void run()
		{
			scan = new Scanner(System.in);
			while(true)
			{
				System.out.println("Number of students: "+model.size());
				System.out.println("Index of current student: "+model.currentPosition());
				displayMenu();
				int command = getCommand("Enter a number [1-11]: ", 1, 11);
				if(command == 11)
					break;
				runCommand(command);
			}
			scan.close();
		}
		
		private static void displayMenu()
		{
			System.out.println("1\tDisplay current student");
			System.out.println("2\tDisplay class average");
			System.out.println("3\tDisplay student with the highest grade");
			System.out.println("4\tDisplay all students");
			System.out.println("5\tEdit current student");
			System.out.println("6\tAdd a new student");
			System.out.println("7\tMove to first student");
			System.out.println("8\tMove to last student");
			System.out.println("9\tMove to next student");
			System.out.println("10\tMove to previous student");
			System.out.println("11\tExit");
		}
		
		private static int getCommand(String prompt, int low, int high)
		{
			System.out.println(prompt);
			int command;
			while(true)
			{
				try
				{
					command = (int) scan.nextDouble();
					scan.nextLine();
					if(command < low || command > high)
						throw new IllegalArgumentException();
					return command;
				}
				catch(InputMismatchException e)
				{
					System.err.println("Input must be a number.");
					scan.next();
				}
				catch(IllegalArgumentException e)
				{
					System.err.println("Input must be between "+low+" and "+high+".");
				}
			}
		}
		
		private void runCommand(int command)
		{
			switch(command)
			{
				case(1):
				{
					Student s = model.currentStudent();
					System.out.println(s == null ? "No students!" : s);
					System.out.println("Press enter to continue.");
					scan.nextLine();
				}break;
				case(2):
				{
					System.out.println(model.getClassAverage());
					System.out.println("Press enter to continue.");
					scan.nextLine();
				}break;
				case(3):
				{
					System.out.println(model.getHighScore());
					System.out.println("Press enter to continue.");
					scan.nextLine();
				}break;
				case(4):
				{
					for (Student student : model) 
					{
						System.out.println(student);
						System.out.println("Press enter to continue.");
						scan.nextLine();
					}
				}break;
				case(6):
				{
					if(model.size() == 10)
					{
						System.out.println("No more space!");
						System.out.println("Press enter to continue.");
						scan.nextLine();
						break;
					}
					
					System.out.println("Enter a name:");
					model.add(new Student(scan.nextLine(), getCommand("How many tests has this student taken?", 0, Integer.MAX_VALUE)));
					System.out.println("Finish editing your student:");
				}case(5):
				{
					System.out.println(model.currentStudent());
					while(true)
					{
						System.out.println("1\tEdit test score");
						System.out.println("2\tEdit name");
						System.out.println("3\tDone editing");
						int subcommand = getCommand("Enter a number [1-3]: ", 1, 3);
						if(subcommand == 3)
							break;
						switch(subcommand)
						{
							case(1):
							{
								model.currentStudent().setScore(getCommand("Enter a test number:", 0, model.currentStudent().getTests().length-1), getCommand("Enter the score:", 0, 100));
							}break;
							case(2):
							{
								System.out.println("Enter a new name:");
								model.currentStudent().setName(scan.nextLine());
							}break;
						}
					}
				}
				case(7):
				{
					Student s = model.first();
					System.out.println(s == null ? "No students!" : s);
					System.out.println("Press enter to continue.");
					scan.nextLine();
				}break;
				case(8):
				{
					Student s = model.last();
					System.out.println(s == null ? "No students!" : s);
					System.out.println("Press enter to continue.");
					scan.nextLine();
				}break;
				case(9):
				{
					Student s = model.next();
					System.out.println(s == null ? "No students!" : s);
					System.out.println("Press enter to continue.");
					scan.nextLine();
				}break;
				case(10):
				{
					Student s = model.previous();
					System.out.println(s == null ? "No students!" : s);
					System.out.println("Press enter to continue.");
					scan.nextLine();
				}break;
			}
		}
	}

}
