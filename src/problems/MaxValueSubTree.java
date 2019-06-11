package problems;

public class MaxValueSubTree
{
	static void decorateTree(TreeNode root)
	{
		if (root == null)
			return;

		decorateTree(root.left);
		decorateTree(root.right);

		if (root.left != null)
			root.data = Math.max(root.data, root.left.data);
		if (root.right != null)
			root.data = Math.max(root.data, root.right.data);
	}

	public static void main(String[] args)
	{
		BinaryTree tree = new BST();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 14);
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 16);
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 5);
		System.out.println();
		decorateTree(tree.root);
	}
}
