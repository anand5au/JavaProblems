package problems;

public class BST extends BinaryTree
{
	public BST()
	{
		root = null;
	}

	@Override
	public TreeNode find(TreeNode root, int d)
	{
		if (root == null)
			return null;

		while (root != null)
		{
			if (root.data == d)
				return root;

			if (d < root.data)
				root = root.left;
			else
				root = root.right;
		}

		return null;
	}

	@Override
	public TreeNode insert(TreeNode root, int d)
	{
		if (root == null)
			return new TreeNode(d);

		if (d < root.data)
			root.left = insert(root.left, d);

		else
			root.right = insert(root.right, d);

		return root;
	}

	private int minVal(TreeNode root)
	{
		TreeNode node = root;
		while (node.left != null)
			node = node.left;
		return node.data;
	}

	public TreeNode deleteNode(TreeNode root, int key)
	{
		if (root == null)
			return null;

		if (root.data > key)
			root.left = deleteNode(root.left, key);
		else if (root.data < key)
			root.right = deleteNode(root.right, key);
		else
		{
			if (root.right == null)
				return root.left;
			else if (root.left == null)
				return root.right;

			root.data = minVal(root.right);
			root.right = deleteNode(root.right, root.data);
		}
		return root;
	}

	@Override
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		if (root == null || p == null || q == null)
			return null;

		if (root.data < p.data && root.data < q.data)
			return lowestCommonAncestor(root.right, p, q);
		if (root.data > p.data && root.data > q.data)
			return lowestCommonAncestor(root.left, p, q);
		return root;
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

		TreeNode temp = tree.find(tree.root, 9);
		System.out.println("temp: " + ((temp == null) ? "null" : temp.data));

		System.out.println(tree.inOrderSuccessor(tree.root, temp).data);

		System.out.println(tree.BFS(tree.root, 7));

		System.out.println(tree.DFS(tree.root, 7));

		System.out.println(tree.isBST(tree.root));

	}
}
