package problems;

public class Adding2NumbersList
{
	static int carry = 0;

	private static void padZeros(MyLinkedList<Integer> l, int len)
	{
		for (int i = 0; i < len; i++)
			l.insertAtStart(0);
	}

	private static MyLinkedList<Integer> addLists(MyLinkedList<Integer> l1, MyLinkedList<Integer> l2)
	{
		if (l1 == null && l2 == null)
			return null;

		if (l1 == null || l1.getHead() == null)
			return l2;

		if (l2 == null || l2.getHead() == null)
			return l1;

		int len1 = l1.length();
		int len2 = l2.length();

		if (len1 > len2)
			padZeros(l2, len1 - len2);
		else
			padZeros(l1, len2 - len1);

		l1.printList();
		l2.printList();
		MyLinkedList<Integer> l3 = new MyLinkedList<Integer>();
		l3.setHead(addLists(l1.getHead(), l2.getHead()));

		if (carry > 0)
		{
			l3.insertAtStart(carry);
			carry = 0;
		}

		return l3;
	}

	private static ListNode<Integer> addLists(ListNode<Integer> t1, ListNode<Integer> t2)
	{
		if (t1 == null && t2 == null)
			return null;

		ListNode<Integer> t = addLists(t1.next, t2.next);
		int sum = t1.data + t2.data + carry;
		ListNode<Integer> t3 = new ListNode<Integer>(sum % 10);
		carry = sum / 10;
		t3.next = t;

		return t3;
	}

	public static void main(String[] args)
	{
		MyLinkedList<Integer> l1 = new MyLinkedList<Integer>();
		l1.insertAtEnd(7);
		l1.insertAtEnd(1);
		l1.insertAtEnd(6);
		l1.insertAtEnd(6);

		// l1.printList();
		// l1.setHead(l1.reverseList(l1.getHead()));
		// l1.printList();

		MyLinkedList<Integer> l2 = new MyLinkedList<Integer>();
		l2.insertAtEnd(5);
		l2.insertAtEnd(9);
		l2.insertAtEnd(5);

		MyLinkedList<Integer> l3 = addLists(l1, l2);
		if (l3 != null)
			l3.printList();
	}

}
