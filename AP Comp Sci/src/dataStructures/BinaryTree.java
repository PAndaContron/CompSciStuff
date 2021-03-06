package dataStructures;

import java.util.NoSuchElementException;

public class BinaryTree<T>
{
	protected TreeNode<T> root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	public int height()
	{
		if(root == null)
			return 0;
		return root.depth();
	}
	
	public void printInorder()
	{
		if(root != null)
			root.visitInorder(e -> System.out.print(e));
		System.out.println();
	}

	public void printPreorder()
	{
		if(root != null)
			root.visitPreorder(e -> System.out.print(e));
		System.out.println();
	}

	public void printPostorder()
	{
		if(root != null)
			root.visitPostorder(e -> System.out.print(e));
		System.out.println();
	}
	
	public void printBreadthFirst()
	{
		int height = height();
		for(int i=0; i<height; i++)
		{
			printGivenLevel(i);
		}
		System.out.println();
	}
	
	public void printGivenLevel(int level)
	{
		root.visitLevelDown(level, e->System.out.print(e));
	}
	
	public void printBreadthFirstQ()
	{
		if(root != null)
		{
			LinkedListQueue<TreeNode<T>> queue = new LinkedListQueue<>();
			queue.enqueue(root);
			
			try
			{
				while(true)
				{
					TreeNode<T> current = queue.dequeue();
					System.out.print(current);
					
					if(current.getLeft() != null)
						queue.enqueue(current.getLeft());
					if(current.getRight() != null)
						queue.enqueue(current.getRight());
				}
			}
			catch(NoSuchElementException e) {}
		}
		System.out.println();
	}
	
	public void insert(T data)
	{
		TreeNode<T> newNode = new TreeNode<>(data);
		
		if(root == null)
		{
			root = newNode;
			return;
		}
		
		int height = height();
		try
		{
			for(int i=0; i<height; i++)
			{			
				root.visitLevelDown(i, node ->
				{
					if(node.add(newNode))
						throw new IllegalStateException();
				});
			}
		}
		catch(IllegalStateException e) {}
	}
}
