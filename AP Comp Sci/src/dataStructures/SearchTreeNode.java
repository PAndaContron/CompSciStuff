package dataStructures;

public class SearchTreeNode<T extends Comparable<T>> extends TreeNode<T>
{
	public SearchTreeNode()
	{
		this(null);
	}
	
	public SearchTreeNode(T data)
	{
		super(data);
	}
	
	public boolean add(TreeNode<T> newNode)
	{
		if(newNode.getData().compareTo(getData()) > 0)
		{
			if(getRight() == null)
				setRight(newNode);
			else
				getRight().add(newNode);
		}
		else
		{
			if(getLeft() == null)
				setLeft(newNode);
			else
				getLeft().add(newNode);
		}
		
		return true;
	}
	
	public SearchTreeNode<T> findParent(SearchTreeNode<T> node)
	{
		if(getLeft() != null && getLeft() == node)
			return this;
		if(getRight() != null && getRight() == node)
			return this;
		if(getRight() != null && node.getData().compareTo(getData()) > 0)
			return ((SearchTreeNode<T>) getRight()).findParent(node);
		else if(getLeft() != null)
			return ((SearchTreeNode<T>) getLeft()).findParent(node);
		return null;
	}

	public SearchTreeNode<T> find(T data)
	{
		if(data.compareTo(getData()) == 0)
			return this;
		if(getRight() != null && data.compareTo(getData()) > 0)
			return ((SearchTreeNode<T>) getRight()).find(data);
		else if(getLeft() != null)
			return ((SearchTreeNode<T>) getLeft()).find(data);
		return null;
	}
	
	public boolean contains(T data)
	{
		return find(data) != null;
	}
	
	public SearchTreeNode<T> getInorderSuccessor(SearchTreeNode<T> node)
	{
		if(getRight() != null)
			return ((SearchTreeNode<T>) node.getRight()).getMinimumNode();
		
		SearchTreeNode<T> successor = null, temp = this;
		while(temp != null)
		{
			if(node.getData().compareTo(temp.getData()) < 0)
			{
				successor = temp;
				temp = (SearchTreeNode<T>) temp.getLeft();
			}
			else if(node.getData().compareTo(temp.getData()) > 0)
				temp = (SearchTreeNode<T>) temp.getRight();
			else
				break;
		}
		
		return successor;
	}
	
	public SearchTreeNode<T> getMinimumNode()
	{
		if(getLeft() != null)
			return ((SearchTreeNode<T>) getLeft()).getMinimumNode();
		return this;
	}
	
	public boolean isValid()
	{
		if(getLeft() != null && getLeft().getData().compareTo(getData()) > 0)
			return false;
		if(getRight() != null && getRight().getData().compareTo(getData()) <= 0)
			return false;
		
		boolean valid = true;
		if(getLeft() != null)
			valid = valid && ((SearchTreeNode<T>) getLeft()).isValid();
		if(getRight() != null)
			valid = valid && ((SearchTreeNode<T>) getRight()).isValid();
		
		return valid;
	}
}
