package dataStructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>
{
	public void insert(T data)
	{
		SearchTreeNode<T> newNode = new SearchTreeNode<>(data);
		if(root == null)
			root = newNode;
		else
			root.add(newNode);
	}
	
	/**
	 * Checks if a value is inside this tree.
	 * 
	 * @param data The data to look for.
	 * @return true if the data is in here, false if it is not
	 */
	public boolean search(T data)
	{
		if(root == null)
			return false;
		return ((SearchTreeNode<T>) root).contains(data);
	}
	
	/**
	 * Removes a {@link SearchTreeNode} from this tree. If it has one child, the child replaces it. If it has two children, it is
	 * replaced by its inorder successor.
	 * 
	 * @param data The data to be removed from the Tree. If it is not found, nothing happens.
	 * 
	 * @see #getInorderSuccessor(SearchTreeNode)
	 * @see SearchTreeNode#getInorderSuccessor(SearchTreeNode)
	 * @see SearchTreeNode#getMinimumNode()
	 */
	public void remove(T data)
	{
		if(!search(data))
			throw new NoSuchElementException();
		
		SearchTreeNode<T> node = ((SearchTreeNode<T>) root).find(data);
		SearchTreeNode<T> parent = ((SearchTreeNode<T>) root).findParent(node);
		boolean left = parent.getLeft() == node;
		
		int children = 0;
		if(node.getLeft() != null)
			children++;
		if(node.getRight() != null)
			children++;
		
		switch(children)
		{
			case 0:
				if(left)
					parent.setLeft(null);
				else
					parent.setRight(null);
				break;
			case 1:
				TreeNode<T> next = (node.getLeft() == null ? node.getRight() : node.getLeft());
				if(left)
					parent.setLeft(next);
				else
					parent.setRight(next);
				break;
			case 2:
				// All 3 of these methods do the same thing, but I'm pretty sure this one is the most efficient
				SearchTreeNode<T> successor = ((SearchTreeNode<T>) node.getRight()).getMinimumNode();
//				SearchTreeNode<T> successor = getInorderSuccessor(node);
//				SearchTreeNode<T> successor = ((SearchTreeNode<T>) root).getInorderSuccessor(node);
				SearchTreeNode<T> sParent = ((SearchTreeNode<T>) root).findParent(successor);
				
				if(node.getLeft() != successor)
					successor.setLeft(node.getLeft());
				if(node.getRight() != successor)
					successor.setLeft(node.getRight());
				
				if(sParent.getLeft() == successor)
					sParent.setLeft(null);
				else
					sParent.setRight(null);
				
				if(left)
					parent.setLeft(successor);
				else
					parent.setRight(successor);
				break;
		}
	}
	
	/**
	 * Checks the validity of this BinarySearchTree. The tree is valid if every left node is less than or equal to its parent, and
	 * every right node is greater than its parent.
	 * 
	 * @return Whether or not the tree is valid
	 */
	public boolean isValid()
	{
		return root == null || ((SearchTreeNode<T>) root).isValid();
	}
	
	/**
	 * Finds the inorder successor of a {@link SearchTreeNode} in this tree by doing an inorder traversal.
	 * 
	 * @param node The node to find the successor of, cannot be null
	 * @return The inorder successor of the node
	 */
	public SearchTreeNode<T> getInorderSuccessor(SearchTreeNode<T> node)
	{
		LinkedListQueue<SearchTreeNode<T>> q = new LinkedListQueue<>();
		root.visitInorder(current -> q.enqueue((SearchTreeNode<T>) current));
		try
		{
			boolean found = false;
			while(true)
			{
				if(found)
					return q.dequeue();
				if(q.dequeue() == node)
					found = true;
			}
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
	
	public static <T extends Comparable<T>> BinarySearchTree<T> convert(T[] arr)
	{
		if(!isSorted(arr))
			throw new IllegalArgumentException();
		
		BinarySearchTree<T> tree = new BinarySearchTree<>();
		
		if(arr.length > 0)
		{
			int mid = arr.length/2;
			tree.root = new SearchTreeNode<T>(arr[mid]);
			T[] left = Arrays.copyOfRange(arr, 0, mid);
			T[] right = Arrays.copyOfRange(arr, mid+1, arr.length);
			BinarySearchTree<T> lTree = convert(left);
			BinarySearchTree<T> rTree = convert(right);
			tree.root.setLeft(lTree.root);
			tree.root.setRight(rTree.root);
		}
		
		return tree;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> BinarySearchTree<T> convert(LinkedList<T> list)
	{
		return convert((T[]) list.toArray());
	}
	
	public static <T extends Comparable<T>> BinarySearchTree<T> convert(BinaryTree<T> tree)
	{
		LinkedListQueue<T> q = new LinkedListQueue<>();
		tree.root.visitInorder(node -> q.enqueue(node.getData()));
		LinkedList<T> list = new LinkedList<>();
		while(true)
		{
			try
			{
				list.add(q.dequeue());
			}
			catch(NoSuchElementException e)
			{
				break;
			}
		}
		
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) list.toArray();
		sort(arr);
		return convert(arr);
	}
	
	public static <T extends Comparable<T>> void sort(T[] arr)
	{
		sort(arr, 0, arr.length);
	}
	
	private static <T extends Comparable<T>> void sort(T[] arr, int start, int end)
	{
		if(end-start < 2)
			return;
		
		int mid = (start+end)/2;
		T[] temp = Arrays.copyOf(arr, end-start);
		int i = 0, j = end-start;
		for(int index = start; index < end; index++)
		{
			if(arr[index].compareTo(arr[mid]) < 0)
				temp[i++] = arr[index];
			else
				temp[--j] = arr[index];
		}
		
		for(int index=0; index<temp.length; index++)
		{
			arr[start + index] = temp[index];
		}
		
		sort(arr, start, mid);
		sort(arr, mid, end);
	}
	
	private static <T extends Comparable<T>> boolean isSorted(T[] arr)
	{
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i].compareTo(arr[i-1]) < 0)
				return false;
		}
		return true;
	}
}
