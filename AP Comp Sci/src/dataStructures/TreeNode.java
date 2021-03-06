package dataStructures;

import java.util.function.Consumer;

public class TreeNode<T>
{
	private T data;
	private TreeNode<T> left, right;
	
	public TreeNode()
	{
		this(null);
	}
	
	public TreeNode(T data)
	{
		this.data = data;
	}
	
	public T getData()
	{
		return data;
	}
	
	public TreeNode<T> getLeft()
	{
		return left;
	}
	
	public TreeNode<T> getRight()
	{
		return right;
	}
	
	public void setLeft(TreeNode<T> left)
	{
		this.left = left;
	}
	
	public void setRight(TreeNode<T> right)
	{
		this.right = right;
	}
	
	public void visitInorder(Consumer<TreeNode<T>> action)
	{
		if(left != null)
			left.visitInorder(action);
		action.accept(this);
		if(right != null)
			right.visitInorder(action);
	}

	public void visitPreorder(Consumer<TreeNode<T>> action)
	{
		action.accept(this);
		if(left != null)
			left.visitPreorder(action);
		if(right != null)
			right.visitPreorder(action);
	}
	
	public void visitPostorder(Consumer<TreeNode<T>> action)
	{
		if(left != null)
			left.visitPostorder(action);
		if(right != null)
			right.visitPostorder(action);
		action.accept(this);
	}
	
	public int depth()
	{
		int i = 0, j = 0;
		if(left != null)
			i = left.depth();
		if(right != null)
			j = right.depth();
		
		return Math.max(i, j) + 1;
	}
	
	public boolean add(TreeNode<T> newNode)
	{
		if(left == null)
		{
			left = newNode;
			return true;
		}
		
		if(right == null)
		{
			right = newNode;
			return true;
		}
		
		return false;
	}
	
	public void visitLevelDown(int level, Consumer<TreeNode<T>> action)
	{
		if(level == 0)
		{
			action.accept(this);
		}
		else
		{
			if(left != null)
				left.visitLevelDown(level-1, action);
			if(right != null)
				right.visitLevelDown(level-1, action);
		}
	}
	
	public String toString()
	{
		return data.toString();
	}
}
