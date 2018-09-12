package chapter5;

public class Proj5_1 {

	public static void main(String[] args) 
	{
		Student s1 = new Student();
		Student s2 = new Student("Student 2");
		Student s3 = new Student("Student 3", 90, 90, 95);
		Student s4 = new Student(s3);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
	
	private static class Student 
	{
		private String name;
		private int test1;
		private int test2;
		private int test3;
		
		public Student(Student s)
		{
			this(s.getName(), s.getScore(1), s.getScore(2), s.getScore(3));
		}
		
		public Student()
		{
			this("");
		}
		
		public Student(String nm)
		{
			this(nm, 0, 0, 0);
		}
		
		public Student(String nm, int t1, int t2, int t3)
		{
			setName(nm);
			setScore(1, t1);
			setScore(2, t2);
			setScore(3, t3);
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
			switch(i)
			{
				case(1): test1 = score;	break;
				case(2): test2 = score;	break;
				case(3): test3 = score;	break;
			}
		}
		
		public int getScore(int i)
		{
			switch(i)
			{
				case(1): return test1;
				case(2): return test2;
				case(3): return test3;
			}
			return -1;
		}
		
		public int getAverage()
		{
			return (int) Math.round((test1 + test2 + test3) / 3.0);
		}
		
		public int getHighScore()
		{
			return test1>test2 ? (test1>test3 ? test1 : test3) : (test2>test3 ? test2 : test3);
		}
		
		public String toString()
		{
			return "Name:\t"+name+"\nTest 1:\t"+test1+"\nTest 2:\t"+test2+"\nTest 3:\t"+test3
					+"\nAverage:\t"+getAverage()+"\nHigh Score:\t"+getHighScore();
		}
	}
}
