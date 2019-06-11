package problems;

public class LinkedListToBST
{
	static TreeNode convertSLLtoBST(MyLinkedList<Integer> list)
	{
		if (list.head == null)
			return null;

		return recurSLLtoBST(list, 0, list.length() - 1);
		// return recurSLLtoBST(list, list.length());

	}

	static TreeNode recurSLLtoBST(MyLinkedList<Integer> list, int low, int high)
	{
		if (low > high)
			return null;

		int mid = (low + high) / 2;
		TreeNode left = recurSLLtoBST(list, low, mid - 1);
		TreeNode root = new TreeNode(list.head.data);
		root.left = left;
		list.head = list.head.next;
		root.right = recurSLLtoBST(list, mid + 1, high);
		return root;
	}

	public static void main(String[] args)
	{
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		list.insertAtEnd(8);
		list.printList();

		TreeNode root = convertSLLtoBST(list);
		BinaryTree.printInOrder(root);
	}

}
