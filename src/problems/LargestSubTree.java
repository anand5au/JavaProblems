package problems;

import java.util.LinkedList;
import java.util.Queue;

public class LargestSubTree
{
	static int getLeftMostChild(TreeNode root)
	{
		TreeNode temp = root;
		while (temp.left != null)
			temp = temp.left;
		return temp.data;
	}

	static int getRightMostChild(TreeNode root)
	{
		TreeNode temp = root;
		while (temp.right != null)
			temp = temp.right;
		return temp.data;
	}

	static TreeNode getLargeRoot(TreeNode root, int i, int j)
	{
		if (root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty())
		{
			TreeNode curr = q.poll();
			if (curr.data >= i && curr.data <= j)
			{
				int lMost = getLeftMostChild(curr);
				int rMost = getRightMostChild(curr);
				if (lMost >= i && rMost <= j)
					return curr;
			}
			if (curr.left != null)
				q.offer(curr.left);
			if (curr.right != null)
				q.offer(curr.right);
		}
		return null;
	}

	public static void main(String[] args)
	{
		BinaryTree tree = new BST();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 14);
		tree.root = tree.insert(tree.root, 16);
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 7);

		TreeNode largeRoot = getLargeRoot(tree.root, 5, 6);
		if (largeRoot != null)
			System.out.println(largeRoot.data);
		else
			System.out.println("No such tree is possible...");
	}
}
