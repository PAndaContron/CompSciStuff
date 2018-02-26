//***********************************************************************************
//  Rajat Patel
//  Array List
//  11/3/2017
//  A copy of Java ArrayList
//***********************************************************************************

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class MyArrayList<E> implements Iterable<E>
{
	private E[] theData;
	private int capacity = 0;
	private int size = 0;
	
	private final int INIT_CAPACITY = 10;
	
	public MyArrayList(int initCapacity)
	{
		theData = (E[])new Object[initCapacity];
		capacity = initCapacity;
	}
	
	public MyArrayList()
	{
		theData = (E[])new Object[INIT_CAPACITY];
		capacity = INIT_CAPACITY;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public Iterator<E> iterator()
	{
		return new GenericIterator();
	}
	
	public Stream<E> stream()
	{
		return Stream.of(toArray());
	}
	
	public E[] toArray()
	{
		return Arrays.copyOf(theData,size);
	}
	
	public E get(int index)
	{
		if(index>=size||index<0)
			throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
		return theData[index];
	}
	
	public boolean add(E e)
	{
		if(e==null)
			throw new NullPointerException();
		if(size==capacity)
			reallocate();
		theData[size] = e;
		size++;
		return true;
	}
	
	public void add(int i, E e)
	{
		if(e==null)
			throw new NullPointerException();
		if(i>size || i<0)
			throw new IndexOutOfBoundsException("Index: "+i+" Size: "+size);
		if(size==capacity)
			reallocate();
		for(int j=size;j>i;j--)
			theData[j] = theData[j-1];
		theData[i] = e;
	}
	
	public boolean addFirst(E e)
	{
		add(0,e);
		return true;
	}
	
	public boolean addAll(Collection<E> eList)
	{
		for(E e : eList)
			add(e);
		return true;
	}
	
	public E remove()
	{
		size--;
		E result = theData[size];
		theData[size]=null;
		return result;
	}
	
	public E remove(int i)
	{
		if(i>=size || i<0)
			throw new IndexOutOfBoundsException("Index: "+i+" Size: "+size);
		size--;
		E result = theData[i];
		for(int j=i;j<size;j++)
			theData[j] = theData[j+1];
		theData[size] = null;
		return result;
	}
	
	public boolean remove(E e)
	{
		if(e==null)
			throw new NullPointerException();
		if(!contains(e))
			return false;
		remove(indexOf(e));
		return true;
	}
	
	public boolean removeAll(Collection<E> eList)
	{
		boolean output = false;
		for(E e : eList)
			if(remove(e))
				output = true;
		return output;
	}
	
	public void clear()
	{
		theData = (E[]) new Object[capacity];
		size=0;
	}
	
	public E set(int index,E e)
	{
		if(e==null)
			throw new NullPointerException();
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
		E result = theData[index];
		theData[index] = e;
		return result;
	}
	
	public boolean contains(E e)
	{
		for(int i=0;i<size;i++)
			if(theData[i].equals(e))
				return true;
		return false;
	}
	
	public boolean containsAll(Collection<E> eList)
	{
		return stream().allMatch(e -> contains(e));
	}
	
	public int indexOf(E e)
	{
		if(e==null)
			throw new NullPointerException();
		for(int i=0;i<size;i++)
			if(theData[i].equals(e))
				return i;
		return -1;
	}
	
	public int lastIndexOf(E e)
	{
		if(e==null)
			throw new NullPointerException();
		for(int i=size-1;i>=0;i--)
			if(theData[i].equals(e))
				return i;
		return -1;
	}
	
	public int size()
	{
		return size;
	}
	
	public void print()
	{
		System.out.println(this);
	}
	
	public void ensureCapacity(int minCapacity)
	{
		while(capacity < minCapacity)
			reallocate();
	}
	
	public ListIterator<E> listIterator()
	{
		return new GenericListIterator();
	}
	
	public MyArrayList<E> clone()
	{
		MyArrayList<E> newList = new MyArrayList<E>(capacity);
		for(int i=0;i<size;i++)
			newList.add(theData[i]);
		return newList;
	}
	
	public String toString()
	{
		return Arrays.toString(toArray());
	}
	
	public boolean equals(Object o)
	{
		if(o.getClass()!=this.getClass())
			throw new IllegalArgumentException();
		return Arrays.equals(toArray(),((MyArrayList<E>)o).toArray());
	}
	
	public int hashCode()
	{
		int hashCode = 1;
	    for (E e : this)
	    	hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
	    return hashCode;
	}

	private void reallocate()
	{
		System.out.println("Running \"reallocate\"");
		capacity *= 2;
		E[] newData = (E[])new Object[capacity];
		for(int i=0;i<size;i++)
			newData[i] = theData[i];
		theData = newData;
	}
	
	private class GenericIterator implements Iterator<E>
	{
		protected int current=-1;
		
		public boolean hasNext()
		{
			return current<size-1;
		}
		
		public E next()
		{
			if(!hasNext())
				throw new NoSuchElementException();
			return theData[++current];
		}
	}
	
	private class GenericListIterator extends GenericIterator implements ListIterator<E>
	{
		MyArrayList<E> containedList = new MyArrayList<E>();
		private byte state = 0;
		private boolean added = false;
		
		public GenericListIterator()
		{
			for(E e : theData)
				containedList.add(e);
		}
		
		public boolean hasNext()
		{
			return current<size-1;
		}
		
		public E next()
		{
			if(!hasNext())
				throw new NoSuchElementException();
			state = 1;
			return containedList.get(++current);
		}

		public void add(E e) 
		{
			if(containedList.size()==0)
			{
				containedList.add(e);
				return;
			}
			
		}

		public boolean hasPrevious() 
		{
			return current>=0;
		}

		public int nextIndex() 
		{
			return current+1;
		}

		public E previous() 
		{
			if(!hasPrevious())
				throw new NoSuchElementException();
			state = -1;
			return containedList.get(current--);
		}

		public int previousIndex() 
		{
			return current;
		}

		public void remove() 
		{
			switch(state)
			{
				case -1:
					state = 0;
					containedList.remove(current+1);
					break;
				case 1:
					state = 0;
					containedList.remove(current);
					break;
				default:
					throw new IllegalStateException();
			}
		}

		public void set(E e) 
		{
			switch(state)
			{
				case -1:
					state = 0;
					containedList.set(current+1,e);
					break;
				case 1:
					state = 0;
					containedList.set(current,e);
					break;
				default:
					throw new IllegalStateException();
			}
		}
		
	}
}
