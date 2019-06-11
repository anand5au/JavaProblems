package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class NaryTreeNode<T>
{
	T data;
	NaryTreeNode<T> firstChild;
	NaryTreeNode<T> nextSibling;

	public NaryTreeNode(T d)
	{
		data = d;
		firstChild = null;
		nextSibling = null;
	}
}

public class NaryTree<T>
{
	NaryTreeNode<T> root;

	public NaryTree()
	{
		root = null;
	}

	public NaryTreeNode<T> insert(NaryTreeNode<T> root, T parent, T d)
	{
		NaryTreeNode<T> newNode = new NaryTreeNode<T>(d);
		if (root == null)
		{
			root = newNode;
			return root;
		}

		NaryTreeNode<T> temp = findNode(root, parent);

		if (temp == null)
		{
			newNode.nextSibling = root.nextSibling;
			root.nextSibling = newNode;
		}
		else if (temp.firstChild != null)
		{
			newNode.nextSibling = temp.firstChild.nextSibling;
			temp.firstChild.nextSibling = newNode;
		}
		else
		{
			temp.firstChild = newNode;
		}

		return root;
	}

	public NaryTreeNode<T> findNode(NaryTreeNode<T> root, T d)
	{
		if (root == null)
			return null;

		if (root.data == d)
			return root;

		NaryTreeNode<T> temp = findNode(root.firstChild, d);

		if (temp == null)
		{
			temp = root.nextSibling;
			while (temp != null)
			{
				if (temp.data == d)
					break;

				NaryTreeNode<T> t = findNode(temp.firstChild, d);
				if (t != null)
				{
					temp = t;
					break;
				}

				temp = temp.nextSibling;
			}
		}

		return temp;
	}

	public void printTree(NaryTreeNode<T> root)
	{
		if (root == null)
			return;

		System.out.print(root.data + " ");

		NaryTreeNode<T> temp = root.nextSibling;
		while (temp != null)
		{
			System.out.print(temp.data + " ");
			printTree(temp.firstChild);
			temp = temp.nextSibling;
		}
		System.out.println();
		printTree(root.firstChild);
	}

	public void printSiblings(T d)
	{
		if (root == null)
			return;

		Queue<NaryTreeNode<T>> q = new LinkedList<NaryTreeNode<T>>();
		Set<T> level = new HashSet<T>();
		int currLevel = 0, nextLevel = 0;
		NaryTreeNode<T> temp = root;
		while (temp != null)
		{
			q.offer(temp);
			currLevel++;
			level.add(temp.data);
			temp = temp.nextSibling;
		}

		if (level.contains(d))
		{
			System.out.println(level);
			return;
		}

		level.clear();
		while (!q.isEmpty())
		{
			temp = q.poll();
			currLevel--;
			if (temp.firstChild != null)
			{
				q.offer(temp.firstChild);
				nextLevel++;
				level.add(temp.firstChild.data);
				temp = temp.firstChild;
				while (temp.nextSibling != null)
				{
					q.offer(temp.nextSibling);
					nextLevel++;
					level.add(temp.nextSibling.data);
					temp = temp.nextSibling;
				}
			}
			if (currLevel == 0)
			{
				currLevel = nextLevel;
				nextLevel = 0;
				if (level.contains(d))
				{
					System.out.println(level);
					return;
				}
				level.clear();
				System.out.println();
			}
		}

	}

	public static void main(String[] args)
	{
		NaryTree<String> ftree = new NaryTree<String>();

		ftree.root = ftree.insert(ftree.root, "", "adam");
		ftree.root = ftree.insert(ftree.root, "adam", "sam");
		ftree.root = ftree.insert(ftree.root, "adam", "watson");
		ftree.root = ftree.insert(ftree.root, "sam", "bob");
		ftree.root = ftree.insert(ftree.root, "sam", "jon");
		ftree.root = ftree.insert(ftree.root, "sam", "ruby");
		ftree.root = ftree.insert(ftree.root, "watson", "roger");

		ftree.printTree(ftree.root);
		ftree.printSiblings("bob");
	}
}
