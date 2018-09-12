package chapter5;

import java.util.HashMap;
import java.util.Map;

public class Proj5_6 
{

	public static void main(String[] args) 
	{
		Patron patron = new Patron("Sam");
		System.out.println(patron);
		System.out.println(patron.borrowBook(new Book("George Miller", "Francis of the Filth")));
		System.out.println(patron);
		System.out.println(patron.hasBook("Francis of the Filth"));
		System.out.println(patron.hasBook("Froncis of the Filth"));
		System.out.println(patron.returnBook("Francis of the Filth"));
		System.out.println(patron.borrowBook(new Book("Author", "Book 1")));
		System.out.println(patron.borrowBook(new Book("Author", "Book 2")));
		System.out.println(patron.borrowBook(new Book("Author", "Book 3")));
		System.out.println(patron.borrowBook(new Book("Author", "Book 4")));
	}

	private static class Book
	{
		private String author;
		private String title;
		
		public Book(String author, String title)
		{
			this.author = author;
			this.title = title;
		}
		
		public String getAuthor()
		{
			return author;
		}
		
		public String getTitle()
		{
			return title;
		}
		
		public String toString()
		{
			return getTitle() + " by " + getAuthor();
		}
	}
	
	private static class Patron
	{
		private String name;
		private Map<String, Book> books;
		
		public Patron(String name)
		{
			this.name = name;
			books = new HashMap<>();
		}
		
		public String getName()
		{
			return name;
		}
		
		public boolean hasBook(String title)
		{
			return books.containsKey(title);
		}
		
		public Book returnBook(String title)
		{
			return books.remove(title);
		}
		
		public boolean borrowBook(Book book)
		{
			if(books.size() >= 3)
				return false;
			return books.put(book.title, book)==null;
		}
		
		public String toString()
		{
			return getName() + "\t" + books;
		}
	}
}
